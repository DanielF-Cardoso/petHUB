<p align="center">
  <img src="https://i.imgur.com/JXyyAti.png" alt="petHUB">
</p>

## Descrição

O petHUB é um gerenciador de petshop, pensado para facilitar o gerenciamento de vendas e de vacinas de um petshop.

Este projeto foi desenvolvido como parte da atividade avaliativa A3 da disciplina de Programação de Soluções Computacionais de Análise e Desenvolvimento de Sistemas da UNIFG/BA.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) ![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

## Funcionalidades

- Controle de clientes
- Controle de animais
- Controle de vacinas
- Controle de vendas
- Controle de produtos
- Controle de fornecedores
- Controle de Funcionário com nível de acesso
- Geração de Relatórios e pedido de venda
- Ficha Animal com todas as vacians registradas

## Dependências

- [json-20160810](https://repo1.maven.org/maven2/org/json/json/20160810/json-20160810.jar)
- [mysql-connector](https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.0.31/mysql-connector-j-8.0.31.jar)
- [jBCrypt](https://repo1.maven.org/maven2/de/svenkubiak/jBCrypt/0.4/jBCrypt-0.4.jar)
- [JasperReports® Library](https://community.jaspersoft.com/download-jaspersoft/community-edition/)

## Pacotes Externos

- [ViaCEP](https://gitlab.com/parg/ViaCEP) - Biblioteca para consulta de CEPs através da API do ViaCEP (https://viacep.com.br/)

## Telas

<div align="center">

| Login | Dashboard |
| --- | --- |
| <img src="https://i.imgur.com/vHZlwML.png" width="410" height="200" /> | <img src="https://i.imgur.com/7DS68zy.png" width="410" height="200" /> |

| Cadastro Cliente | Cadastro Pet |
| --- | --- |
| <img src="https://i.imgur.com/xwclfVX.png" width="410" height="200" /> | <img src="https://i.imgur.com/ak1ComS.png" width="410" height="200" /> |

| Cadastro Funcionário | Cadastro Fornecedor |
| --- | --- |
| <img src="https://i.imgur.com/xwclfVX.png" width="410" height="200" /> | <img src="https://i.imgur.com/idSJ3rU.png" width="410" height="200" /> |

| Cadastro Produto | Controle Estoque |
| --- | --- |
| <img src="https://i.imgur.com/FY5gZhb.png" width="410" height="200" /> | <img src="https://i.imgur.com/cXW7L3A.png" width="410" height="200" /> |

| Controle Vacinas | Tela Vendas |
| --- | --- |
| <img src="https://i.imgur.com/xEFOWUI.png" width="410" height="200" /> | <img src="https://i.imgur.com/U5NTinG.png" width="410" height="200" /> |

| Total Vendas | Histórico Vendas |
| --- | --- |
| <img src="https://i.imgur.com/l3rJbHa.png" width="410" height="200" /> | <img src="https://i.imgur.com/X2fe6BF.png" width="410" height="200" /> |

</div>

## Logins

### Administrador (Acesso Total ao Sistema)
- **Usuário:** admin@admin.com
- **Senha:** admin

### Vendedor
- **Acessos:** Cadastro de Clientes, Animais, Produtos e Serviços, Agenda de Serviços e Abrir PDV
- **Usuário:** vendedor@vendedor.com
- **Senha:** vendedor

### Veterinário
- **Acessos:** Cadastro de Clientes, Animais, Produtos e Serviços, Agenda de Serviços, Gerar Ficha Animal e Registro de Vacina
- **Usuário:** veterinario@veterinario.com
- **Senha:** veterinario

## Instalação

Antes de começar, verifique se você possui o Java 17/22 instalado em seu computador. Se não tiver, faça o download e a instalação a partir do site oficial.

1. **Configuração do Banco de Dados**
    - Abra o arquivo `config.properties` dentro da pasta `resources`.
    - Edite o arquivo com as informações do seu banco de dados.

2. **Importação do Banco de Dados**
    - Importe o banco de dados disponível na raiz do projeto (petHUB.sql) para o seu servidor MySQL.

3. **Execução do Projeto**
    - No diretório raiz do projeto, execute os seguintes comandos do Maven para limpar e empacotar o projeto:
      ```sh
      mvn clean package
      ```
    - O comando acima irá gerar um arquivo `petHUB-1.0-SNAPSHOT.jar` na pasta `target`.

4. **Iniciando a Aplicação**
    - Execute o arquivo `petHUB-1.0-SNAPSHOT.jar` gerado, que já estará com todas as dependências necessárias:
      ```sh
      java -jar target/petHUB-1.0-SNAPSHOT.jar
      ```
