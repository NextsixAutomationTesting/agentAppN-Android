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

Mobile.tap(findTestObject('14 Announcement/android.widget.TextView - Message'), 0)

Mobile.tap(findTestObject('14 Announcement/android.widget.TextView - Announcement'), 0)

Mobile.tap(findTestObject('14 Announcement/android.view.ViewGroup - first announcement'), 0)

annoTitle = Mobile.getText(findTestObject('14 Announcement/android.widget.TextView - title'), 0)

annoContent = Mobile.getText(findTestObject('14 Announcement/android.widget.TextView - content'), 0)

announcementLog = WS.sendRequest(findTestObject('14 Announcement/announcementLog'))

def sluper = new groovy.json.JsonSlurper()

def result = sluper.parseText(announcementLog.getResponseBodyContent())

String title = result.documents[0].title

String content = result.documents[0].content

assert title == annoTitle

assert content == annoContent

Mobile.tap(findTestObject('14 Announcement/android.widget.TextView - back'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

