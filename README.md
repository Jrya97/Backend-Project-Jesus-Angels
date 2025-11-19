# Colegio Jesús Angels - Backend API

Este proyecto es una API REST construida con Spring Boot para la gestión del Colegio Jesús Angels.

## Requisitos Previos

- Java 21
- Maven
- PostgreSQL

## Ejecución

Para correr el proyecto localmente:

```bash
./mvnw spring-boot:run
```

La aplicación se iniciará en `http://localhost:8080`.

## Documentación de Endpoints

La URL base para todos los endpoints es `http://localhost:8080/api`.

### 1. Alumnos (`/alumnos`)
Gestión de la información de los estudiantes.

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Obtener todos los alumnos |
| `GET` | `/{id}` | Obtener un alumno por su ID |
| `GET` | `/dni/{dni}` | Buscar alumno por DNI |
| `POST` | `/` | Registrar un nuevo alumno |
| `PUT` | `/{id}` | Actualizar datos de un alumno |
| `DELETE` | `/{id}` | Eliminar un alumno |

**Ejemplo de JSON (POST/PUT):**
```json
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "dni": "12345678",
  "fechaNacimiento": "2015-05-20",
  "direccion": "Av. Lima 123",
  "idApoderado": 1  // Opcional, si se vincula a un apoderado existente
}
```

### 2. Cursos (`/cursos`)
Gestión del catálogo de cursos.

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Listar todos los cursos |
| `GET` | `/{id}` | Obtener curso por ID |
| `POST` | `/` | Crear un nuevo curso |
| `PUT` | `/{id}` | Actualizar un curso |
| `DELETE` | `/{id}` | Eliminar un curso |

**Ejemplo de JSON:**
```json
{
  "nombre": "Matemáticas",
}
```

### 3. Matrículas (`/matriculas`)
Gestión de las matrículas de alumnos en grados y años lectivos.

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Listar todas las matrículas |
| `GET` | `/{id}` | Obtener matrícula por ID |
| `GET` | `/alumno/{idAlumno}` | Listar matrículas de un alumno |
| `GET` | `/grado/{idGrado}` | Listar matrículas de un grado |
| `POST` | `/` | Registrar nueva matrícula |
| `PUT` | `/{id}` | Actualizar matrícula |
| `DELETE` | `/{id}` | Eliminar matrícula |

**Ejemplo de JSON:**
```json
{
  "alumno": { "id": 1 },
  "grado": { "id": 1 },
  "anioLectivo": 2025,
  "fechaMatricula": "2025-01-15",
  "estado": "ACTIVO"
}
```

### 4. Pagos (`/pagos`)
Registro y control de pagos (matriculas, mensualidades).

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Listar todos los pagos |
| `GET` | `/{id}` | Obtener pago por ID |
| `GET` | `/matricula/{idMatricula}` | Ver pagos de una matrícula específica |
| `POST` | `/` | Registrar un pago |
| `PUT` | `/{id}` | Actualizar un pago |
| `DELETE` | `/{id}` | Eliminar un pago |

**Ejemplo de JSON:**
```json
{
  "matricula": { "id": 1 },
  "tipo": "MENSUALIDAD",
  "mes": "MARZO",
  "monto": 350.00,
  "fechaPago": "2025-03-05",
  "estado": "PAGADO"
}
```

### 5. Notas (`/notas`)
Registro de calificaciones por bimestre.

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Listar todas las notas |
| `GET` | `/{id}` | Obtener nota por ID |
| `GET` | `/alumno/{idAlumno}` | Ver notas de un alumno |
| `POST` | `/` | Registrar una nota |
| `PUT` | `/{id}` | Actualizar una nota |
| `DELETE` | `/{id}` | Eliminar una nota |

**Ejemplo de JSON:**
```json
{
  "alumno": { "id": 1 },
  "profesorCurso": { "id": 1 },
  "bimestre": 1,
  "nota": 18.5
}
```

### 6. Asistencia (`/asistencia`)
Control de asistencia diaria.

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Listar registros de asistencia |
| `GET` | `/{id}` | Obtener registro por ID |
| `GET` | `/fecha/{fecha}` | Ver asistencia de una fecha (YYYY-MM-DD) |
| `POST` | `/` | Registrar asistencia |
| `PUT` | `/{id}` | Actualizar asistencia |
| `DELETE` | `/{id}` | Eliminar registro |

**Ejemplo de JSON:**
```json
{
  "alumno": { "id": 1 },
  "profesorCurso": { "id": 1 },
  "fecha": "2025-03-10",
  "estado": "PRESENTE"
}
```

### 7. Perfiles (`/perfiles`)
Gestión de usuarios y roles (Admin, Profesor).

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Listar todos los perfiles |
| `GET` | `/{id}` | Obtener perfil por ID (UUID) |
| `GET` | `/rol/{rol}` | Listar por rol (ADMIN, PROFESOR) |
| `POST` | `/` | Crear un nuevo perfil |
| `PUT` | `/{id}` | Actualizar perfil |
| `DELETE` | `/{id}` | Eliminar perfil |

**Ejemplo de JSON:**
```json
{
  "nombre": "Director General",
  "rol": "ADMIN",
  "usuario": "admin",
  "password": "securepassword"
}
```

### 8. Grados (`/grados`)
Gestión de grados y niveles educativos.

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Listar todos los grados |
| `GET` | `/{id}` | Obtener grado por ID |
| `GET` | `/nivel/{nivel}` | Listar por nivel (INICIAL, PRIMARIA, SECUNDARIA) |
| `POST` | `/` | Crear un nuevo grado |
| `PUT` | `/{id}` | Actualizar grado |
| `DELETE` | `/{id}` | Eliminar grado |

**Ejemplo de JSON:**
```json
{
  "nombre": "PRIMER_GRADO",
  "nivel": "PRIMARIA"
}
```

### 9. Apoderados (`/apoderados`)
Gestión de padres o tutores.

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/` | Listar todos los apoderados |
| `GET` | `/{id}` | Obtener apoderado por ID |
| `GET` | `/dni/{dni}` | Buscar por DNI |
| `POST` | `/` | Registrar apoderado |
| `PUT` | `/{id}` | Actualizar datos |
| `DELETE` | `/{id}` | Eliminar apoderado |

**Ejemplo de JSON:**
```json
{
  "nombre": "Maria",
  "apellido": "Gomez",
  "dni": "87654321",
  "telefono": "999888777",
  "email": "maria@example.com",
  "direccion": "Calle Real 456"
}
```
