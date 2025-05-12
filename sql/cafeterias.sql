/*---TABLA PRODUCTO---*/
CREATE TABLE producto (
    id_producto INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
    nombre VARCHAR(50) NOT NULL, 
    precio DECIMAL(6,2),
    tipo VARCHAR(30),
    proveedor VARCHAR(50),
    CONSTRAINT precio_pos CHECK (precio > 0),
    PRIMARY KEY (id_producto)
);

/*---TABLA EMPLEADO---*/
CREATE TABLE empleado (
    id_empleado INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
    nombre VARCHAR(50),
    salario DECIMAL(6,2),
    fecha_alta_empresa DATE,
    dni VARCHAR(10),
    CONSTRAINT salario_pos CHECK (salario > 0),
    PRIMARY KEY (id_empleado)
);

/*---TABLA CAFETERIA---*/
CREATE TABLE cafeteria (
    id_cafeteria INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
    horario VARCHAR(50),
    direccion VARCHAR(50) NOT NULL, 
    aforo_local INT,
    precio_alquiler DECIMAL(10,2),
    gerente INT,
    CONSTRAINT fk_gerente FOREIGN KEY (gerente) REFERENCES empleado (id_empleado),
    CONSTRAINT precio_alq_pos CHECK (precio_alquiler > 0),
    PRIMARY KEY (id_cafeteria)
);

/*---TABLA ALMACENA---*/
CREATE TABLE almacena (
    id_producto INT,
    id_cafeteria INT,
    stock INT,
    PRIMARY KEY (id_producto, id_cafeteria),
    CONSTRAINT fk_producto FOREIGN KEY (id_producto) REFERENCES producto (id_producto) ON DELETE CASCADE,
    CONSTRAINT fk_cafeteria FOREIGN KEY (id_cafeteria) REFERENCES cafeteria (id_cafeteria) ON DELETE CASCADE,
    CONSTRAINT stock_pos CHECK (stock >= 0)
);

/*---TABLA TRABAJA EN---*/
CREATE TABLE trabaja_en (
    id_empleado INT,
    id_cafeteria INT,
    horario_trabajo VARCHAR(50),
    PRIMARY KEY (id_empleado, id_cafeteria),
    CONSTRAINT fk_empleado FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado) ON DELETE CASCADE,
    CONSTRAINT fk_tr_cafeteria FOREIGN KEY (id_cafeteria) REFERENCES cafeteria (id_cafeteria) ON DELETE CASCADE
);

/*---TRIGGER ELIMINAR RELACIONES SIN STOCK---*/
CREATE TRIGGER eliminar_sin_stock
AFTER UPDATE OF STOCK ON ALMACENA
DELETE FROM ALMACENA WHERE STOCK <= 0;

/*--- INSERTAR EMPLEADOS---*/
INSERT INTO EMPLEADO(nombre, salario,fecha_alta_empresa, dni)
VALUES('Ricardo Lopez', 2157.98, DATE('2020-01-12'), '33789412G');
INSERT INTO EMPLEADO(nombre, salario,fecha_alta_empresa, dni)
VALUES('Juan Alberto Diaz', 3161.00, DATE('2015-11-07'), '14589637T');
INSERT INTO EMPLEADO(nombre, salario,fecha_alta_empresa, dni)
VALUES('Willy Rodriguez', 2020.00, DATE('2016-07-24'), '45623178Z');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Alejandro Lopez', 5600.50, DATE('2023-02-15'), '12345678A');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Sofia Martinez', 2550.75, DATE('2022-08-22'), '83561247M');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Carlos Garcia', 1500.20, DATE('2010-10-01'), '51479863J');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Laura Fernandez', 1800.59, DATE('2021-11-05'), '98324571K');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Javier Rodriguez', 3650.35, DATE('2023-07-30'), '64713985H');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Carmen Perez', 2580.85, DATE('2022-12-18'), '72985641P');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Fernando Gomez', 4900.40, DATE('2021-06-25'), '35168472D');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Elena Diaz', 6772.60, DATE('2023-09-02'), '49725318C');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Daniel Torres', 2550.10, DATE('2024-03-19'), '68231479Y');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Natalia Ramirez', 1850.95, DATE('2020-05-11'), '75398142B');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Ana Lopez', 3200.50, DATE('2020-03-15'), '45328716K');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Javier Gomez Fernandez', 2875.25, DATE('2019-06-23'), '71854329M');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Arturo Martinez', 1850.95, DATE('2020-05-11'), '52679183B');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Carlos Perez Herrero', 3080.90, DATE('2021-11-12'), '83942567L');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Elena Castillo Ruiz', 4000.25, DATE('2017-09-08'), '14763852V');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Natalia Fernandez Lopez', 2890.50, DATE('2021-07-25'), '71836542R');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Daniel Soto', 3720.10, DATE('2020-11-18'), '52698134A');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Laura Mendez Castillo', 3045.60, DATE('2018-06-05'), '83921765M');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Manuel Torres', 4110.40, DATE('2017-09-03'), '14789532E');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Carla Ruiz Morales', 2980.75, DATE('2019-04-12'), '36592148L');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Emilio Navarro', 3256.25, DATE('2021-03-2'), '58743219J');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Beatriz Delgado Suarez', 3590.80, DATE('2016-08-08'), '21548736K');
INSERT INTO EMPLEADO(nombre, salario, fecha_alta_empresa, dni)
VALUES('Lorena Vazquez Ortega', 3995.20, DATE('2015-01-27'), '63257894Y');

