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

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

Mobile.scrollToText('Ai Matching', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - DeveloperProject'), 0)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - search'), 0)

Mobile.setText(findTestObject('11 Developer Project/android.widget.EditText - Search for developer project'), 'Project', 0)
Mobile.hideKeyboard()

Mobile.delay(1)
Mobile.tapAtPosition(540,450)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - FILTER'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(500, 850)

Mobile.delay(1)
Mobile.tapAtPosition(500, 1100)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - Ok'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(1040,150)

Mobile.waitForElementPresent(findTestObject('11 Developer Project/android.widget.RelativeLayout - map'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - list'), 0)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - back'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

