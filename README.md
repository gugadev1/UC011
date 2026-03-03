# Sistema de Leilões - Cadastro de Itens (Atividade 1)

Projeto Java para informatizar as rotinas de uma casa de leilões, com persistência em banco MySQL usando JDBC.

Requisitos
- Java 11+
- Maven
- MySQL ou MariaDB com o banco do projeto

Configurar o banco
1. Importe/execute o arquivo SQL do projeto no seu servidor MySQL/MariaDB.
2. Configure as credenciais de conexão:

- Crie um arquivo `db.properties` na raiz do projeto copiando `db.properties.sample` e atualize os valores (`db.host`, `db.port`, `db.name`, `db.user`, `db.password`).
- Se `db.properties` não existir, a aplicação usará as configurações padrão definidas no projeto.

Build e execução
```bash
cd /c/caminho/do/projeto
mvn package
java -jar target/sistema-leiloes-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Uso
- Preencha os campos do formulário de cadastro de itens/leilões conforme solicitado pela interface.
- Clique em "Salvar" para inserir os dados no banco.

Observações
- Este repositório está versionado com Git e publicado no GitHub conforme os requisitos da atividade.
- O projeto utiliza Java e MySQL como tecnologias principais.