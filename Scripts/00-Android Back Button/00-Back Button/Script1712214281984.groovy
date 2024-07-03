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
import java.time.Duration as Duration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.TouchAction as TouchAction
import io.appium.java_client.touch.offset.PointOption as PointOption
import io.appium.java_client.touch.WaitOptions as WaitOptions

Mobile.callTestCase(findTestCase('0-GENERAL/Open Agent App'), [:])

Mobile.delay(2)

Mobile.tapAtPosition(880, 1500)

Mobile.delay(2)

Mobile.pressBack()

Mobile.delay(2)

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Sign Up'), 0)

Mobile.pressBack()

float lati = 4.60165445912618

float longi = 101.11034798360426

String state = 'Perak'

String area = 'Ipoh'

WS.sendRequest(findTestObject('00 Back Button/AgentPlotting', [('lati') : lati, ('longi') : longi, ('state') : state
            , ('area') : area]))

Mobile.callTestCase(findTestCase('0-GENERAL/Login - Pro Plus (Cado)'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('00 Back Button/android.view.ViewGroup - online'), 0)

Mobile.pressBack()

Mobile.delay(1)

onlineClose = Mobile.verifyElementExist(findTestObject('00 Back Button/android.widget.TextView - Got it'), 0, FailureHandling.OPTIONAL)

if (onlineClose == true) {
    Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Got it'), 0)

    KeywordUtil.markFailed('Agent online not in area prompt back button')
}

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Add Property'), 0)

Mobile.callTestCase(findTestCase('0-GENERAL/PermissionPopup'), [:])

Mobile.pressBack()

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Edit Profile'), 0)

Mobile.pressBack()

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Submit Ren ID'), 0)

Mobile.pressBack()

Mobile.delay(1)

Mobile.callTestCase(findTestCase('00-Android Back Button/00.1-iProforma Back (sub)'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(1)

Mobile.callTestCase(findTestCase('00-Android Back Button/00.2-My Property Back (sub)'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(1)

Mobile.callTestCase(findTestCase('00-Android Back Button/00.3-Get Listing Back (sub)'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(1)

Mobile.tap(findTestObject('09 Master Properties/android.widget.TextView - Master Property'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(535, 580)

Mobile.pressBack()

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Pending'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(535, 580)

Mobile.pressBack()

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Rejected'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(535, 580)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('09 Master Properties/android.widget.TextView - create'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('13 Academy/android.widget.TextView - Academy'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(535, 580)

Mobile.delay(1)

Mobile.pressBack()

Mobile.tap(findTestObject('13 Academy/android.widget.TextView - Assessment'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(535, 580)

Mobile.delay(1)

Mobile.tap(findTestObject('13 Academy/android.widget.TextView - Take Test'), 0)

Mobile.tap(findTestObject('13 Academy/android.widget.TextView - Yes'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.pressBack()

Mobile.pressBack()

Mobile.scrollToText('Get My Referrals', FailureHandling.STOP_ON_FAILURE)

Mobile.delay(1)

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Ai Matching'), 0)

Mobile.delay(3)

Mobile.pressBack()

Mobile.delay(1)

AIpopup = Mobile.verifyElementExist(findTestObject('00 Back Button/android.widget.TextView - AI Got It'), 0, FailureHandling.OPTIONAL)

if (AIpopup == true) {
    Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - AI Got It'), 0)

    KeywordUtil.markFailed('AiMatching popup back button')
}

Mobile.delay(1)

Mobile.pressBack()

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Meeting Room'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - ADD'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - branch'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - HQ Branch'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Select'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Search'), 0)

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Book Now'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

bookMeetingRoom = Mobile.verifyElementExist(findTestObject('08 Meeting Room/android.widget.EditText - Meeting Title'), 
    0, FailureHandling.OPTIONAL)

if (bookMeetingRoom == true) {
    Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - Cancel'), 0)

    KeywordUtil.markFailed('Booking meeting room popup back button')
}

Mobile.delay(1)

Mobile.pressBack()

Mobile.pressBack()

Mobile.tap(findTestObject('08 Meeting Room/android.widget.TextView - Cancelled'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(535, 535)

Mobile.delay(1)

Mobile.pressBack()

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - DeveloperProject'), 0)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - search'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - FILTER'), 0)

Mobile.pressBack()

Mobile.delay(1)

devFilter = Mobile.verifyElementExist(findTestObject('11 Developer Project/android.widget.TextView - Ok'), 0, FailureHandling.OPTIONAL)

if (devFilter == true) {
    Mobile.tap(findTestObject('11 Developer Project/android.widget.TextView - Ok'), 0)

    KeywordUtil.markFailed('developer project filter back button')
}

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - SORT'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tapAtPosition(535, 535)

Mobile.delay(1)

Mobile.tapAtPosition(535, 535)

Mobile.delay(1)

Mobile.pressBack()

Mobile.pressBack()

Mobile.tap(findTestObject('11 Developer Project/android.widget.ImageView - map'), 0)

Mobile.waitForElementPresent(findTestObject('11 Developer Project/android.widget.RelativeLayout - map'), 0)

Mobile.pressBack()

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('00 Back Button/android.widget.TextView - More'), 0)

Mobile.tap(findTestObject('Object Repository/00 Back Button/android.widget.TextView - The Will'), 0)

Mobile.delay(1)

Mobile.waitForElementPresent(findTestObject('Object Repository/00 Back Button/android.widget.TextView - The Will (1)'), 10)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(2)

willClose = Mobile.verifyElementExist(findTestObject('Object Repository/00 Back Button/android.widget.TextView - Will Exit'), 
    0, FailureHandling.OPTIONAL)

if (willClose == true) {
    Mobile.tap(findTestObject('Object Repository/00 Back Button/android.widget.TextView - Will Exit'), 0)
} else {
    KeywordUtil.markFailed('the will page back button')

    Mobile.tap(findTestObject('Object Repository/00 Back Button/android.widget.TextView - x the will'), 0)
}

Mobile.callTestCase(findTestCase('00-Android Back Button/00.4-Home Pro (sub)'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/02 E Business Card/android.widget.TextView - Account'), 1)

Mobile.delay(1)

Mobile.tapAtPosition(240, 1200)

Mobile.delay(1)

Mobile.pressBack()

Mobile.tap(findTestObject('05 Message/android.widget.TextView - Message'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(540, 840)

Mobile.delay(3)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/00 Back Button/android.widget.TextView - Co-Broke'), 0)

Mobile.delay(1)

Mobile.tapAtPosition(540, 840)

Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/00 Back Button/android.widget.ImageView - cobroke listing'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.pressBack()

Mobile.tap(findTestObject('14 Announcement/android.widget.TextView - Announcement'), 0)

Mobile.tap(findTestObject('14 Announcement/android.view.ViewGroup - first announcement'), 0)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/02 E Business Card/android.widget.TextView - Account'), 1)

Mobile.delay(1)

Mobile.tapAtPosition(330, 860)

Mobile.delay(1)

Mobile.tapAtPosition(530, 1530)

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tapAtPosition(960, 170)

