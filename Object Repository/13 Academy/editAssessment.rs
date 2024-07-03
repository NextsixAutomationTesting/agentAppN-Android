<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>editAssessment</name>
   <tag></tag>
   <elementGuidId>914b0bfa-5f1b-43f9-8405-3224df1dcae1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;_id\&quot;: \&quot;65d84503d19649006644fe4e\&quot;,\n    \&quot;assessment\&quot;: \&quot;65d844a1d19649006644fe3b\&quot;,\n    \&quot;title\&quot;: \&quot;test\&quot;,\n    \&quot;pool\&quot;: 3,\n    \&quot;required\&quot;: true,\n    \&quot;randomize\&quot;: true,\n    \&quot;active\&quot;: true,\n    \&quot;edit\&quot;: true,\n    \&quot;delete\&quot;: false,\n    \&quot;timer\&quot;: 60,\n    \&quot;questions\&quot;: [\n        {\n            \&quot;description\&quot;: \&quot;${ans}\&quot;,\n            \&quot;options\&quot;: [\n                \&quot;${ans}\&quot;,\n                \&quot;${q}\&quot;\n            ],\n            \&quot;answers\&quot;: [\n                \&quot;${ans}\&quot;\n            ]\n        },\n        {\n            \&quot;description\&quot;: \&quot;${ans1}\&quot;,\n            \&quot;options\&quot;: [\n                \&quot;${ans1}\&quot;,\n                \&quot;${q1}\&quot;\n            ],\n            \&quot;answers\&quot;: [\n                \&quot;${ans1}\&quot;\n            ]\n        },\n      {\n            \&quot;description\&quot;: \&quot;${ans2}\&quot;,\n            \&quot;options\&quot;: [\n                \&quot;${q2}\&quot;,\n                \&quot;${ans2}\&quot;\n            ],\n            \&quot;answers\&quot;: [\n                \&quot;${ans2}\&quot;\n            ]\n        },\n      {\n            \&quot;description\&quot;: \&quot;${q1}\&quot;,\n            \&quot;options\&quot;: [\n                \&quot;${q}\&quot;,\n                \&quot;${q1}\&quot;\n            ],\n            \&quot;answers\&quot;: [\n                \&quot;${q1}\&quot;\n            ]\n        },\n      {\n            \&quot;description\&quot;: \&quot;${q}\&quot;,\n            \&quot;options\&quot;: [\n                \&quot;${q}\&quot;,\n                \&quot;${ans1}\&quot;\n            ],\n            \&quot;answers\&quot;: [\n                \&quot;${q}\&quot;\n            ]\n        },\n      {\n            \&quot;description\&quot;: \&quot;${q2}\&quot;,\n            \&quot;options\&quot;: [\n                \&quot;${q2}\&quot;,\n                \&quot;${ans}\&quot;\n            ],\n            \&quot;answers\&quot;: [\n                \&quot;${q2}\&quot;\n            ]\n        }\n    ]\n}&quot;,
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
      <webElementGuid>24d3a993-2eac-4db8-85f3-e1ba2736f7e5</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.2.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://sit-host.nextsix.com/assessmentTests/save</restUrl>
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
