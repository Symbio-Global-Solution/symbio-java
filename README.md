# 🚀 SYMBIO - API Core (Java/Quarkus)

Backend principal do projeto SYMBIO, desenvolvido para a Global Solution 2025. Esta API é o cérebro da operação, conectando-se ao banco Oracle e servindo os dados para o frontend React.

**Disciplina Relacionada:** *Domain Driven Design using JAVA*

## 🛠️ Tecnologias Utilizadas
* Java
* Quarkus
* [cite_start]JDBC (Padrão DAO Clássico) [cite: 339]
* RESTeasy Reactive
* Oracle Database
* Maven

## ✨ Funcionalidades Principais
* CRUD completo para `Colaborador`, `Cargo`, `Skill`, e `Vaga`.
* Endpoint de "Match" que calcula a compatibilidade entre Colaboradores e Vagas.
* Serviço de integração para consumir a API de IA (Python/Flask).
* Geração de dados agregados para o Dashboard (ex: contagem de risco).

## 🎛️ Endpoints Principais (Exemplos)
* `GET /api/colaboradores`: Lista todos os colaboradores.
* `POST /api/colaboradores`: Cadastra um novo colaborador.
* `GET /api/dashboard/risco`: Retorna dados para o gráfico de pizza.
* `GET /api/match/{idColaborador}`: Retorna os "Matches" de vagas para um colaborador.

## 🚀 Como Executar (Localmente)

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/](https://github.com/)[seu-usuario]/symbio-api-java.git
    cd symbio-api-java
    ```
2.  **Configure o Banco de Dados:**
    * Renomeie `application.properties.example` para `application.properties`.
    * Preencha as variáveis de conexão com o Oracle (`quarkus.datasource.jdbc.url`, `username`, `password`).
3.  **Execute o Quarkus em modo de desenvolvimento:**
    ```bash
    ./mvnw quarkus:dev
    ```
4.  A API estará disponível em `http://localhost:8080`.

## ☁️ Deploy
[cite_start]Conforme o edital[cite: 353], esta aplicação será hospedada na nuvem (Render/Railway).

**URL da API (Produção):** `[LINK DO SEU DEPLOY AQUI]`

##  deliverables
[cite_start]Para a entrega final, este repositório será zipado [cite: 363] e acompanhado de:
* [cite_start]Documentação PDF [cite: 364]
* [cite_start]Link do Deploy [cite: 365]
* [cite_start]Vídeo de Demonstração (máx 10 min) [cite: 367]
