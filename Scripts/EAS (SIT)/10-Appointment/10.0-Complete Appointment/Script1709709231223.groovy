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

Mobile.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Login - TRR (Wilson)'), [:], FailureHandling.STOP_ON_FAILURE)

//Get the current date and time (GMT+8)
LocalDateTime nowMyt = LocalDateTime.now()

//set time to GMT timezone (-8hrs according to API)
LocalDateTime apiTime = nowMyt.minusHours(8)

///println(apiTime)
//add 1 hours for appointment time and round to 00 minutes
LocalDateTime appointTime = apiTime.plusHours(1)

int mins = apiTime.getMinute()

if ((mins > 0) && (mins < 30)) {
    appointTime = appointTime.withMinute(0)
} else if (mins > 30) {
    appointTime = appointTime.plusHours(1).withMinute(0)
}

///println(appointTime)
//Format according to API
DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')

String slot = apiTime.format(dateFormat)

String date = appointTime.format(dateFormat)

///println(slot)
///println(date)
//Create new appointment - accept
WS.sendRequest(findTestObject('EAS/10 Appointment/Create Appointment', [('date') : date, ('slot') : slot]))

//Get appointmentID
appointmentID = WS.sendRequest(findTestObject('EAS/10 Appointment/latest appointment ID'))

def sluper = new groovy.json.JsonSlurper()

def result = sluper.parseText(appointmentID.getResponseBodyContent())

def appID = result.documents[0]._id

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Request'), 0)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Accept'), 0)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Accept Appointment (1)'), 0)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Accepted'), 0)

//Check appointment status in DB by appointmentID
appointmentDetails = WS.sendRequest(findTestObject('EAS/10 Appointment/appointment details', [('appID') : appID]))

def sluper1 = new groovy.json.JsonSlurper()

def result1 = sluper1.parseText(appointmentDetails.getResponseBodyContent())

def stat = result1.status

///println(stat)
assert stat == 'Accepted'

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

String action = 'complete'

//set appointment-accepted as complete
WS.sendRequest(findTestObject('EAS/10 Appointment/Update appointment status', [('appID') : appID, ('action') : action]))

//create new appointment for 'Completed'
LocalDateTime nowMyt1 = LocalDateTime.now()

LocalDateTime apiTime1 = nowMyt1.minusHours(8)

LocalDateTime appointTime1 = apiTime1.plusSeconds(5)

String slot1 = apiTime1.format(dateFormat)

String date1 = appointTime1.format(dateFormat)

WS.sendRequest(findTestObject('EAS/10 Appointment/Create Appointment', [('date') : date1, ('slot') : slot1]))

//get appointmentID for appointment(complete)
appointmentID2 = WS.sendRequest(findTestObject('EAS/10 Appointment/latest appointment ID'))

def sluper2 = new groovy.json.JsonSlurper()

def result2 = sluper2.parseText(appointmentID2.getResponseBodyContent())

def appID2 = result2.documents[0]._id

//accept the appointment with API
String action1 = 'accept'

WS.sendRequest(findTestObject('EAS/10 Appointment/Update appointment status', [('appID') : appID2, ('action') : action1]))

//on app to complete the appointment
Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - New'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Accepted'), 0)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Complete'), 0)

Mobile.waitForElementPresent(findTestObject('EAS/10 Appointment/android.widget.TextView - Completed Confirm'), 0)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Completed Confirm'), 0)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Completed'), 0)

//Check appointment status in DB by appointmentID
appointmentDetails1 = WS.sendRequest(findTestObject('EAS/10 Appointment/appointment details', [('appID') : appID2]))

def sluper3 = new groovy.json.JsonSlurper()

def result3 = sluper3.parseText(appointmentDetails1.getResponseBodyContent())

def stat2 = result3.status

assert stat2 == 'Completed'

Mobile.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

