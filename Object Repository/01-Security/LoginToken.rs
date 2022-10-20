<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>WS Security</description>
   <name>LoginToken</name>
   <tag></tag>
   <elementGuidId>6546d6b3-1453-44f7-aefe-7b9e81730161</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;email\&quot;: \&quot;${User}\&quot;,\n  \&quot;password\&quot;: \&quot;${Pswd}\&quot;\n}&quot;,
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
      <webElementGuid>86e1d9a1-4bc9-4abd-a4ac-bf435eb45721</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.5.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://${Server}/api/security/login/token</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>findTestData('06-Users/Users').getValue(1, 18)</defaultValue>
      <description></description>
      <id>eb1a0ccf-2706-4ad0-b4b4-0fa1bb3276b6</id>
      <masked>false</masked>
      <name>User</name>
   </variables>
   <variables>
      <defaultValue>findTestData('06-Users/Users').getValue(2, 18)</defaultValue>
      <description></description>
      <id>704ae0d0-6143-4cb1-9306-77dab332ba81</id>
      <masked>false</masked>
      <name>Pswd</name>
   </variables>
   <variables>
      <defaultValue>findTestData('01-Servers/Servers').getValue(2, 1)</defaultValue>
      <description></description>
      <id>9f2f817e-4da1-41f1-bd56-b0b3a11fd9af</id>
      <masked>false</masked>
      <name>Server</name>
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
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
