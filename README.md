# Java JDBC DAO
:desktop_computer: :keyboard: :computer_mouse: :coffee:

## Breve Relato :bulb:

### :point_right: Peristência de dados

>**Persistência de dados** é como a garantia de que **um dado salvo, poderá ser recuperado quando necessário**.  
>A duas formas mais comuns de persistir dados é  **Banco de dados_(SQL)_** e **arquivos_(xml ou txt)_**.
>
>Dados **com persistência** = **_Banco Dados_**  
>Dados **sem persitência** = **_Memória Ram_**

### :point_right: JDBC

#### O que é?
>
>O **JDBC** é uma **_biblioteca_** implementada em java que disponibiliza **_classes e interfaces_** para persistência e acesso ao **banco de dados**.  
>Para cada  servidor de dados(SQLServer, PostgreSQL e outros) a  **JDBC API** disponibiliza um **JDBC Driver**, a fim, da **aplicação java**  se comunicar. 

#### Principais classes e interfaces JDBC

>- **DriverManager**, cria conexão com o banco de dados;
>- **Connection**, mantém uma conexão aberta com o banco;
>- **Statement**, gerencia e executa instrução SQL;
>- **PreparedStatement**, gerencia e executa instuções SQL(parâmetros);
>- **ResultSet**, recebe os dados obtidos em uma pesquisa ao banco.

### :point_right: Java DAO

#### Data Access Object (DAO)

>É um padrão de projeto ou uma boa prática que programação, que possibilita organizar nosso código de forma mais prática e legível, a fim,  facilitar sua alteração e leitura.
>
>>MVC 
>>
>>>Visão
>>>
>>>Controle
>>>
>>>Modelo
>>
>>DAO
>>
>>Persistencia
