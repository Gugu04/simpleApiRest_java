###ApiRest en java (Spring boot) 🚀
-------------

**Instalación:**

Deberás de tener instalado spring boot y PostgreSQL una vez hayas clonado el proyecto deberás de seguir los siguientes pasos:

- Crear una base de datos y ejecutar el script  [application.properties](https://github.com/Gugu04/simpleApiRest_java/blob/master/apirest_jdbc/src/main/resources/application.properties).
- Configurar el archivo  [script_db.sql](https://github.com/Gugu04/simpleApiRest_java/blob/master/script_db.sql) con los datos de su conexión hacia el motor de la base de datos PostgreSQL.
- Hacer un `maven clean` y un `maven install` esto se puede hacer de diferentes maneras dependerá del IDE que estés utilizando.
- Como último punto solo deberá de ejecutar el proyecto.
-------------

####org.springframework.security (configuracion basica)
> [ConfigurationSecurity](https://github.com/Gugu04/simpleApiRest_java/blob/master/apirest_jdbc/src/main/java/com/api/rest/security/ConfigurationSecurity.java)

| Rol | Usuario | Contraseña |
| ------------- | ------------- |------------- |
| ADMIN  | admin  | admin123  |
| USER  | vale | vale1234  |

**Nota:** Tambien puede sustituir los procedures y funciones por consultas normales SQL
> [CategoriaRepository](https://github.com/Gugu04/simpleApiRest_java/blob/master/apirest_jdbc/src/main/java/com/api/rest/repository/CategoriaRepository.java)
> [LibroRespository](https://github.com/Gugu04/simpleApiRest_java/blob/master/apirest_jdbc/src/main/java/com/api/rest/repository/LibroRespository.java)
