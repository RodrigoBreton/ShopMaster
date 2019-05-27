-- MySQL Script generated by MySQL Workbench
-- Fri May 24 15:58:54 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema shopmaster
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `shopmaster` ;

-- -----------------------------------------------------
-- Schema shopmaster
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopmaster` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `shopmaster` ;

-- -----------------------------------------------------
-- Table `shopmaster`.`direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopmaster`.`direccion` ;

CREATE TABLE IF NOT EXISTS `shopmaster`.`direccion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(150) NULL DEFAULT NULL,
  `portal` VARCHAR(20) NULL DEFAULT NULL,
  `piso` VARCHAR(40) NULL DEFAULT NULL,
  `codigo_postal` INT(11) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopmaster`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopmaster`.`cliente` ;

CREATE TABLE IF NOT EXISTS `shopmaster`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_direccion` INT(11) NULL DEFAULT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `nombre_usuario` VARCHAR(100) NULL DEFAULT NULL,
  `password` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_direccion` (`id_direccion` ASC) VISIBLE,
  CONSTRAINT `cliente_ibfk_1`
    FOREIGN KEY (`id_direccion`)
    REFERENCES `shopmaster`.`direccion` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopmaster`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopmaster`.`producto` ;

CREATE TABLE IF NOT EXISTS `shopmaster`.`producto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `precio` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopmaster`.`tienda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopmaster`.`tienda` ;

CREATE TABLE IF NOT EXISTS `shopmaster`.`tienda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `id_direccion` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_direccion` (`id_direccion` ASC) VISIBLE,
  CONSTRAINT `tienda_ibfk_1`
    FOREIGN KEY (`id_direccion`)
    REFERENCES `shopmaster`.`direccion` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopmaster`.`productos_tiendas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopmaster`.`productos_tiendas` ;

CREATE TABLE IF NOT EXISTS `shopmaster`.`productos_tiendas` (
  `id_producto` INT(11) NOT NULL,
  `id_tienda` INT(11) NOT NULL,
  PRIMARY KEY (`id_producto`, `id_tienda`),
  INDEX `id_tienda` (`id_tienda` ASC) VISIBLE,
  CONSTRAINT `productos_tiendas_ibfk_1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `shopmaster`.`producto` (`id`),
  CONSTRAINT `productos_tiendas_ibfk_2`
    FOREIGN KEY (`id_tienda`)
    REFERENCES `shopmaster`.`tienda` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
