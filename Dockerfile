# Usa una imagen de Tomcat como base para desplegar el archivo WAR
FROM tomcat:latest

# Crear el directorio /uploads dentro del contenedor para archivos
#RUN mkdir -p /uploads

# Copia el archivo WAR generado por Maven a la carpeta webapps de Tomcat y renómbralo como ROOT.war
ADD target/apihd-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expone el puerto que escucha Tomcat (generalmente es 8080)
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
