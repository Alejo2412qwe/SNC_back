INSERT INTO rol (rol_id, rol_nombre)
SELECT * FROM (
                  SELECT 1, 'Administrador' AS rol_nombre
                  UNION ALL
                  SELECT 2, 'Administrativo'
                  UNION ALL
                  SELECT 3, 'Docente'
                  UNION ALL
                  SELECT 4, 'Funcionario'
                  UNION ALL
                  SELECT 5, 'Jefe de Unidad'
              ) AS datos
WHERE NOT EXISTS (
    SELECT 1 FROM rol WHERE rol_id IN (1, 2, 3, 4, 5)
);


--motivo del permiso
INSERT INTO motivo_permiso(mot_estado, mot_nombre, mot_descripcion_corta, mot_descripcion_larga)
SELECT * FROM (
                  SELECT 1 AS mot_estado, 'LICENCIA POR CALAMIDAD DOMÉSTICA' AS mot_nombre, 'HASTA 8 DÍAS; SEGÚN EL CASO' AS mot_descripcion_corta, 'Por calamidad doméstica, entendida como tal, al fallecimiento, accidente o enfermedad grave del cónyuge o conviviente en unión de hecho legalmente reconocida o de los parientes hasta el segundo grado de consanguinidad o segundo de afinidad de las servidoras o servidores públicos. Para el caso del cónyuge o conviviente en unión de hecho legalmente reconocida, del padre, madre o hijos, la máxima autoridad, su delegado o las Unidades de Administración del Talento Humano deberán conceder licencia hasta por ocho días, al igual que para el caso de siniestros que afecten gravemente la propiedad o los bienes de la servidora o servidor. Para el resto de parientes contemplados en este literal, se concederá la licencia hasta por tres días y, en caso de requerir tiempo adicional, se lo contabilizará con cargo a vacaciones;' AS mot_descripcion_larga
                  UNION ALL
                  SELECT 1, 'LICENCIA POR ENFERMEDAD', 'PUEDE SER DE HASTA TRES MESES - SEIS MESES SEGÚN SEA EL CASO', 'Por enfermedad que determine imposibilidad física o psicológica, debidamente comprobada, para la realización de sus labores, hasta por tres meses; e, igual período podrá aplicarse para su rehabilitación; Por enfermedad catastrófica o accidente grave debidamente certificado, hasta por seis meses; así como el uso de dos horas diarias para su rehabilitación en caso de prescripción médica;'
                  UNION ALL
                  SELECT 1, 'LICENCIA POR MATERNIDAD', '84 DÍAS', 'Por maternidad, toda servidora pública tiene derecho a una licencia con remuneración de doce (12) semanas por el nacimiento de su hija o hijo; en caso de nacimiento múltiple el plazo se extenderá por diez días adicionales. La ausencia se justificará mediante la presentación del certificado médico otorgado por un facultativo del Instituto Ecuatoriano de Seguridad Social; y, a falta de éste, por otro profesional de los centros de salud pública. En dicho certificado se hará constar la fecha probable del parto o en la que tal hecho se produjo;'
                  UNION ALL
                  SELECT 1, 'LICENCIA POR MATRIMONIO O UNIÓN DE HECHO', '3 DÍAS LABORABLES (HÁBILES)', 'La servidora o el servidor que contraiga matrimonio o unión de hecho, tendrá derecho a una licencia con remuneración de tres días hábiles continuos en total, pudiendo solicitarla antes o después de la celebración del matrimonio.'
                  UNION ALL
                  SELECT 1, 'LICENCIA POR PATERNIDAD', '10 DÍAS (NORMAL), 15 DÍAS (CESÁREA) Y 8 DÍAS MÁS PREMATURO, y 25 días Enfermedades Degenerativas etc.', 'Por paternidad, el servidor público tiene derecho a licencia con remuneración por el plazo de diez días contados desde el nacimiento de su hija o hijo cuando el parto es normal; en los casos de nacimiento múltiple o por cesárea se ampliará por cinco días más; En los casos de nacimientos prematuros o en condiciones de cuidado especial, se prolongará la licencia por paternidad con remuneración por ocho días más; y, cuando hayan nacido con una enfermedad degenerativa, terminal o irreversible o con un grado de discapacidad severa, el padre podrá tener licencia con remuneración por veinte y cinco días, hecho que se justificará con la presentación de un certificado médico, otorgado por un facultativo del Instituto Ecuatoriano de Seguridad Social y a falta de éste, por otro profesional médico debidamente avalado por los centros de salud pública; En caso de fallecimiento de la madre, durante el parto o mientras goza de la licencia por maternidad, el padre podrá hacer uso de la totalidad, o en su caso de la parte que reste del período de licencia que le hubiere correspondido a la madre;'
                  UNION ALL
                  SELECT 1, 'PERMISO PARA ESTUDIOS REGULARES', 'HASTA DOS HORAS RECUPERABLES', 'En el caso de contratos de servicios ocasionales se podrá otorgar este permiso de conformidad con las necesidades institucionales siempre que la servidora o el servidor recupere el tiempo solicitado.'
                  UNION ALL
                  SELECT 1, 'PERMISO POR DÍAS CON CARGO A', 'Tomar en cuenta que los días de vacaciones son en un numero de 30 días (22 laborales, 8 sábados y domingos), después de 11 meses laborados, el cálculo se lo realiza multiplicando el tiempo laboral solicitado por 1,36363636363636', 'Podrán concederse permisos imputables a vacaciones, siempre que éstos no excedan los días de vacación a los que la servidora o el servidor tenga derecho al momento de la solicitud.  (se suman horas, fracciones de horas y días)'
                  UNION ALL
                  SELECT 1, 'PERMISO POR ASUNTOS OFICIALES', 'NO IMPUTABLE A VACACIONES', 'Esta licencia se hará efectiva siempre y cuando exista la disposición por su jefe inmediato de realizar labores innherentes a su puesto o a la Institución, o a su vez sea dispuesto por la máxima autoridad.'
                  UNION ALL
                  SELECT 1, 'PERMISO POR ATENCIÓN MÉDICA', 'HASTA POR 2 HORAS', 'Las y los servidores/as tendrán derecho a permiso para atención médica hasta por dos horas, siempre que se justifique con certificado médico correspondiente otorgado por el Instituto Ecuatoriano de Seguridad Social o abalizado por los centros de salud pública.'
                  UNION ALL
                  SELECT 1, 'OTROS', 'SEGÚN EL DETALLE SE LE ASIGNARÁ LA CATEGORÍA Y EL PERIODO', 'Los demás que contempla la ley Orgánica del Servicio Público, su Reglamento, y el Reglamento Interno de la Institución.'
              ) AS datos
