# language: es
Característica: Busca orden de compra API REST
  Yo, como usuario
  Necesito ralizar una busqueda por el id de la orden
  Con el fin de obtener la información de la misma,

  Escenario: Buscar orden de compra
    Dado que el usuario cargó la información de la URL
    Y que ingresó la información de la ordenen que desea buscar: 7
    Cuando ejecuta el servicio con los párametros ingresados para la búsqueda
    Entonces se muestra la información de las órdenes ingresadas