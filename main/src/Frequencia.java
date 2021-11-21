import java.util.ArrayList;
import java.util.Date;

public class Frequencia {
    private int id;
    private ArrayList<Disciplina> listdisc;
    private Date datafreq;
    private ArrayList<Professor> listprof;
    private int numpergtotal;
    private ArrayList<Perguntas> listperg;
    private String dificuldade;

    public Frequencia() {
        this.id = 0;
        this.listdisc = new ArrayList<Disciplina>();
        this.datafreq = new Date();
        this.listprof = new ArrayList<Professor>();
        this.numpergtotal = 0;
        this.listperg = new ArrayList<Perguntas>();
        this.dificuldade = "";
    }

    public Frequencia(int id, int numpergtotal, String dificuldade) {
        this.id = id;
        this.listdisc = new ArrayList<Disciplina>();
        this.datafreq = new Date();
        this.listprof = new ArrayList<Professor>();
        this.numpergtotal = numpergtotal;
        this.listperg = new ArrayList<Perguntas>();
        this.dificuldade = dificuldade;
    }

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public ArrayList<Disciplina> getListdisc() {
        return this.listdisc;
    }

    public void setlistdisc(ArrayList<Disciplina> listdisc) {
        this.listdisc = (ArrayList<Disciplina>) listdisc.clone();
    }

    public Date getdatefreq() {
        return this.datafreq;
    }

    public void setdatafreq(Date datafreq) {
        this.datafreq = datafreq;
    }

    public ArrayList<Professor> getprofessor() {
        return this.listprof;
    }

    public void setListProf(ArrayList<Professor> listprof) {
        this.listprof = (ArrayList<Professor>) listprof.clone();
    }

    public int getmumpergtotal() {
        return this.numpergtotal;
    }

    public void setnumpergtotal(int numpergtotal) {
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

    public String toString() {
        String s;
        s = "\nID Disciplina: " + id;
        s = s + ";Disciplina: ";
        for (int i = 0; i < listdisc.size(); i++) {
            if (i != listdisc.size() - 1)
                s = s + listdisc.get(i) + ", ";
            else
                s = s + listdisc.get(i) + "\n";
        }
        s = s + ";Data da frequencia(" + datafreq + ")";
        s = s + "Professores regentes: (";
        for (int i = 0; i < listprof.size(); i++) {
            if (i != listprof.size() - 1)
                s = s + listprof.get(i) + ", ";
            else
                s = s + listprof.get(i) + ")\n";
        }
        s = s + "Numero de perguntas: " + numpergtotal;
        s = s + "Lista de perguntas:\n";
        for (int i = 0; i < listperg.size(); i++)
            s = s + listperg.get(i) + "\n\n";
        return s;
    }

    public boolean equals(Object obj) {
        boolean ig = false;
        if (obj != null && this.getClass() == obj.getClass()) {
            Frequencia freq1 = (Frequencia) obj;
            ig = ((this.id == freq1.id) && (this.listdisc.equals(freq1.listdisc))
                    && (this.datafreq.equals(freq1.datafreq)) && (this.listprof.equals(freq1.listprof))
                    && (this.numpergtotal == freq1.numpergtotal) && (this.listperg.equals(freq1.listperg))
                    && (this.dificuldade.equals(freq1.dificuldade)));
        } else {
            ig = false;
        }
        return ig;
    }

    public Object clone() {
        Frequencia copia = new Frequencia();
        copia.id = this.id;
        copia.listdisc = (ArrayList<Disciplina>) this.listdisc.clone();
        copia.datafreq = this.datafreq;
        copia.listprof = (ArrayList<Professor>) this.listprof.clone();
        copia.numpergtotal = this.numpergtotal;
        copia.listperg = (ArrayList<Perguntas>) this.listperg.clone();
        copia.dificuldade = this.dificuldade;
        return copia;
    }

}
