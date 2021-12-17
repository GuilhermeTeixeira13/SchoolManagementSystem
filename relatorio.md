***
# Relatório  

## **Capa** (Cláudio)


## **Introdução** (Tiago)


## **Desenvolvimento**
### Interação Utilizador - Programa
O programa foi desenvolvido com o objetivo de proporcionar ao utilizador a acessibilidade e simplicidade necessária durante a execução do mesmo. É comporto por um menu principal, em que é possível escolher-se a qual dos seis grandes temas (Escola, Cursos, Disciplinas, Professores, Alunos e Frequências) se pretende aceder aceder. Depois, dentro desses temas foram inseridos (conforme necessário) mais menus/subtemas, de forma a facilitar o utilizador no momento de escolha. As opções são escolhidas por números, não sendo possível escolher uma opção inexistente. Caso se pretenda voltar atrás, a tecla a ser primida é o '0'.

### Classes Escolhidas + Ligações
**Escola Profissional de Informática (Elaborado por: Guilherme Teixeira)** -> Nome da Escola(String), Número da Escola(int), Cursos(ArrayList de Curso), Localização(String), Diretor da Escola(Diretor), Contactos da Escola(Contactos), Pessoas(ArrayList de Pessoa, podendo estas ser Alunos, Professores, Diretor), Disciplinas(ArrayList de Disciplinas)  
  
**Curso (Elaborado por: Guilherme Teixeira)** -> Código de Curso(static int), Composto por várias disciplinas(ArrayList de Disciplina), Provas de Ingresso(ArrayList de String), Nome(String), Duração em horas(int), Média do Último Colocado(float), Data de início(Date), Data de fim(Date), Alunos inscritos no curso(ArrayList de Aluno).
  
**Disciplina (Elaborado por: João Baltazar)** -> Número da disciplina(static int), Nome(string), Alunos Inscritos(ArrayList de Aluno), Professores que lecionam a disciplina(ArrayList de Professores), Frequências(ArrayList de Frequências)
  
**ProvasDeIngresso (João)** -> Provas de Ingresso(ArrayList de Strings)
  
**Pessoa (Gui 26-11)** ->  Nome, Contactos, Local de Origem, email, data de nascimento(para a partir daí calcular a idade)

**Aluno EXTENDS Pessoa (Gui 26-11)** -> Número de aluno, NotasDisciplinas(ArrayList de NotasDisciplina), Média de Entrada, Disciplinas a que está inscrito (ArrayList de Disciplinas), Curso em que está

**Professor EXTENDS Pessoa (João 26-11)** -> Número de Professor, Rating, Disciplinas que Leciona(ArrayList de Disciplinas)

**Diretor EXTENDS Pessoa (Gui 26-11)** -> Anos de serviço, Formação Académica

**NotasDisciplina (Tiago 26-11)** -> disciplina, notas(ArrayList de Resultados) 

**Resultado (Cláudio 26-11)** -> Frequência, nota 

**Contactos (Tiago 26-11)** -> ArrayList de Telefone, email

**Telefone (Tiago 26-11)** -> Número, tipo

**Frequência (Cláudio 26-11)** -> ID, Disciplina, Data da Frequência, Professor que a fez, Nº de Perguntas, Perguntas(ArrayList de Perguntas), Nível de dificuldade

**Perguntas (Cláudio 26-11)** -> Número, Cotação, Texto

## **Aspetos a melhorar** (Joao)


## **Conclusão** (Joao)

