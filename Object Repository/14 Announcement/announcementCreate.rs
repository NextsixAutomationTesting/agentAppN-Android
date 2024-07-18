<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>announcementCreate</name>
   <tag></tag>
   <elementGuidId>3c3a437d-e981-49b1-a01f-7649299778d9</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;creator\&quot;: {\n        \&quot;admin\&quot;: \&quot;6535c94d03346a005021986a\&quot;,\n        \&quot;name\&quot;: \&quot;ying hui\&quot;\n    },\n    \&quot;_id\&quot;: \&quot;668364f724fa59004ef710ea\&quot;,\n    \&quot;content\&quot;: \&quot;${contentCreate}\&quot;,\n    \&quot;created\&quot;: \&quot;${createTime}\&quot;,\n    \&quot;groupType\&quot;: \&quot;System\&quot;,\n    \&quot;schedule\&quot;: \&quot;${scheduleTime}\&quot;,\n    \&quot;status\&quot;: \&quot;New\&quot;,\n    \&quot;systemGroup\&quot;: \&quot;605c53271342db002f1796de\&quot;,\n    \&quot;targetGroup\&quot;: \&quot;Agent\&quot;,\n    \&quot;title\&quot;: \&quot;test\&quot;,\n    \&quot;version\&quot;: 1\n}&quot;,
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
      <webElementGuid>593d2f5a-b727-4567-b902-4572a451ec14</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.5.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://sit-host.nextsix.com/announcements/save</restUrl>
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
