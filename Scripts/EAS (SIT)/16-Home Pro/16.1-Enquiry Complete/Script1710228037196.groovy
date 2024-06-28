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

Mobile.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('Get My Referrals', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/16 HomePro/android.widget.TextView - Get My Referrals'), 0)

LocalDateTime nowMyt = LocalDateTime.now()

LocalDateTime comTime = nowMyt.plusDays(14).withHour(0)

DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')

String comDate = comTime.format(dateFormat)

String enqNote = 'This enquiry is created at: ' + nowMyt

WS.sendRequest(findTestObject('EAS/16 HomePro/newEnquiry', [('comDate') : comDate, ('enqNote') : enqNote]))

Mobile.tap(findTestObject('EAS/16 HomePro/android.widget.TextView - My Referral'), 0)

String enquiryStatus = Mobile.getText(findTestObject('EAS/16 HomePro/android.widget.TextView - status'), 0)

assert enquiryStatus == 'New'

Mobile.tap(findTestObject('EAS/16 HomePro/android.widget.TextView - back referral'), 0)

def latestEnquiry = WS.sendRequest(findTestObject('EAS/16 HomePro/latestEnquiry'))

def slurper = new JsonSlurper()

def result = slurper.parseText(latestEnquiry.getResponseBodyContent())

String enquiryId = result.documents[0]._id

WS.sendRequest(findTestObject('EAS/16 HomePro/acceptEnquiry', [('enquiryId') : enquiryId]))

Mobile.tap(findTestObject('EAS/16 HomePro/android.widget.TextView - My Referral'), 0)

String enquiryStat = Mobile.getText(findTestObject('EAS/16 HomePro/android.widget.TextView - status'), 0)

assert enquiryStat == 'In Progress'

Mobile.tap(findTestObject('EAS/16 HomePro/android.widget.TextView - back referral'), 0)

def referAmount = RandomStringUtils.randomNumeric(4)

WS.sendRequest(findTestObject('EAS/16 HomePro/completeEnquiry', [('enquiryId') : enquiryId, ('referAmount') : referAmount]))

Mobile.delay(1)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

TouchAction swipeLeft = new TouchAction(driver).press(PointOption.point(180, 250)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
			30))).moveTo(PointOption.point(250, 250)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).moveTo(
	PointOption.point(1000, 250)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(30))).release()

swipeLeft.perform()

Mobile.delay(2)

Mobile.tap(findTestObject('Object Repository/EAS/16 HomePro/android.widget.TextView - My Referral (1)'), 0)

Mobile.tap(findTestObject('EAS/16 HomePro/android.widget.TextView - Completed'), 0)

String enquiryStatCom = Mobile.getText(findTestObject('EAS/16 HomePro/android.widget.TextView - CompletedStatus'), 0)

enquiryAmoCom = Mobile.getText(findTestObject('EAS/16 HomePro/android.widget.TextView - RM 1234'), 0)

assert enquiryStatCom == 'Completed'

assert enquiryAmoCom == 'RM '+ referAmount

Mobile.callTestCase(findTestCase('EAS (SIT)/16-Home Pro/16.2-Enquiry Attachments (sub)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/16 HomePro/android.widget.TextView - back referral'), 0)

Mobile.tap(findTestObject('EAS/16 HomePro/android.widget.TextView - back home'), 0)

Mobile.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

