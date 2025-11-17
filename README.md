# 🧪 Desafio API – Serverest (Kotlin + RestAssured)

Projeto de automação de testes **de API** desenvolvido em **Kotlin + RestAssured** para validar as principais funcionalidades da API   **Serverest**, conforme proposto no desafio técnico.

---

## 🎯 Objetivo do projeto

Demonstrar habilidades em:

- Automação de testes de API com **RestAssured**
- Estruturação de projeto em **Kotlin** (camadas: core, requests, factory, tests)
- Uso de **JUnit 5** com ordenação de cenários quando necessário
- Validação de contratos básicos (status code + mensagens)
- Criação, consulta, alteração e exclusão de recursos (CRUD)
- Uso de **fábricas de dados** para montar payloads dinâmicos
- Uso de **Allure** (anotações e possíveis evidências) para documentação dos testes

---

## 🛠 Tecnologias e Bibliotecas

| Tecnologia / Biblioteca         | Descrição                                           |
|---------------------------------|-----------------------------------------------------|
| **Kotlin JVM**                  | Linguagem principal do projeto                      |
| **JUnit 5 (Jupiter)**           | Framework de testes                                 |
| **RestAssured + Kotlin Extensions** | Client HTTP para testes de API                   |
| **Hamcrest**                    | Matchers e asserts adicionais                       |
| **kotlinx-serialization / Gson**| Serialização e desserialização JSON                |
| **dotenv-kotlin**               | Leitura de variáveis de ambiente (.env)            |
| **Allure (JUnit5 / RestAssured / OkHttp)** | Evidências e relatórios (opcional)    |
| **kotlin-faker** (se usado nas factories) | Geração de dados fake                     |
| **Gradle (Kotlin DSL)**         | Gerenciador de build e dependências                |

---

## 📁 Estrutura do Projeto

Exemplo de estrutura (pode variar levemente conforme seu repo):

```text
📦 desafio-api-serverest-kotlin
├── build.gradle.kts              # Configuração Gradle (Kotlin DSL)
├── settings.gradle.kts
├── .env                          # Configuração de ambiente (URL, credenciais etc.)
└── src
    ├── main
    │   └── kotlin
    │       ├── core/
    │       │   └── Setup.kt      # Configuração base do RestAssured (baseURI, basePath, etc.)
    │       ├── factory/
    │       │   ├── LoginFactory.kt
    │       │   ├── ProductFactory.kt
    │       │   └── UserFactory.kt
    │       └── requests/
    │           ├── LoginRequests.kt
    │           ├── ProductRequests.kt
    │           ├── CartRequests.kt
    │           └── UsersRequests.kt
    └── test
        └── kotlin
            └── tests/
                ├── LoginTests.kt
                ├── ProductTests.kt
                ├── CartTests.kt
                └── UserTests.kt
