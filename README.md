# ProdutoXPTO - Sistema de Cadastro e Controle de Estoque

Sistema web desenvolvido em Java com **Spring Boot**, **Thymeleaf** e banco de dados **H2** para gerenciamento simples de produtos (cadastro com nome, tipo, tamanho e quantidade) e visualização de estoque.

---

## Funcionalidades

- **Cadastro de Produtos:** Formulário para registrar novos itens informando Nome, Tipo, Tamanho e Quantidade inicial.
- **Controle de Estoque:** Aba dedicada para listar todos os produtos cadastrados em tabela organizada, com opção de exclusão.
- **Navegação por Abas:** Alternância rápida entre a tela de cadastro e a tela de estoque.
- **Banco de Dados em Memória:** Persistência rápida durante a execução utilizando o banco H2, com console web integrado para consultas SQL.

---

## Tecnologias Utilizadas

- **Java 25**
- **Spring Boot 4.1.2**
  - Spring Web (MVC)
  - Spring Data JPA
  - Thymeleaf
- **H2 Database** (em memória)
- **Bootstrap 5** (estilização das telas HTML)
- **Maven** (gerenciador de dependências e build)

---

## Estrutura do Projeto

```text
src/
└── main/
    ├── java/
    │   └── br/com/sebrae/produtoxpto/
    │       ├── controller/
    │       │   └── ProdutoController.java      # Rotas e controle das telas
    │       ├── model/
    │       │   └── Produto.java                # Entidade JPA do produto
    │       ├── repository/
    │       │   └── ProdutoRepository.java      # Interface de acesso ao banco
    │       └── ProdutoxptoApplication.java     # Classe principal de inicialização
    └── resources/
        ├── templates/
        │   ├── cadastro.html                   # Tela da aba de cadastro
        │   └── estoque.html                    # Tela da aba de estoque
        └── application.properties              # Configurações do Spring e H2
```

---

## Como Executar o Projeto

### Pré-requisitos
- **JDK 25** (ou superior) instalado e configurado.
- **IntelliJ IDEA** (ou outra IDE Java de sua preferência).

### Passos para rodar
1. Clone ou extraia a pasta do projeto no seu computador.
2. Abra o projeto no **IntelliJ IDEA** e aguarde o carregamento do Maven.
3. Localize a classe `ProdutoxptoApplication.java` em `src/main/java/br/com/sebrae/produtoxpto/`.
4. Clique no botão verde de **Run (Play)** ao lado do método `main`.
5. Após a inicialização no console, abra o navegador e acesse:
   - **Aplicação:** `http://localhost:8080`
   - **Console do Banco H2:** `http://localhost:8080/h2-console` *(JDBC URL: `jdbc:h2:mem:estoquedb` | User: `sa` | Senha: em branco)*

---

## Rotas Principais

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/` | Exibe a aba de cadastro de novos produtos. |
| `POST` | `/salvar` | Salva o produto no banco H2 e redireciona para o estoque. |
| `GET` | `/estoque` | Exibe a aba com a lista de produtos cadastrados. |
| `GET` | `/excluir/{id}` | Remove um produto específico do estoque pelo ID. |
