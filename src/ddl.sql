CREATE TABLE FEDERACION (
  FEDERACION_ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  FED_DESCRIPCION VARCHAR(255) NOT NULL,
  PRIMARY KEY(FEDERACION_ID)
);

CREATE TABLE MEDICO (
  MED_ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  MED_NOMBRE VARCHAR(20) NOT NULL,
  MED_APELLIDO VARCHAR(20) NOT NULL,
  MED_MATRICULA VARCHAR(20) NOT NULL,
  PRIMARY KEY(MED_ID)
);

CREATE TABLE CATEGORIA (
  CAT_ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  CAT_DESCRIPCION VARCHAR(255) NOT NULL,
  CAT_DESDE DATETIME NOT NULL,
  CAT_HASTA DATETIME NOT NULL,
  CAT_MIN_JUG INTEGER UNSIGNED NULL,
  PRIMARY KEY(CAT_ID)
);

CREATE TABLE CLUB (
  CLUB_ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  FEDERACION_ID INTEGER UNSIGNED NOT NULL,
  CLU_DESCRIPCION VARCHAR(45) NOT NULL,
  CLU_FEDERADO CHAR NOT NULL,
  PRIMARY KEY(CLUB_ID, FEDERACION_ID),
  INDEX CLUB_FKIndex1(FEDERACION_ID),
  FOREIGN KEY(FEDERACION_ID)
    REFERENCES FEDERACION(FEDERACION_ID)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE JUGADOR (
  JUG_ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  CATEGORIA_CAT_ID INTEGER UNSIGNED NOT NULL,
  CLUB_FEDERACION_ID INTEGER UNSIGNED NOT NULL,
  CLUB_ID INTEGER UNSIGNED NOT NULL,
  JUG_FEDERADO VARCHAR(1) NOT NULL,
  JUG_NOMBRE VARCHAR(20) NOT NULL,
  JUG_APELLIDO VARCHAR(20) NOT NULL,
  JUG_FECHA_NAC DATETIME NOT NULL,
  PRIMARY KEY(JUG_ID),
  INDEX JUGADOR_FKIndex1(CLUB_ID, CLUB_FEDERACION_ID),
  INDEX JUGADOR_FKIndex2(CATEGORIA_CAT_ID),
  FOREIGN KEY(CLUB_ID, CLUB_FEDERACION_ID)
    REFERENCES CLUB(CLUB_ID, FEDERACION_ID)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(CATEGORIA_CAT_ID)
    REFERENCES CATEGORIA(CAT_ID)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE FICHA_MEDICA (
  FM_ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  MEDICO_MED_ID INTEGER UNSIGNED NOT NULL,
  JUGADOR_JUG_ID INTEGER UNSIGNED NOT NULL,
  FM_ESTADO VARCHAR(20) NOT NULL,
  FM_ALERGIAS VARCHAR(255) NOT NULL,
  FM_CARDIOPATIAS VARCHAR(255) NOT NULL,
  FM_ANTECEDENTES VARCHAR(255) NOT NULL,
  FM_HISTORIAL VARCHAR(255) NOT NULL,
  FM_BUCO_DEN VARCHAR(255) NULL,
  PRIMARY KEY(FM_ID),
  INDEX FICHA_MEDICA_FKIndex1(JUGADOR_JUG_ID),
  INDEX FICHA_MEDICA_FKIndex2(MEDICO_MED_ID),
  FOREIGN KEY(JUGADOR_JUG_ID)
    REFERENCES JUGADOR(JUG_ID)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(MEDICO_MED_ID)
    REFERENCES MEDICO(MED_ID)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE AVISO (
  AVI_ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  JUGADOR_JUG_ID INTEGER UNSIGNED NOT NULL,
  AVI_ESTADO VARCHAR(20) NOT NULL,
  AVI_FECHA DATETIME NOT NULL,
  AVI_TIPO VARCHAR(20) NOT NULL,
  PRIMARY KEY(AVI_ID),
  INDEX AVISO_FKIndex1(JUGADOR_JUG_ID),
  FOREIGN KEY(JUGADOR_JUG_ID)
    REFERENCES JUGADOR(JUG_ID)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


