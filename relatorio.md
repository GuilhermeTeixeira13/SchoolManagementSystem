***
# Relatório  

## **Capa** (Cláudio)


## **Introdução** (Tiago)
### ORGANIZAÇÃO E PLANO DE ESTRUTURAÇÃO DO TRABALHO

## **Desenvolvimento**
### Interação Utilizador - Programa
O programa foi desenvolvido com o objetivo de proporcionar ao utilizador a acessibilidade e simplicidade necessária durante a execução do mesmo. É comporto por um menu principal, em que é possível escolher-se a qual dos seis grandes temas (Escola, Cursos, Disciplinas, Professores, Alunos e Frequências) se pretende aceder aceder. Depois, dentro desses temas foram inseridos (conforme necessário) mais menus/subtemas, de forma a facilitar o utilizador no momento de escolha. As opções são escolhidas por números, não sendo possível escolher uma opção inexistente. Caso se pretenda voltar atrás, a tecla a ser primida é o '0'.
***
### Estrutura/Corpo do Programa
No ficheiro Programa.java está localizada classe main que possibilita a execução do programa. Usando switches e do whiles foi feita a interação entre os diversos menus e o utilizador, interação essa abordada no seguinte passo.
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
1. :exclamation:Criar Diretor - Funcionalidade que, depois de pedir os dados que formam o diretor (Pessoa+Diretor), cria um novo, removendo automaticamente o que se encontrava no seu lugar, ou seja, não necessitamos de estar a remover um diretor para depois podermos criar outro. Esse processo é-nos facilitado já que só existe um diretor na escola.
2. :exclamation:Modificar dados sobre o diretor
3. :exclamation:Listar Pessoas 
4. :exclamation:Mudar informações acerca da escola 
5. :exclamation:Mostrar informações da escola

**GERIR CURSOS: (Elaborado por: Guilherme Teixeira)**
1. :exclamation:Listar cursos - Mostra-nos, de uma forma limpa, o nome e ID dos cursos existentes na escola. Caso se pretenda mais informações e detalhes, consultar a funcionalidade "Consultar informações de determinado curso".
2. :exclamation:Criar curso 
3. :exclamation:Consultar informações de determinado curso 
4. :exclamation:Modificar dados sobre um curso 
5. :exclamation:Remover curso 
6. Mostrar curso mais frequentado 
7. Inserir disciplina de determinado curso 
8. Remover disciplina de determinado curso 

**GERIR DISCIPLINAS: (Elaborado por: Cláudio Redondo)**
1. :exclamation:Listar disciplinas - Mostra-nos, de uma forma limpa, o nome e ID das disciplinas existentes na escola. Caso se pretenda mais informações e detalhes, consultar a funcionalidade "Consultar informações de determinada disciplina".
2. :exclamation:Criar disciplina 
3. :exclamation:Consultar informações de determinada disciplina 
4. :exclamation:Modificar dados sobre uma disciplina 
5. :exclamation:Remover disciplina (A implementar na classe Escola) 
6. Mostrar qual a disciplina com a frequência mais longa 
7. Mostrar professores que lecionam determinada disciplina
8. Mostrar alunos inscritos em determinada disciplina 

**GERIR FREQUÊNCIAS: (Elaborado por: Tiago Ribeiro)**
1. :exclamation:Listar Frequências de determinada disciplina - Mostra-nos, de uma forma limpa, o ID das Frequências de uma Disciplina escolhida pelo utilizador. Caso se pretenda mais informações e detalhes, consultar a funcionalidade "Consultar uma determinada Frequência".
2. :exclamation:Criar Frequência 
3. :exclamation:Mostrar determinada frequência, dado o ID da mesma 
4. :exclamation:Modificar dados sobre uma Frequência 
5. :exclamation:Remover Frequência 
6. Mostrar a pergunta com maior cotação, de determinada frequência 
7. Mostrar frequências por nível de dificuldade 
8. Mostrar frequências elaboradas por determinado professor
9. Mostrar frequências de determinado curso 

**GERIR PROFESSORES: (Elaborado por: João Baltazar)**
1. :exclamation:Listar professores - Mostra-nos, de uma forma limpa, o nome e o número dos professores existentes na escola. Caso se pretenda mais informações e detalhes, consultar a funcionalidade "Consultar informações de determinado professor".
2. :exclamation:Criar professor 
3. :exclamation:Consultar informações de determinado professor 
4. :exclamation:Modificar dados sobre um determinado professor 
5. :exclamation:Remover professor 
6. Mostrar professor que lecionou mais disciplinas 
7. Mostrar professores deslocados 
8. Mostrar qual é o professore com melhor rating 
9. Mostrar professor mais velho e mais novo

**GERIR ALUNOS: (Elaborado por: Guilherme Teixeira)**
1. :exclamation:Listar alunos - Mostra-nos, de uma forma limpa, o nome e o número dos alunos existentes na escola. Caso se pretenda mais informações e detalhes, consultar a funcionalidade "Consultar informações de determinado aluno". 
2. :exclamation:Criar aluno 
3. :exclamation:Consultar informações de determinado aluno 
4. :exclamation:Modificar dados sobre um determinado aluno 
5. :exclamation:Remover aluno 
6. Atribuir notas
7. Inscrever aluno em curso
8. Mostrar alunos deslocados (
9. Mostrar aluno mais velho e mais novo 
10. Mostrar aluno com melhor nota numa determinada frequência 

### Conteúdos lecionados que foram usados no trabalho

## **Aspetos a melhorar** (Joao)

## **Conclusão** (Joao)

