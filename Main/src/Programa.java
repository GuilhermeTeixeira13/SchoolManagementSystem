import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Programa {
    public static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pedeTecla() {
        System.out.print("Pressione alguma tecla para avançar --> ");
        Ler.umaString();
    }

    public static boolean verificaData(String data){
        boolean correto = false;
        if(data.length() != 10)
            correto = false;
        else{
            if((data.charAt(0) == '0' && data.charAt(1) == '0') || (data.charAt(3) == '0' && data.charAt(4) == '0') || (data.charAt(6) == '0' && data.charAt(7) == '0' && data.charAt(8) == '0' && data.charAt(9) == '0') || (data.charAt(2) != '/' || data.charAt(5) != '/'))
                correto = false;
            else
                correto = true; 
        }
        return correto;
    }

    public static LocalDate pedeData() throws Exception{
        boolean verificaString;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        System.out.print("Digite uma data no formato 'dd/MM/yyyy' --> ");
        String dateString = Ler.umaString();
        verificaString = verificaData(dateString);
        while(verificaString == false){
            System.out.print("INVÁLIDA! Digite uma data no formato 'dd/MM/yyyy' --> ");
            dateString = Ler.umaString();
            verificaString = verificaData(dateString);
        }
        LocalDate data = LocalDate.parse(dateString, formatter);
        return data;
    }

    public static void removeDiretorDaListaDePessoas(ArrayList<Pessoa> pessoasEscola){
        for(int i=0; i<pessoasEscola.size(); i++){
            if(pessoasEscola.get(i) instanceof Diretor)
                pessoasEscola.remove(i);
        }
    }

    public static void main(String[] args) throws Exception{
        int opcaoUtilizador;
        limpaTela();
        System.out.print("💻 ESCOLA PROFISSIONAL DE INFORMÁTICA 💻\n\n1. 🏫 Gerir Escola\n2. 🔖 Gerir Cursos\n3. 📘 Gerir Disciplinas\n4. 👴 Gerir Professores\n5. 👨 Gerir Alunos\n6. 📑 Gerir Frequências\n\n0. ❌ Sair\n\nESCOLHA A SUA OPÇÃO -> ");
        ArrayList<Curso> cursosEscola = new ArrayList<Curso>();
        ArrayList<Pessoa> pessoasEscola = new ArrayList<Pessoa>();
        ArrayList<Disciplina> disciplinasEscola = new ArrayList<Disciplina>();
        Diretor diretorEscola = new Diretor();
        Contactos contactosEscola = new Contactos();
        String locallizaçãoEscola = "Covilhã";
        EscolaInformatica escolaInformatica = new EscolaInformatica("Escola de Informática", 8, cursosEscola, pessoasEscola, disciplinasEscola, diretorEscola, contactosEscola, locallizaçãoEscola);
        opcaoUtilizador = Ler.umInt();
        while(opcaoUtilizador > 0 && opcaoUtilizador <= 5){
            switch (opcaoUtilizador) {
                case 1:
                    do{
                        limpaTela();
                        System.out.print("🏫 GERIR ESCOLA 🏫\n\n1. Criar Diretor (Removendo automaticamento o anterior)\n2. Modificar dados acerca do atual diretor\n3. Listar Pessoas\n4. Mudar informações acerca da escola (Nome, Número, Contactos, Localização)\n5. Informações da escola\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 4 || opcaoUtilizador < 0){
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

                                System.out.println("\n------------------------------------------------------------------------------");
                                System.out.println("Telefones");
                                do{
                                    System.out.print("\nTipo: ");
                                    tipoContacto = Ler.umaString();
                                        
                                    System.out.print("Número: ");
                                    numeroContacto = Ler.umLong();
                                        
                                    Telefone telefone = new Telefone(tipoContacto, numeroContacto);

                                    telefones.add(telefone);

                                    System.out.print("Pretende inserir mais telefones? [S/N] -> ");

                                    opcaoContactoMenu = Ler.umaString();
                                }while(!opcaoContactoMenu.equals("N") && !opcaoContactoMenu.equals("n"));   
                                contactosdir.setTelefone(telefones);
                                System.out.println("------------------------------------------------------------------------------");
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

                                escolaInformatica.setDiretorEscola(novodiretor);
                                Programa.removeDiretorDaListaDePessoas(pessoasEscola);
                                pessoasEscola.add(novodiretor);
                                escolaInformatica.setPessoasEscola(pessoasEscola);

                                System.out.println("\n✔️  Diretor criado com sucesso!!\n");

                                System.out.println(pessoasEscola);
                                
                                pedeTecla();  
                                break;
                            case 2:
                                // Modificar dados acerca do atual diretor    

                                pedeTecla();        
                                break;
                            case 3:
                                // Listar Pessoas    

                                pedeTecla();        
                                break;
                            case 4:
                                // Mudar informações acerca da escola (Nome, Número, Contactos, Localização) 

                                pedeTecla();        
                                break;
                            case 5:
                                // Mostrar informações da escola    

                                pedeTecla();        
                                break;
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 5);
                    break;
                case 2:
                    do{
                        limpaTela();
                        System.out.print("🔖  GERIR CURSOS 🔖\n\n1. Listar cursos\n2. Criar curso\n3. Consultar informações de determinado curso\n4. Modificar dados sobre um curso\n5. Remover curso\n6. Mostrar curso mais frequentado\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 6 || opcaoUtilizador < 0){
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
                                // Criar Curso

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
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 6);
                    break;    
                case 3:
                    do{
                        limpaTela();
                        System.out.print("📘  GERIR DISCIPLINAS 📘\n\n1. Listar disciplinas\n2. Criar disciplina\n3. Consultar informações de determinada disciplina\n4. Modificar dados sobre uma disciplina\n5. Remover disciplina\n6. Mostrar qual a disciplina com a frequência mais longa\n7. Mostrar professores que lecionam determinada disciplina\n8. Mostrar alunos inscritos em determinada disciplina\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 8 || opcaoUtilizador < 0){
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
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 8);
                    break;
                case 4:
                    do{
                        limpaTela();
                        System.out.print("👴  GERIR PROFESSORES  👴\n\n1. Listar professores\n2. Criar professor\n3. Consultar informações de determinado professor\n4. Modificar dados sobre um determinado professor\n5. Remover professor\n6. Mostrar quais disciplinas lecionou determinado professor\n7. Mostrar professor que lecionou mais disciplinas\n8. Mostrar professores deslocados\n9. Mostrar qual é o professore com melhor rating\n10. Mostrar professor mais velho e mais novo\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 10 || opcaoUtilizador < 0){
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
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 10);
                    break;
                case 5:
                    do{
                        limpaTela();
                        System.out.print("👨  GERIR ALUNOS  👨\n\n1. Listar alunos\n2. Criar aluno\n3. Consultar informações de determinado aluno\n4. Modificar dados sobre um determinado aluno\n5. Remover aluno\n6. Mostrar alunos não deslocados\n7. Mostrar aluno mais velho e mais novo\n8. Mostrar aluno com melhor e pior média, de determinado curso\n9. Mostrar aluno com melhor nota, numa determinada frequência\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 10 || opcaoUtilizador < 0){
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
                                // Mostrar alunos não deslocados

                                pedeTecla();
                                break;
                            case 7:
                                // Mostrar aluno mais velho e mais novo

                                pedeTecla();
                                break;
                            case 8:
                                // Mostrar aluno com melhor e com pior média num determinado curso

                               pedeTecla();
                                break;
                            case 9:
                                // Mostrar aluno com melhor nota numa determinada frequência

                                pedeTecla();
                                break;                                    
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 10);
                    break;
                case 6:
                    do{
                        limpaTela();
                        System.out.print("📑  GERIR FREQUÊNCIAS  📑\n\n1. Listar Frequências de determinada disciplina\n2. Criar Frequência\n3. Mostrar determinada frequência, dado o ID da mesma\n4. Modificar dados sobre uma Frequência\n5. Remover Frequência\n6. Mostrar a pergunta com maior cotação, de determinada frequência\n7. Mostrar frequências por nível de dificuldade\n8. Mostrar frequências elaboradas por determinado professor\n9. Mostrar frequências de determinado curso\n10. Mostrar frequências de determinada disciplina\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 10 || opcaoUtilizador < 0){
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
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 10);
                    break;
            }
            limpaTela();       
            System.out.print("💻 ESCOLA PROFISSIONAL DE INFORMÁTICA 💻\n\n1. 🏫 Gerir Escola\n2. 🔖 Gerir Cursos\n3. 📘 Gerir Disciplinas\n4. 👴 Gerir Professores\n5. 👨 Gerir Alunos\n6. 📑 Gerir Frequências\n\n0. ❌ Sair\n\nESCOLHA A SUA OPÇÃO -> ");
            opcaoUtilizador = Ler.umInt();
        }

    limpaTela();System.out.print("_______________________________________________\n");System.out.print("🔌 Programa elaborado por:\n\n👉 João Martins\n👉 Guilherme Teixeira\n👉 Cláudio Redondo\n👉 Tiago Ribeiro\n\n🖥️  POO - Engenharia Informática - UBI 🖥️");System.out.print("\n_______________________________________________\n");
}}
