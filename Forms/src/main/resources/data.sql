insert into cliente (user_name, pass, nombrecompleto, correo,telefono,direccion, monto, rol) values ('AlexB','pass1','Alejandro Bernal', 'aleebernal@gmail.com', '8128686516','Escobedo',1254.00, 0);
insert into cliente (user_name, pass, nombrecompleto, correo,telefono,direccion, monto, rol) values ('CesarL','pass2','Cesar Leos', 'emoxito@gmail.com', '8156657980','Guadalupe',158.00, 0);
insert into cliente (user_name, pass, nombrecompleto, correo,telefono,direccion, monto, rol) values ('UnAdmin','pass3','Admin', 'admin@gmail.com', '12345','Monterrey',10, 1);

-- insert into rol (nombre) values ('ROLE_ADMIN');
-- insert into rol (nombre) values ('ROLE_CLIENTE');


insert into prestamo (cliente_id, monto, fecha_creacion, fecha_expiracion, tipo,abonototal,pagado) values (2,300.00,'1998-12-10','1998-12-19',1,60,0);
insert into prestamo (cliente_id, monto, fecha_creacion, fecha_expiracion, tipo,abonototal,pagado) values (1,123.00,'1998-10-10','1998-10-19',1,50,0);