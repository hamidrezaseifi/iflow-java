

ALTER TABLE `iflow`.`workflow` ADD COLUMN `identity` VARCHAR(20) NOT NULL AFTER `id`, ADD UNIQUE INDEX `identity_UNIQUE` (`identity` ASC);