# BFF Web - Orquestador Wasap 2.2

Este componente actúa como el **Backend For Frontend (BFF)** del sistema. Su función principal es la orquestación de servicios y la agregación de datos para el cliente web.

## 🎯 Propósito Arquitectónico
A diferencia de los microservicios de dominio, este componente no gestiona una base de datos propia. Su responsabilidad es:
1. **Orquestación**: Realiza llamadas paralelas a `msuser` y `msmessages`.
2. **Transformación**: Convierte las entidades internas en un **DTO** único (`DashboardDTO`).
3. **Punto de Entrada**: Centraliza la seguridad y el manejo de errores para el frontend.



## ⚙️ Configuración Técnica
* **Puerto**: 8080 (Punto de acceso para Axios).
* **Consumo de Servicios**:
    * MS-User: `http://localhost:8081`
    * MS-Messages: `http://localhost:8082`

## 🚀 Ejecución
```bash
./mvnw spring-boot:run