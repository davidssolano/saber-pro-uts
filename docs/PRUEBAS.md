# Casos de prueba y resultados

## Casos clave
1. **Alta estudiante**
   - Entrada: documento único, correo válido, programa, semestre.
   - Esperado: estudiante aparece en listado y es editable.
2. **Edición estudiante con correo duplicado**
   - Entrada: correo existente.
   - Esperado: validación falla y muestra mensaje de error.
3. **Registro resultado**
   - Entrada: selección de estudiante, fecha, puntajes por módulo y global.
   - Esperado: resultado en listado y se recalculan reportes.
4. **Asignación de incentivos**
   - Entrada: resultado con puntaje global dentro de rango y vigencia.
   - Esperado: aparece incentivo en columna "Incentivos" del listado.
5. **Eliminación resultado**
   - Entrada: acción eliminar.
   - Esperado: resultado desaparece y reportes se actualizan.
6. **Reportes**
   - Entrada: datos existentes.
   - Esperado: promedio global != null, tabla por programa ordenada y top 5 con máximo 5 filas.
7. **Autenticación/roles (diseño)**
   - Entrada: login coordinación vs estudiante.
   - Esperado: coordinación ve CRUD completos; estudiante solo ve sus datos e incentivos.

## Informe resumido
- Pruebas manuales en entorno local con datos de `schema.sql`.
- Resultados esperados se cumplen en la interfaz actual para CRUD y asignación de incentivos.
- Pendiente: pruebas automatizadas y validación de seguridad una vez se integre Spring Security.
