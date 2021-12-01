import java.io.Serializable;
import java.util.ArrayList;

public class EscolaInformatica implements Serializable{
    private String NomeEscola;
    private int CodEscola;
    private ArrayList<Curso> CursosEscola;
    private ArrayList<Pessoa> PessoasEscola;
    private ArrayList<Disciplina> DisciplinasEscola;
    private Diretor DiretorEscola;
    private Contactos ContactoEscola;
    private String localizacao;

    public EscolaInformatica(){
        this.NomeEscola = "";
        this.CodEscola = 0;
        this.CursosEscola = new ArrayList<Curso>();
        this.PessoasEscola = new ArrayList<Pessoa>();
        this.DisciplinasEscola = new ArrayList<Disciplina>();
        this.DiretorEscola = new Diretor();
        this.ContactoEscola = new Contactos();
        this.localizacao = "";
    }

    public EscolaInformatica(String NomeEscola,int CodEscola, ArrayList<Curso> CursosEscola, ArrayList<Pessoa> PessoasEscola, ArrayList<Disciplina> DisciplinasEscola, Diretor DiretorEscola, Contactos ContactosEscola, String localizacao){
        this.NomeEscola = NomeEscola;
        this.CodEscola = CodEscola;
        this.CursosEscola = (ArrayList<Curso>) CursosEscola;
        this.PessoasEscola = (ArrayList<Pessoa>) PessoasEscola;
        this.DisciplinasEscola = (ArrayList<Disciplina>) DisciplinasEscola;
        this.DiretorEscola = DiretorEscola;
        this.ContactoEscola = ContactosEscola;
        this.localizacao = localizacao;
    }

    //Getters e Setters
    public void setNomeEscola(String NomeEscola){
        this.NomeEscola = NomeEscola;
    }
    public String getNomeEscola(){
        return this.NomeEscola;
    }

    public void setCodEscola(int CodEscola){
        this.CodEscola = CodEscola;
    }
    public int getCodEscola(){
        return this.CodEscola;
    }

    public void setCursosEscola(ArrayList<Curso> CursosEscola){
        this.CursosEscola = (ArrayList<Curso>) CursosEscola.clone();
    }
    public ArrayList<Curso> getCursosEscola(){
        return this.CursosEscola;
    }

    public void setPessoasEscola(ArrayList<Pessoa> PessoasEscola){
        this.PessoasEscola = (ArrayList<Pessoa>) PessoasEscola.clone();
    }
    public ArrayList<Pessoa> getPessoasEscola(){
        return this.PessoasEscola;
    }

    public void setDisciplinasEscola(ArrayList<Disciplina> DisciplinasEscola){
        this.DisciplinasEscola = (ArrayList<Disciplina>) CursosEscola.clone();
    }
    public ArrayList<Disciplina> getDisciplinaEscola(){
        return this.DisciplinasEscola;
    }

    public void setDiretorEscola(Diretor DiretorEscola){
        this.DiretorEscola = DiretorEscola;
    }
    public Diretor getDiretorEscola(){
        return this.DiretorEscola;
    }

    public void setContactoEscola(Contactos ContactoEscola){
        this.ContactoEscola = ContactoEscola;
    }
    public Contactos getContactoEscola(){
        return this.ContactoEscola;
    }

    public void setLocalizacao(String localizacao){
        this.localizacao = localizacao;
    }
    public String getLocalizacao(){
        return this.localizacao;
    }

