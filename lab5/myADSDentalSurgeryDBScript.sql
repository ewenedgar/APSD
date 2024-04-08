-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`address` (
  `iaddress_d` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zip` VARCHAR(45) NULL,
  PRIMARY KEY (`iaddress_d`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`patient` (
  `patient_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `contact_phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `date_of_birth` VARCHAR(45) NULL,
  `address_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`patient_id`),
  INDEX `fk_patient_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_patient_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `mydb`.`address` (`iaddress_d`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dentist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`dentist` (
  `dentist_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `contact_phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `specialization` INT NOT NULL,
  PRIMARY KEY (`dentist_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`surgery_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`surgery_location` (
  `id_surgery_location` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `location_address` INT NULL,
  `contact_phone` VARCHAR(45) NULL,
  `appointment_dentist_id` INT NOT NULL,
  `appointment_surgery_location_id` INT NOT NULL,
  `address_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_surgery_location`),
  INDEX `fk_surgery_location_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_surgery_location_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `mydb`.`address` (`iaddress_d`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`appointment` (
  `id_appointment` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NULL,
  `time` VARCHAR(45) NULL,
  `confirmed` VARCHAR(6) NULL DEFAULT 'false',
  `patient_id` INT UNSIGNED NOT NULL,
  `dentist_id` INT UNSIGNED NOT NULL,
  `surgery_location_id_surgery_location` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_appointment`),
  INDEX `fk_appointment_patient1_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_appointment_dentist1_idx` (`dentist_id` ASC) VISIBLE,
  INDEX `fk_appointment_surgery_location1_idx` (`surgery_location_id_surgery_location` ASC) VISIBLE,
  CONSTRAINT `fk_appointment_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `mydb`.`patient` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_dentist1`
    FOREIGN KEY (`dentist_id`)
    REFERENCES `mydb`.`dentist` (`dentist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_surgery_location1`
    FOREIGN KEY (`surgery_location_id_surgery_location`)
    REFERENCES `mydb`.`surgery_location` (`id_surgery_location`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`specialization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`specialization` (
  `id_specialization` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `dentist_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id_specialization`),
  INDEX `fk_specialization_dentist1_idx` (`dentist_id` ASC) VISIBLE,
  CONSTRAINT `fk_specialization_dentist1`
    FOREIGN KEY (`dentist_id`)
    REFERENCES `mydb`.`dentist` (`dentist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
