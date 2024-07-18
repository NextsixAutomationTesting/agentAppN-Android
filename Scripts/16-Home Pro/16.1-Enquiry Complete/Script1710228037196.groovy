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

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

Mobile.scrollToText('Get My Referrals')

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Get My Referrals'), 0)

LocalDateTime nowMyt = LocalDateTime.now()
LocalDateTime comTime = nowMyt.plusDays(14).withHour(0)
DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')

String comDate = comTime.format(dateFormat)
String enqNote = 'This enquiry is created at: ' + nowMyt

WS.sendRequest(findTestObject('16 HomePro/newEnquiry', [('comDate') : comDate, ('enqNote') : enqNote]))

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - My Referral'), 0)

def latestEnquiry = WS.sendRequest(findTestObject('16 HomePro/latestEnquiry'))
def slurper = new JsonSlurper()
def result = slurper.parseText(latestEnquiry.getResponseBodyContent())
String enquiryId = result.documents[0]._id

WS.sendRequest(findTestObject('16 HomePro/acceptEnquiry', [('enquiryId') : enquiryId]))

AppiumDriver<?> driver = MobileDriverFactory.getDriver()
TouchAction refreshEnquiry = new TouchAction(driver)
.press(PointOption.point(540, 600)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(30)))
.moveTo(PointOption.point(540, 800)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10)))
.moveTo(PointOption.point(540, 2000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(30))).release()

refreshEnquiry.perform()

String enquiryStat = Mobile.getText(findTestObject('Object Repository/16 HomePro/android.widget.TextView - In Progress'), 0)
assert enquiryStat == 'In Progress'

def referAmount = RandomStringUtils.randomNumeric(4)

WS.sendRequest(findTestObject('16 HomePro/completeEnquiry', [('enquiryId') : enquiryId, ('referAmount') : referAmount]))

Mobile.delay(1)
Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Completed'), 0)

Mobile.delay(2)
String enquiryStatCom = Mobile.getText(findTestObject('Object Repository/16 HomePro/android.widget.TextView - Completed (1)'), 0)

enquiryAmoCom = Mobile.getText(findTestObject('Object Repository/16 HomePro/android.widget.TextView - RM 4870'), 0)
assert enquiryStatCom == 'Completed'
assert enquiryAmoCom == 'RM '+ referAmount

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back referral'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back home'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:])

