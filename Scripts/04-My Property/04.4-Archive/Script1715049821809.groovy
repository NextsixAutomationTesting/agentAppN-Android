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
import java.time.Duration as Duration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.TouchAction as TouchAction
import io.appium.java_client.touch.offset.PointOption as PointOption
import io.appium.java_client.touch.WaitOptions as WaitOptions
import groovy.json.JsonSlurper as JsonSlurper
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.util.Date as Date

//Auto Archive
//Last update >60 days will move to archive
autoArchive = WS.sendRequest(findTestObject('04 Property/autoArchive'))
def slurper = new JsonSlurper()
def result = slurper.parseText(autoArchive.getResponseBodyContent())
updatedDate = result.documents[0].updated

LocalDateTime nowTime = LocalDateTime.now()
DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')
LocalDateTime updateTime = LocalDateTime.parse(updatedDate, dateFormat).plusHours(8)

def differenceTime = nowTime.dayOfYear - updateTime.dayOfYear
if (differenceTime <= 60) 
	{
	KeywordUtil.markFailed('Auto archive <60 days moved to archive')
}

//Last update <=60 days will remain
autoArchived = WS.sendRequest(findTestObject('04 Property/autoArchived'))
def result1 = slurper.parseText(autoArchived.getResponseBodyContent())
lastUpdate = result1.documents[0].updated

LocalDateTime nowDate = LocalDateTime.now()
LocalDateTime updatedTime = LocalDateTime.parse(lastUpdate, dateFormat).plusHours(8)

def differenceDays = nowDate.dayOfYear - updatedTime.dayOfYear
if (differenceDays > 60) {
	KeywordUtil.markFailed('Auto archive >60 days did not move to archive')
}

//Manual Archive (App)
WebUI.callTestCase(findTestCase('0-GENERAL/Login - Public (Kelly)'), [:])

Mobile.tap(findTestObject('04 Property/android.widget.TextView - My Property'), 0)

Mobile.delay(3)
AppiumDriver driver = MobileDriverFactory.getDriver()

TouchAction swipeUp = new TouchAction(driver).press(PointOption.point(560, 2100)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            30))).moveTo(PointOption.point(560, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).moveTo(
    PointOption.point(560, 340)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(30))).release()

swipeUp.perform()

Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Inactive (1)'),0)

Mobile.delay(1)
TouchAction swipeRight = new TouchAction(driver).press(PointOption.point(90, 1660)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            10))).moveTo(PointOption.point(120, 1660)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5))).moveTo(
    PointOption.point(1060, 1660)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).release()

swipeRight.perform()

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Change Property Status'), 0)

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Archive'), 0)

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Update Status'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(950, 2120)

Mobile.delay(1)
Mobile.tapAtPosition(950, 1450)

Mobile.delay(1)
TouchAction swipeRight2 = new TouchAction(driver).press(PointOption.point(90, 600)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            10))).moveTo(PointOption.point(120, 600)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5))).moveTo(PointOption.point(
        1060, 600)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).release()

swipeRight2.perform()

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Change Property Status'), 0)

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Active'), 0)

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Update Status'), 0)

Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - FOR SALES'),0)

Mobile.delay(1)
TouchAction swipeUp1 = new TouchAction(driver).press(PointOption.point(560, 2100)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            30))).moveTo(PointOption.point(560, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).moveTo(
    PointOption.point(560, 340)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(30))).release()

swipeUp1.perform()

Mobile.delay(1)

TouchAction swipeRight1 = new TouchAction(driver).press(PointOption.point(90, 1660)).waitAction(WaitOptions.waitOptions(
        Duration.ofMillis(10))).moveTo(PointOption.point(120, 1660)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            5))).moveTo(PointOption.point(1060, 1660)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).release()

swipeRight1.perform()

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Change Property Status'), 0)

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Inactive'), 0)

Mobile.tap(findTestObject('Object Repository/04 Property/android.widget.TextView - Update Status'), 0)

Mobile.tap(findTestObject('04 Property/android.widget.TextView - back home'), 0)

WebUI.callTestCase(findTestCase('0-GENERAL/Logout'), [:])
