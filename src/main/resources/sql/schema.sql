DROP TABLE ampabl.prestamos if exists;
DROP TABLE ampabl.ejemplares if exists; 
DROP TABLE ampabl.libros if exists;
DROP TABLE ampabl.usuarios if exists;  
DROP TABLE ampabl.cursosasignaturas if exists;
DROP TABLE ampabl.asignaturas if exists;
DROP TABLE ampabl.alumnos if exists;
DROP TABLE ampabl.socios if exists; 
DROP TABLE ampabl.cursos if exists;
drop sequence if exists hibernate_sequence;

/*Crear cursos*/
CREATE TABLE `ampabl`.`cursos` (
  `idcurso`BIGINT NOT NULL,
  `nombrecurso` VARCHAR(70) NULL,
  PRIMARY KEY (`idcurso`));
  
/*Crear socios*/
CREATE TABLE `ampabl`.`socios` (
  `idsocios` BIGINT NOT NULL,  
  `nombrepadre` VARCHAR(70) NULL,
  `apellido1padre` VARCHAR(70) NULL,
  `apellido2padre` VARCHAR(70) NULL,
  `dnipadre` VARCHAR(10) NULL,
  `nombremadre` VARCHAR(70) NULL,
  `apellido1madre` VARCHAR(70) NULL,
  `apellido2madre` VARCHAR(70) NULL,
  `dnimadre` VARCHAR(10) NULL,
  `telefono` VARCHAR(9) NULL,
  `nombre` VARCHAR(170) NULL,
  `alta` BIGINT NULL,
  `numhijos` BIGINT NULL,
  `pagado` TINYINT NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idsocios`));
  
 /*Crear alumnos*/
CREATE TABLE `ampabl`.`alumnos` (
  `idalumnos` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido1` VARCHAR(70) NULL,
  `apellido2` VARCHAR(70) NULL,
  `curso` BIGINT NULL,
  `numsocio`BIGINT NULL,
  `prestamo`BIGINT NULL,
  PRIMARY KEY (`idalumnos`),
  INDEX `cursos_idx` (`cursos` ASC) VISIBLE,
  INDEX `socios_idx` (`numsocio` ASC) VISIBLE,
  INDEX `prestamos_idx` (`prestamo` ASC) VISIBLE,
  CONSTRAINT `cursos`
    FOREIGN KEY (`curso`)
    REFERENCES `ampabl`.`cursos` (`idcurso`)
   ,
  CONSTRAINT `socios`
    FOREIGN KEY (`numsocio`)
    REFERENCES `ampabl`.`socios` (`idsocios`)
    );

/*Crear asignaturas */
CREATE TABLE `ampabl`.`asignaturas` (
  `idasignaturas` BIGINT NOT NULL,
  `nombreasignaturas` VARCHAR(200) NULL,
   `curso` BIGINT NULL,
   `libro` BIGINT NULL,
  PRIMARY KEY (`idasignaturas`));

/*Crear usuarios*/
CREATE TABLE `ampabl`.`usuarios` (
  `idusuarios` BIGINT NOT NULL,
  `nombre` VARCHAR(70) NULL,
  `cargo` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(170) NULL,
  `rol` VARCHAR(45) NULL
  PRIMARY KEY (`idusuarios`));

/*Crear libros*/
CREATE TABLE `ampabl`.`libros` (
  `idlibros` BIGINT NOT NULL,
  `titulo` VARCHAR(200) NULL,
  `asignaturas` BIGINT NULL,
  `numejemplares` BIGINT NULL,
  `estado` VARCHAR(45)NULL,
  PRIMARY KEY (`idlibros`),
  INDEX `cursoasignaturas_idx` (`ca` ASC) VISIBLE,
  CONSTRAINT `cursoasignaturas`
    FOREIGN KEY (`ca`)
    REFERENCES `ampabl`.`cursosasignaturass` (`idcursosasignaturass`)
 );

/*Crear ejemplares*/
CREATE TABLE `ampabl`.`ejemplares` (
  `idejemplares` BIGINT NOT NULL,
  `libro` BIGINT NULL,
  `estado` VARCHAR(45) NULL,
  `alumno` BIGINT NULL,
  `prestamo` BIGINT NULL,
  PRIMARY KEY (`idejemplares`),
  INDEX `libroorigen_idx` (`libro` ASC) VISIBLE,
  INDEX `alumno_idx` (`alumno` ASC) VISIBLE,
  CONSTRAINT `libroorigen`
    FOREIGN KEY (`libro`)
    REFERENCES `ampabl`.`libros` (`idlibros`),
 
  CONSTRAINT `alumno`
    FOREIGN KEY (`alumno`)
    REFERENCES `ampabl`.`alumnos` (`idalumnos`)
    ); 

/*Crear prestamos */
CREATE TABLE `ampabl`.`prestamos` (
  `idprestamos` BIGINT NOT NULL,
  `fecha` DATE NULL, 
  `alumno` BIGINT NULL,
  
  PRIMARY KEY (`idprestamos`),
  INDEX `alumno_idx` (`alumno` ASC) VISIBLE,
 
  CONSTRAINT `alumno`
    FOREIGN KEY (`alumno`)
    REFERENCES `ampabl`.`alumnos` (`idalumnos`)
    );
