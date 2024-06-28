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

'create property for save draft'
Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - My Property'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(950, 2120)

Mobile.delay(1)

Mobile.tapAtPosition(950, 1900)

Mobile.delay(1)

WebUI.callTestCase(findTestCase('PermissionPopup'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('EAS/04 Property/android.widget.Button - listing category'), 0)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.Button - listing category'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(200, 1124)

Mobile.delay(1)

Mobile.tapAtPosition(960, 310)

Mobile.waitForElementPresent(findTestObject('EAS/04 Property/android.widget.EditText-editmas'), 0)

Mobile.setText(findTestObject('EAS/04 Property/android.widget.EditText-editmas'), 'maria', 0)

Mobile.delay(2)

Mobile.tapAtPosition(525, 1050)

Mobile.setText(findTestObject('EAS/04 Property/android.widget.EditText - selling price'), '220000', 0)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('EAS/04 Property/android.widget.EditText - buildup size'), '567', 0)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('EAS/04 Property/android.widget.EditText - highlight'), 'save draft', 0)

Mobile.hideKeyboard()

Mobile.scrollToText('Next')

Mobile.tap(findTestObject('EAS/04 Property/android.widget.Button - Save as Draft'), 0)

Mobile.waitForElementPresent(findTestObject('EAS/04 Property/android.widget.TextView - delete draft'), 0)

'delete draft'
Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - delete draft'), 0)

Mobile.delay(1)

'\r\n'
Mobile.tapAtPosition(730, 1400)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - back draft'), 0)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - Exit'), 0)

Mobile.tap(findTestObject('EAS/04 Property/android.widget.TextView - back home'), 0)

Mobile.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

