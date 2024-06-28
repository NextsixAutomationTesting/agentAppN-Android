<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>newEnquiry</name>
   <tag></tag>
   <elementGuidId>7c5ac0a5-949c-4b0b-b757-12b0e5743932</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;user\&quot;: \&quot;64e328a23af351004ec321fc\&quot;,\n  \&quot;merchant\&quot;: \&quot;655463439d5ac3005056cf81\&quot;,\n  \&quot;agent\&quot;: \&quot;6554159b68995716dc360d7f\&quot;,\n  \&quot;property\&quot;: \n  {\n    \&quot;address\&quot; : \&quot;No 2, Jalan Kuraman\&quot; ,\n\t\&quot;state\&quot; : \&quot;Wilayah Persekutuan Kuala Lumpur\&quot;,\n\t\&quot;area\&quot; : \&quot;Setapak\&quot;\n   },\n\n   \&quot;typeOfService\&quot;: [\&quot;Hire Purchase Loan\&quot; , \&quot;Mortgage Loan\&quot;], \n\n   \&quot;commencementDate\&quot;: \&quot;${comDate}\&quot;,\n   \&quot;note\&quot;: \&quot;${enqNote}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>d7bebb25-17ff-4b1b-95c1-6540bfad08f8</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.2.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://sit-apps.nextsix.com/serviceMerchant/enquiries/create</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
