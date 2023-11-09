<h1 align="center">📱Views Navigation</h1>

## 📝 Índice
- [🧐 Sobre](#-sobre)
  - [⚠ Desafios Enfrentados](#-desafios-enfrentados)
    - [📖 Entendendo o SharedPreferences](#-entendendo-o-sharedpreferences)
  - [✨ Funcionalidades do Aplicativo](#-funcionalidades-do-aplicativo)
- [🧐 Ferramentas Utilizadas](#%EF%B8%8F-ferramentas-utilizadas)
- [✍️ Autores](#%EF%B8%8F-autores)


<h2 align=center>🧐 Sobre</h2>

Este aplicativo foi criado como parte da aula de Programação Mobile, sob a orientação do professor **Paulo**. 

Inicialmente, o projeto tinha como desafio a criação de um app com quatro telas interativas (Tela1, Tela2, Tela3 e Tela4), onde cada uma deveria possuir dois botões para navegação — permitindo ao usuário avançar ou retornar entre as telas. Adicionalmente, cada tela deveria apresentar quatro botões com funcionalidade de mudança de cor, preservando o estado da cor escolhida mesmo após a navegação entre elas. 

No decorrer do desenvolvimento, o conceito foi **adaptado**: ao invés da alternância entre telas, o app foi configurado para **alternar entre imagens de personagens.** A mudança de escopo **não alterou os objetivos educativos do projeto**, que se mantiveram focados em:

- Navegação entre telas
- Gestão de estado
- Manipulação de eventos
- Personalização de interface

<h3 align=center>⚠ Desafios Enfrentados</h3>

Durante o desenvolvimento, alguns desafios notáveis incluíram a transferência eficiente de dados entre as várias views, assegurando uma experiência de usuário coesa e intuitiva. Para manter o estado das imagens dos personagens ao navegar entre diferentes partes do aplicativo, foi empregado o uso do `SharedPreferences`. Esta ferramenta provou ser essencial para a persistência de dados locais, possibilitando que o estado do app fosse preservado entre sessões.

<h4 align=center>📖 Entendendo o SharedPreferences</h4>

O `SharedPreferences` é um mecanismo no Android que permite salvar e recuperar dados primitivos em pares de chave-valor, proporcionando uma maneira simples de armazenar dados leves ou estados de preferência do usuário entre sessões do aplicativo.

No código fornecido, o `SharedPreferences` é utilizado para persistir os índices das imagens de personagens visualizadas, de modo que o estado de visualização seja mantido mesmo após o fechamento e reabertura do aplicativo.

Aqui está um exemplo de como os dados são salvos:
```java
SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
SharedPreferences.Editor editor = prefs.edit();
editor.putInt("counterLuigi", index); // Salvando o índice de Luigi
// ...
editor.apply(); // Aplica as mudanças ao editor de preferências.
```

E aqui está como os dados são recuperados na recriação da atividade:
```java
SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
universalCounter[0] = prefs.getInt("counterLuigi", 0); // Recupera o índice de Luigi
// ...
```

Ao invocar `apply()`, as mudanças são salvas de forma assíncrona, o que é mais eficiente e evita que a interface do usuário seja bloqueada.

<h3 align=center>✨ Funcionalidades do Aplicativo</h3>

Com base na análise do código fornecido anteriormente, o aplicativo possui as seguintes funcionalidades:

1. Navegação Progressiva e Regressiva entre imagens de personagens.
2. Manutenção do estado das imagens ao navegar, assegurando que a imagem selecionada anteriormente seja retomada ao reabrir a aplicação.
3. Gestão de eventos de clique, permitindo ao usuário interagir com botões para mudar a imagem exibida.
4. Salvamento do índice de cada imagem de personagem selecionada usando `SharedPreferences`, garantindo que a seleção do usuário seja mantida.
5. Implementação de botões dedicados para avançar para a próxima imagem ou retornar à anterior, melhorando a interatividade do usuário com o app.

Este aplicativo serve não apenas como um instrumento de aprendizado para os conceitos mencionados, mas também como um exemplo prático da implementação de técnicas de programação Android em um projeto real.

<h2 align=center>⛏️ Ferramentas Utilizadas</h2>
<div align=center>
<a href="https://skillicons.dev"><img src="https://skillicons.dev/icons?i=androidstudio,java,github,git"></a>
</div>

<h2 align=center>✍️ Autores</h2>

- [GabrielleCGNeves](https://github.com/GabrielleCGNeves)
- [ericksantos12](https://github.com/ericksantos12)


