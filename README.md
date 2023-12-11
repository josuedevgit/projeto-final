# PROJETO FINAL 

 <img src="https://cdn0.vox-cdn.com/assets/4599351/spider-chase.gif"/>

 ## Desenvolvimento de plataforma para entusiastas da franquia Zelda 🧝🏻‍♂️

### Descrição
Este projeto foi proposto na aula do Geração Caldeira e executado por cinco alunos. O software foi estruturado em três microserviços distintos, cada um desempenhando um papel fundamental na experiência do usuário.
O projeto proporcionará aos entusiastas da franquia Zelda uma plataforma envolvente e interativa, reunindo informações detalhadas e permitindo a interação social entre os usuários. Prepare-se para mergulhar no universo de Zelda e explorar o potencial da arquitetura de microserviços em Java com Spring!

### Tecnologias utilizadas

<table>
  <tr>  
    <td>Java</td>
    <td>Springboot</td>
    <td>JUnit</td>
    <td>PostgresSQL</td>
    <td>GateWay</td>
    </tr>
  <tr>
    <td>17</td>
    <td>3</td>
    <td>4</td>
    <td>16</td>
    <td>3000</td>
  </tr>  
</table>

## Como acessar este projeto na sua máquina:
```bash
Para criar um banco de dados local e interagir com ele usando o Postman, você pode seguir o passo a passo abaixo:

### Passo 1: Criando o banco de dados local

1. Baixe e instale um sistema de gerenciamento de banco de dados PostgreSQL em sua máquina local, se ainda não tiver.
   
2. Execute os scripts SQL fornecidos na pasta "BDD" para criar o banco de dados e as tabelas.

### Passo 2: Utilizando o Postman para interagir com o banco

#### Adicionar um novo usuário:

1. Abra o Postman.

2. Selecione o método POST e insira a seguinte URL:
   
   http://localhost:8080/api/usuarios/add
   

3. No corpo da solicitação, insira um exemplo de código JSON para adicionar um novo usuário:
   json
   {
     "nome": "Marco Jr",
     "idade": 8
   }
   

4. Envie a solicitação.

#### Alterar o usuário:

1. Selecione o método PUT e insira a seguinte URL, substituindo {id} pelo ID do usuário desejado:
   
   http://localhost:8080/api/usuarios/update/{id}
   

2. No corpo da solicitação, insira um exemplo de código JSON para atualizar o usuário:
   json
   {
     "nome": "Marco Jr",
     "idade": 9
   }
   

3. Envie a solicitação.

#### Deletar o usuário:

1. Selecione o método DELETE e insira a seguinte URL, substituindo {id} pelo ID do usuário desejado:
   
   http://localhost:8080/api/usuarios/delete/{id}
   

2. Envie a solicitação para deletar o usuário associado ao ID selecionado.

#### Selecionar jogos favoritos de um usuário:

1. Selecione o método GET e insira a seguinte URL, substituindo 1 pelo ID do usuário desejado:
   
   http://localhost:8080/api/usuarios/1/jogosfavoritos
   

2. Envie a solicitação para obter os jogos favoritos do usuário associado ao ID selecionado.

Certifique-se de que o servidor esteja em execução na porta 8080 e que as URLs estejam corretas.
```

## Equipe de desenvolvedores:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/josuedevgit">
       <img src="https://github.com/josuedevgit/projeto-final/assets/116842009/afc34544-0cfa-4a99-b0e5-462c416c775d" 
       "smartCard-inline " width="100px;" alt="Foto de Josué"/><br>
        <sub>
          <b>Josué</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/0hTutu">
        <img src="https://github.com/josuedevgit/projeto-final/assets/116842009/03bb68e0-eacd-4dfc-94df-f32be4bcf463"
          "smartCard-inline" width="100px;" alt="Foto de Arthur"/><br>
        <sub>
          <b>Arthur</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/biancaoliveirx">
        <img src="https://github.com/josuedevgit/projeto-final/assets/116842009/0692cbd5-800c-441a-a9d6-d60e48a43de4"
          "smartCard-inline" width="100px;" alt="Foto de Bianca"/><br>
        <sub>
          <b>Bianca</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Aliciafrom0">
        <img src="https://github.com/josuedevgit/projeto-final/assets/116842009/2a3cf827-f0ca-4bd7-a188-844b8e2be35f"
          "smartCard-inline" width="100px;" alt="Foto de Alicia"/><br>
        <sub>
          <b>Alicia</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/sdksantana">
        <img src="https://github.com/josuedevgit/projeto-final/assets/116842009/c983d34a-4cd2-4153-ab27-24b84229d11c"
          "smartCard-inline" width="100px;" alt="Foto de Kah"/><br>
        <sub>
          <b>Kah</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<img src="https://78.media.tumblr.com/eceb4c1e8c552563ef13ca148d33818b/tumblr_p1b5oaj3681v3suvbo4_400.gif"/>
