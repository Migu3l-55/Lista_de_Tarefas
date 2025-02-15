# Lista_de_Tarefas usando JSF 2.2 e PostgreSQL
Atividade requisitada pelo GUPO ESIG / Lista de tarefas.

## Sumário
- **Tecnologias usadas**
- **O que foi feito**
  - _Arquivos Java_
  -  _Arquivos do JSF_ 
- **Guia de SetUp e preparação para o funcionamento**
  - _Instalando Eclipse EE Edition_
  - _Instalando o Tomcat_
  - _Abrindo os arquivos no Eclipse_
  - _Adicionando o acesso ao banco de dados_
  - _Executando a página_ 
- **Usando o sistema**
  - _Campos de entrada_
  - _Exibir tabela de tarefas_

  ## Tecnologias Usadas
- java - v21.0.1
- JSF (impl e api) - v2.2.8 (jsf-impl: https://repo1.maven.org/maven2/com/sun/faces/jsf-impl/2.2.8/jsf-impl-2.2.8.jar 
 jsf-api: https://repo1.maven.org/maven2/com/sun/faces/jsf-api/2.2.8/jsf-api-2.2.8.jar)
- PostgreSQL - v17.2
- Apache Tomcat - v9.0.99 (https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.99/bin/apache-tomcat-9.0.99-windows-x64.zip)
- Eclipse (IDE) EE Edition - v4.34.0
- PostgreSQL JDBC - v42.7.5 (https://jdbc.postgresql.org/download/postgresql-42.7.5.jar)
- Javax Annotation api - v1.2 (https://repo1.maven.org/maven2/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar)

## o que foi feito
**Tarefa.java** Classe de apoio para gerar objetos Tarefa que serão usados pela
classe TarefaDAO para criar uma lista das tarefas do banco de dados \
**TarefaBEAN.java** Executa e analisa os dados inseridos pelo usuário. Executa
funções definidas pela classe TarefaDAO e serve de implementação aos arquivos
Tarefas.xhtml e Listagem.xhtml.
