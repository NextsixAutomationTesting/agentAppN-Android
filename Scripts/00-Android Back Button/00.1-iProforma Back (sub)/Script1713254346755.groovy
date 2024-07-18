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

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Chatbot'), 0)
Mobile.waitForElementPresent(findTestObject('00 Back Button/android.widget.Button -  Commission'), 10)
Mobile.pressBack()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Employment Application'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Application'), 0)
Mobile.delay(1)
Mobile.pressBack()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Purchase Form'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Secure Purchase'), 0)
Mobile.delay(1)
Mobile.pressBack()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Purchase Form'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Purchase'), 0)
Mobile.delay(1)
Mobile.pressBack()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Rent Form'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Secure Rent'), 0)
Mobile.delay(1)
Mobile.pressBack()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Rent Form'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Rent'), 0)
Mobile.delay(1)
Mobile.pressBack()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Developer Sales Form'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Developer Sales'), 0)
Mobile.delay(1)
Mobile.pressBack()

Mobile.delay(1)
AppiumDriver driver = MobileDriverFactory.getDriver()
TouchAction leftSwipe = new TouchAction(driver)
.press(PointOption.point(950, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
.moveTo(PointOption.point(550, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
.moveTo(PointOption.point(150, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
.release()
.press(PointOption.point(950, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
.moveTo(PointOption.point(550, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
.moveTo(PointOption.point(150, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
.release()
.press(PointOption.point(950, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
.moveTo(PointOption.point(550, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
.moveTo(PointOption.point(150, 1650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
.release()
	
leftSwipe.perform()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Show All'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - My Folder'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - My CP58 Listing'), 0)
Mobile.delay(2)
Mobile.pressBack()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Show All'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Company Letter'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Company Letter Listing'), 0)
Mobile.delay(2)
Mobile.pressBack()

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Show All'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Memo'), 0)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Memo Listing'), 0)
Mobile.delay(2)
Mobile.pressBack()

Mobile.delay(1)

