--TABLES

CREATE TABLE LIBROS
(
    ID_LIBRO        SERIAL       NOT NULL PRIMARY KEY,
    TITULO          VARCHAR(50)  NOT NULL,
    DESCRIPCION     VARCHAR(500) NOT NULL,
    FECHA_PUBLICADO DATE,
    NOMBRE_AUTOR    VARCHAR(100),
    APELLIDOS_AUTOR VARCHAR(100),
    ID_CATEGORIAFK  INTEGER          NOT NULL

);

CREATE TABLE CATEGORIAS
(
    ID_CATEGORIA SERIAL      NOT NULL PRIMARY KEY,
    NOMBRE       VARCHAR(60) NOT NULL
);

alter table LIBROS
    add CONSTRAINT FK_CATEGORIAS_LIBROS FOREIGN KEY (ID_CATEGORIAFK) REFERENCES CATEGORIAS (ID_CATEGORIA);

COMMIT;

-------------------------------------------------

-- FUNCTION AND PROCEDURE - CATEGORIAS

create function fn_get_all_categorias()
    returns TABLE(id_categoria integer, nombre character varying)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
        SELECT *FROM CATEGORIAS C ORDER BY C.NOMBRE ;
END;
$$;


create function fn_by_categoria(nub_id integer)
    returns TABLE(id_categoria integer, nombre character varying)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
        SELECT *FROM CATEGORIAS C where C.id_categoria = $1;
END;
$$;


create procedure pr_insert_categoria(str_nombre character varying)
    language plpgsql
as
$$
BEGIN
    INSERT INTO CATEGORIAS (NOMBRE)
    VALUES (TRIM(FROM $1));
    COMMIT;
END
$$;


create procedure pr_update_categoria(nub_id integer, str_nombre character varying)
    language plpgsql
as
$$
BEGIN

    UPDATE CATEGORIAS SET NOMBRE=(TRIM(FROM $2)) WHERE ID_CATEGORIA = $1;
    COMMIT;
END
$$;


create procedure pr_delete_categoria(nub_id integer)
    language plpgsql
as
$$
BEGIN

    DELETE FROM CATEGORIAS WHERE ID_CATEGORIA = $1;
    COMMIT;
END
$$;

------------------------------------------------------

-- FUNCTION AND PROCEDURE - LIBROS

create function fn_get_all_libros()
    returns TABLE(id_libro integer, titulo character varying, descripcion character varying, fecha_publicado date, nombre_autor character varying, apellidos_autor character varying, id_categoriafk integer, categoria_nombre character varying)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
        SELECT LIB.ID_LIBRO,
               LIB.TITULO,
               LIB.DESCRIPCION,
               LIB.FECHA_PUBLICADO,
               LIB.NOMBRE_AUTOR,
               LIB.APELLIDOS_AUTOR,
               LIB.ID_CATEGORIAFK,
               CAT.NOMBRE
        FROM LIBROS LIB
                 INNER JOIN CATEGORIAS CAT ON LIB.ID_CATEGORIAFK = CAT.ID_CATEGORIA ORDER BY LIB.TITULO ;
END;
$$;

create function fn_get_by_libro(nub_id integer)
    returns TABLE(id_libro integer, titulo character varying, descripcion character varying, fecha_publicado date, nombre_autor character varying, apellidos_autor character varying, id_categoriafk integer, categoria_nombre character varying)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
        SELECT LIB.ID_LIBRO,
               LIB.TITULO,
               LIB.DESCRIPCION,
               LIB.FECHA_PUBLICADO,
               LIB.NOMBRE_AUTOR,
               LIB.APELLIDOS_AUTOR,
               LIB.ID_CATEGORIAFK,
               CAT.NOMBRE
        FROM LIBROS LIB
                 INNER JOIN CATEGORIAS CAT ON LIB.ID_CATEGORIAFK = CAT.ID_CATEGORIA
            AND LIB.ID_LIBRO = $1;
END;
$$;

create procedure pr_insert_libro(str_titulo character varying, str_descripcion character varying, dte_fecha_publicado date, str_nombre_autor character varying, str_apellidos_autor character varying, nub_id_categoriafk integer)
    language plpgsql
as
$$
BEGIN
    INSERT INTO LIBROS (TITULO, DESCRIPCION, FECHA_PUBLICADO, NOMBRE_AUTOR, APELLIDOS_AUTOR, ID_CATEGORIAFK)
    VALUES (TRIM(FROM $1), TRIM(FROM $2), $3, TRIM(FROM $4), TRIM(FROM $5), $6);
    COMMIT;
END;
$$;

create procedure pr_update_libro(nub_id_libro integer, str_titulo character varying, str_descripcion character varying, dte_fecha_publicado date, str_nombre_autor character varying, str_apellidos_autor character varying, nub_id_categoriafk integer)
    language plpgsql
as
$$
BEGIN
    UPDATE LIBROS
    SET TITULO         =TRIM(FROM $2),
        DESCRIPCION=TRIM(FROM $3),
        FECHA_PUBLICADO=$4,
        NOMBRE_AUTOR=TRIM(FROM $5),
        APELLIDOS_AUTOR=TRIM(FROM $6),
        ID_CATEGORIAFK= $7
    WHERE ID_LIBRO = $1;
    COMMIT;

END;
$$;

create procedure pr_delete_libro(nub_id integer)
    language plpgsql
as
$$
BEGIN
    DELETE FROM LIBROS WHERE ID_LIBRO = $1;
        COMMIT;

END;
$$;

------------------------------------------------------

-- FUNCTION CATEGORIAS - LIBROS

create function fn_get_by_categoria_libro(nub_id integer)
    returns TABLE(r_id_libro integer, r_titulo character varying, r_descripcion character varying, r_fecha_publicado date, r_nombre_autor character varying, r_apellidos_autor character varying, r_id_categoriafk integer, r_categoria_nombre character varying)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
        SELECT LIB.ID_LIBRO,
               LIB.TITULO,
               LIB.DESCRIPCION,
               LIB.FECHA_PUBLICADO,
               LIB.NOMBRE_AUTOR,
               LIB.APELLIDOS_AUTOR,
               LIB.ID_CATEGORIAFK,
               CAT.NOMBRE
        FROM LIBROS LIB
                 INNER JOIN CATEGORIAS CAT ON LIB.ID_CATEGORIAFK = CAT.ID_CATEGORIA
        AND LIB.ID_CATEGORIAFK = $1;
END;
$$;











