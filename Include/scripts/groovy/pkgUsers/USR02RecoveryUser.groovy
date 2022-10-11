package pkgUsers
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import javax.swing.JFrame as JFrame
import javax.swing.JOptionPane as JOptionPane


class USR02RecoveryUser {

//--- Recupera usuario con mail correcto ---

	@Given("Configuracion de request con mail de usuario valido")
	def configRequest() {
		println("\n Configuracion del Request")		

		//Test data
		GlobalVariable.vMethod = findTestData('02-Endpoints/Endpoints').getValue(2, 2)
		GlobalVariable.vServer = findTestData('01-Servers/Servers').getValue(2, 1)
		//Response data
		GlobalVariable.vTokenTTLTransport
		//HTTP Error Code
		GlobalVariable.vTempHTTPCode
		GlobalVariable.vTempHTTPCode = findTestData('04-ResponseCodes/HTTPCodes').getValue(2, 1)
		
	}

	@When("Se envia el request para recuperacion")
	def sendRequest() {
		println("\n Envio del request")
		
		//Method Errors varibales
		GlobalVariable.vResponse = WS.sendRequest(findTestObject(
				//Method
				GlobalVariable.vMethod,
				[
					('Server') : GlobalVariable.vServer,
					('User') : GlobalVariable.vUser
					
				]
				)
				)
	}

	@Then("Se valida el response")
	def verifyResponse() {
		println("\n Verifica el response")
		
		int vHTTPCodeVerif
		vHTTPCodeVerif = Integer.parseInt(GlobalVariable.vTempHTTPCode)
		//HTTP response code validation
		WS.verifyResponseStatusCode(GlobalVariable.vResponse, vHTTPCodeVerif)
		
	}
//--------------------------------------------------------------------------------------------------------------------
	@Given("Configuracion de request usuario invalido")
	def configRequestBadUser() {
		println("\n Configuracion del Request")

		//Test data
		GlobalVariable.vMethod = findTestData('02-Endpoints/Endpoints').getValue(2, 2)
		GlobalVariable.vServer = findTestData('01-Servers/Servers').getValue(2, 1)
		//Response data
		GlobalVariable.vTokenTTLTransport
		//HTTP Error Code
		GlobalVariable.vTempHTTPCode
		GlobalVariable.vTempHTTPCode = findTestData('04-ResponseCodes/HTTPCodes').getValue(2, 4)
		
		JOptionPane.showMessageDialog(null,GlobalVariable.vTempHTTPCode)
		JOptionPane.showMessageDialog(null,GlobalVariable.vUsuarioInvalido)
			
	}
	
	@When("Se envia el request para usuario invalido")
	def sendRequestBadUser() {
		println("\n Envio del request")
		
		//Method Errors varibales
		GlobalVariable.vResponse = WS.sendRequest(findTestObject(
				//Method
				GlobalVariable.vMethod,
				[
					('Server') : GlobalVariable.vServer,
					('User') : GlobalVariable.vUsuarioInvalido
					
				]
				)
				)
	}
	
	@Then("Se valida el response usuario invalido")
	def verifyResponseBadUser() {
		println("\n Verifica el response")
		
		int vHTTPCodeVerif
		vHTTPCodeVerif = Integer.parseInt(GlobalVariable.vTempHTTPCode)
		
		JOptionPane.showMessageDialog(null,vHTTPCodeVerif)
		//HTTP response code validation
		WS.verifyResponseStatusCode(GlobalVariable.vResponse, vHTTPCodeVerif)
		
	}
}
