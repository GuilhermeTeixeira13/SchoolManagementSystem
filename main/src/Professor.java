package src;

import java.util.ArrayList;
import java.time.LocalDate;

public class Professor extends Pessoa {
    private int numProf;
    private int rating;
    private ArrayList<Disciplina> discLec;

    // Construtor sem parâmetros
    public Professor() {
        super();
        this.numProf = 0;
        this.rating = 0;
        this.discLec = new ArrayList<Disciplina>();
    }

    // Construtor com parâmetros
    public Professor(int numProf, int rating, Pessoa p) {
        super(p.getNome(), p.getContactos(), p.getLocalDeOrigem(), p.getDataNascimento());
        this.numProf = numProf;
        this.rating = rating;
        this.discLec = new ArrayList<Disciplina>();
    }

    // Construtor cópia
    public Professor(Professor prof) {
        super(prof.getNome(), prof.getContactos(), prof.getLocalDeOrigem(), prof.getDataNascimento());
        this.numProf = prof.numProf;
        this.rating = prof.rating;
        this.discLec = (ArrayList<Disciplina>) prof.discLec.clone();
    }

    // Getters e Setters
    public String getNome() {
        return super.getNome();
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }

    public Contactos getContactos() {
        return super.getContactos();
    }

    public void setContactos(Contactos contactos) {
        super.setContactos(contactos);
    }

    public String getLocalDeOrigem() {
        return super.getLocalDeOrigem();
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        super.setLocalDeOrigem(localDeOrigem);
    }

    public LocalDate getDataNascimento() {
        return super.getDataNascimento();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        super.setDataNascimento(dataNascimento);
    }

    public int getNumProf() {
        return this.numProf;
    }

    public void setNumProf(int numProf) {
        this.numProf = numProf;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<Disciplina> getDiscLec() {
        return this.discLec;
    }

    public void setDiscLec(ArrayList<Disciplina> discLec) {
        this.discLec = (ArrayList<Disciplina>) discLec.clone();
    }

    // To String
    public String ToString() {
        String s;
        s = super.toString();
        s = s + " / Número do Professor: " + this.numProf + " / Posição no rating: " + this.rating + "\n";
        s = s + "Lista de Disciplinas Lecionadas pelo Docente: (";
        for (int i = 0; i < discLec.size(); i++) {
            if (i != discLec.size() - 1)
                s = s + discLec.get(i).getNomDisc() + ", ";
            else
                s = s + discLec.get(i).getNomDisc() + ")\n";
        }
        return s;

    }

    // Método Equals
    public boolean equals(Object obj) {
        boolean ig = false;
        if (obj != null && this.getClass() == obj.getClass()) {
            Professor prof1 = (Professor) obj;
            ig = super.equals(prof1) && (this.numProf == prof1.numProf) && (this.rating == prof1.rating)
                    && (this.discLec.equals(discLec));
        } else {
            return false;
        }
        return ig;
    }

    // Método Clone
    public Object clone() {
        Professor copia = new Professor(this);
        return copia;
    }

    public int devolveposDisciplina(String nomedisc, ArrayList<Disciplina> disciplinas){
        int pos = -1;
        for(int i = 0; i < disciplinas.size(); i++){
            if(this.getDiscLec().get(i).equals(nomedisc)){
                pos = i;
            }
        }
        return pos;

    }

    public void listaDisc(){
        if(this.getDiscLec().isEmpty()){
            System.out.println("Este professor ainda não leciona nenhuma disciplina.");
        }
        else{
            for(int i=0; i<this.getDiscLec().size(); i++){
                System.out.println(i+". "+this.getDiscLec().get(i).getNomDisc());
            }
        }
    }

    public int contDiscProf(){
        int totalDisc;
        totalDisc = this.getDiscLec().size();
        return totalDisc;
    }

    public static void main(String[] args) {
        // Testes
    }
}