/*--- INSERTAR CAFETERIAS---*/
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('08:30-20:30', 'C/ Alfonso Primero 47', 120, 1540.50, 1);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('06:30-21:30', 'PL España 87', 95, 1240.50, 2);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('08:30-20:30', 'Av Zaragoza 121', 50, 1320.40, 3);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:30-22:00', 'Calle del Sol, 15', 45, 1800, 5);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('08:00-23:00', 'Avenida Del Aroma, 25', 60, 2000, 25);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('09:00-20:00', 'Plaza De Los Libros, 9', 40, 1500, 1);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-20:00', 'Calle Del Cafe, 22', 55, 1700, 4);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('10:00-23:00', 'Calle De La Noche, 7', 50, 1600, 9);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('06:30-22:30', 'Avenida Del Despertar, 32', 65, 2100, 25);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-19:40', 'Paseo De La Creatividad, 3', 45, 1800, 3);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-22:40', 'Calle Mayor, 25', 50, 2550, 17);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('06:00-21:20', 'Avenida Libertad, 12', 80, 3200,15);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:30-19:30', 'Plaza del Sol, 8', 40, 1800, 6);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('08:00-22:00', 'Paseo Independencia, 43', 70, 2800, 22);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-19:00', 'Calle Verde, 10', 60, 1800, 21);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-18:00', 'Calle Del Comercio, 22, Zaragoza', 55, 2800, 9);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-21:00', 'Avenida Central, 25', 65, 3100, 17);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('09:00-23:40', 'Plaza Mayor, 12', 75, 2850,4);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('08:00-23:00', 'Paseo De La Playa, 12', 45, 1900, 22);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-19:00', 'Calle Azul, 5', 70, 2500, 4);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-20:30', 'Calle Primavera, 18', 50, 2450, 11);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:30-22:30', 'Avenida De Los Poetas, 7', 90, 3300, 25);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-17:40', 'Plaza Real, 10', 40, 1700,8);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('08:10-22:00', 'Calle Gran Via, 35', 70, 2880, 14);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('07:00-20:00', 'Avenida Europa, 22', 75, 3150,6);
INSERT INTO CAFETERIA(horario, direccion, aforo_local, precio_alquiler, gerente)
VALUES('08:00-20:30', 'Plaza Wolfgang, 1 ', 55, 2650,20);

/*--- INSERTAR PRODUCTOS---*/
INSERT INTO PRODUCTO(nombre, precio,tipo, proveedor)
VALUES('Cocacola', 2.15, 'Refresco', 'Cocacola');
INSERT INTO PRODUCTO(nombre, precio,tipo, proveedor)
VALUES('Cafe Espresso', 1.90, 'Bebida', 'Pascual');
INSERT INTO PRODUCTO(nombre, precio,tipo, proveedor)
VALUES('Doritos', 1.20, 'Snack', 'Grefusa');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Cafe Colombia', 12.50, 'Cafe en grano', 'Cafe Del Mundo');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Croissant de Matequilla', 1.80, 'Panaderia', 'A La Asturiana');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Leche de Almendra', 2.90, 'Bebida', 'NaturAliment');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Tarta de Zanahoria', 4.50, 'Reposteria', 'Dulces Tradicionales');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Te Verde', 8.75, 'Infusion', 'Tes Del Oriente');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Cafe Espresso', 15.00, 'Cafe Molido', 'Aromas y Delicias');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Muffin de Chocolate', 2.50, 'Reposteria', 'Dulces Del Norte');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Zumo de Naranja', 3.80, 'Babida', 'Frutas Del Valle');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Cappuccino Americano', 3.90, 'Bebida', 'American Premium');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Galletas de Avellana', 2.30, 'Snack', 'HorneaNatural');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Bombones de Chocolate', 6.90, 'Dulces', 'Cacao Real');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Queso Curado', 8.50, 'Lacteos', 'Granjas El Encanto');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Empanadas de Queso', 3.80, 'Snack salado', 'Horno Del Bosque');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Granola Casera Frutos Secos', 7.25, 'Cereal', 'NutriVida');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Helado De Vainilla', 3.50, 'Postre Frio', 'Cafe Del Mundo');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Zumo De Mango', 4.00, 'Bebida Fria', 'Exoticos Tropicales');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Brownie de Chocolate', 3.50, 'Reposteria', 'Dulces Gourmet');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Tostadas con Aguacate', 4.50, 'Comida Ligera', 'Masa Madre');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Smoothie de Frutas', 3.80, 'Bebida Fria', 'Naturaleza en Vaso');
INSERT INTO PRODUCTO(nombre, precio, tipo, proveedor)
VALUES('Tarta de Chocolate', 4.50, 'Reposteria', 'Dulce Tentacion');

