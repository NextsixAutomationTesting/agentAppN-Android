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

Mobile.callTestCase(findTestCase('Login - TRR (Wilson)'), [:], FailureHandling.STOP_ON_FAILURE)

'chatbot'
Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Chatbot'), 0)

Mobile.waitForElementPresent(findTestObject('EAS/07 iProforma/android.widget.Button -  Commission'), 0)

Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.Button -  Commission'), 0)

Mobile.waitForElementPresent(findTestObject('EAS/07 iProforma/android.widget.Button -  How to check the calculation of the commission for the case'), 
    0)

Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.Button -  How to check the calculation of the commission for the case'), 
    0)

'end of chatbot'
Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - back chatbot'), 0)

'open employment application form\r\n'
Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Employment Application'), 0)

Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Application'), 0)

'verify employment application form opened'
Mobile.verifyElementVisible(findTestObject('EAS/07 iProforma/android.view.View - person_add Employment Application'), 0)

Mobile.pressBack()

'open secure purchase form\r\n'
Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Purchase Form'), 0)

Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Secure Purchase'), 0)

'verify secure purchase form opened'
Mobile.verifyElementVisible(findTestObject('EAS/07 iProforma/android.widget.TextView - Instruction To Secure a Purchaser'), 
    0)

Mobile.pressBack()

'open purchase form\r\n'
Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Purchase Form'), 0)

Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Purchase'), 0)

'verify purchase form opened'
Mobile.verifyElementVisible(findTestObject('EAS/07 iProforma/android.view.View - assignment Letter of Offer to Purchase fiber_new'), 
    0)

Mobile.pressBack()

'open secure rent form\r\n'
Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Rent Form'), 0)

Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Secure Rent'), 0)

'verify secure rent form opened'
Mobile.verifyElementVisible(findTestObject('EAS/07 iProforma/android.widget.TextView - Instruction To Secure a Tenant'), 
    0)

Mobile.pressBack()

'open rent form\r\n'
Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Rent Form'), 0)

Mobile.tap(findTestObject('EAS/07 iProforma/android.widget.TextView - Rent'), 0)

'verify rent form opened'
Mobile.verifyElementVisible(findTestObject('EAS/07 iProforma/android.view.View - account_balance Letter of Offer to Rent fiber_new'), 
    0)

Mobile.pressBack()

Mobile.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

