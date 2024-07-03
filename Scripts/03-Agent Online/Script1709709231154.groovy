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

WebUI.callTestCase(findTestCase('0-GENERAL/Login - TRR (Wilson)'), [:])

float lati = 4.60165445912618
float longi = 101.11034798360426
String state = 'Perak'
String area = 'Ipoh'

WS.sendRequest(findTestObject('03 Agent Online/AgentPlot', [('lati') : lati, ('longi') : longi, ('state') : state
            , ('area') : area]))

Mobile.delay(2)
Mobile.tapAtPosition(970,140)

'If agent (current GPS) not in plotted area'
Mobile.verifyElementExist(findTestObject('03 Agent Online/android.view.ViewGroup - not in area'), 0)

Mobile.tap(findTestObject('03 Agent Online/android.view.ViewGroup - not in area'), 0)

lati = 3.0852849928088357
longi = 101.6924844179576
state = 'Wilayah Persekutuan Kuala Lumpur'
area = 'Kuchai Lama'

WS.sendRequest(findTestObject('03 Agent Online/AgentPlot', [('lati') : lati, ('longi') : longi, ('state') : state
            , ('area') : area]))

Mobile.delay(2)
Mobile.tapAtPosition(970,140)

'If agent (current GPS) in plotted area'
Mobile.verifyElementNotExist(findTestObject('03 Agent Online/android.view.ViewGroup - not in area'), 2)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:])

