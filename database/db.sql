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
-- Table `mydb`.`nguoi_dung`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`nguoi_dung` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ten` TEXT NOT NULL,
  `email` TEXT NOT NULL,
  `hinh_dai_dien` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tai_khoan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tai_khoan` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `account` TEXT NOT NULL,
  `password` TEXT NOT NULL,
  `type` VARCHAR(255) NOT NULL,
  `nguoi_dung_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `account_UNIQUE` (`account` ASC) VISIBLE,
  INDEX `fk_tai_khoan_nguoi_dung_idx` (`nguoi_dung_id` ASC) VISIBLE,
  CONSTRAINT `fk_tai_khoan_nguoi_dung`
    FOREIGN KEY (`nguoi_dung_id`)
    REFERENCES `mydb`.`nguoi_dung` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`play_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`play_list` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ten` TEXT NOT NULL,
  `ngay_tao` DATETIME NULL,
  `nguoi_tao` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `nguoi_tao_idx` (`nguoi_tao` ASC) VISIBLE,
  CONSTRAINT `nguoi_tao`
    FOREIGN KEY (`nguoi_tao`)
    REFERENCES `mydb`.`nguoi_dung` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`bai_hat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`bai_hat` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ten` TEXT NOT NULL,
  `link` LONGTEXT NOT NULL,
  `url` LONGTEXT NOT NULL,
  `ngay_tao` DATETIME NULL,
  `nguoi_tao` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `nguoi_tao_idx` (`nguoi_tao` ASC) VISIBLE,
  CONSTRAINT `nguoi_tao`
    FOREIGN KEY (`nguoi_tao`)
    REFERENCES `mydb`.`nguoi_dung` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`play_list_bai_hat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`play_list_bai_hat` (
  `play_list_id` BIGINT NOT NULL,
  `bai_hat_id` BIGINT NOT NULL,
  PRIMARY KEY (`play_list_id`, `bai_hat_id`),
  INDEX `fk_play_list_has_bai_hat_bai_hat1_idx` (`bai_hat_id` ASC) VISIBLE,
  INDEX `fk_play_list_has_bai_hat_play_list1_idx` (`play_list_id` ASC) VISIBLE,
  CONSTRAINT `fk_play_list_has_bai_hat_play_list1`
    FOREIGN KEY (`play_list_id`)
    REFERENCES `mydb`.`play_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_play_list_has_bai_hat_bai_hat1`
    FOREIGN KEY (`bai_hat_id`)
    REFERENCES `mydb`.`bai_hat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`the_loai`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`the_loai` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ten` LONGTEXT NOT NULL,
  `ngay_tao` DATETIME NULL,
  `nguoi_tao` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `nguoi_tao_idx` (`nguoi_tao` ASC) VISIBLE,
  CONSTRAINT `nguoi_tao`
    FOREIGN KEY (`nguoi_tao`)
    REFERENCES `mydb`.`nguoi_dung` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`the_loai_bai_hat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`the_loai_bai_hat` (
  `the_loai_id` BIGINT NOT NULL,
  `bai_hat_id` BIGINT NOT NULL,
  PRIMARY KEY (`the_loai_id`, `bai_hat_id`),
  INDEX `fk_the_loai_has_bai_hat_bai_hat1_idx` (`bai_hat_id` ASC) VISIBLE,
  INDEX `fk_the_loai_has_bai_hat_the_loai1_idx` (`the_loai_id` ASC) VISIBLE,
  CONSTRAINT `fk_the_loai_has_bai_hat_the_loai1`
    FOREIGN KEY (`the_loai_id`)
    REFERENCES `mydb`.`the_loai` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_the_loai_has_bai_hat_bai_hat1`
    FOREIGN KEY (`bai_hat_id`)
    REFERENCES `mydb`.`bai_hat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ca_si`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ca_si` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ten` TEXT NOT NULL,
  `gioi_thieu` LONGTEXT NULL,
  `ngay_tao` DATETIME NULL,
  `nguoi_tao` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `nguoi_tao_idx` (`nguoi_tao` ASC) VISIBLE,
  CONSTRAINT `nguoi_tao`
    FOREIGN KEY (`nguoi_tao`)
    REFERENCES `mydb`.`nguoi_dung` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`bai_hat_ca_si`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`bai_hat_ca_si` (
  `bai_hat_id` BIGINT NOT NULL,
  `ca_si_id` BIGINT NOT NULL,
  PRIMARY KEY (`bai_hat_id`, `ca_si_id`),
  INDEX `fk_bai_hat_has_ca_si_ca_si1_idx` (`ca_si_id` ASC) VISIBLE,
  INDEX `fk_bai_hat_has_ca_si_bai_hat1_idx` (`bai_hat_id` ASC) VISIBLE,
  CONSTRAINT `fk_bai_hat_has_ca_si_bai_hat1`
    FOREIGN KEY (`bai_hat_id`)
    REFERENCES `mydb`.`bai_hat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bai_hat_has_ca_si_ca_si1`
    FOREIGN KEY (`ca_si_id`)
    REFERENCES `mydb`.`ca_si` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`album` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ten` TEXT NOT NULL,
  `gioi_thieu` LONGTEXT NULL,
  `ngay_tao` DATETIME NULL,
  `nguoi_tao` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `nguoi_tao_idx` (`nguoi_tao` ASC) VISIBLE,
  CONSTRAINT `nguoi_tao`
    FOREIGN KEY (`nguoi_tao`)
    REFERENCES `mydb`.`nguoi_dung` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`album_bai_hat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`album_bai_hat` (
  `album_id` BIGINT NOT NULL,
  `bai_hat_id` BIGINT NOT NULL,
  PRIMARY KEY (`album_id`, `bai_hat_id`),
  INDEX `fk_album_has_bai_hat_bai_hat1_idx` (`bai_hat_id` ASC) VISIBLE,
  INDEX `fk_album_has_bai_hat_album1_idx` (`album_id` ASC) VISIBLE,
  CONSTRAINT `fk_album_has_bai_hat_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `mydb`.`album` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_album_has_bai_hat_bai_hat1`
    FOREIGN KEY (`bai_hat_id`)
    REFERENCES `mydb`.`bai_hat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
