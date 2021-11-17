import java.util.ArrayList;

public class Disciplina {
    private int numdisc;
    private String nomedisc;
    private ArrayList<Aluno> listalunos;
    private ArrayList<Professor> listprof;
    private ArrayList<Frequencia> listfreq;

    public Disciplina() {
        this.numdisc = 0;
        this.nomedisc = "";
        this.listalunos = new ArrayList<Aluno>();
        this.listprof = new ArrayList<Professor>();
        this.listfreq = new ArrayList<Frequencia>();

    }

    public Disciplina(int numdisc, String nomedisc) {
        this.numdisc = numdisc;
        this.nomedisc = nomedisc;
        this.listalunos = new ArrayList<Aluno>();
        this.listprof = new ArrayList<Professor>();
        this.listfreq = new ArrayList<Frequencia>();

    }

    public int getNumDisc() {
        return this.numdisc;
    }

    public void setNumDisc(int numdisc) {
        this.numdisc = numdisc;
    }

    public String getNomDisc() {
        return this.nomedisc;
    }

    public void setNomDisc(String nomedisc) {
        this.nomedisc = nomedisc;
    }

    public ArrayList<Aluno> getListAlunos() {
        return this.listalunos;
    }

    public void setListAlunos(ArrayList<Aluno> listalunos) {
        this.listalunos = (ArrayList<Aluno>) listalunos.clone();
    }

    public ArrayList<Professor> getListProf() {
        return this.listprof;
    }

    public void setListProf(ArrayList<Professor> listprof) {
        this.listprof = (ArrayList<Professor>) listprof.clone();
    }

    public ArrayList<Frequencia> getListFreq() {
        return this.listfreq;
    }

    public void setListFreq(ArrayList<Frequencia> listfreq) {
        this.listfreq = (ArrayList<Frequencia>) listfreq.clone();

    }

    public String toString() {

        String s;
        s = "\nDisciplina: " + nomedisc + "/ Num.Disciplina: " + numdisc;
        s = s + "Lista de Alunos: (";
        for (int i = 0; i < listalunos.size(); i++) {
            if (i != listalunos.size() - 1)
                s = s + listalunos.get(i) + ", ";
            else
                s = s + listalunos.get(i) + ")\n";
        }
        s = s + "Lista de Professores: (";
        for (int i = 0; i < listprof.size(); i++) {
            if (i != listprof.size() - 1)
                s = s + listprof.get(i) + ", ";
            else
                s = s + listprof.get(i) + ")\n";
        }
        s = s + "Lista de Frequências:\n";
        for (int i = 0; i < listfreq.size(); i++)
            s = s + listfreq.get(i) + "\n\n";
        return s;
    }


    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            Disciplina disc1 = (Disciplina) obj;
            ig = this.nomedisc.equals(disc1.nomedisc) && (this.numdisc == disc1.numdisc);
            ig = ig && (this.listalunos.equals(disc1.listalunos)) && (this.listfreq.equals(disc1.listfreq)) && (this.listprof.equals(disc1.listprof));
        }
        else{
            ig = false;
        }
        return ig;
    }

    public Object clone(){
        Disciplina  copia = new Disciplina();
        copia.nomedisc = this.nomedisc;
        copia.numdisc = this.numdisc;
        copia.listalunos = (ArrayList<Aluno>) this.listalunos.clone();
        copia.listfreq = (ArrayList<Frequencia>) this.listfreq.clone();
        copia.listprof = (ArrayList<Professor>) this.listprof.clone();
        return copia;
    }

    public static void main(String[] args) {
        // Há espera das outras classes para conseguir elaborar a classe teste da Disciplina.
    }


}
