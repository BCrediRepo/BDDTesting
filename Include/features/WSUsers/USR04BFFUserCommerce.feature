@BFFUsers
Feature: BFF-User - Informacion del comercio
  Se validan los distintos escenarios
  con los datos correspondientes para BFF-User

  @BFFUserCommerce
  Scenario: BFF User/Commerces
    Given Configuracion UserComerces request GET
    When Envio del request UserCommerces GET
    Then Verifica el response UserCommerces
