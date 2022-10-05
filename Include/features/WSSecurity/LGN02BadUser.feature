@Login
Feature: Login-WSSecure
  Se prueba el WS /api/security/login/token utilizando
  datos no validos para Usuario

  @UsuarioInvalido
  Scenario: WSSecurity Login con usuario incorrecto
    Given Configuracion de request con usuario incorrecto
    When Envio del request con usuario invalido
    Then Verifica el response de error con usuario invalido
