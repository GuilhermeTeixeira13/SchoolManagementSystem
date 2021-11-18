import java.util.Date;


public class Aluno extends Pessoa{
    //Atributos
    private static int ultimo=0;
    private int numAluno;
    private double mediaAtual;
    private double mediaEntrada;

    // Construtores
    public Aluno(){
        super();
        ultimo ++;
        this.numAluno = ultimo;
        this.mediaAtual = 0;
        this.mediaEntrada = 0;
    }

    public Aluno(String nome, Contactos contactos, String localDeOrigem, String email, Date dataNascimento, double mediaEntrada, double mediaAtual){
        super(nome, contactos, localDeOrigem, email, dataNascimento);
        ultimo ++;
        this.numAluno = ultimo;
        this.mediaAtual = mediaAtual;
        this.mediaEntrada = mediaEntrada;
    }

    //Getters e Setters
    public void setNome(String nome){
        super.setNome(nome);
    }
    public String getNome(){
        return super.getNome();
    }


}