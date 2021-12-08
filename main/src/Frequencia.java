

import java.util.ArrayList;

import java.time.LocalDate;

public class Frequencia implements java.io.Serializable {
    // Atributos
    private int id;
    private Disciplina disc;
    private LocalDate datafreq;
    private Professor professorResp;
    private int numpergtotal;
    private ArrayList<Perguntas> listperg;
    private String dificuldade;

    // Contrutores
    public Frequencia() {
        this.id = 0;
        this.disc = new Disciplina();
        this.datafreq = LocalDate.now();
        this.professorResp = new Professor();
        this.numpergtotal = 0;
        this.listperg = new ArrayList<Perguntas>();
        this.dificuldade = "";
    }

    public Frequencia(int id, String disc, int numpergtotal, String dificuldade, LocalDate datafreq, Professor professorResp){
        this.id = id;
        this.disc = new Disciplina();
        this.datafreq = datafreq;
        this.professorResp = professorResp;
        this.numpergtotal = numpergtotal;
        this.listperg = new ArrayList<Perguntas>();
        this.dificuldade = dificuldade;
    }

    // Getters e Setters
    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public Disciplina getDisc() {
        return this.disc;
    }

    public void setDisc(Disciplina disc) {
        this.disc = disc;
    }

    public LocalDate getdatefreq() {
        return this.datafreq;
    }

    public void setdatafreq(LocalDate datafreq) {
        this.datafreq = datafreq;
    }

    public Professor getProfessorResponsavel() {
        return this.professorResp;
    }

    public void setProfessorResponsavel(Professor professorResp) {
        this.professorResp = professorResp;
    }

    public int getNumPergTotal() {
        return this.numpergtotal;
    }

    public void setNumPergTotal(int numpergtotal) {
        this.numpergtotal = numpergtotal;
    }

    public ArrayList<Perguntas> getlistperg() {
        return this.listperg;
    }

    public void setlistperg(ArrayList<Perguntas> listperg) {
        this.listperg = (ArrayList<Perguntas>) listperg.clone();
    }

    public String getdificuldade() {
        return this.dificuldade;
    }

    public void setdificuldadec(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    // toString
    public String toString() {
        String s;
        s = "\nID Frequência: " + id;
        s = s + "; Disciplina: " + disc;
        s = s + "; Data da frequencia = " + datafreq;
        s = s + "; Professores que a realizou: "+professorResp;
        s = s + "; Dificuldade: "+dificuldade;
        s = s + "; Número de perguntas: " + numpergtotal;
        s = s + "Lista de perguntas:\n";
        for (int i = 0; i < listperg.size(); i++)
            s = s + listperg.get(i) + "\n\n";
        return s;
    }

    // Equals
    public boolean equals(Object obj) {
        boolean ig = false;
        if (obj != null && this.getClass() == obj.getClass()) {
            Frequencia e = (Frequencia) obj;
            ig = ((this.id == e.id) && (this.disc.equals(e.disc))
                    && (this.datafreq.equals(e.datafreq)) && (this.professorResp.equals(e.professorResp))
                    && (this.numpergtotal == e.numpergtotal) && (this.listperg.equals(e.listperg))
                    && (this.dificuldade.equals(e.dificuldade)));
        } else {
            ig = false;
        }
        return ig;
    }

    // Clone
    public Object clone() {
        Frequencia copia = new Frequencia();
        copia.id = this.id;
        copia.disc = this.disc;
        copia.datafreq = this.datafreq;
        copia.professorResp = this.professorResp;
        copia.numpergtotal = this.numpergtotal;
        copia.listperg = (ArrayList<Perguntas>) this.listperg.clone();
        copia.dificuldade = this.dificuldade;
        return copia;
    }

    public static void main(String[] args) {
        // Testes
    }
}
