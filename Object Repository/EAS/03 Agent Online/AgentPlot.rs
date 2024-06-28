<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>AgentPlot</name>
   <tag></tag>
   <elementGuidId>1b183724-dd23-4f64-8c3e-79aafd5704bc</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;location\&quot;: {\n        \&quot;latitude\&quot;: ${lati},\n        \&quot;longitude\&quot;: ${longi}\n    },\n    \&quot;state\&quot;: \&quot;${state}\&quot;,\n    \&quot;area\&quot;: \&quot;${area}\&quot;\n}&quot;,
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
      <webElementGuid>1a7c6e4f-dafe-4fa6-81c9-c608a4c32135</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.2.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://sit-apps.nextsix.com/agents/5e5e0545ca612e08545b0e2e/plot</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>3.0852849928088357</defaultValue>
      <description></description>
      <id>1b33b012-a8a0-4851-bf95-5e07c76b1274</id>
      <masked>false</masked>
      <name>lati</name>
   </variables>
   <variables>
      <defaultValue>101.6924844179576</defaultValue>
      <description></description>
      <id>a0b9e764-50dc-45c0-8c25-7700226bb183</id>
      <masked>false</masked>
      <name>longi</name>
   </variables>
   <variables>
      <defaultValue>'Wilayah Persekutuan Kuala Lumpur'</defaultValue>
      <description></description>
      <id>3a19a9b0-8772-4e4f-9007-03e6a16bd99e</id>
      <masked>false</masked>
      <name>state</name>
   </variables>
   <variables>
      <defaultValue>'Kuchai Lama'</defaultValue>
      <description></description>
      <id>7c7d0ece-73e6-49dd-bd22-bd995971ec34</id>
      <masked>false</masked>
      <name>area</name>
   </variables>
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
