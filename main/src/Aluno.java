



import java.util.ArrayList;
import java.time.LocalDate;

public class Aluno extends Pessoa {
    // Atributos
    private static int ultimo = 0;
    private int numAluno;
    private ArrayList<NotasDisciplina> notasDisciplinas;
    private Curso cursoInscrito;
    private double mediaEntrada;

    // Construtores
    public Aluno() {
        super();
        ultimo++;
        this.numAluno = ultimo;
        this.notasDisciplinas = new ArrayList<NotasDisciplina>();
        this.cursoInscrito = new Curso();
        this.mediaEntrada = 0;
    }

    public Aluno(Pessoa p, double mediaEntrada, double mediaAtual) {
        super(p.getNome(), p.getContactos(), p.getLocalDeOrigem(), p.getDataNascimento());
        ultimo++;
        this.numAluno = ultimo;
        this.notasDisciplinas = new ArrayList<NotasDisciplina>();
        this.cursoInscrito = new Curso();
        this.mediaEntrada = mediaEntrada;
    }

    public Aluno(Aluno a) {
        super(a.getNome(), a.getContactos(), a.getLocalDeOrigem(), a.getDataNascimento());
        this.numAluno = a.numAluno;
        this.notasDisciplinas = (ArrayList<NotasDisciplina>) a.notasDisciplinas.clone();
        this.cursoInscrito = a.cursoInscrito;
        this.mediaEntrada = a.mediaEntrada;
    }

    // Getters e Setters
    public void setNome(String nome) {
        super.setNome(nome);
    }

    public String getNome() {
        return super.getNome();
    }

    public int getNumAluno() {
        return this.numAluno;
    }

    public static int getUltimo(){
        return ultimo;
    }

    public static void setUltimo(int ult){
        Aluno.ultimo = ult;
    }

    public void setContactos(Contactos contactos){
        super.setContactos(contactos);
    }

    public Contactos getContactos() {
        return super.getContactos();
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        super.setLocalDeOrigem(localDeOrigem);
        ;
    }

    public String getLocalDeOrigem() {
        return super.getLocalDeOrigem();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        super.setDataNascimento(dataNascimento);
    }

    public LocalDate getDataNascimento() {
        return super.getDataNascimento();
    }

    public void setCurso(Curso curso) {
        this.cursoInscrito = curso;
    }

    public Curso getCurso() {
        return this.cursoInscrito;
    }

    public void setMediaEntrada(double mediaEntrada) {
        this.mediaEntrada = mediaEntrada;
    }

    public double getMediaEntrada() {
        return this.mediaEntrada;
    }

    public void setMediaDisciplinas(ArrayList<NotasDisciplina> notasDisciplinas) {
        this.notasDisciplinas = (ArrayList<NotasDisciplina>) notasDisciplinas.clone();
    }

    public ArrayList<NotasDisciplina> getMediaDisciplinas() {
        return this.notasDisciplinas;
    }

    // toString
    public String toString() {
        String s;
        s = super.toString();
        s = s + " / Média de entrada: " + this.mediaEntrada + " / Nº.Aluno: " + numAluno + "\n"
                + "Média das Disciplinas: " + notasDisciplinas + "\nDisciplinas do Aluno: "
                + cursoInscrito.getDisciplinasCurso() + "\nCurso: " + cursoInscrito;
        return s;
    }

    // Equals
    public boolean equals(Object obj) {
        boolean ig = false;
        if (obj != null && this.getClass() == obj.getClass()) {
            Aluno e = (Aluno) obj;
            ig = super.equals(e);
            ig = ig && (this.notasDisciplinas.equals(e.notasDisciplinas)) && (this.mediaEntrada == e.mediaEntrada)
                    && (this.numAluno == e.numAluno) && this.cursoInscrito.equals(cursoInscrito);
        } else
            ig = false;
        return ig;
    }

    // Clone
    public Object clone() {
        Aluno copia = new Aluno(this);
        return copia;
    }

    public void listaDiscDoAluno(){
        if(this.getCurso().getDisciplinasCurso().isEmpty())
            System.out.println("De momento, o aluno não se encontra inscrito em nenhuma disciplina.\n");
        else{
            System.out.println("Disciplinas do aluno "+ this.getNome()+":\n");
            for(int i = 0; i < this.getCurso().getDisciplinasCurso().size(); i++)
                System.out.println(". Cód:" + this.getCurso().getDisciplinasCurso().get(i).getNumDisc() + " - " + this.getCurso().getDisciplinasCurso().get(i).getNomDisc());
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}