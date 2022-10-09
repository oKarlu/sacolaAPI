<h1>Sacola API</h1>
<p>Sacola API para Servir uma Aplicação com Domínio de Delivery</p>
<p align="center">
<a href="https://docs.google.com/presentation/d/1O_lCZFiuU9MOsot-pJv2lb7kKrRs4ykW/edit?usp=sharing&ouid=101340348592910912358&rtpof=true&sd=true">Slides dia 1</a> ♥ 
<a href="https://docs.google.com/presentation/d/14JDFLaWvK6KL_9ZxubRoBciWQ_aVcxd4/edit?usp=sharing&ouid=101340348592910912358&rtpof=true&sd=true">Slides dia 2</a> ♥
<a href="https://docs.google.com/presentation/d/11rOmP1u7nwYv5mL4ovmquYMZWktPwIiJ/edit?usp=sharing&ouid=101340348592910912358&rtpof=true&sd=true">Slides dia 3</a> ♥ 
<a href="https://docs.google.com/presentation/d/162KrAjBivpN4GKzPVwv7y-JcIPUnN1_h/edit?usp=sharing&ouid=101340348592910912358&rtpof=true&sd=true">Slides dia 4</a>
</p>

<h3>Status do Projeto</h3>
<p align="center"> Sacola API 💻 Em construção... </p>

<h3>Features</h3>

- [x] Incluir itens na sacola<br>
- [x] Visualizar sacola<br>
- [x] Fechar sacola<br>
- [ ] Excluir item da sacola<br>

<h3>Demostração da Aplicação</h3>
<p>Antes de começar, você precisará ter instalado em sua máquina as seguintes ferramentas:</p>
<table>
<tr>
	<th>Ferramenta</th>
	<th>Versão</th>
</tr>
<tr>
	<td>Java JDK</td>
	<td>8+</td>
</tr>
<tr>
	<td>Git</td>
	<td>2.**</td>
</tr>
<tr>
	<td>Gradle</td>
	<td>7.**</td>
</tr>
<tr>
	<td>Postman</td>
	<td>9.**</td>
</tr>
</table>
<h6>** Visando facilitar a demostração da aplicação, recomendo instalar apenas o IntelliJ IDEA e rodar o projeto através da IDE **</h6>

No Terminal/Console:
<ol>
	<li>Faça um clone do projeto na sua máquina: <code>git clone https://github.com/cami-la/sacola-api.git</code></li>
	<li>Entre na pasta raiz do projeto: <code>cd sacola-api</code></li> 
	<li>Rode o comando: <code>./gradlew bootrun</code></li>
	<li>Com a aplicação "de pé", clique aqui: <a href="http://localhost:8081/swagger-ui/">http://localhost:8081/swagger-ui/</a></li>
</ol>

<a href="https://drive.google.com/file/d/1-FTY7jRfYbqVNQi-B7Dvn8p6wjnzf2f6/view?usp=sharing"> 🚀 Collection Sacola API - Postman</a><br>

<img src="https://i.imgur.com/UBHcWKt.png" alt="Sacola API Swagger UI">

<h3>Tecnologias Utilizadas</h3>

<table>
<tr>
	<th>Dependência</th>
	<th>Versão</th>
</tr>
<tr>
	<td>spring initialzr</td>
	<td><a href="https://start.spring.io/">https://start.spring.io/</a></td>
</tr>
<tr>
	<td>spring-boot-starter-web</td>
	<td>2.7.4</td>
</tr>
<tr>
	<td>spring-boot-starter-data-jpa</td>
	<td>2.7.4</td>
</tr>
<tr>
	<td>lombok</td>
	<td>1.18.24</td>
</tr>
<tr>
	<td>springfox-boot-starter</td>
	<td>3.0.0</td>
</tr>
<tr>
	<td>h2</td>
	<td>2.1.214</td>
</tr>
</table>