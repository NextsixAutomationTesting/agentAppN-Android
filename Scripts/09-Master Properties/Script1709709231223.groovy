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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

Mobile.tap(findTestObject('09 Master Properties/android.widget.TextView - Master Property'), 0)

Mobile.tap(findTestObject('09 Master Properties/android.widget.TextView - create'), 0)

def randChar = RandomStringUtils.randomAlphanumeric(6)
String randName = 'Automation ' + randChar.toUpperCase()
Mobile.setText(findTestObject('09 Master Properties/android.widget.EditText - propname'), randName, 0)
Mobile.hideKeyboard()

Mobile.delay(1)
Mobile.tapAtPosition(450, 1110)

Mobile.delay(1)
Mobile.tapAtPosition(450, 1250)

Mobile.delay(1)
Mobile.tapAtPosition(450, 1350)

Mobile.delay(1)
Mobile.tapAtPosition(450, 1500)

Mobile.delay(1)
Mobile.tapAtPosition(450, 1600)

Mobile.delay(1)
Mobile.tapAtPosition(450, 1750)

Mobile.tap(findTestObject('09 Master Properties/android.widget.Button - Next'), 5)

Mobile.setText(findTestObject('Object Repository/09 Master Properties/android.widget.EditText-add1'), 'Jln Mewah 8, Taman Ampang Mewah', 5)
Mobile.hideKeyboard()

Mobile.setText(findTestObject('Object Repository/09 Master Properties/android.widget.EditText-city'), 'Ampang Mewah', 0)
Mobile.hideKeyboard()

Mobile.setText(findTestObject('Object Repository/09 Master Properties/android.widget.EditText-postc'), '68000', 0)
Mobile.delay(1)
Mobile.hideKeyboard()

Mobile.delay(1)
Mobile.tapAtPosition(450, 1650)

Mobile.delay(1)
Mobile.tapAtPosition(450, 1800)

Mobile.delay(1)
Mobile.tapAtPosition(450, 1900)

Mobile.delay(1)
Mobile.tapAtPosition(450, 2050)

Mobile.delay(1)
Mobile.scrollToText('Cafeteria')

Mobile.tap(findTestObject('09 Master Properties/android.widget.Button - Publish'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(790, 1340)

Mobile.verifyElementVisible(findTestObject('09 Master Properties/android.widget.Image - Successful Checkmark'), 0)

Mobile.tap(findTestObject('09 Master Properties/android.widget.TextView - back'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(720, 1400)

Mobile.tap(findTestObject('09 Master Properties/android.widget.TextView - Pending'), 0)

masterName = Mobile.getText(findTestObject('Object Repository/09 Master Properties/android.widget.TextView - Automation S9H4RW'), 0)
assert masterName == randName

Mobile.tap(findTestObject('09 Master Properties/android.widget.TextView - mas back'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

