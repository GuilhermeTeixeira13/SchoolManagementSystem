***
# Relatório  

## **Capa** (Cláudio)


## **Introdução** (Tiago)
### ORGANIZAÇÃO E PLANO DE ESTRUTURAÇÃO DO TRABALHO
Desenvolvido por João Martins, Guilherme Teixeira, Cláudio Redondo e Tiago Ribeiro, este trabalho visa a elaboração de uma aplicação de uma escola profissional de informática, dando para criar e gerir várias funções da mesma.
Para que o programa fosse desenvolvido no tempo estabelecido, foi criado um repositório no github para facilitar e agilizar o processo e mantendo sempre o trabalho organizado e atualizado para todos os elementos. Em seguida foram atribuídas tarefas a todos os elementos dos grupos e após todos concordarem com as mesmas foram estabelecidos prazos para cada uma.

## **Desenvolvimento**
### Interação Utilizador - Programa (Gui)
O programa foi desenvolvido com o objetivo de proporcionar ao utilizador a acessibilidade e simplicidade necessária durante a execução do mesmo. É comporto por um menu principal, em que é possível escolher-se a qual dos seis grandes temas (Escola, Cursos, Disciplinas, Professores, Alunos e Frequências) se pretende aceder aceder. Depois, dentro desses temas foram inseridos (conforme necessário) mais menus/subtemas, de forma a facilitar o utilizador no momento de escolha. As opções são escolhidas por números, não sendo possível escolher uma opção inexistente. Caso se pretenda voltar atrás, a tecla a ser primida é o '0'.
***
### Estrutura/Corpo do Programa (Gui)
No ficheiro Programa.java está localizada classe main que possibilita a execução do programa. Usando switches e do whiles foi feita a interação entre os diversos menus e o utilizador, interação essa abordada no seguinte passo.
***
### Classes Escolhidas (Gui)
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
### Funcões (Cada um completa as que fez)

**GERIR ESCOLA: (Elaborado por: João Baltazar)** 
1. :exclamation:Criar Diretor - Funcionalidade que, depois de pedir os dados que formam o diretor (Pessoa+Diretor), cria um novo, removendo automaticamente o que se encontrava no seu lugar, ou seja, não necessitamos de estar a remover um diretor para depois podermos criar outro. Esse processo é-nos facilitado já que só existe um diretor na escola.
2. :exclamation:Modificar dados sobre o diretor - Nesta função, é apresentado um submenu que permite ao utlizador escolher que informações pretende mudar sobre o diretor. Não é dado nada como parâmetro visto que, só existe um diretor na escola.
3. :exclamation:Listar Pessoas - Mostra as informações pessoais do diretor, dos professores e dos alunos que pertencem à escola. Caso se pretenda saber informações mais específicas, devemos aceder a "Consultar Informações de um Aluno/Professor"
4. :exclamation:Mudar informações acerca da escola - É mostrado ao utilizador um submenu, que permite mudar as informações relevantes da escola.
5. :exclamation: É mostrado ao utilizador, as informações pertencentes à escola, cursos, disciplinas, e nome de todas as pessoas associadas a esta entidade.

**GERIR CURSOS: (Elaborado por: Guilherme Teixeira)**  
Os IDS são sempre diferentes (variáveis estáticas) e não é possível criar cursos com o mesmo nome. Ao remover são dadas 3 opções em que duas delas é possível remover um curso pelo nome (para usarmos o conteúdo das aulas práticas e porque o programa permite que o façamos)

1. :exclamation:Listar cursos - Mostra-nos, de uma forma limpa, o nome e ID dos cursos existentes na escola. Caso se pretenda mais informações e detalhes, consultar a funcionalidade "Consultar informações de determinado curso".
2. :exclamation:Criar curso - Cria um curso a partir dos dados pedidos utilizador. As disciplinas que fazem parte do curso são inseridas na opção 7 (para não ficar confuso). Não é pedido o código do curso pois este é atribuido de forma automática.
3. :exclamation:Consultar informações de determinado curso - Dado o ID de um determinado curso, são mostradas as informações relevantes acerca do mesmo.
4. :exclamation:Modificar dados sobre um curso - Dado o ID de um determinado curso, é possível escolher que aspeto do curso se pretende modificar.
5. :exclamation:Remover curso - Nesta opção é possível escolher se se pretende remover o curso pelo nome ou por palavra contida no nome.
6. Mostrar curso mais frequentado - Mostra qual ou quais os cursos mais frequentados, e mostra também a respetiva quantidade de alunos nele presente.
7. Inserir disciplina de determinado curso - De entre as disciplinas disponíveis na escola, são pedidas (até o utilizador mandar parar) aquelas que se pretende adicionar ao curso escolhido pelo utilizador (pelo ID de curso). 
8. Remover disciplina de determinado curso - De entre as disciplinas disponíveis na escola, são pedidas (até o utilizador mandar parar) aquelas que se pretende remover do curso escolhido pelo utilizador (pelo ID de curso). 

