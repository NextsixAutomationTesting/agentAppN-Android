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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.time.Duration as Duration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.TouchAction as TouchAction
import io.appium.java_client.touch.offset.PointOption as PointOption
import io.appium.java_client.touch.WaitOptions as WaitOptions
import java.util.concurrent.TimeUnit as TimeUnit

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

Mobile.scrollToText('Get My Referrals')

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Get My Referrals'), 0)

LocalDateTime nowMyt = LocalDateTime.now()
LocalDateTime comTime = nowMyt.plusDays(14).withHour(0)
DateTimeFormatter dateForm = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')

String comDate = comTime.format(dateForm)
String enqNote = 'This enquiry is created at: ' + nowMyt

WS.sendRequest(findTestObject('16 HomePro/newEnquiry', [('comDate') : comDate, ('enqNote') : enqNote]))

def latestEnquiry = WS.sendRequest(findTestObject('16 HomePro/latestEnquiry'))
def slurper = new JsonSlurper()
def result = slurper.parseText(latestEnquiry.getResponseBodyContent())
String enquiryId = result.documents[0]._id

def referAmount = RandomStringUtils.randomNumeric(4)
WS.sendRequest(findTestObject('16 HomePro/completeEnquiry', [('enquiryId') : enquiryId, ('referAmount') : referAmount]))

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - My Referral'), 0)

Mobile.delay(1)
Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Completed'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(970,580)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - preview attach'), 0)

Mobile.verifyElementVisible(findTestObject('16 HomePro/android.widget.TextView - view pdf'), 10)

Mobile.pressBack()

Mobile.delay(1)
Mobile.tapAtPosition(970,580)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - download attach'), 0)

if (Mobile.verifyElementVisible(findTestObject('13 Academy/android.widget.Button - Download again'), 2, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('13 Academy/android.widget.Button - Download again'), 0)
}

Mobile.delay(5)
Mobile.tapAtPosition(850,2350)

Mobile.delay(1)
Mobile.tapAtPosition(850,2350)

def nowTime = new Date()

println(nowTime)

//Get list of files in Download (Device Internal Storage)in descending order
String adbCommand = 'adb shell ls -lt /sdcard/Download'

Process process = Runtime.getRuntime().exec(adbCommand)

process.waitFor(5, TimeUnit.SECONDS)

def output = process.inputStream.text

//Tokenize the list and get the first file (latest downloaded file)
List<String> lines = output.tokenize('\n')

String[] tokens = (lines[1]).tokenize()

//Get downloadTime and fileType from the latest file
String downloadTime = (tokens[(5..6)]).join(' ')

println(downloadTime)

String fileName = tokens[-1]

def fileType = fileName.tokenize('.')[-1]

//Get difference within downloadTime and currentTime
def dateFormat = new SimpleDateFormat('yyyy-MM-dd HH:mm')

def downloadTimeFormat = dateFormat.parse(downloadTime)

def differenceTime = (nowTime.time - downloadTimeFormat.time) / 1000

println(differenceTime)

//Assert differenceTime is within 3 min and fileType is pdf
assert differenceTime < 180

assert fileType == 'pdf'

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back referral'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back home'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:])

