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


//test
Mobile.startApplication('C:\\Users\\Nextsix\\git\\agentTesterSDK49.apk', true)

Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - UsernameEmail Address'), 
    'yuvi', 0)

Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Password'), '123456', 
    0)

'tick agreement \r\n\r\n'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView -'), 0)

'Click log in button\r\n'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Sign In'), 0)

'Click Add Property'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Add Property'), 0)

'Enhance it to scroll to the element \r\n'
Mobile.scrollToText('Highlight', FailureHandling.STOP_ON_FAILURE)

'Click Property Category'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Property Category'), 
    0)

'Click Terrace/Link/Townhouse\r\n'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - TerraceLinkTownhouse'), 
    0)

'Click Property Type'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Property Type'), 0)

'Click 2-sty Terrace/Link House'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - 2-sty TerraceLink House'), 
    0)

'Fill in Property Name'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Property Name'), 
    'Test Terrace Link House', 0)

'Fill in Highlight\r\n'
Mobile.setText(findTestObject('SDK44/4. Create Property For Sale/android.widget.EditText - Highlight'), 'Test Highlight', 0)

'Click Next button'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Next'), 0)

'Fill in Address Line 1\r\n'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Address Line 1'), 
    'Address Line 1', 0)

'Fill in Address Line 2\r\n'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Address Line 2'), 
    'Address Line 2', 0)

'Fill in City/Town\r\n'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - City or Town'), 'Kuchai Lama', 
    0)

'Fill in Postcode\r\n'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Postcode'), '58200', 
    0)

'Click State'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - State'), 0)

'Choose Wilayah Persekutuan Kuala Lumpur'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Wilayah Persekutuan Kuala Lumpur'), 
    0)

'Make it scroll to element'
Mobile.scrollToText('Land Area(sq.ft)', FailureHandling.STOP_ON_FAILURE)

'Click Area'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Area'), 0)

'Click Ampang Hilir ** make it scroll to Kuchai Lama'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Ampang Hilir'), 0)

'Fill in Buying price **Make it random number\r\n'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Buying Price'), '560000', 
    0)

'Fill in Build-Up Size ** make it random'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Build-up Size(sq.ft)'), 
    '2500', 0)

'Fill in Land Area **make it random'
Mobile.setText(findTestObject('SDK44/4. Create Property For Sale/android.widget.EditText - Land Area(sq.ft)'), '2600', 0)

'Click Next button'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Next (1)'), 0)

'Click Tenure'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Tenure'), 0)

'Click Leaase Tenancy'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Lease Tenancy'), 0)

'Click Title Type'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Title Type'), 0)

'Click Individual'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Individual'), 0)

'Click Land Title'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Land Title Type'), 0)

'Click Residential'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Residential'), 0)

'Click Residential'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Direction'), 0)

'Click East'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - East'), 0)

'Click Occupied'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Occupied'), 0)

'Click Tenanted'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Tenanted'), 0)

'Clikc Unit Type'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Unit Type'), 0)

'Click Intermediate'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Intermediate'), 0)

'Tap Furnishing'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Furnishing'), 0)

'Click Partly Furnished'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Partly Furnished'), 0)

'Click Bedrooms'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Bedrooms'), 0)

'Choose 1 bedroom'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - 1'), 0)

'Make it Scroll to element'
Mobile.scrollToText('Description', FailureHandling.STOP_ON_FAILURE)

'Click no. of bathroom'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Number of Bathrooms'), 
    0)

'Click 3 bathroom'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - 3'), 0)

'Click no of Car Park'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Number of Car Parks'), 
    0)

'Click 3 car park'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - 3 (1)'), 0)

'Fill in description'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Description (1)'), 
    'Test Description', 0)

//'Tap Select All Facilities'
//Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - (1)'), 0)
'Click Next button'
Mobile.tap(findTestObject('SDK44/4. Create Property For Sale/android.widget.TextView - Next (1)'), 0)

'Tap Congfiguration'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Configure'), 0)

Mobile.verifyElementText(findTestObject('SDK44/4. Create Property For Sale/android.widget.TextView - Nickname'), 'Nickname')

Mobile.verifyElementText(findTestObject('SDK44/4. Create Property For Sale/android.widget.TextView - Configuration'), 'Configuration')

Mobile.verifyElementText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Do you wish to confirm the'), 
    'Do you wish to confirm the')

Mobile.verifyElementText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - nickname (1)'), 
    'nickname?')

'click Yes button'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Yes'), 0)

'Clik Upload button'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Upload'), 0)

'Click choose mutliple photo'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Choose Multiple Photo'), 
    0)

'Click Download'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Download'), 0)

'Click photo 1'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.ImageView (4)'), 0)

'Click photo 2'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.ImageView (5)'), 0)

'Click photo 3'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.ImageView'), 0)

'Click photo 4'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.ImageView (1)'), 0)

'Click photo 5'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.ImageView (2)'), 0)

'Click photo 6'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.ImageView (3)'), 0)

Mobile.verifyElementText(findTestObject('SDK44/4. Create Property For Sale/android.widget.TextView - Selected 6 images'), 'Selected 6 images')

'Click Save button'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - SAVE'), 0)

'make it Scroll to element'
Mobile.scrollToText('Virtual Reality (VR) Link', FailureHandling.STOP_ON_FAILURE)

'Fill in Video Link'
Mobile.setText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.EditText - Video Link'), 'https://www.youtube.com/watch?v=1yurLJk16rs', 
    0)

'Fill in VR link '
Mobile.setText(findTestObject('SDK44/4. Create Property For Sale/android.widget.EditText - Virtual Reality (VR) Link'), 'https://my.matterport.com/show/?m=3f84HHk123e&play=1&brand=0', 
    0)

'Click Publish button'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Publish'), 0)

Mobile.verifyElementText(findTestObject('SDK44/4. Create Property For Sale/android.widget.TextView - Do you wish to publish this'), 
    'Do you wish to publish this')

Mobile.verifyElementText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - property'), 
    'property?')

'Click Yes button'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Yes (1)'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - Do you want to share your new'), 
    'Do you want to share your new')

Mobile.verifyElementText(findTestObject('SDK44/4. Create Property For Sale/android.widget.TextView - property'), 'property?')

'Click No button'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - No'), 0)

'Make it scroll to text'
Mobile.scrollToText('Get My Referrals', FailureHandling.STOP_ON_FAILURE)

'Click My Property'
Mobile.tap(findTestObject('Object Repository/SDK44/4. Create Property For Sale/android.widget.TextView - My Property'), 0)

'Verify Property name successfully created'
Mobile.verifyElementText(findTestObject('SDK44/4. Create Property For Sale/android.widget.TextView - Test Terrace Link House'), 
    'Test Terrace Link House')

Mobile.closeApplication()