    // To String
    public String toString(){
        String s;
        s = "Escola: "+NomeEscola+"// Cód.Escolaº: "+CodEscola+"// Diretor: "+DiretorEscola+"// Contactos: "+ContactoEscola+"// Localização: "+this.localizacao+"\n";
        s = s + "CURSOS:\n";
        for(int i=0; i<CursosEscola.size();i++)
            CursosEscola.get(i).toString();
        s = s + "\nDISCIPLINAS:\n";
        for(int i=0; i<DisciplinasEscola.size();i++)
            DisciplinasEscola.get(i).toString();
        s = s + "\nPessoas:\n";
        for(int i=0; i<PessoasEscola.size();i++)
            PessoasEscola.get(i).toString();
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            EscolaInformatica e = (EscolaInformatica) obj;
            ig = this.NomeEscola.equals(e.NomeEscola) && (this.localizacao.equals(e.localizacao)) && (this.CodEscola == e.CodEscola) && (this.DiretorEscola.equals(e.DiretorEscola)) && (this.ContactoEscola.equals(e.ContactoEscola)) && (this.CursosEscola.equals(e.CursosEscola) && (this.DisciplinasEscola.equals(e.DisciplinasEscola) && (this.PessoasEscola.equals(e.PessoasEscola))));
        }        
        else
            ig = false;
        return ig;
    }

    //Clone
    public Object clone(){
        EscolaInformatica copia = new EscolaInformatica();
        copia.CodEscola = this.CodEscola;
        copia.NomeEscola = this.NomeEscola;
        copia.ContactoEscola = this.ContactoEscola;
        copia.DiretorEscola = this.DiretorEscola;
        copia.CursosEscola = (ArrayList<Curso>) this.CursosEscola.clone();
        copia.PessoasEscola = (ArrayList<Pessoa>) this.PessoasEscola.clone();
        copia.DisciplinasEscola = (ArrayList<Disciplina>) this.DisciplinasEscola.clone();
        copia.localizacao = this.localizacao;
        return copia;
    }

    public void listaCursos(){
        System.out.println("Cursos da "+ this.getNomeEscola()+":\n");
        for(int i = 0; i < this.getCursosEscola().size(); i++)
            System.out.println(". Cód:" + this.getCursosEscola().get(i).getCodCurso() + " - " + this.getCursosEscola().get(i).getNomeCurso());
            System.out.println();
    }

    public void addCurso(Curso c){
        this.CursosEscola.add(c);
    }

    public void changeAluno(int posicao, Aluno a){
        this.getPessoasEscola().set(posicao, a);
    }

    public boolean removeCursoContains(String nomeCursoRemover){
        boolean conseguiuRemover = false;
        for(int i = 0; i < this.getCursosEscola().size(); i++){
            if(this.getCursosEscola().get(i).getNomeCurso().contains(nomeCursoRemover)){
                this.getCursosEscola().remove(this.getCursosEscola().get(i));
                conseguiuRemover = true;
            }
        }
        return conseguiuRemover;
    }

    public boolean removeCursoEquals(String nomeCursoRemover){
        boolean conseguiuRemover = false;
        for(int i = 0; i < this.getCursosEscola().size(); i++){
            if(this.getCursosEscola().get(i).getNomeCurso().equals(nomeCursoRemover)){
                this.getCursosEscola().remove(this.getCursosEscola().get(i));
                conseguiuRemover = true;
            }
        }
        return conseguiuRemover;
    }

    public int devolvePosCurso(String nomeCurso){
        int pos=-1;
        for(int i = 0; i < this.getCursosEscola().size(); i++){
            if(this.getCursosEscola().get(i).getNomeCurso().equals(nomeCurso))
                pos = i;
        }
        return pos;
    }

    public int devolvePosAluno(String nomeAluno, ArrayList<Pessoa> Alunos){
        int pos=-1;

        for(int i = 0; i < Alunos.size(); i++){
            if(this.getPessoasEscola().get(i).getNome().equals(nomeAluno))
                pos = i;
        }

        return pos;
    }

    public int devolveposDisc(String nomeDiscP, ArrayList<Disciplina> disciplinas){
        int pos = -1;

        for(int i = 0; i < disciplinas.size(); i++){
            if(disciplinas.get(i).getNomDisc().equals(nomeDiscP)){
                pos = i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        // Testes
    }
}
