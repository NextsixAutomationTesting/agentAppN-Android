<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>completeEnquiry</name>
   <tag></tag>
   <elementGuidId>8378646e-9510-4c38-977c-f002827ea80b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;_id\&quot;: \&quot;${enquiryId}\&quot;,\n  \&quot;status\&quot;: \&quot;Completed\&quot;,\n  \&quot;clientAttachment\&quot;: {\n    \&quot;files\&quot;: [],\n\t\&quot;images\&quot;: []\n  },\n  \&quot;referral\&quot;: {\n    \&quot;amount\&quot;: \&quot;${referAmount}\&quot;,\n    \&quot;attachment\&quot;: {\n      \&quot;files\&quot;: [\n        {\n        \&quot;name\&quot;: \&quot;6ca25d7f-115c-4194-b58e-949485dd1383.pdf\&quot;,\n        \&quot;size\&quot;: 35295,\n        \&quot;url\&quot;: \&quot;https://iprofstore.blob.core.windows.net/files/test/servicemerchants/65e7dcc2feed680065ff37d9/referral/8eef8aba-add4-4712-ae13-e5ad3353f419.pdf\&quot;\n      }\n      ],\n\t \&quot;images\&quot;: []\n    }\n  }\n}&quot;,
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
      <webElementGuid>24f6adf2-9ec2-4645-9f0d-51b53bfa429c</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.2.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://sit-apps.nextsix.com/serviceMerchant/enquiries/markAsComplete</restUrl>
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
