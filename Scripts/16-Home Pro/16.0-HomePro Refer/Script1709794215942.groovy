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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Mobile.callTestCase(findTestCase('0-GENERAL/Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('Get My Referrals', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Get My Referrals'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(800, 1170)

Mobile.delay(1)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - search'), 0)

Mobile.setText(findTestObject('16 HomePro/android.widget.EditText - Search for banker'), 'james', 0)

Mobile.hideKeyboard()

Mobile.tapAtPosition(550, 830)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - James Broke'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Refer This Merchant'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(960, 1490)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

String clipboard = driver.getClipboardText()

assert clipboard == 'Hi there, check out Banker - James Broke on NEXTSIX with many professional legal services offered that you might need at http://sit-apps.nextsix.com/m/v2/65e7dc64feed680065ff377a'

Mobile.delay(1)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back homepro'), 0)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - back home'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