**GERIR DISCIPLINAS: (Elaborado por: Cláudio Redondo)**
1. :exclamation:Listar disciplinas - Mostra-nos, de uma forma limpa, o nome e ID das disciplinas existentes na escola. Caso se pretenda mais informações e detalhes, consultar a funcionalidade "Consultar informações de determinada disciplina".
2. :exclamation:Criar disciplina - 
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
2. :exclamation:Criar professor - Nesta função, é possibilitado ao utilizador criar um professor, inserindo os seus dados pessoais. É possivel também, atribuir-lhe uma função no rating. Por último, é fornecido um menu que permite ao utilizador escolher (atráves do número que cada uma, tem lhe associada no menu) as disciplinas existentes na escola, que deseja associar ao professor.
3. :exclamation:Consultar informações de determinado professor - O utilizador deve passar o nome do professor que deseja consultar. Na consulta, é listado o professor.
4. :exclamation:Modificar dados sobre um determinado professor - Nesta função, o utilizador insere o nome do professor que deseja modificar e de seguida, é lhe apresentado um menu que permite modificar, separadamente, todas as caraterísticas deste. 
5. :exclamation:Remover professor - Ao escolher esta opcão, o utilizador irá escrever o nome do professor que deseja remover. Depois disso, o programa irá conhecer a posição em que este se encontrana lista de pessoas da escola e consequentemente, eliminá-lo.
6. Mostrar professor que lecionou mais disciplinas - É analisado qual o professor que lecionou mais disciplinas. Caso, haja empate, é lhe mostrado o nome dos sujeitos em questão. Caso contrário, é lhe mostrado somente, o nome do sujeito em questão.
7. Mostrar professores deslocados - É fornecido ao utilizador todos os professores, nome e local, que têm como local de origem um local diferente de onde está estabelecida a escola.
8. Mostrar qual é o professore com melhor rating - É analisado qual o professor com melhor rating. Caso, haja empate, é lhe mostrado o nome dos sujeitos em questão. Caso contrário, é lhe mostrado somente, o nome do sujeito em questão.
9. Mostrar professor mais velho e mais novo - É analisado qual o professor mais velho e mais novo. Caso, haja empate, é lhe mostrado o nome dos sujeitos em questão. Caso contrário, é lhe mostrado somente, o nome do sujeito em questão.

**GERIR ALUNOS: (Elaborado por: Guilherme Teixeira)**
1. :exclamation:Listar alunos - Mostra-nos, de uma forma limpa, o nome e o número dos alunos existentes na escola. Caso se pretenda mais informações e detalhes, consultar a funcionalidade "Consultar informações de determinado aluno". 
2. :exclamation:Criar aluno - Pede ao utilizador os dados do aluno que este pretende inserir. A parte de inscrição do aluno num curso é feita no ponto 7 (para não ficar confuso). Adiciona o aluno à lista de pessoa da escola.
3. :exclamation:Consultar informações de determinado aluno  - É pedido ao utilizador o ID do aluno que se pretende consultar. De seguida são mostradas as informoções referentes ao aluno em questão.
4. :exclamation:Modificar dados sobre um determinado aluno - É pedido ao utilizador o ID do aluno cujos dados se pretende modificar. De seguida é mostrado um menu com as várias opções referentes ao aluno, possíveis de modificar.
5. :exclamation:Remover aluno - É pedido ao utilizador o ID do aluno que se pretende remover. De seguida, o aluno é removido , não aparecendo na lista de alunos dos cursos nem das disciplinas.
6. Atribuir notas - É pedido ao utilizador o ID do aluno a que se pretende atribuir notas, o ID da Disciplina da Frequência que esse aluno realizou e o ID dessa mesma frequência. Após isto é pedido a classificação que o aluno obteve e é guardada nos dados do aluno. Cada aluno contem uma ArrayList< NotasDisciplina> em que cada posição contém uma disciplina e os resultados das frequências que esse aluno realizou , exemplo -> NotasDisciplinaDoAluno1(Álgebra-(IDFreq:1 Classi:17; IDFreq:2, Classi:18 ,...) ; POO-(IDFreq:5 Classi:20; IDFreq:3, Classi:16, ...) ; ...)
7. Inscrever aluno em curso - Após ser dado o ID do aluno que se pretende inscrever, é apresentada a lista de cursos da escola e dos seus IDS. O utilizador escolhe o curso em que pretende inscrever o aluno. Caso este já se encontre inscrito em algum curso, é mostrado um aviso e pergunta-se ao utilizador se pretende alterar o curso do aluno.
8. Mostrar alunos deslocados -  Mostra uma lista de alunos cuja localização difere daquela que é a localização da escola.
9. Mostrar aluno mais velho e mais novo - A partir de uma função que calcula a idade, é mostrado qual ou quais (Caso tenham a mesma idade) são os utilizador(os) mais novos e mais velhos.
10. Mostrar aluno com melhor nota numa determinada frequência - É pedido qual o ID da disciplina e da Frequência em questão e após isto, analisa-se quais foram os alunos que realizaram essa frequência. Desse lista de alunos calcula-se qual foi o que obteve a melhor nota nessa frequência.

### Conteúdos lecionados que foram usados no trabalho

## **Aspetos a melhorar** (João)

## **Conclusão** (João)

