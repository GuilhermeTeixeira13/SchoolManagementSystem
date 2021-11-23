import java.util.Date;
import java.text.SimpleDateFormat;

public class Programa {
    public static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void pedeTecla() {
        System.out.print("Pressione alguma tecla para avançar --> ");
        Ler.umaString();
    }
    public static Date pedeDatanascimento() throws Exception{
        System.out.print("Digite uma data no formato 'dd/MM/yyyy' --> ");
        String sDataNascimento = Ler.umaString();
        Date DataNascimento = new SimpleDateFormat("dd/MM/yyy").parse(sDataNascimento);
        return DataNascimento;
    }

    public static void main(String[] args) {
        int opcaoUtilizador;
        limpaTela();
        System.out.print("💻 ESCOLA PROFISSIONAL DE INFORMÁTICA 💻\n\n1. 🏫 Gerir Escola\n2. 🔖 Gerir Cursos\n3. 📘 Gerir Disciplinas\n4. 👴 Gerir Professores\n5. 👨 Gerir Alunos\n6. 📑 Gerir Frequências\n\n0. ❌ Sair\n\nESCOLHA A SUA OPÇÃO -> ");
        opcaoUtilizador = Ler.umInt();
        while(opcaoUtilizador > 0 && opcaoUtilizador <= 6){
            switch (opcaoUtilizador) {
                case 1:
                    do{
                        limpaTela();
                        System.out.print("🏫 GERIR ESCOLA 🏫\n\n1. Informações sobre o Diretor\n2. Alterar diretor\n3. Modificar dados acerca do atual diretor\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 3 || opcaoUtilizador < 0){
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        limpaTela();
                        switch (opcaoUtilizador) {
                            case 1:
                                // Mostrar dados acerca do atual diretor;
                                
                                pedeTecla();
                                break;
                            case 2:
                                // Alterar o diretor, removendo o anterior de forma automática;
                                
                                pedeTecla();        
                                break;
                            case 3:
                                // Modificar dados sobre o diretor;

                                pedeTecla();
                                break;
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 3);
                    break;
                case 2:
                    do{
                        limpaTela();
                        System.out.print("🔖  GERIR CURSOS 🔖\n\n1. Listar cursos\n2. Criar curso\n3. Consultar informações de determinado curso\n4. Modificar dados sobre um curso\n5. Remover curso\n6. Mostrar curso mais frequentado\n7. Mostrar professores que lecionam disciplinas de determinado curso\n\n0. Voltar ao menu anterior\n\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 7 || opcaoUtilizador < 0){
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
                            case 7:
                                // Mostrar professores que lecionam as disciplinas de determinado curso

                                pedeTecla();
                                break;
                                
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 7);
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
        limpaTela();
        System.out.print("_______________________________________________\n");
        System.out.print("🔌 Programa elaborado por:\n\n👉 João Martins\n👉 Guilherme Teixeira\n👉 Cláudio Redondo\n👉 Tiago Ribeiro\n\n🖥️  POO - Engenharia Informática - UBI 🖥️");
        System.out.print("\n_______________________________________________\n");
    }
}
