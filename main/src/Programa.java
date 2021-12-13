import java.util.ArrayList;
import java.util.Collections;

import javax.lang.model.util.ElementScanner14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public class Programa implements Serializable {

    public static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pedeTecla() {
        System.out.print("Pressione alguma tecla para avançar --> ");
        Ler.umaString();
    }

    public static void EscreveEscolaNoFicheiro(String filepath, EscolaInformatica escolaInformatica) {

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filepath));
            // escrever o objeto livros no ficheiro
            os.writeInt(Aluno.getUltimo());
            os.writeInt(Professor.getUltimo());
            os.writeObject(escolaInformatica);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static EscolaInformatica LeEscolaNoFicheiro(String filepath) {
        EscolaInformatica escolaVazia = new EscolaInformatica();
        try {
            File file = new File(filepath);
            if (file.length() != 0) {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(filepath));
                int ult = is.readInt();
                Aluno.setUltimo(ult);
                int ultProf = is.readInt();
                Professor.setUltimo(ultProf);
                EscolaInformatica escolaInformatica = (EscolaInformatica) is.readObject();
                return escolaInformatica;
            } else
                return escolaVazia;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não existente - " + e.getMessage());
            return null;
        }
    }

    public static boolean verificaLogicaData(LocalDate datafim, LocalDate datainicio) {
        boolean correto = false;
        if (datainicio.isAfter(datafim) || datafim.isBefore(datainicio))
            correto = false;
        else
            correto = true;
        return correto;
    }

    public static LocalDate pedeData() {
        LocalDate data = LocalDate.now();
        Boolean exc = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        System.out.print("Digite uma data no formato 'dd/MM/yyyy' --> ");
        String dateString = Ler.umaString();
        do {
            exc = false;
            try {
                data = LocalDate.parse(dateString, formatter);
            } catch (Exception e) {
                System.out.print("INVÁLIDA! Digite uma data no formato 'dd/MM/yyyy' --> ");
                dateString = Ler.umaString();
                exc = true;
            }
        } while (exc == true);
        return data;
    }

    public static void listaumaFreq(Frequencia f) {
        System.out.println("ID: " + f.getid());
        System.out.println("Data da Frequência: " + f.getdatefreq());
        System.out.println("Disciplina: "+f.getDisc().getNomDisc());
        System.out.println("Professor Responsável: " + f.getProfessorResponsavel().getNome());
        System.out.println("Número de perguntas: " + f.getNumPergTotal());
        System.out.println("Dificuldade: " + f.getdificuldade());
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public static ArrayList<Professor> convPessoaProf(ArrayList<Pessoa> profsEscolaPessoa) {
        ArrayList<Professor> professores = new ArrayList<>();
        for (int i = 0; i < profsEscolaPessoa.size(); i++) {
            Professor p = (Professor) profsEscolaPessoa.get(i);
            professores.add(p);
        }
        return professores;
    }

    public static ArrayList<Aluno> convPessoaAluno(ArrayList<Pessoa> AlunosEscolaPessoa) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (int i = 0; i < AlunosEscolaPessoa.size(); i++) {
            Aluno a = (Aluno) AlunosEscolaPessoa.get(i);
            alunos.add(a);
        }
        return alunos;
    }

    public static void listaPessoasOutput(ArrayList<Pessoa> pessoas) {
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Contactos:");
            System.out.println("  Email: " + pessoa.getContactos().getE_mail());
            System.out.println("  Telefones: " + pessoa.getContactos().getTelefones());
            System.out.println("Local de Origem: " + pessoa.getLocalDeOrigem());
            System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());
            System.out.println("-----------------------------------------------------");
        }
        System.out.println();
    }

    public static void listaAlunosOutput(ArrayList<Aluno> alunos) {
        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            listaumAluno(a);
        }
        System.out.println();
    }

    public static void listaumAluno(Aluno a) {
        System.out.println("Nome: " + a.getNome());
        System.out.println("Número: " + a.getNumAluno());
        System.out.println("Contactos:");
        System.out.println("  Email: " + a.getContactos().getE_mail());
        System.out.println("  Telefones: " + a.getContactos().getTelefones());
        System.out.println("Local de Origem: " + a.getLocalDeOrigem());
        System.out.println("Data de Nascimento: " + a.getDataNascimento());
        System.out.println("Média de Entrada: " + a.getMediaEntrada());
        System.out.println("Curso: " + a.getCurso().getNomeCurso());
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public static void listaPerguntas(ArrayList<Perguntas> listaPerg) {
        for (int i = 0; i < listaPerg.size(); i++) {
            System.out.println("->  Pergunta Nº  " + (i + 1));
            System.out.println("Cotação: " + listaPerg.get(i).getcotaçao());
            System.out.println(listaPerg.get(i).getpergunta());
            System.out.println("------------------------------------------------");
        }
    }

    public static void listaumProf(Professor p) {
        System.out.println("Nome: " + p.getNome());
        System.out.println("Contactos:");
        System.out.println("  Email: " + p.getContactos().getE_mail());
        System.out.println("  Telefones: " + p.getContactos().getTelefones());
        System.out.println("Local de Origem: " + p.getLocalDeOrigem());
        System.out.println("Data de Nascimento: " + p.getDataNascimento());
        System.out.println("Número: " + p.getNumProf());
        System.out.println("Rating: " + p.getRating());
        p.listaDisc();
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public static void listaumaDisciplinaProf(Disciplina d) {
        System.out.println("\nNome: " + d.getNomDisc());
        System.out.println("Número:" + d.getNumDisc());
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public static void listaumDiretor(Diretor d) {
        System.out.println("Nome: " + d.getNome());
        System.out.println("Contactos:");
        System.out.println("  Email: " + d.getContactos().getE_mail());
        System.out.println("  Telefones: " + d.getContactos().getTelefones());
        System.out.println("Local de Origem: " + d.getLocalDeOrigem());
        System.out.println("Data de Nascimento: " + d.getDataNascimento());
        System.out.println("Anos de Serviço: " + d.getAnosDeServico());
        System.out.println("Formação Académica: " + d.getFormacaoAcademica());
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public static void removeDiretorDaListaDePessoas(ArrayList<Pessoa> pessoasEscola) {
        for (int i = 0; i < pessoasEscola.size(); i++) {
            if (pessoasEscola.get(i) instanceof Diretor)
                pessoasEscola.remove(i);
        }
    }

    public static ArrayList<Pessoa> identDiretor(ArrayList<Pessoa> pessoas) {
        ArrayList<Pessoa> pessoaDir = new ArrayList<>();
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof Diretor) {
                pessoaDir.add(pessoas.get(i));
            }
        }
        return pessoaDir;
    }

    public static ArrayList<Pessoa> identProf(ArrayList<Pessoa> pessoas) {
        ArrayList<Pessoa> pessoaAluno = new ArrayList<>();
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof Professor) {
                pessoaAluno.add(pessoas.get(i));
            }
        }
        return pessoaAluno;
    }

    public static ArrayList<Pessoa> identAluno(ArrayList<Pessoa> pessoas) {
        ArrayList<Pessoa> pessoaDir = new ArrayList<>();
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof Aluno) {
                pessoaDir.add(pessoas.get(i));
            }
        }
        return pessoaDir;
    }

    public static void listarPessoasEscola(ArrayList<Pessoa> pessoasEscola, EscolaInformatica escolaInformatica) {
        ArrayList<Pessoa> listapessoas = new ArrayList<>();
        int opcaolistpessoas;
        System.out.print(" LISTAR PESSOAS\n\n");
        System.out.print("1. Mostra Diretor\n");
        System.out.print("2. Listar Professores\n");
        System.out.print("3. Listar Alunos\n");
        System.out.print("\n0. Voltar Atrás\n");
        System.out.print("ESCOLHA A SUA OPÇÃO -> ");
        opcaolistpessoas = Ler.umInt();
        while (opcaolistpessoas > 3 || opcaolistpessoas < 0) {
            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
            opcaolistpessoas = Ler.umInt();
        }
        switch (opcaolistpessoas) {
            case 1:
                limpaTela();
                listapessoas = identDiretor(pessoasEscola);
                listaPessoasOutput(listapessoas);
                pedeTecla();
                break;
            case 2:
                limpaTela();
                listapessoas = identProf(pessoasEscola);
                listaPessoasOutput(listapessoas);
                pedeTecla();
                break;
            case 3:
                limpaTela();
                ArrayList<Pessoa> alunosDaEscola = identAluno(escolaInformatica.getPessoasEscola());
                for (int i = 0; i < alunosDaEscola.size(); i++)
                    listaumAluno((Aluno) alunosDaEscola.get(i));
                pedeTecla();
                break;
        }
    }

    public static ArrayList<Perguntas> cotacaoMaior(EscolaInformatica escolaInformatica, int idFrequencia) {
        ArrayList<Perguntas> perguntaMaior = new ArrayList<>();
        ArrayList<Float> cotacaoMaior = new ArrayList<>();
        int posFreq, posDisciplinaFreq;
        float maiorValor;
        ArrayList<Integer> posCotacaoMaior = new ArrayList<>();
        posFreq = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFrequencia);
        posDisciplinaFreq = escolaInformatica.devolvePosDisciplinaDaFreq(idFrequencia);
        for (int i = 0; i < escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq().get(posFreq)
                .getlistperg().size(); i++) {
            cotacaoMaior.add(escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq().get(posFreq)
                    .getlistperg().get(i).getcotaçao());

        }
        maiorValor = Collections.max(cotacaoMaior);
        for (int i = 0; i < cotacaoMaior.size(); i++) {
            if (cotacaoMaior.get(i) == maiorValor) {
                posCotacaoMaior.add(i);
            }
        }
        if (posCotacaoMaior.size() == 1) {
            perguntaMaior.add(escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq().get(posFreq)
                    .getlistperg().get(posCotacaoMaior.get(0)));
        }
        if (posCotacaoMaior.size() > 1) {
            for (int i = 0; i < posCotacaoMaior.size(); i++) {
                perguntaMaior.add(escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq()
                        .get(posFreq).getlistperg().get(posCotacaoMaior.get(i)));
            }
        }
        return perguntaMaior;
    }

    public static Diretor criarDiretor() {
        System.out.println("1. CRIAR DIRETOR\n");
        Diretor novodiretor = new Diretor();

        String nomePessoa, tipoContacto, localDeOrigem, email;
        String opcaoContactoMenu;
        long numeroContacto;
        ArrayList<Telefone> telefones = new ArrayList<>();
        Contactos contactosdir = new Contactos();

        System.out.print("Nome do Diretor: ");
        nomePessoa = Ler.umaString();
        novodiretor.setNome(nomePessoa);

        System.out.print("\nLocal de Origem do Diretor: ");
        localDeOrigem = Ler.umaString();
        novodiretor.setLocalDeOrigem(localDeOrigem);

        System.out.print("\nData de nascimento - ");
        LocalDate dataNascimentoDiretor = pedeData();
        novodiretor.setDataDeNascimento(dataNascimentoDiretor);

        System.out.println(
                "\n------------------------------------------------------------------------------");
        System.out.println("Telefones");
        do {
            System.out.print("\nTipo: ");
            tipoContacto = Ler.umaString();

            System.out.print("Número: ");
            numeroContacto = Ler.umLong();

            Telefone telefone = new Telefone(tipoContacto, numeroContacto);

            telefones.add(telefone);

            System.out.print("Pretende inserir mais telefones? [S/N] -> ");

            opcaoContactoMenu = Ler.umaString();
        } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
        contactosdir.setTelefone(telefones);
        System.out.println(
                "------------------------------------------------------------------------------");
        System.out.print("\nEmail do Diretor: ");
        email = Ler.umaString();
        contactosdir.setE_mail(email);
        novodiretor.setContactos(contactosdir);

        int anosdeservico;
        String formacaoacademica;

        System.out.print("\nAnos de Serviço: ");
        anosdeservico = Ler.umInt();
        novodiretor.setAnosDeServico(anosdeservico);

        System.out.print("\nFormação Académica: ");
        formacaoacademica = Ler.umaString();
        novodiretor.setFormacaoAcademica(formacaoacademica);
        return novodiretor;
    }

    public static Professor criaProfessor(EscolaInformatica escolaInformatica) {
        String nomeProfC, opcaoContactoMenu, tipoContactoC, emailC, localdeOrigemC;
        LocalDate datadenascimentoC;
        Long numeroContactoC;
        int ratingProfC, escolhaDisc;
        Contactos contactosC = new Contactos();
        ArrayList<Telefone> telefonesC = new ArrayList<>();
        ArrayList<Pessoa> Profs = identProf(escolaInformatica.getPessoasEscola());
        ArrayList<Disciplina> disciplinasP = new ArrayList<>();
        Professor professorC = new Professor();

        System.out.println("2. CRIAR PROFESSOR\n");

        int verificaExistenciaProf = -1;
        do {
            if (verificaExistenciaProf == -1)
                System.out.print("Nome do Professor: ");
            else
                System.out.print("Esse nome já existe! Por favor, escolha outro: ");
            nomeProfC = Ler.umaString();
            verificaExistenciaProf = escolaInformatica.devolvePosProf(nomeProfC, Profs);
        } while (verificaExistenciaProf != -1);
        professorC.setNome(nomeProfC);

        System.out.println("\n------------------------------------------------------------------------------");

        System.out.println("Telefones");
        do {
            System.out.print("\nTipo: ");
            tipoContactoC = Ler.umaString();

            System.out.print("Número: ");
            numeroContactoC = Ler.umLong();

            Telefone telefone = new Telefone(tipoContactoC, numeroContactoC);

            telefonesC.add(telefone);

            System.out.print("Pretende inserir mais telefones? [S/N] -> ");

            opcaoContactoMenu = Ler.umaString();
        } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
        contactosC.setTelefone(telefonesC);
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.print("\nEmail: ");
        emailC = Ler.umaString();
        contactosC.setE_mail(emailC);
        professorC.setContactos(contactosC);

        System.out.print("\nLocal de Origem: ");
        localdeOrigemC = Ler.umaString();
        professorC.setLocalDeOrigem(localdeOrigemC);

        System.out.print("\nData de Nascimento: ");
        datadenascimentoC = pedeData();
        professorC.setDataNascimento(datadenascimentoC);

        System.out.print("\nRating: ");
        ratingProfC = Ler.umInt();
        professorC.setRating(ratingProfC);

        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("Disciplinas para adicionar ao Professor: ");
        ArrayList<Integer> adicionados = new ArrayList<Integer>();
        int cont = 0;
        if (escolaInformatica.getDisciplinaEscola().isEmpty() == false) {
            do {
                int i = 0;
                System.out.println("\nDisciplinas Disponíveis (Escolha uma a uma pelo número): ");
                for (i = 0; i < escolaInformatica.getDisciplinaEscola().size(); i++) {
                    if (!adicionados.contains(i))
                        System.out.println(
                                i + ". " + escolaInformatica.getDisciplinaEscola().get(i).getNomDisc());
                }
                System.out.print("\nDisciplina para adicionar ao professor --> ");
                escolhaDisc = Ler.umInt();
                while (escolhaDisc < 0 || escolhaDisc > escolaInformatica.getDisciplinaEscola().size() - 1
                        || adicionados.contains(escolhaDisc)) {
                    System.out.println("Disciplina para adicionar ao professor (DIGITE ALGO VÁLIDO)--> ");
                    escolhaDisc = Ler.umInt();
                }
                adicionados.add(escolhaDisc);
                disciplinasP.add(escolaInformatica.getDisciplinaEscola().get(escolhaDisc));
                cont++;
                System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                opcaoContactoMenu = Ler.umaString();
                while (!opcaoContactoMenu.equals("n") && !opcaoContactoMenu.equals("N")
                        && !opcaoContactoMenu.equals("S") && !opcaoContactoMenu.equals("s")) {
                    System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                    opcaoContactoMenu = Ler.umaString();
                }
            } while ((opcaoContactoMenu.equals("s") || opcaoContactoMenu.equals("S"))
                    && cont < escolaInformatica.getDisciplinaEscola().size());
        } else {
            System.out.println("\nSem disciplinas disponíveis.\n");
        }
        if (cont == escolaInformatica.getDisciplinaEscola().size() && !opcaoContactoMenu.equals("n")
                && !opcaoContactoMenu.equals("N")) {
            System.out.println("Não é possível adicionar mais disciplinas.");
        }
        professorC.setDiscLec(disciplinasP);

        return professorC;
    }

    public static Curso criarCurso(EscolaInformatica escolaInformatica) {
        String nomeCurso, opcaoContactoMenu = "", codCurso;
        int duracaoCurso, escolhaDisc, verificaExistenciaCurso = -1;
        float mediaUltimoColocado;
        LocalDate dataInicioCurso, dataFimCurso;
        ArrayList<String> provasIngresso = new ArrayList<String>();
        ArrayList<Disciplina> disciplinasCurso = new ArrayList<Disciplina>();

        do {
            if (verificaExistenciaCurso == -1)
                System.out.print("Nome do Curso: ");
            else
                System.out.print("Esse nome já existe! Por favor, escolha outro: ");
            nomeCurso = Ler.umaString();
            verificaExistenciaCurso = escolaInformatica.devolvePosCurso(nomeCurso);
        } while (verificaExistenciaCurso != -1);

        System.out.print("\nCódigo do Curso: ");
        codCurso = Ler.umaString();

        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("Disciplinas para adicionar ao Curso: ");
        ArrayList<Integer> adicionados = new ArrayList<Integer>();
        int cont = 0;
        if (escolaInformatica.getDisciplinaEscola().isEmpty() == false) {
            do {
                int i = 0;
                System.out.println("\nDisciplinas Disponíveis (Escolha uma a uma pelo número): ");
                for (i = 0; i < escolaInformatica.getDisciplinaEscola().size(); i++) {
                    if (!adicionados.contains(i))
                        System.out.println(
                                i + ". " + escolaInformatica.getDisciplinaEscola().get(i).getNomDisc());
                }
                System.out.print("\nDisciplina para adicionar ao curso --> ");
                escolhaDisc = Ler.umInt();
                while (escolhaDisc < 0 || escolhaDisc > escolaInformatica.getDisciplinaEscola().size() - 1
                        || adicionados.contains(escolhaDisc)) {
                    System.out.println("Disciplina para adicionar ao cruso (DIGITE ALGO VÁLIDO)--> ");
                    escolhaDisc = Ler.umInt();
                }
                adicionados.add(escolhaDisc);
                disciplinasCurso.add(escolaInformatica.getDisciplinaEscola().get(escolhaDisc));
                cont++;
                System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                opcaoContactoMenu = Ler.umaString();
                while (!opcaoContactoMenu.equals("n") && !opcaoContactoMenu.equals("N")
                        && !opcaoContactoMenu.equals("S") && !opcaoContactoMenu.equals("s")) {
                    System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                    opcaoContactoMenu = Ler.umaString();
                }
            } while ((opcaoContactoMenu.equals("s") || opcaoContactoMenu.equals("S"))
                    && cont < escolaInformatica.getDisciplinaEscola().size());
        } else {
            System.out.println("\nSem disciplinas disponíveis.\n");
        }
        if (cont == escolaInformatica.getDisciplinaEscola().size() && !opcaoContactoMenu.equals("n")
                && !opcaoContactoMenu.equals("N")) {
            System.out.println("Não é possível adicionar mais disciplinas.");
        }
        System.out.println("------------------------------------------------------------------------------\n");

        System.out.println("Provas Ingresso:");
        String prova;
        do {
            System.out.print("\nAdicione uma prova de ingresso --> ");
            prova = Ler.umaString();
            provasIngresso.add(prova);
            System.out.print("Pretende inserir mais provas de ingresso? [S/N] -> ");
            opcaoContactoMenu = Ler.umaString();
            while (!opcaoContactoMenu.equals("n") && !opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("S")
                    && !opcaoContactoMenu.equals("s")) {
                System.out.print("ERRO! Pretende inserir mais provas de ingresso? [S/N] -> ");
                opcaoContactoMenu = Ler.umaString();
            }
        } while (opcaoContactoMenu.equals("s") || opcaoContactoMenu.equals("S"));
        System.out.println("------------------------------------------------------------------------------\n");

        System.out.print("Data de ínicio de curso - ");
        dataInicioCurso = pedeData();

        System.out.print("\nData de fim de curso - ");
        dataFimCurso = pedeData();

        boolean verificalogicaDatas;
        verificalogicaDatas = verificaLogicaData(dataFimCurso, dataInicioCurso);
        while (verificalogicaDatas == false) {
            System.out.println("\nA data de início não pode ser posterior à data final!");

            System.out.print("Data de ínicio de curso - ");
            dataInicioCurso = pedeData();

            System.out.print("Data de fim de curso - ");
            dataFimCurso = pedeData();

            verificalogicaDatas = verificaLogicaData(dataFimCurso, dataInicioCurso);
        }

        System.out.print("\nDuração do Curso em horas: ");
        duracaoCurso = Ler.umInt();

        System.out.print("\nMédia do Último Colocado: ");
        mediaUltimoColocado = Ler.umFloat();

        Curso novoCurso = new Curso(nomeCurso, codCurso, duracaoCurso, mediaUltimoColocado, provasIngresso,
                dataInicioCurso, dataFimCurso);
        novoCurso.setDisciplinasCurso(disciplinasCurso);

        return novoCurso;
    }

    public static Curso modificarCurso(EscolaInformatica escolaInformatica, int posicao) {
        int opcaoUtilizador;
        do {
            System.out.print("\nO que pretende modificar no curso de "
                    + escolaInformatica.getCursosEscola().get(posicao).getNomeCurso()
                    + "?\n\n 1. Nome\n 2. Cód.Curso\n 3. Média do último colocado\n 4. Provas de Ingresso\n 5. Datas\n\n 0. Nada, desejo sair\n\n Escolha a sua opção --> ");
            opcaoUtilizador = Ler.umInt();

            while (opcaoUtilizador > 5 || opcaoUtilizador < 0) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                opcaoUtilizador = Ler.umInt();
            }
            limpaTela();
            switch (opcaoUtilizador) {
                case 1:
                    int verificaExistenciaCurso = -1;
                    String nomeCurso;
                    do {
                        if (verificaExistenciaCurso == -1)
                            System.out.print("Nome do Curso: ");
                        else
                            System.out.print("Esse nome já existe! Por favor, escolha outro: ");
                        nomeCurso = Ler.umaString();
                        verificaExistenciaCurso = escolaInformatica.devolvePosCurso(nomeCurso);
                    } while (verificaExistenciaCurso != -1);
                    escolaInformatica.getCursosEscola().get(posicao).setNomeCurso(nomeCurso);
                    pedeTecla();
                    break;
                case 2:
                    String codCurso;
                    System.out.print("\nCódigo do Curso: ");
                    codCurso = Ler.umaString();
                    escolaInformatica.getCursosEscola().get(posicao).setCodCurso(codCurso);
                    pedeTecla();
                    break;
                case 3:
                    float mediaUltimoColocado;
                    System.out.print("\nMédia do Último Colocado: ");
                    mediaUltimoColocado = Ler.umInt();
                    escolaInformatica.getCursosEscola().get(posicao).setMediaUltimoColocado(mediaUltimoColocado);
                    pedeTecla();
                    break;
                case 4:
                    int opcaoProvas;
                    System.out.println("\nProvas de Ingresso atuais, do curso de "
                            + escolaInformatica.getCursosEscola().get(posicao).getNomeCurso() + ": ");
                    for (int i = 0; i < escolaInformatica.getCursosEscola().get(posicao).getProvasIngresso()
                            .size(); i++) {
                        System.out.println(
                                " . " + escolaInformatica.getCursosEscola().get(posicao).getProvasIngresso().get(i));
                    }
                    System.out.print(
                            "\n O que pretende fazer?\n 1. Adicionar prova de ingresso\n 2. Remover prova de ingresso\n 0. Voltar atrás\n\n ESCOLHA A SUA OPÇÃO --> ");
                    opcaoProvas = Ler.umInt();

                    while (opcaoProvas > 2 || opcaoProvas < 0) {
                        System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                        opcaoProvas = Ler.umInt();
                    }
                    limpaTela();
                    String Prova;
                    switch (opcaoProvas) {
                        case 1:
                            System.out.print("1. ADICIONAR PROVA DE INGRESSO\n\nNome da prova de ingresso a inserir: ");
                            Prova = Ler.umaString();
                            escolaInformatica.getCursosEscola().get(posicao).getProvasIngresso().add(Prova);
                            pedeTecla();
                            break;
                        case 2:
                            System.out.print("2. REMOVER PROVA DE INGRESSO\n\nNome da prova de ingresso a remover: ");
                            Prova = Ler.umaString();
                            if (escolaInformatica.getCursosEscola().get(posicao).verificaExistenciaProvaIng(Prova)) {
                                escolaInformatica.getCursosEscola().get(posicao).getProvasIngresso().remove(Prova);
                                System.out.println("Prova de ingresso removida com sucesso!\n");
                            } else
                                System.out.print(Prova + " não é uma prova de ingresso do curso de "
                                        + escolaInformatica.getCursosEscola().get(posicao).getNomeCurso());
                            pedeTecla();
                            break;
                    }
                    break;
                case 5:
                    LocalDate dataInicioCurso, dataFimCurso;
                    System.out.println("Alterar datas do início e fim do curso de "
                            + escolaInformatica.getCursosEscola().get(posicao).getNomeCurso() + "\n");

                    System.out.print("Data de ínicio de curso - ");
                    dataInicioCurso = pedeData();

                    System.out.print("\nData de fim de curso - ");
                    dataFimCurso = pedeData();

                    boolean verificalogicaDatas;
                    verificalogicaDatas = verificaLogicaData(dataFimCurso, dataInicioCurso);
                    while (verificalogicaDatas == false) {
                        System.out.println("\nA data de início não pode ser posterior à data final!");

                        System.out.print("Data de ínicio de curso - ");
                        dataInicioCurso = pedeData();

                        System.out.print("Data de fim de curso - ");
                        dataFimCurso = pedeData();

                        verificalogicaDatas = verificaLogicaData(dataFimCurso, dataInicioCurso);
                    }
                    escolaInformatica.getCursosEscola().get(posicao).setDataInicio(dataInicioCurso);
                    escolaInformatica.getCursosEscola().get(posicao).setDataFim(dataFimCurso);
                    System.out.println();
                    pedeTecla();
                    break;
            }
            limpaTela();
        } while (opcaoUtilizador > 0 && opcaoUtilizador <= 5);
        return escolaInformatica.getCursosEscola().get(posicao);
    }

    public static EscolaInformatica modificarEscola(EscolaInformatica escolaInformaticafich) {
        EscolaInformatica modEscola = LeEscolaNoFicheiro("escolaInformática.txt");
        int opcaoModEscola;
        String nomeModEscola;
        int numeroModEscola;
        String opcaoContactoMenu;
        String localizacaoModEscola;
        String emailModEscola;
        System.out.print(" MUDAR INFORMAÇÕES ACERCA DA ESCOLA\n\n");
        System.out.println("1. Nome\n2. Número\n3. Telefones\n4. Localização\n5. Email\n\n0. Voltar");
        System.out.print("ESCOLHA A SUA OPÇÃO -> ");
        opcaoModEscola = Ler.umInt();
        while (opcaoModEscola > 5 || opcaoModEscola < 0) {
            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
            opcaoModEscola = Ler.umInt();
        }
        switch (opcaoModEscola) {
            case 1:
                limpaTela();
                System.out.print("Introduza o novo nome: ");
                nomeModEscola = Ler.umaString();
                modEscola.setNomeEscola(nomeModEscola);
                break;
            case 2:
                limpaTela();
                System.out.print("Introduza o novo número: ");
                numeroModEscola = Ler.umInt();
                modEscola.setCodEscola(numeroModEscola);
                break;
            case 3:
                limpaTela();
                String emailModTEscola;
                String tipoContacto;
                Long numeroContacto;
                ArrayList<Telefone> telefoneModEscola = new ArrayList<Telefone>();
                System.out.println("Introduza os novos Telefones: ");
                do {
                    System.out.print("\nTipo: ");
                    tipoContacto = Ler.umaString();

                    System.out.print("Número: ");
                    numeroContacto = Ler.umLong();

                    Telefone telefone = new Telefone(tipoContacto, numeroContacto);
                    telefoneModEscola.add(telefone);

                    System.out.print("Pretende inserir mais telefones? [S/N] -> ");

                    opcaoContactoMenu = Ler.umaString();
                } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
                emailModTEscola = modEscola.getContactoEscola().getE_mail();
                Contactos contactoModTEscola = new Contactos(emailModTEscola);
                contactoModTEscola.setTelefone(telefoneModEscola);
                modEscola.setContactoEscola(contactoModTEscola);
                pedeTecla();
                break;
            case 4:
                limpaTela();
                System.out.print("Localização: ");
                localizacaoModEscola = Ler.umaString();
                modEscola.setLocalizacao(localizacaoModEscola);
                pedeTecla();
                break;
            case 5:
                limpaTela();
                System.out.print("Email: ");
                emailModEscola = Ler.umaString();
                Contactos oldContact = escolaInformaticafich.getContactoEscola();
                oldContact.setE_mail(emailModEscola);
                modEscola.setContactoEscola(oldContact);
                pedeTecla();
                break;
        }
        return modEscola;
    }

    public static Diretor modDiretor(EscolaInformatica escolaInformatica) {
        Diretor dirMod = escolaInformatica.getDiretorEscola();

        ArrayList<Telefone> dirModTelefone = new ArrayList<>();
        int opcaomoddiretor, dirModAnosServico;
        String dirModEmail, dirModLocalOrigem, dirModNome, dirModFormacaoNova, tipoContacto, opcaoContactoMenu;
        Long numeroContacto;

        System.out.println(" MODIFICAR DIRETOR\n");
        System.out.println(
                "1. Alterar email\n2. Alterar telefones\n3. Alterar data de nascimento\n4. Alterar local de origem\n5. Alterar nome\n6. Alterar anos de serviço\n7. Alterar formação académica\n\n0. Voltar Atrás");
        System.out.print("ESCOLHA A SUA OPÇÃO -> ");
        opcaomoddiretor = Ler.umInt();
        while (opcaomoddiretor > 7 || opcaomoddiretor < 0) {
            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
            opcaomoddiretor = Ler.umInt();
        }
        limpaTela();
        switch (opcaomoddiretor) {
            case 1:
                System.out.print("\nEmail do Diretor: ");
                dirModEmail = Ler.umaString();
                dirMod.getContactos().setE_mail(dirModEmail);
                ;
                pedeTecla();
                break;
            case 2:
                Contactos modDiretorContactos = new Contactos();
                modDiretorContactos = dirMod.getContactos();
                System.out.println("Telefones");
                do {
                    System.out.print("\nTipo: ");
                    tipoContacto = Ler.umaString();

                    System.out.print("Número: ");
                    numeroContacto = Ler.umLong();

                    Telefone telefone = new Telefone(tipoContacto, numeroContacto);

                    dirModTelefone.add(telefone);

                    System.out.print("Pretende inserir mais telefones? [S/N] -> ");

                    opcaoContactoMenu = Ler.umaString();
                } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
                modDiretorContactos.setTelefone(dirModTelefone);
                dirMod.setContactos(modDiretorContactos);
                pedeTecla();
                break;
            case 3:
                System.out.print("Data de Nascimento do Diretor: ");
                LocalDate dataNascimentoDiretorMod = pedeData();
                dirMod.setDataDeNascimento(dataNascimentoDiretorMod);
                pedeTecla();
                break;
            case 4:
                System.out.print("Alterar Local de Origem: ");
                dirModLocalOrigem = Ler.umaString();
                dirMod.setLocalDeOrigem(dirModLocalOrigem);
                pedeTecla();
                break;
            case 5:
                System.out.print("Alterar Nome: ");
                dirModNome = Ler.umaString();
                dirMod.setNome(dirModNome);
                pedeTecla();
                break;
            case 6:
                System.out.print("Anos de Serviço: ");
                dirModAnosServico = Ler.umInt();
                dirMod.setAnosDeServico(dirModAnosServico);
                pedeTecla();
                break;
            case 7:
                System.out.print("Alterar Formação Académica: ");
                dirModFormacaoNova = Ler.umaString();
                dirMod.setFormacaoAcademica(dirModFormacaoNova);
                pedeTecla();
                break;
        }
        limpaTela();
        return dirMod;
    }

    public static Aluno criarAluno(EscolaInformatica escolaInformatica) {
        System.out.println("1. CRIAR ALUNO\n");
        Aluno novoAluno = new Aluno();

        int verificaExistenciaAluno = -1;
        String nomePessoa, tipoContacto, localDeOrigem, email;
        String opcaoContactoMenu;
        long numeroContacto;
        double media;
        ArrayList<Telefone> telefones = new ArrayList<Telefone>();
        ArrayList<Pessoa> Alunos = identAluno(escolaInformatica.getPessoasEscola());
        Contactos contactosAluno = new Contactos();

        do {
            if (verificaExistenciaAluno == -1)
                System.out.print("Nome do Aluno: ");
            else
                System.out.print("Esse nome já existe! Por favor, escolha outro: ");
            nomePessoa = Ler.umaString();
            verificaExistenciaAluno = escolaInformatica.devolvePosAluno(nomePessoa, Alunos);
        } while (verificaExistenciaAluno != -1);
        novoAluno.setNome(nomePessoa);

        System.out.print("\nLocal de Origem do aluno: ");
        localDeOrigem = Ler.umaString();
        novoAluno.setLocalDeOrigem(localDeOrigem);

        System.out.print("\nData de nascimento - ");
        LocalDate dataNascimentoAluno = pedeData();
        novoAluno.setDataNascimento(dataNascimentoAluno);

        System.out.println(
                "\n------------------------------------------------------------------------------");
        System.out.println("Telefones");
        do {
            System.out.print("\nTipo: ");
            tipoContacto = Ler.umaString();

            System.out.print("Número: ");
            numeroContacto = Ler.umLong();

            Telefone telefone = new Telefone(tipoContacto, numeroContacto);

            telefones.add(telefone);

            System.out.print("Pretende inserir mais telefones? [S/N] -> ");

            opcaoContactoMenu = Ler.umaString();
        } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
        contactosAluno.setTelefone(telefones);
        System.out.println(
                "------------------------------------------------------------------------------");
        System.out.print("\nEmail do Aluno: ");
        email = Ler.umaString();
        contactosAluno.setE_mail(email);
        novoAluno.setContactos(contactosAluno);

        System.out.print("\nMédia de entrada: ");
        media = Ler.umFloat();
        novoAluno.setMediaEntrada(media);
        System.out.println();

        return novoAluno;
    }

    public static void modificarAluno(EscolaInformatica escolaInformatica, int posicao) {
        int opcaoUtilizador;
        Aluno novoAluno = (Aluno) escolaInformatica.getPessoasEscola().get(posicao);
        do {
            int verificaExistenciaAluno = -1;
            String nomePessoa, tipoContacto, localDeOrigem, email;
            String opcaoContactoMenu;
            long numeroContacto;
            double media;
            ArrayList<Telefone> telefones = new ArrayList<Telefone>();
            Contactos contactosAluno = new Contactos();

            System.out.print("\nO que pretende modificar no aluno " + novoAluno.getNome()
                    + "?\n\n 1. Nome\n 2. Local de Origem\n 3. Datas de nascimento\n 4. Telefones\n 5. Email\n 6. Média de Entrada\n\n 0. Nada, desejo sair\n\n Escolha a sua opção --> ");
            opcaoUtilizador = Ler.umInt();

            while (opcaoUtilizador > 6 || opcaoUtilizador < 0) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                opcaoUtilizador = Ler.umInt();
            }
            limpaTela();
            switch (opcaoUtilizador) {
                case 1:
                    do {
                        if (verificaExistenciaAluno == -1)
                            System.out.print("Nome do Aluno: ");
                        else
                            System.out.print("Esse nome já existe! Por favor, escolha outro: ");
                        nomePessoa = Ler.umaString();
                        verificaExistenciaAluno = escolaInformatica.devolvePosAluno(nomePessoa,
                                escolaInformatica.getPessoasEscola());
                    } while (verificaExistenciaAluno != -1);
                    novoAluno.setNome(nomePessoa);
                    pedeTecla();
                    break;
                case 2:
                    System.out.print("\nLocal de Origem do aluno: ");
                    localDeOrigem = Ler.umaString();
                    novoAluno.setLocalDeOrigem(localDeOrigem);
                    pedeTecla();
                    break;
                case 3:
                    System.out.print("\nData de nascimento - ");
                    LocalDate dataNascimentoAluno = pedeData();
                    novoAluno.setDataNascimento(dataNascimentoAluno);
                    pedeTecla();
                    break;
                case 4:
                    System.out.println("Telefones");
                    do {
                        System.out.print("\nTipo: ");
                        tipoContacto = Ler.umaString();

                        System.out.print("Número: ");
                        numeroContacto = Ler.umLong();

                        Telefone telefone = new Telefone(tipoContacto, numeroContacto);

                        telefones.add(telefone);

                        System.out.print("Pretende inserir mais telefones? [S/N] -> ");

                        opcaoContactoMenu = Ler.umaString();
                    } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
                    contactosAluno.setTelefone(telefones);
                    novoAluno.setContactos(contactosAluno);
                    pedeTecla();
                    break;
                case 5:
                    System.out.print("\nEmail do Aluno: ");
                    email = Ler.umaString();
                    contactosAluno.setE_mail(email);
                    novoAluno.setContactos(contactosAluno);
                    pedeTecla();
                    break;
                case 6:
                    System.out.print("\nMédia de entrada: ");
                    media = Ler.umFloat();
                    novoAluno.setMediaEntrada(media);
                    System.out.println();
                    pedeTecla();
                    break;
            }
            limpaTela();
            if (opcaoUtilizador != 0)
                escolaInformatica.changeAluno(posicao, novoAluno);
        } while (opcaoUtilizador > 0 && opcaoUtilizador <= 6);
    }

    public static void criarfrequencia(EscolaInformatica escolaInformatica, Disciplina disciplina) {
        Frequencia novaFrequencia = new Frequencia();
        int posDisciplinaIdFreq = escolaInformatica.devolvePosDisc(disciplina.getNomDisc());
        escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().add(novaFrequencia);

        int verificaExistenciaFreq = -1, verificaExistenciaProf = -1, idFreq = 0, NTotalPerguntas;
        float cotacao;
        String dific, pergunta, nomeProf;
        ArrayList<Pessoa> Professores = identProf(escolaInformatica.getPessoasEscola());

        novaFrequencia.setDisc(disciplina);

        do {
            if (verificaExistenciaFreq == -1)
                System.out.print("\nID da Frequência: ");
            else
                System.out.print("Esse ID já existe! Por favor, escolha outro: ");
            idFreq = Ler.umInt();
            verificaExistenciaFreq = escolaInformatica.devolvePosDisciplinaDaFreq(idFreq);
        } while (verificaExistenciaFreq != -1);
        novaFrequencia.setid(idFreq);

        System.out.print("\nData da frequência: ");
        LocalDate dataFrequencia = pedeData();
        novaFrequencia.setdatafreq(dataFrequencia);

        ArrayList<Pessoa> listaProfsEscola = identProf(escolaInformatica.getPessoasEscola());
        System.out.println("\nProfessores existentes na escola:");
        for (int i = 0; i < listaProfsEscola.size(); i++)
            System.out.println(" " + i + ". " + listaProfsEscola.get(i).getNome());
        System.out.print("\nEscolha um professor pelo nome: ");
        nomeProf = Ler.umaString();
        verificaExistenciaProf = escolaInformatica.devolvePosProf(nomeProf, Professores);
        while (verificaExistenciaProf == -1) {
            System.out.print("Lamento, mas este professor não existe! Escolha outro: ");
            nomeProf = Ler.umaString();
            verificaExistenciaProf = escolaInformatica.devolvePosProf(nomeProf, Professores);
        }
        novaFrequencia.setProfessorResponsavel((Professor) Professores.get(verificaExistenciaProf));

        System.out.print("\nNumero Total de Perguntas: ");
        NTotalPerguntas = Ler.umInt();
        novaFrequencia.setNumPergTotal(NTotalPerguntas);
        while (NTotalPerguntas <= 0) {
            System.out.print("Insira um número de perguntas válido: ");
            NTotalPerguntas = Ler.umInt();
        }
        novaFrequencia.setNumPergTotal(NTotalPerguntas);

        System.out.println("\n------------------------------------------------");
        int posFreq = escolaInformatica.devolvePosFrequenciaDaListaFreqDeUmaDisciplina(idFreq, disciplina.getNomDisc());
        for (int i = 0; i < NTotalPerguntas; i++) {
            System.out.print("\nDigite a cotação: ");
            cotacao = Ler.umInt();
            System.out.print("\nDigite a pergunta: ");
            pergunta = Ler.umaString();
            Perguntas questao = new Perguntas(cotacao, pergunta);
            escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(posFreq)
                    .getlistperg().add(questao);
        }

        System.out.println("\n------------------------------------------------");
        System.out.print("\nDificuldade: ");
        dific = Ler.umaString();
        novaFrequencia.setdificuldadec(dific);
    }

    public static void consultarFrequencia(EscolaInformatica escolaInformatica, int idFreq, int posDisciplinaFreq,
            int posFrequencialistaFreq) {
        int opcaomenuconsulFreq;
        do {
            limpaTela();
            System.out.println("\nCONSULTAR DADOS DA FREQUÊNCIA DE "
                    + escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getNomDisc() + " COM O ID "
                    + idFreq + ":\n");
            System.out.println(
                    " 1. Data da Frequência\n 2. Professor Responsável\n 3. Número Total de Perguntas\n 4. Conjunto de Perguntas\n 5. Dificuldade da Frequência\n 0. Voltar");
            System.out.print("\n Opcão -> ");
            opcaomenuconsulFreq = Ler.umInt();
            while (opcaomenuconsulFreq < 0 || opcaomenuconsulFreq > 5) {
                System.out.print("Introduza uma opção válida -> ");
                opcaomenuconsulFreq = Ler.umInt();
            }
            limpaTela();
            switch (opcaomenuconsulFreq) {
                case 1:
                    System.out.println("Data da Frequência: " + escolaInformatica.getDisciplinaEscola()
                            .get(posDisciplinaFreq).getListFreq().get(posFrequencialistaFreq).getdatefreq());
                    pedeTecla();
                    break;
                case 2:
                    System.out.println(
                            "Professor Responsável: " + escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq)
                                    .getListFreq().get(posFrequencialistaFreq).getProfessorResponsavel().getNome());
                    pedeTecla();
                    break;
                case 3:
                    System.out.println("Número Total de Perguntas: " + escolaInformatica.getDisciplinaEscola()
                            .get(posDisciplinaFreq).getListFreq().get(posFrequencialistaFreq).getNumPergTotal());
                    pedeTecla();
                    break;
                case 4:
                    listaPerguntas(escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq()
                            .get(posFrequencialistaFreq).getlistperg());
                    pedeTecla();
                    break;
                case 5:
                    System.out.println("Dificuldade da Frequência: " + escolaInformatica.getDisciplinaEscola()
                            .get(posDisciplinaFreq).getListFreq().get(posFrequencialistaFreq).getdificuldade());
                    pedeTecla();
                    break;
            }
        } while (opcaomenuconsulFreq > 0 && opcaomenuconsulFreq <= 5);
    }

    public static Frequencia modFrequencia(EscolaInformatica escolaInformatica, int idFreq1, int posDisciplinaIdFreq,
            int posFrequencia) {
        int numQuestao;
        int opcaomodFreq;
        int opcaomodPerg;
        String respContinuar;
        float novcotacao;
        int opcaomenulistaPerg;
        Frequencia modificarFrequencia = escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                .get(posFrequencia);
        modificarFrequencia.setDisc(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq));
        int verificaExistenciaFreq = -1, verificaExistenciaProf = -1, idFreq = 0, NTotalPerguntas;
        String novocont, pergunta, nomeProf, dif;
        ArrayList<Pessoa> Professores = identProf(escolaInformatica.getPessoasEscola());
        do {
            limpaTela();
            System.out.println("MENU MODIFICAÇÕES FREQUÊNCIA DE "
                    + escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getNomDisc() + " com o ID "
                    + escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(posFrequencia)
                            .getid()
                    + "\n");
            System.out.println(
                    " 1. ID da Frequência\n 2. Data da Frequência\n 3. Professor Responsável\n 4. Número Total de Perguntas\n 5. Perguntas\n 6. Dificuldade\n 0. Voltar");
            System.out.print("\n Opção -> ");
            opcaomodFreq = Ler.umInt();
            while (opcaomodFreq < 0 || opcaomodFreq > 6) {
                System.out.print("Digite uma opção VÁLIDA: ");
                opcaomodFreq = Ler.umInt();
            }
            limpaTela();
            switch (opcaomodFreq) {
                case 1:
                    do {
                        if (verificaExistenciaFreq == -1)
                            System.out.print("ID da Frequência: ");
                        else
                            System.out.print("Esse ID já existe! Por favor, escolha outro: ");
                        idFreq = Ler.umInt();
                        verificaExistenciaFreq = escolaInformatica.devolvePosDisciplinaDaFreq(idFreq);
                    } while (verificaExistenciaFreq != -1);
                    modificarFrequencia.setid(idFreq);
                    pedeTecla();
                    break;
                case 2:
                    System.out.print("\nData da frequência: ");
                    LocalDate dataFrequencia = pedeData();
                    modificarFrequencia.setdatafreq(dataFrequencia);
                    pedeTecla();
                    break;
                case 3:
                    System.out.print("\nProfessor Responsável: ");
                    nomeProf = Ler.umaString();
                    verificaExistenciaProf = escolaInformatica.devolvePosProf(nomeProf, Professores);
                    while (verificaExistenciaProf == -1) {
                        System.out.print("Lamento, mas este professor não existe! Escolha outro: ");
                        nomeProf = Ler.umaString();
                        verificaExistenciaProf = escolaInformatica.devolvePosProf(nomeProf, Professores);
                    }
                    modificarFrequencia.setProfessorResponsavel((Professor) Professores.get(verificaExistenciaProf));
                    break;
                case 4:
                    System.out.print("\nNúmero Total de Perguntas: ");
                    NTotalPerguntas = Ler.umInt();
                    modificarFrequencia.setNumPergTotal(NTotalPerguntas);
                    while (NTotalPerguntas <= 0) {
                        System.out.print("Insira um número de perguntas válido: ");
                        NTotalPerguntas = Ler.umInt();
                    }
                    modificarFrequencia.setNumPergTotal(NTotalPerguntas);
                    pedeTecla();
                    break;
                case 5:
                    do {
                        limpaTela();
                        System.out.println("->  MENU MODIFICAR LISTA PERGUNTAS\n");

                        System.out.println(
                                "1. Adicionar Pergunta\n2. Remover Pergunta\n3. Modificar Pergunta\n4. Voltar");
                        System.out.print("Opção -> ");
                        opcaomenulistaPerg = Ler.umInt();
                        while (opcaomenulistaPerg < 1 || opcaomenulistaPerg > 4) {
                            System.out.print("Digite uma opção válida: ");
                            opcaomenulistaPerg = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaomenulistaPerg) {
                            case 1:
                                if (escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                        .get(posFrequencia).getlistperg().size() == escolaInformatica
                                                .getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                                .get(posFrequencia).getNumPergTotal())
                                    System.out.println(
                                            "Impossível adicionar mais perguntas. Para isso tem de alterar o número total de perguntas.");
                                else {
                                    do {
                                        System.out.print("\nDigite a cotação: ");
                                        novcotacao = Ler.umInt();
                                        System.out.print("\nDigite a pergunta: ");
                                        pergunta = Ler.umaString();
                                        Perguntas questao = new Perguntas(novcotacao, pergunta);
                                        escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                                .get(posFrequencia).getlistperg().add(questao);
                                        System.out.print("\nDeseja continuar? Se sim, digite [S] senão digite [N]:");
                                        respContinuar = Ler.umaString();
                                    } while ((respContinuar == "S" || respContinuar == "s") && (escolaInformatica
                                            .getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                            .get(posFrequencia).getlistperg().size() == escolaInformatica
                                                    .getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                                    .get(posFrequencia).getNumPergTotal()));
                                }
                                pedeTecla();
                                break;
                            case 2:
                                listaPerguntas(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq)
                                        .getListFreq().get(posFrequencia).getlistperg());
                                do {
                                    System.out.print("Número da Pergunta que deseja remover: ");
                                    numQuestao = Ler.umInt();
                                    for (int i = 0; i < escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq)
                                            .getListFreq().get(posFrequencia).getlistperg().size(); i++)
                                        escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                                .get(posFrequencia).getlistperg().remove(i - 1);
                                    System.out.print("\nDeseja continuar? Se sim, digite [S] senão digite [N]: ");
                                    respContinuar = Ler.umaString();
                                } while (respContinuar == "S" || respContinuar == "s");
                                pedeTecla();
                                break;
                            case 3:
                                do {
                                    limpaTela();
                                    listaPerguntas(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq)
                                            .getListFreq().get(posFrequencia).getlistperg());
                                    System.out.print("Número da Pergunta que deseja modificar: ");
                                    numQuestao = Ler.umInt();

                                    System.out.print("\nDigite a cotação: ");
                                    novcotacao = Ler.umInt();
                                    System.out.print("\nDigite a pergunta: ");
                                    pergunta = Ler.umaString();
                                    Perguntas questao = new Perguntas(novcotacao, pergunta);
                                    escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                            .get(posFrequencia).getlistperg().set(numQuestao - 1, questao);

                                    System.out.print("\nDeseja continuar? Se sim, digite [S] senão digite [N]: ");
                                    respContinuar = Ler.umaString();
                                } while (respContinuar.equals("S") || respContinuar.equals("s"));
                                break;
                        }
                    } while (opcaomenulistaPerg > 0 && opcaomenulistaPerg < 4);
                    break;
                case 6:
                    System.out.print("\nDificuldade: ");
                    dif = Ler.umaString();
                    modificarFrequencia.setdificuldadec(dif);
                    pedeTecla();
                    break;
            }
        } while (opcaomodFreq > 0 && opcaomodFreq <= 6);
        return modificarFrequencia;
    }

    public static int menuDisciplinasFreq(EscolaInformatica escolaInformatica) {
        int opmenudiscFreq = 0;
        System.out.println("Disciplinas da " + escolaInformatica.getNomeEscola());
        for (int i = 0; i < escolaInformatica.getDisciplinaEscola().size(); i++) {
            System.out.println(i + 1 + ". " + escolaInformatica.getDisciplinaEscola().get(i).getNomDisc());
        }
        System.out.print("\nNúmero da Disciplina da Frequência: -> ");
        opmenudiscFreq = Ler.umInt();
        while (opmenudiscFreq < 0 || opmenudiscFreq > escolaInformatica.getDisciplinaEscola().size()
                || escolaInformatica.getDisciplinaEscola().get(opmenudiscFreq - 1).getListFreq().isEmpty()) {
            if (escolaInformatica.getDisciplinaEscola().get(opmenudiscFreq - 1).getListFreq().isEmpty()) {
                System.out.print("Esta disciplina não contém frequências, Digite uma opção válida -> ");
                opmenudiscFreq = Ler.umInt();
            } else {
                System.out.print("Digite uma opção VÁLIDA -> ");
                opmenudiscFreq = Ler.umInt();
            }
        }
        return opmenudiscFreq - 1;
    }

    public static ArrayList<Integer> listIdsDisciplina(EscolaInformatica escolaInformatica, int posDisciplinaFreq) {
        ArrayList<Integer> listaIds = new ArrayList<Integer>();
        ArrayList<Frequencia> listaFreq = escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq();
        for (int i = 0; i < listaFreq.size(); i++) {
            listaIds.add(listaFreq.get(i).getid());
        }
        return listaIds;
    }

    public static Professor modificarProfessor(EscolaInformatica escolaInformatica, int posicao) {
        int opcaoUtilizador;
        Professor novoProfessor = (Professor) escolaInformatica.getPessoasEscola().get(posicao);
        do {
            int verificaExistenciaAluno = -1, numProf, ratingProf, escolhaDisc;
            String nomePessoa, tipoContacto, localDeOrigem, email;
            String opcaoContactoMenu = "";
            long numeroContacto;
            ArrayList<Telefone> telefones = new ArrayList<Telefone>();
            Contactos contactosAluno = new Contactos();
            ArrayList<Disciplina> disciplinasP = novoProfessor.getDiscLec();

            System.out.print("\nO que pretende modificar no professor " + novoProfessor.getNome()
                    + "?\n\n 1. Nome\n 2. Local de Origem\n 3. Datas de nascimento\n 4. Telefones\n 5. Email\n 6. Número de Professor\n 7. Rating\n 8. Disciplinas\n\n 0. Nada, desejo sair\n\n Escolha a sua opção --> ");
            opcaoUtilizador = Ler.umInt();

            while (opcaoUtilizador > 8 || opcaoUtilizador < 0) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                opcaoUtilizador = Ler.umInt();
            }
            limpaTela();
            switch (opcaoUtilizador) {
                case 1:
                    do {
                        if (verificaExistenciaAluno == -1)
                            System.out.print("Nome do Professor: ");
                        else
                            System.out.print("Esse nome já existe! Por favor, escolha outro: ");
                        nomePessoa = Ler.umaString();
                        verificaExistenciaAluno = escolaInformatica.devolvePosAluno(nomePessoa,
                                escolaInformatica.getPessoasEscola());
                    } while (verificaExistenciaAluno != -1);
                    novoProfessor.setNome(nomePessoa);
                    pedeTecla();
                    break;
                case 2:
                    System.out.print("\nLocal de Origem do aluno: ");
                    localDeOrigem = Ler.umaString();
                    novoProfessor.setLocalDeOrigem(localDeOrigem);
                    pedeTecla();
                    break;
                case 3:
                    System.out.print("\nData de nascimento - ");
                    LocalDate dataNascimentoAluno = pedeData();
                    novoProfessor.setDataNascimento(dataNascimentoAluno);
                    pedeTecla();
                    break;
                case 4:
                    System.out.println("Telefones");
                    do {
                        System.out.print("\nTipo: ");
                        tipoContacto = Ler.umaString();

                        System.out.print("Número: ");
                        numeroContacto = Ler.umLong();

                        Telefone telefone = new Telefone(tipoContacto, numeroContacto);

                        telefones.add(telefone);

                        System.out.print("Pretende inserir mais telefones? [S/N] -> ");

                        opcaoContactoMenu = Ler.umaString();
                    } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
                    contactosAluno.setTelefone(telefones);
                    novoProfessor.setContactos(contactosAluno);
                    pedeTecla();
                    break;
                case 5:
                    System.out.print("\nEmail do Aluno: ");
                    email = Ler.umaString();
                    contactosAluno.setE_mail(email);
                    novoProfessor.setContactos(contactosAluno);
                    pedeTecla();
                    break;
                case 6:
                    System.out.print("\nNúmero de Professor: ");
                    numProf = Ler.umInt();
                    novoProfessor.setNumProf(numProf);
                    ;
                    System.out.println();
                    pedeTecla();
                    break;
                case 7:
                    System.out.print("\nRating: ");
                    ratingProf = Ler.umInt();
                    novoProfessor.setRating(ratingProf);
                    ;
                    System.out.println();
                    pedeTecla();
                    break;
                case 8:
                    System.out.println("Disciplinas para adicionar ao Professor: ");
                    ArrayList<Integer> adicionados = new ArrayList<Integer>();
                    ArrayList<Disciplina> disciplinasDisponiveis = new ArrayList<Disciplina>();

                    for (int j = 0; j < escolaInformatica.getDisciplinaEscola().size(); j++) {
                        if (!novoProfessor.getDiscLec().contains(escolaInformatica.getDisciplinaEscola().get(j))) {
                            disciplinasDisponiveis.add(escolaInformatica.getDisciplinaEscola().get(j));
                        }
                    }

                    int cont = 0;
                    if (disciplinasDisponiveis.isEmpty() == false) {
                        do {
                            int i = 0;
                            System.out.println("\nDisciplinas Disponíveis (Escolha uma a uma pelo número): ");
                            for (i = 0; i < disciplinasDisponiveis.size(); i++) {
                                if (!adicionados.contains(i))
                                    System.out.println(
                                            i + ". " + disciplinasDisponiveis.get(i).getNomDisc());
                            }
                            System.out.print("\nDisciplina para adicionar ao professor --> ");
                            escolhaDisc = Ler.umInt();
                            while (escolhaDisc < 0 || escolhaDisc > disciplinasDisponiveis.size() - 1
                                    || adicionados.contains(escolhaDisc)) {
                                System.out.println("Disciplina para adicionar ao professor (DIGITE ALGO VÁLIDO)--> ");
                                escolhaDisc = Ler.umInt();
                            }
                            adicionados.add(escolhaDisc);
                            disciplinasP.add(disciplinasDisponiveis.get(escolhaDisc));
                            cont++;
                            System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                            opcaoContactoMenu = Ler.umaString();
                            while (!opcaoContactoMenu.equals("n") && !opcaoContactoMenu.equals("N")
                                    && !opcaoContactoMenu.equals("S") && !opcaoContactoMenu.equals("s")) {
                                System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                                opcaoContactoMenu = Ler.umaString();
                            }
                        } while ((opcaoContactoMenu.equals("s") || opcaoContactoMenu.equals("S"))
                                && cont < disciplinasDisponiveis.size());
                    } else {
                        System.out.println("\nSem disciplinas disponíveis.\n");
                    }
                    if (cont == escolaInformatica.getDisciplinaEscola().size() && !opcaoContactoMenu.equals("n")
                            && !opcaoContactoMenu.equals("N")) {
                        System.out.println("Não é possível adicionar mais disciplinas.");
                    }
                    novoProfessor.setDiscLec(disciplinasP);
                    pedeTecla();
                    break;
            }
            limpaTela();
            if (opcaoUtilizador != 0)
                escolaInformatica.changeProf(posicao, novoProfessor);
        } while (opcaoUtilizador > 0 && opcaoUtilizador <= 8);

        return novoProfessor;
    }

    public static ArrayList<Professor> profcommaisdiscpLecionadas(ArrayList<Professor> profsEscola) {
        ArrayList<Professor> profsComMaisDiscpLec = new ArrayList<>();
        int nmaximodiscp;
        ArrayList<Integer> armazenaNumDiscp = new ArrayList<>();

        for (int i = 0; i < profsEscola.size(); i++) {
            armazenaNumDiscp.add(profsEscola.get(i).contDiscProf());
        }

        nmaximodiscp = Collections.max(armazenaNumDiscp);

        // A função irá devolver a posição do prof que lecione mais disciplinas, caso o
        // máximo tenho mais do que uma correspondecia indica-se os professores com mais
        // disciplinas lecionadas.
        for (int i = 0; i < profsEscola.size(); i++) {
            if (profsEscola.get(i).contDiscProf() == nmaximodiscp) {
                profsComMaisDiscpLec.add(profsEscola.get(i));
            }
        }
        return profsComMaisDiscpLec;
    }

    public static ArrayList<Pessoa> pessoasDeslocadas(EscolaInformatica escolaInformatica) {
        ArrayList<Pessoa> pessoasEscola = escolaInformatica.getPessoasEscola();
        String localizacaoEscola = escolaInformatica.getLocalizacao();
        ArrayList<Pessoa> deslocados = new ArrayList<>();
        for (int i = 0; i < pessoasEscola.size(); i++) {
            if (!pessoasEscola.get(i).getLocalDeOrigem().equals(localizacaoEscola)) {
                deslocados.add(pessoasEscola.get(i));
            }
        }
        return deslocados;
    }

    public static ArrayList<Professor> professorComMelhorRating(ArrayList<Professor> professoresEscola) {
        int melhorRating;
        ArrayList<Professor> profMelhorRating = new ArrayList<>();
        ArrayList<Integer> arrayRatings = new ArrayList<>();
        for (int i = 0; i < professoresEscola.size(); i++) {
            arrayRatings.add(professoresEscola.get(i).getRating());
        }
        melhorRating = Collections.max(arrayRatings);
        for (int i = 0; i < professoresEscola.size(); i++) {
            if (professoresEscola.get(i).getRating() == melhorRating) {
                profMelhorRating.add(professoresEscola.get(i));
            }
        }
        return profMelhorRating;
    }

    public static ArrayList<Pessoa> pessoasMaisVelhas(ArrayList<Pessoa> pessoas) {
        ArrayList<Pessoa> pessoasMaisVelhas = new ArrayList<>();
        int idademaisVelho;
        ArrayList<Integer> idades = new ArrayList<>();
        for (int i = 0; i < pessoas.size(); i++) {
            idades.add(pessoas.get(i).calculaIdade());
        }
        idademaisVelho = Collections.max(idades);
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).calculaIdade() == idademaisVelho) {
                pessoasMaisVelhas.add(pessoas.get(i));
            }
        }
        return pessoasMaisVelhas;

    }

    public static ArrayList<Pessoa> pessoasMaisNovas(ArrayList<Pessoa> pessoas) {
        ArrayList<Pessoa> pessoasMaisNovas = new ArrayList<>();
        int idademaisNovo;
        ArrayList<Integer> idades = new ArrayList<>();
        for (int i = 0; i < pessoas.size(); i++) {
            idades.add(pessoas.get(i).calculaIdade());
        }
        idademaisNovo = Collections.min(idades);
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).calculaIdade() == idademaisNovo) {
                pessoasMaisNovas.add(pessoas.get(i));
            }
        }
        return pessoasMaisNovas;

    }

    public static Curso cursoMaisFrequentado(EscolaInformatica escolaInformatica) {
        Curso cursoMaisFrequentado = new Curso();
        int numAlunos = 0, maior = 0;
        for (int i = 0; i < escolaInformatica.getCursosEscola().size(); i++) {
            numAlunos = escolaInformatica.getCursosEscola().get(i).getAlunosCurso().size();
            if (numAlunos > maior) {
                maior = escolaInformatica.getCursosEscola().get(i).getAlunosCurso().size();
                cursoMaisFrequentado = escolaInformatica.getCursosEscola().get(i);
            }
        }
        return cursoMaisFrequentado;
    }

    public static EscolaInformatica inscreverAlunoEmCurso(EscolaInformatica escolaInformatica,
            String nomeAlunoInscrever, Aluno alunoinscrever) {
        escolaInformatica.listaCursos();
        System.out.print(
                "Dos cursos disponíveis, escolha aquele em que se quer inscrever o aluno " + nomeAlunoInscrever + ": ");
        String CursoInscrever = Ler.umaString();
        int posCurso = escolaInformatica.devolvePosCurso(CursoInscrever);
        if (posCurso == -1) {
            System.out.println("Lamentamos, mas este Curso não existe!\n");
        } else {
            if (!alunoinscrever.getCurso().getNomeCurso().equals(""))
                escolaInformatica.getCursosEscola()
                        .get(escolaInformatica.devolvePosCurso(alunoinscrever.getCurso().getNomeCurso()))
                        .getAlunosCurso().remove(alunoinscrever);
            alunoinscrever.setCurso(escolaInformatica.getCursosEscola().get(posCurso));
            escolaInformatica.getCursosEscola()
                    .get(escolaInformatica.devolvePosCurso(alunoinscrever.getCurso().getNomeCurso())).getAlunosCurso()
                    .add(alunoinscrever);

            System.out.println("Aluno " + nomeAlunoInscrever + " inscrito com sucesso no curso de "
                    + escolaInformatica.getCursosEscola().get(posCurso).getNomeCurso() + ".\n");
            EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
        }
        return escolaInformatica;
    }

    public static Disciplina criarDisciplina(EscolaInformatica escolaInformatica) {
        String numdisc, nomedisc;
        int verificaExistenciadisc = -1;
        do {
            if (verificaExistenciadisc == -1)
                System.out.print("Nome da Disiplina: ");
            else
                System.out.print("Esse nome já existe! Por favor, escolha outro: ");
            nomedisc = Ler.umaString();
            verificaExistenciadisc = escolaInformatica.devolvePosDisc(nomedisc);
        } while (verificaExistenciadisc != -1);
        System.out.print("\nCódigo do Disciplina: ");
        numdisc = Ler.umaString();
        Disciplina novDisciplina = new Disciplina(numdisc, nomedisc);
        return novDisciplina;
    }

    public static Disciplina modificarDisciplina(EscolaInformatica escolaInformatica, int posicao) {
        int opcaoUtilizador;
        do {
            System.out.print("\nO que pretende modificar na disciplina de "
                    + escolaInformatica.getDisciplinaEscola().get(posicao).getNomDisc()
                    + "?\n\n 1. Nome\n 2. Cód.disciplina\n 0. Nada, desejo sair\n\n Escolha a sua opção --> ");
            opcaoUtilizador = Ler.umInt();
            while (opcaoUtilizador > 3 || opcaoUtilizador < 0) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                opcaoUtilizador = Ler.umInt();
            }
            limpaTela();
            switch (opcaoUtilizador) {
                case 1:
                    int verificaExistenciadisc = -1;
                    String nomedisc;
                    do {
                        if (verificaExistenciadisc == -1)
                            System.out.print("Nome da Disciplina: ");
                        else
                            System.out.print("Esse nome já existe! Por favor, escolha outro: ");
                        nomedisc = Ler.umaString();
                        verificaExistenciadisc = escolaInformatica.devolvePosDisc(nomedisc);
                    } while (verificaExistenciadisc != -1);

                    escolaInformatica.getDisciplinaEscola().get(posicao).setNomDisc(nomedisc);
                    System.out.println();
                    pedeTecla();
                    break;
                case 2:
                    String numdisc;
                    System.out.print("\nCódigo da Disciplina: ");
                    numdisc = Ler.umaString();
                    escolaInformatica.getDisciplinaEscola().get(posicao).setNumDisc(numdisc);
                    System.out.println();
                    pedeTecla();
                    break;
            }
            limpaTela();
        } while (opcaoUtilizador > 0 && opcaoUtilizador <= 5);
        return escolaInformatica.getDisciplinaEscola().get(posicao);
    }

    public static ArrayList<Professor> profdasdisciplinas(ArrayList<Professor> profsEscola, String nomediscprof) {
        ArrayList<Professor> profdasdisciplinasLec = new ArrayList<>();
        for (int i = 0; i < profsEscola.size(); i++) {
            for (int j = 0; j < profsEscola.get(i).getDiscLec().size(); j++) {
                // if (profsEscola.get(i).getDiscLec().isEmpty()==false) {
                if (profsEscola.get(i).getDiscLec().get(j).getNomDisc().equals(nomediscprof))
                    profdasdisciplinasLec.add(profsEscola.get(i));
                // }
            }
        }
        return profdasdisciplinasLec;

    }

    public static ArrayList<Professor> profdasdisciplinascont(ArrayList<Professor> profsEscola, String nomediscprof) {
        ArrayList<Professor> profdasdisciplinasLec = new ArrayList<>();
        for (int i = 0; i < profsEscola.size(); i++) {
            for (int j = 0; j < profsEscola.get(i).getDiscLec().size(); j++) {
                // if (profsEscola.get(i).getDiscLec().isEmpty()==false) {
                if (profsEscola.get(i).getDiscLec().get(j).getNomDisc().contains(nomediscprof))
                    profdasdisciplinasLec.add(profsEscola.get(i));
                // }
            }
        }
        return profdasdisciplinasLec;

    }

    public static ArrayList<Aluno> alunosdasdisciplinas(ArrayList<Aluno> alunosEscola, String nomediscalunos) {
        ArrayList<Aluno> alunosdasdisciplinasLec = new ArrayList<>();
        for (int i = 0; i < alunosEscola.size(); i++) {
            for (int j = 0; j < alunosEscola.get(i).getCurso().getDisciplinasCurso().size(); j++) {
                // if (alunosEscola.get(i).getDiscLec().isEmpty()==false) {
                if (alunosEscola.get(i).getCurso().getDisciplinasCurso().get(j).getNomDisc().equals(nomediscalunos))
                    alunosdasdisciplinasLec.add(alunosEscola.get(i));
                // }
            }
        }
        return alunosdasdisciplinasLec;

    }

    public static ArrayList<Aluno> alunosdasdisciplinascont(ArrayList<Aluno> alunosEscola, String nomediscalunos) {
        ArrayList<Aluno> alunosdasdisciplinasLec = new ArrayList<>();
        for (int i = 0; i < alunosEscola.size(); i++) {
            for (int j = 0; j < alunosEscola.get(i).getCurso().getDisciplinasCurso().size(); j++) {
                // if (alunosEscola.get(i).getDiscLec().isEmpty()==false) {
                if (alunosEscola.get(i).getCurso().getDisciplinasCurso().get(j).getNomDisc().contains(nomediscalunos))
                    alunosdasdisciplinasLec.add(alunosEscola.get(i));
                // }
            }
        }
        return alunosdasdisciplinasLec;

    }

    //
    public static void main(String[] args) {
        int opcaoUtilizador;
        limpaTela();
        System.out.print(
                "ESCOLA PROFISSIONAL DE INFORMÁTICA\n\n1. Gerir Escola\n2. Gerir Cursos\n3. Gerir Disciplinas\n4. Gerir Professores\n5. Gerir Alunos\n6. Gerir Frequências\n\n0. Sair\n\nESCOLHA A SUA OPÇÃO -> ");

        EscolaInformatica escolaInformatica = LeEscolaNoFicheiro("escolaInformática.txt");

        opcaoUtilizador = Ler.umInt();
        while (opcaoUtilizador > 6 || opcaoUtilizador < 0) {
            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
            opcaoUtilizador = Ler.umInt();
        }
        while (opcaoUtilizador > 0 && opcaoUtilizador <= 6) {
            switch (opcaoUtilizador) {
                case 1:
                    do {
                        limpaTela();
                        System.out.print(
                                "GERIR ESCOLA\n\n1. Criar Diretor (Removendo automaticamento o anterior)\n2. Modificar dados acerca do atual diretor\n3. Listar Pessoas\n4. Mudar informações acerca da escola (Nome, Número, Contactos, Localização, Email)\n5. Informações da escola\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 5 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Criar novo diretor (Removendo automaticamento o anterior)

                                Diretor diretorCriado = criarDiretor();
                                // Diretor antigo removido da lista de pessoas da escola.
                                removeDiretorDaListaDePessoas(escolaInformatica.getPessoasEscola());
                                // Diretor criado adicionado à lista de pessoas da escola
                                escolaInformatica.getPessoasEscola().add(diretorCriado);
                                // Definir diretor criado como diretor da escola
                                escolaInformatica.setDiretorEscola(diretorCriado);
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println();
                                pedeTecla();
                                break;
                            case 2:
                                // Modificar dados acerca do atual diretor

                                removeDiretorDaListaDePessoas(escolaInformatica.getPessoasEscola());
                                Diretor dirModificado = modDiretor(escolaInformatica);
                                escolaInformatica.getPessoasEscola()
                                        .add(dirModificado);
                                escolaInformatica
                                        .setDiretorEscola(dirModificado);

                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println();
                                break;
                            case 3:
                                // Listar Pessoas
                                listarPessoasEscola(escolaInformatica.getPessoasEscola(), escolaInformatica);
                                break;
                            case 4:
                                // Mudar informações acerca da escola
                                escolaInformatica = modificarEscola(escolaInformatica);
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                break;
                            case 5:
                                // Listar informações sobre a escola
                                System.out.print(escolaInformatica);
                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 5);
                    break;
                case 2:
                    do {
                        limpaTela();
                        System.out.print(
                                " GERIR CURSOS\n\n1. Listar cursos\n2. Criar curso\n3. Consultar informações de determinado curso\n4. Modificar dados sobre um curso\n5. Remover curso\n6. Mostrar curso mais frequentado\n7. Inserir disciplinas de determinado curso\n8. Remover disciplinas de determinado curso\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 8 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Cursos
                                System.out.println("1. LISTAR CURSOS\n");
                                escolaInformatica.listaCursos();
                                pedeTecla();
                                break;
                            case 2:
                                // Criar curso
                                System.out.println("2. CRIAR CURSO\n");
                                escolaInformatica.addCurso(criarCurso(escolaInformatica));
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println("\n-->  Curso criado com sucesso!!\n");
                                pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinado curso
                                String nomeCursoConsultar;
                                int posCurso;
                                System.out.print(
                                        "3. CONSULTAR INFORMAÇÕES SOBRE DETERMINADO CURSO\n\nEscreva o nome do curso que pretende consultar -->  ");
                                nomeCursoConsultar = Ler.umaString();
                                posCurso = escolaInformatica.devolvePosCurso(nomeCursoConsultar);
                                if (posCurso == -1)
                                    System.out.println("Lamentamos, mas este curso não existe!\n");
                                else {
                                    System.out.println(
                                            escolaInformatica.getCursosEscola().get(posCurso).toString() + "\n");
                                }
                                pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre determinado curso
                                String nomeCursomodificar;
                                int posCursoMod;

                                System.out.print(
                                        "4. MODIFICAR DADOS SOBRE DETERMINADO CURSO\n\nEscreva o nome do curso que pretende modificar -->  ");
                                nomeCursomodificar = Ler.umaString();
                                posCursoMod = escolaInformatica.devolvePosCurso(nomeCursomodificar);
                                if (posCursoMod == -1)
                                    System.out.println("Lamentamos, mas este curso não existe!\n");
                                else {
                                    modificarCurso(escolaInformatica, 0);
                                    EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                break;
                            case 5:
                                // Remover Curso
                                String nomeCursoRemover;
                                int opcaoCursos;
                                System.out.print(
                                        "5. REMOVER CURSO\n\n  1. Remover pelo nome\n  2. Remover por palavra contida no nome\n  0. Sair\n\n  ESCOLHA UMA OPCAO --> ");
                                opcaoCursos = Ler.umInt();
                                while (opcaoCursos > 2 || opcaoCursos < 0) {
                                    System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                                    opcaoCursos = Ler.umInt();
                                }
                                limpaTela();
                                boolean sucesso = false;
                                switch (opcaoCursos) {
                                    case 1:
                                        System.out.print(
                                                "1. Remover pelo nome\n\nEscreva o nome do curso que pretende remover -->  ");
                                        nomeCursoRemover = Ler.umaString();
                                        sucesso = escolaInformatica.removeCursoEquals(nomeCursoRemover);
                                        if (sucesso == true) {
                                            EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                            System.out.println("Curso " + nomeCursoRemover + " removido com sucesso.");
                                        } else
                                            System.out.println(
                                                    "Não existe nenhum curso com o nome " + nomeCursoRemover + ".");
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print(
                                                "2. Remover por palavra contida no nome\n\nEscreva o nome do curso que pretende remover -->  ");
                                        nomeCursoRemover = Ler.umaString();
                                        sucesso = escolaInformatica.removeCursoContains(nomeCursoRemover);
                                        if (sucesso == true) {
                                            EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                            System.out.println("Cursos que contêm a palavra " + nomeCursoRemover
                                                    + " removidos com sucesso.");
                                        } else
                                            System.out.println("Não existe nenhum curso que contenha a palavra "
                                                    + nomeCursoRemover + ".");
                                        System.out.println();
                                        break;
                                }
                                pedeTecla();
                                break;
                            case 6:
                                // Mostrar curso mais frequentado
                                System.out.println(
                                        "O curso mais frequentado da " + escolaInformatica.getNomeEscola() + " é:\n");
                                System.out.println(" . " + cursoMaisFrequentado(escolaInformatica).getNomeCurso() + " ("
                                        + cursoMaisFrequentado(escolaInformatica).getAlunosCurso().size()
                                        + " ALUNOS)\n");
                                pedeTecla();
                                break;
                            case 7:
                                // Inserir disciplinas de determinado curso
                                String nomeCursoAddDisc;
                                int posCursoAddDisc;

                                System.out.print(
                                        "7. INSERIR DISCIPLINAS NUM DETERMINADO CURSO\n\nEscreva o nome do curso em que pretende adicionar disciplinas -->  ");
                                nomeCursoAddDisc = Ler.umaString();
                                posCursoAddDisc = escolaInformatica.devolvePosCurso(nomeCursoAddDisc);
                                if (posCursoAddDisc == -1)
                                    System.out.println("Lamentamos, mas este curso não existe!\n");
                                else {
                                    String NomeDiscAdd;
                                    int posdisc;
                                    boolean existeNoCurso = false;
                                    System.out.print(
                                            "Escreva o nome da disciplina que pretende adicionar ao curso "
                                                    + nomeCursoAddDisc + " --> ");
                                    NomeDiscAdd = Ler.umaString();
                                    posdisc = escolaInformatica.devolvePosDisc(NomeDiscAdd);
                                    existeNoCurso = escolaInformatica.verificaSeDisciplinaPertenceCurso(posCursoAddDisc,
                                            NomeDiscAdd);
                                    if (existeNoCurso == true)
                                        System.out.println("Lamentamos, mas esta disciplina já existe neste curso!\n");
                                    else {
                                        escolaInformatica.getCursosEscola().get(posCursoAddDisc).getDisciplinasCurso()
                                                .add(escolaInformatica.getDisciplinaEscola().get(posdisc));
                                        escolaInformatica.atualizaCurso(posCursoAddDisc);
                                        System.out.println(
                                                "Disciplina adicionada a " + nomeCursoAddDisc + " com sucesso!\n");
                                        EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                    }
                                }
                                pedeTecla();
                                break;
                            case 8:
                                String nomeCursoRemDisc;
                                int posCursoRemDisc;

                                System.out.print(
                                        "8. REMOVER DISCIPLINAS NUM DETERMINADO CURSO\n\nEscreva o nome do curso em que pretende remover disciplinas -->  ");
                                nomeCursoRemDisc = Ler.umaString();
                                posCursoRemDisc = escolaInformatica.devolvePosCurso(nomeCursoRemDisc);
                                if (posCursoRemDisc == -1)
                                    System.out.println("Lamentamos, mas este curso não existe!\n");
                                else {
                                    String NomeDiscRem;
                                    int posdisc;
                                    boolean existeNoCurso = false;
                                    System.out.print(
                                            "Escreva o nome da disciplina que pretende remover do curso "
                                                    + nomeCursoRemDisc + " --> ");
                                    NomeDiscRem = Ler.umaString();
                                    posdisc = escolaInformatica.devolvePosDisc(NomeDiscRem);
                                    existeNoCurso = escolaInformatica.verificaSeDisciplinaPertenceCurso(posCursoRemDisc,
                                            NomeDiscRem);
                                    if (existeNoCurso == false)
                                        System.out.println("Lamentamos, mas esta disciplina não existe neste curso!\n");
                                    else {
                                        escolaInformatica.getCursosEscola().get(posCursoRemDisc).getDisciplinasCurso()
                                                .remove(escolaInformatica.getDisciplinaEscola().get(posdisc));
                                        escolaInformatica.atualizaCurso(posCursoRemDisc);
                                        System.out.println(
                                                "Disciplina removida de " + nomeCursoRemDisc + " com sucesso!\n");
                                        EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                    }
                                }
                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 8);
                    break;
                case 3:
                    do {
                        limpaTela();
                        System.out.print(
                                "GERIR DISCIPLINAS\n\n1. Listar disciplinas\n2. Criar disciplina\n3. Consultar informações de determinada disciplina\n4. Modificar dados sobre uma disciplina\n5. Remover disciplina\n6. Mostrar professor que lecionou mais disciplinas\n7. Mostrar professores deslocados\n8. Mostrar qual é o professore com melhor rating\n9. Mostrar professor mais velho e mais novo\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 8 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Disciplinas
                                System.out.print("1. LISTAR Disciplinas\n");
                                escolaInformatica.listaDisciplinas();
                                pedeTecla();
                                break;
                            case 2:
                                // Criar Disciplina
                                System.out.print("2. Disciplinas\n");
                                escolaInformatica.getDisciplinaEscola().add(criarDisciplina(escolaInformatica));
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println("\n-->  disciplina criado com sucesso!!\n");
                                pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinada disciplina
                                String NomeDiscConsultar;
                                int posdisc;
                                System.out.print(
                                        "3. CONSULTAR INFORMAÇÕES SOBRE DETERMINADA DISCIPLINA\n\nEscreva o nome da disciplina que pretende consultar --> ");
                                NomeDiscConsultar = Ler.umaString();
                                posdisc = escolaInformatica.devolvePosDisc(NomeDiscConsultar);
                                if (posdisc == -1)
                                    System.out.println("Lamentamos, mas este disciplina não existe!\n");
                                else {
                                    System.out.println(
                                            escolaInformatica.getDisciplinaEscola().get(posdisc).toString() + "\n");
                                }
                                pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma determinada disciplina
                                String nomediscmodificar;
                                int posdiscmod;
                                System.out.print(
                                        "MODIFICAR DADOS SOBRE UMA DETERMINADA DISCIPLINA\n\nEscreva o nome da disciplina que pretende modificar -->  ");
                                nomediscmodificar = Ler.umaString();
                                posdiscmod = escolaInformatica.devolvePosDisc(nomediscmodificar);
                                if (posdiscmod == -1)
                                    System.out.println("Lamentamos, mas esta disciplina não existe!\n");
                                else {
                                    modificarDisciplina(escolaInformatica, posdiscmod);
                                    EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                break;
                            case 5:
                                // Remover disciplina
                                String nomeDiscRemover;
                                int opcaodisc;
                                System.out.print(
                                        "5. REMOVER DISCIPLINA\n\n  1. Remover pelo nome\n  2. Remover por palavra contida no nome\n  0. Sair\n\n  ESCOLHA UMA OPCAO --> ");
                                opcaodisc = Ler.umInt();
                                while (opcaodisc > 2 || opcaodisc < 0) {
                                    System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                                    opcaodisc = Ler.umInt();
                                }
                                limpaTela();
                                boolean sucesso = false;
                                switch (opcaodisc) {
                                    case 1:
                                        System.out.print(
                                                "1. Remover pelo nome\n\nEscreva o nome da Disciplina que pretende remover -->  ");
                                        nomeDiscRemover = Ler.umaString();
                                        sucesso = escolaInformatica.removeDiscEquals(nomeDiscRemover);
                                        if (sucesso == true) {
                                            EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                            System.out.println(
                                                    "Disciplina " + nomeDiscRemover + " removido com sucesso.");
                                        } else
                                            System.out.println(
                                                    "Não existe nenhuma disciplina com o nome " + nomeDiscRemover
                                                            + ".");
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print(
                                                "2. Remover por palavra contida no nome\n\nEscreva o nome da Disciplina que pretende remover -->  ");
                                        nomeDiscRemover = Ler.umaString();
                                        sucesso = escolaInformatica.removediscContains(nomeDiscRemover);
                                        if (sucesso == true) {
                                            EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                            System.out.println("Disciplina que contêm a palavra " + nomeDiscRemover
                                                    + " removida com sucesso.");
                                        } else
                                            System.out.println("Não existe nenhuma disciplina que contenha a palavra "
                                                    + nomeDiscRemover + ".");
                                        System.out.println();
                                        break;
                                }
                                pedeTecla();
                                break;
                            case 6:
                                // Mostrar a disciplina com a frequência mais longa

                                pedeTecla();
                                break;
                            case 7:
                                // Mostrar professores que lecionam determianda disciplina
                                String nomeDiscprof = "";
                                int opcaodiscprof;
                                ArrayList<Professor> discescolaprof = convPessoaProf(
                                        identProf(escolaInformatica.getPessoasEscola()));
                                System.out.print(
                                        "5. Professores de uma determinada Disciplina\n\n  1. Pelo nome da Disciplina\n  2. Por uma palavra contida no nome da Disciplina\n  0. Sair\n\n  ESCOLHA UMA OPCAO --> ");
                                opcaodiscprof = Ler.umInt();
                                while (opcaodiscprof > 2 || opcaodiscprof < 0) {
                                    System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                                    opcaodiscprof = Ler.umInt();
                                }
                                limpaTela();
                                boolean sucesso1 = false;
                                switch (opcaodiscprof) {
                                    case 1:
                                        System.out.print(
                                                "1. Pelo nome da Disciplina\n\nEscreva o nome da Disciplina que pretende -->  ");
                                        nomeDiscprof = Ler.umaString();
                                        sucesso1 = escolaInformatica.profDiscEquals(nomeDiscprof);
                                        if (sucesso1 == true) {
                                            ArrayList<Professor> ArrayResultadosdiscProf = profdasdisciplinas(
                                                    discescolaprof, nomeDiscprof);
                                            System.out.println("Professores de " + nomeDiscprof + ":\n"
                                                    + ArrayResultadosdiscProf);
                                        } else
                                            System.out.println(
                                                    "Não existe nenhum disciplina com o nome " + nomeDiscprof + ".");
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print(
                                                "2. Pela palavra contida no nome\n\nEscreva o nome da Disciplina que pretende -->  ");
                                        nomeDiscprof = Ler.umaString();
                                        sucesso1 = escolaInformatica.discprofContains(nomeDiscprof);
                                        if (sucesso1 == true) {
                                            ArrayList<Professor> ArrayResultadosdiscProfcont = profdasdisciplinascont(
                                                    discescolaprof, nomeDiscprof);
                                            System.out.println("Professores da Disciplina que contêm a palavra "
                                                    + nomeDiscprof + ":\n" + ArrayResultadosdiscProfcont);
                                        } else
                                            System.out.println("Não existe nenhuma disciplina que contenha a palavra "
                                                    + nomeDiscprof + ".");
                                        System.out.println();
                                        break;
                                }
                                pedeTecla();
                                break;
                            // alterar prints funçao prof contem diciplina
                            case 8:
                                // Mostrar alunos inscritos em determinada disciplina
                                String nomeDiscalunos = "";
                                int opcaodiscalunos;
                                ArrayList<Aluno> discescolaalunos = convPessoaAluno(
                                        identAluno(escolaInformatica.getPessoasEscola()));
                                System.out.print(
                                        "5. Alunos de uma determinada Disciplina\n\n  1. Pelo nome da Disciplina\n  2. Por uma palavra contida no nome da Disciplina\n  0. Sair\n\n  ESCOLHA UMA OPCAO --> ");
                                opcaodiscalunos = Ler.umInt();
                                while (opcaodiscalunos > 2 || opcaodiscalunos < 0) {
                                    System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                                    opcaodiscprof = Ler.umInt();
                                }
                                limpaTela();
                                boolean sucesso2 = false;

                                switch (opcaodiscalunos) {
                                    case 1:
                                        System.out.print(
                                                "1. Pelo nome da Disciplina\n\nEscreva o nome da Disciplina que pretende -->  ");
                                        nomeDiscalunos = Ler.umaString();
                                        sucesso2 = escolaInformatica.alunosDiscEquals(nomeDiscalunos);
                                        if (sucesso2 == true) {
                                            ArrayList<Aluno> arrayResultadosdiscalunos = alunosdasdisciplinas(
                                                    discescolaalunos, nomeDiscalunos);
                                            System.out.println("Alunos de " + nomeDiscalunos + ":\n"
                                                    + arrayResultadosdiscalunos.get(0).getNome());
                                        } else
                                            System.out.println(
                                                    "Não existe nenhum disciplina com o nome " + nomeDiscalunos + ".");
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print(
                                                "2. Pela palavra contida no nome\n\nEscreva o nome da Disciplina que pretende -->  ");
                                        nomeDiscalunos = Ler.umaString();
                                        sucesso2 = escolaInformatica.discalunosContains(nomeDiscalunos);
                                        if (sucesso2 == true) {
                                            ArrayList<Aluno> arrayResultadosdiscalunoscont = alunosdasdisciplinascont(
                                                    discescolaalunos, nomeDiscalunos);
                                            System.out.println(
                                                    "Alunos da Disciplina que contêm a palavra " + nomeDiscalunos
                                                            + ":\n" + arrayResultadosdiscalunoscont.get(0).getNome());
                                        } else
                                            System.out.println("Não existe nenhuma disciplina que contenha a palavra "
                                                    + nomeDiscalunos + ".");
                                        System.out.println();
                                        break;
                                }
                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 8);
                    break;
                case 4:
                    do {
                        limpaTela();
                        System.out.print(
                                "GERIR PROFESSORES\n\n1. Listar professores\n2. Criar professor\n3. Consultar informações de determinado professor\n4. Modificar dados sobre um determinado professor\n5. Remover professor\n6. Mostrar professor que lecionou mais disciplinas\n7. Mostrar professores deslocados\n8. Mostrar qual é o professor com melhor rating\n9. Mostrar professor mais velho e mais novo\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 9 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        ArrayList<Pessoa> profsDaEscola;
                        ArrayList<Professor> professoresEscolaDisc;
                        ArrayList<Professor> professoresEscolaRating;
                        ArrayList<Professor> profscomMelhorRating;
                        ;
                        switch (opcaoUtilizador) {
                            case 1:
                                profsDaEscola = identProf(escolaInformatica.getPessoasEscola());
                                // Listar Professores
                                for (int i = 0; i < profsDaEscola.size(); i++) {
                                    listaumProf((Professor) profsDaEscola.get(i));
                                }
                                pedeTecla();
                                break;
                            case 2:
                                // Criar Professor
                                Professor novoProf = criaProfessor(escolaInformatica);
                                escolaInformatica.getPessoasEscola().add(novoProf);
                                escolaInformatica.insereProfNasSuasDisciplinas(novoProf);
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinado professor
                                String nomeProfConsultar;
                                int posProf;
                                profsDaEscola = identProf(escolaInformatica.getPessoasEscola());
                                System.out.print(
                                        "3. CONSULTAR INFORMAÇÕES SOBRE DETERMINADO PROFESSOR\n\nEscreva o nome do professor que pretende consultar -->  ");
                                nomeProfConsultar = Ler.umaString();
                                posProf = escolaInformatica.devolvePosProf(nomeProfConsultar, profsDaEscola);
                                if (posProf == -1)
                                    System.out.println("Lamentamos, mas este professor não existe!\n");
                                else {
                                    System.out.println();
                                    listaumProf((Professor) profsDaEscola.get(posProf));
                                }
                                pedeTecla();
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
                                    pedeTecla();
                                } else {
                                    professorModificado = modificarProfessor(escolaInformatica, posProf);
                                    escolaInformatica.removeProfNasSuasDisciplinas(professorModificado);
                                    escolaInformatica.insereProfNasSuasDisciplinas(professorModificado);
                                    EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
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
                                    EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                pedeTecla();
                                break;
                            case 6:
                                // Mostrar professores com mais disciplinas lecionadas
                                professoresEscolaDisc = convPessoaProf(identProf(escolaInformatica.getPessoasEscola()));
                                ArrayList<Professor> professorMaisDiscLec = convPessoaProf(
                                        identProf(escolaInformatica.getPessoasEscola()));
                                ArrayList<Professor> ArrayResultadosProf = profcommaisdiscpLecionadas(
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
                                pedeTecla();
                                break;
                            case 7:
                                // Mostrar professores deslocados
                                ArrayList<Pessoa> pessoasDeslocadas = pessoasDeslocadas(escolaInformatica);
                                ArrayList<Professor> professoresEscolaDeslocados = convPessoaProf(
                                        identProf(pessoasDeslocadas));
                                System.out.println("PROFESSORES DESLOCADOS\n");
                                for (int i = 0; i < professoresEscolaDeslocados.size(); i++)
                                    System.out.println(" . " + professoresEscolaDeslocados.get(i).getNome() + " ("
                                            + professoresEscolaDeslocados.get(i).getLocalDeOrigem() + ")");
                                System.out.println();
                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar professores com melhor rating
                                professoresEscolaRating = convPessoaProf(
                                        identProf(escolaInformatica.getPessoasEscola()));
                                profscomMelhorRating = professorComMelhorRating(professoresEscolaRating);
                                professoresEscolaDisc = convPessoaProf(identProf(escolaInformatica.getPessoasEscola()));
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
                                pedeTecla();
                                break;
                            case 9:
                                // Mostrar professores mais velhos e mais novos
                                ArrayList<Pessoa> professores = identProf(escolaInformatica.getPessoasEscola());
                                ArrayList<Professor> profMaisVelhos = convPessoaProf(
                                        identProf(pessoasMaisVelhas(professores)));
                                ArrayList<Professor> profMaisNovos = convPessoaProf(
                                        identProf(pessoasMaisNovas(professores)));

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
                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 9);
                    break;
                case 5:
                    do {
                        limpaTela();
                        System.out.print(
                                "GERIR ALUNOS\n\n1. Listar alunos\n2. Criar aluno\n3. Consultar informações de determinado aluno\n4. Modificar dados sobre um determinado aluno\n5. Remover aluno\n6. Atribuir notas a alunos\n7. Inscrever aluno em curso\n8. Mostrar alunos deslocados\n9. Mostrar aluno mais velho e mais novo\n10. Mostrar aluno com melhor e pior média, de determinado curso\n11. Mostrar aluno com melhor nota, numa determinada frequência\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 11 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        ArrayList<Pessoa> alunosDaEscola = identAluno(escolaInformatica.getPessoasEscola());
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Alunos
                                for (int i = 0; i < alunosDaEscola.size(); i++)
                                    listaumAluno((Aluno) alunosDaEscola.get(i));
                                pedeTecla();
                                break;
                            case 2:
                                // Criar Alunos
                                Aluno novoAluno = criarAluno(escolaInformatica);
                                escolaInformatica.insereAlunoNasSuasDisciplinas(novoAluno);
                                escolaInformatica.getPessoasEscola().add(novoAluno);
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinado aluno
                                String nomeAlunoConsultar;
                                int posAluno;
                                alunosDaEscola = identAluno(escolaInformatica.getPessoasEscola());
                                System.out.print(
                                        "3. CONSULTAR INFORMAÇÕES SOBRE DETERMINADO ALUNO\n\nEscreva o nome do aluno que pretende consultar -->  ");
                                nomeAlunoConsultar = Ler.umaString();
                                posAluno = escolaInformatica.devolvePosAluno(nomeAlunoConsultar, alunosDaEscola);
                                if (posAluno == -1)
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                else {
                                    System.out.println();
                                    listaumAluno((Aluno) alunosDaEscola.get(posAluno));
                                }
                                pedeTecla();
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
                                    pedeTecla();
                                } else {
                                    modificarAluno(escolaInformatica, posAluno);
                                    EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
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
                                    EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                pedeTecla();
                                break;
                            case 6:
                                // Atribuir notas a alunos

                                pedeTecla();
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
                                        inscreverAlunoEmCurso(escolaInformatica, nomeAlunoInscrever, alunoinscrever);
                                        escolaInformatica.insereAlunoNasSuasDisciplinas(alunoinscrever);
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
                                            inscreverAlunoEmCurso(escolaInformatica, nomeAlunoInscrever,
                                                    alunoinscrever);
                                            escolaInformatica.insereAlunoNasSuasDisciplinas(alunoinscrever);
                                        }
                                    }
                                }
                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar alunos não deslocados
                                ArrayList<Pessoa> pessoasDeslocadas = pessoasDeslocadas(escolaInformatica);
                                ArrayList<Aluno> alunosEscolaDeslocados = convPessoaAluno(
                                        identAluno(pessoasDeslocadas));
                                System.out.println("ALUNOS DESLOCADOS\n");
                                for (int i = 0; i < alunosEscolaDeslocados.size(); i++)
                                    System.out.println(" . " + alunosEscolaDeslocados.get(i).getNome() + " ("
                                            + alunosEscolaDeslocados.get(i).getLocalDeOrigem() + ")");
                                System.out.println();
                                pedeTecla();
                                break;
                            case 9:
                                // Mostrar aluno mais velho e mais novo
                                ArrayList<Pessoa> alunos = identAluno(escolaInformatica.getPessoasEscola());
                                ArrayList<Aluno> alunoMaisVelhos = convPessoaAluno(
                                        identAluno(pessoasMaisVelhas(alunos)));
                                ArrayList<Aluno> alunoMaisNovos = convPessoaAluno(identAluno(pessoasMaisNovas(alunos)));

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
                                pedeTecla();
                                break;
                            case 10:
                                // Mostrar aluno com melhor e pior média, de determinado curso

                                pedeTecla();
                                break;
                            case 11:
                                // Mostrar aluno com melhor nota, numa determinada frequência

                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 11);
                    break;
                case 6:
                    do {
                        limpaTela();
                        System.out.print(
                                "GERIR FREQUÊNCIAS\n\n1. Listar Frequências de determinada disciplina\n2. Criar Frequência\n3. Mostrar determinada frequência, dado o ID da mesma\n4. Modificar dados sobre uma Frequência\n5. Remover Frequência\n6. Mostrar a pergunta com maior cotação, de determinada frequência\n7. Mostrar frequências por nível de dificuldade\n8. Mostrar frequências elaboradas por determinado professor\n9. Mostrar frequências de determinado curso\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 9 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Frequências de determinada disciplina
                                String nomediscp;
                                int posdisc;
                                System.out.println("1. LISTAR FREQUÊNCIAS DE DETERMINADA DISCIPLINA\n");
                                System.out.print("Introduza o nome da disciplina: ");
                                nomediscp = Ler.umaString();
                                posdisc = escolaInformatica.devolveposDisc(nomediscp);
                                if (posdisc == -1)
                                    System.out.println("Lamento, mas esta disciplina não existe!\n");
                                else {
                                    ArrayList<Frequencia> listaFreqDisc = escolaInformatica.getDisciplinaEscola()
                                            .get(posdisc).getListFreq();
                                    for (int i = 0; i < listaFreqDisc.size(); i++)
                                        listaumaFreq(listaFreqDisc.get(i));
                                }
                                pedeTecla();
                                break;
                            case 2:
                                // Criar Frequência
                                ArrayList<Pessoa> profsDaEscola = identProf(escolaInformatica.getPessoasEscola());
                                if (profsDaEscola.isEmpty())
                                    System.out.println(
                                            "Não é possível criar Frequências pois ainda não há professores inscritos!\n");
                                else {
                                    int verificaExistenciaDisc = -1;
                                    Disciplina disciplinaDaFreq = new Disciplina();
                                    System.out.println("2. CRIAR FREQUÊNCIA\n");

                                    if (!escolaInformatica.getDisciplinaEscola().isEmpty()) {
                                        System.out.print("\nDisciplina disponíveis na escola: ");
                                        escolaInformatica.listaDisciplinas();

                                        System.out.print("\nDisciplina para a qual pretende criar uma frequência: ");
                                        nomediscp = Ler.umaString();
                                        verificaExistenciaDisc = escolaInformatica.devolveposDisc(nomediscp);
                                        while (verificaExistenciaDisc == -1) {
                                            System.out
                                                    .print("Lamento, mas esta disciplina não existe! Escolha outra: ");
                                            nomediscp = Ler.umaString();
                                            verificaExistenciaDisc = escolaInformatica.devolveposDisc(nomediscp);
                                        }

                                        disciplinaDaFreq = escolaInformatica.devolveDisciplina(nomediscp);

                                        criarfrequencia(escolaInformatica, disciplinaDaFreq);

                                        EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                        System.out.println("\n-->  Frequência criada com sucesso!!\n");
                                    } else
                                        System.out.println(
                                                "Não é possível criar uma frequência pois ainda não existem disciplinas criadas nesta escola.\n");
                                }
                                pedeTecla();
                                break;
                            case 3:
                                int idFreq;
                                int posDisciplinaIdFreq;
                                int posFrequencia = -1;
                                System.out.println("3. CONSULTAR DADOS DE UM FREQUÊNCIA, DADO O SEU ID\n");
                                posDisciplinaIdFreq = menuDisciplinasFreq(escolaInformatica);
                                System.out.print("\nID's das Frequências de "
                                        + escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getNomDisc()
                                        + ": " + listIdsDisciplina(escolaInformatica, posDisciplinaIdFreq));
                                System.out.print("\nIntroduza o ID da frequência que deseja consultar: ");
                                idFreq = Ler.umInt();
                                posFrequencia = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFreq);
                                while (posFrequencia == -1 || posDisciplinaIdFreq == -1) {
                                    System.out.print(
                                            "Introduza o ID da frequência que deseja consultar (DE ENTRE OS VÁLIDOS): ");
                                    idFreq = Ler.umInt();
                                    posFrequencia = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFreq);
                                }
                                consultarFrequencia(escolaInformatica, idFreq, posDisciplinaIdFreq, posFrequencia);

                                break;
                            case 4:
                                int idFreq1;
                                int posicaoDisc, posFrequencianaDisc;
                                System.out.println("4. MODIFICAR DADOS DE UM FREQUÊNCIA, DADO O SEU ID\n");
                                String disciplina;
                                System.out.println("Disciplinas da " + escolaInformatica.getNomeEscola());
                                for (int i = 0; i < escolaInformatica.getDisciplinaEscola().size(); i++) {
                                    System.out.println(
                                            i + 1 + ". " + escolaInformatica.getDisciplinaEscola().get(i).getNomDisc());
                                }
                                System.out.print("\nNome da Disciplina da Frequência que pretende consultar -> ");
                                disciplina = Ler.umaString();
                                posicaoDisc = escolaInformatica.devolvePosDisc(disciplina);
                                while (posicaoDisc == -1) {
                                    System.out
                                            .print("Lamentamos, mas este disciplina não existe! Digite algo válido: ");
                                    disciplina = Ler.umaString();
                                    posicaoDisc = escolaInformatica.devolvePosDisc(disciplina);
                                    ;
                                }

                                System.out.print("\nID's das Frequências de "
                                        + escolaInformatica.getDisciplinaEscola().get(posicaoDisc).getNomDisc() + ": "
                                        + listIdsDisciplina(escolaInformatica, posicaoDisc));
                                System.out.print("\nIntroduza o ID da frequência que deseja modificar: ");
                                idFreq1 = Ler.umInt();
                                posFrequencianaDisc = escolaInformatica
                                        .devolvePosFrequenciaDaListaFreqDeUmaDisciplina(idFreq1, disciplina);
                                while (posFrequencianaDisc == -1) {
                                    System.out.println("Introduza um ID da Frequência VÁLIDO: ");
                                    idFreq1 = Ler.umInt();
                                    posFrequencianaDisc = escolaInformatica
                                            .devolvePosFrequenciaDaListaFreqDeUmaDisciplina(idFreq1, disciplina);
                                }

                                Frequencia modificadaFreq = modFrequencia(escolaInformatica, idFreq1, posicaoDisc,
                                        posFrequencianaDisc);
                                escolaInformatica.getDisciplinaEscola().get(posicaoDisc).getListFreq()
                                        .remove(posFrequencianaDisc);
                                escolaInformatica.getDisciplinaEscola().get(posicaoDisc).getListFreq()
                                        .add(modificadaFreq);
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);

                                break;
                            case 5:
                                // Remover Frequência
                                int posFrequencia2 = -1;
                                int posDisciplinaIdFreq2;
                                System.out.print("5. REMOVER FREQUÊNCIA\n\n");
                                posDisciplinaIdFreq2 = menuDisciplinasFreq(escolaInformatica);
                                System.out.print("Escreva o ID da frequência que pretende remover "
                                        + listIdsDisciplina(escolaInformatica, posDisciplinaIdFreq2) + "-->  ");
                                int idFrequencia = Ler.umInt();
                                posFrequencia2 = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFrequencia);
                                while (posFrequencia2 == -1 || posDisciplinaIdFreq2 == -1) {
                                    System.out.println("Introduza um ID da frequência VÁLIDO: ");
                                    idFrequencia = Ler.umInt();
                                }
                                escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq2).getListFreq()
                                        .remove(posFrequencia2);
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                pedeTecla();
                                break;
                            case 6:
                                // Mostrar a pergunta com maior cotação, de determinada frequência
                                ArrayList<Perguntas> MaioresPerguntaLista = new ArrayList<>();
                                int posFrequencia3 = -1;
                                int posDisciplinaIdFreq3;
                                System.out.print("6. CONSULTAR PERGUNTA COM MAIOR COTAÇÃO\n\n");
                                posDisciplinaIdFreq3 = menuDisciplinasFreq(escolaInformatica);
                                System.out.print(
                                        "\nEscreva o ID da frequência da qual pretende consultar a pergunta com maior cotação "
                                                + listIdsDisciplina(escolaInformatica, posDisciplinaIdFreq3) + "-->  ");
                                int idFrequencia3 = Ler.umInt();
                                posFrequencia3 = escolaInformatica.devolvePosFrequenciaDaListaFreq(idFrequencia3);
                                while (posFrequencia3 == -1 || posDisciplinaIdFreq3 == -1) {
                                    System.out.println("Introduza um ID da frequência VÁLIDO: ");
                                    idFrequencia3 = Ler.umInt();
                                }
                                MaioresPerguntaLista = cotacaoMaior(escolaInformatica, idFrequencia3);
                                if (MaioresPerguntaLista.size() == 0) {
                                    System.out.println("\nAinda não existem perguntas com cotação!");
                                }
                                if (MaioresPerguntaLista.size() == 1) {
                                    System.out.println(
                                            "\nPergunta com maior cotação (" + MaioresPerguntaLista.get(0).getcotaçao()
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
                                pedeTecla();
                                break;
                            case 7:
                                // Mostrar frequências por nível de dificuldade

                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar frequências elaboradas por determinado professor
                                System.out.print("8. Mostrar frequências elaboradas por um professor");
                                System.out.print("\nEscolha o nome do professor: ");
                                String nomeProf = Ler.umaString();
                                int posProf;
                                posProf = escolaInformatica.devolvePosProf(nomeProf,
                                        escolaInformatica.getPessoasEscola());
                                if (posProf == -1) {
                                    System.out.println("Lamentamos, mas este professor não existe!\n");
                                } else {
                                    ArrayList<Frequencia> listaFreqProf = escolaInformatica.getDisciplinaEscola()
                                            .get(posProf).getListFreq();
                                    for (int i = 0; i < listaFreqProf.size(); i++)
                                        listaumaFreq(listaFreqProf.get(i));
                                }
                                pedeTecla();
                                break;
                            case 9:
                                // Mostrar frequências de determinado curso

                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 9);
                    break;
            }
            limpaTela();
            System.out.print(
                    "ESCOLA PROFISSIONAL DE INFORMÁTICA\n\n1. Gerir Escola\n2. Gerir Cursos\n3. Gerir Disciplinas\n4. Gerir Professores\n5. Gerir Alunos\n6. Gerir Frequências\n\n0. Sair\n\nESCOLHA A SUA OPÇÃO -> ");
            opcaoUtilizador = Ler.umInt();
        }

        limpaTela();
        System.out.print("_______________________________________________\n");
        System.out.print(
                "Programa elaborado por:\n\n-> João Martins\n-> Guilherme Teixeira\n-> Cláudio Redondo\n-> Tiago Ribeiro\n\n  POO - Engenharia Informática - UBI ");
        System.out.print("\n_______________________________________________\n");
    }
}
