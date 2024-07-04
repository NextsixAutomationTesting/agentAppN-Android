import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import com.kms.katalon.core.mobile.helper.MobileScreenCaptor
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver

class AgentAppListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	
	private void openApp()
	{
	Mobile.startExistingApplication("com.nextsix.proforma", FailureHandling.STOP_ON_FAILURE)
	
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/android.widget.Button - While using the app (1)'), 8, FailureHandling.OPTIONAL))
		{
			Mobile.tap(findTestObject('Object Repository/android.widget.Button - While using the app (1)'),5)
		
			Mobile.waitForElementPresent(findTestObject('Object Repository/android.widget.Button - Allow (2)'), 5)
			Mobile.tap(findTestObject('Object Repository/android.widget.Button - Allow (2)'),5)
		
		}
	}
	
	@BeforeTestCase
	def beforeCase(TestCaseContext testCaseContext) 
	{
		openApp()
	}
	
	private void closeApp()
	{
		Mobile.closeApplication()
	}
	
	private void clearAppDataAndCloseApp() 
	{
        AppiumDriver driver = MobileDriverFactory.getDriver()
		
		// Close the app
		driver.terminateApp("com.nextsix.proforma")
		
		// Clear app data
		String adbCommand = "adb shell pm clear com.nextsix.proforma"
		Runtime.getRuntime().exec(adbCommand)
    }
	
	
	/**REMEMBER TO COM OUT WHEN RUNNING TEST SUITE**/
	/*
	@AfterTestCase
	def ifFailed(TestCaseContext testCaseContext)
	{
		if (!testCaseContext.getTestCaseStatus().equals("PASSED"))
		{
			Mobile.delay(1)
			clearAppDataAndCloseApp()
			//openApp()
		}
		else if (testCaseContext.getTestCaseStatus().equals("PASSED"))
		{
			closeApp()
		}
	} */
}