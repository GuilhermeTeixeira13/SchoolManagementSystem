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

    public void setContactos(Contactos contactos){
        super.setContactos(contactos);
    }
    public Contactos getContactos(){
        return super.getContactos();
    }

    public void setLocalDeOrigem(String localDeOrigem){
        super.setLocalDeOrigem(localDeOrigem);;
    }
    public String getLocalDeOrigem(){
        return super.getLocalDeOrigem();
    }

    public void setEmail(String email){
        super.setEmail(email);
    }
    public String getEmail(){
       return super.getEmail();
    }

    public void setDataDeNascimento(Date dataNascimento){
        super.setDataNascimento(dataNascimento);
    }
    public Date getDataDeNascimento(){
       return super.getDataNascimento();
    }

    public void setMediaEntrada(double mediaEntrada){
        this.mediaEntrada = mediaEntrada;
    }
    public double getMediaEntrada(){
       return this.mediaEntrada;
    }

    public void setMediaAtual(double mediaAtual){
        this.mediaAtual = mediaAtual;
    }
    public double getMediaAtual(){
       return this.mediaAtual;
    }

    // toString
    public String toString(){
        String s;
        s = super.toString();
        s = s + " / Média de entrada: " + this.mediaEntrada + " / Média Atual de Curso: " + this.mediaAtual + " / Nº.Aluno: "+numAluno+"\n";
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            Aluno e = (Aluno) obj;
            ig = super.equals(e);
            ig = ig && (this.mediaAtual == e.mediaAtual) && (this.mediaEntrada == e.mediaEntrada) && (this.numAluno == e.numAluno);
        }
        else
            ig = false;
        return ig;
    }

    // Clone
    public Object clone(){
        Aluno copia = new Aluno();
        copia = (Aluno)super.clone();
        copia.mediaAtual = this.mediaAtual;
        copia.mediaEntrada = this.mediaAtual;
        copia.numAluno = this.numAluno;
        return copia;
    }

    public static void main(String[] args) {
        
    }
}