DROP DATABASE IF EXISTS `spring_security_demo_bcrypt`;

CREATE DATABASE IF NOT EXISTS `spring_security_demo_bcrypt`;

USE `spring_security_demo_bcrypt`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`(
    `username` varchar(50) NOT NULL,
    `password` varchar(68) NOT NULL,
    `enabled` tinyint(1) NOT NULL,

    PRIMARY KEY (`username`)
) Engine=InnoDB DEFAULT CHARSET=latin1;

-- A generation tool is available at www.luv2code.com/generate-bcrypt-password
-- Default passwords here are: test123
INSERT INTO `users`
VALUES
('john', '{bcrypt}$2a$10$DvdLLrpFavBRl7Z8taexFOoHDUBOLEbEFCHaAdNir0LdjPQoxai62', 1),
('mary', '{bcrypt}$2a$10$SGJInrx53h4U888nZARkZeLLGa4p5Lqgpki7pGbWUjVNwHhmkxtDm', 1),
('susan', '{bcrypt}$2a$10$/Vzh0azAmDtkiIeqKD208eqvaRzUFdFyV0g2p0Zmj9VoMQ2GcnGr2', 1);

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