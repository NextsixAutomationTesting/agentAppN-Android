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

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

Mobile.tap(findTestObject('04 Property/android.widget.TextView - My Property'), 5)

Mobile.waitForElementPresent(findTestObject('Object Repository/04 Property/android.widget.TextView - Properties'), 60)

AppiumDriver driver = MobileDriverFactory.getDriver()

TouchAction swipeUp = new TouchAction(driver).press(PointOption.point(560, 2100)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            500))).moveTo(PointOption.point(560, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(
    PointOption.point(560, 340)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).release()
	
swipeUp.perform()

Mobile.delay(1)
Mobile.tapAtPosition(560, 1750)

Mobile.delay(1)
Mobile.tapAtPosition(540, 2190)

WebUI.callTestCase(findTestCase('0-GENERAL/PermissionPopup'), [:])

Mobile.waitForElementPresent(findTestObject('04 Property/android.widget.Button - listing category'), 5)

Mobile.scrollToText('MEMO')

Mobile.delay(1)
Mobile.setText(findTestObject('Object Repository/04 Property/android.widget.EditText - Edit Hightlight'), 'edit property', 5)
Mobile.hideKeyboard()

swipeUp.perform()

Mobile.tap(findTestObject('04 Property/android.widget.Button - Next'), 0)

Mobile.tap(findTestObject('04 Property/android.widget.Button - Next2'), 0)

Mobile.swipe(500, 1800, 500, 200)

Mobile.delay(1)
Mobile.swipe(500, 1800, 500, 200)

Mobile.tapAtPosition(800, 2150)

Mobile.delay(1)
Mobile.scrollToText('Watermark options')

Mobile.delay(1)
Mobile.tap(findTestObject('04 Property/android.widget.Button - 2nd photo'), 0)

Mobile.tap(findTestObject('04 Property/android.widget.Button - Set as cover'), 0)

Mobile.swipe(500, 1800, 500, 200)

Mobile.delay(1)
Mobile.swipe(500, 1800, 500, 200)

Mobile.tap(findTestObject('04 Property/android.widget.Button - Submit'), 1)

Mobile.delay(1)
Mobile.tapAtPosition(800, 1340)

Mobile.delay(1)
Mobile.tapAtPosition(530,880)

Mobile.delay(1)
Mobile.tapAtPosition(720,1350)

Mobile.delay(1)
Mobile.tapAtPosition(75,130)

Mobile.delay(1)
Mobile.tapAtPosition(100,360)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:])
