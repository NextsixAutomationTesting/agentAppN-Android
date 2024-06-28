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

'Verify previous file in Album'
String adbCmd = 'adb shell ls -lt /sdcard/DCIM'

Process proc = Runtime.getRuntime().exec(adbCmd)

proc.waitFor(5, TimeUnit.SECONDS)

def outp = proc.inputStream.text

List<String> line = outp.tokenize('\n')

String[] token = (line[1]).tokenize()

String previousFile = ''

if ((token[-2]).contains('downloadedFile')) {
    previousFile = (token[(-2..-1)]).join(' ')
} else {
    previousFile = (token[-1])
}

//Execute ADB command to get the downloaded path list
Mobile.tapAtPosition(530, 1530)

Mobile.tap(findTestObject('EAS/02 E Business Card/android.widget.TextView - Download'), 0)

WebUI.callTestCase(findTestCase('PermissionPopup'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

'Verify whether ecard downloaded in Album'
String adbCommand = 'adb shell ls -lt /sdcard/DCIM'

Process process = Runtime.getRuntime().exec(adbCommand)

process.waitFor(5, TimeUnit.SECONDS)

def output = process.inputStream.text

//Split the output by newlines to get individual file entries
List<String> lines = output.tokenize('\n')

//Extract the latest file path from the list of the output
String[] tokens = (lines[1]).tokenize()

//Join last 2 tokens as the filename has space in between
String latestFile = ''

if (!tokens[-1].contains('downloadedFile')) {
    latestFile = (tokens[(-2..-1)]).join(' ')
} else {
    latestFile = (tokens[-1])
}

if (!previousFile.contains('downloadedFile')) {
    assert latestFile == 'downloadedFile.png'
} else if (previousFile == 'downloadedFile.png') {
    assert latestFile == 'downloadedFile (1).png'
} else {
    String lastToken = (token[-1]).replaceAll('[()]', '').replaceAll('.png', '')

    def filenameNumbers = lastToken.findAll('\\d+').collect({ it.toInteger()}).first()

    int fileNumbers = filenameNumbers + 1

    assert latestFile == ('downloadedFile (' + fileNumbers + ').png')
}

Mobile.delay(1)

