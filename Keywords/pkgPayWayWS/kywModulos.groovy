package pkgPayWayWS

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import javax.swing.JFrame as JFrame
import javax.swing.JOptionPane as JOptionPane

import internal.GlobalVariable

public class kywModulos {

	/*----------------------------------------------------------------------------------------------*
	 *TOKEN:																						*
	 *Generador de TOKEN para Authorization header      											*
	 *----------------------------------------------------------------------------------------------*/
	@Keyword
	def MOD01Login() {

		//Test data
		GlobalVariable.vMethod = findTestData('02-Endpoints/Endpoints').getValue(2, 1)
		GlobalVariable.vServer = findTestData('01-Servers/Servers').getValue(2, 1)
		//Response data
		GlobalVariable.vTokenTTLTransport
		//HTTP Error Code
		GlobalVariable.vTempHTTPCode
		GlobalVariable.vTempHTTPCode = findTestData('04-ResponseCodes/HTTPCodes').getValue(2, 1)

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


		int vHTTPCodeVerif
		vHTTPCodeVerif = Integer.parseInt(GlobalVariable.vTempHTTPCode)

		//HTTP response code validation
		WS.verifyResponseStatusCode(GlobalVariable.vResponse, vHTTPCodeVerif)

		//Se captura el Token y se almacena en variable global
		GlobalVariable.vToken = "Bearer " + WS.getElementPropertyValue(GlobalVariable.vResponse, 'access_token')
		//JOptionPane.showMessageDialog(null,GlobalVariable.vToken)

	}
}
