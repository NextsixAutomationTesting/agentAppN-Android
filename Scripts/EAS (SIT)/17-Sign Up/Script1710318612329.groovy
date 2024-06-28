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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Mobile.callTestCase(findTestCase('Open Agent App'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Object Repository/EAS/android.widget.EditText - UsernameEmail Address'), 30, 
    FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('EAS/17 Agent Apply/android.widget.TextView - Sign Up'), 0)

Mobile.tap(findTestObject('EAS/17 Agent Apply/android.widget.TextView - Choose This Package'), 0)

fakeAgent = WS.sendRequest(findTestObject('EAS/17 Agent Apply/fakeAgent'))

def slurper = new JsonSlurper()

def result = slurper.parseText(fakeAgent.getResponseBodyContent())

String fullName = result.address.Full_Name + ' Test'

String email = result.address.Temporary_mail

String phoneNo = result.address.Telephone

String phoneNum = phoneNo.substring(3).replaceAll('[\\s+]', '')

println(phoneNum)

Mobile.setText(findTestObject('EAS/17 Agent Apply/android.widget.EditText - Full Name'), fullName, 0)

Mobile.setText(findTestObject('EAS/17 Agent Apply/android.widget.EditText - Email'), email, 0)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('EAS/17 Agent Apply/android.widget.EditText - Phone Number'), phoneNum, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('EAS/17 Agent Apply/android.widget.TextView - Submit'), 0)

Mobile.verifyElementVisible(findTestObject('EAS/17 Agent Apply/android.widget.TextView - Ok'), 5)

Mobile.tap(findTestObject('EAS/17 Agent Apply/android.widget.TextView - Ok'), 0)

latestAgent = WS.sendRequest(findTestObject('EAS/17 Agent Apply/latestAgent',[('email'):email]))

def result1 = slurper.parseText(latestAgent.getResponseBodyContent())

applyID = result1.documents[0]._id

if (applyID == null)
{
	KeywordUtil.markFailedAndStop("id not exist")
}
