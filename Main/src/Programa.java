import java.util.ArrayList;
import java.util.Collections;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.io.IOException;
import java.util.Collection;

public class Programa implements Serializable {

    public static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pedeTecla() {
        System.out.print("Pressione alguma tecla para avançar --> ");
        Ler.umaString();
    }

    public static void EscreveEscolaNoFicheiro(String filepath, EscolaInformatica escolaInformaticas) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(escolaInformaticas);
            objectOut.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static EscolaInformatica LeEscolaNoFicheiro(String filepath) {
        try {
            File file = new File(filepath);
            FileInputStream is = new FileInputStream(file);
            EscolaInformatica obj = new EscolaInformatica();
            if (file.length() != 0) {
                ObjectInputStream oIS = new ObjectInputStream(is);
                obj = (EscolaInformatica) oIS.readObject();
                oIS.close();
            }
            return obj;
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


    public static ArrayList<Professor> convPessoaProf(ArrayList<Pessoa> profsEscolaPessoa){
        ArrayList<Professor> professores = new ArrayList<>();
        for(int i = 0; i < profsEscolaPessoa.size(); i++){
            Professor p = (Professor) profsEscolaPessoa.get(i);
            professores.add(p);
        }
        return professores;
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

    public static String mostrarEscola(EscolaInformatica escolaInformatica) {
        String infoEscola = escolaInformatica.toString();
        return infoEscola;
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
        System.out.print("1. Listar Diretores\n");
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
                Diretor diretor = (Diretor) listapessoas.get(0);
                listaumDiretor(diretor);
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
        int numProfC, ratingProfC, escolhaDisc;
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

        System.out.print("\nNúmero: ");
        numProfC = Ler.umInt();
        professorC.setNumProf(numProfC);
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
        System.out.println("Disciplinas do Professor: \n");
        if (escolaInformatica.getDisciplinaEscola().isEmpty() == false) {
            do {
                int i = 0;
                ArrayList<Integer> adicionados = new ArrayList<Integer>();
                System.out.println("Disciplinas Disponíveis (Escolha uma a uma pelo número): ");
                for (i = 0; i < escolaInformatica.getDisciplinaEscola().size(); i++) {
                    if (!adicionados.contains(i))
                        System.out.println(i + ". " + escolaInformatica.getDisciplinaEscola().get(i).getNomDisc());
                }
                System.out.println("Disciplina para adicionar ao professor --> ");
                escolhaDisc = Ler.umInt();
                while (i < 0 || i > escolaInformatica.getDisciplinaEscola().size() - 1 || adicionados.contains(i)) {
                    System.out.println("Disciplina para adicionar ao professor (DIGITE ALGO VÁLIDO)--> ");
                    escolhaDisc = Ler.umInt();
                }
                adicionados.add(escolhaDisc);
                disciplinasP.add(escolaInformatica.getDisciplinaEscola().get(escolhaDisc));
                System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                opcaoContactoMenu = Ler.umaString();
                while (!opcaoContactoMenu.equals("n") && !opcaoContactoMenu.equals("N")
                        && !opcaoContactoMenu.equals("S") && !opcaoContactoMenu.equals("s")) {
                    System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                    opcaoContactoMenu = Ler.umaString();
                }
            } while (opcaoContactoMenu.equals("s") || opcaoContactoMenu.equals("S"));
        } else {
            System.out.println("Ainda não há disciplinas criadas.");
        }

        professorC.setDiscLec(disciplinasP);

        System.out.println(professorC);
        return professorC;
    }

    public static Curso criarCurso(EscolaInformatica escolaInformatica) {
        String nomeCurso, opcaoContactoMenu, codCurso;
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
        System.out.println("Disciplinas do Curso: \n");

        if (escolaInformatica.getDisciplinaEscola().isEmpty() == false) {
            do {
                int i = 0;
                ArrayList<Integer> adicionados = new ArrayList<Integer>();
                System.out.println("Disciplinas Disponíveis (Escolha uma a uma pelo número): ");
                for (i = 0; i < escolaInformatica.getDisciplinaEscola().size(); i++) {
                    if (!adicionados.contains(i))
                        System.out.println(i + ". " + escolaInformatica.getDisciplinaEscola().get(i).getNomDisc());
                }
                System.out.println("Disciplina para adicionar ao curso --> ");
                escolhaDisc = Ler.umInt();
                while (i < 0 || i > escolaInformatica.getDisciplinaEscola().size() - 1 || adicionados.contains(i)) {
                    System.out.println("Disciplina para adicionar ao curso (DIGITE ALGO VÁLIDO)--> ");
                    escolhaDisc = Ler.umInt();
                }
                adicionados.add(escolhaDisc);
                disciplinasCurso.add(escolaInformatica.getDisciplinaEscola().get(escolhaDisc));
                System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                opcaoContactoMenu = Ler.umaString();
                while (!opcaoContactoMenu.equals("n") && !opcaoContactoMenu.equals("N")
                        && !opcaoContactoMenu.equals("S") && !opcaoContactoMenu.equals("s")) {
                    System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                    opcaoContactoMenu = Ler.umaString();
                }
            } while (opcaoContactoMenu.equals("s") || opcaoContactoMenu.equals("S"));
        } else
            System.out.println("Ainda não há disciplinas criadas.");
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
        mediaUltimoColocado = Ler.umInt();

        Curso novoCurso = new Curso(nomeCurso, codCurso, duracaoCurso, mediaUltimoColocado, provasIngresso,
                dataInicioCurso, dataFimCurso);
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

    public static void modificarProfessor(EscolaInformatica escolaInformatica, int posicao) {
        int opcaoUtilizador;
        Professor novoProfessor = (Professor) escolaInformatica.getPessoasEscola().get(posicao);
        do {
            int verificaExistenciaAluno = -1, numProf, ratingProf, escolhaDisc;
            String nomePessoa, tipoContacto, localDeOrigem, email;
            String opcaoContactoMenu;
            long numeroContacto;
            ArrayList<Telefone> telefones = new ArrayList<Telefone>();
            Contactos contactosAluno = new Contactos();
            ArrayList<Disciplina> disciplinasP = new ArrayList<>();

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
                    System.out.println("Disciplinas do Professor: \n");
                    if (escolaInformatica.getDisciplinaEscola().isEmpty() == false) {
                        do {
                            int i = 0;
                            ArrayList<Integer> adicionados = new ArrayList<Integer>();
                            System.out.println("Disciplinas Disponíveis (Escolha uma a uma pelo número): ");
                            for (i = 0; i < escolaInformatica.getDisciplinaEscola().size(); i++) {
                                if (!adicionados.contains(i))
                                    System.out.println(
                                            i + ". " + escolaInformatica.getDisciplinaEscola().get(i).getNomDisc());
                            }
                            System.out.println("Disciplina para adicionar ao curso --> ");
                            escolhaDisc = Ler.umInt();
                            while (i < 0 || i > escolaInformatica.getDisciplinaEscola().size() - 1
                                    || adicionados.contains(i)) {
                                System.out.println("Disciplina para adicionar ao curso (DIGITE ALGO VÁLIDO)--> ");
                                escolhaDisc = Ler.umInt();
                            }
                            adicionados.add(escolhaDisc);
                            disciplinasP.add(escolaInformatica.getDisciplinaEscola().get(escolhaDisc));
                            System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                            opcaoContactoMenu = Ler.umaString();
                            while (!opcaoContactoMenu.equals("n") && !opcaoContactoMenu.equals("N")
                                    && !opcaoContactoMenu.equals("S") && !opcaoContactoMenu.equals("s")) {
                                System.out.print("Pretende inserir mais disciplinas? [S/N] -> ");
                                opcaoContactoMenu = Ler.umaString();
                            }
                        } while (opcaoContactoMenu.equals("s") || opcaoContactoMenu.equals("S"));
                    } else {
                        System.out.println("Ainda não há disciplinas criadas.\n");
                    }
                    novoProfessor.setDiscLec(disciplinasP);
                    pedeTecla();
                    break;
            }
            limpaTela();
            if (opcaoUtilizador != 0)
                escolaInformatica.changeProf(posicao, novoProfessor);
        } while (opcaoUtilizador > 0 && opcaoUtilizador <= 8);
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

    public static ArrayList<Professor> professoresDeslocadosFuncao(EscolaInformatica escolaInformatica , ArrayList<Professor> professoresEscola){
        String localizacaoEscola = escolaInformatica.getLocalizacao();
        ArrayList<Professor> deslocados = new ArrayList<>();
        for(int i = 0; i < professoresEscola.size(); i++){
            if(!professoresEscola.get(i).getLocalDeOrigem().equals(localizacaoEscola)){
                deslocados.add(professoresEscola.get(i));
            }
        }
        return deslocados;
    }

    public static ArrayList<Professor> professorComMelhorRating(ArrayList<Professor> professoresEscola){
        int melhorRating;
        ArrayList<Professor> profMelhorRating = new ArrayList<>();
        ArrayList<Integer> arrayRatings = new ArrayList<>();
        for(int i = 0; i < professoresEscola.size(); i++){
              arrayRatings.add(professoresEscola.get(i).getRating());
        }
        melhorRating = Collections.max(arrayRatings);
        for(int i = 0; i < professoresEscola.size(); i++){
            if(professoresEscola.get(i).getRating() == melhorRating){
                profMelhorRating.add(professoresEscola.get(i));
            }
        }
        return profMelhorRating;
    }

    public static ArrayList<Professor> professorMaisVelho(ArrayList<Professor> professoresEscola){
        ArrayList<Professor> professoresMaisVelhos = new ArrayList<>();
        int idademaisVelho;
        ArrayList<Integer> idades = new ArrayList<>();
        for(int i = 0; i < professoresEscola.size(); i++){
            idades.add(professoresEscola.get(i).calculaIdade());
        }
        idademaisVelho = Collections.max(idades);
        for(int i = 0; i < professoresEscola.size(); i++){
            if(professoresEscola.get(i).calculaIdade() == idademaisVelho){
                professoresMaisVelhos.add(professoresEscola.get(i));
            }
        }
        return professoresMaisVelhos;

    }

    public static ArrayList<Professor> professorMaisNovo(ArrayList<Professor> professoresEscola){
        ArrayList<Professor> professoresMaisNovos = new ArrayList<>();
        int idademaisNovo;
        ArrayList<Integer> idades = new ArrayList<>();
        for(int i = 0; i < professoresEscola.size(); i++){
            idades.add(professoresEscola.get(i).calculaIdade());
        }
        idademaisNovo = Collections.min(idades);
        for(int i = 0; i < professoresEscola.size(); i++){
            if(professoresEscola.get(i).calculaIdade() == idademaisNovo){
                professoresMaisNovos.add(professoresEscola.get(i));
            }
        }
        return professoresMaisNovos;

    }
























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
                                escolaInformatica.getPessoasEscola()
                                        .add(modDiretor(LeEscolaNoFicheiro("escolaInformática.txt")));
                                escolaInformatica
                                        .setDiretorEscola(modDiretor(LeEscolaNoFicheiro("escolaInformática.txt")));
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                System.out.println();
                                break;
                            case 3:
                                // Listar Pessoas

                                listarPessoasEscola(escolaInformatica.getPessoasEscola(), escolaInformatica);
                                break;
                            case 4:
                                // Mudar informações acerca da escola
                                EscreveEscolaNoFicheiro("escolaInformática.txt",
                                        modificarEscola(LeEscolaNoFicheiro("escolaInformática.txt")));
                                break;
                            case 5:
                                // Listar informações sobre a escola

                                System.out.print(mostrarEscola(LeEscolaNoFicheiro("escolaInformática.txt")));
                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 5);
                    break;
                case 2:
                    do {
                        limpaTela();
                        System.out.print(
                                " GERIR CURSOS\n\n1. Listar cursos\n2. Criar curso\n3. Consultar informações de determinado curso\n4. Modificar dados sobre um curso\n5. Remover curso\n6. Inserir e Remover disciplinas de determinado curso\n7. Inserir e Remover alunos de determinado curso\n8. Mostrar curso mais frequentado\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 6 || opcaoUtilizador < 0) {
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

                                pedeTecla();
                                break;
                            case 7:
                                // Inserir e Remover disciplinas de determinado curso

                                pedeTecla();
                                break;
                            case 8:
                                // Inserir e Remover alunos de determinado curso

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
                        while (opcaoUtilizador > 9 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Disciplinas

                                pedeTecla();
                                break;
                            case 2:
                                // Criar Disciplina

                                pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinada disciplina

                                pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma determinada disciplina

                                pedeTecla();
                                break;
                            case 5:
                                // Remover disciplina

                                pedeTecla();
                                break;
                            case 6:
                                // Mostrar a disciplina com a frequência mais longa

                                pedeTecla();
                                break;
                            case 7:
                                // Mostrar professores que lecionam determianda disciplina

                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar alunos inscritos em determinada disciplina

                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 8);
                    break;
                case 4:
                    do {
                        limpaTela();
                        System.out.print(
                                "GERIR PROFESSORES\n\n1. Listar professores\n2. Criar professor\n3. Consultar informações de determinado professor\n4. Modificar dados sobre um determinado professor\n5. Remover professor\n6. Mostrar quais disciplinas lecionou determinado professor\n7. Mostrar professor que lecionou mais disciplinas\n8. Mostrar professores deslocados\n9. Mostrar qual é o professor com melhor rating\n10. Mostrar professor mais velho e mais novo\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 10 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        ArrayList<Pessoa> profsDaEscola = identProf(escolaInformatica.getPessoasEscola());
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Professores
                                for (int i = 0; i < profsDaEscola.size(); i++) {
                                    listaumProf((Professor) profsDaEscola.get(i));
                                }
                                pedeTecla();
                                break;
                            case 2:
                                // Criar Professor
                                escolaInformatica.getPessoasEscola().add(criaProfessor(escolaInformatica));
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
                                System.out.print(
                                        "4. MODIFICAR INFORMAÇÕES SOBRE DETERMINADO PROFESSOR\n\nEscreva o nome do professor que pretende modificar -->  ");
                                String nomeProfModificar = Ler.umaString();
                                posProf = escolaInformatica.devolvePosProf(nomeProfModificar,
                                        escolaInformatica.getPessoasEscola());
                                if (posProf == -1) {
                                    System.out.println("Lamentamos, mas este professor não existe!\n");
                                    pedeTecla();
                                } else {
                                    modificarProfessor(escolaInformatica, posProf);
                                    EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }
                                break;
                            case 5:
                                // Remover diretor
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
                                ArrayList<Professor> professorMaisDiscLec = convPessoaProf(escolaInformatica.getPessoasEscola());
                                ArrayList<Professor> ArrayResultadosProf = profcommaisdiscpLecionadas(professorMaisDiscLec);
                                ArrayList<Professor> professoresEscolaDisc = convPessoaProf(identProf(escolaInformatica.getPessoasEscola()));
                                if(ArrayResultadosProf.size() == 1){
                                    System.out.println("Professor com mais discipinas lecionadas " + "----> " + ArrayResultadosProf.get(0).contDiscProf());
                                    listaumProf(ArrayResultadosProf.get(0));
                                }
                                else{
                                    System.out.println("EMPATE RATING COM " + professoresEscolaDisc.get(0).contDiscProf() + " DISCIPLINAS LECIONADAS!");
                                    for(int i = 0; i < ArrayResultadosProf.size(); i++){
                                        listaumProf(ArrayResultadosProf.get(i));
                                    }
                                }
                                pedeTecla();
                                break;
                            case 7:
                                ArrayList<Professor> professoresEscolaDeslocacoes = convPessoaProf(identProf(escolaInformatica.getPessoasEscola()));
                                ArrayList<Professor> professoresDeslocados = professoresDeslocadosFuncao(escolaInformatica, professoresEscolaDeslocacoes);
                                for(int i = 0; i < professoresDeslocados.size(); i++){
                                    listaumProf(professoresDeslocados.get(i));
                                }
                                pedeTecla();
                                break;
                            case 8:
                                ArrayList<Professor> professoresEscolaRating = convPessoaProf(identProf(escolaInformatica.getPessoasEscola()));
                                ArrayList<Professor> profscomMelhorRating = professorComMelhorRating(professoresEscolaRating);
                                if(profscomMelhorRating.size() == 1){
                                    System.out.println("Professor com melhor Rating " + "----> " + profscomMelhorRating.get(0).getRating());
                                    listaumProf(profscomMelhorRating.get(0));
                                }
                                else{
                                    System.out.println("EMPATE NA POSIÇÃO " + professoresEscolaDisc.get(0).getRating() + " DO RATING!");
                                    for(int i = 0; i < profscomMelhorRating.size(); i++){
                                        listaumProf(profscomMelhorRating.get(i));
                                    }
                                }
                                pedeTecla();
                                break;
                            case 9:
                                ArrayList<Professor> professoresEscolaIdade = convPessoaProf(identProf(escolaInformatica.getPessoasEscola()));
                                ArrayList<Professor> profMaisNovos = professorMaisNovo(professoresEscolaIdade);
                                ArrayList<Professor> profMaisVelhos = professorMaisVelho(professoresEscolaIdade);
                                if(profMaisNovos.size() == 1){
                                    System.out.println("Professor com " + "----> " + profscomMelhorRating.get(0).calculaIdade() + " é o mais novo!");
                                    listaumProf(profMaisNovos.get(0));
                                }
                                else{
                                    System.out.println("EMPATE NOS MAIS NOVOS, IDADE: " + professoresEscolaDisc.get(0).getRating());
                                    for(int i = 0; i < profMaisNovos.size(); i++){
                                        listaumProf(profMaisNovos.get(i));
                                    }
                                }
                                System.out.println("------------------------------------------------");
                                if(profMaisVelhos.size() == 1){
                                    System.out.println("Professor com " + "----> " + profscomMelhorRating.get(0).calculaIdade() + " é o mais velho!");
                                    listaumProf(profMaisVelhos.get(0));
                                }
                                else{
                                    System.out.println("EMPATE NOS MAIS VELHOS, IDADE: " + professoresEscolaDisc.get(0).getRating());
                                    for(int i = 0; i < profMaisVelhos.size(); i++){
                                        listaumProf(profMaisVelhos.get(i));
                                    }
                                }

                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 9);
                    break;
                case 5:
                    do {
                        limpaTela();
                        System.out.print(
                                "GERIR ALUNOS\n\n1. Listar alunos\n2. Criar aluno\n3. Consultar informações de determinado aluno\n4. Modificar dados sobre um determinado aluno\n5. Remover aluno\n6. Atribuir notas a alunos\n7. Inscrever aluno em curso\n8. Mostrar alunos não deslocados\n9. Mostrar aluno mais velho e mais novo\n10. Mostrar aluno com melhor e pior média, de determinado curso\n11. Mostrar aluno com melhor nota, numa determinada frequência\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
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
                                for(int i = 0; i<alunosDaEscola.size(); i++)
                                    listaumAluno((Aluno)alunosDaEscola.get(i));
                                pedeTecla();
                                break;
                            case 2:
                                // Criar Alunos
                                escolaInformatica.getPessoasEscola().add(criarAluno(escolaInformatica));
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
                                    listaumAluno((Aluno)alunosDaEscola.get(posAluno));
                                }
                                pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma determinado aluno
                                System.out.print(
                                        "4. MODIFICAR INFORMAÇÕES SOBRE DETERMINADO ALUNO\n\nEscreva o nome do aluno que pretende modificar -->  ");
                                String nomeAlunoModificar = Ler.umaString();
                                posAluno = escolaInformatica.devolvePosAluno(nomeAlunoModificar, escolaInformatica.getPessoasEscola());
                                if (posAluno == -1){
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                    pedeTecla();
                                }
                                else{
                                    modificarAluno(escolaInformatica, posAluno);
                                    EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                }                    
                                break;
                            case 5:
                                // Remover aluno
                                System.out.print(
                                    "5. REMOVER ALUNO\n\nEscreva o nome do aluno que pretende remover -->  ");
                                String nomeAlunoRemover = Ler.umaString();
                                posAluno = escolaInformatica.devolvePosAluno(nomeAlunoRemover, escolaInformatica.getPessoasEscola());
                                if (posAluno == -1){
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                }
                                else{
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
                                posAluno = escolaInformatica.devolvePosAluno(nomeAlunoInscrever, escolaInformatica.getPessoasEscola());
                                if (posAluno == -1){
                                    System.out.println("Lamentamos, mas este aluno não existe!\n");
                                }
                                else{
                                    Aluno alunoinscrever = (Aluno) escolaInformatica.getPessoasEscola().get(posAluno);

                                    if(alunoinscrever.getCurso().getNomeCurso() == ""){
                                        escolaInformatica.listaCursos();
                                        System.out.print("Dos cursos disponíveis, escolha aquele em que se quer inscrever o aluno "+ nomeAlunoInscrever +": ");
                                        String CursoInscrever = Ler.umaString();
                                        int posCurso = escolaInformatica.devolvePosCurso(CursoInscrever);
                                        if (posCurso == -1){
                                            System.out.println("Lamentamos, mas este Curso não existe!\n");
                                        }
                                        else{
                                            
                                            alunoinscrever.setCurso(escolaInformatica.getCursosEscola().get(posCurso));
                                            System.out.println("Aluno " + nomeAlunoInscrever + " inscrito com sucesso no curso de "+ escolaInformatica.getCursosEscola().get(posCurso).getNomeCurso() +".\n");
                                            EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                        }
                                    }
                                    else
                                        System.out.println("O Aluno " + nomeAlunoInscrever + " já se encontra inscrito num curso! ("+ alunoinscrever.getCurso().getNomeCurso() +")\n");
                                }   

                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar alunos não deslocados

                                pedeTecla();
                                break;
                            case 9:
                                // Mostrar aluno mais velho e mais novo

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
                                "GERIR FREQUÊNCIAS\n\n1. Listar Frequências de determinada disciplina\n2. Criar Frequência\n3. Mostrar determinada frequência, dado o ID da mesma\n4. Modificar dados sobre uma Frequência\n5. Remover Frequência\n6. Mostrar a pergunta com maior cotação, de determinada frequência\n7. Mostrar frequências por nível de dificuldade\n8. Mostrar frequências elaboradas por determinado professor\n9. Mostrar frequências de determinado curso\n10. Mostrar frequências de determinada disciplina\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 10 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Frequências de determinada disciplina

                                pedeTecla();
                                break;
                            case 2:
                                // Criar Frequência

                                pedeTecla();
                                break;
                            case 3:
                                // Mostrar determinada frequência, dado o ID da mesma

                                pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma Frequência

                                pedeTecla();
                                break;
                            case 5:
                                // Remover Frequência

                                pedeTecla();
                                break;
                            case 6:
                                // Mostrar a pergunta com maior cotação, de determinada frequência

                                pedeTecla();
                                break;
                            case 7:
                                // Mostrar frequências por nível de dificuldade

                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar frequências elaboradas por determinado professor

                                pedeTecla();
                                break;
                            case 9:
                                // Mostrar frequências de determinado curso

                                pedeTecla();
                                break;
                            case 10:
                                // Mostrar frequências de determinada disciplina

                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 10);
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
