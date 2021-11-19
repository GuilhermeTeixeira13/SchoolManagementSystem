import java.util.ArrayList;
import java.util.Date;

public class Aluno extends Pessoa{
    //Atributos
    private static int ultimo=0;
    private int numAluno;
    private ArrayList<MediaDisciplina> mediaDisciplinas;
    private ArrayList<Disciplina> disciplinasInscrito;
    private double mediaEntrada;

    // Construtores
    public Aluno(){
        super();
        ultimo ++;
        this.numAluno = ultimo;
        this.disciplinasInscrito = new ArrayList<Disciplina>();
        this.mediaDisciplinas = new ArrayList<MediaDisciplina>();
        this.mediaEntrada = 0;
    }

    public Aluno(Pessoa p, double mediaEntrada, double mediaAtual){
        super(p.getNome(), p.getContactos(), p.getLocalDeOrigem(), p.getEmail(), p.getDataNascimento());
        ultimo ++;
        this.numAluno = ultimo;
        this.disciplinasInscrito = new ArrayList<Disciplina>();
        this.mediaDisciplinas = new ArrayList<MediaDisciplina>();
        this.mediaEntrada = mediaEntrada;
    }

    public Aluno(Aluno a){
        super(a.getNome(), a.getContactos(), a.getLocalDeOrigem(), a.getEmail(), a.getDataNascimento());
        this.numAluno = a.numAluno;
        this.disciplinasInscrito = (ArrayList<Disciplina>) a.disciplinasInscrito.clone();
        this.mediaDisciplinas = (ArrayList<MediaDisciplina>) a.mediaDisciplinas.clone();
        this.mediaEntrada = a.mediaEntrada;
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

    public void setDataNascimento(Date dataNascimento){
        super.setDataNascimento(dataNascimento);
    }
    public Date getDataNascimento(){
       return super.getDataNascimento();
    }

    public void setMediaEntrada(double mediaEntrada){
        this.mediaEntrada = mediaEntrada;
    }
    public double getMediaEntrada(){
       return this.mediaEntrada;
    }

    public void setMediaDisciplinas(ArrayList<MediaDisciplina> mediaDisciplinas){
        this.mediaDisciplinas = (ArrayList<MediaDisciplina>) mediaDisciplinas.clone();
    }
    public ArrayList<MediaDisciplina> getMediaDisciplinas(){
       return this.mediaDisciplinas;
    }

    public void setDisciplinasInscrito(ArrayList<Disciplina> disciplinasInscrito){
        this.disciplinasInscrito = (ArrayList<Disciplina>) disciplinasInscrito.clone();
    }
    public ArrayList<Disciplina> getDisciplinasInscrito(){
       return this.disciplinasInscrito;
    }

    // toString
    public String toString(){
        String s;
        s = super.toString();
        s = s + " / Média de entrada: " + this.mediaEntrada + " / Nº.Aluno: "+numAluno+"\n" + "Média das Disciplinas: " + mediaDisciplinas + "\n" + "Disciplinas do Aluno: " + disciplinasInscrito;
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            Aluno e = (Aluno) obj;
            ig = super.equals(e);
            ig = ig && (this.mediaDisciplinas.equals(e.mediaDisciplinas)) && (this.mediaEntrada == e.mediaEntrada) && (this.numAluno == e.numAluno) && (this.disciplinasInscrito.equals(e.disciplinasInscrito));
        }
        else
            ig = false;
        return ig;
    }

    // Clone
    public Object clone(){
        Aluno copia = new Aluno(this);
        return copia;
    }

    public static void main(String[] args) {
        //À  espera das outras classes para conseguir elaborar a classe teste do Aluno
    }
}