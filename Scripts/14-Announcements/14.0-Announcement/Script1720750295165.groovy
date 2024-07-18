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
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:])

LocalDateTime nowMyt = LocalDateTime.now()
LocalDateTime apiTime = nowMyt.minusHours(8)
LocalDateTime announceTime = apiTime.plusSeconds(1)

DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'')
String createTime = apiTime.format(dateFormat)
String scheduleTime = announceTime.format(dateFormat)

String contentCreate = 'Automation Test Announcement {{Agent Name}} on '+ nowMyt

WS.sendRequest(findTestObject('Object Repository/14 Announcement/announcementCreate', [('createTime') : createTime, ('scheduleTime') : scheduleTime,('contentCreate') : contentCreate ]))

Mobile.tap(findTestObject('Object Repository/14 Announcement/android.widget.TextView - Notification'), 0)

Mobile.delay(1)
Mobile.tapAtPosition(550,650)

annoTitle = Mobile.getText(findTestObject('Object Repository/14 Announcement/android.widget.TextView - title (1)'), 0)
annoContent = Mobile.getText(findTestObject('Object Repository/14 Announcement/android.widget.TextView - content (1)'), 0)

announcementLog = WS.sendRequest(findTestObject('14 Announcement/announcementLog'))
def sluper = new groovy.json.JsonSlurper()
def result = sluper.parseText(announcementLog.getResponseBodyContent())
String title = result.documents[0].title
String content = result.documents[0].content

assert title == annoTitle
assert content == annoContent

Mobile.tap(findTestObject('14 Announcement/android.widget.TextView - back'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/Logout'), [:])

