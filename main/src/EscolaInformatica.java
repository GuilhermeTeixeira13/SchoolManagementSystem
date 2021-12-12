

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
        s = s + "\nCursos da "+ this.getNomeEscola()+":\n";
        if(this.getCursosEscola().isEmpty())
            s = s + "De momento, não estão registados quaisquer cursos.\n";
        else{
        for(int i = 0; i < this.getCursosEscola().size(); i++)
            s = s + ". Cód:" + this.getCursosEscola().get(i).getCodCurso() + " - " + this.getCursosEscola().get(i).getNomeCurso()+"\n";
        }
        s = s + "\nDisciplinas da "+ this.getNomeEscola()+":\n";
        if(this.getDisciplinaEscola().isEmpty())
            s = s + "De momento, não estão registadas quaisquer disciplinas.\n";
        else{
            for(int i = 0; i < this.getDisciplinaEscola().size(); i++)
                s = s + ". Cód:" + this.getDisciplinaEscola().get(i).getNumDisc() + " - " + this.getDisciplinaEscola().get(i).getNomDisc()+ "\n";
        }
        s = s + "\nPessoas da "+ this.getNomeEscola()+":\n";
        if(this.getPessoasEscola().isEmpty())
            s = s + "De momento, não estão registadas quaisquer pessoas.\n";
        else{
            for(int i = 0; i < this.getPessoasEscola().size(); i++)
               s = s + ". " + this.getPessoasEscola().get(i).getNome()+"\n";
        }
        s = s + "\n";
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
        if(this.getCursosEscola().isEmpty())
            System.out.println("De momento, não estão registados quaisquer cursos.\n");
        else{
            System.out.println("Cursos da "+ this.getNomeEscola()+":\n");
        for(int i = 0; i < this.getCursosEscola().size(); i++)
            System.out.println(". Cód:" + this.getCursosEscola().get(i).getCodCurso() + " - " + this.getCursosEscola().get(i).getNomeCurso());
         System.out.println();
        }
    }

    public void listaDisciplinas(){
        if(this.getDisciplinaEscola().isEmpty())
            System.out.println("De momento, não estão registadas quaisquer disciplinas.\n");
        else{
            System.out.println("Disciplinas da "+ this.getNomeEscola()+":\n");
            for(int i = 0; i < this.getDisciplinaEscola().size(); i++)
                System.out.println(". Cód:" + this.getDisciplinaEscola().get(i).getNumDisc() + " - " + this.getDisciplinaEscola().get(i).getNomDisc());
            System.out.println();
        }
    }


    public void addCurso(Curso c){
        this.CursosEscola.add(c);
    }
    public void adddisciplina(Disciplina d){
        this.DisciplinasEscola.add(d);
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

    public void changeProf(int posicao, Professor p){
        this.getPessoasEscola().set(posicao, p);
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
            if(Alunos.get(i).getNome().equals(nomeAluno))
                pos = i;
        }

        return pos;
    }
    public int devolveposDisc(String nomeDiscP){
        int pos = -1;

        for(int i = 0; i < this.getDisciplinaEscola().size(); i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc().equals(nomeDiscP)){
                pos = i;
            }
        }
        return pos;
    }

    public int devolvePosDisciplinaDaFreq(int idFreq){
        int pos = -1;

        for(int i = 0; i < this.getDisciplinaEscola().size(); i++){
            for(int j = 0; j < this.getDisciplinaEscola().get(i).getListFreq().size(); j++){
                if(this.getDisciplinaEscola().get(i).getListFreq().get(j).getid() == idFreq)
                    pos = i;
            }
        }

        return pos;
    }

    public int devolvePosFrequenciaDaListaFreq(int idFreq){
        int pos = -1;

        for(int i = 0; i < this.getDisciplinaEscola().size(); i++){
            for(int j = 0; j < this.getDisciplinaEscola().get(i).getListFreq().size(); j++){
                if(this.getDisciplinaEscola().get(i).getListFreq().get(j).getid() == idFreq)
                    pos = j;
            }
        }

        return pos;
    }

    public Disciplina devolveDisciplina(String nomeDisciplina){ 
        Disciplina disciplina = new Disciplina();

        for(int i=0; i<this.getDisciplinaEscola().size(); i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc() == nomeDisciplina)
                disciplina = this.getDisciplinaEscola().get(i);
        }

        return disciplina;
    }
    
    public int devolvePosProf(String nomeProf, ArrayList<Pessoa> Professores){
        int pos=-1;

        for(int i = 0; i < Professores.size(); i++){
            if(Professores.get(i).getNome().equals(nomeProf))
                pos = i;
        }

        return pos;
    }
    public int devolvePosDisc(String nomedisc){
        int pos=-1;
        for(int i = 0; i < this.getDisciplinaEscola().size(); i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc().equals(nomedisc)){
                pos = i;
            }
        }
        return pos;
    }

    public void insereProfNasSuasDisciplinas(Professor prof){
        for(int i = 0; i<prof.getDiscLec().size(); i++){
            prof.getDiscLec().get(i).getListProf().add(prof);
        }
    }

    public void removeProfNasSuasDisciplinas(Professor prof){
        for(int i = 0; i<prof.getDiscLec().size(); i++){
            prof.getDiscLec().get(i).getListProf().remove(prof);
        }
    }

    public void insereAlunoNasSuasDisciplinas(Aluno a){
        for(int i = 0; i<a.getCurso().getDisciplinasCurso().size(); i++){
            a.getCurso().getDisciplinasCurso().get(i).getListAlunos().add(a);
        }
    }

    public void removeAlunoNasSuasDisciplinas(Aluno a){
        for(int i = 0; i<a.getCurso().getDisciplinasCurso().size(); i++){
            a.getCurso().getDisciplinasCurso().get(i).getListAlunos().remove(a);
        }
    }

    public boolean removeDiscEquals(String nomeDiscRemover){
        boolean conseguiuRemover = false;
        for(int i=0;i<this.getDisciplinaEscola().size();i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc().equals(nomeDiscRemover)){
                this.getDisciplinaEscola().remove(this.getDisciplinaEscola().get(i));
                conseguiuRemover=true;
            }
        }
        return conseguiuRemover;
    }
    public boolean removediscContains(String nomeDiscRemover){
        boolean conseguiuRemover = false;
        for(int i = 0; i < this.getDisciplinaEscola().size(); i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc().contains(nomeDiscRemover)){
                this.getDisciplinaEscola().remove(this.getDisciplinaEscola().get(i));
                conseguiuRemover = true;
            }
        }
        return conseguiuRemover;
    }
    public boolean profDiscEquals(String nomeDiscprof){
        boolean nomevalido = false;
        for(int i=0;i<this.getDisciplinaEscola().size();i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc().equals(nomeDiscprof)){
                nomevalido=true;
            }
        }
        return nomevalido;
    }
    public boolean alunosDiscEquals(String nomeDiscalunos){
        boolean nomevalido = false;
        for(int i=0;i<this.getDisciplinaEscola().size();i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc().equals(nomeDiscalunos)){
                nomevalido=true;
            }
        }
        return nomevalido;
    }
    
    public boolean discprofContains(String nomeDiscprof){
        boolean nomevalido = false;
        for(int i = 0; i < this.getDisciplinaEscola().size(); i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc().contains(nomeDiscprof)){
                nomevalido = true;
            }
        }
        return nomevalido;
    }
    public boolean discalunosContains(String nomeDiscalunos){
        boolean nomevalido = false;
        for(int i = 0; i < this.getDisciplinaEscola().size(); i++){
            if(this.getDisciplinaEscola().get(i).getNomDisc().contains(nomeDiscalunos)){
                nomevalido = true;
            }
        }
        return nomevalido;
    }



    public static void main(String[] args) {
        // Testes
    }
}
