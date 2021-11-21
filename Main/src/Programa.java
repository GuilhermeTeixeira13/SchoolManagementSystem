public class Programa {
    public static void main(String[] args) {
        int opcaoUtilizador;
        String avancar;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Escola Professional de Informática\n1 - Gerir Escola\n2 - Gerir Cursos\n3 - Gerir Disciplinas\n4 - Gerir Professores\n5 - Gerir Alunos\n6 - Gerir Professores\n0 - Sair\nESCOLHA A SUA OPCAO -> ");
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
                                
                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString();
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                // Alterar o diretor, removendo o anterior de forma automética;
                                
                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString();         
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                // Modificar dados sobre o diretor;

                                System.out.print("Digite qualquer LETRA para avançar --> ");
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
                                
                                //

                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                //

                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 3:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                //

                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 4:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                //

                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 5:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                //

                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 6:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                //

                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                            case 7:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();  
                                
                                //

                                System.out.print("Digite qualquer LETRA para avançar --> ");
                                avancar = Ler.umaString(); 
                                break;
                                
                        }
                    }while(opcaoUtilizador > 0 && opcaoUtilizador <= 7);
                    break;    
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();         
            System.out.print("Escola Professional de Informática\n1 - Gerir Escola\n2 - Gerir Cursos\n3 - Gerir Disciplinas\n4 - Gerir Professores\n5 - Gerir Alunos\n6 - Gerir Professores\n0 - Sair\nESCOLHA A SUA OPCAO -> ");
            opcaoUtilizador = Ler.umInt();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("Obrigado por usufruir do nosso programa!");
    }
}
