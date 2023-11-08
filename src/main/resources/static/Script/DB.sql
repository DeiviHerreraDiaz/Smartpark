use smartpark;

select * from usuario;

insert into rol (nombre) values 
("Aprendiz"),
("Funcionario"),
("Invitado"),
("Administrador");

insert into usuario (documento,apellido,estado,nombre,proveniente,telefono,id_rol_fk) values
("1028480560","Moreno",true,"Brayan","","3117382120",4),
("1234567892","Vega",false,"Laura","","987654321",4),
("1033679469","Herrera",true,"Deivi","","3044028836",4),
("1013106777","Vargas",false,"Dayana","Centro de Gestión Industrial","321456789",3),
("1000000001","Lopez",true,"Luis","Centro de Informática","300111222",2),
("1000000002","Gomez",false,"Carlos","Centro de Diseño","311222333",1),
("1000000003","Perez",true,"Maria","Centro de Administración","322333444",2),
("1000000004","Rodriguez",false,"Elena","Centro de Idiomas","333444555",1),
("1000000005","Gonzalez",true,"Pedro","Centro de Arte","344455566",2),
("1000000006","Torres",false,"Ana","Centro de Ciencias Sociales","355566677",1),
("1000000007","Sanchez",true,"Daniel","Centro de Ciencias Naturales","366677788",2),
("1000000008","Ramirez",false,"Monica","Centro de Música","377788899",1),
("1000000009","Martinez",true,"Jose","Centro de Deportes","388899900",2),
("1000000010","Lopez",false,"Carla","Centro de Agricultura","399900011",1),
("1000000011","Gomez",true,"Roberto","Centro de Arquitectura","400011122",2),
("1000000012","Perez",false,"Linda","Centro de Medicina","411122233",1),
("1000000013","Rodriguez",true,"Raul","Centro de Psicología","422233344",2),
("1000000014","Gonzalez",false,"Luisa","Centro de Derecho","433344455",1),
("1000000015","Torres",true,"Andres","Centro de Economía","444455566",2),
("1000000016","Sanchez",false,"Lucia","Centro de Historia","455566677",1),
("1000000017","Ramirez",true,"Javier","Centro de Geografía","466677788",2),
("1000000018","Martinez",false,"Carmen","Centro de Filosofía","477788899",1),
("1000000019","Lopez",true,"Miguel","Centro de Química","488899900",2),
("1000000020","Gomez",false,"Isabel","Centro de Biología","499900011",1),
("1000000021","Perez",true,"Alejandro","Centro de Física","500011122",2),
("1000000022","Rodriguez",false,"Laura","Centro de Matemáticas","511122233",1),
("1000000023","Gonzalez",true,"Eduardo","Centro de Estadística","522233344",2),
("1000000024","Torres",false,"Silvia","Centro de Información","533344455",1),
("1000000025","Sanchez",true,"Juan","Centro de Literatura","544455566",2),
("1000000026","Ramirez",false,"Rosa","Centro de Lingüística","555566677",1),
("1000000027","Martinez",true,"Sergio","Centro de Relaciones Públicas","566677788",2);

insert into equipo (estado,marca,serie,tipo,documento) values 
(true,"Acer","1028480560","Portatil","1028480560"),
(true,"Victus","455GH","Portatil","1033679469"),
(true,"Hp","fdsa5","Portatil","1028480560"),
(true,"Camera asus","fds45","Camara","1028480560"),
(true,"Dell","1qaz","Portatil","1000000001"),
(true,"Lenovo","2wsx","Portatil","1000000002"),
(true,"Asus","3edc","Portatil","1000000003"),
(true,"HP","4rfv","Camara","1000000004"),
(true,"Acer","5tgb","Portatil","1000000005"),
(true,"Dell","6yhn","Portatil","1000000006"),
(true,"Lenovo","7ujm","Portatil","1000000007"),
(true,"Asus","8ik,","Camara","1000000008"),
(true,"HP","9ol.","Portatil","1000000009"),
(true,"Acer","0p;/","Portatil","1000000010"),
(true,"Dell","[pl,","Portatil","1000000011"),
(true,"Lenovo","]';.","Camara","1000000012"),
(true,"Asus","/.,m","Portatil","1000000013"),
(true,"HP","tgvb","Portatil","1000000014"),
(true,"Acer","yhn,","Portatil","1000000015"),
(true,"Dell","ujm.","Portatil","1000000016"),
(true,"Lenovo","cde3","Camara","1000000017"),
(true,"Asus","vfgr","Portatil","1000000018"),
(true,"HP","tyhn","Portatil","1000000019"),
(true,"Acer","qa2w","Portatil","1000000020"),
(true,"Dell","r4t5","Camara","1000000021");


insert into tipo_vehiculo (nombre) values
("Carro"),
("Moto"),
("Bicicleta");

insert into vehiculo (estado,marca,placa,documento,tipo_vehiculo_fk) values 
(true,"Kawasaki","12fds","1028480560",2),
(true,"Chevrolet","6565HHJ","1033679469",1),
(true,"Pulsar","964961hd","1013106777",2),
(true,"BMX","4Gds6","1234567892",1),
(true,"Toyota","789ABC","1000000001",1),
(true,"Honda","XYZ123","1000000002",2),
(true,"Hyundai","456DEF","1000000003",1),
(true,"Nissan","JKL456","1000000004",2),
(true,"Ford","789MNO","1000000005",1),
(true,"Mazda","PQR789","1000000006",2),
(true,"Volkswagen","STU123","1000000007",1),
(true,"Audi","VWX456","1000000008",2),
(true,"Mercedes-Benz","YZA789","1000000009",1),
(true,"BMW","BCD123","1000000010",2),
(true,"Lexus","EFG456","1000000011",1),
(true,"Subaru","HIJ789","1000000012",2),
(true,"Volvo","KLM123","1000000013",1),
(true,"Porsche","NOP456","1000000014",2),
(true,"Tesla","QRS789","1000000015",1),
(true,"Kia","TUV123","1000000016",2),
(true,"Ferrari","WXY456","1000000017",1),
(true,"Jaguar","ZAB789","1000000018",2),
(true,"Land Rover","CDE123","1000000019",1),
(true,"Jeep","FGH456","1000000020",2);


Insert into tipo_movimiento (tipo) values
("Entrada"),
("Salida");