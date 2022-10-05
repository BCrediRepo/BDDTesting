package pkgPayWayWS

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import java.sql.Connection;
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

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

import internal.GlobalVariable

public class kywSQLConnection {
	
	private static Connection connection = null;
	
		/**
		 * Abre la conexión con la dB
		 * @param dataFile path absoluto
		 * @return instancia de java.sql.Connection
		 **/
		@Keyword
		def connectDB(){
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
			if(connection != null && !connection.isClosed()){
				connection.close()
			}
			//connection = DriverManager.getConnection("jdbc:sqlserver://my-db-phe-qa.c4uukmeyrgpl.us-east-1.rds.amazonaws.com:1433;databaseName=Users;user=user_qa;password=Password01")
			connection = DriverManager.getConnection(findTestData('03-Database/Connection').getValue(1,1) +
					";databaseName=" + findTestData('03-Database/Connection').getValue(2,1) +
					";user=" + findTestData('03-Database/Connection').getValue(3,1) +
					";password=" + findTestData('03-Database/Connection').getValue(4,1))
			return connection
		}
	
		/**
		 * Ejecuta un consulta SQL sobre la dB
		 * @param query SQL como string
		 **/
		@Keyword
		def executeQuery(String queryString) {
			Statement stm = connection.createStatement()
			ResultSet rs = stm.executeQuery(queryString)
			//JOptionPane.showMessageDialog(null, rs)
			return rs
		}
	
		@Keyword
		def closeDatabaseConnection() {
			if(connection != null && !connection.isClosed()){
				connection.close()
			}
			connection = null
		}
	
		/**
		 * Ejecuta INSERT/UPDATE/DELETE/COUNT/SUM.. en la dB
		 * @param query SQL como string
		 */
		@Keyword
		def execute(String queryString) {
			Statement stm = connection.createStatement()
			boolean result = stm.execute(queryString)
			return result
		}
}
