# Agência de Viagens - Aplicação Web

Este projeto é uma aplicação web desenvolvida utilizando o ecossistema Spring Framework. O back-end é desenvolvido com Java Spring Boot, Spring MVC, e Spring Data JPA, e utiliza MySQL para persistência de dados. O front-end é baseado no padrão MVC e usa Thymeleaf como engine de template para renderização das views.

## Tecnologias Utilizadas

- **Back-end**: Java Spring Boot, Spring MVC, Spring Data JPA
- **Banco de Dados**: MySQL
- **Front-end**: Thymeleaf

## Estrutura do Projeto

### 1. Back-end

O back-end utiliza Java Spring Boot para construir a aplicação e Spring MVC para implementar o padrão Model-View-Controller. A persistência de dados é gerenciada com Spring Data JPA, e o banco de dados é MySQL.

#### Tecnologias e Ferramentas:
- **Spring Boot**: Framework principal para desenvolvimento.
- **Spring MVC**: Implementação do padrão MVC.
- **Spring Data JPA**: Integração com MySQL para persistência de dados.
- **MySQL**: Banco de dados relacional.

#### Endpoints Disponíveis:
- **Destinos**
  - `GET /destinos` - Obtém a lista de destinos disponíveis.
  - `POST /destinos` - Adiciona um novo destino.
  - `PUT /destinos/{id}` - Atualiza um destino existente.
  - `DELETE /destinos/{id}` - Remove um destino.

- **Usuários**
  - `GET /usuarios` - Obtém a lista de usuários.
  - `GET /usuarios/{cpf}` - Obtém informações de um usuário específico pelo CPF.
  - `POST /usuarios` - Adiciona um novo usuário.
  - `PUT /usuarios/{cpf}` - Atualiza um usuário existente.
  - `DELETE /usuarios/{cpf}` - Remove um usuário.

#### Estruturas das Tabelas:

- **Destinos**
  - **nome**: Nome do destino.
  - **valor**: Valor associado ao destino.

- **Usuários**
  - **cpf**: CPF do usuário (identificador único).
  - **nome**: Nome do usuário.
  - **email**: Email do usuário.
  - **telefone**: Telefone do usuário.

### 2. Banco de Dados

O banco de dados utilizado é MySQL, um banco de dados relacional.

#### Configuração do MySQL:
- **URL de Conexão**: Definida em `application.properties`.
- **Database**: Definido como `agencia_viagens`.

#### Estrutura do Banco de Dados:

```sql
CREATE TABLE destino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL
);

CREATE TABLE usuario (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(20)
);
