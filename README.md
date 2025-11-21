# 🚀 SYMBIO - API Core (Java/Quarkus)

Backend principal do projeto SYMBIO, desenvolvido para a Global Solution 2025. Esta API é o cérebro da operação, conectando-se ao banco Oracle e servindo os dados para o frontend React.

**Disciplina:** *Domain Driven Design using JAVA*

## 🛠️ Tecnologias Utilizadas
* Java
* Quarkus
* JDBC 
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

## ☁️ Deploy e Links
Esta aplicação está hospedada na nuvem Render.

**URL da API (Produção):** `[https://symbio-java-k2x1.onrender.com]`
**Vídeo de Demonstração:** `https://www.youtube.com/watch?v=dFaqvPYaIJc`
**Vídeo Pitch:** `https://youtu.be/mT2-jy_XQQ0`

## 🚀 Como Usar e Testar a API SYMBIO (Java + Python no Render) 

```
Este guia explica como testar a API SYMBIO, que consiste em dois microsserviços hospedados no
plano gratuito do Render:
```
1. API Java (Quarkus): https://symbio-java-k2x1.onrender.com
2. API de IA (Python): https://symbio-api-ia.onrender.com

```
⚠ Aviso Importante: O "Cold Start" (Inicialização a Frio)
Ambas as APIs "dormem" após 15 minutos sem uso.
```
```
A API Java (Passo 2) precisa chamar a API de IA (Passo 1). Se a API de IA estiver "dormindo", a API Java
(que acorda mais rápido) não conseguirá obter o risco de IA a tempo e irá salvar o valor de fallback
"ANALISE_PENDENTE" no banco de dados.
```
```
Para demonstrar o fluxo completo (onde a IA retorna "ALTO", "MEDIO" ou "BAIXO"), você DEVE
"aquecer" a API de IA (Python) PRIMEIRO.
```
```
🚀 Passo a Passo para Testar (Roteiro de Demonstração)
Use o Postman ou o cliente HTTP do IntelliJ.
```
```
Passo 1: "Acordar" a API de IA (Python)
Primeiro, envie uma requisição direta para a API de IA para forçá-la a "acordar".
Método: POST
URL: https://symbio-api-ia.onrender.com/prever/risco
Body (raw, JSON):
```
```
{ "features": [90, 10, 30] }
```
```
Ação: Clique em "Send" e aguarde. Esta primeira chamada pode demorar de 30 a 60 segundos. Você
saberá que funcionou quando receber a resposta {"risco_predito": "ALTO"}.
```
```
Passo 2: "Acordar" a API Java (Quarkus)
Agora que a IA está acordada, acorde o Java.
Método: GET
URL: https://symbio-java-k2x1.onrender.com/hello
Ação: Clique em "Send". Esta chamada também pode demorar alguns segundos. Resultado: Você
receberá o JSON {"status": "online", ...}.
```
```
Pronto! Ambas as APIs estão "quentes" e prontas para se comunicar.
```
---
```
🏆 Testando as Funcionalidades
```
```
Agora você pode rodar os testes principais (faça isso nos próximos 10 minutos, antes que elas durmam
de novo).
```
```
Teste 1: Cadastro com IA
Método: POST
URL: https://symbio-java-k2x1.onrender.com/cargos
Body (raw, JSON):
```
```
{
"nm_cargo": "Operador de Telemarketing",
"ds_cargo": "Realizar vendas por telefone seguindo script pré-definido",
"repetitividade": 95,
"criatividade": 5,
"interacao": 100
}
```
```
Resultado Esperado: 201 Created e o JSON de resposta com "nivel_risco_ia": "ALTO". (A
IA respondeu com sucesso!)
```
```
Teste 2: Match de 89%)
Método: GET
URL: https://symbio-java-k2x1.onrender.com/match/1/
Resultado Esperado: 200 OK e o JSON com "porcentagemMatch": 89.47.
```
