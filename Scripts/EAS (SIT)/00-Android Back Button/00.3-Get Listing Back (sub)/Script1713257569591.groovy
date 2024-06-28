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

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Get Listing'), 0)

Mobile.delay(5)

Mobile.tapAtPosition(590, 1520)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Filter'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.tap(findTestObject('EAS/00 Back Button/android.widget.TextView - Contact history'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.tap(findTestObject('EAS/00 Back Button/android.widget.TextView - Enquiry'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(320, 1430)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('EAS/00 Back Button/android.widget.TextView - Owner (Sale)'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(320, 1430)

Mobile.delay(1)

Mobile.tap(findTestObject('EAS/00 Back Button/android.widget.TextView - Convert to my listing'), 0)

Mobile.delay(1)

Mobile.tap(findTestObject('EAS/00 Back Button/android.widget.TextView - Confirm'), 1430)

Mobile.delay(1)

Mobile.pressBack()

Mobile.pressBack()

Mobile.pressBack()

