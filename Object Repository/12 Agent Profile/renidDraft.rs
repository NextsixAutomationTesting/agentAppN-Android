<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>renidDraft</name>
   <tag></tag>
   <elementGuidId>7201518e-14c1-4c05-a82b-bbc74994b4bd</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n      \&quot;dataSource\&quot;: \&quot;ClusterSIT\&quot;,\n      \&quot;database\&quot;: \&quot;trrappdb\&quot;,\n      \&quot;collection\&quot;: \&quot;roledrafts\&quot;,\n      \&quot;filter\&quot;:{\n          \&quot;agent\&quot;:{\&quot;$oid\&quot;:\&quot;6554159b68995716dc360d7f\&quot;},\n          \&quot;status\&quot;:\&quot;Pending\&quot;\n          },\n  \t  \&quot;sort\&quot;:{\n        \&quot;created\&quot;:-1\n      },\n  \t  \&quot;limit\&quot;:1\n}\n&quot;,
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
      <webElementGuid>1aa394c8-6d5f-449a-98f4-d1d3c612e225</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api-key</name>
      <type>Main</type>
      <value>AKAFnW5WgyyOq3F3S2lVPcRhZr12qxZTTPjz0Llu1myg9jUSNjaVaGih51BZ8n60</value>
      <webElementGuid>496b4e5c-844c-4a8d-88d0-cf703e58e2b6</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.2.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://data.mongodb-api.com/app/data-nnnyp/endpoint/data/beta/action/find</restUrl>
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
