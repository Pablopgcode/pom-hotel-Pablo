-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pom_hotel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pom_hotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pom_hotel` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `pom_hotel` ;

-- -----------------------------------------------------
-- Table `pom_hotel`.`roomtypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pom_hotel`.`roomtypes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `description` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `pom_hotel`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pom_hotel`.`rooms` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `fk_roomtype_id` BIGINT NULL DEFAULT NULL,
  `code` VARCHAR(100) NULL DEFAULT NULL,
  `description` VARCHAR(300) NULL DEFAULT NULL,
  `pricePerNight` DOUBLE NULL DEFAULT NULL,
  `image` VARCHAR(100) NULL DEFAULT NULL,
  `guests` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_roomtype_id` (`fk_roomtype_id` ASC) VISIBLE,
  CONSTRAINT `rooms_ibfk_1`
    FOREIGN KEY (`fk_roomtype_id`)
    REFERENCES `pom_hotel`.`roomtypes` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `pom_hotel`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pom_hotel`.`clients` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `lastname` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `pom_hotel`.`bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pom_hotel`.`bookings` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `fk_client_id` BIGINT NULL DEFAULT NULL,
  `fk_room_id` BIGINT NULL DEFAULT NULL,
  `checkIn` DATE NULL DEFAULT NULL,
  `checkOut` DATE NULL DEFAULT NULL,
  `totalPrice` DOUBLE NULL DEFAULT NULL,
  `safebox` TINYINT NULL DEFAULT '0',
  `wedge` TINYINT NULL DEFAULT '0',
  `laundry` TINYINT NULL DEFAULT '0',
  `parking` TINYINT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `fk_room_id` (`fk_room_id` ASC) VISIBLE,
  INDEX `fk_client_id` (`fk_client_id` ASC) VISIBLE,
  CONSTRAINT `bookings_ibfk_1`
    FOREIGN KEY (`fk_room_id`)
    REFERENCES `pom_hotel`.`rooms` (`id`),
  CONSTRAINT `bookings_ibfk_2`
    FOREIGN KEY (`fk_client_id`)
    REFERENCES `pom_hotel`.`clients` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 75
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `pom_hotel`.`logins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pom_hotel`.`logins` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `fk_client_id` BIGINT NULL DEFAULT NULL,
  `username` VARCHAR(100) NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `role` VARCHAR(100) NULL DEFAULT NULL,
  `enabled` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `fk_client_id` (`fk_client_id` ASC) VISIBLE,
  UNIQUE INDEX `username` (`username` ASC) VISIBLE,
  CONSTRAINT `logins_ibfk_1`
    FOREIGN KEY (`fk_client_id`)
    REFERENCES `pom_hotel`.`clients` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
