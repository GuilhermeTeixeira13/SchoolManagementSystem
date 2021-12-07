# CLASSES

**Escola Profissional de Informática (Gui 26-11)** -> Nome da Escola, Número da Escola, Composto por vários cursos(ArrayList de Cursos), Localização, Diretor da Escola, Contactos da Escola, Composto por várias pessoas(ArrayList de pessoas), Composto por várias disciplinas(ArrayList de Disciplinas)

**Curso (Gui 26-11)** -> Código de Curso; Composto por várias disciplinas(ArrayList de Disciplinas),Provas de Ingresso, Nome, Duração em horas, Média do Último Colocado, data de início, data de fim, alunos(ArrayList de Alunos).

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
3. :exclamation:Listar Pessoas ✔️ Melhorar inputs :warning:
4. :exclamation:Mudar informações acerca da escola (Nome, Número, Contactos, Localização) ✔️
5. :exclamation:Mostrar informações da escola ✔️ Melhorar inputs :warning:

**Cursos: (Gui 10-12)**
1. :exclamation:Listar cursos (A implementar na classe Escola) ✔️
2. :exclamation:Criar curso (A implementar na classe Escola) --> Inserindo logo as disciplinas  ✔️ Verificar se dá p adicionar disciplinas corretamente :warning:
3. :exclamation:Consultar informações de determinado curso (A implementar na classe Escola)✔️
4. :exclamation:Modificar dados sobre um curso (A implementar na classe Escola) ✔️
5. :exclamation:Remover curso (A implementar na classe Escola) ✔️
6. Mostrar curso mais frequentado (A implementar na classe Escola) ✔️
7. Inserir e Remover disciplinas de determinado curso (A implementar na classe Escola)

**Disciplinas: (Cláudio 10-12)**
1. :exclamation:Listar disciplinas (A implementar na classe Escola)
2. :exclamation:Criar disciplina (A implementar na classe Escola)
3. :exclamation:Consultar informações de determinada disciplina (A implementar na classe Escola)
4. :exclamation:Modificar dados sobre uma disciplina (A implementar na classe Escola)
5. :exclamation:Remover disciplina (A implementar na classe Escola)
6. Mostrar qual a disciplina com a frequência mais longa (A implementar na classe Escola)
7. Mostrar professores que lecionam determinada disciplina (A implementar na classe Escola)
8. Mostrar alunos inscritos em determinada disciplina (A implementar na classe Escola)

**Frequências: (Tiago 10-12)**
1. :exclamation:Listar Frequências de determinada disciplina (A implementar na classe Frequência)
2. :exclamation:Criar Frequência (A implementar na classe Frequência)
3. :exclamation:Mostrar determinada frequência, dado o ID da mesma (A implementar na classe Frequência)
4. :exclamation:Modificar dados sobre uma Frequência (A implementar na classe Frequência)
5. :exclamation:Remover Frequência (A implementar na classe Frequência)
6. Mostrar a pergunta com maior cotação, de determinada frequência (A implementar na classe Frequência)
7. Mostrar frequências por nível de dificuldade (A implementar na classe Frequência)
8. Mostrar frequências elaboradas por determinado professor (A implementar na classe Frequência)
9. Mostrar frequências de determinado curso (A implementar na classe Frequência)
9. Mostrar frequências de determinada disciplina (A implementar na classe Frequência)

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
6. Atribuir notas(A implementar na classe Aluno)
7. Inscrever aluno em curso --> Inscrevendo-o automaticamente nas disciplinas do curso ✔️ (Talvez barrar inscrição caso o aluno não tenha uma média superior à média do curso) :warning:
8. Mostrar alunos deslocados (A implementar na classe Aluno) ✔️
9. Mostrar aluno mais velho e mais novo (A implementar da Classe Aluno, depois de elaborar função q calcule a idade) ✔️
10. Mostrar aluno com melhor e pior média, de determinado curso (A implementar na classe Aluno, depois de fazer função que calcule a média nas NotasDisciplina)
11. Mostrar aluno com melhor nota numa determinada frequência (A implementar na classe Aluno)

**A implementar:**
- Variáveis estáticas para número do professor e número das perguntas (Falta para número das perguntas)
