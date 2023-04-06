# language: es
Característica: Autenticación desde API REST
  Yo, como usuario
  Necesito ingresar las credenciales de usuario y contraseña por medio de una API
  Con el fin de obtener un token,

  Esquema del escenario: Autenticación exitosa
    Dado que el usuario cargó la información de la URL
    Y que ingresó la información del nombre de usuario: <user> y la contraseña: <password>
    Cuando ejecuta el servicio con los párametros ingresados
    Entonces se muestra la información del token

    Ejemplos:
      |  user     |  password    |
      |  admin    |  password123 |