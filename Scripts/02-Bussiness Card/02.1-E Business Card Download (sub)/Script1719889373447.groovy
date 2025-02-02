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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.RemoteWebElement as RemoteWebElement
import java.util.concurrent.TimeUnit as TimeUnit
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

Mobile.delay(1)
Mobile.tapAtPosition(530, 1530)

Mobile.delay(1)
Mobile.tapAtPosition(700,1450)

Mobile.delay(1)
WebUI.callTestCase(findTestCase('0-GENERAL/PermissionPopup'), [:])

Mobile.delay(1)
Mobile.pressBack()

'Verify whether ecard downloaded in Album'
def nowTime = new Date()

String adbCommand = 'adb shell ls -lt /sdcard/DCIM'

Process process = Runtime.getRuntime().exec(adbCommand)

process.waitFor(5, TimeUnit.SECONDS)

def output = process.inputStream.text

//Tokenize the list and get the first file (latest downloaded file)
List<String> lines = output.tokenize('\n')

String[] tokens = (lines[1]).tokenize()

//Get downloadTime and fileType from the latest file
String downloadTime = (tokens[(5..6)]).join(' ')

println(downloadTime)

String fileName = tokens[-1]

def fileType = fileName.tokenize('.')[-1]

//Get difference within downloadTime and currentTime
def dateFormat = new SimpleDateFormat('yyyy-MM-dd HH:mm')

def downloadTimeFormat = dateFormat.parse(downloadTime)

def differenceTime = (nowTime.time - downloadTimeFormat.time) / 1000

println(differenceTime)

//Assert differenceTime is within 3 mins and fileType is pdf
assert differenceTime < 180

assert fileType == 'png'
