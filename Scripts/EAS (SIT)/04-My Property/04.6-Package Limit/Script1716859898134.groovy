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

WebUI.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login - TRR (Carmen)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - My Property'), 0)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Inactive (1)'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

TouchAction swipeRight = new TouchAction(driver).press(PointOption.point(90, 2000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
	10))).moveTo(PointOption.point(120, 2000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5))).moveTo(
PointOption.point(1060, 2000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))).release()

swipeRight.perform()

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Change Property Status'),0)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Active'),0)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Update Status'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Youve reached your maximum active listing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/EAS/04 Property/android.widget.TextView - Ok'), 0)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - back home'), 0)

WebUI.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)