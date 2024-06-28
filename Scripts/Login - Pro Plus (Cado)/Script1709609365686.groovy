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

Mobile.waitForElementPresent(findTestObject('Object Repository/EAS/android.widget.EditText - UsernameEmail Address'), 30, 
    FailureHandling.OPTIONAL)

Mobile.setText(findTestObject('Object Repository/EAS/android.widget.EditText - UsernameEmail Address'), 'cado', 0)

Mobile.setEncryptedText(findTestObject('Object Repository/EAS/android.widget.EditText - Password'), '75N1G81rm4Q=', 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('EAS/android.view.ViewGroup - sign in button'), 0)

Mobile.tap(findTestObject('EAS/android.view.ViewGroup - agree login'), 0)

if (Mobile.verifyElementVisible(findTestObject('EAS/android.widget.TextView - outdate prop'), 5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('EAS/android.widget.TextView - outdate prop'), 0)
}

