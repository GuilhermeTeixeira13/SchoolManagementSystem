import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public class funcoesUteis implements Serializable {
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
            os.writeInt(Disciplina.getUltimo());
            os.writeInt(Curso.getUltimo());
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
                int ultDisc = is.readInt();
                Disciplina.setUltimo(ultDisc);
                int ultCurso = is.readInt();
                Curso.setUltimo(ultCurso);
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

    public static boolean verificacaoTelemovel(long numero) {
        String numeroConvString;
        numeroConvString = String.valueOf(numero);
        String pattern = "\\d{9}|(?:\\d{3}-){2}\\d{3}";
        if (numeroConvString.matches(pattern)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verificacaoEmail(String email) {
        boolean verifEmail = false;
        char[] emailA = new char[email.length()];
        emailA = email.toCharArray();
        int posArroba = -1;
        int posPonto = -1;
        // Verifica se o email tem o @ e o .
        if (email.contains("@")) {
            if (email.contains(".")) {
                for (int i = 0; i < emailA.length; i++) {
                    if (emailA[i] == '@') {
                        posArroba = i;
                    }
                    if (emailA[i] == '.') {
                        posPonto = i;
                    }
                }
                // Verifica se o ponto está escrito depois do @
                if (posPonto > posArroba) {
                    verifEmail = true;
                }
            } else {
                verifEmail = false;
            }
        } else {
            verifEmail = false;
        }
        return verifEmail;
    }

    public static boolean verifRating(int rating) {
        if (rating > 0 && rating <= 100) {
            return true;
        } else {
            return false;
        }
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
        System.out.println("Disciplina: " + f.getDisc().getNomDisc());
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
        System.out.println("ID: " + a.getNumAluno());
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
        System.out.println("ID: " + p.getNumProf());
        System.out.println("Contactos:");
        System.out.println("  Email: " + p.getContactos().getE_mail());
        System.out.println("  Telefones: " + p.getContactos().getTelefones());
        System.out.println("Local de Origem: " + p.getLocalDeOrigem());
        System.out.println("Data de Nascimento: " + p.getDataNascimento());
        System.out.println("Rating: " + p.getRating());
        p.listaDisc();
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public static void listaumaDisciplinaProf(Disciplina d) {
        System.out.println("\nNome: " + d.getNomDisc());
        System.out.println("ID:" + d.getNumDisc());
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
                listapessoas = identAluno(pessoasEscola);
                listaPessoasOutput(listapessoas);
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
        // Guarda-se o valor de todas as cotações de uma frequência numa ArrayList.
        for (int i = 0; i < escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq().get(posFreq)
                .getlistperg().size(); i++) {
            cotacaoMaior.add(escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq().get(posFreq)
                    .getlistperg().get(i).getcotaçao());

        }
        // Procura-se o valor da maior cotação através do Collections.max
        maiorValor = Collections.max(cotacaoMaior);
        // Ao procurar a posição da ArrayList cotaçãoMaior onde o número maior está,
        // acede-se também à posição da pergunta na lista de pergunta pois a cada
        // pergunta corresponde uma cotação. Ou seja, a terceira pergunta, presente na
        // posição 2 da lista de perguntas, tem a sua cotação guardada na posição dois
        // da cotacaoMaior.
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
        // Ao encontrar a/as pergunta/as com maior cotação, devolve um array com estas
        // perguntas armazenadas.
        return perguntaMaior;
    }

    public static Diretor criarDiretor() {
        System.out.println("1. CRIAR DIRETOR\n");
        Diretor novodiretor = new Diretor();
        boolean verifTel;
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

            System.out.print("Número (9 digítos todos juntos): ");
            numeroContacto = Ler.umLong();
            verifTel = verificacaoTelemovel(numeroContacto);
            while (verifTel == false) {
                System.out.print("\nIntroduza um número de telemóvel válido: ");
                numeroContacto = Ler.umLong();
                verifTel = verificacaoTelemovel(numeroContacto);
            }

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
        boolean verifEmail = verificacaoEmail(email);
        while (verifEmail == false) {
            System.out.print("\nDigite o email corretamente!! ->  ");
            email = Ler.umaString();
            verifEmail = verificacaoEmail(email);
        }
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

            System.out.print("Número (9 digítos todos juntos): ");
            numeroContactoC = Ler.umLong();
            boolean verifTel = verificacaoTelemovel(numeroContactoC);
            while (verifTel == false) {
                System.out.print("\nIntroduza um número de telemóvel válido: ");
                numeroContactoC = Ler.umLong();
                verifTel = verificacaoTelemovel(numeroContactoC);
            }

            Telefone telefone = new Telefone(tipoContactoC, numeroContactoC);

            telefonesC.add(telefone);

            System.out.print("Pretende inserir mais telefones? [S/N] -> ");

            opcaoContactoMenu = Ler.umaString();
        } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
        contactosC.setTelefone(telefonesC);
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.print("\nEmail: ");
        emailC = Ler.umaString();
        boolean verifEmail = verificacaoEmail(emailC);
        while (verifEmail == false) {
            System.out.print("\nDigite o email corretamente!! ->  ");
            emailC = Ler.umaString();
            verifEmail = verificacaoEmail(emailC);
        }
        contactosC.setE_mail(emailC);
        professorC.setContactos(contactosC);

        System.out.print("\nLocal de Origem: ");
        localdeOrigemC = Ler.umaString();
        professorC.setLocalDeOrigem(localdeOrigemC);

        System.out.print("\nData de Nascimento: ");
        datadenascimentoC = pedeData();
        professorC.setDataNascimento(datadenascimentoC);

        System.out.print("\nRating [1 - 100]: ");
        ratingProfC = Ler.umInt();
        boolean verifRating = verifRating(ratingProfC);
        while (verifRating == false) {
            System.out.print("\nIntroduza o Rating corretamente! Rating [1 - 100] -> ");
            ratingProfC = Ler.umInt();
            verifRating = verifRating(ratingProfC);
        }
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
        String nomeCurso, opcaoContactoMenu = "";
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

        Curso novoCurso = new Curso(nomeCurso, duracaoCurso, mediaUltimoColocado, provasIngresso,
                dataInicioCurso, dataFimCurso);
        novoCurso.setDisciplinasCurso(disciplinasCurso);

        return novoCurso;
    }

    public static Curso modificarCurso(EscolaInformatica escolaInformatica, int posicao) {
        int opcaoUtilizador;
        do {
            System.out.print("\nO que pretende modificar no curso de "
                    + escolaInformatica.getCursosEscola().get(posicao).getNomeCurso()
                    + "?\n\n 1. Nome\n 2. Média do último colocado\n 3. Provas de Ingresso\n 4. Datas\n\n 0. Nada, desejo sair\n\n Escolha a sua opção --> ");
            opcaoUtilizador = Ler.umInt();

            while (opcaoUtilizador > 4 || opcaoUtilizador < 0) {
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
                    float mediaUltimoColocado;
                    System.out.print("\nMédia do Último Colocado: ");
                    mediaUltimoColocado = Ler.umInt();
                    escolaInformatica.getCursosEscola().get(posicao).setMediaUltimoColocado(mediaUltimoColocado);
                    pedeTecla();
                    break;
                case 3:
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
                case 4:
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
        } while (opcaoUtilizador > 0 && opcaoUtilizador <= 4);
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

                    System.out.print("Número (9 digítos todos juntos): ");
                    numeroContacto = Ler.umLong();
                    boolean verifTel = verificacaoTelemovel(numeroContacto);
                    while (verifTel == false) {
                        System.out.print("\nIntroduza um número de telemóvel válido: ");
                        numeroContacto = Ler.umLong();
                        verifTel = verificacaoTelemovel(numeroContacto);
                    }

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
                boolean verifEmail = verificacaoEmail(emailModEscola);
                while (verifEmail == false) {
                    System.out.print("\nDigite o email corretamente!! ->  ");
                    emailModEscola = Ler.umaString();
                    verifEmail = verificacaoEmail(emailModEscola);
                }
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

                    System.out.print("Número (9 digítos todos juntos): ");
                    numeroContacto = Ler.umLong();
                    boolean verifTel = verificacaoTelemovel(numeroContacto);
                    while (verifTel == false) {
                        System.out.print("\nIntroduza um número de telemóvel válido: ");
                        numeroContacto = Ler.umLong();
                        verifTel = verificacaoTelemovel(numeroContacto);
                    }

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

            System.out.print("Número (9 digítos todos juntos): ");
            numeroContacto = Ler.umLong();
            boolean verifTel = verificacaoTelemovel(numeroContacto);
            while (verifTel == false) {
                System.out.print("\nIntroduza um número de telemóvel válido: ");
                numeroContacto = Ler.umLong();
                verifTel = verificacaoTelemovel(numeroContacto);
            }

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
        boolean verifEmail = verificacaoEmail(email);
        while (verifEmail == false) {
            System.out.print("\nDigite o email corretamente!! ->  ");
            email = Ler.umaString();
            verifEmail = verificacaoEmail(email);
        }
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

                        System.out.print("Número (9 digítos todos juntos): ");
                        numeroContacto = Ler.umLong();
                        boolean verifTel = verificacaoTelemovel(numeroContacto);
                        while (verifTel == false) {
                            System.out.print("\nIntroduza um número de telemóvel válido: ");
                            numeroContacto = Ler.umLong();
                            verifTel = verificacaoTelemovel(numeroContacto);
                        }

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
                    boolean verifEmail = verificacaoEmail(email);
                    while (verifEmail == false) {
                        System.out.print("\nDigite o email corretamente!! ->  ");
                        email = Ler.umaString();
                        verifEmail = verificacaoEmail(email);
                    }
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

    public static String menuEscolhaNivel() {
        int nivelescolhido;
        String dificescolhida = "";
        System.out.println("Dificuldade:\n1 - Fácil\n2 - Média\n3 - Difícil");
        System.out.print("Opção escolhida -> ");
        nivelescolhido = Ler.umInt();
        while (nivelescolhido < 0 || nivelescolhido > 4) {
            System.out.print("Digite a opção corretamente -> ");
            nivelescolhido = Ler.umInt();
        }
        if (nivelescolhido == 1) {
            dificescolhida = "Fácil";
        }
        if (nivelescolhido == 2) {
            dificescolhida = "Média";
        }
        if (nivelescolhido == 3) {
            dificescolhida = "Difícil";
        }
        return dificescolhida;
    }

    public static void criarfrequencia(EscolaInformatica escolaInformatica, Disciplina disciplina) {

        Frequencia novaFrequencia = new Frequencia();
        int posDisciplinaIdFreq = escolaInformatica.devolvePosDisc(disciplina.getNomDisc());
        escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().add(novaFrequencia);

        int verificaExistenciaFreq = -1, verificaExistenciaProf = -1, idFreq = 0, NTotalPerguntas;
        float cotacao;
        String dific, pergunta;
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

        listaProfs(escolaInformatica);
        System.out.print("Escolha um professor pelo ID: ");
        int idProf = Ler.umInt();
        verificaExistenciaProf = escolaInformatica.devolvePosProfDadoID(idProf, convPessoaProf(Professores));
        while (verificaExistenciaProf == -1) {
            System.out.print("Lamento, mas este professor não existe! Escolha outro: ");
            idProf = Ler.umInt();
            verificaExistenciaProf = escolaInformatica.devolvePosProfDadoID(idProf, convPessoaProf(Professores));
        }
        novaFrequencia.setProfessorResponsavel((Professor) Professores.get(verificaExistenciaProf));

        System.out.print("\nNúmero Total de Perguntas: ");
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
            System.out.print("\nPergunta " + (i + 1) + ": ");
            pergunta = Ler.umaString();
            System.out.print("\nCotação da pergunta " + (i + 1) + ": ");
            cotacao = Ler.umInt();
            Perguntas questao = new Perguntas(cotacao, pergunta);
            escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(posFreq)
                    .getlistperg().add(questao);
        }
        System.out.println();
        dific = menuEscolhaNivel();
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
        int numQuestao, idProf;
        int opcaomodFreq;
        String respContinuar;
        float novcotacao;
        int opcaomenulistaPerg;
        Frequencia modificarFrequencia = escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                .get(posFrequencia);
        modificarFrequencia.setDisc(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq));
        int verificaExistenciaFreq = -1, verificaExistenciaProf = -1, idFreq = 0, NTotalPerguntas;
        String pergunta, dif;
        ArrayList<Professor> Professores = convPessoaProf(identProf(escolaInformatica.getPessoasEscola()));
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
                    listaProfs(escolaInformatica);
                    System.out.print("ID do novo Professor Responsável: ");
                    idProf = Ler.umInt();
                    verificaExistenciaProf = escolaInformatica.devolvePosProfDadoID(idProf, Professores);
                    while (verificaExistenciaProf == -1) {
                        System.out.print("Lamento, mas este professor não existe! Escolha outro: ");
                        idProf = Ler.umInt();
                        verificaExistenciaProf = escolaInformatica.devolvePosProfDadoID( idProf, Professores);
                    }
                    modificarFrequencia.setProfessorResponsavel((Professor) Professores.get(verificaExistenciaProf));
                    break;
                case 4:
                    System.out.print("\nNúmero Total de Perguntas: ");
                    NTotalPerguntas = Ler.umInt();
                    while (NTotalPerguntas < modificarFrequencia.getNumPergTotal()) {
                        System.out.print("Insira um número de perguntas maior ao igual ao anterior: ");
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
                                "1. Adicionar Pergunta\n2. Remover Pergunta\n3. Modificar Pergunta\n0. Voltar");
                        System.out.print("Opção -> ");
                        opcaomenulistaPerg = Ler.umInt();
                        while (opcaomenulistaPerg < 0 || opcaomenulistaPerg > 3) {
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
                                            .get(posFrequencia).getlistperg().size() < escolaInformatica
                                                    .getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                                    .get(posFrequencia).getNumPergTotal()));
                                    if(escolaInformatica
                                    .getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                    .get(posFrequencia).getlistperg().size() == escolaInformatica
                                            .getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                            .get(posFrequencia).getNumPergTotal())
                                            System.out.println("\nLimite de perguntas atingido!");
                                }
                                System.out.println();
                                pedeTecla();
                                break;
                            case 2:
                                listaPerguntas(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq)
                                        .getListFreq().get(posFrequencia).getlistperg());
                                do {
                                    System.out.print("Número da Pergunta que deseja remover: ");
                                    numQuestao = Ler.umInt();
                        
                                    escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                                .get(posFrequencia).getlistperg().remove(numQuestao - 1);
                                    escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                                .get(posFrequencia).setNumPergTotal(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                                .get(posFrequencia).getNumPergTotal()-1);
                                    System.out.print("\nDeseja continuar? Se sim, digite [S] senão digite [N]: ");
                                    respContinuar = Ler.umaString();
                                } while ((respContinuar == "S" || respContinuar == "s") && escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                .get(posFrequencia).getlistperg().size()>0);
                                pedeTecla();
                                break;
                            case 3:
                                do {
                                    limpaTela();
                                    listaPerguntas(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq)
                                            .getListFreq().get(posFrequencia).getlistperg());
                                    System.out.print("Número da Pergunta que deseja modificar: ");
                                    numQuestao = Ler.umInt();

                                    System.out.print("\nPergunta " + numQuestao + ": ");
                                    pergunta = Ler.umaString();
                                    System.out.print("\nCotação da pergunta " + numQuestao + ": ");
                                    novcotacao = Ler.umInt();

                                    Perguntas questao = new Perguntas(novcotacao, pergunta);
                                    escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                                            .get(posFrequencia).getlistperg().set(numQuestao - 1, questao);

                                    System.out.print("\nDeseja continuar? Se sim, digite [S] senão digite [N]: ");
                                    respContinuar = Ler.umaString();
                                } while (respContinuar.equals("S") || respContinuar.equals("s"));
                                break;
                        }
                    } while (opcaomenulistaPerg > 0 && opcaomenulistaPerg <= 3);
                    break;
                case 6:
                    dif = menuEscolhaNivel();
                    modificarFrequencia.setdificuldadec(dif);
                    pedeTecla();
                    break;
            }
        } while (opcaomodFreq > 0 && opcaomodFreq <= 6);
        return modificarFrequencia;
    }

    public static int menuDisciplinasFreq(EscolaInformatica escolaInformatica) {
        int idDisc = 0;
        escolaInformatica.listaDisciplinas();
        System.out.print("ID da Disciplina da Frequência: -> ");
        idDisc = Ler.umInt();

        int posDisc = escolaInformatica.devolvePosDisciplinaDadoID(idDisc);
        while (posDisc == -1) {
            System.out.print("Digite uma opção VÁLIDA -> ");
            idDisc = Ler.umInt();
            posDisc = escolaInformatica.devolvePosDisciplinaDadoID(idDisc);
        }

        if (escolaInformatica.getDisciplinaEscola().get(posDisc).getListFreq().isEmpty()) {
            System.out.println("Esta disciplina não contém frequências.\n");
            idDisc = -1;
        } 
        
        return idDisc;
    }

    public static int menuCurso(EscolaInformatica escolaInformatica) {
        int opcaoCurso;
        System.out.println("Cursos da " + escolaInformatica.getNomeEscola());
        for (int i = 0; i < escolaInformatica.getCursosEscola().size(); i++) {
            System.out.println(i + 1 + ". " + escolaInformatica.getCursosEscola().get(i).getNomeCurso());
        }
        System.out.print("\nNúmero do Curso que pretende escolher: -> ");
        opcaoCurso = Ler.umInt();
        while (opcaoCurso < 0 || opcaoCurso > escolaInformatica.getCursosEscola().size()) {
            System.out.print("Digite uma opção VÁLIDA -> ");
            opcaoCurso = Ler.umInt();
        }
        return opcaoCurso - 1;

    }

    public static int menuEscolhaNivelAdequadaDisciplina(EscolaInformatica escolaInformatica, int posDisciplinaFreq) {
        int nivelescolhido;
        System.out.println("Deseja consultar as frequências da disciplina "
                + escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getNomDisc()
                + " com dificuldade:\n1 - Fácil\n2 - Média\n3 - Difícil");
        System.out.print("Opção escolhida -> ");
        nivelescolhido = Ler.umInt();
        while (nivelescolhido < 0 || nivelescolhido > 4) {
            System.out.print("Digite a opção corretamente -> ");
            nivelescolhido = Ler.umInt();
        }
        return nivelescolhido;
    }

    public static ArrayList<Frequencia> freqnivelFacil(EscolaInformatica escolaInformatica, int posDisciplinaIdFreq) {
        ArrayList<Frequencia> freqnivelFacil = new ArrayList<>();
        for (int i = 0; i < escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                .size(); i++) {
            if (escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(i).getdificuldade()
                    .contains("Fácil")) {
                freqnivelFacil
                        .add(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(i));
            }
        }
        return freqnivelFacil;
    }

    public static ArrayList<Frequencia> freqnivelMédio(EscolaInformatica escolaInformatica, int posDisciplinaIdFreq) {
        ArrayList<Frequencia> freqnivelMedio = new ArrayList<>();
        for (int i = 0; i < escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                .size(); i++) {
            if (escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(i).getdificuldade()
                    .contains("Médio")) {
                freqnivelMedio
                        .add(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(i));
            }
        }
        return freqnivelMedio;
    }

    public static ArrayList<Frequencia> freqnivelDificil(EscolaInformatica escolaInformatica, int posDisciplinaIdFreq) {
        ArrayList<Frequencia> freqnivelDificil = new ArrayList<>();
        for (int i = 0; i < escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq()
                .size(); i++) {
            if (escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(i).getdificuldade()
                    .contains("Difícil")) {
                freqnivelDificil
                        .add(escolaInformatica.getDisciplinaEscola().get(posDisciplinaIdFreq).getListFreq().get(i));
            }
        }
        return freqnivelDificil;
    }

    public static ArrayList<Integer> listIdsDisciplina(EscolaInformatica escolaInformatica, int posDisciplinaFreq) {
        ArrayList<Integer> listaIds = new ArrayList<Integer>();
        ArrayList<Frequencia> listaFreq = escolaInformatica.getDisciplinaEscola().get(posDisciplinaFreq).getListFreq();
        for (int i = 0; i < listaFreq.size(); i++) {
            listaIds.add(listaFreq.get(i).getid());
        }
        return listaIds;
    }

    public static ArrayList<Frequencia> freqcommaisPerguntasCurso(EscolaInformatica escolaInformatica, int posCurso) {
        ArrayList<Frequencia> freqComMaiorPerg = new ArrayList<>();
        ArrayList<Frequencia> freqTotalCurso = new ArrayList<>();
        int maiornperguntas;
        ArrayList<Integer> posFreqComMaiorPerg = new ArrayList<>();
        ArrayList<Integer> resultados = new ArrayList<>();
        for (int i = 0; i < escolaInformatica.getCursosEscola().get(posCurso).getDisciplinasCurso().size(); i++) {
            for (int j = 0; j < escolaInformatica.getCursosEscola().get(posCurso).getDisciplinasCurso().get(i)
                    .getListFreq().size(); j++) {
                freqTotalCurso.add(escolaInformatica.getCursosEscola().get(posCurso).getDisciplinasCurso().get(i)
                        .getListFreq().get(j));
            }
        }
        for (int i = 0; i < freqTotalCurso.size(); i++) {
            resultados.add(freqTotalCurso.get(i).getNumPergTotal());
        }
        maiornperguntas = Collections.max(resultados);
        for (int i = 0; i < resultados.size(); i++) {
            if (resultados.get(i) == maiornperguntas) {
                posFreqComMaiorPerg.add(i);
            }
        }
        for (int i = 0; i < freqTotalCurso.size(); i++) {
            for (int j = 0; j < posFreqComMaiorPerg.size(); j++) {
                if (i == posFreqComMaiorPerg.get(j)) {
                    freqComMaiorPerg.add(freqTotalCurso.get(i));
                }
            }
        }
        return freqComMaiorPerg;
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

                        System.out.print("Número (9 digítos todos juntos): ");
                        numeroContacto = Ler.umLong();
                        boolean verifTel = verificacaoTelemovel(numeroContacto);
                        while (verifTel == false) {
                            System.out.print("\nIntroduza um número de telemóvel válido: ");
                            numeroContacto = Ler.umLong();
                            verifTel = verificacaoTelemovel(numeroContacto);
                        }

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
                    boolean verifEmail = verificacaoEmail(email);
                    while (verifEmail == false) {
                        System.out.print("\nDigite o email corretamente!! ->  ");
                        email = Ler.umaString();
                        verifEmail = verificacaoEmail(email);
                    }
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
                    System.out.print("\nRating [1 - 100]: ");
                    ratingProf = Ler.umInt();
                    boolean verifRating = verifRating(ratingProf);
                    while (verifRating == false) {
                        System.out.print("\nIntroduza o Rating corretamente! Rating [1 - 100] -> ");
                        ratingProf = Ler.umInt();
                        verifRating = verifRating(ratingProf);
                    }
                    novoProfessor.setRating(ratingProf);
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
        melhorRating = Collections.min(arrayRatings);
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
        String nomedisc;
        int verificaExistenciadisc = -1;
        do {
            if (verificaExistenciadisc == -1)
                System.out.print("\nNome da Disiplina: ");
            else
                System.out.print("Esse nome já existe! Por favor, escolha outro: ");
            nomedisc = Ler.umaString();
            verificaExistenciadisc = escolaInformatica.devolvePosDisc(nomedisc);
        } while (verificaExistenciadisc != -1);
        Disciplina novDisciplina = new Disciplina(nomedisc);
        return novDisciplina;
    }

    public static Disciplina modificarDisciplina(EscolaInformatica escolaInformatica, int posicao) {

        int verificaExistenciadisc = -1;
        String nomedisc;

        do {
            if (verificaExistenciadisc == -1)
                System.out.print("\nNome da Disciplina: ");
            else
                System.out.print("Esse nome já existe! Por favor, escolha outro: ");
            nomedisc = Ler.umaString();
            verificaExistenciadisc = escolaInformatica.devolvePosDisc(nomedisc);
        } while (verificaExistenciadisc != -1);

        escolaInformatica.getDisciplinaEscola().get(posicao).setNomDisc(nomedisc);

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

    public static Disciplina discfrequenciamaislonga(EscolaInformatica escolaInformatica) {
        Disciplina discfrequenciamaislonga = new Disciplina();
        int maiorNumPerg = 0, numperg = 0;

        for (int i = 0; i < escolaInformatica.getDisciplinaEscola().size(); i++) {
            for (int j = 0; j < escolaInformatica.getDisciplinaEscola().get(i).getListFreq().size(); j++) {
                numperg = escolaInformatica.getDisciplinaEscola().get(i).getListFreq().get(j).getNumPergTotal();
                if (numperg > maiorNumPerg) {
                    maiorNumPerg = numperg;
                    discfrequenciamaislonga = escolaInformatica.getDisciplinaEscola().get(i);
                }
            }
        }

        return discfrequenciamaislonga;
    }

    public static Aluno atribuiNotas(EscolaInformatica escolaInformatica, int numAluno) {
        ArrayList<Aluno> alunosEscola = convPessoaAluno(identAluno(escolaInformatica.getPessoasEscola()));
        Aluno alunoSelecionado = alunosEscola.get(numAluno - 1);
        int idDisc, idFreq;
        float nota;

        System.out.println(alunoSelecionado.getNotasDisciplinas());

        if (!alunoSelecionado.getCurso().getNomeCurso().equals("")) {
            if (!alunoSelecionado.getCurso().getDisciplinasCurso().isEmpty()) {
                System.out.println();
                alunoSelecionado.listaDiscDoAluno();
                System.out.print("Escolha o ID da Disciplina para a qual pretende atribuir notas: ");
                idDisc = Ler.umInt();
                alunoSelecionado.getCurso().verificaIdDisc(idDisc);
                while (alunoSelecionado.getCurso().verificaIdDisc(idDisc) == false) {
                    System.out.print("ID NÃO EXISTENTE, ESCOLHA OUTRO: ");
                    idDisc = Ler.umInt();
                    alunoSelecionado.getCurso().verificaIdDisc(idDisc);
                }

                Disciplina discSelecionada = alunoSelecionado.getCurso().getDisciplinasCurso()
                        .get(escolaInformatica.devolvePosDisciplinaDeUmCurso(idDisc, alunoSelecionado.getCurso()));
                if (!alunoSelecionado.getCurso().getDisciplinasCurso()
                        .get(escolaInformatica.devolvePosDisciplinaDeUmCurso(idDisc, alunoSelecionado.getCurso()))
                        .getListFreq().isEmpty()) {
                    ;
                    System.out.print("\nEscolha o ID da Frequência para a qual pretende atribuir notas "
                            + listIdsDisciplina(escolaInformatica,
                                    escolaInformatica.devolvePosDisc(discSelecionada.getNomDisc()))
                            + " --> ");
                    idFreq = Ler.umInt();
                    while (escolaInformatica.devolvePosFrequenciaDaListaFreq(idFreq) == -1) {
                        System.out.print("ID NÃO EXISTENTE, ESCOLHA OUTRO: ");
                        idFreq = Ler.umInt();
                        escolaInformatica.devolvePosFrequenciaDaListaFreq(idFreq);
                    }

                    System.out.print("\nNota na frequência com o ID " + idFreq + " da Disciplina de "
                            + escolaInformatica.devolveDisciplinaDadoID(idDisc).getNomDisc() + ": ");
                    nota = Ler.umFloat();
                    Resultado notaNaFreq = new Resultado(idFreq, nota);

                    boolean notaModificada = false;
                    for (int i = 0; i < alunoSelecionado.getNotasDisciplinas().size(); i++) {
                        if (alunoSelecionado.getNotasDisciplinas().get(i).getDisciplina()
                                .equals(escolaInformatica.devolveDisciplinaDadoID(idDisc).getNomDisc())) {
                            for (int j = 0; j < alunoSelecionado.getNotasDisciplinas().get(i).getNotas().size(); j++) {
                                if (alunoSelecionado.getNotasDisciplinas().get(i).getNotas().get(j).getid() == idFreq) {
                                    alunoSelecionado.getNotasDisciplinas().get(i).getNotas().get(j).setcotaçao(nota);
                                    notaModificada = true;
                                }
                            }
                            if (notaModificada == false)
                                alunoSelecionado.getNotasDisciplinas().get(i).getNotas().add(notaNaFreq);
                        }
                    }
                    System.out.println("\nNotas adicionadas com sucesso!");
                } else {
                    System.out.println("\nEsta disciplina ainda não contém frequências!!");
                }
            } else {
                System.out.println("\nEste curso ainda não contem disciplinas!!");
            }
        } else {
            System.out.println("\nEste aluno ainda não se encontra inscrito em nenhum curso!!");
        }

        return alunoSelecionado;
    }

    public static Aluno alunoComMelhorNotaNumaFreq(int idFreq, Disciplina disc, ArrayList<Aluno> Alunos) {
        ArrayList<Aluno> AlunosQueFizeramAFreq = new ArrayList<Aluno>();
        Aluno alunoComMelhorNota = new Aluno();
        float maior = 0;

        for (int i = 0; i < Alunos.size(); i++) {
            for (int j = 0; j < Alunos.get(i).getNotasDisciplinas().size(); j++) {
                if (Alunos.get(i).getNotasDisciplinas().get(j).getDisciplina().equals(disc.getNomDisc())) {
                    for (int k = 0; k < Alunos.get(i).getNotasDisciplinas().get(j).getNotas().size(); k++) {
                        if (Alunos.get(i).getNotasDisciplinas().get(j).getNotas().get(k).getid() == idFreq)
                            AlunosQueFizeramAFreq.add(Alunos.get(i));
                    }
                }
            }
        }

        for (int i = 0; i < AlunosQueFizeramAFreq.size(); i++) {
            for (int j = 0; j < AlunosQueFizeramAFreq.get(i).getNotasDisciplinas().size(); j++) {
                for (int k = 0; k < AlunosQueFizeramAFreq.get(i).getNotasDisciplinas().get(j).getNotas().size(); k++) {
                    if (AlunosQueFizeramAFreq.get(i).getNotasDisciplinas().get(j).getNotas().get(k).getid() == idFreq) {
                        float cot = AlunosQueFizeramAFreq.get(i).getNotasDisciplinas().get(j).getNotas().get(k)
                                .getcotaçao();
                        if (cot > maior) {
                            maior = cot;
                            alunoComMelhorNota = AlunosQueFizeramAFreq.get(i);
                        }
                    }
                }
            }
        }

        return alunoComMelhorNota;
    }

    public static void listaProfs(EscolaInformatica escolaInformatica){
        ArrayList<Professor> profsEscola = convPessoaProf(identProf(escolaInformatica.getPessoasEscola()));

        if(escolaInformatica.getDisciplinaEscola().isEmpty())
            System.out.println("De momento, não estão registadas quaisquer professores.\n");
        else{
            System.out.println("Professores da "+ escolaInformatica.getNomeEscola()+":\n");
            for(int i = 0; i < profsEscola.size(); i++)
                System.out.println(". ID:" + profsEscola.get(i).getNumProf() + " , " + profsEscola.get(i).getNome());
            System.out.println();
        }
    }
}
