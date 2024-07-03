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

WebUI.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Get Listing'), 0)

Mobile.waitForElementPresent(findTestObject('06 Get Listing/android.widget.EditText - Search Listing'), 30)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Owner (Sale)'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Filter'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - state'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Kelantan'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Select'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - area'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Ayer Lanas'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Select'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Search'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(320, 1430)

Mobile.delay(1)
Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Convert to my listing'), 0)

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Confirm'), 0)

WebUI.callTestCase(findTestCase('0-GENERAL/PermissionPopup'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('06 Get Listing/android.widget.Button - Preview'), 0)

Mobile.tap(findTestObject('Object Repository/06 Get Listing/android.widget.Button - Convert'), 0)

Mobile.scrollToText('MEMO')

Mobile.setText(findTestObject('Object Repository/06 Get Listing/android.widget.EditText -highl'), 'test convert owner listing', 0)
Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/06 Get Listing/android.widget.Button - Next'), 0)

Mobile.setText(findTestObject('Object Repository/06 Get Listing/android.widget.EditText - Addline1'), '123 Convert owner listing', 0)
Mobile.hideKeyboard()

Mobile.setText(findTestObject('Object Repository/06 Get Listing/android.widget.EditText - postcode'), '23400', 0)
Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/06 Get Listing/android.widget.Button - Next (1)'), 0)

Mobile.delay(1)
Mobile.scrollToText('FACILITIES')

Mobile.swipe(500, 1800, 500, 200)

Mobile.delay(1)
Mobile.tapAtPosition(800, 2150)

Mobile.delay(1)
Mobile.swipe(500, 1800, 500, 200)

Mobile.delay(1)
Mobile.tap(findTestObject('06 Get Listing/android.widget.Button - Submit'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(800, 1340)

Mobile.delay(1)
Mobile.tap(findTestObject('04 Property/android.widget.TextView - back'), 0)

Mobile.tap(findTestObject('04 Property/android.widget.TextView - Exit'), 0)

Mobile.tap(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - back listing'), 0)

Mobile.tap(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - back'), 0)

WebUI.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

