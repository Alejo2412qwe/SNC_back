INSERT INTO rol(rol_id, rol_nombre)
VALUES (1, 'Administrador');
INSERT INTO rol(rol_id, rol_nombre)
VALUES (2, 'Administrativo');
INSERT INTO rol(rol_id, rol_nombre)
VALUES (3, 'Docente');
INSERT INTO rol(rol_id, rol_nombre)
VALUES (4, 'Funcionario');






-- PROVINCIAS
    INSERT
INTO provincia (pro_id, pro_nombre)
VALUES (1, 'AZUAY'), (2, 'BOLIVAR'), (3, 'CAÑAR'), (4, 'CARCHI'), (5, 'COTOPAXI'), (6, 'CHIMBORAZO'), (7, 'EL ORO'), (8, 'ESMERALDAS'), (9, 'GUAYAS'), (10, 'IMBABURA'), (11, 'LOJA'), (12, 'LOS RIOS'), (13, 'MANABI'), (14, 'MORONA SANTIAGO'), (15, 'NAPO'), (16, 'PASTAZA'), (17, 'PICHINCHA'), (18, 'TUNGURAHUA'), (19, 'ZAMORA CHINCHIPE'), (20, 'GALAPAGOS'), (21, 'SUCUMBIOS'), (22, 'ORELLANA'), (23, 'SANTO DOMINGO DE LOS TSACHILAS'), (24, 'SANTA ELENA'), (25, 'ZONAS NO DELIMITADAS');


