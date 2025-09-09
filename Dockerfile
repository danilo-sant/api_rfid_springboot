# Usa uma imagem base oficial do Java 17 (OpenJDK)
FROM eclipse-temurin:17-jdk-jammy

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos do Maven para baixar as dependências primeiro (cache)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Baixa as dependências
RUN ./mvnw dependency:go-offline

# Copia o resto do código fonte do projeto
COPY src ./src

# Compila e empacota a aplicação em um .jar, pulando os testes
RUN ./mvnw package -Dmaven.test.skip=true

# Expõe a porta 8080 para a Render poder se comunicar com a aplicação
EXPOSE 8080

# Comando final para iniciar a aplicação quando o container rodar
ENTRYPOINT ["java","-jar","/app/target/api-rfid-0.0.1-SNAPSHOT.jar"]