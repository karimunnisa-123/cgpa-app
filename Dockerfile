# Use Tomcat with Java 17
FROM tomcat:10.1-jdk17

# Copy WAR file as ROOT.war so it runs at localhost:8080
COPY target/cgpa-app.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
