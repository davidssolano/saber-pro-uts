# Requerimientos del sistema

## Requerimientos funcionales
1. CRUD de estudiantes (crear, listar, actualizar, eliminar y filtrar por documento/programa).
2. Registro y actualización de resultados Saber Pro por estudiante y fecha de presentación.
3. Gestión de incentivos/beneficios con umbrales de puntaje, vigencia, tipo y programa objetivo.
4. Asignación automática de incentivos a resultados cuyo puntaje esté dentro de los rangos definidos.
5. Reportes: promedio global, promedio por programa y top 5 puntajes, con exportación futura.
6. Consulta general de estudiantes con sus resultados e incentivos aplicados.
7. Consulta detallada por estudiante con resultados por módulo y beneficio asignado.
8. Inicio de sesión por rol (coordinación/estudiante) y autorización de funcionalidades.
9. Generación de informe general descargable (PDF/Excel) para coordinación.
10. Registro de auditoría básico (quién creó o editó datos) previsto para iteraciones futuras.

## Requerimientos no funcionales
- **Seguridad:** autenticación y autorización por rol; uso de HTTPS en Render; parámetros sensibles por variables de entorno.
- **Usabilidad:** interfaz web responsive con navegación directa a módulos clave.
- **Rendimiento:** respuestas <1s para listados de 1k estudiantes; índices en campos de búsqueda (documento, programa).
- **Disponibilidad:** aplicación desplegada en Render con base MySQL accesible; backups periódicos en la instancia DB.
- **Escalabilidad:** posibilidad de escalar instancia en Render y base de datos para mayor carga.
- **Mantenibilidad:** código organizado en capas (controller, repository, service); uso de validaciones Bean Validation.
- **Portabilidad:** empaquetado como jar ejecutable compatible con Java 17.
