# Utilise une image officielle Java
FROM eclipse-temurin:17-jdk

# Création du répertoire de travail
WORKDIR /app

# Copie le jar compilé
COPY target/*.jar app.jar

# Démarre le microservice
ENTRYPOINT ["java", "-jar", "app.jar"]





