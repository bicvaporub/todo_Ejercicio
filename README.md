
# ToDo API - Spring Boot + MySQL

API REST para gestionar tareas (ToDo) desarrollada con Spring Boot y MySQL.

---

## Descripción

Esta API permite crear, consultar, actualizar, cambiar el estado y eliminar tareas.  
Está desarrollada usando Spring Boot 3.3.11, JPA/Hibernate para persistencia y validaciones básicas.

---

## Tecnologías

- Java 17
- Spring Boot 3.3.11
- Spring Data JPA
- MySQL 8+
- Maven
- Lombok
- Validación con javax.validation
- (Opcional) Swagger / OpenAPI (No incluido en esta versión)

---

## Requisitos Previos

- Java 17 instalado
- MySQL corriendo y base de datos `tododb` creada
- Maven instalado

---

## Configuración

En `src/main/resources/application.properties`:

```properties
spring.application.name=todo
spring.datasource.url=jdbc:mysql://localhost:3306/tododb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8081
```

Ajusta según tu entorno (usuario, contraseña, puerto).

---

## Compilar y Ejecutar

Desde la raíz del proyecto, corre:

```bash
mvn clean spring-boot:run
```

La aplicación iniciará en el puerto configurado (`8081` por defecto).

---

## Endpoints disponibles

Base URL: `http://localhost:8081/api/todos`

| Método | Ruta            | Descripción                    | Request Body                  | Respuesta                |
|--------|-----------------|-------------------------------|------------------------------|--------------------------|
| POST   | `/api/todos`    | Crear un nuevo ToDo            | JSON con campos del ToDo      | Objeto ToDo creado       |
| GET    | `/api/todos`    | Obtener todos los ToDos        | N/A                          | Lista de ToDos           |
| PUT    | `/api/todos/{id}`| Actualizar un ToDo existente  | JSON con ToDo actualizado     | Objeto ToDo actualizado  |
| PATCH  | `/api/todos/{id}/status` | Cambiar solo el estado    | JSON `{ "status": "nuevoEstado" }` | Objeto ToDo actualizado |
| DELETE | `/api/todos/{id}`| Eliminar un ToDo por ID        | N/A                          | 204 No Content           |

---

## Ejemplo con cURL

Crear un ToDo:

```bash
curl -X POST http://localhost:8081/api/todos \
-H "Content-Type: application/json" \
-d '{"title":"Aprender Spring Boot","description":"Practicar APIs REST","status":"PENDING"}'
```

Obtener todos:

```bash
curl http://localhost:8081/api/todos
```

---

## Manejo de errores

- Validaciones de campos (ej. descripción no vacía).
- Respuestas HTTP adecuadas (400, 404, 201, etc.).
- Manejo global de excepciones con `@ControllerAdvice`.

---

## Estructura del proyecto

- `controller/` – Controladores REST
- `service/` – Lógica de negocio
- `repository/` – Interfaces JPA para acceso a datos
- `entity/` – Entidades JPA (modelos de datos)
- `exception/` – Manejo global de errores

---

## Notas

- La tabla `todos` se crea automáticamente con `spring.jpa.hibernate.ddl-auto=update`.
- Cambia el puerto en `application.properties` si el 8080 está ocupado.

---

## Autor

Victor Kevin Perez Garcia

---


