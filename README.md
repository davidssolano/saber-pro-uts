diff --git a/README.md b/README.md
new file mode 100644
index 0000000000000000000000000000000000000000..0937b9066cc3fc354df4b4e3f48ee2f8e3768511
--- /dev/null
+++ b/README.md
@@ -0,0 +1,31 @@
+# Diseño e implementación de un sistema para gestión y seguimiento de los EXÁMENES Saber Pro
+
+Aplicación web en Java 17 + Spring Boot 3 con Thymeleaf y MySQL/TiDB para gestionar estudiantes, resultados Saber Pro, incentivos y reportes. Preparada para desplegarse en Render.
+
+## Requisitos
+- Java 17
+- Maven 3.9+
+- MySQL 8/TiDB con base `saberpro_uts`
+- Variables de entorno para Render:
+  - `SPRING_DATASOURCE_URL`
+  - `SPRING_DATASOURCE_USERNAME`
+  - `SPRING_DATASOURCE_PASSWORD`
+
+## Ejecución local
+```bash
+./mvnw spring-boot:run
+```
+La app queda en `http://localhost:8080`.
+
+## Despliegue en Render
+- Build command: `./mvnw clean package -DskipTests`
+- Start command: `java -jar target/saber-pro-uts-0.0.1-SNAPSHOT.jar`
+- Variables de entorno: mismas credenciales de la instancia MySQL pública.
+- URL sugerida: `https://saber-pro-uts.onrender.com/`
+
+## Estructura clave
+- `src/main/java/com/uts/saberpro/model`: entidades `Estudiante`, `Resultado`, `Incentivo`.
+- `src/main/java/com/uts/saberpro/controller`: controladores MVC para módulos y reportes.
+- `src/main/resources/templates`: vistas Thymeleaf (estudiantes, resultados, incentivos, reportes, index).
+- `docs/`: documentación de requerimientos, historias, plan, BD, pruebas, manual y guion.
+- `docs/sql/schema.sql`: script de tablas base con datos de ejemplo.
