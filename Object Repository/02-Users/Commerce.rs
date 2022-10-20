<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Commerce</name>
   <tag></tag>
   <elementGuidId>0c08717c-a75a-4860-9f2b-cf60409f9176</elementGuidId>
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
      <webElementGuid>1ae8fe38-268c-4a34-9cb0-95ccd3fdfd66</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${Token}</value>
      <webElementGuid>5386510c-be2c-4af3-819b-4ac6d3a80330</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.5.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${Server}/api/bff-user/private/user/commerces</restUrl>
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
      <description>Conexion con el servidor</description>
      <id>7a13e7fd-7686-4f7f-b753-84c32e804238</id>
      <masked>false</masked>
      <name>Server</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.vToken</defaultValue>
      <description>Token generado</description>
      <id>2ed8a3e4-1ef7-4bbf-bcad-d4afe2eb3108</id>
      <masked>false</masked>
      <name>Token</name>
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


WS.verifyElementPropertyValue(response, '[0].cuit', &quot;30-61398988-5&quot;)
WS.verifyElementPropertyValue(response, '[0].role', &quot;ADMIN&quot;)
WS.verifyElementPropertyValue(response, '[0].predetermined', true)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
