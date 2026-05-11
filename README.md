# Wasap 2.2 - Arquitectura de Microservicios Orquestada

Este proyecto implementa una solución de mensajería basada en una arquitectura de microservicios.
## 🏗️ Arquitectura y Patrones

* **Backend For Frontend (BFF)**: Centraliza la orquestación de datos de los microservicios internos en un solo punto (`bffweb`), optimizando la comunicación con el frontend.
* **Data Transfer Object (DTO)**: Implementado mediante `DashboardDTO` para transferir datos unificados, evitando el envío de entidades crudas de base de datos.
* **Repository Pattern**: Abstrae la lógica de persistencia en H2, permitiendo la independencia tecnológica de la capa de datos.
* **Singleton**: Gestión de beans de controlador y servicios a través del contenedor de Spring.



## 📁 Estructura del Proyecto
* **`frontend-app`**: Componente de presentación tipo **NPM**.
* **`bffweb`**: Orquestador basado en arquetipo **Maven**.
* **`msuser`**: Microservicio de gestión de usuarios (Maven).
* **`msmessages`**: Microservicio de gestión de mensajería (Maven).

## 🚀 Guía de Ejecución

### Orden de inicio sugerido:
1. **MS-User**: `cd msuser/msuser && ./mvnw spring-boot:run` (Puerto 8081)
2. **MS-Messages**: `cd msmessages/msmessages && ./mvnw spring-boot:run` (Puerto 8082)
3. **BFF-Web**: `cd bffweb/bffweb && ./mvnw spring-boot:run` (Puerto 8080)
4. **Frontend**: `cd frontend-app && npm start` (Puerto 3000)

> **Nota para Windows**: En lugar de `./mvnw`, utilice `.\mvnw.cmd`.

## 🧪 Calidad y Pruebas
Se implementaron pruebas unitarias con JUnit y AssertJ para validar la carga de contextos y la integridad de los controladores. Para ejecutarlas:
```bash
./mvnw test
```
## 🌳 Estrategia de Branching
Se utilizó una estrategia de **Feature Branching (Git Flow simplificado)**. El desarrollo se organizó en ramas de funcionalidad (`feature/*`) integradas a `main` mediante **Pull Requests**, garantizando la trazabilidad y la resolución de conflictos antes de la integración final.