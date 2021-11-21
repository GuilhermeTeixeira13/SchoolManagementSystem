public class Programa {
    public static void main(String[] args) {
        int opcaoUtilizador;
        System.out.println("Escola Professional de Informática");

        do{
            System.out.print("1 - Gerir Escola\n2 - Gerir Cursos\n3 - Gerir Disciplinas\n4 - Gerir Professores\n5 - Gerir Alunos\n6 - Gerir Professores");
            opcaoUtilizador = Ler.umInt();
        }while(opcaoUtilizador != 0 || opcaoUtilizador < 0 || opcaoUtilizador > 5);
    }
}
