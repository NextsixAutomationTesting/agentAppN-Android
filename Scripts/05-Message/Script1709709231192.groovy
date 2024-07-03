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

Mobile.delay(1)
Mobile.tapAtPosition(450, 2210)

WS.sendRequest(findTestObject('05 Message/receiveMessage'))

Mobile.waitForElementPresent(findTestObject('05 Message/android.widget.TextView - Select Multiple'), 10)

Mobile.delay(1)
Mobile.tapAtPosition(550, 700)

Mobile.verifyElementText(findTestObject('Object Repository/05 Message/android.widget.TextView - automation test (agent app) receive message (1)'), 
    'automation test (agent app) receive message')

Mobile.setText(findTestObject('05 Message/android.widget.EditText - Type a message'), 'automation test (agent app) send message', 
    0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('05 Message/android.widget.TextView - Send'), 0)

Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/05 Message/android.widget.TextView - back message'), 0)

Mobile.delay(2)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

