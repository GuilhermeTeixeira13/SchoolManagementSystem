import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public class Programa implements Serializable{
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
            EscolaInformatica  obj = new EscolaInformatica();
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

    public static void main(String[] args) {
        int opcaoUtilizador;
        limpaTela();
        System.out.print(
                "ESCOLA PROFISSIONAL DE INFORMÁTICA\n\n1. Gerir Escola\n2. Gerir Cursos\n3. Gerir Disciplinas\n4. Gerir Professores\n5. Gerir Alunos\n6. Gerir Frequências\n\n0. Sair\n\nESCOLHA A SUA OPÇÃO -> ");

        ArrayList<Curso> cursosEscola = new ArrayList<Curso>();
        ArrayList<Pessoa> pessoasEscola = new ArrayList<Pessoa>();
        ArrayList<Disciplina> disciplinasEscola = new ArrayList<Disciplina>();
        Diretor diretorEscola = new Diretor();
        Contactos contactosEscola = new Contactos();
        String locallizaçãoEscola = "Covilhã";
        EscolaInformatica escolaInformatica = new EscolaInformatica("Escola de Informática", 8, cursosEscola,
                pessoasEscola, disciplinasEscola, diretorEscola, contactosEscola, locallizaçãoEscola);
        
        cursosEscola = LeCursosNoFicheiro("cursoTexto.txt");
        diretorEscola = LeDiretorNoFicheiro("diretorEscola.txt");
        escolaInformatica.setDiretorEscola(diretorEscola);
        pessoasEscola = LePessoaNoFicheiro("pessoasEscola.txt");
        escolaInformatica.setPessoasEscola(pessoasEscola);
        escolaInformatica.setCursosEscola(cursosEscola);
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

                        Programa.removeDiretorDaListaDePessoas(pessoasEscola);
                        pessoasEscola.add(novodiretor);
                        escolaInformatica.setPessoasEscola(pessoasEscola);
                        escolaInformatica.setDiretorEscola(novodiretor);
                        EscrevePessoasNoFicheiro("pessoasEscola.txt", pessoasEscola);
                        EscreveDiretorNoFicheiro("diretorEscola.txt", escolaInformatica.getDiretorEscola());
                        pedeTecla();
                        break;
                    case 2:
                        Diretor dirlido = new Diretor();
                        Contactos dirlidocontact = new Contactos();
                        ArrayList<Telefone> dirlidotelefone = new ArrayList<>();
                        dirlido = LeDiretorNoFicheiro("diretorEscola.txt");
                        int opcaomoddiretor, anosserviconovo;
                        String novoemail, novolocalorigem, novonome, formacaonova;
                        System.out.println(" MODIFICAR DIRETOR\n");
                        System.out.println("1. Alterar email\n2. Alterar telefones\n3. Alterar data de nascimento\n4. Alterar local de origem\n5. Alterar nome\n6. Alterar anos de serviço\n7. Alterar formação académica\n\n0. Voltar Atrás");
                        System.out.print("ESCOLHA A SUA OPÇÃO -> ");
                        opcaomoddiretor = Ler.umInt();
                        while (opcaomoddiretor > 7 || opcaoUtilizador < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaomoddiretor = Ler.umInt();
                        }
                        switch (opcaomoddiretor) {
                        case 1:
                            limpaTela();
                            System.out.print("\nEmail do Diretor: ");
                            novoemail = Ler.umaString();
                            dirlidocontact = dirlido.getContactos();
                            dirlidocontact.setE_mail(novoemail);
                            break;
                        case 2:
                            System.out.println("Telefones");
                            do {
                                System.out.print("\nTipo: ");
                                tipoContacto = Ler.umaString();

                                System.out.print("Número: ");
                                numeroContacto = Ler.umLong();

                                Telefone telefone = new Telefone(tipoContacto, numeroContacto);

                                dirlidotelefone.add(telefone);

                                System.out.print("Pretende inserir mais telefones? [S/N] -> ");

                                opcaoContactoMenu = Ler.umaString();
                            } while (!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));
                            dirlidocontact.setTelefone(dirlidotelefone);
                            break;
                        case 3:
                            limpaTela();
                            System.out.print("Data de Nascimento do Diretor: ");
                            LocalDate dataNascimentoDiretorMod = pedeData();
                            dirlido.setDataDeNascimento(dataNascimentoDiretorMod);
                            dirlido.setDataDeNascimento(dataNascimentoDiretorMod);
                            pedeTecla();
                            break;
                        case 4:
                            limpaTela();
                            System.out.print("Alterar Local de Origem: ");
                            novolocalorigem = Ler.umaString();
                            dirlido.setLocalDeOrigem(novolocalorigem);
                            break;
                        case 5:
                            limpaTela();
                            System.out.print("Alterar Nome: ");
                            novonome = Ler.umaString();
                            dirlido.setNome(novonome);
                            break;
                        case 6:
                            limpaTela();
                            System.out.print("Anos de Serviço: ");
                            anosserviconovo = Ler.umInt();
                            dirlido.setAnosDeServico(anosserviconovo);
                            break;

                        case 7:
                            limpaTela();
                            System.out.print("Formação Académica: ");
                            formacaonova = Ler.umaString();
                            dirlido.setFormacaoAcademica(formacaonova);
                            break;
                        }
                        Programa.removeDiretorDaListaDePessoas(pessoasEscola);
                        pessoasEscola.add(dirlido);
                        escolaInformatica.setPessoasEscola(pessoasEscola);
                        escolaInformatica.setDiretorEscola(dirlido);
                        EscreveDiretorNoFicheiro("diretorEscola.txt", escolaInformatica.getDiretorEscola());
                        pedeTecla();
                        break;
                    case 3:
                        EscrevePessoasNoFicheiro("pessoasEscola.txt", pessoasEscola);
                        ArrayList<Pessoa> pessoasAtaulizada = new ArrayList<Pessoa>();
                        pessoasAtaulizada = LePessoaNoFicheiro("pessoasEscola.txt");
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
                            opcaoUtilizador = Ler.umInt();
                        }
                        switch (opcaolistpessoas) {
                        case 1:
                            listapessoas = identDiretor(pessoasAtaulizada);
                            System.out.println("Diretor: " + listapessoas);
                            break;
                        case 2:
                            listapessoas = identProf(pessoasAtaulizada);
                            System.out.println("Professores: " + listapessoas);
                            break;
                        case 3:
                            listapessoas = identAluno(pessoasAtaulizada);
                            System.out.println("Aluno: " + listapessoas);
                            break;
                        }
                        pedeTecla();
                        break;
                    case 4:
                        EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                        EscolaInformatica escolaatualizada = new EscolaInformatica();
                        escolaatualizada = LeEscolaNoFicheiro("escolaInformática.txt");
                        int opcaomodescola;
                        String novonomeescola;
                        int novonumescola;
                        String novalocalizacao;
                        System.out.print(" MUDAR INFORMAÇÕES ACERCA DA ESCOLA\n\n");
                        System.out.println("1. Nome\n2. Número\n3. Contactos\n4. Localização\n\n0. Voltar");
                        System.out.print("ESCOLHA A SUA OPÇÃO -> ");
                        opcaomodescola = Ler.umInt();
                        while (opcaomodescola > 4 || opcaomodescola < 0) {
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaomodescola = Ler.umInt();
                        }
                        switch(opcaomodescola){
                            case 1:
                            System.out.print("Introduza o novo nome: ");
                            novonomeescola = Ler.umaString();
                            escolaInformatica.setNomeEscola(novonomeescola);
                            break;
                            case 2:
                            String emailescolaatua; 
                            System.out.print("Introduza o novo número: ");
                            novonumescola = Ler.umInt();
                            escolaInformatica.setCodEscola(novonumescola);
                            break;
                            case 3:
                            Contactos contactosescolaatua;
                            contactosescolaatua = escolaatualizada.getContactoEscola();
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
                            emailescolaatua = contactosescolaatua.getE_mail();
                            Contactos contactescolatua = new Contactos(emailescolaatua);
                            contactescolatua.setTelefone(telefoneescolaatua);
                            escolaInformatica.setContactoEscola(contactescolatua);
                            case 4:
                            System.out.println("Localização: ");
                            novalocalizacao = Ler.umaString();
                            escolaInformatica.setLocalizacao(novalocalizacao);
                        }

                        pedeTecla();
                        break;
                    case 5:
                        System.out.print("INFORMAÇÕES ESCOLA\n\n");
                        EscreveEscolaNoFicheiro("escolaInformática.txt", escolaInformatica);
                        EscolaInformatica infosescola = LeEscolaNoFicheiro("escolaInformática.txt");
                        String descricaoescola = infosescola.toString();
                        System.out.print(descricaoescola);
                        pedeTecla();
                        break;
                    }
                } while (opcaoUtilizador > 0 && opcaoUtilizador <= 5);
                break;
            case 2:
                do {
                    limpaTela();
                    System.out.print(
                            " GERIR CURSOS\n\n1. Listar cursos\n2. Criar curso\n3. Consultar informações de determinado curso\n4. Modificar dados sobre um curso\n5. Remover curso\n6. Mostrar curso mais frequentado\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                    opcaoUtilizador = Ler.umInt();
                    while (opcaoUtilizador > 6 || opcaoUtilizador < 0) {
                        System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                        opcaoUtilizador = Ler.umInt();
                    }
                    limpaTela();
                    switch (opcaoUtilizador) {
                    case 1:
                        // Listar Cursos

                        pedeTecla();
                        break;
                    case 2:
                        System.out.println("1. CRIAR CURSO\n");
                        Curso novocurso = new Curso();

                        String nomeCurso, opcaoContactoMenu;
                        int duracaoCurso, codCurso, escolhaDisc;
                        float mediaUltimoColocado;
                        LocalDate dataInicioCurso, dataFimCurso;
                        ArrayList<String> provasIngresso = new ArrayList<String>();

                        System.out.print("Nome do Curso: ");
                        nomeCurso = Ler.umaString();
                        novocurso.setNomeCurso(nomeCurso);

                        System.out.print("\nCódigo do Curso: ");
                        codCurso = Ler.umInt();
                        novocurso.setCodCurso(codCurso);
                        ;

                        System.out.println(
                                "\n------------------------------------------------------------------------------");
                        System.out.println("Disciplinas do Curso: \n");

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
                                novocurso.addDisciplina(escolaInformatica.getDisciplinaEscola().get(escolhaDisc));
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
                        System.out.println(
                                "------------------------------------------------------------------------------\n");

                        System.out.println("Provas Ingresso:");
                        String prova;
                        do {
                            System.out.print("\nAdicione uma prova de ingresso --> ");
                            prova = Ler.umaString();
                            provasIngresso.add(prova);
                            System.out.print("Pretende inserir mais provas de ingresso? [S/N] -> ");
                            opcaoContactoMenu = Ler.umaString();
                            while (!opcaoContactoMenu.equals("n") && !opcaoContactoMenu.equals("N")
                                    && !opcaoContactoMenu.equals("S") && !opcaoContactoMenu.equals("s")) {
                                System.out.print("ERRO! Pretende inserir mais provas de ingresso? [S/N] -> ");
                                opcaoContactoMenu = Ler.umaString();
                            }
                        } while (opcaoContactoMenu.equals("s") || opcaoContactoMenu.equals("S"));
                        novocurso.setProvasIngresso(provasIngresso);
                        System.out.println(
                                "------------------------------------------------------------------------------\n");

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
                        novocurso.setDataInicio(dataInicioCurso);
                        novocurso.setDataFim(dataFimCurso);

                        System.out.print("\nDuração do Curso em horas: ");
                        duracaoCurso = Ler.umInt();
                        novocurso.setDuracaoEmHoras(duracaoCurso);
                        ;

                        System.out.print("\nMédia do Último Colocado: ");
                        mediaUltimoColocado = Ler.umInt();
                        novocurso.setMediaUltimoColocado(mediaUltimoColocado);

                        escolaInformatica.addCurso(novocurso);

                        EscreveCursosNoFicheiro("cursoTexto.txt", escolaInformatica.getCursosEscola());

                        System.out.println("\n-->  Curso criado com sucesso!!\n");

                        System.out.println(escolaInformatica.getCursosEscola());

                        pedeTecla();
                        break;
                    case 3:
                        // Consultar informações de determinado curso

                        pedeTecla();
                        break;
                    case 4:
                        // Modificar dados sobre determinado curso

                        pedeTecla();
                        break;
                    case 5:
                        // Remover curso

                        pedeTecla();
                        break;
                    case 6:
                        // Mostrar curso mais frequentado

                        pedeTecla();
                        break;
                    }
                } while (opcaoUtilizador > 0 && opcaoUtilizador <= 6);
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
