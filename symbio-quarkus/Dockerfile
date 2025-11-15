# ===============================
# Etapa 1: Build (Compilação)
# ===============================
# Usamos uma imagem que já tem Maven e JDK 17 instalados
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia apenas o pom.xml primeiro para aproveitar o cache de dependências do Docker
COPY pom.xml .

# (Opcional) Baixa as dependências para cachear esta camada
RUN mvn dependency:go-offline

# Copia o código fonte do projeto
COPY src ./src

# Compila o projeto e gera o .jar (Pula testes para agilizar deploy)
RUN mvn clean package -DskipTests

# ===============================
# Etapa 2: Runtime (Execução)
# ===============================
# Usamos uma imagem leve apenas com o Java (JRE) para rodar
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copia os artefatos gerados na etapa anterior (build)
# O Quarkus gera a pasta 'quarkus-app' dentro de 'target'
COPY --from=build /app/target/quarkus-app/ /app/

# Expõe a porta 8080 (padrão do Quarkus)
EXPOSE 8080

# Variáveis de ambiente padrão (podem ser sobrescritas no Render)
# Isso garante que o Quarkus escute em todos os IPs (necessário para containers)
ENV QUARKUS_HTTP_HOST=0.0.0.0

# Comando para iniciar a aplicação
CMD ["java", "-jar", "quarkus-run.jar"]