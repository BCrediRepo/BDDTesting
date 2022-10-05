@Login
Feature: Login-WSSecure
  Se bloquea el usuario utilizando
  datos no validos para Ususrio y Password

  @BloquearUsuario
  Scenario: WSSecurity Login con credenciales incorrecto
    Given Configuracion de request con credenciales incorrecto
    When Envio del request con credenciales invalido
    Then Verifica el response de error con credenciales invalido
