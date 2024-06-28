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

Mobile.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Get Listing'), 0)

Mobile.waitForElementPresent(findTestObject('EAS/06 Get Listing/android.widget.TextView - Enquiry'), 0)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Enquiry'), 0)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Call button'), 0)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.pressBack()

Mobile.waitForElementPresent(findTestObject('EAS/06 Get Listing/android.widget.TextView - Owner (Sale)'), 0)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Owner (Sale)'), 0)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Call button'), 0)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.pressBack()

Mobile.waitForElementPresent(findTestObject('EAS/06 Get Listing/android.widget.TextView - Owner (Rent)'), 0)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Owner (Rent)'), 0)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - Call button'), 0)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.pressBack()

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/06 Get Listing/android.widget.TextView - back listing'), 0)

Mobile.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

