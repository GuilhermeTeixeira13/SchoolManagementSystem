import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

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

    public static void EscreveCursosNoFicheiro(String filepath, ArrayList<Curso> serObj) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void EscrevePessoasNoFicheiro(String filepath, ArrayList<Pessoa> serObj) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void EscreveDiretorNoFicheiro(String filepath, Diretor diretor) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(diretor);
            objectOut.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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

    public static Diretor LeDiretorNoFicheiro(String filepath) {
        try {
            File file = new File(filepath);
            FileInputStream is = new FileInputStream(file);
            Diretor obj = new Diretor();
            if (file.length() != 0) {
                ObjectInputStream oIS = new ObjectInputStream(is);
                obj = (Diretor) oIS.readObject();
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

    public static ArrayList<Pessoa> LePessoaNoFicheiro(String filepath) {
        try {
            File file = new File(filepath);
            FileInputStream is = new FileInputStream(file);
            ArrayList<Pessoa> obj = new ArrayList<>();
            if (file.length() != 0) {
                ObjectInputStream oIS = new ObjectInputStream(is);
                obj = (ArrayList<Pessoa>) oIS.readObject();
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

    public static ArrayList<Curso> LeCursosNoFicheiro(String filepath) {
        try {
            File file = new File(filepath);
            FileInputStream fileIn = new FileInputStream(filepath);
            ArrayList<Curso> obj = new ArrayList<Curso>();
            if (file.length() != 0) {
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                obj = (ArrayList<Curso>) objectIn.readObject();
                objectIn.close();
            }
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
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

    public static void listaPessoasOutput(ArrayList<Pessoa> pessoas) {
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            System.out.print("Nome: " + pessoa.getNome());
            System.out.print(" // Contactos -> " + pessoa.getContactos());
            System.out.println(" // Local de Origem: " + pessoa.getLocalDeOrigem());
            System.out.println(" //  Data de Nascimento: " + pessoa.getDataNascimento());
        }
    }

    public static String mostrarEscola(EscolaInformatica escolaInformatica){
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
            if (pessoas.get(i) instanceof Aluno) {
                pessoaAluno.add(pessoas.get(i));
            }
        }
        return pessoaAluno;
    }

    public static ArrayList<Pessoa> identAluno(ArrayList<Pessoa> pessoas) {
        ArrayList<Pessoa> pessoaDir = new ArrayList<>();
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof Diretor) {
                pessoaDir.add(pessoas.get(i));
            }
        }
        return pessoaDir;
    }

    public static void listarPessoasEscola(ArrayList<Pessoa> pessoasEscola) {
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
                    ;
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
        System.out.print(" MUDAR INFORMAÇÕES ACERCA DA ESCOLA\n\n");
        System.out.println("1. Nome\n2. Número\n3. Telefones\n4. Localização\n5. Email\n\n0. Voltar");
        System.out.print("ESCOLHA A SUA OPÇÃO -> ");
        opcaoModEscola = Ler.umInt();
        while (opcaoModEscola > 4 || opcaoModEscola < 0) {
            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
            opcaoModEscola = Ler.umInt();
        }
        switch (opcaoModEscola) {
            case 1:
                limpaTela();
                System.out.print("Introduza o novo nome: ");
                nomeModEscola = Ler.umaString();
                modEscola.setNomeEscola(nomeModEscola);
                pedeTecla();
                break;
            case 2:
                limpaTela();
                System.out.print("Introduza o novo número: ");
                numeroModEscola = Ler.umInt();
                modEscola.setCodEscola(numeroModEscola);
                pedeTecla();
                break;
            case 3:
                limpaTela();
                String tipoContacto;
                Long numeroContacto;
                ArrayList<Telefone> telefoneescolaatua = new ArrayList<Telefone>();
                System.out.println("Introduza os novos Telefones: ");
                do {
                    System.out.print("\nTipo: ");
                    tipoContacto = Ler.umaString();

                    System.out.print("Número: ");
                    numeroContacto = Ler.umLong();

                    Telefone telefone = new Telefone(tipoContacto, numeroContacto);
                    telefoneescolaatua.add(telefone);

                    System.out.print("Pretende inserir mais telefones? [S/N] -> ");

                    opcaoContactoMenu = Ler.umaString();
                } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
                Contactos contactoModEscola = new Contactos(escolaInformaticafich.getContactoEscola().getE_mail());
                contactoModEscola.setTelefone(telefoneescolaatua);
                modEscola.setContactoEscola(contactoModEscola);
                pedeTecla();
                break;
            case 4:
                limpaTela();
                System.out.println("Localização: ");
                localizacaoModEscola = Ler.umaString();
                modEscola.setLocalizacao(localizacaoModEscola);
                pedeTecla();
                break;
        }
        return modEscola;
    }

    public static Diretor modDiretor(Diretor diretorfich) {
        Diretor dirMod = LeDiretorNoFicheiro("diretorEscola.txt");
        Contactos dirModContact = new Contactos();
        ArrayList<Telefone> dirModTelefone = new ArrayList<>();
        int opcaomoddiretor, dirModAnosServico;
        String dirModEmail, dirModLocalOrigem, dirModNome, dirModFormacaoNova;
        String tipoContacto;
        Long numeroContacto;
        String opcaoContactoMenu;
        System.out.println(" MODIFICAR DIRETOR\n");
        System.out.println(
                "1. Alterar email\n2. Alterar telefones\n3. Alterar data de nascimento\n4. Alterar local de origem\n5. Alterar nome\n6. Alterar anos de serviço\n7. Alterar formação académica\n\n0. Voltar Atrás");
        System.out.print("ESCOLHA A SUA OPÇÃO -> ");
        opcaomoddiretor = Ler.umInt();
        while (opcaomoddiretor > 7 || opcaomoddiretor < 0) {
            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
            opcaomoddiretor = Ler.umInt();
        }
        switch (opcaomoddiretor) {
            case 1:
                limpaTela();
                System.out.print("\nEmail do Diretor: ");
                dirModEmail = Ler.umaString();
                dirModContact = diretorfich.getContactos();
                dirModContact.setE_mail(dirModEmail);
                break;
            case 2:
                limpaTela();
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
                dirModContact = diretorfich.getContactos();
                dirModContact.setTelefone(dirModTelefone);
                break;
            case 3:
                limpaTela();
                System.out.print("Data de Nascimento do Diretor: ");
                LocalDate dataNascimentoDiretorMod = pedeData();
                dirMod.setDataDeNascimento(dataNascimentoDiretorMod);
                pedeTecla();
                break;
            case 4:
                limpaTela();
                System.out.print("Alterar Local de Origem: ");
                dirModLocalOrigem = Ler.umaString();
                dirMod.setLocalDeOrigem(dirModLocalOrigem);
                break;
            case 5:
                limpaTela();
                System.out.print("Alterar Nome: ");
                dirModNome = Ler.umaString();
                dirMod.setNome(dirModNome);
                break;
            case 6:
                limpaTela();
                System.out.print("Anos de Serviço: ");
                dirModAnosServico = Ler.umInt();
                dirMod.setAnosDeServico(dirModAnosServico);
                break;
            case 7:
                limpaTela();
                System.out.print("Alterar Formação Académica: ");
                dirModFormacaoNova = Ler.umaString();
                dirMod.setFormacaoAcademica(dirModFormacaoNova);
                break;
        }
        return dirMod;
    }

    public static void main(String[] args) {
        int opcaoUtilizador;
        limpaTela();
        System.out.print(
                "ESCOLA PROFISSIONAL DE INFORMÁTICA\n\n1. Gerir Escola\n2. Gerir Cursos\n3. Gerir Disciplinas\n4. Gerir Professores\n5. Gerir Alunos\n6. Gerir Frequências\n\n0. Sair\n\nESCOLHA A SUA OPÇÃO -> ");

        Contactos contactosEscola = new Contactos();
        ArrayList<Disciplina> disciplinasEscola = new ArrayList<Disciplina>();
        String locallizaçãoEscola = "Covilhã";

        EscolaInformatica escolaInformatica = new EscolaInformatica("Escola de Informática", 8,
                LeCursosNoFicheiro("cursoTexto.txt"), LePessoaNoFicheiro("pessoasEscola.txt"), disciplinasEscola,
                LeDiretorNoFicheiro("diretorEscola.txt"), contactosEscola, locallizaçãoEscola);

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
                                "GERIR ESCOLA\n\n1. Criar Diretor (Removendo automaticamento o anterior)\n2. Modificar dados acerca do atual diretor\n3. Listar Pessoas\n4. Mudar informações acerca da escola (Nome, Número, Contactos, Localização)\n5. Informações da escola\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 5 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                Diretor diretorCriado = criarDiretor();
                                // Diretor antigo removido da lista de pessoas da escola.
                                Programa.removeDiretorDaListaDePessoas(escolaInformatica.getPessoasEscola());
                                // Diretor criado adicionado à lista de pessoas da escola
                                escolaInformatica.getPessoasEscola().add(diretorCriado);
                                // Defenir lista de pessoas atualizada
                                escolaInformatica.setPessoasEscola(escolaInformatica.getPessoasEscola());
                                escolaInformatica.setDiretorEscola(diretorCriado);
                                EscrevePessoasNoFicheiro("pessoasEscola.txt", escolaInformatica.getPessoasEscola());
                                EscreveDiretorNoFicheiro("diretorEscola.txt", escolaInformatica.getDiretorEscola());
                                System.out.println();
                                pedeTecla();
                                break;
                            case 2:
                                Diretor dirfich, dirMod;
                                dirfich = LeDiretorNoFicheiro("diretorEscola.txt");
                                dirMod = modDiretor(dirfich);
                                Programa.removeDiretorDaListaDePessoas(escolaInformatica.getPessoasEscola());
                                escolaInformatica.getPessoasEscola().add(dirMod);
                                escolaInformatica.setPessoasEscola(escolaInformatica.getPessoasEscola());
                                escolaInformatica.setDiretorEscola(dirMod);
                                EscrevePessoasNoFicheiro("pessoasEscola.txt", escolaInformatica.getPessoasEscola());
                                EscreveDiretorNoFicheiro("diretorEscola.txt", escolaInformatica.getDiretorEscola());
                                System.out.println();
                                pedeTecla();
                                break;
                            case 3:
                                ArrayList<Pessoa> pessoasEscola = LePessoaNoFicheiro("pessoasEscola.txt");
                                listarPessoasEscola(pessoasEscola);;
                                break;
                            case 4:
                                EscolaInformatica escolaMod;
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                escolaMod = modificarEscola(LeEscolaNoFicheiro("escolaInformática.txt"));
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaMod);
                                pedeTecla();
                                break;
                            case 5:
                                limpaTela();
                                EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                                EscolaInformatica escolaFich = LeEscolaNoFicheiro("escolaInformática.txt");
                                String escolaInfoDetalhes = mostrarEscola(escolaFich);
                                System.out.print(escolaInfoDetalhes);
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
                                escolaInformatica.setCursosEscola(LeCursosNoFicheiro("cursoTexto.txt"));
                                escolaInformatica.listaCursos();
                                pedeTecla();
                                break;
                            case 2:
                                // Criar curso
                                System.out.println("2. CRIAR CURSO\n");
                                escolaInformatica.addCurso(criarCurso(escolaInformatica));
                                EscreveCursosNoFicheiro("cursoTexto.txt", escolaInformatica.getCursosEscola());
                                System.out.println("\n-->  Curso criado com sucesso!!\n");
                                System.out.println(escolaInformatica.getCursosEscola());
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
                                    EscreveCursosNoFicheiro("cursoTexto.txt", escolaInformatica.getCursosEscola());
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
                                            EscreveCursosNoFicheiro("cursoTexto.txt",
                                                    escolaInformatica.getCursosEscola());
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
                                            EscreveCursosNoFicheiro("cursoTexto.txt",
                                                    escolaInformatica.getCursosEscola());
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
                                "GERIR DISCIPLINAS\n\n1. Listar disciplinas\n2. Criar disciplina\n3. Consultar informações de determinada disciplina\n4. Modificar dados sobre uma disciplina\n5. Remover disciplina\n6. Mostrar qual a disciplina com a frequência mais longa\n7. Mostrar professores que lecionam determinada disciplina\n8. Mostrar alunos inscritos em determinada disciplina\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 8 || opcaoUtilizador < 0) {
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
                                "GERIR PROFESSORES\n\n1. Listar professores\n2. Criar professor\n3. Consultar informações de determinado professor\n4. Modificar dados sobre um determinado professor\n5. Remover professor\n6. Mostrar quais disciplinas lecionou determinado professor\n7. Mostrar professor que lecionou mais disciplinas\n8. Mostrar professores deslocados\n9. Mostrar qual é o professore com melhor rating\n10. Mostrar professor mais velho e mais novo\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 10 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Professores

                                pedeTecla();
                                break;
                            case 2:
                                // Criar Professor

                                pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinado professor

                                pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma determinado professor

                                pedeTecla();
                                break;
                            case 5:
                                // Remover professor

                                pedeTecla();
                                break;
                            case 6:
                                // Mostrar quais disciplinas leciona determinado professor

                                pedeTecla();
                                break;
                            case 7:
                                // Mostrar professores que lecionou mais disciplinas

                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar professores deslocados

                                pedeTecla();
                                break;
                            case 9:
                                // Mostrar professor com melhor rating

                                pedeTecla();
                                break;
                            case 10:
                                // Mostrar professor mais velho e mais novo

                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 10);
                    break;
                case 5:
                    do {
                        limpaTela();
                        System.out.print(
                                "GERIR ALUNOS\n\n1. Listar alunos\n2. Criar aluno\n3. Consultar informações de determinado aluno\n4. Modificar dados sobre um determinado aluno\n5. Remover aluno\n6. Mostrar alunos não deslocados\n7. Mostrar aluno mais velho e mais novo\n8. Mostrar aluno com melhor e pior média, de determinado curso\n9. Mostrar aluno com melhor nota, numa determinada frequência\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while (opcaoUtilizador > 10 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Listar Alunos

                                pedeTecla();
                                break;
                            case 2:
                                // Criar Alunos

                                pedeTecla();
                                break;
                            case 3:
                                // Consultar informações de determinado aluno

                                pedeTecla();
                                break;
                            case 4:
                                // Modificar dados sobre uma determinado aluno

                                pedeTecla();
                                break;
                            case 5:
                                // Remover aluno

                                pedeTecla();
                                break;
                            case 6:
                                // Inscrever aluno em curso

                                pedeTecla();
                                break;
                            case 7:
                                // Mostrar alunos não deslocados

                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar aluno mais velho e mais novo

                                pedeTecla();
                                break;
                            case 9:
                                // Mostrar aluno com melhor e com pior média num determinado curso

                                pedeTecla();
                                break;
                            case 10:
                                // Mostrar aluno com melhor nota numa determinada frequência

                                pedeTecla();
                                break;
                        }
                    } while (opcaoUtilizador > 0 && opcaoUtilizador <= 10);
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
