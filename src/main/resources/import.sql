-- Tipos de actividades
INSERT INTO tipos_de_actividades(id, tipo_actividad) values (1, 'Mantenimiento');
INSERT INTO tipos_de_actividades(id, tipo_actividad) values (2, 'Insatalación');
INSERT INTO tipos_de_actividades(id, tipo_actividad) values (3, 'Insatalación y mantenimiento');

-- Tipos de empleado
INSERT INTO tipos_de_empleados(id, tipo_empleado) values (1, 'Técnico');
INSERT INTO tipos_de_empleados(id, tipo_empleado) values (2, 'Administrativo');
INSERT INTO tipos_de_empleados(id, tipo_empleado) values (3, 'Encargado');

-- Clientes
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Ana Carolina' ,'García', 'López', '2002-01-10', 'DomicilioUsuario1', 'anacarolinagarcial@gmail.com', '8331111111');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Juan Carlos', 'Ramírez', 'Ruiz', '2002-02-12', 'DomicilioUsuario2', 'juancarlosramirezz@gmail.com', '8332222222');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Sofía Isabel', 'Torres', 'Hernández', '2002-03-13', 'DomicilioUsuario3', 'sofiatorresh@gmail.com', '8333333333');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Luis Enrique', 'González', 'Flores', '2002-05-14', 'DomicilioUsuario4', 'luisenriquegonzalezf@gmail.com', '8334444444');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Marco Pablo', 'González', 'Flores', '2002-08-18', 'DomicilioUsuario7', 'Marcopablogonres@gmail.com', '8338888888');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Luisa Mia', 'González', 'Flores', '2002-08-19', 'DomicilioUsuario8', 'Luisamiagonres@gmail.com', '8339999999');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Luis Polo', 'González', 'Flores', '2002-07-10', 'DomicilioUsuario9', 'Luispologonres@gmail.com', '8331000000');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Ruben Rodrigo', 'González', 'Flores', '2002-05-11', 'DomicilioUsuario10', 'Rubenrodrigogonres@gmail.com', '8331100000');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Luis Ernesto', 'González', 'Flores', '2002-03-2', 'DomicilioUsuario11', 'Luisernestogonres@gmail.com', '8331110000');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Antonio Quique', 'Arriaga', 'Flores', '2002-04-3', 'DomicilioUsuario12', 'Antonioquique@gmail.com', '8331111000');
INSERT INTO clientes (nombre_cliente, apellido_paterno, apellido_materno, fecha_nacimineto, domicilio, correo, telefono) VALUES ('Jose Toño', 'Vargas', 'Flores', '2000-04-4', 'DomicilioUsuario13', 'Josetoño@gmail.com', '8331111100');

-- Empleados
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Mariana Alejandra', 'Ortiz', 'Castro', '2002-01-10', 'DomicilioUsuario1', 'marianaortizc@gmail.com', '8331111111', 1);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Ricardo Antonio', 'Pérez', 'Sánchez', '2002-02-12', 'DomicilioUsuario2', 'ricardoperezs@gmail.com', '8332222222', 2);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Ana Cecilia', 'Hernández', 'Reyes', '2001-03-13', 'DomicilioUsuario3', 'anaceciliahernandezr@gmail.com', '8333333333', 3);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Pablo Andrés', 'Sánchez', 'Torres', '2000-04-14', 'DomicilioUsuario4', 'pabloandressanchezt@gmail.com', '8334444444', 1);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Kevin Andrés', 'Cruz', 'Torres', '2001-07-11', 'DomicilioUsuario8', 'Kevinandrescrutor@gmail.com', '8337777777', 1);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Ruben Andrés', 'Cruz', 'Vega', '1990-03-13', 'DomicilioUsuario13', 'Rubenandrescruveg@gmail.com', '8331110000', 1);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Natan Uriel', 'Gonzalez', 'Torres', '2000-06-12', 'DomicilioUsuario9', 'Natanurielgontor@gmail.com', '8338888888', 1);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Alejandra Nathali', 'Sánchez', 'Vega', '2001-05-13', 'DomicilioUsuario10', 'Alejandranathalisanveg@gmail.com', '8339999999', 1);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Santiago Ruben', 'Sánchez', 'Garcia', '2000-03-1', 'DomicilioUsuario11', 'Santiagorubensangar@gmail.com', '8331111110', 1);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Mia Angela', 'Vega', 'Padron', '1999-02-16', 'DomicilioUsuario12', 'Miaangelavegpad@gmail.com', '8331111100', 1);
INSERT INTO empleados (nombre_empleado, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, correo, telefono, tipo_de_empleado_id) VALUES ('Santiago Andrés', 'Vargas', 'Arriaga', '1992-05-19', 'DomicilioUsuario14', 'Santiagoandresvararr@gmail.com', '8331110000', 1);

-- Citas
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-03-15', '12:16:00', 'Calle segunda', 'Ejemplo de una descripcion 1' ,1, 1, 1);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-04-10', '01:16:00', 'Calle tercera', 'Ejemplo de una descripcion 2', 2, 2, 1);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-03-20', '01:16:00', 'Calle sexta', 'Ejemplo de una descripcion 3',  3, 3, 1);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-05-19', '01:16:00', 'Calle Primera', 'Ejemplo de una descripcion 4', 4, 4, 1);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-04-12', '01:16:00', 'Calle Primera', 'Ejemplo de una descripcion 3', 5, 6, 2);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-02-12', '01:16:00', 'Calle Segunda', 'Ejemplo de una descripcion 3', 6, 5, 3);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-07-11', '01:16:00', 'Calle Tercera', 'Ejemplo de una descripcion 3', 7, 4, 1);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-08-07', '01:16:00',  'Calle Primera', 'Ejemplo de una descripcion 3', 8, 3, 1);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-09-05', '01:16:00', 'Calle Cuarta', 'Ejemplo de una descripcion 3', 9, 2, 3);
INSERT INTO citas (fecha_cita, hora_cita, direccion, descripcion, cliente_id, empleado_id, tipo_de_actividad_id) VALUES ('2023-12-01', '01:16:00', 'Calle Tercera', 'Ejemplo de una descripcion 3', 10, 1, 2);

-- Reportes
insert into reportes (descripcion_reporte, id_cita) values ('Ejemplo de una descripcion 1', 1);
insert into reportes (descripcion_reporte, id_cita) values ('Ejemplo de una descripcion 2', 2);
insert into reportes (descripcion_reporte, id_cita) values ('Ejemplo de una descripcion 3', 3);
insert into reportes (descripcion_reporte, id_cita) values ('Ejemplo de una descripcion 4', 4);
