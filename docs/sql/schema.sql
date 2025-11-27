CREATE TABLE estudiantes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    documento VARCHAR(50) NOT NULL UNIQUE,
    nombre_completo VARCHAR(150) NOT NULL,
    correo VARCHAR(120) NOT NULL UNIQUE,
    programa VARCHAR(120) NOT NULL,
    semestre INT NOT NULL
);

CREATE TABLE incentivos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(120) NOT NULL,
    tipo_beneficio VARCHAR(80) NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    puntaje_minimo DOUBLE NOT NULL,
    puntaje_maximo DOUBLE NOT NULL,
    programa_objetivo VARCHAR(120),
    vigencia_inicio DATE NOT NULL,
    vigencia_fin DATE NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE resultados (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    estudiante_id BIGINT NOT NULL,
    fecha_presentacion DATE NOT NULL,
    lectura_critica INT NOT NULL,
    razonamiento_cuantitativo INT NOT NULL,
    ingles INT NOT NULL,
    comunicacion_escrita INT NOT NULL,
    competencias_ciudadanas INT NOT NULL,
    formulacion_proyectos INT NOT NULL,
    puntaje_global INT NOT NULL,
    CONSTRAINT fk_resultado_estudiante FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)
);

INSERT INTO estudiantes (documento, nombre_completo, correo, programa, semestre) VALUES
('1001', 'Ana Torres', 'ana.torres@uts.edu.co', 'Ingeniería de Sistemas', 9),
('1002', 'Luis Gómez', 'luis.gomez@uts.edu.co', 'Ingeniería de Sistemas', 10);

INSERT INTO incentivos (nombre, tipo_beneficio, descripcion, puntaje_minimo, puntaje_maximo, programa_objetivo, vigencia_inicio, vigencia_fin, activo) VALUES
('Beca Excelencia', 'Beca', 'Descuento 50% matrícula para puntajes sobresalientes', 180, 300, 'Ingeniería de Sistemas', '2025-01-01', '2026-12-31', true),
('Exoneración Derechos de Grado', 'Exoneración', 'Exonera pago de derechos de grado a los mejores 5 puntajes', 190, 300, NULL, '2025-01-01', '2025-12-31', true);

INSERT INTO resultados (estudiante_id, fecha_presentacion, lectura_critica, razonamiento_cuantitativo, ingles, comunicacion_escrita, competencias_ciudadanas, formulacion_proyectos, puntaje_global) VALUES
(1, '2025-03-10', 170, 165, 180, 175, 168, 172, 172),
(2, '2025-03-10', 185, 190, 178, 182, 180, 188, 184);
