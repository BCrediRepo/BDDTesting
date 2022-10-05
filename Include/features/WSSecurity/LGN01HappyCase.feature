@Login
Feature: Login-WSSecure
  Se prueba el WS /api/security/login/token utilizando
  datos validos para Usuario y Password

  @CredencialesCorrectas
  Scenario: WSSecurity Login con credenciales correctas
    Given Configuracion de request
    When Envio del request
    Then Verifica el response

