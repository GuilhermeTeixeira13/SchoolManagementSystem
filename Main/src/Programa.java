public class Programa {
    public static void main(String[] args) {
        int opcaoUtilizador;
        String avancar;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Escola Professional de Informática\n1 - Gerir Escola\n2 - Gerir Cursos\n3 - Gerir Disciplinas\n4 - Gerir Professores\n5 - Gerir Alunos\n6 - Gerir Frequências\n0 - Sair\nESCOLHA A SUA OPCAO -> ");
        opcaoUtilizador = Ler.umInt();
        while(opcaoUtilizador > 0 && opcaoUtilizador <= 6){
            switch (opcaoUtilizador) {
                case 1:
                    do{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("GERIR ESCOLA\n1 - Informações sobre o Diretor\n2 - Alterar diretor\n3 - Modificar dados acerca do atual diretor\n0 - Voltar ao menu anterior\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 3 || opcaoUtilizador < 0){
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        switch (opcaoUtilizador) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                // Mostrar dados acerca do atual diretor;
                                
                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString();
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                // Alterar o diretor, removendo o anterior de forma automética;
                                
                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString();         
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                // Modificar dados sobre o diretor;

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 3);
                    break;
                case 2:
                    do{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("GERIR CURSOS\n1 - Listar cursos\n2 - Criar curso\n3 - Consultar informações de determinado curso\n4 - Modificar dados sobre um curso\n5 - Remover curso\n6 - Mostrar curso mais frequentado\n7 - Mostrar professores que lecionam disciplinas de determinado curso\n0 - Voltar ao menu anterior\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 7 || opcaoUtilizador < 0){
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        switch (opcaoUtilizador) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Listar Cursos

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Criar Curso

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Consultar informações de determinado curso

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 4:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Modificar dados sobre determinado curso

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 5:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Remover curso

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 6:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar curso mais frequentado

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 7:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar professores que lecionam as disciplinas de determinado curso

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                                
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 7);
                    break;    
                case 3:
                    do{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("GERIR DISCIPLINAS\n1 - Listar disciplinas\n2 - Criar disciplina\n3 - Consultar informações de determinada disciplina\n4 - Modificar dados sobre uma disciplina\n5 - Remover disciplina\n6 - Mostrar qual a disciplina com a frequência mais longa\n7 - Mostrar professores que lecionam determinada disciplina\n8 - Mostrar alunos inscritos em determinada disciplina\n0 - Voltar ao menu anterior\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 8 || opcaoUtilizador < 0){
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        switch (opcaoUtilizador) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Listar Disciplinas

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Criar Disciplina

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Consultar informações de determinada disciplina

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 4:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Modificar dados sobre uma determinada disciplina

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 5:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Remover disciplina

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 6:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar a disciplina com a frequência mais longa

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 7:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar professores que lecionam determianda disciplina

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 8:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar alunos inscritos em determinada disciplina
                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString();
                                break;                                
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 8);
                    break;
                case 4:
                    do{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("GERIR PROFESSORES\n1 - Listar professores\n2 - Criar professor\n3 - Consultar informações de determinado professor\n4 - Modificar dados sobre um determinado professor\n5 - Remover professor\n6 - Mostrar quais disciplinas lecionou determinado professor\n7 - Mostrar professor que lecionou mais disciplinas\n8 - Mostrar professores deslocados\n9 - Mostrar qual é o professore com melhor rating\n10 - Mostrar professor mais velho e mais novo\n0 - Voltar ao menu anterior\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 10 || opcaoUtilizador < 0){
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        switch (opcaoUtilizador) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Listar Professores

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Criar Professor

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Consultar informações de determinado professor

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 4:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Modificar dados sobre uma determinado professor

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 5:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Remover professor

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 6:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar quais disciplinas leciona determinado professor

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 7:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar professores que lecionou mais disciplinas

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 8:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar professores deslocados

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString();
                                break;
                            case 9:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar professor com melhor rating

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString();
                                break;
                            case 10:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar professor mais velho e mais novo

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString();
                                break;                                    
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 10);
                    break;
                case 5:
                    do{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("GERIR ALUNOS\n1 - Listar alunos\n2 - Criar aluno\n3 - Consultar informações de determinado aluno\n4 - Modificar dados sobre um determinado aluno\n5 - Remover aluno\n6 - Mostrar alunos não deslocados\n7 - Mostrar aluno mais velho e mais novo\n8 - Mostrar aluno com melhor e pior média, de determinado curso\n9 - Mostrar aluno com melhor e pior média, de determinado curso\n10 - Mostrar aluno com melhor nota numa determinada frequência\n0 - Voltar ao menu anterior\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 10 || opcaoUtilizador < 0){
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        switch (opcaoUtilizador) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Listar Alunos

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Criar Alunos

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Consultar informações de determinado aluno

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 4:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Modificar dados sobre uma determinado aluno

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 5:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Remover aluno

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 6:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar alunos não deslocados

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 7:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar aluno mais velho e mais novo

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 8:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar aluno com melhor e com pior média

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString();
                                break;
                            case 9:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar aluno com melhor nota numa determinada frequência

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString();
                                break;                                    
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 10);
                    break;
                case 6:
                    do{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("GERIR FREQUÊNCIAS\n1 - Listar Frequências de determinada disciplina\n2 - Mostrar determinada frequência, dado o ID da mesma\n3 - Mostrar a pergunta com maior cotação, de determinada frequência\n4 - Mostrar frequências por nível de dificuldade\n5 - Mostrar frequências elaboradas por determinado professor\n6 - Mostrar frequências de determinado curso\n0 - Voltar ao menu anterior\nESCOLHA A SUA OPCÃO -> ");
                        opcaoUtilizador = Ler.umInt();
                        while(opcaoUtilizador > 6 || opcaoUtilizador < 0){
                            System.out.print("OPCÃO INVÁLIDA! DIGITE A SUA OPÇÃO --> ");
                            opcaoUtilizador = Ler.umInt();
                        }
                        switch (opcaoUtilizador) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Listar Frequências de determinada disciplina

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar determinada Frequência, dado o ID da mesma

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar a pergunta com maior cotação, de determinada frequência

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 4:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar frequências por nível de dificuldade

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 5:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar frequências elaboradas por determinado professor

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 6:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                // Mostrar frequências de determinado curso

                                System.out.print("Pressione alguma tecla para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;                                  
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 6);
                    break;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();         
            System.out.print("Escola Professional de Informática\n1 - Gerir Escola\n2 - Gerir Cursos\n3 - Gerir Disciplinas\n4 - Gerir Professores\n5 - Gerir Alunos\n6 - Gerir Professores\n0 - Sair\nESCOLHA A SUA OPCAO -> ");
            opcaoUtilizador = Ler.umInt();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.print("🔌 Programa elaborado por:\n\n👉 João Martins\n👉 Guilherme Teixeira\n👉 Cláudio Redondo\n👉 Tiago Ribeiro\n\n🖥️  POO - Engenharia Informática - UBI 🖥️");
    }
}