--CIUDADES
INSERT INTO ciudad(ciu_nombre, pro_id)
VALUES ('CUENCA', 1),
       ('GIRÓN', 1),
       ('GUALACEO', 1),
       ('NABÓN', 1),
       ('PAUTE', 1),
       ('PUCARA', 1),
       ('SAN FERNANDO', 1),
       ('SANTA ISABEL', 1),
       ('SIGSIG', 1),
       ('OÑA', 1),
       ('CHORDELEG', 1),
       ('EL PAN', 1),
       ('SEVILLA DE ORO', 1),
       ('GUACHAPALA', 1),
       ('CAMILO PONCE ENRÍQUEZ', 1),
       ('GUARANDA', 2),
       ('CHILLANES', 2),
       ('CHIMBO', 2),
       ('ECHEANDÍA', 2),
       ('SAN MIGUEL', 2),
       ('CALUMA', 2),
       ('LAS NAVES', 2),
       ('AZOGUES', 3),
       ('BIBLIÁN', 3),
       ('CAÑAR', 3),
       ('LA TRONCAL', 3),
       ('EL TAMBO', 3),
       ('DÉLEG', 3),
       ('SUSCAL', 3),
       ('TULCÁN', 4),
       ('BOLÍVAR', 4),
       ('ESPEJO', 4),
       ('MIRA', 4),
       ('MONTÚFAR', 4),
       ('SAN PEDRO DE HUACA', 4),
       ('LATACUNGA', 5),
       ('LA MANÁ', 5),
       ('PANGUA', 5),
       ('PUJILI', 5),
       ('SALCEDO', 5),
       ('SAQUISILÍ', 5),
       ('SIGCHOS', 5),
       ('RIOBAMBA', 6),
       ('ALAUSI', 6),
       ('COLTA', 6),
       ('CHAMBO', 6),
       ('CHUNCHI', 6),
       ('GUAMOTE', 6),
       ('GUANO', 6),
       ('PALLATANGA', 6),
       ('PENIPE', 6),
       ('CUMANDÁ', 6),
       ('MACHALA', 7),
       ('ARENILLAS', 7),
       ('ATAHUALPA', 7),
       ('BALSAS', 7),
       ('CHILLA', 7),
       ('EL GUABO', 7),
       ('HUAQUILLAS', 7),
       ('MARCABELÍ', 7),
       ('PASAJE', 7),
       ('PIÑAS', 7),
       ('PORTOVELO', 7),
       ('SANTA ROSA', 7),
       ('ZARUMA', 7),
       ('LAS LAJAS', 7),
       ('ESMERALDAS', 8),
       ('ELOY ALFARO', 8),
       ('MUISNE', 8),
       ('QUININDÉ', 8),
       ('SAN LORENZO', 8),
       ('ATACAMES', 8),
       ('RIOVERDE', 8),
       ('LA CONCORDIA', 8),
       ('GUAYAQUIL', 9),
       ('ALFREDO BAQUERIZO MORENO (JUJÁN)', 9),
       ('BALAO', 9),
       ('BALZAR', 9),
       ('COLIMES', 9),
       ('DAULE', 9),
       ('DURÁN', 9),
       ('EL EMPALME', 9),
       ('EL TRIUNFO', 9),
       ('MILAGRO', 9),
       ('NARANJAL', 9),
       ('NARANJITO', 9),
       ('PALESTINA', 9),
       ('PEDRO CARBO', 9),
       ('SAMBORONDÓN', 9),
       ('SANTA LUCÍA', 9),
       ('SALITRE (URBINA JADO)', 9),
       ('SAN JACINTO DE YAGUACHI', 9),
       ('PLAYAS', 9),
       ('SIMÓN BOLÍVAR', 9),
       ('CORONEL MARCELINO MARIDUEÑA', 9),
       ('LOMAS DE SARGENTILLO', 9),
       ('NOBOL', 9),
       ('GENERAL ANTONIO ELIZALDE', 9),
       ('ISIDRO AYORA', 9),
       ('IBARRA', 10),
       ('ANTONIO ANTE', 10),
       ('COTACACHI', 10),
       ('OTAVALO', 10),
       ('PIMAMPIRO', 10),
       ('SAN MIGUEL DE URCUQUÍ', 10),
       ('LOJA', 11),
       ('CALVAS', 11),
       ('CATAMAYO', 11),
       ('CELICA', 11),
       ('CHAGUARPAMBA', 11),
       ('ESPÍNDOLA', 11),
       ('GONZANAMÁ', 11),
       ('MACARÁ', 11),
       ('PALTAS', 11),
       ('PUYANGO', 11),
       ('SARAGURO', 11),
       ('SOZORANGA', 11),
       ('ZAPOTILLO', 11),
       ('PINDAL', 11),
       ('QUILANGA', 11),
       ('OLMEDO', 11),
       ('BABAHOYO', 12),
       ('BABA', 12),
       ('MONTALVO', 12),
       ('PUEBLOVIEJO', 12),
       ('QUEVEDO', 12),
       ('URDANETA', 12),
       ('VENTANAS', 12),
       ('VÍNCES', 12),
       ('PALENQUE', 12),
       ('BUENA FÉ', 12),
       ('VALENCIA', 12),
       ('MOCACHE', 12),
       ('QUINSALOMA', 12),
       ('PORTOVIEJO', 13),
       ('BOLÍVAR', 13),
       ('CHONE', 13),
       ('EL CARMEN', 13),
       ('FLAVIO ALFARO', 13),
       ('JIPIJAPA', 13),
       ('JUNÍN', 13),
       ('MANTA', 13),
       ('MONTECRISTI', 13),
       ('PAJÁN', 13),
       ('PEDERNALES', 13),
       ('ROCAFUERTE', 13),
       ('SANTA ANA', 13),
       ('SUCRE', 13),
       ('TOSAGUA', 13),
       ('24 DE MAYO', 13),
       ('PEDERNALES', 13),
       ('OLMEDO', 13),
       ('PUERTO LÓPEZ', 13),
       ('JAMA', 13),
       ('JARAMIJÓ', 13),
       ('SAN VICENTE', 13),
       ('MORONA', 14),
       ('GUALAQUIZA', 14),
       ('LIMÓN INDANZA', 14),
       ('PALORA', 14),
       ('SANTIAGO', 14),
       ('SUCÚA', 14),
       ('HUAMBOYA', 14),
       ('SAN JUAN BOSCO', 14),
       ('TAISHA', 14),
       ('LOGROÑO', 14),
       ('PABLO SEXTO', 14),
       ('TIWINTZA', 14),
       ('TENA', 15),
       ('ARCHIDONA', 15),
       ('EL CHACO', 15),
       ('QUIJOS', 15),
       ('CARLOS JULIO AROSEMENA TOLA', 15),
       ('PASTAZA', 16),
       ('MERA', 16),
       ('SANTA CLARA', 16),
       ('ARAJUNO', 16),
       ('QUITO', 17),
       ('CAYAMBE', 17),
       ('MEJIA', 17),
       ('PEDRO MONCAYO', 17),
       ('RUMIÑAHUI', 17),
       ('SAN MIGUEL DE LOS BANCOS', 17),
       ('PEDRO VICENTE MALDONADO', 17),
       ('PUERTO QUITO', 17),
       ('AMBATO', 18),
       ('BAÑOS DE AGUA SANTA', 18),
       ('CEVALLOS', 18),
       ('MOCHA', 18),
       ('PATATE', 18),
       ('QUERO', 18),
       ('SAN PEDRO DE PELILEO', 18),
       ('SANTIAGO DE PÍLLARO', 18),
       ('TISALEO', 18),
       ('ZAMORA', 19),
       ('CHINCHIPE', 19),
       ('NANGARITZA', 19),
       ('YACUAMBI', 19),
       ('YANTZAZA (YANZATZA)', 19),
       ('EL PANGUI', 19),
       ('CENTINELA DEL CÓNDOR', 19),
       ('PALANDA', 19),
       ('PAQUISHA', 19),
       ('SAN CRISTÓBAL', 20),
       ('ISABELA', 20),
       ('SANTA CRUZ', 20),
       ('LAGO AGRIO', 21),
       ('GONZALO PIZARRO', 21),
       ('PUTUMAYO', 21),
       ('SHUSHUFINDI', 21),
       ('SUCUMBÍOS', 21),
       ('CASCALES', 21),
       ('CUYABENO', 21),
       ('ORELLANA', 22),
       ('AGUARICO', 22),
       ('LA JOYA DE LOS SACHAS', 22),
       ('LORETO', 22),
       ('SANTO DOMINGO', 23),
       ('SANTA ELENA', 24),
       ('LA LIBERTAD', 24),
       ('SALINAS', 24),
       ('LAS GOLONDRINAS', 25),
       ('MANGA DEL CURA', 25),
       ('EL PIEDRERO', 25);


INSERT INTO persona(per_apellido, per_cedula, per_direccion, per_fecha_nacimiento, per_nombre,
                      per_telefono, ciu_id)
VALUES ('JARAMILLO', '012313123123', 'AV. DE LAS AMERICAS', '2002-08-22', 'JULIO', '098123123123', 1);