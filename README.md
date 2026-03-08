# 📚 Foro Hub API

API REST desarrollada como parte del **Foro Hub - Challenge Back End** de Alura Latam dentro del programa **ONE - Oracle Next Education**.

El objetivo del proyecto es construir el backend de un foro donde los usuarios puedan crear, listar, actualizar y eliminar tópicos, aplicando buenas prácticas de desarrollo con Spring Boot.

## 🚀 Tecnologías utilizadas

* ☕ **Java 17**
* ⚙️ **Spring Boot**
* 🗄 **Spring Data JPA**
* 🔐 **Spring Security**
* 🐬 **MySQL**
* 🔎 **Hibernate ORM**
* ✔ **Hibernate Validator**
* 🧪 **Postman**
* 📦 **Maven**

---

## 📌 Funcionalidades

La API permite gestionar tópicos dentro del foro mediante los siguientes endpoints:

* ✔ **Crear un tópico:** `POST /topicos`
* ✔ **Listar tópicos:** `GET /topicos`
* ✔ **Mostrar detalle de un tópico:** `GET /topicos/{id}`
* ✔ **Actualizar un tópico:** `PUT /topicos/{id}`
* ✔ **Eliminar un tópico:** `DELETE /topicos/{id}`

---

## 🧩 Estructura del proyecto

```text
src
 └── main
     └── java
         └── com.example.BackEnd
             ├── config
             ├── controller
             ├── domain
             │    ├── topico
             │    └── usuario
             └── infra
