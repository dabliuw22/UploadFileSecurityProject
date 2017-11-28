# Upload y Visualización de Imagenes con Spring Security

En este proyecto se cargaran en la base de datos y visualizaran Noticias con contenidos de imagen. Se utilizara Hibernate Framework con Spring MVC y Spring Security. El motor de base de datos relacionales sera MySQL.
1. Primero se requiere setiar el valor de allowCasualMultipartParsing a true en el context.xml de nuestro Tomcat como se especifica en la [documentación de Tomcat 8](https://tomcat.apache.org/tomcat-8.0-doc/config/context.html): 
``` [XML]
<Context ... allowCasualMultipartParsing="true">
...
</Context>
```
2. Configuramos el arranque del MultipartFilter antes del filtro de Spring Security, todo esto por **CSRF** activo en Spring Security como se especifica en la [documentación Spring Security](https://docs.spring.io/spring-security/site/docs/5.0.0.BUILD-SNAPSHOT/reference/htmlsingle/#csrf-multipart): 
``` [Java]
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		insertFilters(servletContext, new MultipartFilter());
	}
}
```