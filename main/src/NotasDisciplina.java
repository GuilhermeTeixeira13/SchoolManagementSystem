//package src;

import java.util.ArrayList;

public class NotasDisciplina implements java.io.Serializable {
    // Atributos
    private ArrayList<Resultado> notas;
    private String disciplina;

    // Contrutores
    public NotasDisciplina(){
        this.disciplina = "";
        this.notas = new ArrayList<Resultado>();
    }

    public NotasDisciplina(String disciplina){
        this.disciplina = disciplina;
        this.notas = new ArrayList<Resultado>();
    }

    // Getters e Setters
    public String getDisciplina(){
        return disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    public ArrayList<Resultado> getNotas(){
        return notas;
    }

    public void setNotas(ArrayList<Resultado> notas){
        this.notas = (ArrayList<Resultado>) notas.clone();
    }

    // toString
    public String toString() {
        String s;
        s = "\nDisciplina: " + disciplina;
        s = s + "Notas:\n";
        for (int i = 0; i < notas.size(); i++)
            s = s + notas.get(i) + "\n\n";
        return s;
    }

    // Equals
    public boolean equals(Object obj) {
        boolean ig = false;
        if (obj != null && this.getClass() == obj.getClass()) {
            NotasDisciplina e = (NotasDisciplina) obj;
            ig = (this.disciplina.equals(e.disciplina)) && (this.notas.equals(e.notas));
        }
        else {
            ig = false;
        }
        return ig;
    } 
    
    // Clone
    public Object clone() {
        NotasDisciplina copia = new NotasDisciplina();
        copia.disciplina = this.disciplina;
        copia.notas = (ArrayList<Resultado>) this.notas.clone();
        return copia;
    }

    public static void main(String[] args) {
        // Testes
    }

}
