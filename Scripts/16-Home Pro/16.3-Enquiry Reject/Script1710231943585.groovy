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

Mobile.callTestCase(findTestCase('0-GENERAL/Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('Get My Referrals', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Get My Referrals'), 0)

LocalDateTime nowMyt = LocalDateTime.now()

LocalDateTime comTime = nowMyt.plusDays(14)

DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')

String comDate = comTime.format(dateFormat)

String enqNote = 'This enquiry is created at: ' + nowMyt

WS.sendRequest(findTestObject('16 HomePro/newEnquiry', [('comDate') : comDate, ('enqNote') : enqNote]))

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - My Referral'), 0)

String enquiryStatus = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - status'), 0)

assert enquiryStatus == 'New'

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back referral'), 0)

def latestEnquiry = WS.sendRequest(findTestObject('16 HomePro/latestEnquiry'))

def slurper = new JsonSlurper()

def result = slurper.parseText(latestEnquiry.getResponseBodyContent())

String enquiryId = result.documents[0]._id

String reasonReject = 'Not available on ' + comDate

WS.sendRequest(findTestObject('16 HomePro/rejectEnquiry', [('enquiryId') : enquiryId, ('reasonReject') : reasonReject]))

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - My Referral'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Completed'), 0)

String enquiryStatRej = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - CompletedStatus'), 0)

reasonRej = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - Reason rejected'), 0)

assert enquiryStatRej == 'Rejected '

assert reasonRej == ('Reason rejected : ' + reasonReject)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back referral'), 0)

Mobile.delay(1)

//Cancel by merchant
WS.sendRequest(findTestObject('16 HomePro/newEnquiry', [('comDate') : comDate, ('enqNote') : enqNote]))

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - My Referral'), 0)

String enqStatus = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - status'), 0)

assert enqStatus == 'New'

Mobile.delay(1)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back referral'), 0)

def latestEnquiry2 = WS.sendRequest(findTestObject('16 HomePro/latestEnquiry'))

def slurper2 = new JsonSlurper()

def result2 = slurper2.parseText(latestEnquiry2.getResponseBodyContent())

String enqId = result2.documents[0]._id

def role = 'merchant'

def merchantCancel = (('Cancelled by ' + role) + ' at ') + nowMyt

WS.sendRequest(findTestObject('16 HomePro/cancelMerchant', [('enqId') : enqId, ('role') : role, ('merchantCancel'):merchantCancel] ))

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - My Referral'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Completed'), 0)

String enqMercCancel = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - CompletedStatus'), 0)

reasonCan = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - Reason rejected'), 0)

assert enqMercCancel == 'Cancelled by Merchant'

assert reasonCan == ('Reason from Merchant : ' + merchantCancel)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back referral'), 0)

Mobile.delay(1)

//Cancel by user
WS.sendRequest(findTestObject('16 HomePro/newEnquiry', [('comDate') : comDate, ('enqNote') : enqNote]))

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - My Referral'), 0)

String enqStatus1 = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - status'), 0)

assert enqStatus1 == 'New'

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back referral'), 0)

Mobile.delay(1)

def latestEnquiry3 = WS.sendRequest(findTestObject('16 HomePro/latestEnquiry'))

def slurper3 = new JsonSlurper()

def result3 = slurper3.parseText(latestEnquiry3.getResponseBodyContent())

String enqId1 = result3.documents[0]._id

role2 = 'user'

clientCancel = 'Cancelled by ' + role2

WS.sendRequest(findTestObject('16 HomePro/cancelClient', [('enqId') : enqId1, ('role') : role2, ('clientCancel'):clientCancel] ))

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - My Referral'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Completed'), 0)

String enqMercCancel1 = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - CompletedStatus'), 0)

reasonCan1 = Mobile.getText(findTestObject('16 HomePro/android.widget.TextView - Reason rejected'), 0)

assert enqMercCancel1 == 'Cancelled by User'

assert reasonCan1 == ('Reason from Client : ' + clientCancel)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back referral'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back home'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

