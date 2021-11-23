import java.util.ArrayList;
import java.time.LocalDate;


public class Aluno extends Pessoa{
    //Atributos
    private static int ultimo=0;
    private int numAluno;
    private ArrayList<NotasDisciplina> notasDisciplinas;
    private ArrayList<Disciplina> disciplinasInscrito;
    private double mediaEntrada;

    // Construtores
    public Aluno(){
        super();
        ultimo ++;
        this.numAluno = ultimo;
        this.disciplinasInscrito = new ArrayList<Disciplina>();
        this.notasDisciplinas = new ArrayList<NotasDisciplina>();
        this.mediaEntrada = 0;
    }

    public Aluno(Pessoa p, double mediaEntrada, double mediaAtual){
        super(p.getNome(), p.getContactos(), p.getLocalDeOrigem(), p.getDataNascimento());
        ultimo ++;
        this.numAluno = ultimo;
        this.disciplinasInscrito = new ArrayList<Disciplina>();
        this.notasDisciplinas = new ArrayList<NotasDisciplina>();
        this.mediaEntrada = mediaEntrada;
    }

    public Aluno(Aluno a){
        super(a.getNome(), a.getContactos(), a.getLocalDeOrigem(), a.getDataNascimento());
        this.numAluno = a.numAluno;
        this.disciplinasInscrito = (ArrayList<Disciplina>) a.disciplinasInscrito.clone();
        this.notasDisciplinas = (ArrayList<NotasDisciplina>) a.notasDisciplinas.clone();
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

    public void setDataNascimento(LocalDate dataNascimento){
        super.setDataNascimento(dataNascimento);
    }
    public LocalDate getDataNascimento(){
       return super.getDataNascimento();
    }

    public void setMediaEntrada(double mediaEntrada){
        this.mediaEntrada = mediaEntrada;
    }
    public double getMediaEntrada(){
       return this.mediaEntrada;
    }

    public void setMediaDisciplinas(ArrayList<NotasDisciplina> notasDisciplinas){
        this.notasDisciplinas = (ArrayList<NotasDisciplina>) notasDisciplinas.clone();
    }
    public ArrayList<NotasDisciplina> getMediaDisciplinas(){
       return this.notasDisciplinas;
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
        s = s + " / Média de entrada: " + this.mediaEntrada + " / Nº.Aluno: "+numAluno+"\n" + "Média das Disciplinas: " + notasDisciplinas + "\n" + "Disciplinas do Aluno: " + disciplinasInscrito;
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            Aluno e = (Aluno) obj;
            ig = super.equals(e);
            ig = ig && (this.notasDisciplinas.equals(e.notasDisciplinas)) && (this.mediaEntrada == e.mediaEntrada) && (this.numAluno == e.numAluno) && (this.disciplinasInscrito.equals(e.disciplinasInscrito));
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
        
    }
}