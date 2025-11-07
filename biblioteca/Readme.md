# Biblioteca GraphQL - Spring Boot + MySQL

API GraphQL para gestionar libros con **Spring Boot 3.5.7**, **GraphQL**, **JPA/Hibernate** y **MySQL**.

---

## Crea la base de datos en MySQL

CREATE DATABASE biblioteca_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
EXIT;

## Aplication.properties
## Cambia estas lineas por tus datos

spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA_AQUÍ

## El puerto yo utilizo en 8081
> (Cambia `8081` si usas otro puerto)
> **URL de GraphiQL**: `http://localhost:8081/graphiql`  


---


## Funcionalidades y cómo probarlas


# 1. **Crear libro**

graphql
mutation {
  crearLibro(
    nombre: "Cien años de soledad"
    autor: "Gabriel García Márquez"
    descripcion: "Realismo mágico"
  ) {
    id
    nombre
    autor
  }
}

# 2. **Listar todos**
query { libros { id nombre autor } }
# 3. **Buscar por ID**
query { libro(id: 1) { id nombre descripcion } }
# 4. **Actualizar**
mutation {
actualizarLibro(id: 1, nombre: "Rayuela (ed. 2025)") {
nombre
}
}
# 5. **Eliminar**
mutation { eliminarLibro(id: 1) }


