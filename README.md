# Sistema de Gestão de Alunos - FATEC (P2)

Projeto desenvolvido como parte da avaliação P2 do curso de Análise e Desenvolvimento de Sistemas da FATEC. O objetivo da aplicação é permitir o cadastro de cursos e a matrícula de alunos, gerenciando o relacionamento entre eles e garantindo a integridade dos dados.

## 📺 Demonstração em Vídeo

Confira a explicação detalhada do código e o funcionamento do projeto no YouTube:

[![Assista ao Vídeo](https://img.youtube.com/vi/ID_DO_VIDEO_AQUI/0.jpg)](LINK_DO_SEU_VIDEO_AQUI)

> **Clique na imagem acima ou [neste link](LINK_DO_SEU_VIDEO_AQUI) para assistir.**

---

## Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3** (Web, JPA, Validation)
* **Thymeleaf** (Template Engine)
* **Banco de Dados:** H2 / MySQL (Dependendo da sua config)
* **Maven** (Gerenciador de Dependências)

---

## Arquitetura do Projeto (MVC)

O projeto segue o padrão de arquitetura **MVC (Model-View-Controller)**, garantindo a separação de responsabilidades. Abaixo, detalho como cada camada foi implementada conforme apresentado no vídeo:

### 1. Model (Camada de Modelo)
Representa as entidades do banco de dados e as regras de negócio.
* **Mapeamento ORM:** Utilização de anotações do **JPA** (`@Entity`, `@Id`, `@GeneratedValue`) para transformar as classes Java em tabelas.
* **Relacionamento:** Implementação de relacionamento **One-to-Many** (`@ManyToOne`) na classe `Aluno`, indicando que muitos alunos pertencem a um único curso.
* **Validação:** Uso de **Bean Validation** (`@NotBlank`, `@Email`, `@NotNull`, `@Min`) para impedir a entrada de dados vazios ou inválidos antes mesmo de processar a requisição.

### 2. Repository (Camada de Persistência)
Responsável pela comunicação direta com o banco de dados.
* **Spring Data JPA:** As interfaces estendem `JpaRepository`.
* **Produtividade:** Isso abstrai a necessidade de escrever SQL manual, fornecendo automaticamente métodos de CRUD como `save()`, `findAll()` e `delete()`.

### 3. Controller (Camada de Controle)
O "coração" da aplicação, responsável por orquestrar o fluxo de dados.
* **Injeção de Dependência:** Utilização do `@Autowired` para injetar as instâncias dos repositórios, garantindo baixo acoplamento.
* **Métodos GET:**
    * `listar()`: Busca os dados e preenche o objeto `Model` para exibição na View.
    * `formulario()`: Prepara o cadastro carregando, por exemplo, a lista de cursos para preencher o *combobox* (menu suspenso) de seleção, garantindo a integridade relacional.
* **Métodos POST (Salvar):**
    * Utiliza a anotação `@Valid` para ativar as validações do Model.
    * **Tratamento de Erros:** Verifica o objeto `BindingResult`. Se houver erros de validação (ex: email inválido), o sistema impede o salvamento e retorna o usuário ao formulário, exibindo as mensagens de erro.

### 4. View (Camada de Visualização)
* Arquivos HTML localizados em `src/main/resources/templates`.
* Utiliza **Thymeleaf** para renderizar os dados vindos do Controller e exibir mensagens de erro de validação para o usuário.

---

## Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/ThiagoMoura963/NOME-DO-REPOSITORIO.git](https://github.com/ThiagoMoura963/NOME-DO-REPOSITORIO.git)
