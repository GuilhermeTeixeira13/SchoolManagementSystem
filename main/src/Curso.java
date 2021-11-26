import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;

public class Curso implements Serializable{
    // Atributos
    private String nomeCurso, codCurso;
    private int duracaoEmHoras;
    private ArrayList<Disciplina> disciplinasCurso;
    private ArrayList<String> provasIngresso;
    private ArrayList<Aluno> alunosCurso;
    private float mediaUltimoColocado;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    // Construtores
    public Curso(){
        this.nomeCurso = "";
        this.codCurso = "";
        this.disciplinasCurso = new ArrayList<Disciplina>();
        this.provasIngresso = new ArrayList<String>();
        this.alunosCurso = new ArrayList<Aluno>();
        this.duracaoEmHoras = 0;
        this.mediaUltimoColocado = 0;
        this.dataInicio = LocalDate.now();
        this.dataFim = LocalDate.now();
    }
    public Curso(String nomeCurso, String codCurso, int duracaoEmHoras, float mediaUltimoColocado, ArrayList<String> provasIngresso, LocalDate dataInicio, LocalDate dataFim){
        this.nomeCurso = nomeCurso;
        this.codCurso = codCurso;
        this.disciplinasCurso = new ArrayList<Disciplina>();
        this.provasIngresso = provasIngresso;
        this.alunosCurso = new ArrayList<Aluno>();
        this.duracaoEmHoras = duracaoEmHoras;
        this.mediaUltimoColocado = mediaUltimoColocado;
        this.dataInicio = LocalDate.now();
        this.dataFim = LocalDate.now();
    }

    //Getters e Setters
    public void setNomeCurso(String nomeCurso){
        this.nomeCurso = nomeCurso;
    }
    public String getNomeCurso(){
        return this.nomeCurso;
    }

    public void setCodCurso(String codCurso){
        this.codCurso = codCurso;
    }
    public String getCodCurso(){
        return this.codCurso;
    }

    public void setDisciplinasCurso(ArrayList<Disciplina> disciplinasCurso){
        this.disciplinasCurso = (ArrayList<Disciplina>) disciplinasCurso.clone();
    }
    public ArrayList<Disciplina> getDisciplinasCurso(){
        return this.disciplinasCurso;
    }

    public void setProvasIngresso(ArrayList<String> provasIngresso){
        this.provasIngresso = provasIngresso;
    }
    public ArrayList<String> getProvasIngresso(){
        return this.provasIngresso;
    }

    public void setAlunosCurso(ArrayList<Aluno> alunosCurso){
        this.alunosCurso = (ArrayList<Aluno>) alunosCurso.clone();
    }
    public ArrayList<Aluno> getAlunosCurso(){
        return this.alunosCurso;
    }

    public void setDuracaoEmHoras(int duracaoEmHoras){
        this.duracaoEmHoras = duracaoEmHoras;
    }
    public int getDuracaoEmHoras(){
        return this.duracaoEmHoras;
    }

    public void setMediaUltimoColocado(float mediaUltimoColocado){
        this.mediaUltimoColocado = mediaUltimoColocado;
    }
    public float getMediaUltimoColocado(){
        return this.mediaUltimoColocado;
    }

    // Seria interessante não deixar que a data de fim fosse antes da de início nem que a de início fosse depois da de fim 
    public void setDataInicio(LocalDate dataInicio){
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataInicio(){
        return this.dataInicio;
    }

    public void setDataFim(LocalDate dataFim){
        this.dataFim = dataFim;
    }
    public LocalDate getDataFim(){
        return this.dataFim;
    }

    // To String
    public String toString(){
        String s;
        s = "\nCurso: "+nomeCurso+"\n Cod.Curso: "+codCurso+"\n Media do Ultimo Colocado: "+mediaUltimoColocado+"\n Data de Inicio: "+dataInicio+"\n Data de Fim: "+dataFim+"\n Duracao: "+duracaoEmHoras+"h";
        s = s + "\n Disciplinas: ";
        for(int i=0; i<disciplinasCurso.size(); i++){
            if(i == disciplinasCurso.size() - 1)
                s = s + disciplinasCurso.get(i) + ")";
            else if(i == 1)
                s = s + disciplinasCurso.get(i) + "(";
            else
                s = s + disciplinasCurso.get(i) + ", ";
        }
        s = s + "\n Provas Ingresso: ";
        for(int i=0; i<provasIngresso.size(); i++){
            if(i == provasIngresso.size() - 1)
                s = s + provasIngresso.get(i);
            else
                s = s + provasIngresso.get(i) + ",";  
        }   
        s = s + "\n Alunos Inscritos: ";
        for(int i=0; i<alunosCurso.size(); i++)
            if(i == provasIngresso.size() - 1)
                s = s + alunosCurso.get(i).getNome();
            else if(i == 0)
                s = s + "";
            else
                s = s + alunosCurso.get(i).getNome() + ",";     
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && obj.getClass() == this.getClass()){
            Curso e = (Curso) obj;
            ig = this.nomeCurso.equals(e.nomeCurso) && (this.codCurso.equals(e.codCurso)) && (this.disciplinasCurso.equals(e.disciplinasCurso)) && (this.provasIngresso.equals(e.provasIngresso));
            ig = ig && (this.alunosCurso.equals(e.alunosCurso)) && (this.duracaoEmHoras == e.duracaoEmHoras) && (this.mediaUltimoColocado == e.mediaUltimoColocado) && (this.dataInicio.equals(e.dataInicio)) && (this.dataFim.equals(e.dataFim));
        }
        else
            ig = false;
        return ig;
    }

    // Clone
    public Object clone(){
        Curso copia = new Curso();

        copia.nomeCurso = this.nomeCurso;
        copia.codCurso = this.codCurso;
        copia.disciplinasCurso = (ArrayList<Disciplina>) this.disciplinasCurso.clone();
        copia.provasIngresso = (ArrayList<String>) this.disciplinasCurso.clone();
        copia.alunosCurso = (ArrayList<Aluno>) this.alunosCurso.clone();
        copia.duracaoEmHoras = this.duracaoEmHoras;
        copia.mediaUltimoColocado = this.mediaUltimoColocado;
        copia.dataInicio = this.dataInicio;
        copia.dataFim = this.dataFim;

        return copia;
    }

    public static void main(String[] args) {
        // Testes
    }
}
