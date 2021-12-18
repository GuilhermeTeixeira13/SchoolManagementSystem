import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        int opcaoUtilizador;
        funcoesUteis.limpaTela();
        System.out.print(
                "ESCOLA PROFISSIONAL DE INFORMÁTICA\n\n1. Gerir Escola\n2. Gerir Cursos\n3. Gerir Disciplinas\n4. Gerir Professores\n5. Gerir Alunos\n6. Gerir Frequências\n\n0. Sair\n\nESCOLHA A SUA OPÇÃO -> ");

        EscolaInformatica escolaInformatica = funcoesUteis.LeEscolaNoFicheiro("escolaInformática.txt");

        opcaoUtilizador = Ler.umInt();
        while (opcaoUtilizador > 6 || opcaoUtilizador < 0) {
            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
            opcaoUtilizador = Ler.umInt();
        }
        while (opcaoUtilizador > 0 && opcaoUtilizador <= 6) {
            switch (opcaoUtilizador) {
                case 1:
                    do {
                        funcoesUteis.limpaTela();
                        System.out.print(
                                "GERIR ESCOLA\n\n1. Criar Diretor (Removendo automaticamento o anterior)\n2. Modificar dados acerca do atual diretor\n3. Listar Pessoas\n4. Mudar informações acerca da escola (Nome, Número, Contactos, Localização, Email)\n5. Informações da escola\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 5 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        funcoesUteis.limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Criar novo diretor (Removendo automaticamento o anterior)
                                Diretor diretorCriado = funcoesUteis.criarDiretor();
                                // Diretor antigo removido da lista de pessoas da escola.
                                funcoesUteis.removeDiretorDaListaDePessoas(escolaInformatica.getPessoasEscola());
                                // Diretor criado adicionado à lista de pessoas da escola
                                escolaInformatica.getPessoasEscola().add(diretorCriado);
                                // Definir diretor criado como diretor da escola
                                escolaInformatica.setDiretorEscola(diretorCriado);
                                funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println();
                                funcoesUteis.pedeTecla();
                                break;
                            case 2:
                                // Modificar dados acerca do atual diretor

                                funcoesUteis.removeDiretorDaListaDePessoas(escolaInformatica.getPessoasEscola());
                                Diretor dirModificado = funcoesUteis.modDiretor(escolaInformatica);
                                escolaInformatica.getPessoasEscola()
                                        .add(dirModificado);
                                escolaInformatica
                                        .setDiretorEscola(dirModificado);

                                funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println();
                                break;
                            case 3:
                                // Listar Pessoas

                                funcoesUteis.listarPessoasEscola(escolaInformatica.getPessoasEscola(),
                                        escolaInformatica);
                                break;
                            case 4:
                                // Mudar informações acerca da escola

                                escolaInformatica = funcoesUteis.modificarEscola(escolaInformatica);
                                funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                break;
                            case 5:
                                // Listar informações sobre a escola

                                System.out.print(escolaInformatica);
                                funcoesUteis.pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 5);
                    break;
                case 2:
                    do {
                        funcoesUteis.limpaTela();
                        System.out.print(
                                " GERIR CURSOS\n\n1. Listar cursos\n2. Criar curso\n3. Consultar informações de determinado curso\n4. Modificar dados sobre um curso\n5. Remover curso\n6. Mostrar curso mais frequentado\n7. Inserir disciplinas de determinado curso\n8. Remover disciplinas de determinado curso\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 8 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        funcoesUteis.limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Cursos

                                System.out.println("1. LISTAR CURSOS\n");
                                escolaInformatica.listaCursos();
                                funcoesUteis.pedeTecla();
                                break;
                            case 2:
                                // Criar curso

                                System.out.println("2. CRIAR CURSO\n");
                                escolaInformatica.addCurso(funcoesUteis.criarCurso(escolaInformatica));
                                funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println("\n-->  Curso criado com sucesso!!\n");
                                funcoesUteis.pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinado curso

                                int posCurso, idCursoConsultar;
                                System.out.print(
                                        "3. CONSULTAR INFORMAÇÕES SOBRE DETERMINADO CURSO\n\n");
                                escolaInformatica.listaCursos();
                                System.out.print("Escreva o ID do curso que pretende consultar --> ");
                                idCursoConsultar = Ler.umInt();
                                posCurso = escolaInformatica.devolvePosCursoDadoID(idCursoConsultar);
                                if (posCurso == -1)
                                    System.out.println("Lamentamos, mas este curso não existe!\n");
                                else {
                                    System.out.println(
                                            escolaInformatica.getCursosEscola().get(posCurso).toString() + "\n");
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre determinado curso

                                int posCursoMod, idCursoModificar;

                                System.out.print(
                                        "4. MODIFICAR DADOS SOBRE DETERMINADO CURSO\n\n");
                                escolaInformatica.listaCursos();
                                System.out.print("Escreva o ID do curso que pretende modificar --> ");
                                idCursoModificar = Ler.umInt();
                                posCursoMod = escolaInformatica.devolvePosCursoDadoID(idCursoModificar);
                                if (posCursoMod == -1)
                                    System.out.println("Lamentamos, mas este curso não existe!\n");
                                else {
                                    funcoesUteis.modificarCurso(escolaInformatica, 0);
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                break;
                            case 5:
                                // Remover Curso

                                String nomeCursoRemover;
                                int opcaoCursos;
                                System.out.print(
                                        "5. REMOVER CURSO\n\n  1. Remover pelo nome\n  2. Remover por palavra contida no nome\n  3. Remover por ID\n  0. Sair\n\n  ESCOLHA UMA OPCÃO --> ");
                                opcaoCursos = Ler.umInt();
                                while (opcaoCursos > 3 || opcaoCursos < 0) {
                                    System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                                    opcaoCursos = Ler.umInt();
                                }
                                funcoesUteis.limpaTela();
                                boolean sucesso = false;
                                switch (opcaoCursos) {
                                    case 1:
                                        System.out.print(
                                                "1. Remover pelo nome\n\n");
                                        escolaInformatica.listaCursos();
                                        System.out.print("Escreva o nome do curso que pretende remover --> ");
                                        nomeCursoRemover = Ler.umaString();
                                        sucesso = escolaInformatica.removeCursoEquals(nomeCursoRemover);
                                        if (sucesso == true) {
                                            funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                    escolaInformatica);
                                            System.out
                                                    .println("\nCurso " + nomeCursoRemover + " removido com sucesso.");
                                        } else
                                            System.out.println(
                                                    "\nNão existe nenhum curso com o nome " + nomeCursoRemover + ".");
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print(
                                                "2. Remover por palavra contida no nome\n\n");
                                        escolaInformatica.listaCursos();
                                        System.out.print(
                                                "Escreva uma palavra contida no curso que pretende remover --> ");
                                        nomeCursoRemover = Ler.umaString();
                                        sucesso = escolaInformatica.removeCursoContains(nomeCursoRemover);
                                        if (sucesso == true) {
                                            funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                    escolaInformatica);
                                            System.out.println("\nCursos que contêm a palavra " + nomeCursoRemover
                                                    + " removidos com sucesso.");
                                        } else
                                            System.out.println("\nNão existe nenhum curso que contenha a palavra "
                                                    + nomeCursoRemover + ".");
                                        System.out.println();
                                        break;
                                    case 3:
                                        int idCursoRemover, posCursoRem;
                                        System.out.print(
                                                "3. Remover por ID\n\n");
                                        escolaInformatica.listaCursos();
                                        System.out.print("Escreva o ID do curso que pretende remover -->  ");
                                        idCursoRemover = Ler.umInt();
                                        posCursoRem = escolaInformatica.devolvePosCursoDadoID(idCursoRemover);
                                        if (posCursoRem != -1) {
                                            funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                    escolaInformatica);
                                            System.out.println("\nCurso "
                                                    + escolaInformatica.getCursosEscola().get(posCursoRem)
                                                            .getNomeCurso()
                                                    + " (ID:" + idCursoRemover + ") removido com sucesso.");
                                        } else
                                            System.out.println("\nNão existe nenhum curso com o ID "
                                                    + idCursoRemover + ".");
                                        System.out.println();
                                        break;
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 6:
                                // Mostrar curso mais frequentado

                                System.out.println(
                                        "O curso mais frequentado da " + escolaInformatica.getNomeEscola() + " é:\n");
                                System.out.println(" . "
                                        + funcoesUteis.cursoMaisFrequentado(escolaInformatica).getNomeCurso() + " ("
                                        + funcoesUteis.cursoMaisFrequentado(escolaInformatica).getAlunosCurso().size()
                                        + " ALUNOS)\n");
                                funcoesUteis.pedeTecla();
                                break;
                            case 7:
                                // Inserir disciplinas de determinado curso

                                int posCursoAddDisc, idCursoInserirDisc;

                                System.out.print(
                                        "7. INSERIR DISCIPLINAS NUM DETERMINADO CURSO\n\n");
                                escolaInformatica.listaCursos();
                                System.out.print("Escreva o ID do curso em que pretende adicionar disciplinas -->  ");
                                idCursoInserirDisc = Ler.umInt();
                                posCursoAddDisc = escolaInformatica.devolvePosCursoDadoID(idCursoInserirDisc);
                                if (posCursoAddDisc == -1)
                                    System.out.println("Lamentamos, mas este curso não existe!\n");
                                else {
                                    int posdisc, idDisc;
                                    boolean existeNoCurso = false;
                                    System.out.println();
                                    escolaInformatica.listaDisciplinas();
                                    System.out.print(
                                            "Escreva o ID da disciplina que pretende adicionar ao curso "
                                                    + escolaInformatica.getCursosEscola().get(posCursoAddDisc)
                                                            .getNomeCurso()
                                                    + " --> ");
                                    idDisc = Ler.umInt();
                                    posdisc = escolaInformatica.devolvePosDisciplinaDadoID(idDisc);
                                    existeNoCurso = escolaInformatica.verificaSeDisciplinaPertenceCurso(posCursoAddDisc,
                                            escolaInformatica.getDisciplinaEscola().get(posdisc).getNomDisc());
                                    if (existeNoCurso == true || posdisc == -1) {
                                        if (existeNoCurso == true && posdisc != -1)
                                            System.out
                                                    .println("\nLamentamos, mas essa disciplina já existe no curso!\n");
                                        if (existeNoCurso == false && posdisc == -1)
                                            System.out.println(
                                                    "\nLamentamos, mas essa disciplina não existe na escola!\n");
                                    } else {
                                        escolaInformatica.getCursosEscola().get(posCursoAddDisc).getDisciplinasCurso()
                                                .add(escolaInformatica.getDisciplinaEscola().get(posdisc));
                                        escolaInformatica.atualizaCurso(posCursoAddDisc);
                                        System.out.println(
                                                "\nDisciplina "
                                                        + escolaInformatica.getDisciplinaEscola().get(posdisc)
                                                                .getNomDisc()
                                                        + " adicionada a " + escolaInformatica.getCursosEscola()
                                                                .get(posCursoAddDisc).getNomeCurso()
                                                        + " com sucesso!\n");
                                        funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                escolaInformatica);
                                    }
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 8:
                                // Remover disciplinas de um determinado Curso

                                int posCursoRemDisc, idCursoRemDisc;

                                System.out.print(
                                        "8. REMOVER DISCIPLINAS DE UM DETERMINADO CURSO\n\n");
                                escolaInformatica.listaCursos();
                                System.out.print("Escreva o ID do curso em que pretende remover disciplinas --> ");
                                idCursoRemDisc = Ler.umInt();
                                posCursoRemDisc = escolaInformatica.devolvePosCursoDadoID(idCursoRemDisc);
                                if (posCursoRemDisc == -1)
                                    System.out.println("Lamentamos, mas este curso não existe!\n");
                                else {
                                    int posdisc, idDiscRem;
                                    boolean existeNoCurso = false;
                                    System.out.println();
                                    escolaInformatica.listaDisciplinas();
                                    System.out.print(
                                            "Escreva o ID da disciplina que pretende remover do curso "
                                                    + escolaInformatica.getCursosEscola().get(posCursoRemDisc)
                                                            .getNomeCurso()
                                                    + " --> ");
                                    idDiscRem = Ler.umInt();
                                    posdisc = escolaInformatica.devolvePosDisciplinaDadoID(idDiscRem);
                                    existeNoCurso = escolaInformatica.verificaSeDisciplinaPertenceCurso(posCursoRemDisc,
                                            escolaInformatica.getDisciplinaEscola().get(posdisc).getNomDisc());
                                    if (existeNoCurso == false)
                                        System.out
                                                .println("\nLamentamos, mas esta disciplina não existe neste curso!\n");
                                    else {
                                        escolaInformatica.getCursosEscola().get(posCursoRemDisc).getDisciplinasCurso()
                                                .remove(escolaInformatica.getDisciplinaEscola().get(posdisc));
                                        escolaInformatica.atualizaCurso(posCursoRemDisc);
                                        System.out.println(
                                                "\nDisciplina "
                                                        + escolaInformatica.getDisciplinaEscola().get(posdisc)
                                                                .getNomDisc()
                                                        + " removida de " + escolaInformatica.getCursosEscola()
                                                                .get(posCursoRemDisc).getNomeCurso()
                                                        + " com sucesso!\n");
                                        funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                escolaInformatica);
                                    }
                                }
                                funcoesUteis.pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 8);
                    break;
                case 3:
                    do {
                        funcoesUteis.limpaTela();
                        System.out.print(
                                "GERIR DISCIPLINAS\n\n1. Listar disciplinas\n2. Criar disciplina\n3. Consultar informações de determinada disciplina\n4. Modificar dados sobre uma disciplina\n5. Remover disciplina\n6. Mostrar a disciplina com a frequência mais longa\n7. Mostrar professores que lecionam determianda disciplina\n8. Mostrar alunos inscritos em determinada disciplina\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 8 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        funcoesUteis.limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Disciplinas

                                System.out.println("1. LISTAR Disciplinas\n");
                                escolaInformatica.listaDisciplinas();
                                funcoesUteis.pedeTecla();
                                break;
                            case 2:
                                // Criar Disciplina

                                System.out.print("2. Disciplinas\n");
                                escolaInformatica.getDisciplinaEscola()
                                        .add(funcoesUteis.criarDisciplina(escolaInformatica));
                                funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println("\nDisciplina criada com sucesso!!\n");
                                funcoesUteis.pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinada disciplina

                                int posdiscCons, idDiscConsultar;
                                System.out.print(
                                        "3. CONSULTAR INFORMAÇÕES SOBRE DETERMINADA DISCIPLINA\n\n");
                                escolaInformatica.listaDisciplinas();
                                System.out.print("Escreva o ID da disciplina que pretende consultar --> ");
                                idDiscConsultar = Ler.umInt();
                                posdiscCons = escolaInformatica.devolvePosDisciplinaDadoID(idDiscConsultar);
                                if (posdiscCons == -1)
                                    System.out.println("Lamentamos, mas este disciplina não existe!\n");
                                else
                                    System.out.println(
                                            escolaInformatica.getDisciplinaEscola().get(posdiscCons).toString());
                                funcoesUteis.pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma determinada disciplina

                                int posdiscmod, idDiscMod;
                                System.out.print(
                                        "MODIFICAR DADOS SOBRE UMA DETERMINADA DISCIPLINA\n\n");
                                escolaInformatica.listaDisciplinas();
                                System.out.print("Escreva o ID da disciplina que pretende modificar --> ");
                                idDiscMod = Ler.umInt();
                                posdiscmod = escolaInformatica.devolvePosDisciplinaDadoID(idDiscMod);
                                if (posdiscmod == -1)
                                    System.out.println("\nLamentamos, mas esta disciplina não existe!\n");
                                else {
                                    funcoesUteis.modificarDisciplina(escolaInformatica, posdiscmod);
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                    System.out.println("\nDisciplina modificada com sucesso!\n");
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 5:
                                // Remover disciplina

                                String nomeDiscRemover;
                                int opcaodisc;
                                System.out.print(
                                        "5. REMOVER DISCIPLINA\n\n  1. Remover pelo nome\n  2. Remover por palavra contida no nome\n  3. Remover pelo ID\n  0. Sair\n\n  ESCOLHA UMA OPCAO --> ");
                                opcaodisc = Ler.umInt();
                                while (opcaodisc > 3 || opcaodisc < 0) {
                                    System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                                    opcaodisc = Ler.umInt();
                                }
                                funcoesUteis.limpaTela();
                                boolean sucesso = false;
                                switch (opcaodisc) {
                                    case 1:
                                        System.out.print(
                                                "1. Remover pelo nome\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print("Escreva o nome da Disciplina que pretende remover -->  ");
                                        nomeDiscRemover = Ler.umaString();
                                        sucesso = escolaInformatica.removeDiscEquals(nomeDiscRemover);
                                        if (sucesso == true) {
                                            funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                    escolaInformatica);
                                            System.out.println(
                                                    "Disciplina " + nomeDiscRemover + " removido com sucesso.");
                                        } else
                                            System.out.println(
                                                    "Não existe nenhuma disciplina com o nome " + nomeDiscRemover
                                                            + ".");
                                        System.out.println();
                                        funcoesUteis.pedeTecla();
                                        break;
                                    case 2:
                                        System.out.print(
                                                "2. Remover por palavra contida no nome\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print(
                                                "Escreva uma palavra contida no nome da disciplina que pretende remover -->  ");
                                        nomeDiscRemover = Ler.umaString();
                                        sucesso = escolaInformatica.removediscContains(nomeDiscRemover);
                                        if (sucesso == true) {
                                            funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                    escolaInformatica);
                                            System.out.println("Disciplina que contêm a palavra " + nomeDiscRemover
                                                    + " removida com sucesso.");
                                        } else
                                            System.out.println("Não existe nenhuma disciplina que contenha a palavra "
                                                    + nomeDiscRemover + ".");
                                        System.out.println();
                                        funcoesUteis.pedeTecla();
                                        break;
                                    case 3:
                                        System.out.print(
                                                "3. Remover pelo ID\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print("Escreva o ID da disciplina que pretende remover -->  ");
                                        int idDiscRemover = Ler.umInt();
                                        int posdiscRem = escolaInformatica.devolvePosDisciplinaDadoID(idDiscRemover);
                                        if (posdiscRem != -1) {
                                            String nomeDiscRem = escolaInformatica.getDisciplinaEscola().get(posdiscRem)
                                                    .getNomDisc();
                                            escolaInformatica.getDisciplinaEscola().remove(posdiscRem);
                                            funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                    escolaInformatica);
                                            System.out.println(
                                                    "\nDisciplina " + nomeDiscRem + " removida com sucesso!\n");
                                        } else
                                            System.out.println("Não existe nenhuma disciplina com o ID "
                                                    + idDiscRemover + ".");
                                        funcoesUteis.pedeTecla();
                                        break;
                                }
                                break;
                            case 6:
                                // Mostrar a disciplina com a frequência mais longa
                                if (funcoesUteis.discfrequenciamaislonga(escolaInformatica).getNomDisc().equals(""))
                                    System.out.println("Ainda não existem frequências criadas!");
                                else
                                    System.out.println("A Disciplina com a frequencia mais longa da "
                                            + escolaInformatica.getNomeEscola() + " é:\n . "
                                            + funcoesUteis.discfrequenciamaislonga(escolaInformatica).getNomDisc()
                                            + "\n");

                                funcoesUteis.pedeTecla();
                                break;
                            case 7:
                                // Mostrar professores que lecionam determianda disciplina

                                String nomeDiscprof = "";
                                int opcaodiscprof;
                                ArrayList<Professor> discescolaprof = funcoesUteis.convPessoaProf(
                                        funcoesUteis.identProf(escolaInformatica.getPessoasEscola()));
                                System.out.print(
                                        "5. Professores de uma determinada Disciplina\n\n  1. Pelo nome da Disciplina\n  2. Por uma palavra contida no nome da Disciplina\n  3. Pelo ID da Disciplina\n  0. Sair\n\n  ESCOLHA UMA OPCAO --> ");
                                opcaodiscprof = Ler.umInt();
                                while (opcaodiscprof > 3 || opcaodiscprof < 0) {
                                    System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                                    opcaodiscprof = Ler.umInt();
                                }
                                funcoesUteis.limpaTela();
                                boolean sucesso1 = false;
                                switch (opcaodiscprof) {
                                    case 1:
                                        System.out.print(
                                                "1. Pelo nome da Disciplina\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print("Escreva o nome da Disciplina que pretende -->  ");
                                        nomeDiscprof = Ler.umaString();
                                        sucesso1 = escolaInformatica.profDiscEquals(nomeDiscprof);
                                        if (sucesso1 == true) {
                                            ArrayList<Professor> ArrayResultadosdiscProf = funcoesUteis
                                                    .profdasdisciplinas(
                                                            discescolaprof, nomeDiscprof);
                                            if (ArrayResultadosdiscProf.isEmpty())
                                                System.out.println(
                                                        "Ainda não existem professores de " + nomeDiscprof + ".");
                                            else {
                                                System.out.println("\nProfessores de " + nomeDiscprof + ":");
                                                for (int i = 0; i < ArrayResultadosdiscProf.size(); i++)
                                                    System.out.println(" . ID:"
                                                            + ArrayResultadosdiscProf.get(i).getNumProf() + ", Nome:"
                                                            + ArrayResultadosdiscProf.get(i).getNome());
                                            }
                                        } else
                                            System.out.println(
                                                    "\nNão existe nenhuma disciplina com o nome " + nomeDiscprof + ".");
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print(
                                                "2. Pela palavra contida no nome\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print("Escreva uma palavra contida no nome da disciplina -->  ");
                                        nomeDiscprof = Ler.umaString();
                                        sucesso1 = escolaInformatica.discprofContains(nomeDiscprof);
                                        if (sucesso1 == true) {
                                            ArrayList<Professor> ArrayResultadosdiscProfcont = funcoesUteis
                                                    .profdasdisciplinascont(
                                                            discescolaprof, nomeDiscprof);
                                            if (ArrayResultadosdiscProfcont.isEmpty()) {
                                                System.out.println(
                                                        "\nAinda não existem professores de " + nomeDiscprof + ".");
                                            } else {
                                                System.out.println("\nProfessores da Disciplina que contêm a palavra "
                                                        + nomeDiscprof + ":");
                                                for (int i = 0; i < ArrayResultadosdiscProfcont.size(); i++) {
                                                    System.out.println(" . ID:"
                                                            + ArrayResultadosdiscProfcont.get(i).getNumProf()
                                                            + ", Nome:" + ArrayResultadosdiscProfcont.get(i).getNome());
                                                }
                                            }
                                        } else
                                            System.out.println("\nNão existe nenhuma disciplina que contenha a palavra "
                                                    + nomeDiscprof + ".");
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.print(
                                                "2. Pelo ID da Disciplina\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print("Escreva o ID da disciplina -->  ");
                                        int idDiscProf = Ler.umInt();
                                        int posDiscProf = escolaInformatica.devolvePosDisciplinaDadoID(idDiscProf);
                                        sucesso1 = escolaInformatica.discprofContains(
                                                escolaInformatica.getDisciplinaEscola().get(posDiscProf).getNomDisc());
                                        if (sucesso1 == true) {
                                            ArrayList<Professor> ArrayResultadosdiscProfcont = funcoesUteis
                                                    .profdasdisciplinascont(
                                                            discescolaprof, nomeDiscprof);
                                            if (ArrayResultadosdiscProfcont.isEmpty()) {
                                                System.out.println("\nAinda não existem professores de "
                                                        + escolaInformatica.getDisciplinaEscola().get(posDiscProf)
                                                                .getNomDisc()
                                                        + ".");
                                            } else {
                                                System.out.println("\nProfessores da Disciplina de "
                                                        + escolaInformatica.getDisciplinaEscola().get(posDiscProf)
                                                                .getNomDisc()
                                                        + ":");
                                                for (int i = 0; i < ArrayResultadosdiscProfcont.size(); i++) {
                                                    System.out.println(" . ID:"
                                                            + ArrayResultadosdiscProfcont.get(i).getNumProf()
                                                            + ", Nome:" + ArrayResultadosdiscProfcont.get(i).getNome());
                                                }
                                            }
                                        } else
                                            System.out.println("\nNão existe nenhuma disciplina com ID "
                                                    + idDiscProf + ".");
                                        System.out.println();
                                        break;
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 8:
                                // Mostrar alunos inscritos em determinada disciplina

                                String nomeDiscalunos = "", nomedisc;
                                int opcaodiscalunos;
                                boolean sucesso2 = false;
                                ArrayList<Aluno> discescolaalunos = funcoesUteis.convPessoaAluno(
                                        funcoesUteis.identAluno(escolaInformatica.getPessoasEscola()));

                                System.out.print(
                                        "5. Alunos de uma determinada Disciplina\n\n  1. Pelo nome da Disciplina\n  2. Por uma palavra contida no nome da Disciplina\n  3. Pelo ID da Disciplina\n  0. Sair\n\n  ESCOLHA UMA OPCAO --> ");
                                opcaodiscalunos = Ler.umInt();
                                while (opcaodiscalunos > 3 || opcaodiscalunos < 0) {
                                    System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                                    opcaodiscprof = Ler.umInt();
                                }
                                funcoesUteis.limpaTela();

                                switch (opcaodiscalunos) {
                                    case 1:
                                        System.out.print(
                                                "1. Pelo nome da Disciplina\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print("Escreva o nome da Disciplina que pretende --> ");
                                        nomeDiscalunos = Ler.umaString();
                                        sucesso2 = escolaInformatica.alunosDiscEquals(nomeDiscalunos);
                                        if (sucesso2 == true) {
                                            ArrayList<Aluno> arrayResultadosdiscalunos = funcoesUteis
                                                    .alunosdasdisciplinas(
                                                            discescolaalunos, nomeDiscalunos);
                                            if (arrayResultadosdiscalunos.isEmpty())
                                                System.out.println(
                                                        "\nAinda não há alunos inscritos em cursos que contenham esta disciplina.");
                                            else {
                                                System.out.println("\nAlunos de " + nomeDiscalunos + ":");
                                                for (int i = 0; i < arrayResultadosdiscalunos.size(); i++)
                                                    System.out.println(" . ID:"
                                                            + arrayResultadosdiscalunos.get(i).getNumAluno() + ", Nome:"
                                                            + arrayResultadosdiscalunos.get(i).getNome());
                                            }
                                        } else
                                            System.out.println(
                                                    "\nNão existe nenhum disciplina com o nome " + nomeDiscalunos
                                                            + ".");
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print(
                                                "2. Pela palavra contida no nome\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print(
                                                "Escreva uma palavra contida no nome da disciplina que pretende --> ");
                                        nomeDiscalunos = Ler.umaString();
                                        nomedisc = escolaInformatica.devolveDisciplinaConts(nomeDiscalunos)
                                                .getNomDisc();
                                        sucesso2 = escolaInformatica.discalunosContains(nomeDiscalunos);
                                        if (sucesso2 == true) {
                                            ArrayList<Aluno> arrayResultadosdiscalunoscont = funcoesUteis
                                                    .alunosdasdisciplinascont(
                                                            discescolaalunos, nomeDiscalunos);
                                            if (arrayResultadosdiscalunoscont.isEmpty())
                                                System.out.println(
                                                        "\nAinda não há alunos inscritos em cursos que contenham "
                                                                + nomedisc + ".");
                                            else {
                                                System.out.println("\nAlunos de " + nomedisc + ":");
                                                for (int i = 0; i < arrayResultadosdiscalunoscont.size(); i++)
                                                    System.out.println(" . ID:"
                                                            + arrayResultadosdiscalunoscont.get(i).getNumAluno()
                                                            + ", Nome:"
                                                            + arrayResultadosdiscalunoscont.get(i).getNome());
                                            }
                                        } else
                                            System.out.println("\nNão existe nenhuma disciplina que contenha a palavra "
                                                    + nomeDiscalunos + ".");
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.print(
                                                "3. Pelo ID da Disciplina\n\n");
                                        escolaInformatica.listaDisciplinas();
                                        System.out.print(
                                                "Escreva o ID da Disciplina que pretende consultar os alunos --> ");
                                        int idDiscAlun = Ler.umInt();
                                        int pos = escolaInformatica.devolvePosDisciplinaDadoID(idDiscAlun);
                                        nomedisc = escolaInformatica.getDisciplinaEscola().get(pos).getNomDisc();
                                        sucesso2 = escolaInformatica.discalunosContains(nomedisc);
                                        if (sucesso2 == true) {
                                            ArrayList<Aluno> arrayResultadosdiscalunos = funcoesUteis
                                                    .alunosdasdisciplinascont(
                                                            discescolaalunos, nomedisc);
                                            if (arrayResultadosdiscalunos.isEmpty())
                                                System.out.println(
                                                        "\nAinda não há alunos inscritos em cursos que contenham "
                                                                + nomedisc + ".");
                                            else {
                                                System.out.println("\nAlunos de " + nomedisc + ":");
                                                for (int i = 0; i < arrayResultadosdiscalunos.size(); i++)
                                                    System.out.println(" . ID:"
                                                            + arrayResultadosdiscalunos.get(i).getNumAluno()
                                                            + ", Nome:"
                                                            + arrayResultadosdiscalunos.get(i).getNome());
                                            }
                                        } else
                                            System.out.println("\nNão existe nenhuma disciplina com o ID "
                                                    + idDiscAlun + ".");
                                        System.out.println();
                                        break;
                                }
                                funcoesUteis.pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 8);
                    break;
                case 4:
                    do {
                        funcoesUteis.limpaTela();
                        System.out.print(
                                "GERIR PROFESSORES\n\n1. Listar professores\n2. Criar professor\n3. Consultar informações de determinado professor\n4. Modificar dados sobre um determinado professor\n5. Remover professor\n6. Mostrar professor que lecionou mais disciplinas\n7. Mostrar professores deslocados\n8. Mostrar qual é o professor com melhor rating\n9. Mostrar professor mais velho e mais novo\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 9 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        funcoesUteis.limpaTela();
                        ArrayList<Pessoa> profsDaEscola;
                        ArrayList<Professor> professoresEscolaDisc;
                        ArrayList<Professor> professoresEscolaRating;
                        ArrayList<Professor> profscomMelhorRating;
                        ;
                        switch (opcaoUtilizador) {
                            case 1:
                                profsDaEscola = funcoesUteis.identProf(escolaInformatica.getPessoasEscola());
                                // Listar Professores

                                for (int i = 0; i < profsDaEscola.size(); i++) {
                                    funcoesUteis.listaumProf((Professor) profsDaEscola.get(i));
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 2:
                                // Criar Professor

                                Professor novoProf = funcoesUteis.criaProfessor(escolaInformatica);
                                escolaInformatica.getPessoasEscola().add(novoProf);
                                escolaInformatica.insereProfNasSuasDisciplinas(novoProf);
                                funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                funcoesUteis.pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinado professor

                                String nomeProfConsultar;
                                int posProf;
                                profsDaEscola = funcoesUteis.identProf(escolaInformatica.getPessoasEscola());
                                System.out.print(
                                        "3. CONSULTAR INFORMAÇÕES SOBRE DETERMINADO PROFESSOR\n\nEscreva o nome do professor que pretende consultar -->  ");
                                nomeProfConsultar = Ler.umaString();
                                posProf = escolaInformatica.devolvePosProf(nomeProfConsultar, profsDaEscola);
                                if (posProf == -1)
                                    System.out.println("Lamentamos, mas este professor não existe!\n");
                                else {
                                    System.out.println();
                                    funcoesUteis.listaumProf((Professor) profsDaEscola.get(posProf));
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma determinado professor

                                Professor professorModificado;
                                System.out.print(
                                        "4. MODIFICAR INFORMAÇÕES SOBRE DETERMINADO PROFESSOR\n\nEscreva o nome do professor que pretende modificar -->  ");
                                String nomeProfModificar = Ler.umaString();
                                posProf = escolaInformatica.devolvePosProf(nomeProfModificar,
                                        escolaInformatica.getPessoasEscola());
                                if (posProf == -1) {
                                    System.out.println("Lamentamos, mas este professor não existe!\n");
                                    funcoesUteis.pedeTecla();
                                } else {
                                    professorModificado = funcoesUteis.modificarProfessor(escolaInformatica, posProf);
                                    escolaInformatica.removeProfNasSuasDisciplinas(professorModificado);
                                    escolaInformatica.insereProfNasSuasDisciplinas(professorModificado);
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                break;
                            case 5:
                                // Remover professor

                                System.out.print(
                                        "5. REMOVER PROFESSOR\n\nEscreva o nome do professor que pretende remover -->  ");
                                String nomeProfRemover = Ler.umaString();
                                posProf = escolaInformatica.devolvePosProf(nomeProfRemover,
                                        escolaInformatica.getPessoasEscola());
                                if (posProf == -1) {
                                    System.out.println("Lamentamos, mas este professor não existe!\n");
                                } else {
                                    escolaInformatica.getPessoasEscola().remove(posProf);
                                    System.out.println("Professor " + nomeProfRemover + " removido com sucesso.\n");
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 6:
                                // Mostrar professores com mais disciplinas lecionadas

                                professoresEscolaDisc = funcoesUteis
                                        .convPessoaProf(funcoesUteis.identProf(escolaInformatica.getPessoasEscola()));
                                ArrayList<Professor> professorMaisDiscLec = funcoesUteis.convPessoaProf(
                                        funcoesUteis.identProf(escolaInformatica.getPessoasEscola()));
                                ArrayList<Professor> ArrayResultadosProf = funcoesUteis.profcommaisdiscpLecionadas(
                                        professorMaisDiscLec);
                                if (ArrayResultadosProf.size() == 1) {
                                    System.out.println("PROFESSORES COM MAIS DISCIPLINAS LECIONADAS ("
                                            + ArrayResultadosProf.get(0).contDiscProf() + "):\n");
                                    System.out.println(" . " + ArrayResultadosProf.get(0).getNome());
                                } else {
                                    System.out.println("EMPATE! " + professoresEscolaDisc.get(0).contDiscProf()
                                            + " DISCIPLINAS LECIONADAS ENTRE OS SEGUINTES PROFESSORES:\n");
                                    for (int i = 0; i < ArrayResultadosProf.size(); i++)
                                        System.out.println(" . " + ArrayResultadosProf.get(i).getNome());
                                }
                                System.out.println();
                                funcoesUteis.pedeTecla();
                                break;
                            case 7:
                                // Mostrar professores deslocados

                                ArrayList<Pessoa> pessoasDeslocadas = funcoesUteis.pessoasDeslocadas(escolaInformatica);
                                ArrayList<Professor> professoresEscolaDeslocados = funcoesUteis.convPessoaProf(
                                        funcoesUteis.identProf(pessoasDeslocadas));
                                System.out.println("PROFESSORES DESLOCADOS\n");
                                for (int i = 0; i < professoresEscolaDeslocados.size(); i++)
                                    System.out.println(" . " + professoresEscolaDeslocados.get(i).getNome() + " ("
                                            + professoresEscolaDeslocados.get(i).getLocalDeOrigem() + ")");
                                System.out.println();
                                funcoesUteis.pedeTecla();
                                break;
                            case 8:
                                // Mostrar professores com melhor rating

                                professoresEscolaRating = funcoesUteis.convPessoaProf(
                                        funcoesUteis.identProf(escolaInformatica.getPessoasEscola()));
                                profscomMelhorRating = funcoesUteis.professorComMelhorRating(professoresEscolaRating);
                                professoresEscolaDisc = funcoesUteis
                                        .convPessoaProf(funcoesUteis.identProf(escolaInformatica.getPessoasEscola()));
                                if (profscomMelhorRating.size() == 1) {
                                    System.out.println("PROFESSOR COM MELHOR RATING ("
                                            + profscomMelhorRating.get(0).getRating() + "):\n");
                                    System.out.println(" . " + profscomMelhorRating.get(0).getNome());
                                } else {
                                    System.out.println(
                                            "EMPATE NO MELHOR RATING (" + professoresEscolaDisc.get(0).getRating()
                                                    + ") ENTRE OS SEGUINTES PROFESSORES:\n");
                                    for (int i = 0; i < profscomMelhorRating.size(); i++)
                                        System.out.println(" . " + profscomMelhorRating.get(i).getNome());
                                    System.out.println();
                                }
                                System.out.println();
                                funcoesUteis.pedeTecla();
                                break;
                            case 9:
                                // Mostrar professores mais velhos e mais novos

                                ArrayList<Pessoa> professores = funcoesUteis
                                        .identProf(escolaInformatica.getPessoasEscola());
                                ArrayList<Professor> profMaisVelhos = funcoesUteis.convPessoaProf(
                                        funcoesUteis.identProf(funcoesUteis.pessoasMaisVelhas(professores)));
                                ArrayList<Professor> profMaisNovos = funcoesUteis.convPessoaProf(
                                        funcoesUteis.identProf(funcoesUteis.pessoasMaisNovas(professores)));

                                if (profMaisNovos.size() == 1) {
                                    System.out.println("PROFESSOR MAIS NOVO (" + profMaisNovos.get(0).calculaIdade()
                                            + " ANOS):\n");
                                    System.out.println(" . " + profMaisNovos.get(0).getNome());
                                } else {
                                    System.out.println("EMPATE NOS PROFESSORES MAIS NOVOS ("
                                            + profMaisNovos.get(0).calculaIdade() + " ANOS):\n");
                                    for (int i = 0; i < profMaisNovos.size(); i++) {
                                        if (profMaisNovos.get(i).calculaIdade() == profMaisNovos.get(0).calculaIdade())
                                            System.out.println(" . " + profMaisNovos.get(i).getNome());
                                    }
                                }
                                System.out.println("\n------------------------------------------------");
                                if (profMaisVelhos.size() == 1) {
                                    System.out.println("PROFESSOR MAIS VELHO (" + profMaisVelhos.get(0).calculaIdade()
                                            + " ANOS):\n");
                                    System.out.println(" . " + profMaisVelhos.get(0).getNome());
                                } else {
                                    System.out.println("EMPATE NOS PROFESSORES MAIS VELHOS ("
                                            + profMaisVelhos.get(0).calculaIdade() + " ANOS):\n");
                                    for (int i = 0; i < profMaisVelhos.size(); i++) {
                                        if (profMaisVelhos.get(i).calculaIdade() == profMaisVelhos.get(0)
                                                .calculaIdade())
                                            System.out.println(" . " + profMaisVelhos.get(i).getNome());
                                    }
                                }
                                System.out.println();
                                funcoesUteis.pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 9);
                    break;
                case 5:
                    do {
                        funcoesUteis.limpaTela();
                        System.out.print(
                                "GERIR ALUNOS\n\n1. Listar alunos\n2. Criar aluno\n3. Consultar informações de determinado aluno\n4. Modificar dados sobre um determinado aluno\n5. Remover aluno\n6. Atribuir notas a alunos\n7. Inscrever aluno em curso\n8. Mostrar alunos deslocados\n9. Mostrar aluno mais velho e mais novo\n10. Mostrar aluno com melhor e pior média, de determinado curso\n11. Mostrar aluno com melhor nota, numa determinada frequência\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 10 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        funcoesUteis.limpaTela();
                        ArrayList<Pessoa> alunosDaEscola = funcoesUteis
                                .identAluno(escolaInformatica.getPessoasEscola());
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Alunos

                                for (int i = 0; i < alunosDaEscola.size(); i++)
                                    funcoesUteis.listaumAluno((Aluno) alunosDaEscola.get(i));
                                funcoesUteis.pedeTecla();
                                break;
                            case 2:
                                // Criar Alunos

                                Aluno novoAluno = funcoesUteis.criarAluno(escolaInformatica);
                                escolaInformatica.getPessoasEscola().add(novoAluno);
                                funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                funcoesUteis.pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinado aluno

                                String nomeAlunoConsultar;
                                int posAluno;
                                alunosDaEscola = funcoesUteis.identAluno(escolaInformatica.getPessoasEscola());
                                System.out.print(
                                        "3. CONSULTAR INFORMAÇÕES SOBRE DETERMINADO ALUNO\n\nEscreva o nome do aluno que pretende consultar -->  ");
                                nomeAlunoConsultar = Ler.umaString();
                                posAluno = escolaInformatica.devolvePosAluno(nomeAlunoConsultar, alunosDaEscola);
                                if (posAluno == -1)
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                else {
                                    System.out.println();
                                    funcoesUteis.listaumAluno((Aluno) alunosDaEscola.get(posAluno));
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma determinado aluno

                                System.out.print(
                                        "4. MODIFICAR INFORMAÇÕES SOBRE DETERMINADO ALUNO\n\nEscreva o nome do aluno que pretende modificar -->  ");
                                String nomeAlunoModificar = Ler.umaString();
                                posAluno = escolaInformatica.devolvePosAluno(nomeAlunoModificar,
                                        escolaInformatica.getPessoasEscola());
                                if (posAluno == -1) {
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                    funcoesUteis.pedeTecla();
                                } else {
                                    funcoesUteis.modificarAluno(escolaInformatica, posAluno);
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                break;
                            case 5:
                                // Remover aluno

                                System.out.print(
                                        "5. REMOVER ALUNO\n\nEscreva o nome do aluno que pretende remover -->  ");
                                String nomeAlunoRemover = Ler.umaString();
                                posAluno = escolaInformatica.devolvePosAluno(nomeAlunoRemover,
                                        escolaInformatica.getPessoasEscola());
                                if (posAluno == -1) {
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                } else {
                                    escolaInformatica.getPessoasEscola().remove(posAluno);
                                    System.out.println("Aluno " + nomeAlunoRemover + " removido com sucesso.\n");
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 6:
                                // Atribuir notas a alunos

                                ArrayList<Aluno> Alunos = funcoesUteis.convPessoaAluno(
                                        funcoesUteis.identAluno(escolaInformatica.getPessoasEscola()));
                                System.out.println("6. ATRIBUIR NOTAS A ALUNOS\n\n");
                                System.out.println("Alunos existentes na escola: ");
                                for (int i = 0; i < Alunos.size(); i++)
                                    System.out.println(
                                            "ID:" + Alunos.get(i).getNumAluno() + " --> " + Alunos.get(i).getNome());
                                System.out.print("\nEscolha o ID do aluno a que deseja atribuir notas --> ");
                                int numAlunoAtribuirNotas = Ler.umInt();

                                posAluno = escolaInformatica.devolvePosAlunoDadoID(numAlunoAtribuirNotas,
                                        funcoesUteis.convPessoaAluno(alunosDaEscola));
                                if (posAluno == -1) {
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                    funcoesUteis.pedeTecla();
                                } else {
                                    funcoesUteis.atribuiNotas(escolaInformatica, numAlunoAtribuirNotas);
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 7:
                                // Inscrever aluno em curso

                                System.out.print(
                                        "7. INSCREVER ALUNO EM CURSO\n\nEscreva o nome do aluno que pretende inscrever -->  ");
                                String nomeAlunoInscrever = Ler.umaString();
                                System.out.println();
                                posAluno = escolaInformatica.devolvePosAluno(nomeAlunoInscrever,
                                        escolaInformatica.getPessoasEscola());
                                if (posAluno == -1) {
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                } else {
                                    Aluno alunoinscrever = (Aluno) escolaInformatica.getPessoasEscola().get(posAluno);

                                    if (alunoinscrever.getCurso().getNomeCurso() == "") {
                                        funcoesUteis.inscreverAlunoEmCurso(escolaInformatica, nomeAlunoInscrever,
                                                alunoinscrever);
                                        escolaInformatica.insereAlunoNasSuasDisciplinas(alunoinscrever);
                                        for (int i = 0; i < alunoinscrever.getCurso().getDisciplinasCurso()
                                                .size(); i++) {
                                            ArrayList<Resultado> resultados = new ArrayList<Resultado>();
                                            NotasDisciplina notasDisciplina = new NotasDisciplina(
                                                    alunoinscrever.getCurso().getDisciplinasCurso().get(i).getNomDisc(),
                                                    resultados);
                                            alunoinscrever.getNotasDisciplinas().add(notasDisciplina);
                                        }
                                    } else {
                                        String opcao = "";
                                        System.out.println("O Aluno " + nomeAlunoInscrever
                                                + " já se encontra inscrito num curso! ("
                                                + alunoinscrever.getCurso().getNomeCurso() + ")\n");
                                        while (!opcao.equals("n") && !opcao.equals("N") && !opcao.equals("S")
                                                && !opcao.equals("s")) {
                                            System.out.print("Pretende alterar o Curso? [S/N] -> ");
                                            opcao = Ler.umaString();
                                        }
                                        System.out.println();
                                        if (opcao.equals("s") || opcao.equals("S")) {
                                            escolaInformatica.removeAlunoNasSuasDisciplinas(alunoinscrever);
                                            funcoesUteis.inscreverAlunoEmCurso(escolaInformatica, nomeAlunoInscrever,
                                                    alunoinscrever);
                                            escolaInformatica.insereAlunoNasSuasDisciplinas(alunoinscrever);
                                            for (int i = 0; i < alunoinscrever.getCurso().getDisciplinasCurso()
                                                    .size(); i++) {
                                                ArrayList<Resultado> resultados = new ArrayList<Resultado>();
                                                NotasDisciplina notasDisciplina = new NotasDisciplina(alunoinscrever
                                                        .getCurso().getDisciplinasCurso().get(i).getNomDisc(),
                                                        resultados);
                                                alunoinscrever.getNotasDisciplinas().add(notasDisciplina);
                                            }
                                        }
                                    }
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 8:
                                // Mostrar alunos não deslocados

                                ArrayList<Pessoa> pessoasDeslocadas = funcoesUteis.pessoasDeslocadas(escolaInformatica);
                                ArrayList<Aluno> alunosEscolaDeslocados = funcoesUteis.convPessoaAluno(
                                        funcoesUteis.identAluno(pessoasDeslocadas));
                                System.out.println("ALUNOS DESLOCADOS\n");
                                for (int i = 0; i < alunosEscolaDeslocados.size(); i++)
                                    System.out.println(" . " + alunosEscolaDeslocados.get(i).getNome() + " ("
                                            + alunosEscolaDeslocados.get(i).getLocalDeOrigem() + ")");
                                System.out.println();
                                funcoesUteis.pedeTecla();
                                break;
                            case 9:
                                // Mostrar aluno mais velho e mais novo

                                ArrayList<Pessoa> alunos = funcoesUteis
                                        .identAluno(escolaInformatica.getPessoasEscola());
                                ArrayList<Aluno> alunoMaisVelhos = funcoesUteis.convPessoaAluno(
                                        funcoesUteis.identAluno(funcoesUteis.pessoasMaisVelhas(alunos)));
                                ArrayList<Aluno> alunoMaisNovos = funcoesUteis.convPessoaAluno(
                                        funcoesUteis.identAluno(funcoesUteis.pessoasMaisNovas(alunos)));

                                if (alunoMaisNovos.size() == 1) {
                                    System.out.println(
                                            "ALUNO MAIS NOVO (" + alunoMaisNovos.get(0).calculaIdade() + " ANOS):\n");
                                    System.out.println(" . " + alunoMaisNovos.get(0).getNome());
                                } else {
                                    System.out.println("EMPATE NOS ALUNOS MAIS NOVOS ("
                                            + alunoMaisNovos.get(0).calculaIdade() + " ANOS):\n");
                                    for (int i = 0; i < alunoMaisNovos.size(); i++) {
                                        if (alunoMaisNovos.get(i).calculaIdade() == alunoMaisNovos.get(0)
                                                .calculaIdade())
                                            System.out.println(" . " + alunoMaisNovos.get(i).getNome());
                                    }
                                }
                                System.out.println("\n------------------------------------------------");
                                if (alunoMaisVelhos.size() == 1) {
                                    System.out.println(
                                            "ALUNO MAIS VELHO (" + alunoMaisVelhos.get(0).calculaIdade() + " ANOS):\n");
                                    System.out.println(" . " + alunoMaisVelhos.get(0).getNome());
                                } else {
                                    System.out.println("EMPATE NOS ALUNOS MAIS VELHOS ("
                                            + alunoMaisVelhos.get(0).calculaIdade() + " ANOS):\n");
                                    for (int i = 0; i < alunoMaisVelhos.size(); i++) {
                                        if (alunoMaisVelhos.get(i).calculaIdade() == alunoMaisVelhos.get(0)
                                                .calculaIdade())
                                            System.out.println(" . " + alunoMaisVelhos.get(i).getNome());
                                    }
                                }
                                System.out.println();
                                funcoesUteis.pedeTecla();
                                break;
                            case 10:
                                // Mostrar aluno com melhor nota, numa determinada frequência

                                int idFreq, idDisc;
                                System.out.println("10 - MOSTRAR ALUNO COM MELHOR NOTA NUMA DAD FREQUÊNCIA\n");

                                escolaInformatica.listaDisciplinas();
                                System.out.print("Escolha o ID da Disciplina: ");
                                idDisc = Ler.umInt();
                                escolaInformatica.devolvePosDisciplinaDadoID(idDisc);
                                while (escolaInformatica.devolvePosDisciplinaDadoID(idDisc) == -1) {
                                    System.out.print("ID NÃO EXISTENTE, ESCOLHA OUTRO: ");
                                    idDisc = Ler.umInt();
                                    escolaInformatica.devolvePosDisciplinaDadoID(idDisc);
                                }

                                System.out
                                        .print("\nEscolha o ID da Frequência "
                                                + funcoesUteis.listIdsDisciplina(escolaInformatica,
                                                        escolaInformatica.devolvePosDisc(escolaInformatica
                                                                .devolveDisciplinaDadoID(idDisc).getNomDisc()))
                                                + " --> ");
                                idFreq = Ler.umInt();
                                while (escolaInformatica.devolvePosFrequenciaDaListaFreq(idFreq) == -1) {
                                    System.out.print("ID NÃO EXISTENTE, ESCOLHA OUTRO: ");
                                    idFreq = Ler.umInt();
                                    escolaInformatica.devolvePosFrequenciaDaListaFreq(idFreq);
                                }

                                Aluno alunoComMelhorNota = funcoesUteis.alunoComMelhorNotaNumaFreq(idFreq,
                                        escolaInformatica.devolveDisciplinaDadoID(idDisc),
                                        funcoesUteis.convPessoaAluno(
                                                funcoesUteis.identAluno(escolaInformatica.getPessoasEscola())));

                                System.out.println("\nO aluno com melhor nota na Frequência com o ID " + idFreq
                                        + " da Disciplina de "
                                        + escolaInformatica.devolveDisciplinaDadoID(idDisc).getNomDisc() + " foi:\n . "
                                        + alunoComMelhorNota.getNome() + "\n");
                                funcoesUteis.pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 10);
                    break;
                case 6:
                    do {
                        funcoesUteis.limpaTela();
                        int idFreq;
                        System.out.print(
                                "GERIR FREQUÊNCIAS\n\n1. Listar Frequências de determinada disciplina\n2. Criar Frequência\n3. Mostrar determinada frequência, dado o ID da mesma\n4. Modificar dados sobre uma Frequência\n5. Remover Frequência\n6. Mostrar a pergunta com maior cotação, de determinada frequência\n7. Mostrar frequências por nível de dificuldade\n8. Mostrar frequências elaboradas por determinado professor\n9. Mostrar frequência com maior Nº perguntas de um curso \n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 9 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        funcoesUteis.limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Frequências de determinada disciplina

                                String nomediscp;
                                System.out.println("1. LISTAR FREQUÊNCIAS DE DETERMINADA DISCIPLINA\n");
                                idFreq = funcoesUteis.menuDisciplinasFreq(escolaInformatica);
                                if (idFreq != -1) {
                                    int posDisc = escolaInformatica.devolvePosDisciplinaDadoID(idFreq);
                                    ArrayList<Frequencia> listaFreqDisc = escolaInformatica.getDisciplinaEscola()
                                            .get(posDisc).getListFreq();
                                    for (int i = 0; i < listaFreqDisc.size(); i++)
                                        funcoesUteis.listaumaFreq(listaFreqDisc.get(i));
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 2:
                                // Criar Frequência

                                ArrayList<Pessoa> profsDaEscola = funcoesUteis
                                        .identProf(escolaInformatica.getPessoasEscola());
                                if (profsDaEscola.isEmpty())
                                    System.out.println(
                                            "Não é possível criar Frequências pois ainda não há professores inscritos!\n");
                                else {
                                    int posdisc = -1;
                                    Disciplina disciplinaDaFreq = new Disciplina();
                                    System.out.println("2. CRIAR FREQUÊNCIA\n");

                                    if (!escolaInformatica.getDisciplinaEscola().isEmpty()) {
                                        System.out.print("\nDisciplina disponíveis na escola: ");
                                        escolaInformatica.listaDisciplinas();

                                        System.out.print(
                                                "Disciplina para a qual pretende criar uma frequência [ID]: ");
                                        int idDisc = Ler.umInt();
                                        posdisc = escolaInformatica.devolvePosDisciplinaDadoID(idDisc);
                                        while (posdisc == -1) {
                                            System.out
                                                    .print("Lamento, mas esta disciplina não existe! Escolha outra: ");
                                            nomediscp = Ler.umaString();
                                            posdisc = escolaInformatica.devolveposDisc(nomediscp);
                                        }

                                        disciplinaDaFreq = escolaInformatica.getDisciplinaEscola().get(posdisc);

                                        funcoesUteis.criarfrequencia(escolaInformatica, disciplinaDaFreq);

                                        funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt",
                                                escolaInformatica);
                                        System.out.println("\n-->  Frequência criada com sucesso!!\n");
                                    } else
                                        System.out.println(
                                                "Não é possível criar uma frequência pois ainda não existem disciplinas criadas nesta escola.\n");
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 3:
                                // Consultar uma determinada Frequência

                                int posDisciplinaIdFreq;
                                int posFrequencia = -1;
                                System.out.println("3. CONSULTAR DADOS DE UM FREQUÊNCIA, DADO O SEU ID\n");
                                idFreq = funcoesUteis.menuDisciplinasFreq(escolaInformatica);
                                posDisciplinaIdFreq = escolaInformatica.devolvePosDisciplinaDadoID(idFreq);
                                System.out.print("\nID's das Frequências de "
                                        + escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getNomDisc()
                                        + ": "
                                        + funcoesUteis.listIdsDisciplina(escolaInformatica, posDisciplinaIdFreq));
                                System.out.print("\nIntroduza o ID da frequência que deseja consultar: ");
                                idFreq = Ler.umInt();
                                posFrequencia = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFreq);
                                while (posFrequencia == -1 || posDisciplinaIdFreq == -1) {
                                    System.out.print(
                                            "Introduza o ID da frequência que deseja consultar (DE ENTRE OS VÁLIDOS): ");
                                    idFreq = Ler.umInt();
                                    posFrequencia = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFreq);
                                }
                                funcoesUteis.consultarFrequencia(escolaInformatica, idFreq, posDisciplinaIdFreq,
                                        posFrequencia);

                                break;
                            case 4:
                                // Modificar dados de uma determinada Frequência
                                int posicaoDisc, posFrequencianaDisc;
                                System.out.println("4. MODIFICAR DADOS DE UM FREQUÊNCIA, DADO O SEU ID\n");
                                escolaInformatica.listaDisciplinas();
                                System.out.print("Nome da Disciplina da Frequência que pretende consultar -> ");
                                idFreq = Ler.umInt();
                                posicaoDisc = escolaInformatica.devolvePosDisciplinaDadoID(idFreq);
                                if (posicaoDisc == -1) {
                                    System.out
                                            .print("Lamentamos, mas este disciplina não existe! Digite algo válido: ");
                                } else {
                                    System.out.print("\nID's das Frequências de "
                                            + escolaInformatica.getDisciplinaEscola().get(posicaoDisc).getNomDisc()
                                            + ": "
                                            + funcoesUteis.listIdsDisciplina(escolaInformatica, posicaoDisc));
                                    System.out.print("\nIntroduza o ID da frequência que deseja modificar: ");
                                    idFreq = Ler.umInt();
                                    posFrequencianaDisc = escolaInformatica
                                            .devolvePosFrequenciaDaListaFreqDeUmaDisciplina(idFreq, escolaInformatica
                                                    .getDisciplinaEscola().get(posicaoDisc).getNomDisc());
                                    while (posFrequencianaDisc == -1) {
                                        System.out.println("Introduza um ID da Frequência VÁLIDO: ");
                                        idFreq = Ler.umInt();
                                        posFrequencianaDisc = escolaInformatica
                                                .devolvePosFrequenciaDaListaFreqDeUmaDisciplina(idFreq,
                                                        escolaInformatica.getDisciplinaEscola().get(posicaoDisc)
                                                                .getNomDisc());
                                    }

                                    Frequencia modificadaFreq = funcoesUteis.modFrequencia(escolaInformatica, idFreq,
                                            posicaoDisc,
                                            posFrequencianaDisc);

                                    escolaInformatica.getDisciplinaEscola().get(posicaoDisc).getListFreq()
                                            .set(posFrequencianaDisc, modificadaFreq);
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                break;
                            case 5:
                                // Remover Frequência

                                int posFrequencia2 = -1;
                                int posDisciplinaIdFreq2;
                                System.out.print("5. REMOVER FREQUÊNCIA\n\n");
                                posDisciplinaIdFreq2 = escolaInformatica.devolvePosDisciplinaDadoID(
                                        funcoesUteis.menuDisciplinasFreq(escolaInformatica));
                                if (posDisciplinaIdFreq2 != -1) {
                                    System.out.print("Escreva o ID da frequência que pretende remover "
                                            + funcoesUteis.listIdsDisciplina(escolaInformatica, posDisciplinaIdFreq2)
                                            + "-->  ");
                                    int idFrequencia = Ler.umInt();
                                    posFrequencia2 = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFrequencia);
                                    while (posFrequencia2 == -1 || posDisciplinaIdFreq2 == -1) {
                                        System.out.println("Introduza um ID da frequência VÁLIDO: ");
                                        idFrequencia = Ler.umInt();
                                    }
                                    escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq2).getListFreq()
                                            .remove(posFrequencia2);
                                    funcoesUteis.EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                    System.out.println(
                                            "\nFrequência com ID:" + idFrequencia + " removida com sucesso!\n");
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 6:
                                // Mostrar a pergunta com maior cotação, de determinada frequência
                                ArrayList<Perguntas> MaioresPerguntaLista = new ArrayList<>();
                                int posFrequencia3 = -1;
                                int posDisciplinaIdFreq3;
                                System.out.print("6. CONSULTAR PERGUNTA COM MAIOR COTAÇÃO\n\n");
                                int idDiscIdFreq3 = funcoesUteis.menuDisciplinasFreq(escolaInformatica);
                                if (idDiscIdFreq3 != -1) {
                                    posDisciplinaIdFreq3 = escolaInformatica.devolvePosDisciplinaDadoID(idDiscIdFreq3);
                                    System.out.print(
                                            "\nEscreva o ID da frequência da qual pretende consultar a pergunta com maior cotação "
                                                    + funcoesUteis.listIdsDisciplina(escolaInformatica,
                                                            posDisciplinaIdFreq3)
                                                    + "-->  ");
                                    int idFrequencia3 = Ler.umInt();
                                    posFrequencia3 = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFrequencia3);
                                    while (posFrequencia3 == -1) {
                                        System.out.print("Introduza um ID da frequência VÁLIDO: ");
                                        idFrequencia3 = Ler.umInt();
                                        posFrequencia3 = escolaInformatica
                                                .devolvePosFrequenciaDaListaFreq(idFrequencia3);
                                    }
                                    MaioresPerguntaLista = funcoesUteis.cotacaoMaior(escolaInformatica, idFrequencia3);
                                    if (MaioresPerguntaLista.size() == 0) {
                                        System.out.println("\nAinda não existem perguntas com cotação!");
                                    }
                                    if (MaioresPerguntaLista.size() == 1) {
                                        System.out.println(
                                                "\nPergunta com maior cotação ("
                                                        + MaioresPerguntaLista.get(0).getcotaçao()
                                                        + ") ->  " + MaioresPerguntaLista.get(0));
                                    }
                                    if (MaioresPerguntaLista.size() > 1) {
                                        System.out.println("\n  EMPATE NAS PERGUNTAS COM MAIOR COTAÇÃO ("
                                                + MaioresPerguntaLista.get(0).getcotaçao() + ") :");
                                        for (int i = 0; i < MaioresPerguntaLista.size(); i++) {
                                            System.out.println("->  " + MaioresPerguntaLista.get(i));
                                        }
                                    }
                                    System.out.println();
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 7:
                                // Mostrar frequências por nível de dificuldade

                                // Niveis Facil - 1 Medio - 2 Dificil - 3
                                int posDisciplinaEscolhida;
                                int nivelescolhido;
                                String condicaostop = "";
                                idFreq = funcoesUteis.menuDisciplinasFreq(escolaInformatica);
                                if (idFreq != -1) {
                                    posDisciplinaEscolhida = escolaInformatica.devolvePosDisciplinaDadoID(idFreq);
                                    funcoesUteis.limpaTela();
                                    do {
                                        funcoesUteis.limpaTela();
                                        nivelescolhido = funcoesUteis.menuEscolhaNivelAdequadaDisciplina(
                                                escolaInformatica,
                                                posDisciplinaEscolhida);
                                        switch (nivelescolhido) {
                                            case 1:
                                                funcoesUteis.limpaTela();
                                                System.out.println("Frequências de " + escolaInformatica
                                                        .getDisciplinaEscola().get(posDisciplinaEscolhida)
                                                        .getNomDisc() + " de fácil dificuldade:");
                                                if (!funcoesUteis.freqnivelFacil(escolaInformatica,
                                                        posDisciplinaEscolhida).isEmpty()) {
                                                    for (int i = 0; i < funcoesUteis.freqnivelFacil(escolaInformatica,
                                                            posDisciplinaEscolhida).size(); i++) {
                                                        funcoesUteis.listaumaFreq(funcoesUteis
                                                                .freqnivelFacil(escolaInformatica,
                                                                        posDisciplinaEscolhida)
                                                                .get(i));
                                                    }
                                                } else
                                                    System.out.println(
                                                            "Este nível de dificuldade não contém frequências.\n");
                                                System.out.print(
                                                        "Pretende explorar outros níveis de dificuldade ? Se sim [S], se não [N]! --> ");
                                                condicaostop = Ler.umaString();
                                                while(!condicaostop.equals("s")&&!condicaostop.equals("S")&&!condicaostop.equals("n")&&!condicaostop.equals("N")){
                                                    System.out.print(
                                                        "Pretende explorar outros níveis de dificuldade ? Se sim [S], se não [N]! --> ");
                                                    condicaostop = Ler.umaString(); 
                                                }
                                                break;
                                            case 2:
                                                funcoesUteis.limpaTela();
                                                System.out.println("Frequências de " + escolaInformatica
                                                        .getDisciplinaEscola().get(posDisciplinaEscolhida)
                                                        .getNomDisc() + " de dificuldade média:");
                                                if (!funcoesUteis.freqnivelMédio(escolaInformatica,
                                                        posDisciplinaEscolhida).isEmpty()) {
                                                    for (int i = 0; i < funcoesUteis.freqnivelMédio(escolaInformatica,
                                                            posDisciplinaEscolhida).size(); i++) {
                                                        funcoesUteis.listaumaFreq(funcoesUteis
                                                                .freqnivelMédio(escolaInformatica,
                                                                        posDisciplinaEscolhida)
                                                                .get(i));
                                                    }
                                                } else {
                                                    System.out.println(
                                                            "Este nível de dificuldade não contém frequências.\n");
                                                }
                                                System.out.print(
                                                        "Pretende explorar outros níveis de dificuldade ? Se sim [S], se não [N]! --> ");
                                                condicaostop = Ler.umaString();
                                                while(!condicaostop.equals("s")&&!condicaostop.equals("S")&&!condicaostop.equals("n")&&!condicaostop.equals("N")){
                                                    System.out.print(
                                                        "Pretende explorar outros níveis de dificuldade ? Se sim [S], se não [N]! --> ");
                                                    condicaostop = Ler.umaString(); 
                                                }
                                                break;
                                            case 3:
                                                funcoesUteis.limpaTela();
                                                System.out.println("Frequências de " + escolaInformatica
                                                        .getDisciplinaEscola().get(posDisciplinaEscolhida)
                                                        .getNomDisc() + " de dificuldade difícil");
                                                if (!funcoesUteis.freqnivelDificil(escolaInformatica,
                                                        posDisciplinaEscolhida).isEmpty()) {
                                                    for (int i = 0; i < funcoesUteis.freqnivelDificil(escolaInformatica,
                                                            posDisciplinaEscolhida).size(); i++) {
                                                        funcoesUteis.listaumaFreq(funcoesUteis
                                                                .freqnivelDificil(escolaInformatica,
                                                                        posDisciplinaEscolhida)
                                                                .get(i));
                                                    }
                                                } else {
                                                    System.out.println(
                                                            "Este nível de dificuldade não contém frequências.\n");
                                                }
                                                System.out.print(
                                                        "Pretende explorar outros níveis de dificuldade ? Se sim [S], se não [N]! --> ");
                                                condicaostop = Ler.umaString();
                                                while(!condicaostop.equals("s")&&!condicaostop.equals("S")&&!condicaostop.equals("n")&&!condicaostop.equals("N")){
                                                    System.out.print(
                                                        "Pretende explorar outros níveis de dificuldade ? Se sim [S], se não [N]! --> ");
                                                    condicaostop = Ler.umaString(); 
                                                }
                                                break;
                                        }
                                    } while (!condicaostop.equals("N") && !condicaostop.equals("n"));
                                    System.out.println();
                                    funcoesUteis.pedeTecla();
                                }
                                break;
                            case 8:
                                // Mostrar frequências elaboradas por determinado professor

                                System.out.println("8. Mostrar frequências elaboradas por um professor\n");
                                funcoesUteis.listaProfs(escolaInformatica);
                                System.out.print("Escolha o ID do Professor: ");
                                int IDProf = Ler.umInt();
                                int posProf;
                                posProf = escolaInformatica.devolvePosProfDadoID(IDProf,
                                        funcoesUteis.convPessoaProf(funcoesUteis.identProf(escolaInformatica.getPessoasEscola())));
                                if (posProf == -1) {
                                    System.out.println("Lamentamos, mas este professor não existe!\n");
                                } else {
                                    // Fazer função que devolva as frequencias de um dado prof de uma lista de array de profs profs
                                    Professor Prof = funcoesUteis.convPessoaProf(funcoesUteis.identProf(escolaInformatica.getPessoasEscola())).get(posProf);
                                    ArrayList<Frequencia> listaFreqProf = funcoesUteis.devolveFreqsDeUmProf(escolaInformatica, Prof, funcoesUteis.convPessoaProf(funcoesUteis.identProf(escolaInformatica.getPessoasEscola())));
                                    System.out.println();
                                    if(!listaFreqProf.isEmpty()){
                                        for (int i = 0; i < listaFreqProf.size(); i++)
                                            funcoesUteis.listaumaFreq(listaFreqProf.get(i));
                                    }
                                    else
                                        System.out.println("Este professor não é responsável por nenhuma disciplina.\n");
                                }
                                funcoesUteis.pedeTecla();
                                break;
                            case 9:
                                // Mostrar frequência com maior Nº perguntas de um curso

                                int posCursoSel;
                                System.out.println("9. Mostrar frequência com maior Nº perguntas de um curso\n");
                                ;
                                posCursoSel = funcoesUteis.menuCurso(escolaInformatica);
                                ArrayList<Frequencia> freqComMaisPerg = funcoesUteis.freqcommaisPerguntasCurso(
                                        escolaInformatica,
                                        posCursoSel);
                                if (freqComMaisPerg.size() == 0) {
                                    System.out.println("Nenhuma disciplina do curso tem frequências!");
                                }
                                if (freqComMaisPerg.size() == 1) {
                                    System.out.println("Frequência com maior Nº Perguntas ("
                                            + freqComMaisPerg.get(0).getNumPergTotal() + ") :");
                                    funcoesUteis.listaumaFreq(freqComMaisPerg.get(0));
                                }
                                if (freqComMaisPerg.size() > 1) {
                                    System.out.println("EMPATE NO Nº TOTAL DE PERGUNTAS ("
                                            + freqComMaisPerg.get(0).getNumPergTotal() + ") :");
                                    for (int i = 0; i < freqComMaisPerg.size(); i++) {
                                        funcoesUteis.listaumaFreq(freqComMaisPerg.get(i));
                                    }
                                }
                                funcoesUteis.pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 9);
                    break;
            }
            funcoesUteis.limpaTela();
            System.out.print(
                    "ESCOLA PROFISSIONAL DE INFORMÁTICA\n\n1. Gerir Escola\n2. Gerir Cursos\n3. Gerir Disciplinas\n4. Gerir Professores\n5. Gerir Alunos\n6. Gerir Frequências\n\n0. Sair\n\nESCOLHA A SUA OPÇÃO -> ");
            opcaoUtilizador = Ler.umInt();
        }
        funcoesUteis.limpaTela();
        System.out.print("_______________________________________________\n");
        System.out.print(
                "Programa elaborado por:\n\n-> João Martins\n-> Guilherme Teixeira\n-> Cláudio Redondo\n-> Tiago Ribeiro\n\n  POO - Engenharia Informática - UBI ");
        System.out.print("\n_______________________________________________\n");
    }
}
