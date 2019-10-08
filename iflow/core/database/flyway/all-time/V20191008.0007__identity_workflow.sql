

ALTER TABLE `iflow`.`workflow` ADD COLUMN `identity` VARCHAR(30) NOT NULL AFTER `id`, ADD UNIQUE INDEX `identity_UNIQUE` (`identity` ASC);

ALTER TABLE `iflow`.`workflow_files` ADD COLUMN `identity` VARCHAR(30) NOT NULL AFTER `id`, ADD UNIQUE INDEX `identity_UNIQUE` (`identity` ASC);