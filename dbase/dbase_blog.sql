
create database blog;

use blog;

CREATE TABLE if not exists grupo (
    IdGrupo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50)
);

create table if not exists permiso(
IdPermiso int not null auto_increment primary key,
Nombre varchar(50)
);

create table if not exists grupo_permiso(
IdGrupo int not null,
IdPermiso int not null, 
foreign key(IdGrupo) references grupo(IdGrupo),
foreign key(IdPermiso) references permiso(IdPermiso)
);

create table if not exists usuario(
IdUsuario int not null auto_increment primary key,
Nombre varchar(50) not null,
Apellido varchar(50) not null,
Contrasena varchar(50) not null,
Correo varchar(50) not null unique,
IdGrupo int not null,
foreign key(IdGrupo) references grupo(IdGrupo)
);

create table if not exists categoria(
IdCategoria int not null auto_increment primary key,
Nombre varchar(50) not null,
Descripcion varchar(100)not null,
Fecha datetime default now(),
CategoriaSuperior int,
foreign key(CategoriaSuperior) references categoria(IdCategoria)
);

create table  if not exists post(
IdPost int not null auto_increment primary key,
Titulo varchar(100) not null,
Slug varchar(75) not null,
Extracto varchar(50) not null,
IdUsuario int not null,
Categoria int not null,
ImagenDestacada varchar(255),
Tipo varchar(50) not null,
foreign key(Categoria) references categoria(IdCategoria),
foreign key(IdUsuario) references usuario(IdUsuario)
);

create table if not exists contenido(
IdContenido int not null auto_increment primary key,
Tipo varchar(50) not null,
Contenido varchar(500) not null,
IdPost int not null,
foreign key(IdPost) references post(IdPost)
);

create table if not exists post_metadata(
IdPostMetadata int not null auto_increment primary key,
Clave varchar(500),
Valor varchar(500),
Tipo varchar(50),
Idpost int not null,
foreign key(IdPost) references post(IdPost)
);

create table if not exists comentario(
IdCOmentario int not null auto_increment primary key,
Comentario varchar(500) not null,
Idpost int not null,
IdUsuario int not null,
Fecha datetime default now(),
Respuesta int,
foreign key(IdPost) references post(IdPost),
foreign key(IdUsuario) references usuario(IdUsuario),
foreign key(Respuesta) references Comentario(IdCOmentario)
);

create table if not exists usuario_metadata(
IdUsuarioMetadata INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
IdUsuario int not null,
Clave varchar(500),
Valor varchar(500),
Tipo varchar(50),
foreign key(IdUsuario) references usuario(IdUsuario)
);



