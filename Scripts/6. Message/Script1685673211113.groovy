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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

// Get the current date and time
LocalDateTime currentDateTime = LocalDateTime.now()

// Define the desired format
DateTimeFormatter formatter = DateTimeFormatter.ofPattern('HH:mm:ss dd-MM-yyyy')

// Format the date and time
String createdDate = currentDateTime.format(formatter)

// Format the updated date and time to the desired format
String timestamp = currentDateTime.format(formatter)

println(timestamp)

UserSendMessage = WS.sendRequest(findTestObject('SDK44/6. Message/user send message', [('timestamp') : timestamp]), FailureHandling.STOP_ON_FAILURE)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(UserSendMessage.getResponseBodyContent())

def content = result.content

KeywordUtil.logInfo(content)

Mobile.startApplication('C:\\Users\\Nextsix\\git\\agentTesterSDK49.apk', true)

Mobile.setText(findTestObject('SDK44/6. Message/android.widget.EditText - UsernameEmail Address'), 'yuvi', 0)

Mobile.setText(findTestObject('Object Repository/SDK44/6. Message/android.widget.EditText - Password'), '123456', 0)

'tick sign in agreement '
Mobile.tap(findTestObject('Object Repository/SDK44/6. Message/android.widget.TextView -'), 0)

'click sign in button'
Mobile.tap(findTestObject('Object Repository/SDK44/6. Message/android.widget.TextView - Sign In'), 0)

'click not now button'
Mobile.tap(findTestObject('Object Repository/SDK44/6. Message/android.widget.TextView - Not Now'), 0)

'Verify message notification'
Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/6. Message/android.widget.TextView - 1'), 0)

'Click message tab'
Mobile.tap(findTestObject('Object Repository/SDK44/6. Message/android.widget.ImageView'), 0)

'Click Peter Message'
Mobile.tap(findTestObject('Object Repository/SDK44/6. Message/android.widget.TextView - Peter'), 0)

String expectedContent = content

String actualContent = Mobile.getText(findTestObject('SDK44/6. Message/android.widget.TextView - Hello again Yuvi 093700 22-06-2023', 
        [('expectedContent') : expectedContent]), 0)

Mobile.verifyMatch(actualContent, expectedContent, true)

Mobile.setText(findTestObject('Object Repository/SDK44/6. Message/android.widget.EditText - Type a message'), 'Hello Peter!', 
    0)

'Click Send Message'
Mobile.tap(findTestObject('Object Repository/SDK44/6. Message/android.widget.TextView - Send'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/6. Message/android.widget.TextView - Thanks for contacting me (1)'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/6. Message/android.widget.TextView - Send (1)'), 0)

