@Notification
Feature: BFF Notification
  Se prueba el el BFF de notificaion /bff-notification/private/information-messages 

  @Notificaciones
  Scenario: BFF-Notification getion de mensajes de notificaciones
    Given Configuracion de request para BFFNotification
    When Envio del request BFFNotification
    Then Verifica el response de BFFNotification