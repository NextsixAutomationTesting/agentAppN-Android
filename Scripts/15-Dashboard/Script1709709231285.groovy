import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import groovy.json.JsonSlurper as JsonSlurper

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

packageName = Mobile.getText(findTestObject('Object Repository/15 Dashboard/android.widget.TextView - Package'), 0)

expiryDate = Mobile.getText(findTestObject('Object Repository/15 Dashboard/android.widget.TextView - Expiry'), 0)

Mobile.tap(findTestObject('15 Dashboard/android.widget.TextView - Listing'), 0)

totalProp = Mobile.getText(findTestObject('Object Repository/15 Dashboard/android.widget.TextView - Active Total'), 0)

saleProp = Mobile.getText(findTestObject('Object Repository/15 Dashboard/android.widget.TextView - Active Sale'), 0)

rentProp = Mobile.getText(findTestObject('Object Repository/15 Dashboard/android.widget.TextView - Active Rent'), 0)

dashboardBDS = Mobile.getText(findTestObject('Object Repository/15 Dashboard/android.widget.TextView - Best Deal'), 0)

Mobile.tap(findTestObject('15 Dashboard/android.widget.TextView - Plotting'), 0)

plotAddress = Mobile.getText(findTestObject('Object Repository/15 Dashboard/android.widget.TextView - Plotted Address'), 0)

//get agent details DB (package id, raw expiry date, plotted address)
agentDetails = WS.sendRequest(findTestObject('15 Dashboard/agentDetails'))
def sluper = new JsonSlurper()
def result = sluper.parseText(agentDetails.getResponseBodyContent())
String expDB = result.expiryDate
String plotAdd = result.plottedAddress

//convert DB expiry date into formatted date & time
def dateDBformat = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')
dateDBformat.setLenient(false)
def expDBformat = dateDBformat.parse(expDB)
SimpleDateFormat expFormat = new SimpleDateFormat('dd MMM yyyy')
formatDBDate = expFormat.format(expDBformat)

//convert App expiry date into formatted date & time
String pattern = '\'Expired on\' dd MMM yyyy'
SimpleDateFormat sdf = new SimpleDateFormat(pattern)
sdf.setLenient(false)
Date date = sdf.parse(expiryDate)
expAppDate = expFormat.format(date)

//get package name by using package id from agent details DB
agentPack = WS.sendRequest(findTestObject('15 Dashboard/agentPack'))
def result1 = sluper.parseText(agentPack.getResponseBodyContent())
String packName = result1.name

//get agent property listings amount
propListed = WS.sendRequest(findTestObject('15 Dashboard/propListed'))
result2 = sluper.parseText(propListed.getResponseBodyContent())

def rentList
def saleList
def totalList

if ((result2.rent == null) && (result2.buy == null)) {
    rentList = 0

    saleList = 0

    totalList = 0
} else if ((result2.rent != null) && (result2.buy == null)) {
    rentList = result2.rent

    saleList = 0

    totalList = (rentList + saleList)
} else if ((result2.rent == null) && (result2.buy != null)) {
    rentList = 0

    saleList = result2.buy

    totalList = (rentList + saleList)
} else if ((result2.rent != null) && (result2.buy != null)) {
    rentList = result2.rent

    saleList = result2.buy

    totalList = (rentList + saleList)
}

agentBDS = WS.sendRequest(findTestObject('Object Repository/15 Dashboard/agentBDS'))
result3 = sluper.parseText(agentBDS.getResponseBodyContent())

def usedBDS = result3.documents[0].bestdeal.usedSlot
def totalBDS = result3.documents[0].bestdeal.totalSlot

//assert dashboard data & app data
assert packageName == packName

assert expAppDate == formatDBDate

assert totalProp == totalList.toString()

assert saleProp == saleList.toString()

assert rentProp == rentList.toString()

assert dashboardBDS == usedBDS+ '/' + totalBDS

assert plotAddress == plotAdd

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

