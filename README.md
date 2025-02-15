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
### Arquivos Java

 - **Tarefa.java** - Classe de apoio para gerar objetos Tarefa que serão usados pela
classe TarefaDAO para criar uma lista das tarefas do banco de dados
 - **TarefaBEAN.java** Executa e analisa os dados inseridos pelo usuário. Executa funções definidas pela classe TarefaDAO e serve de
   implementação aos arquivos Tarefas.xhtml e Listagem.xhtml.
 - **TarefaDAO.java** Classe que faz a conexão com o banco de dados e possui métodos de adição, modificação, busca e exclusão com os itens
   do banco.
 - **TestesDAO.java** classe usada para testar os métodos de TarefaDAO (ex o
método *listarTarefasPorResponsavel()* que não é usada no jsf, mas funciona aqui).
### Arquivos JSF
- **Listagem.xhtml** exibe a tabela com todos os registros no banco de dados
- **Tarefas.xhtml** painel para adicionar nova tarefa.
## Guia de SetUp e preparação para o funcionamento
### Instalando Eclipse EE Edition
1. Baixe o instalador da IDE Eclipse voltada para o desenvolvimento WEB pelo seguinte
link (https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2024-12/R/eclipse-inst-jre-win64.exe&mirror_id=1135)
2. Execute o Instalador e selecione a opção abaixo para instalar a versão EE.
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/1.%20Eclipse%20EE.png)
3. Selecione o diretório padrão para o Eclipse-Workspace quando questionado.
4. Feche a aba de Boas-Vindas do Eclipse. clique no ‘x’ proximo da aba que se encontra
na parte superiora esquerda da sua tela:![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/2.%20Eclipse%20welcome.png)
### Instalando o Tomcat
1. baixe o Apache Tomcat 9.0.99
(https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.99/bin/apache-tomcat-9.0.99-windows-x64.zi
p) e extraia a pasta apache-tomcat-9.0.99 para o diretorio do seu disco local.
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/3.%20disco%20local.png)
2. Abra o eclipse e quando você fechar a aba de boas-vindas, aparecerá o seguinte painel
no canto inferior de sua janela.
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/4.painel%20Server.png)
3. Selecione a aba Servers e note que não há nem um servidor configurado.
4. Clique no link destacado em azul no painel para configurar um novo servidor.
5. No novo painel “New Server” selecione a pasta “Apache” e dentro dela selecione a opção “Tomcat v9.0 Server.
6. No campo ”Server Runtime Environment” clique em “Add” e depois em “Browse” no
painel novo e localize e selecione a pasta do seu “Apache-Tomcat-v9.0.99” no seu disco
local e clique em ”Finish”. Clique mais uma vez em “Finish”. Pronto, seu servidor foi
conectado com o Eclipse
### Abrindo os arquivos no Eclipse
1. Baixe o.ZIP dos arquivos no diretório no Github e extraia os arquivos dentro do .ZIP para
a raiz de uma pasta nomeada como “Lista_de_Tarefas”.
2. Com o eclipse aberto e servidor adicionado, clique na opção “File” do menu do Eclipse e
em seguida selecione “Open Project From File System…”
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/5.abrir%20pasta.png)
Clique em “Browse” e localize a pasta “Lista_de_Tarefas” nos seus Downloads ou onde
você tenha colocado a pasta.
3. O seu explorador de Projetos do Eclipse (lateral esquerda) deve mostrar a pasta que
você acabou de importar ![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/6.exemplopasta.png)
### Adicionando o acesso ao banco de dados
1. No arquivo Java nomeado de “TarefasDAO” voce vai precisar colocar o seu link de
conexão PostgreSQL. Selecione o “TarefasDAO”.
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/7.TarefaDAO.png)
2. Nas linhas 11,12 e 13 encontram-se as variáveis URL, USER e PASSWORD
respectivamente.
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/8.mudarvariaveis.png)
