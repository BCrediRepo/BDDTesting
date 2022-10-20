<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Users</name>
   <tag></tag>
   <elementGuidId>9030edce-aeee-4df3-81ff-9a75af5a3376</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>dcf8657d-d4c4-4f40-8a00-e2b33382d094</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.5.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${Server}/ms/users/api/v1/users?cuit=${CUIT}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>findTestData('01-Servers/Servers').getValue(2, 1)</defaultValue>
      <description></description>
      <id>86651d4a-dca5-467c-bab7-36e7ea7ada32</id>
      <masked>false</masked>
      <name>Server</name>
   </variables>
   <variables>
      <defaultValue>findTestData('06-Users/Users').getValue(3, 18)</defaultValue>
      <description></description>
      <id>726cab3b-87ac-426d-b376-da973e174560</id>
      <masked>false</masked>
      <name>CUIT</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
WS.verifyElementPropertyValue(response, 'data[0].cuit', &quot;20-07608479-4&quot;)
WS.verifyElementPropertyValue(response, 'data[0].email', &quot;test.qa.87@yopmail.com&quot;)
WS.verifyElementPropertyValue(response, 'data[0].role', &quot;ADMIN&quot;)
WS.verifyElementPropertyValue(response, 'data[0].commerce_type_id', &quot;phe-free&quot;)
WS.verifyElementPropertyValue(response, 'data', '')</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
