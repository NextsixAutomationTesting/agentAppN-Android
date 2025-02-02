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

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('12 Agent Profile/android.widget.TextView - Edit Profile'), 0)

String preAbout = Mobile.getText(findTestObject('12 Agent Profile/android.widget.EditText - about'), 0)
String[] separateText = preAbout.split(' ')
int numAbout = Integer.valueOf((separateText[(separateText.length - 1)]).replaceAll('\\D', ''))
String newAbout = 'This is a test account. Automation Testing ' + (numAbout + 1).toString()

Mobile.setText(findTestObject('12 Agent Profile/android.widget.EditText - about'), newAbout, 0)
Mobile.hideKeyboard()

Mobile.tap(findTestObject('12 Agent Profile/android.widget.TextView - Confirm'), 0)

Mobile.waitForElementPresent(findTestObject('12 Agent Profile/android.widget.TextView - Ok'), 30)
Mobile.tap(findTestObject('12 Agent Profile/android.widget.TextView - Ok'), 0)

agentDB = WS.sendRequest(findTestObject('12 Agent Profile/AgentDB'))
def slurper = new groovy.json.JsonSlurper()
def result = slurper.parseText(agentDB.getResponseBodyContent())
def about = result.about

assert about == newAbout

Mobile.tap(findTestObject('12 Agent Profile/android.widget.TextView - back'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:])

