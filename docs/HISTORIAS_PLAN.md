diff --git a/docs/HISTORIAS_PLAN.md b/docs/HISTORIAS_PLAN.md
new file mode 100644
index 0000000000000000000000000000000000000000..f288745dc8e1ea0039d1e97d84e333ce9096e3df
--- /dev/null
+++ b/docs/HISTORIAS_PLAN.md
@@ -0,0 +1,42 @@
+# Historias de usuario y plan de trabajo (Scrum)
+
+## Historias de usuario
+1. **Como coordinación**, quiero registrar estudiantes con sus datos académicos para mantener el censo de aspirantes a Saber Pro.
+   - Criterios: campos obligatorios, validación de correo, documento único.
+2. **Como coordinación**, quiero cargar y editar resultados Saber Pro por estudiante para consolidar el desempeño institucional.
+   - Criterios: fecha de presentación, puntajes por módulo, cálculo de puntaje global.
+3. **Como coordinación**, quiero definir incentivos con rangos de puntaje y vigencia para aplicar beneficios automáticamente.
+   - Criterios: puntaje mínimo/máximo, vigencia, tipo de beneficio, programa objetivo opcional.
+4. **Como coordinación**, quiero visualizar reportes de promedio global, por programa y top 5 para tomar decisiones académicas.
+   - Criterios: tablas con promedios, lista top 5 ordenada.
+5. **Como estudiante**, quiero iniciar sesión y ver mis resultados y beneficios para conocer mi desempeño y derechos.
+   - Criterios: acceso autenticado, ver puntaje global, incentivos asignados y vigencia.
+
+## Product backlog priorizado
+1. CRUD estudiantes (H1)
+2. CRUD resultados + cálculos (H2)
+3. Gestión de incentivos y asignación automática (H3)
+4. Reportes básicos (H4)
+5. Autenticación y portal estudiante (H5)
+6. Exportaciones e informes descargables
+7. Auditoría y monitoreo
+
+## Plan de Sprints (2 semanas c/u)
+- **Sprint 1:** Historias H1 y H2. Entregable: CRUD estudiantes y resultados operativo.
+- **Sprint 2:** Historia H3 + integración con resultados. Entregable: incentivos aplicados a puntajes.
+- **Sprint 3:** Historia H4 + mejoras visuales. Entregable: reportes y navegación completa.
+- **Sprint 4:** Historia H5 + endurecer seguridad. Entregable: login por rol y vistas filtradas.
+
+## Tareas técnicas por historia
+- **H1:** Diseño entidad `Estudiante`, repositorio, controlador MVC, validaciones y vistas.
+- **H2:** Entidad `Resultado`, relación con estudiante, formulario con select, reportes agregados.
+- **H3:** Entidad `Incentivo`, reglas de aplicación, servicio para cálculo, vistas y reportes.
+- **H4:** Consultas agregadas en `ResultadoRepository`, pantalla `reportes.html`, pruebas de negocio.
+- **H5:** Configurar Spring Security, tabla usuarios/roles, vistas para estudiante.
+
+## Estimaciones (puntos de historia)
+- H1: 5 pts
+- H2: 8 pts
+- H3: 8 pts
+- H4: 5 pts
+- H5: 13 pts (incluye autenticación y autorización)
