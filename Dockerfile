# Usa uma imagem base oficial do Java 17 (OpenJDK)
FROM eclipse-temurin:17-jdk-jammy

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos do Maven
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# =================================================================
# --- CORREÇÃO ADICIONADA AQUI ---
# Dá permissão de execução para o script do Maven Wrapper
RUN chmod +x mvnw
# =================================================================

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