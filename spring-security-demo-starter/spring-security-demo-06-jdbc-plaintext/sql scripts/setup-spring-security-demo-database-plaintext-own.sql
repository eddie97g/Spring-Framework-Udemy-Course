DROP DATABASE IF EXISTS `spring_security_demo_plaintext`;

CREATE DATABASE IF NOT EXISTS `spring_security_demo_plaintext`;

USE `spring_security_demo_plaintext`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`(
    `username` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,
    `enabled` tinyint(1) NOT NULL,

    PRIMARY KEY (`username`)
) Engine=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users`
VALUES
('john', '{noop}test123', 1),
('mary', '{noop}test123', 1),
('susan', '{noop}test123', 1);

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
    `username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,

    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),

    CONSTRAINT `authorities_ibfk_1`
    FOREIGN KEY (`username`)
    REFERENCES `users` (`username`)
) Engine=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities`
VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_ADMIN');