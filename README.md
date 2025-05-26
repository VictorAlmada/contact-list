# 📇 Contact List API

Uma API REST de gerenciamento de contatos, desenvolvida em Java 21 com Spring Boot.

---

## 🚀 Tecnologias e ferramentas utilizadas

- ☕ Java 21
- 🌐 Spring Boot (Spring Web)
- 🗄️ Spring Data JPA
- 🏢 Hibernate
- 🐘 Banco de dados relacional (H2/MySQL/PostgreSQL - você escolhe)
- 🔐 Autenticação e autorização (BasicAuth e FormLogin)
- 📦 Lombok
- 🪝 DTOs (Data Transfer Objects)
- 🎯 ResponseEntity (Respostas customizadas)
- 🚦 Tratamento de exceções global
- 📜 Logs customizados no console

---

## 🏗️ Funcionalidades

- ✅ Cadastro de contatos
- 🔍 Listagem de todos os contatos
- 📄 Busca de contatos por ID
- 🔄 Atualização de dados dos contatos
- ❌ Remoção de contatos
- 🛑 Tratamento de erros para requisições inválidas

---

## 🗺️ Endpoints principais

| Método | Endpoint         | Descrição              |
|--------|------------------|------------------------|
| GET    | `/contatos`      | Lista todos os contatos|
| GET    | `/contatos/{id}` | Busca contato por ID   |
| POST   | `/contatos`      | Cria um novo contato   |
| PUT    | `/contatos/{id}` | Atualiza um contato    |
| DELETE | `/contatos/{id}` | Remove um contato      |

---

## 🔐 Security

Eu criei dois usuários para autenticação: 'user' e 'admin' onde:

- User só visualiza os contatos.
- Admin pode fazer todas as operações de CRUD nos contatos.

## 🏆 Melhorias futuras (ideias)

- 🔐 Autenticação e autorização com JWT ou OAuth
- 🧠 Validações mais robustas
- 🗂️ Paginação e ordenação nos endpoints
- 🧪 Testes unitários e de integração
- 📑 Documentação da API (Swagger/OpenAPI)

## 💻 Autor

Desenvolvido por Victor da Costa Almada
- 🚀 Apaixonado por tecnologia e em transição de carreira para a área de TI.
- 🔗 [Victor da Costa Almada](https://www.linkedin.com/in/victor-almada/)


