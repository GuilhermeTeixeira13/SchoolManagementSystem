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

## **Aspetos a melhorar** (Joao)


## **Conclusão** (Joao)

