# Evaluación primera parte - Java Spring
Primera parte de la Evaluación -JAVA Spring con JPA. Creación de endpoints para manejar los servicios de empleados

### Requerimientos

1. Java 1.8
2. Eclipse IDE

### Instrucciones para compilar y ejecutar el proyecto
***
Instrucciones para compilar y ejecutar el programa
1. Descargar todos los archivos y guardar en una misma carpeta.
2. Abrir la carpeta que contiene los archivos como proyecto en el IDE Eclipse.
3. En el IDE, buscar el archivo pom.xml y darle a refresh, para bajar todas las dependecias de Maven.
4. Comprobar que se tenga la versión de Java 1.8
5. Ejecutar el programa como Spring Boot App

>NOTA: Para probar el archivo se puede acceder a la consola de la base de datos h2, mediante el siguiente enlace: http://localhost:8080/h2-console/
o bien, puede probar los endpoints mediande un programa como POSTMAN

***
El endpoint para agregar un nuevo empleado es el siguiente:
> http://localhost:8080/apiv1/empleados/add

El endpoint para recuperar la información de los empleados de la base de datos es el siguiente:
> http://localhost:8080/apiv1/empleados/findall

***
![img](https://imgur.com/a/JAbhGAy)
