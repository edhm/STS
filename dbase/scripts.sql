create table usuario(

idUsuario int not null auto_increment primary key,
Nombre varchar(50) not null,
Apellido varchar(50) not null,
Contrasena varchar(50) not null,
Correo varchar(50) not null unique
);