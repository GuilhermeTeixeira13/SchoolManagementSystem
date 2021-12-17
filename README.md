# CLASSES

**Escola Profissional de Informática (Gui 26-11)** -> Nome da Escola, Número da Escola, Composto por vários cursos(ArrayList de Cursos), Localização, Diretor da Escola, Contactos da Escola, Composta por várias pessoas(ArrayList de pessoas), Composta por várias disciplinas(ArrayList de Disciplinas)

**Curso (Gui 26-11)** -> Código de Curso; Composto por várias disciplinas(ArrayList de Disciplinas), Provas de Ingresso, Nome, Duração em horas, Média do Último Colocado, Data de início, Data de fim, Alunos(ArrayList de Alunos).

***

**Disciplina (João 26-11)** -> Número da disciplina, Nome, Alunos Inscritos (ArrayList de Aluno), Professores que lecionam(ArrayList de Professores), Frequencias(ArrayList de Frequencias)

**ProvasDeIngresso (João 26-11)** -> Provas de Ingresso(ArrayList de Strings), e/ou(String)
***
**Pessoa (Gui 26-11)** ->  Nome, Contactos, Local de Origem, email, data de nascimento(para a partir daí calcular a idade)

**Aluno EXTENDS Pessoa (Gui 26-11)** -> Número de aluno, NotasDisciplinas(ArrayList de NotasDisciplina), Média de Entrada, Disciplinas a que está inscrito (ArrayList de Disciplinas), Curso em que está

**Professor EXTENDS Pessoa (João 26-11)** -> Número de Professor, Rating, Disciplinas que Leciona(ArrayList de Disciplinas)

**Diretor EXTENDS Pessoa (Gui 26-11)** -> Anos de serviço, Formação Académica
***
**NotasDisciplina (Tiago 26-11)** -> disciplina, notas(ArrayList de Resultados) 

**Resultado (Cláudio 26-11)** -> Frequência, nota 

**Contactos (Tiago 26-11)** -> ArrayList de Telefone, email

**Telefone (Tiago 26-11)** -> Número, tipo

**Frequência (Cláudio 26-11)** -> ID, Disciplina, Data da Frequência, Professor que a fez, Nº de Perguntas, Perguntas(ArrayList de Perguntas), Nível de dificuldade

**Perguntas (Cláudio 26-11)** -> Número, Cotação, Texto

***
# OBJETICOS NA MAIN

