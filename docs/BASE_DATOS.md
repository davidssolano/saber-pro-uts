# Diseño de base de datos

## Modelo entidad-relación (texto)
- **Estudiante** (id, documento, nombreCompleto, correo, programa, semestre)
- **Resultado** (id, estudiante_id, fechaPresentacion, lecturaCritica, razonamientoCuantitativo, ingles, comunicacionEscrita, competenciasCiudadanas, formulacionProyectos, puntajeGlobal)
- **Incentivo** (id, nombre, tipoBeneficio, descripcion, puntajeMinimo, puntajeMaximo, programaObjetivo, vigenciaInicio, vigenciaFin, activo)
- **Usuario** (id, username, password, rol) *(planificado para autenticación)*

Relaciones principales:
- Estudiante 1..n Resultado
- Resultado n..m Incentivo (evaluado dinámicamente por reglas; se puede materializar en una tabla intermedia si se requiere trazabilidad)

## Scripts SQL iniciales
Ver `docs/sql/schema.sql` para creación de tablas y datos de ejemplo.
