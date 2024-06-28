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

Mobile.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Login - Best Deal (Mentos)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - My Property'), 0)

Mobile.delay(1)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

TouchAction swipeUp = new TouchAction(driver).press(PointOption.point(560, 2100)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            30))).moveTo(PointOption.point(560, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).moveTo(
    PointOption.point(560, 340)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(30))).release()

swipeUp.perform()

Mobile.delay(1)

TouchAction swipeRight = new TouchAction(driver).press(PointOption.point(90, 1660)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            10))).moveTo(PointOption.point(120, 1660)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5))).moveTo(
    PointOption.point(1060, 1660)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).release()

swipeRight.perform()

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Set As Best Deal'), 0)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Yes'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Best Deal'), 0)

TouchAction swipeRight1 = new TouchAction(driver).press(PointOption.point(90, 1900)).waitAction(WaitOptions.waitOptions(
        Duration.ofMillis(10))).moveTo(PointOption.point(120, 1900)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            5))).moveTo(PointOption.point(1060, 1900)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).release()

swipeRight1.perform()

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Duplicate Property (1)'), 0)

Mobile.callTestCase(findTestCase('PermissionPopup'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(1)

Mobile.swipe(500, 1900, 500, 200)

Mobile.delay(1)

Mobile.swipe(500, 1800, 500, 200)

Mobile.delay(1)

Mobile.tapAtPosition(295, 2160)

Mobile.delay(1)

Mobile.tapAtPosition(800, 2160)

Mobile.delay(1)

Mobile.swipe(500, 1900, 500, 200)

Mobile.delay(1)

Mobile.swipe(500, 1800, 500, 200)

Mobile.delay(1)

Mobile.tapAtPosition(800, 2160)

Mobile.delay(1)

Mobile.swipe(500, 1800, 500, 200)

Mobile.delay(1)

Mobile.tapAtPosition(800, 2160)

Mobile.delay(1)

Mobile.tapAtPosition(800, 1340)

Mobile.waitForElementPresent(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - back'), 0)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - back'), 0)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - Exit'), 1)

usedBDS = WS.sendRequest(findTestObject('EAS/04 Property/usedBestDeal'))

def sluper = new JsonSlurper()

def result = sluper.parseText(usedBDS.getResponseBodyContent())

def usedSlot = result.documents[0].usedBestDealSlot

assert usedSlot == 1

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Remove From Best Deal'),0)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Yes'), 0)

Mobile.delay(2)

TouchAction swipeRight2 = new TouchAction(driver).press(PointOption.point(90, 1900)).waitAction(WaitOptions.waitOptions(
	Duration.ofMillis(10))).moveTo(PointOption.point(120, 1900)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
		5))).moveTo(PointOption.point(1060, 1900)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).release()

swipeRight2.perform()

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Change Property Status'), 0)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Inactive'), 0)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Update Status'), 0)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - back home'), 0)

WebUI.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

