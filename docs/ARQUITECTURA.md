diff --git a/docs/ARQUITECTURA.md b/docs/ARQUITECTURA.md
new file mode 100644
index 0000000000000000000000000000000000000000..0ea5cfcb209a8f1a0c493ccd693b7537abc006e1
--- /dev/null
+++ b/docs/ARQUITECTURA.md
@@ -0,0 +1,9 @@
+# Arquitectura del sistema web
+
+- **Backend:** Spring Boot 3 (Java 17), patrones MVC y Repository. Validaciones con Bean Validation.
+- **Persistencia:** Spring Data JPA sobre MySQL/TiDB. DDL automático (`ddl-auto=update`) y script `docs/sql/schema.sql` para ambientes limpios.
+- **Frontend:** Thymeleaf + HTML/CSS ligero. No hay dependencias JS pesadas.
+- **Capa de servicios:** `IncentivoService` calcula incentivos aplicables por puntaje, programa y vigencia.
+- **Reportes:** consultas agregadas en `ResultadoRepository` (promedio global, promedio por programa, top 5).
+- **Despliegue:** Render (servicio web). Build con `./mvnw clean package -DskipTests`; arranque `java -jar target/saber-pro-uts-0.0.1-SNAPSHOT.jar`. Variables de entorno para URL y credenciales de BD.
+- **Seguridad (pendiente):** incorporar Spring Security, tabla de usuarios/roles y vistas filtradas para estudiantes.