/*--- INSERTAR PRODUCTOS EN CAFETERIAS---*/
INSERT INTO almacena VALUES (1, 1, 40);
INSERT INTO almacena VALUES (2, 1, 35);
INSERT INTO almacena VALUES (3, 2, 50);
INSERT INTO almacena VALUES (4, 2, 10);
INSERT INTO almacena VALUES (5, 3, 20);
INSERT INTO almacena VALUES (6, 3, 15);
INSERT INTO almacena VALUES (7, 4, 30);
INSERT INTO almacena VALUES (8, 4, 12);
INSERT INTO almacena VALUES (9, 5, 25);
INSERT INTO almacena VALUES (10, 5, 18);
INSERT INTO almacena VALUES (11, 6, 45);
INSERT INTO almacena VALUES (12, 6, 22);
INSERT INTO almacena VALUES (13, 7, 30);
INSERT INTO almacena VALUES (14, 7, 17);
INSERT INTO almacena VALUES (15, 8, 10);
INSERT INTO almacena VALUES (16, 8, 16);
INSERT INTO almacena VALUES (17, 9, 24);
INSERT INTO almacena VALUES (18, 9, 14);
INSERT INTO almacena VALUES (19, 10, 20);
INSERT INTO almacena VALUES (20, 10, 15);
INSERT INTO almacena VALUES (21, 11, 18);
INSERT INTO almacena VALUES (22, 11, 25);
INSERT INTO almacena VALUES (23, 12, 12);
INSERT INTO almacena VALUES (1, 13, 40);
INSERT INTO almacena VALUES (2, 14, 33);

/*--- INSERTAR EMPLEADOS EN CAFETERIAS---*/
INSERT INTO trabaja_en VALUES (4, 1, '08:30-14:30');
INSERT INTO trabaja_en VALUES (5, 1, '14:30-20:30');
INSERT INTO trabaja_en VALUES (6, 2, '06:30-13:30');
INSERT INTO trabaja_en VALUES (7, 2, '13:30-21:30');
INSERT INTO trabaja_en VALUES (8, 3, '08:30-14:30');
INSERT INTO trabaja_en VALUES (9, 3, '14:30-20:30');
INSERT INTO trabaja_en VALUES (10, 4, '07:30-14:00');
INSERT INTO trabaja_en VALUES (11, 4, '14:00-22:00');
INSERT INTO trabaja_en VALUES (12, 5, '08:00-16:00');
INSERT INTO trabaja_en VALUES (13, 6, '09:00-14:00');
INSERT INTO trabaja_en VALUES (14, 6, '14:00-20:00');
INSERT INTO trabaja_en VALUES (15, 7, '07:00-13:00');
INSERT INTO trabaja_en VALUES (16, 8, '10:00-16:00');
INSERT INTO trabaja_en VALUES (17, 9, '06:30-13:30');
INSERT INTO trabaja_en VALUES (18, 10, '07:00-13:00');
INSERT INTO trabaja_en VALUES (19, 11, '07:00-15:00');
INSERT INTO trabaja_en VALUES (20, 12, '06:00-14:00');
INSERT INTO trabaja_en VALUES (21, 13, '07:30-14:00');
INSERT INTO trabaja_en VALUES (22, 14, '08:00-16:00');
INSERT INTO trabaja_en VALUES (23, 15, '07:00-13:00');
INSERT INTO trabaja_en VALUES (24, 16, '07:00-13:00');
INSERT INTO trabaja_en VALUES (25, 17, '09:00-17:00');
INSERT INTO trabaja_en VALUES (13, 18, '08:00-16:00');
INSERT INTO trabaja_en VALUES (12, 19, '07:00-14:00');
INSERT INTO trabaja_en VALUES (11, 20, '07:00-13:30');