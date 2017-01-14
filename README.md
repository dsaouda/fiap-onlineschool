# fiap-onlineschool

Trabalho Java na WEB

## Configuração

- Renomear arquivo src/META-INF/persistence.xml.dist para src/META-INF/persistence.xml
- Configurar o arquivo src/META-INF/persistence.xml de acordo com seu ambiente
	
	Principais propriedades
	<property name="javax.persistence.jdbc.url" value="jdbc:mysql://HOST:3306/DATABASE" />
	<property name="javax.persistence.jdbc.user" value="USUARIO" />
	<property name="javax.persistence.jdbc.password" value="SENHA" />

## Database

- Criar um database no mysql com o nome *fiap_online_school*
	
	create database fiap_online_school

- Importar o script database/script.sql para o banco criado (utilizando o console, se preferir utilize sua ferramenta preferida)

	mysql -uUSUARIO -pSENHA -dBANCO_DE_DADOS < database/script.sql	
	
## Utilização

O sistema está dividido em 3 perfis:
 - admin
 - aluno
 - professor
 
 Para acessar o sistema em um desses perfis utilize as informações abaixo:
 
 - admin
	
	admin@fiap.com.br / 1234 
  	
 - aluno
	
	aluno@fiap.com.br / 1234
  	
 - professor
 	
	professor@fiap.com.br / 1234
	
## Suporte

O sistema foi feito utilizando java 8 e tomcat 8.5.

## Rodando o projeto

Importe o projeto no eclipse, configure o tomcat 8.5 e inicie o servidor. 

Após iniciar o tomcat basta acessar o endereço http://localhost:8080/fiap-java-web-trabalho