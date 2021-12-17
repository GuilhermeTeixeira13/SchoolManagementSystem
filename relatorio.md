***
# Relatório  

## **Capa** (Cláudio)


## **Introdução** (Tiago)


## **Desenvolvimento**
### Interação Utilizador - Programa
O programa foi desenvolvido com o objetivo de proporcionar ao utilizador a acessibilidade e simplicidade necessária durante a execução do mesmo. É comporto por um menu principal, em que é possível escolher-se a qual dos seis grandes temas (Escola, Cursos, Disciplinas, Professores, Alunos e Frequências) se pretende aceder aceder. Depois, dentro desses temas foram inseridos (conforme necessário) mais menus/subtemas, de forma a facilitar o utilizador no momento de escolha. As opções são escolhidas por números, não sendo possível escolher uma opção inexistente. Caso se pretenda voltar atrás, a tecla a ser primida é o '0'.
***
### Classes Escolhidas
**Escola Profissional de Informática (Elaborado por: Guilherme Teixeira)** -> Nome da Escola(String), Número da Escola(int), Cursos(ArrayList de Curso), Localização(String), Diretor da Escola(Diretor), Contactos da Escola(Contactos), Pessoas(ArrayList de Pessoa, podendo estas ser Alunos, Professores, Diretor), Disciplinas(ArrayList de Disciplinas)  
  
**Curso (Elaborado por: Guilherme Teixeira)** -> Código de Curso(static int), Composto por várias disciplinas(ArrayList de Disciplina), Provas de Ingresso(ArrayList de String), Nome(String), Duração em horas(int), Média do Último Colocado(float), Data de início(LocalDate), Data de fim(LocalDate), Alunos inscritos no curso(ArrayList de Aluno).
  
**Disciplina (Elaborado por: João Baltazar)** -> Número da disciplina(static int), Nome(string), Alunos Inscritos(ArrayList de Aluno), Professores que lecionam a disciplina(ArrayList de Professores), Frequências(ArrayList de Frequências)
  
**ProvasDeIngresso (Elaborado por: João Baltazar)** -> Provas de Ingresso(ArrayList de Strings)
  
**Pessoa (Elaborado por: Guilherme Teixeira)** ->  Nome(String), Contactos(Contactos), Local de Origem(String), Email(String), Data de nascimento(LocalDate)

**Aluno EXTENDS Pessoa (Elaborado por: Guilherme Teixeira)** -> Número de aluno(static int), NotasDisciplinas(ArrayList de NotasDisciplina), Média de Entrada(float), Disciplinas a que está inscrito (ArrayList de Disciplinas), Curso em que está (Curso)

**Professor EXTENDS Pessoa (Elaborado por: João Baltazar)** -> Número de Professor(static int), Rating(int), Disciplinas que Leciona(ArrayList de Disciplinas)

**Diretor EXTENDS Pessoa (Elaborado por: Guilherme Teixeira)** -> Anos de serviço(int), Formação Académica(String)

**NotasDisciplina (Elaborado por: Tiago Ribeiro)** -> Disciplina(string), Notas(ArrayList de Resultado) 

**Resultado (Elaborado por: Cláudio Redondo)** -> IDFrequência(int), Cotação(float) 

**Contactos (Elaborado por: Tiago Ribeiro)** -> Telefones(ArrayList de Telefone), Email(String)

**Telefone (Elaborado por: Tiago Ribeiro)** -> Número(long), Tipo(String)

**Frequência (Elaborado por: Cláudio Redondo)** -> ID(Static int), Disciplina(Disciplina), Data da Frequência(LocalDate), Professor que a fez(Professor), Nº de Perguntas(int), Perguntas(ArrayList de Perguntas), Nível de dificuldade(String)

**Perguntas (Elaborado por: Cláudio Redondo)** -> Cotação(float), Texto(String)
***
### Funcões

**GERIR ESCOLA: (Elaborado por: João Baltazar)** 
1. :exclamation:Criar Diretor - Função que, depois de pedir os dados que formam o diretor (Pessoa+Diretor), cria um novo, removendo automaticamente o que se encontrava no seu lugar, ou seja, não necessitamos de estar a remover um diretor para depois podermos criar outro. Esse processo é-nos facilitado já que só existe um diretor na escola.
2. :exclamation:Modificar dados sobre o diretor
3. :exclamation:Listar Pessoas 
4. :exclamation:Mudar informações acerca da escola 
5. :exclamation:Mostrar informações da escola

**Cursos: (Gui 10-12)**
1. :exclamation:Listar cursos 
2. :exclamation:Criar curso 
3. :exclamation:Consultar informações de determinado curso 
4. :exclamation:Modificar dados sobre um curso 
5. :exclamation:Remover curso 
6. Mostrar curso mais frequentado 
7. Inserir disciplina de determinado curso 
8. Remover disciplina de determinado curso 

**Disciplinas: (Cláudio 10-12)**
1. :exclamation:Listar disciplinas
2. :exclamation:Criar disciplina 
3. :exclamation:Consultar informações de determinada disciplina 
4. :exclamation:Modificar dados sobre uma disciplina 
5. :exclamation:Remover disciplina (A implementar na classe Escola) 
6. Mostrar qual a disciplina com a frequência mais longa 
7. Mostrar professores que lecionam determinada disciplina
8. Mostrar alunos inscritos em determinada disciplina 

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

## **Aspetos a melhorar** (Joao)


## **Conclusão** (Joao)

