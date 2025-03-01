--
-- Tablas de la base de datos: `desafio-practico1`
--

-- ----------------------------------------------------------------
--  TABLA MATERIA
-- ----------------------------------------------------------------
CREATE TABLE materia (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

-- ----------------------------------------------------------------
--  TABLE ALUMNO
-- ----------------------------------------------------------------

CREATE TABLE alumno (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    id_materia BIGINT NOT NULL,
    CONSTRAINT fk_materia FOREIGN KEY (id_materia) REFERENCES materia(id) ON DELETE  CASCADE
);