**Escola Profissional de Informática: (João 10-12)** 
1. :exclamation:Criar Diretor (Removendo o antigo automaticamente); ((A implementar na classe Escola) ✔️
2. :exclamation:Modificar dados sobre o diretor (A implementar na classe Escola); ✔️
3. :exclamation:Listar Pessoas ✔️ Melhorar outputs :warning:
4. :exclamation:Mudar informações acerca da escola (Nome, Número, Contactos, Localização) ✔️
5. :exclamation:Mostrar informações da escola ✔️ Melhorar outputs :warning:

**Cursos: (Gui 10-12)**
1. :exclamation:Listar cursos (A implementar na classe Escola) ✔️
2. :exclamation:Criar curso (A implementar na classe Escola) --> Inserindo logo as disciplinas  ✔️ Verificar se dá p adicionar disciplinas corretamente ✔️
3. :exclamation:Consultar informações de determinado curso (A implementar na classe Escola)✔️
4. :exclamation:Modificar dados sobre um curso (A implementar na classe Escola) ✔️
5. :exclamation:Remover curso (A implementar na classe Escola) ✔️
6. Mostrar curso mais frequentado (A implementar na classe Escola) ✔️
7. Inserir disciplina de determinado curso (A implementar na classe Escola) ✔️
8. Remover disciplina de determinado curso (A implementar na classe Escola) ✔️

**Disciplinas: (Cláudio 10-12)**
1. :exclamation:Listar disciplinas (A implementar na classe Escola) ✔️ Melhorar outputs :warning:
2. :exclamation:Criar disciplina (A implementar na classe Escola) ✔️ Melhorar outputs :warning:
3. :exclamation:Consultar informações de determinada disciplina (A implementar na classe Escola) ✔️ Melhorar outputs :warning:
4. :exclamation:Modificar dados sobre uma disciplina (A implementar na classe Escola) ✔️ Melhorar outputs :warning:
5. :exclamation:Remover disciplina (A implementar na classe Escola) ✔️ Melhorar outputs :warning:
6. Mostrar qual a disciplina com a frequência mais longa (A implementar na classe Escola) ✔️
7. Mostrar professores que lecionam determinada disciplina (A implementar na classe Escola) :warning: Testar
8. Mostrar alunos inscritos em determinada disciplina (A implementar na classe Escola) :warning: Testar

**Frequências: (Tiago 10-12)**
1. :exclamation:Listar Frequências de determinada disciplina (A implementar na classe Frequência) ✔️
2. :exclamation:Criar Frequência (A implementar na classe Frequência) ✔️
3. :exclamation:Mostrar determinada frequência, dado o ID da mesma (A implementar na classe Frequência) ✔️
4. :exclamation:Modificar dados sobre uma Frequência (A implementar na classe Frequência) ✔️ Testar todas as funcionalidades e melhorar outputs :warning:
5. :exclamation:Remover Frequência (A implementar na classe Frequência) ✔️
6. Mostrar a pergunta com maior cotação, de determinada frequência (A implementar na classe Frequência) ✔️
7. Mostrar frequências por nível de dificuldade (A implementar na classe Frequência) ✔️
8. Mostrar frequências elaboradas por determinado professor (A implementar na classe Frequência) ✔️ Melhorar outputs :warning:
9. Mostrar frequências de determinado curso (A implementar na classe Frequência) ✔️

**Professores: (João 10-12)**
1. :exclamation:Listar professores (A implementar na classe Professor) ✔️
2. :exclamation:Criar professor (A implementar na classe Professor) ✔️
3. :exclamation:Consultar informações de determinado professor (A implementar na classe Professor) ✔️
4. :exclamation:Modificar dados sobre um determinado professor (A implementar na classe Professor) ✔️
5. :exclamation:Remover professor (A implementar na classe Professor) ✔️
6. Mostrar professor que lecionou mais disciplinas (A implementar na classe Professor)✔️
7. Mostrar professores deslocados (A implementar na classe Professor) ✔️
8. Mostrar qual é o professore com melhor rating (A implementar na classe Professor) ✔️
9. Mostrar professor mais velho e mais novo (A implementar na classe Professor, depois de elaborar função q calcule a idade) ✔️

**Alunos: (Gui 10-12)**
1. :exclamation:Listar alunos (A implementar na classe Aluno) ✔️ (Verificar outputs)
2. :exclamation:Criar aluno (A implementar na classe Aluno) ✔️
3. :exclamation:Consultar informações de determinado aluno (A implementar na classe Aluno) ✔️ (Verificar outputs)
4. :exclamation:Modificar dados sobre um determinado aluno (A implementar na classe Aluno) ✔️
5. :exclamation:Remover aluno (A implementar na classe Aluno) ✔️
6. Atribuir notas(A implementar na classe Aluno) ✔️
7. Inscrever aluno em curso --> Inscrevendo-o automaticamente nas disciplinas do curso ✔️ (Talvez barrar inscrição caso o aluno não tenha uma média superior à média do curso) ✔️
8. Mostrar alunos deslocados (A implementar na classe Aluno) ✔️
9. Mostrar aluno mais velho e mais novo (A implementar da Classe Aluno, depois de elaborar função q calcule a idade) ✔️
10. Mostrar aluno com melhor nota numa determinada frequência (A implementar na classe Aluno) ✔️

**A implementar:**
- Não permitir que se insiram números de telefone com mais de 9 dígitos (João) ✔️
- Não permitir que se insiram email sem @ e sem . (João) ✔️
- Definir um limite no rating do professor (João) :warning:
- Variáveis estáticas para atribuir ID a Curso, Disciplina (Gui) :warning:
- Para consultar e modificar, pedir ID em vez do nome, pois podem haver pessoas com o mesmo nome etc (Gui) :warning:
- Correr o código à procura de erros ortográficos e de outputs que podem ser melhorados (TODOS) :warning:
- Verificar onde falta listar disciplinas ect antes de se pedir o ID de alguma (TODOS)
- Adicionar comentários (só o essencial) (TODOS) :warning:
- ADICIONAR DADOS (CORRETOS) NO PROGRAMA, DEPOIS DE TERMINARMOS TUDO (Gui) :warning:
- Mudar as funções que estão na main para outra classe (Gui) ✔️

***
# Relatório  

**Capa** (Cláudio)
- Nome da Disciplina, Professora, Universidade, Ano, Nossos nomes e números

**Introdução** (Tiago)
- Descrever suscintamente em que consiste o trabalho e quem o elaborou

**Desenvolvimento**
- Falar da forma como podemos interagir com o programa (menus, menus dentro de menus etc) (Gui)
- Falar das classes que temos e da forma como elas se interligam (Gui)
- Descrever as funções que temos no readme mais a fundo, por exemplo, dizer que quando um aluno é inscrito num curso, é automaticamente inscrito nas disciplinas desse curso (Já que o objetivo do relatório é ajudar a professora a perceber como é que o trabalho funciona) As funções atribuídas aqui, devem ser esclarecidas por quem de direito. Cada um pode elaborar um parágrafo a explicar separadamente.

**Aspetos a melhorar** (Joao)
- Falar de que podíamos ter posto mais exceções para ajudar nas verificações e do pq de n o termos feito

**Conclusão** (Joao)
- Concluir resumindo os aspetos positivos e negativos do trabalho, e o que este nos proporcionou

