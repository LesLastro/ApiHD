# Usa una imagen de Tomcat como base para desplegar el archivo WAR
FROM tomcat:9.0


# Copia el archivo WAR generado por Maven a la carpeta webapps de Tomcat
COPY target/sircapcev-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

# Expone el puerto que escucha Tomcat (generalmente es 8080)
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]