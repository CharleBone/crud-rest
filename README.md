# Proyecto - Servicio Rest - CRUD

---


El proyecto consiste en generar una API-REST que exponga un servicio CRUD(Create, Read, Update, Delete) de personas mayores de 18 años

## Contenido

- [Tecnologías y herramientas](#install)
- [Instalacion](#instalacion)
- [Api](#api)
- [Local](#local)
- [Consideraciones](#consideraciones)


# Tecnologías y herramientas

* [Java8] - Lenguaje de programación
* [Git] - Versionado
* [Maven] - Paquetización y dependencias
* [Spring-boot] - Framework
* [MySql] - Base de datos
* [GitHub] - Repositorio y manual de uso


-------

# Instalación

- Básicamente se necesita tener esta tecnología instalada en el server.

| Requiere |  |
| ------ | ------ |
| Java8 | https://www.java.com/es/download/ |
| Git | https://git-scm.com/downloads |
| Maven | https://maven.apache.org |


Luego en el espacio de trabajo o workspace clonar el proyecto:

$ git clone https://github.com/CharleBone/crud-rest.git

------

# API

| DESCRIPCION  | URL | PETICION  | HEADER  | RESPUESTA
| ------ | ------ | ------ | ------ | ------ |
| Mostrar una lista de Personas | https://crud-spring-api-rest.herokuapp.com/api/personas | GET| | JSON | 
| Agregar Persona | https://crud-spring-api-rest.herokuapp.com/api/personas/ | POST | Content-Type: application/json |
| Buscar Persona | https://crud-spring-api-rest.herokuapp.com/api/personas/id | GET |   | JSON
| Actualizar Persona | https://crud-spring-api-rest.herokuapp.com/api/personas/id | PUT | Content-Type: application/json | 
| Eliminar Persona | https://crud-spring-api-rest.herokuapp.com/api/personas/id | DELETE    | Content-Type: application/json
| Estadisticas Generales | https://crud-spring-api-rest.herokuapp.com/api/estadisticas | GET |  | JSON | 

[![N|Solid](https://github.com/CharleBone/crud-rest/blob/master/src/main/resources/static/imagenes_ejemplo/agregarPersona.PNG)]


------
# Local

Para usar el servicio de forma local se debe crear una base de datos en el puerto 3306 con el nombre  "db_abm_rest"

------

# Consideraciones
- En cuanto a el punto "Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico
  (Entre 0 y 1100 peticiones por segundo)"; Hay varias consideraciones a tener en cuenta,
  no se puede tener una respuesta concreta con tan poca información:
  Asumiendo que POST /personas es el endpoint que mas llamadas recibe entonces hay que considerar varios
  factores. Si bien es cierto que el performance del código juega un papel importante, la capacidad de
  procesar 1100 transacciones por segundo va mas allá del código, probablemente se necesiten
  múltiples hosts que sean capaces de manejar esa capacidad de transacciones.