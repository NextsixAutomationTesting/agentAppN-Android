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

Mobile.delay(1)

Mobile.tap(findTestObject('16 HomePro/android.widget.TextView - Get My Referrals'), 0)

Mobile.tap(findTestObject('00 Back Button/android.widget.ImageView - merchant card'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/00 Back Button/android.widget.TextView - See All'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tapAtPosition(300, 1150)

Mobile.delay(1)

Mobile.tapAtPosition(320, 610)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/00 Back Button/android.widget.TextView - My Referral'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.pressBack()

