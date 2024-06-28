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

Mobile.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

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

//Create new appointment - reject
WS.sendRequest(findTestObject('EAS/10 Appointment/Create Appointment', [('date') : date, ('slot') : slot]))

//Get appointmentID
appointmentID = WS.sendRequest(findTestObject('EAS/10 Appointment/latest appointment ID'))

def sluper = new groovy.json.JsonSlurper()

def result = sluper.parseText(appointmentID.getResponseBodyContent())

def appID = result.documents[0]._id

Mobile.callTestCase(findTestCase('Login - TRR (Wilson)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(1)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Request'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(750,1100)

Mobile.setText(findTestObject('EAS/10 Appointment/android.widget.EditText - Leave your reason here'), 'Test', 0)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Reject (1)'), 0)

Mobile.tap(findTestObject('EAS/10 Appointment/android.widget.TextView - Rejected by Agent'), 0)

//Check appointment status in DB by appointmentID
appointmentDetails = WS.sendRequest(findTestObject('EAS/10 Appointment/appointment details', [('appID') : appID]))

def sluper1 = new JsonSlurper()

def result1 = sluper1.parseText(appointmentDetails.getResponseBodyContent())

def stat = result1.status

///println(stat)
assert stat == 'Rejected'

Mobile.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

