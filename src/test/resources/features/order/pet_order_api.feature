# language: es
Característica: Orden de compra para mascota API REST
  Yo, como usuario
  Necesito ralizar una orden de compra de implementos para mascotas API
  Con el fin de obtener un id del registro exitoso,

  Esquema del escenario: Solicitud de orden de compra
    Dado que el usuario cargó la información de la URL
    Y que ingresó la información del id: <id>, el Id de la mascota: <petid>
    Y que ingreso la cantidad: <quantity>, la fecha de envío: <shipDate>, el estado: <status>
    Y que ingreso el estado actual del registro: <complete>
    Cuando ejecuta el servicio con los párametros ingresados
    Entonces se muestra la información del pedido de compra de la mascota

    Ejemplos:
      |  id     |  petid |  quantity  | shipDate                  | status    |  complete   |
      |  0      |  0     |     0      |  2023-11-01T01:52:06.457Z | placed    |   true      |