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

WebUI.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

String randAns = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(5).toLowerCase()

String randQ = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(5).toLowerCase()

String randAns1 = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(5).toLowerCase()

String randQ1 = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(5).toLowerCase()

String randAns2 = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(5).toLowerCase()

String randQ2 = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(5).toLowerCase()

WS.sendRequest(findTestObject('EAS/13 Academy/editAssessment', [('q') : randQ, ('ans') : randAns, ('q1') : randQ1, ('ans1') : randAns1
            , ('q2') : randQ2, ('ans2') : randAns2]))

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Academy'), 0)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Assessment'), 0)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Automation Testing'), 0)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Take Test'), 0)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Yes'), 0)

Mobile.waitForElementPresent(findTestObject('EAS/13 Academy/android.widget.TextView - Confirm Answer'), 30)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.tapAtPosition(500, 1450)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tapAtPosition(500, 780)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Confirm Answer'), 0)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Confirm Answer'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tapAtPosition(500, 950)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Confirm Answer'), 0)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Confirm Answer'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tapAtPosition(500, 950)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Confirm Answer'), 0)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Confirm Answer'), 0)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - Exit'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/13 Academy/android.widget.TextView - back'), 0)

Mobile.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

