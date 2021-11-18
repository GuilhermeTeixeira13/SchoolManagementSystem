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
    
    public Frequencia(){
        this.id = 0;
        this.listdisc= new ArrayList<Disciplina>();
        this.datafreq= new Date();
        this.listprof= new ArrayList<Professor>();
        this.numpergtotal=0;
        this.listperg=new ArrayList<Perguntas>();
        this.dificuldade="";
    }

    
}
