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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import java.util.regex.Pattern as Pattern
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject



Mobile.startApplication('C:\\Users\\Nextsix\\git\\agentTesterSDK49.apk', true)

Mobile.setText(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.EditText - UsernameEmail Address (1)'), 
    'mariael', 0)

Mobile.setText(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.EditText - Password (1)'), '123456', 
    0)

Mobile.tap(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView -'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Sign In'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Not Now'), 0)

// Get the current date and time
LocalDateTime currentDateTime = LocalDateTime.now()

// Define the desired format
DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'')

// Format the date and time
String createdDate = currentDateTime.format(formatter)

LocalDateTime updatedDateTime = currentDateTime.minusHours(8)

println(updatedDateTime)

// Add 30 minutes
LocalDateTime updatedDateTime2 = updatedDateTime.plusMinutes(30)

println(updatedDateTime2)

// Round up to the nearest 30 or 00
int minutes = updatedDateTime2.getMinute()

if ((minutes > 0) && (minutes < 30)) {
    updatedDateTime2 = updatedDateTime2.withMinute(30)
} else if (minutes > 30) {
    updatedDateTime2 = updatedDateTime2.plusHours(1).withMinute(0)
}

// Format the updated date and time
String firstAvailableSlot = updatedDateTime2.format(formatter)

def slot = updatedDateTime

def date = firstAvailableSlot

println(date)

println(slot)

'create new appointment'
createAppointment = WS.sendRequest(findTestObject('SDK44/5.1 Appointment (Reject)/create new appointment', [('date') : date, ('slot') : slot]))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(createAppointment.getResponseBodyContent())

'Get latest appointment'
appointmentID = WS.sendRequest(findTestObject('SDK44/5.1 Appointment (Reject)/latest appointment ID'))

def sluper1 = new groovy.json.JsonSlurper()

def result1 = sluper1.parseText(appointmentID.getResponseBodyContent())

def appID = result1.documents[0]._id

println(appID)

'get appointment details'
appointmentDetails = WS.sendRequest(findTestObject('SDK44/5.1 Appointment (Reject)/appointment details', [('status') : appID]))

def sluper2 = new groovy.json.JsonSlurper()

def result2 = sluper2.parseText(appointmentDetails.getResponseBodyContent())

def propertyName = result2.property.name

def propertyStatus = result2.status

def propertyArea = result2.property.address.area

def propertyState = result2.property.address.state

def userName = result2.user.name

def userMobile = result2.user.mobile

def userEmail = result2.user.email

def appDate2 = result2.date

def propertyLocation = (propertyArea + ', ') + propertyState

println(propertyName)

println(propertyStatus)

println(propertyLocation)

println(userName)

println(userMobile)

println(userEmail)

println(appDate2)

WebUI.delay(10)

'click request tab'
Mobile.tap(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.Button'), 0)

propName = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Avantas'), 
    0)

propName = propertyName

propLocation = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Kuchai Lama, Wilayah Persekutuan Kuala Lumpur'), 
    0)

propLocation = propertyLocation

propStatus = Mobile.verifyElementExist(findTestObject('SDK44/5.1 Appointment (Reject)/android.widget.TextView - New (2)'), 0)

propStatus = propertyStatus

propUsername = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Hazim Harith (1)'), 
    0)

propUsername = userName

propUserMobile = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - 60178454122 (1)'), 
    0)

propUserMobile = userMobile

propUserEmail = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - hazimharith93gmail.com (1)'), 
    0)

propUserEmail = userEmail

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Today (1)'), 
    0)

'click x button'
Mobile.tap(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - x'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Appointment'), 
    0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Reject'), 
    0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Reason'), 
    0)

Mobile.setText(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.EditText - Leave your reason here'), 
    'Not available at that time.', 0)

'click reject button'
Mobile.tap(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Reject (1)'), 0)

'Get latest appointment'
appointmentID1 = WS.sendRequest(findTestObject('SDK44/5.1 Appointment (Reject)/latest appointment ID'))

def sluper4 = new groovy.json.JsonSlurper()

def result4 = sluper4.parseText(appointmentID1.getResponseBodyContent())

def appID1 = result4.documents[0]._id

println(appID1)

'get appointment details REJECT'
appointmentDetails2 = WS.sendRequest(findTestObject('SDK44/5.1 Appointment (Reject)/appointment details', [('status') : appID1]))

def sluper3 = new groovy.json.JsonSlurper()

def result3 = sluper3.parseText(appointmentDetails2.getResponseBodyContent())

def propertyStatusReject = result3.status

def propertyReason = result3.reason

def propertyReject = result3.rejected

println(propertyStatusReject)

println(propertyReason)

println(propertyReject)

String originalTimestamp = propertyReject

SimpleDateFormat originalFormat = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')

SimpleDateFormat targetFormat = new SimpleDateFormat('yyyy-MM-dd hh:mm:ss a')

// Parse the original timestamp
Date originalDate = originalFormat.parse(originalTimestamp)

// Add 8 hours to the hour
Date targetDate = new Date(originalDate.time + (((8 * 60) * 60) * 1000))

// Format the target date to the desired format
String convertedTimestamp = targetFormat.format(targetDate)

// Print the converted timestamp
println(convertedTimestamp)

WebUI.delay(10)

'click Rejected tab'
Mobile.tap(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Rejected by Agent (1)'), 
    0)

propNameRejected = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Avantas (2)'), 
    0)

propNameRejected = propertyName

propertyLocationRejected = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Kuchai Lama, Wilayah Persekutuan Kuala Lumpur (2)'), 
    0)

propertyLocationRejected = propertyLocation

propStatusRejected = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Rejected (1)'), 
    0)

propStatusRejected = propertyStatusReject

propUsernameRejected = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Hazim Harith (3)'), 
    0)

propUsernameRejected = userName

propUserMobileRejected = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - 60178454122 (3)'), 
    0)

propUserMobileRejected = userMobile

propUserEmailRejected = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - hazimharith93gmail.com (3)'), 
    0)

propUserEmailRejected = userEmail

propertyReasonRejected = Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Not available at that time (1)'), 
    0)

propertyReasonRejected = propertyReason

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Today (3)'), 
    0)


/**
String convertedTimestamp1= "2023-05-31 045221 PM"
String expectedText = 'Rejected Date: ' + convertedTimestamp1

println(expectedText)

TestObject dynamicObject = new TestObject().addProperty("text", ConditionType.EQUALS, expectedText)
String actualText = Mobile.getText(dynamicObject)

println("Actual Text: " + actualText)

assert actualText == expectedText




String expectedText = 'Rejected Date: ' + convertedTimestamp

println (expectedText)


Mobile.verifyElementText(findTestObject('Object Repository/SDK44/5.1 Appointment (Reject)/android.widget.TextView - Rejected Date 2023-05-31 045221 PM'), expectedText)
**/