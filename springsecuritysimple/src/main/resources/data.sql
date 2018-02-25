insert into Tarea  (code, descripcion, usuario,horas) values('tar1','tarea 1','jordi',4)

insert into Proyecto  (codigo, descripcion, usuario) values('appl','proyect 1','jordi')
insert into Proyecto  (codigo, descripcion, usuario) values('ams','mantenim ','jordi')
insert into Proyecto  (codigo, descripcion, usuario) values('ams','mantenim ','jose')

insert into users (username,password,enabled) values('jordi','omd',true)
insert into authorities (username,authority) values('jordi','JEFE')