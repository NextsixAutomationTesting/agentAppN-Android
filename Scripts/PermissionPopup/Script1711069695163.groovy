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

//music and audio permission
musicAudio = Mobile.verifyElementVisible(findTestObject('EAS/android.widget.TextView - Allow NextSix Agent to access music and audio on this device'),2, FailureHandling.OPTIONAL)
if (musicAudio == true) {
    Mobile.tap(findTestObject('EAS/android.widget.Button - Allow'), 0)
}

//photo and video permission
photoVideo = Mobile.verifyElementVisible(findTestObject('EAS/android.widget.TextView - Allow NextSix Agent to access photos and videos on this device'), 2, FailureHandling.OPTIONAL)
if (photoVideo == true) {
    Mobile.tap(findTestObject('EAS/android.widget.Button - Allow (1)'), 0)
}

//camera permission
camera = Mobile.verifyElementVisible(findTestObject('EAS/android.widget.TextView - Allow NextSix Agent to take pictures and record video'), 2, FailureHandling.OPTIONAL)
if (camera == true) {
    Mobile.tap(findTestObject('EAS/android.widget.Button - While using the app'), 0)
}

