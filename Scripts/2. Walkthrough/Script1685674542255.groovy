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

Mobile.setText(findTestObject('null'), 'robin', 0)

Mobile.setText(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.EditText - Password'), '123456', 0)

'tick agreement'
Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView -'), 0)

'click Sign in '
Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Sign In'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Welcome to'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.ImageView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Accelerate your business growth  get seen by potential customers with GPSYourAgent'), 
    0)

'Click Let get started'
Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Lets Get Started'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Heres an overview of your account'), 
    0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Kick Starter Pack (Free)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Add new property listing here'), 
    0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Add Property'), 0)

//Mobile.verifyElementExist(findTestObject('Object Repository/2. Walkthrough/android.widget.TextView - Change your nickname & bio introduction here'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Edit Profile'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.ImageView (1)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Access available tutorials and guides'), 
    0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.ImageView (2)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Click here for any appointment request from customers'), 
    0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.ImageView (3)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Any inbound message can be accessed here'), 
    0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.ImageView (4)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Lastly, turn ONLINE to stay active and ahead of competition'), 
    0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.view.ViewGroup'), 0)

Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Update Now'), 0)

'click back button'
Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - (1)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Agent Dashboard'), 
    0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Activities'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - iProforma'), 0)

'click account tab'
Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.ImageView (5)'), 0)

'click log out button'
Mobile.tap(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.ImageView (6)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/SDK44/2. Walkthrough/android.widget.TextView - Welcome Back Agent,'), 
    0)

WS.sendRequest(findTestObject('SDK44/2. Walkthrough/Reset Walkthrough'))