WHERE NOT EXISTS (
    SELECT 1 FROM motivo_permiso WHERE mot_nombre IN (
                                                      'LICENCIA POR CALAMIDAD DOMÉSTICA', 'LICENCIA POR ENFERMEDAD', 'LICENCIA POR MATERNIDAD',
                                                      'LICENCIA POR MATRIMONIO O UNIÓN DE HECHO', 'LICENCIA POR PATERNIDAD', 'PERMISO PARA ESTUDIOS REGULARES',
                                                      'PERMISO POR DÍAS CON CARGO A', 'PERMISO POR ASUNTOS OFICIALES', 'PERMISO POR ATENCIÓN MÉDICA', 'OTROS'
        )
);

-- REGIMEN
INSERT INTO regimen (reg_estado, reg_nombre)
SELECT * FROM (
                  SELECT 1, 'LOSEP' AS reg_nombre
                  UNION ALL
                  SELECT 1, 'Código Del Trabajo'
              ) AS datos
WHERE NOT EXISTS (
    SELECT 1 FROM regimen WHERE reg_nombre IN ('LOSEP', 'Código Del Trabajo')
);


-- PROVINCIAS
INSERT INTO provincia (pro_id, pro_nombre)
SELECT * FROM (
                  SELECT 1, 'AZUAY' AS pro_nombre
                  UNION ALL
                  SELECT 2, 'BOLIVAR'
                  UNION ALL
                  SELECT 3, 'CAÑAR'
                  UNION ALL
                  SELECT 4, 'CARCHI'
                  UNION ALL
                  SELECT 5, 'COTOPAXI'
                  UNION ALL
                  SELECT 6, 'CHIMBORAZO'
                  UNION ALL
                  SELECT 7, 'EL ORO'
                  UNION ALL
                  SELECT 8, 'ESMERALDAS'
                  UNION ALL
                  SELECT 9, 'GUAYAS'
                  UNION ALL
                  SELECT 10, 'IMBABURA'
                  UNION ALL
                  SELECT 11, 'LOJA'
                  UNION ALL
                  SELECT 12, 'LOS RIOS'
                  UNION ALL
                  SELECT 13, 'MANABI'
                  UNION ALL
                  SELECT 14, 'MORONA SANTIAGO'
                  UNION ALL
                  SELECT 15, 'NAPO'
                  UNION ALL
                  SELECT 16, 'PASTAZA'
                  UNION ALL
                  SELECT 17, 'PICHINCHA'
                  UNION ALL
                  SELECT 18, 'TUNGURAHUA'
                  UNION ALL
                  SELECT 19, 'ZAMORA CHINCHIPE'
                  UNION ALL
                  SELECT 20, 'GALAPAGOS'
                  UNION ALL
                  SELECT 21, 'SUCUMBIOS'
                  UNION ALL
                  SELECT 22, 'ORELLANA'
                  UNION ALL
                  SELECT 23, 'SANTO DOMINGO DE LOS TSACHILAS'
                  UNION ALL
                  SELECT 24, 'SANTA ELENA'
                  UNION ALL
                  SELECT 25, 'ZONAS NO DELIMITADAS'
              ) AS datos
WHERE NOT EXISTS (
    SELECT 1 FROM provincia WHERE pro_nombre IN (
                                                 'AZUAY', 'BOLIVAR', 'CAÑAR', 'CARCHI', 'COTOPAXI',
                                                 'CHIMBORAZO', 'EL ORO', 'ESMERALDAS', 'GUAYAS', 'IMBABURA',
                                                 'LOJA', 'LOS RIOS', 'MANABI', 'MORONA SANTIAGO', 'NAPO',
                                                 'PASTAZA', 'PICHINCHA', 'TUNGURAHUA', 'ZAMORA CHINCHIPE',
                                                 'GALAPAGOS', 'SUCUMBIOS', 'ORELLANA', 'SANTO DOMINGO DE LOS TSACHILAS',
                                                 'SANTA ELENA', 'ZONAS NO DELIMITADAS'
        )
);

-- CIUDADES
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