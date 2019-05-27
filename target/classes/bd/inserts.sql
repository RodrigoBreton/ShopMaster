INSERT INTO producto(id, nombre, precio) VALUES (1, "Tablet", "15.5");
INSERT INTO producto(id, nombre, precio) VALUES (3, "Televisor Samsung", "1500");
INSERT INTO producto(id, nombre, precio) VALUES (4, "Microondas", "29.99");
INSERT INTO producto(id, nombre, precio) VALUES (5, "PlayStation 4", "320");
INSERT INTO producto(id, nombre, precio) VALUES (6, "XBOX ONE", "250");

INSERT INTO direccion(id, calle, portal, piso, codigo_postal, ciudad) VALUES (1, "Calle Barcelona", "4", "5", 15010, "Coruña");
INSERT INTO direccion(id, calle, portal, piso, codigo_postal, ciudad) VALUES (2, "Marineda", "Bajo 6", "1A", 15010, "Coruña");
INSERT INTO direccion(id, calle, portal, piso, codigo_postal, ciudad) VALUES (3, "Marineda", "Bajo 2", "5C", 15010, "Coruña");

INSERT INTO cliente(id, id_direccion, nombre, apellidos, email, nombre_usuario, password) VALUES (1, 1, "Rodrigo", "Breton Bezerra", "rodrigobreton98@gmail.com", "Rodri98", "password");

INSERT INTO tienda(id, nombre, id_direccion) VALUES (1, "Mediamark", 1);
INSERT INTO tienda(id, nombre, id_direccion) VALUES (2, "Worten", 2);