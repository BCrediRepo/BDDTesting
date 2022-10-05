package pkgLogin
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

class LGN01HappyCase {

	@Given("Configuracion de request")
	def configRequest() {
		println("\n Configuracion del Request")

		//Test data
		GlobalVariable.vMethod = findTestData('02-Endpoints/Endpoints').getValue(2, 1)
		GlobalVariable.vServer = findTestData('01-Servers/Servers').getValue(2, 1)
		//Response data
		GlobalVariable.vTokenTTLTransport
		//HTTP Error Code
		GlobalVariable.vTempHTTPCode
		GlobalVariable.vTempHTTPCode = findTestData('04-ResponseCodes/HTTPCodes').getValue(2, 1)

	}


	@When("Envio del request")
	def sendRequest() {
		println("\n Envio del request")

		//Method Errors varibales
		GlobalVariable.vResponse = WS.sendRequest(findTestObject(
				//Method
				GlobalVariable.vMethod,
				[
					('User') : GlobalVariable.vUser,
					('Pswd') : GlobalVariable.vPass,
					('Server') : GlobalVariable.vServer
				]
				)
				)

	}

	@Then("Verifica el response")
	def verifyResponse() {
		println("\n Verifica el response")

		int vHTTPCodeVerif
		vHTTPCodeVerif = Integer.parseInt(GlobalVariable.vTempHTTPCode)

		//HTTP response code validation
		WS.verifyResponseStatusCode(GlobalVariable.vResponse, vHTTPCodeVerif)

		//Se captura el Token y se almacena en variable global
		GlobalVariable.vToken = WS.getElementPropertyValue(GlobalVariable.vResponse, 'access_token')
		GlobalVariable.vTokenTTLTransport = WS.getElementPropertyValue(GlobalVariable.vResponse, 'expires_in')
		//JOptionPane.showMessageDialog(null, vTokenTTLTransport)
		WS.verifyElementPropertyValue(GlobalVariable.vResponse, 'expires_in', GlobalVariable.vTokenTTLTransport)

	}
}