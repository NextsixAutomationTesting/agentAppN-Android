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

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - My Property'), 0)

Mobile.delay(2)

AppiumDriver driver = MobileDriverFactory.getDriver()

TouchAction swipeUp = new TouchAction(driver).press(PointOption.point(560, 2100)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
            500))).moveTo(PointOption.point(560, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(
    PointOption.point(560, 340)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).release()

swipeUp.perform()

Mobile.tapAtPosition(560, 1750)

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Edit'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('00 Back Button/android.widget.ImageView - memo'), 0)

Mobile.waitForElementPresent(findTestObject('00 Back Button/android.widget.EditText - Leave your memo here'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

memoClose = Mobile.verifyElementExist(findTestObject('00 Back Button/android.widget.EditText - Leave your memo here'), 
    0, FailureHandling.OPTIONAL)

if (memoClose == true) {
    Mobile.tap(findTestObject('00 Back Button/android.widget.ImageView - close memo'), 0)

    KeywordUtil.markFailed('Listing memo back button')
}

Mobile.pressBack()

Mobile.delay(1)

Mobile.tapAtPosition(950, 2120)

Mobile.delay(1)

Mobile.tapAtPosition(950, 1900)

Mobile.delay(2)

Mobile.pressBack()

Mobile.delay(2)

Mobile.tapAtPosition(950, 2120)

Mobile.delay(1)

Mobile.tapAtPosition(950, 1670)

Mobile.delay(2)

Mobile.pressBack()

Mobile.delay(2)

Mobile.tapAtPosition(950, 2120)

Mobile.delay(1)

Mobile.tapAtPosition(950, 1450)

Mobile.delay(1)

Mobile.pressBack()

Mobile.pressBack()

