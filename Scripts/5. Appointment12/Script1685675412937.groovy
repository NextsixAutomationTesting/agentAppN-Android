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


//test

Mobile.startApplication('C:\\Users\\Nextsix\\git\\agentTesterSDK49.apk', true)

Mobile.setText(findTestObject('Object Repository/5.Appointment/android.widget.EditText - UsernameEmail Address (1)'), 'mariael', 
    0)

Mobile.setText(findTestObject('Object Repository/5.Appointment/android.widget.EditText - Password (1)'), '123456', 0)

Mobile.tap(findTestObject('Object Repository/5.Appointment/android.widget.TextView - (1)'), 0)

Mobile.tap(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Sign In (1)'), 0)

Mobile.tap(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Not Now (1)'), 0)

// Get the current date and time
LocalDateTime currentDateTime = LocalDateTime.now()

// Define the desired format
DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')

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

//Create Appointment
createAppointment = WS.sendRequest(findTestObject('5.Appointment/create appointment', [('date') : date, ('slot') : slot]))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(createAppointment.getResponseBodyContent())

//Get latest appointment ID NEW
appointmentID = WS.sendRequest(findTestObject('5.Appointment/latest appointment ID'))

def sluper1 = new groovy.json.JsonSlurper()

def result1 = sluper1.parseText(appointmentID.getResponseBodyContent())

def appID = result1.documents[0]._id

println(appID)

//Get appointment details
appointmentDetails = WS.sendRequest(findTestObject('5.Appointment/appointment details', [('status') : appID]))

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

//convert date format
String timestamp = appDate2

SimpleDateFormat inputFormat = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')

Date date2 = inputFormat.parse(timestamp)

SimpleDateFormat outputFormat = new SimpleDateFormat('dd MMM yyyy EEE')

String appointmentDate = outputFormat.format(date2)

println(appointmentDate)

WebUI.delay(10)

//click on Request tab
Mobile.tap(findTestObject('Object Repository/5.Appointment/android.widget.ImageView'), 0)

propname = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Choons Residence'), 
    0)

propname = propertyName

proplocation = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Kuchai Lama, Wilayah Persekutuan Kuala Lumpur'), 
    0)

proplocation = propertyLocation

propstatus = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - New (1)'), 
    0)

propstatus = propertyStatus

propUsername = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Hazim Harith'), 
    0)

propUsername = userName

propMobile = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - 60178454122'), 
    0)

propMobile = userMobile

Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Today'), 0)

'click accept button'
Mobile.tap(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Accept (2)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Accept'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Do you wish to accept this appointment'), 
    0)

'Click Acccept button'
Mobile.tap(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Accept (1)'), 0)

'Click Accept tab'
Mobile.tap(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Accepted'), 0)

//Get latest appointment ID ACCEPTED
appointmentID2 = WS.sendRequest(findTestObject('5.Appointment/latest appointment ID'))

def sluper3 = new groovy.json.JsonSlurper()

def result3 = sluper3.parseText(appointmentID2.getResponseBodyContent())

def appID2 = result3.documents[0]._id

println(appID2)

//Get appointment details
appointmentDetails = WS.sendRequest(findTestObject('5.Appointment/appointment details', [('status') : appID2]))

def sluper4 = new groovy.json.JsonSlurper()

def result4 = sluper4.parseText(appointmentDetails.getResponseBodyContent())

def propertyStatus1 = result4.status

println(propertyStatus1)

propnameAccept = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Choons Residence (1)'), 0)

propnameAccept = propertyName


propstatusAccept = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Accepted (1)'), 0)

propstatusAccept = propertyStatus1


proplocationAccept = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Kuchai Lama, Wilayah Persekutuan Kuala Lumpur (1)'), 0)

proplocationAccept = propertyLocation


propUsernameAccept = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Hazim Harith (1)'), 0)

propUsernameAccept = userName


propMobileAccept = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - 60178454122 (1)'), 0)

propMobileAccept = userMobile


propemailAccept = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - hazimharith93gmail.com'), 0)

propemailAccept = userEmail


Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Today (1)'), 0)

//Update appointment to COMPLETE
updateAppointment = WS.sendRequest(findTestObject('5.Appointment/Update appointment status', [('appID') : appID]))

def sluper5 = new groovy.json.JsonSlurper()

def result5 = sluper5.parseText(updateAppointment.getResponseBodyContent())

def propertyStatus2 = result5.status

println(propertyStatus2)

//Get latest appointment ID ACCEPTED
appointmentID3 = WS.sendRequest(findTestObject('5.Appointment/latest appointment ID'))

def sluper7 = new groovy.json.JsonSlurper()

def result7 = sluper7.parseText(appointmentID3.getResponseBodyContent())

def appID3 = result7.documents[0]._id

println(appID3)

//Get appointment details
appointmentDetails = WS.sendRequest(findTestObject('5.Appointment/appointment details', [('status') : appID3]))

def sluper6 = new groovy.json.JsonSlurper()

def result6 = sluper6.parseText(appointmentDetails.getResponseBodyContent())

def propertyStatus3 = result6.status

println(propertyStatus3)


'click completed tab'
Mobile.tap(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Completed'), 0)

propnameComplete = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Choons Residence (2)'), 0)

propnameComplete = propertyName


propstatusComplete = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Completed (1)'), 0)

propstatusComplete = propertyStatus3


proplocationComplete = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Kuchai Lama, Wilayah Persekutuan Kuala Lumpur (2)'), 0)

proplocationComplete = propertyLocation


propUsernameComplete = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Hazim Harith (2)'), 0)

propUsernameComplete = userName


propMobileComplete = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - 60178454122 (2)'), 0)

propMobileComplete = userMobile


propemailComplete = Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - hazimharith93gmail.com (1)'), 0)

propemailComplete = userEmail

Mobile.verifyElementExist(findTestObject('Object Repository/5.Appointment/android.widget.TextView - Today (2)'), 0)

