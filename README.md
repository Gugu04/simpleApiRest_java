###ApiRest en java (Spring boot) 🚀
-------------

**Instalación:**

Deberás de tener instalado spring boot y PostgreSQL una vez hayas clonado el proyecto deberás de seguir los siguientes pasos:

- Crear una base de datos y ejecutar el script  [application.properties](http://sss "application.properties").
- Configurar el archivo  [script_db.sql](http://sss "application.properties") con los datos de su conexión hacia el motor de la base de datos PostgreSQL.
- Hacer un `maven clean` y un `maven install` esto se puede hacer de diferentes maneras dependerá del IDE que estés utilizando.
- Como último punto solo deberá de ejecutar el proyecto.
-------------

####org.springframework.security (configuracion basica)
> [ConfigurationSecurity](http://sss "application.properties")

| Rol | Usuario | Contraseña |
| ------------- | ------------- |------------- |
| ADMIN  | admin  | admin123  |
| USER  | vale | vale1234  |

**Nota:** Tambien puede sustituir los procedures y funciones por consultas normales SQL
> [CategoriaRepository](http://sss "application.properties")
> [LibroRespository](http://sss "application.properties")
