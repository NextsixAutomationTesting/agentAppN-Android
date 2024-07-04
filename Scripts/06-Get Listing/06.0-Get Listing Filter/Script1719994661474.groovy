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

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Get Listing'), 0)

Mobile.waitForElementPresent(findTestObject('06 Get Listing/android.widget.EditText - Search Listing'), 30)

agentD = WS.sendRequest(findTestObject('Object Repository/06 Get Listing/agentD'))

def slurper = new JsonSlurper()

def result = slurper.parseText(agentD.getResponseBodyContent())

String plottedState = result.documents[0].plottedState

Mobile.waitForElementPresent(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Kuchai Lama,Wilayah Persekutuan Kuala Lumpur'), 30)
String filterState = Mobile.getText(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Kuchai Lama,Wilayah Persekutuan Kuala Lumpur'), 5)

if (!filterState.contains(plottedState))
{
	KeywordUtil.markFailed("Get Listing Not Filtered According to Plotted State")
}

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Filter'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(500,360)

Mobile.delay(1)
Mobile.tapAtPosition(520,500)

Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - Select'), 0)

String filterS = Mobile.getText(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Kelantan (1)'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(300,2200)

String filterState1 = Mobile.getText(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Kuchai Lama,Wilayah Persekutuan Kuala Lumpur'), 5)
if (!filterState1.contains(filterS))
{
	KeywordUtil.markFailed("Get Listing Not Filtered According to Selected State Filter (Co-Broke)")
}

Mobile.tap(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Enquiry'), 5)
String filterState2 = Mobile.getText(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Ayer Baloi,Johor'), 0)
if (!filterState2.contains(filterS))
	{
		KeywordUtil.markFailed("Get Listing Not Filtered According to Selected State Filter (Enquiry)")
	}

Mobile.tap(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Owner (Sale)'),5)	
String filterState3 = Mobile.getText(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Puteri Harbour,Johor'), 0)
if (!filterState3.contains(filterS))
	{
		KeywordUtil.markFailed("Get Listing Not Filtered According to Selected State Filter (Owner Sale)")
	}
	
Mobile.tap(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Owner (Rent)'),5)
String filterState4 = Mobile.getText(findTestObject('Object Repository/06 Get Listing/android.widget.TextView - Ayer Hitam,Johor'), 0)
if (!filterState4.contains(filterS))
	{
		KeywordUtil.markFailed("Get Listing Not Filtered According to Selected State Filter (Owner Sale)")
	}
	
Mobile.tap(findTestObject('06 Get Listing/android.widget.TextView - back listing'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:])
	
	