DROP DATABASE IF EXISTS linechartdb;
CREATE DATABASE IF NOT EXISTS linechartdb;
USE linechartdb;

CREATE TABLE linechart
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255),
    labelX VARCHAR(50),
    labelY VARCHAR(50)
);

CREATE TABLE rotulosX
(
    rotulo VARCHAR(50),
    id_linechart INT
);

CREATE TABLE rotulosY
(
    rotulo VARCHAR(50),
    id_linechart INT
);

CREATE TABLE pontos
(
    x FLOAT,
    y FLOAT,
    id_linechart INT
);

ALTER TABLE `rotulosX` ADD CONSTRAINT `fk_linechart_rotuloX` FOREIGN KEY ( `id_linechart` ) REFERENCES `linechart` ( `id` );
ALTER TABLE `rotulosY` ADD CONSTRAINT `fk_linechart_rotuloY` FOREIGN KEY ( `id_linechart` ) REFERENCES `linechart` ( `id` );
ALTER TABLE `pontos` ADD CONSTRAINT `fk_linechart_pontos` FOREIGN KEY ( `id_linechart` ) REFERENCES `linechart` ( `id` );
