
## Resumen del Proyecto

Este proyecto es una aplicación web que permite:
- Registrar propiedades con nombre, dirección, precio y descripción.
- Listar todas las propiedades en una tabla.
- Editar propiedades existentes.
- Eliminar propiedades de la base de datos.

El sistema utiliza:
- **Frontend:** HTML + Bootstrap + JavaScript (Fetch API).
- **Backend:** Spring Boot (Java) con API REST.
- **Base de datos:** MySQL en Amazon RDS.

---

## Arquitectura del Sistema

* Frontend: Sirve la interfaz desde src/main/resources/public/index.html.

* Backend: Expone endpoints REST (/items) para CRUD.

* Base de datos: Instancia MySQL en AWS RDS que persiste la información.


Diseño de Clases

Principales clases del backend:

* Item → Entidad JPA que representa una propiedad.

* ItemRepository → Interface que extiende JpaRepository.

* ItemService → Lógica de negocio para las operaciones CRUD.

* ItemController → Controlador REST con endpoints.



classDiagram
class Property {
Long id
String name
String address
Double price
String description
}

    class PropertyRepository {
        + findAll()
        + findById(Long id)
        + save(Property p)
        + deleteById(Long id)
    }

   

    class PropertyController {
        + GET /items
        + POST /items
        + PUT /items/{id}
        + DELETE /items/{id}
    }



## Instrucciones de Despliegue

### Prerrequisitos

* Java 17+

* Maven

* Instancia RDS MySQL (creada en AWS)

* Instancia EC2 para ejecutar la aplicación

### Configuracion

1. Clonar el repositorio:
   ```bash
    git clone https://github.com/DavidBarbosag/tallerCRUDAREP.git
    cd tallerCRUDAREP
    ```
2. Configurar la conexión a la base de datos en src/main/resources/application.properties:

```
spring.datasource.url=jdbc:mysql://<RDS-ENDPOINT>:3306/<DB-NAME>
spring.datasource.username=<USERNAME>
spring.datasource.password=<PASSWORD>
spring.jpa.hibernate.ddl-auto=update
```

3. Compilar y empaquetar:
    ```bash
    mvn clean package
    ```
4. Ejecutar en EC2

    ```bash
      mvn spring-boot:run
    ```
## Uso


### Inicia con persitencia

![uso1.png](assets/uso1.png)

### Post

![post](assets/post.png)

### Get all

![img.png](assets/getall.png)

