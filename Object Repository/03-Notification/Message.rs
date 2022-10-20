<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Request para /message con parametros</description>
   <name>Message</name>
   <tag></tag>
   <elementGuidId>29aac3ca-2a54-4e44-aadb-003c050357c2</elementGuidId>
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
      <name>Authorization</name>
      <type>Main</type>
      <value>${Token}</value>
      <webElementGuid>488f7da7-8339-427a-8d16-0f571d90d54c</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.5.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${Server}/api/bff-notification/private/message?messageTypeId=equals,${Page}</restUrl>
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
      <description>Servidor de prueba</description>
      <id>7b54d851-fe7b-4127-aefb-d9f1d591c307</id>
      <masked>false</masked>
      <name>Server</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.vToken</defaultValue>
      <description>Token generado</description>
      <id>733b6b67-21ef-4d52-8600-5e31d360d8db</id>
      <masked>false</masked>
      <name>Token</name>
   </variables>
   <variables>
      <defaultValue>findTestData('08-WSNotify/TestData').getValue(2, 1)</defaultValue>
      <description>Nro de paginas</description>
      <id>10876c59-5c97-4302-812c-83e35617ba32</id>
      <masked>false</masked>
      <name>Page</name>
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


WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
