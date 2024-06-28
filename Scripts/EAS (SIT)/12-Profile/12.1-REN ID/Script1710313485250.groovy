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
import groovy.json.JsonSlurper as JsonSlurper
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

Mobile.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('EAS/12 Agent Profile/android.widget.TextView - Submit Ren ID'), 0)

Mobile.tap(findTestObject('EAS/12 Agent Profile/android.widget.TextView - level'), 0)

Mobile.tap(findTestObject('EAS/12 Agent Profile/android.widget.TextView - REN'), 0)

def randID = RandomStringUtils.randomNumeric(6)

Mobile.setText(findTestObject('EAS/12 Agent Profile/android.widget.EditText - ID'), randID, 0)

Mobile.tap(findTestObject('EAS/12 Agent Profile/android.widget.TextView - Submit'), 0)

Mobile.verifyElementVisible(findTestObject('EAS/12 Agent Profile/android.widget.TextView - Submitted'), 20)

Mobile.tap(findTestObject('EAS/12 Agent Profile/android.widget.TextView - Ok (1)'), 0)

renidDraft = WS.sendRequest(findTestObject('EAS/12 Agent Profile/renidDraft'))

def slurper = new JsonSlurper()

def result = slurper.parseText(renidDraft.getResponseBodyContent())

renIdApply = result.documents[0].id

assert renIdApply == randID

Mobile.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)

