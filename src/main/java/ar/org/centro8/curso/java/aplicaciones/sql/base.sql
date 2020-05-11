drop database if exists negocioWeb;
create database negocioWeb;
use negocioweb;

create table clientes(
    id int auto_increment primary key,
    nombre varchar(20) not null,
    apellido varchar(20) not null,
    tipoDocumento enum('DNI','LC','LE','PASS'),
    numeroDocumento char(8),
    direccion varchar(50),
    comentarios varchar(250)
);

alter table clientes
    add constraint I_Clientes_Tipo_DNI
    unique(tipoDocumento,numeroDocumento);

create table articulos(
    id int auto_increment primary key,
    descripcion varchar(50) not null,
    costo float,
    precio float,
    stock int,
    stockMin int,
    stockMax int
);

create table facturas(
    id int auto_increment primary key,
    letra enum('A','B','C') not null,
    numero int not null,
    fecha char(10),
    monto double,
    idCliente int not null
);

alter table facturas
    add constraint I_Facturas_Letra_Numero
    unique(letra,numero);

alter table facturas
    add constraint FK_Facturas_Cliente_Id
    foreign key(idCliente)
    references clientes(id);

create table detalles(
    idFactura int not null,
    idArticulo int not null,
    precio float not null,
    cantidad int not null,
    primary key(idFactura,idArticulo)
);

alter table detalles
    add constraint FK_Detalles_IdFactura
    foreign key(idFactura)
    references facturas(id);

alter table detalles
    add constraint FK_Detalles_IdArticulo
    foreign key(idArticulo)
    references articulos(id);


select * from clientes;