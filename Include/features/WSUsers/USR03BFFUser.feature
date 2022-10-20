@BFFUsers
Feature: BFF-User - Informacion del usuario
  Se validan los distintos escenarios
  con los datos correspondientes para BFF-User

  @BFFConsultarUsuario
  Scenario: BFFUser consultar usuaio
    Given Configuracion del BFFUser request GET
    When Envio del request BFFUser GET
    Then Verifica el response BFFUser GET
