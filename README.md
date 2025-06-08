# API REST de Gestión de Usuarios y Notas
Descripción
API REST desarrollada con Spring Boot para gestionar usuarios y sus notas. Implementa relaciones JPA bidireccionales, validaciones, manejo de errores y versionado de API. Permite operaciones CRUD completas con persistencia en MySQL.

# Instrucciones de Ejecución
    Requisitos previos
        Java 17

        MySQL 8.x

        Maven 3.8+

    Pasos:

        1.Clonar repositorio:

            git clone https://github.com/JorgeVeres/API-REST-de-Usuarios-y-Notas
            cd api-usuarios-notas

        2.Crear base de datos MySQL:

            CREATE DATABASE notasdb;
        
        3.Configurar credenciales en src/main/resources/application.properties:
            spring.datasource.url=jdbc:mysql://localhost:3306/notasdb
            spring.datasource.username=root
            spring.datasource.password=tu_password

        4.Compilar y ejecutar:

            mvn spring-boot:run

# Repositorio GitHub

    https://github.com/JorgeVeres/API-REST-de-Usuarios-y-Notas.git

# Pruebas

    1. Registrar nuevo usuario (v2)

        -Método: POST
        -URL: http://localhost:8080/api/v2/sign-in
        -Body (raw - JSON):
            {
                "nombre": "María López",
                "email": "maria@example.com",
                "password": "Pass1234!"
            }