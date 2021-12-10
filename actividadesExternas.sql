drop database if exists actividadesAula;
create database if not exists actividadesAula;
USE actividadesAula;

create table Profesor(
dni varchar (25) primary key not null,
nrp varchar(25) not null,
nombre varchar(25) not null,
domicilio varchar(25) not null,
asignatura varchar(25) not null
)
ENGINE=INNODB;

create table DiaParcial(
id bool not null primary key,
diurno bool not null,
nocturno bool not null
)
ENGINE=INNODB;

create table Actividad(
id int not null,
nombre varchar(25) not null,
profesor varchar(25),
fechaRealizar date not null,
diaC bool not null,
diaP bool not null, 
FOREIGN KEY (diaP)
      REFERENCES DiaParcial(id)
      ON UPDATE CASCADE ON DELETE RESTRICT,
fechaActual date not null,
 FOREIGN KEY (profesor)
      REFERENCES Profesor(dni)
      ON UPDATE CASCADE ON DELETE RESTRICT
)
ENGINE=INNODB;



INSERT INTO Profesor 
VALUES 
('123123v','123','Javier','Talayuela','Talayuela'),
('233444V','213 ','Pablo','635177784','Navalmoral de la Mata');
/*
INSERT INTO DiaParcial
VALUES 
(1,'false','true'),
(2,'true','true');

INSERT INTO Actividad
VALUES 
('12','raul','Javier','2018-10-10','true','true'),
('32','reda','Pablo','2000-09-11','false','false');*/
