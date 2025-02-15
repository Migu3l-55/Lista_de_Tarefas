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
 - Baixe o instalador da IDE Eclipse voltada para o desenvolvimento WEB pelo seguinte
link (https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2024-12/R/eclipse-inst-jre-win64.exe&mirror_id=1135)
 - Execute o Instalador e selecione a opção abaixo para instalar a versão EE. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/1.%20Eclipse%20EE.png)
 - Selecione o diretório padrão para o Eclipse-Workspace quando questionado.
 - Feche a aba de Boas-Vindas do Eclipse. clique no ‘x’ proximo da aba que se encontra
na parte superiora esquerda da sua tela: \![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/2.%20Eclipse%20welcome.png)
### Instalando o Tomcat
 - baixe o Apache Tomcat 9.0.99
(https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.99/bin/apache-tomcat-9.0.99-windows-x64.zi
p) e extraia a pasta apache-tomcat-9.0.99 para o diretorio do seu disco local. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/3.%20disco%20local.png)
 - Abra o eclipse e quando você fechar a aba de boas-vindas, aparecerá o seguinte painel
no canto inferior de sua janela. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/4.painel%20Server.png)
 - Selecione a aba Servers e note que não há nem um servidor configurado.
 - Clique no link destacado em azul no painel para configurar um novo servidor.
 - No novo painel “New Server” selecione a pasta “Apache” e dentro dela selecione a opção “Tomcat v9.0 Server.
 - No campo ”Server Runtime Environment” clique em “Add” e depois em “Browse” no
painel novo e localize e selecione a pasta do seu “Apache-Tomcat-v9.0.99” no seu disco
local e clique em ”Finish”. Clique mais uma vez em “Finish”. Pronto, seu servidor foi
conectado com o Eclipse
### Abrindo os arquivos no Eclipse
 - Baixe o.ZIP dos arquivos no diretório no Github e extraia os arquivos dentro do .ZIP para
a raiz de uma pasta nomeada como “Lista_de_Tarefas”.
 - Com o eclipse aberto e servidor adicionado, clique na opção “File” do menu do Eclipse e
em seguida selecione “Open Project From File System…” \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/5.abrir%20pasta.png)
Clique em “Browse” e localize a pasta “Lista_de_Tarefas” nos seus Downloads ou onde
você tenha colocado a pasta.
 - O seu explorador de Projetos do Eclipse (lateral esquerda) deve mostrar a pasta que
você acabou de importar. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/6.exemplopasta.png)
### Adicionando o acesso ao banco de dados
 - No arquivo Java nomeado de “TarefasDAO” voce vai precisar colocar o seu link de
conexão PostgreSQL. Selecione o “TarefasDAO”. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/7.TarefaDAO.png)
 - Nas linhas 11,12 e 13 encontram-se as variáveis URL, USER e PASSWORD
respectivamente. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/8.mudarvariaveis.png)
Modifique cada pedaço das strings substituindo pelos dados pedidos dentro das chaves
(lembre-se de remover as chaves também).
 - **URL**:
 - *{tipo do banco}* = “postgresql” é o padrão;
 - *{nome do usuário}* = “localhost” é o padrao, mas voce pode ter modificado; {n° porta} = “5432” é o padrão, mas voce pode ter
   modificado.
 - *{nome database}* = nome do banco de dados que você acessa

 - ***USER***: coloque o nome do usuário que acessa o seu banco de dados. “localhost” é o padrão, mas você pode ter modificado.

 - ***PASSWORD***: coloque a senha usada para acessar o seu banco de dados.
   ** Você não precisa criar uma tabela Tarefa antes pois os métodos a cria assim que são executados.
### Executando a página
 - Clique com o botão direito do arquivo “Tarefas.xhtml” que está localizado no seguinte diretório da pasta. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/9.Tarefasxhtml.png)

Selecione a opção “Run as” no painel que aparecer e depois clique em “1 Run on Server”.
 - Selecione “Tomcat v9.0 Server at localhost” e então em “Finish”.
 - O seu console irá exibir linhas que parecem alertas de erro, mas se o seu navegador
abrir em uma página como a inferior então é um sinal de que a conexão foi estabelecida. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/10.painel.png)
## Usando o sistema
o painel principal para a adição de tarefas possui campos de input (entrada de dado) para
que o usuário registre a sua tarefa. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/10.painel.png)
### Campos de entrada

 - **TÍTULO** - (obrigatório): define um título para a tarefa. Max 60
   caracteres;

 - **DESCRIÇÃO** - (opcional): define uma descrição curta sobre que deve ser
   feito. Máx. 100 caracteres;

 - **RESPONSÁVEL** - (obrigatório): define uma pessoa responsável por
   executar a tarefa registrada. Máx. 80 caracteres;

 - **PRIORIDADE** - define a prioridade da tarefa. pode assumir três valores
   apenas: Baixa - tarefas menos exigentes; Médias - tarefas comuns;

 - **Alta** - tarefas mais importantes, difíceis ou que consomem mais tempo.

 - **DATA FINAL** - define uma data limite para que aquela tarefa seja executada.
O campo de texto deve ser respondido da seguinte maneira:
os quatro primeiros dígitos devem ser números;
o quinto dígito deve ser um hífen;
o sexto e o sétimo dígito deve ser números representando o mês;
o oitavo dígito deve ser um hífen;
o nono e o décimo dígito deve ser números representando o dia;

 - **[Botão] ADD** - adiciona os valores dos campos de texto anterior no
   banco de dados criando assim uma nova tarefa.

 - **[Botão] Lista** - exibe uma tabela mostrando todas as tarefas
   registradas no banco de dados.
### Exibir tabela de tarefas
Ao clicar no botão “Lista” da tela anterior, o usuário é levado para uma tabela que exibe as
tarefas que ele inseriu. \
![enter image description here](https://github.com/Migu3l-55/images/blob/ab0fc2942045f9f12dc3c7850a17a16f15363b29/Lista_de_Tarefas/11.tabela.png)
Essa tabela exibe algumas informações sobre a tarefas registradas como: 
**ID** (valor da tarefa registrada no banco de dados), e os valores associados ao **TITULO**,
**RESPONSÁVEL**, **PRIORIDADE**, **DATA FINAL** (ou *deadline*) e se essa tarefa **já foi
concluída ou não**. 

As ações que o usuário pode fazer nessa tela são: **remove tarefa** com o botão **REMOVER**
e **marcar a tarefa como concluída** com o botão **CONCLUIR**
