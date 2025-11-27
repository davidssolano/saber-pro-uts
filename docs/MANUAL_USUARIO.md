# Manual de usuario

## Coordinación / Administrador
1. **Iniciar sesión:** acceder a la URL pública e ingresar credenciales de coordinación (pendiente integración de login).
2. **Gestionar estudiantes:** menú Estudiantes → Crear, editar o eliminar. Validar documento y correo.
3. **Registrar resultados:** menú Resultados → "+ Nuevo resultado", escoger estudiante, fecha y puntajes. Guardar.
4. **Gestionar incentivos:** menú Incentivos → definir nombre, tipo, rango de puntaje y vigencia. Un programa objetivo limita la aplicación a ese programa.
5. **Ver reportes:** menú Reportes → revisar promedio global, promedio por programa y top 5 puntajes.
6. **Exportar/respaldar:** usar script `docs/sql/schema.sql` como base; futuras versiones incluirán exportación directa.

## Estudiante
1. **Iniciar sesión:** ingresar con credenciales institucionales (pendiente integración de login).
2. **Consultar resultados:** ver puntaje global y por módulo en la sección Resultados (vista filtrada al usuario).
3. **Ver incentivos:** la columna Incentivos muestra los beneficios aplicables con su vigencia.

## Despliegue
- Variables de entorno para BD en Render.
- Build con `./mvnw clean package -DskipTests` y arranque `java -jar target/saber-pro-uts-0.0.1-SNAPSHOT.jar`.
