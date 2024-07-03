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

Mobile.callTestCase(findTestCase('0-GENERAL/Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('Ai Matching', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Meeting Room'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - ADD'), 0)

'create new booking'
Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - branch'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - HQ Branch'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Select'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Search'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Book Now'), 0)

Mobile.setText(findTestObject('08 Meeting Room/android.widget.EditText - Meeting Title'), 'Automation Testing', 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - start time'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.view.ViewGroup - 1st time slot'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - duration'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.view.ViewGroup - 1hr'), 0)

Mobile.scrollToText('We may contact you if there are any changes to your booking.', FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('08 Meeting Room/android.widget.EditText - contact'), '124568564', 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Book Now form'), 0)

Mobile.verifyElementVisible(findTestObject('08 Meeting Room/android.widget.TextView - Booking successful'), 10)

Mobile.scrollToText('Got It', FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Got It'), 0)

Mobile.waitForElementPresent(findTestObject('08 Meeting Room/android.widget.TextView - Pending'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Pending'), 0)

meetTime = Mobile.getText(findTestObject('08 Meeting Room/android.widget.TextView - meet Time'), 0)

'cancel meeting'
Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Cancel'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - CancelYes'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Cancelled'), 0)

cancelTime = Mobile.getText(findTestObject('08 Meeting Room/android.widget.TextView - cancel meet time'), 0)

assert cancelTime == meetTime

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - back meeting'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

