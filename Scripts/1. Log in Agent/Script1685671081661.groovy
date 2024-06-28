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

Mobile.startApplication('C:\\Users\\Nextsix\\git\\agentTesterSDK49.apk', true)

Mobile.setText(findTestObject('Object Repository/SDK44/1. login in agent NEW/android.widget.EditText - UsernameEmail Address'), 'bio', 
    0)

Mobile.setText(findTestObject('Object Repository/SDK44/1. login in agent NEW/android.widget.EditText - Password'), '123456', 0)

Mobile.tap(findTestObject('Object Repository/SDK44/1. login in agent NEW/android.widget.TextView -'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/1. login in agent NEW/android.widget.TextView - Sign In'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/1. login in agent NEW/android.widget.TextView - Not Now'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/1. login in agent NEW/android.widget.TextView - Account'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/1. login in agent NEW/android.widget.ImageView'), 0)

Mobile.closeApplication()

