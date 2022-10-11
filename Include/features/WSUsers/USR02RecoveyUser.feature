@Users
Feature: Recovery-WSUsers
  Se recuperan los datos del usuario
  segun su email- Method:POST

  @RecuperacionDeUsuario
  Scenario: Envio de request para recuperar el usuario
    Given Configuracion de request con mail de usuario valido
    When Se envia el request para recuperacion
    Then Se valida el response

  @RecuperacionUsuarioInvalido
  Scenario: Configuracion de request usuario no invalido
    Given Configuracion de request usuario invalido
    When Se envia el request para usuario invalido
    Then Se valida el response usuario invalido
