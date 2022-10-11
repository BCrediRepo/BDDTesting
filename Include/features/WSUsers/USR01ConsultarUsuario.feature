@Users
Feature: Login-WSUsers
  Se validan los distintos escenarios
  con los datos correspondientes para WSUsers	

  @ConsultarUsuario
  Scenario: WSUser consultar usuaio mediante CUIT
    Given Configuracion de request con CUIT valido
    When Envio del request con CUIT valido
    Then Verifica el response de error CUIT valido

  @ConsultarUsuarioSinCUIT
  Scenario: WSUser consultar usuaio sin CUIT
    Given Configuracion de request sin CUIT
    When Envio del request sin CUIT
    Then Verifica el response con error

  @ConsultarUsuarioCUITInvalido
  Scenario: WSUser consultar el usuario con CUIT mal cargado
    Given Configuracion con CUIT mal formato
    When Envio de request CUIT mal formado
    Then Verifica el response con error
