CREATE SCHEMA `restaurant` ;
CREATE TABLE `restaurant`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userid_UNIQUE` (`userId` ASC));

CREATE TABLE `restaurant`.`restaurant_details` (
  `restId` INT NOT NULL AUTO_INCREMENT,
  `restName` VARCHAR(50) NOT NULL,
  `location` VARCHAR(50) NOT NULL,
  `rate_avg` FLOAT ZEROFILL NOT NULL,
  `count` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`restId`),
  UNIQUE INDEX `restId_UNIQUE` (`restId` ASC));

CREATE TABLE `restaurant`.`rate_review` (
  `rate_reviewId` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `rest_id` INT NOT NULL,
  `rate` INT NOT NULL,
  `review` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`rate_reviewId`),
  UNIQUE INDEX `rate_reviewId_UNIQUE` (`rate_reviewId` ASC),
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `rest_id_idx` (`rest_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `restaurant`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `rest_id`
    FOREIGN KEY (`rest_id`)
    REFERENCES `restaurant`.`restaurant_details` (`restId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
	