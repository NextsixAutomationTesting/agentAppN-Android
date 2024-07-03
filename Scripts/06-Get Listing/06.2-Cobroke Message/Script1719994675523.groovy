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

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Get Listing'), 0)

Mobile.waitForElementPresent(findTestObject('06 Get Listing/android.widget.EditText - Search Listing'), 30)
Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Filter'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(500,360)

Mobile.delay(1)
Mobile.tapAtPosition(520,750)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Select'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(500,600)

Mobile.delay(1)
Mobile.tapAtPosition(500,540)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Select'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(300,2200)

Mobile.waitForElementPresent(findTestObject('06 Get Listing/android.widget.EditText - Search Listing'), 30)
Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Taman Ayer Lanas'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Message (1)'), 0)

Mobile.delay(1)
Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Taman Ayer Lanas chat'), 0)

Mobile.delay(1)
Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Message (1)'), 0)

Mobile.delay(1)
Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - back'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - back'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(955, 1605)

Mobile.waitForElementPresent(findTestObject('06 Get Listing/android.widget.EditText - Type a message'), 30)

Mobile.setText(findTestObject('06 Get Listing/android.widget.EditText - Type a message'), 'Automation Test (send) co-broke message', 
    0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Send'), 0)

Mobile.delay(1)
Mobile.verifyElementText(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Automation Test (send) co-broke message (1)'), 'Automation Test (send) co-broke message')

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - back'), 0)

WS.sendRequest(findTestObject('06 Get Listing/receiveCBmessage'))

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Message (1)'), 0)

Mobile.delay(1)
Mobile.verifyElementText(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Automation Test (receive) co-broke message (1)'), 'Automation Test (receive) co-broke message')

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - back'), 0)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - back listing'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

