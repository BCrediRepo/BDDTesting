@Login
Feature: Login-WSSecure
  Se prueba el WS /api/security/login/token utilizando
  datos no validos para Password

  @PasswordInvalido
  Scenario: WSSecurity Login con password incorrecto
    Given Configuracion de request con password incorrecto
    When Envio del request con password invalido
    Then Verifica el response de error con password invalido
