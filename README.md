# fiap-onlineschool

Trabalho Java na WEB. Para realiza��o do trabalho foi utilizado como server java 8 com servlet 3, JSP, tomcat 8.5, JPA 2.1 e JSTL. 

No frontend foi utilizado material design lite (getmdl - https://getmdl.io/) para o perfil admin. 

Para o perfil aluno foi utilizado semantic-ui (http://semantic-ui.com/). 

Para o perfil do professor foi utilizado o materialize (http://materializecss.com/) outro css baseado em material design. 

Para o site inicial foi utilizado bootstrap (http://getbootstrap.com/)

## Configura��o

- Renomear arquivo src/META-INF/persistence.xml.dist para src/META-INF/persistence.xml
- Configurar o arquivo src/META-INF/persistence.xml de acordo com seu ambiente
	
## Database

- Criar um database no mysql com o nome *fiap_online_school*
	
	create database fiap_online_school

- Importar o script database/script.sql para o banco criado (utilizando o console, se preferir utilize sua ferramenta preferida)

	mysql -uUSUARIO -pSENHA -dBANCO_DE_DADOS < database/script.sql	
	
## Acessos

O sistema est� dividido em 3 perfis:
 - admin (admin@fiap.com.br / 1234)
 - aluno (aluno@fiap.com.br / 1234)
 - professor (professor@fiap.com.br / 1234)

Obs: Login e Senha entre par�nteses

## Suporte

O sistema foi feito utilizando java 8 e tomcat 8.5.

## Rodando o projeto

Importe o projeto no eclipse, configure o tomcat 8.5 e inicie o servidor. 

Ap�s iniciar o tomcat basta acessar o endere�o http://localhost:8080/fiap-java-web-trabalho

## Observa��es

Caso n�o tenha importado o banco de dados voc� pode executar a classe br.com.fiap.dsaouda.javaweb.fixture.Bootstrap, o banco de dados ser� criado e dados iniciais ser�o cadastrados. Os dados iniciais podem ser conferidos na se��o acessos.