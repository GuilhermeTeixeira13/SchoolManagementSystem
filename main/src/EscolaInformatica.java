import java.util.ArrayList;

public class EscolaInformatica {
    private String NomeEscola;
    private int CodEscola;
    private ArrayList<Curso> CursosEscola;
    private Diretor DiretorEscola;
    private Contactos ContactoEscola;

    public EscolaInformatica(){
        this.NomeEscola = "";
        this.CodEscola = 0;
        this.CursosEscola = new ArrayList<Curso>();
        this.DiretorEscola = new Diretor();
        this.ContactoEscola = new Contactos();
    }

    public EscolaInformatica(String NomeEscola,int CodEscola, ArrayList<Curso> CursosEscola, Diretor DiretorEscola, Contactos ContactosEscola){
        this.NomeEscola = NomeEscola;
        this.CodEscola = CodEscola;
        this.CursosEscola = (ArrayList<Curso>) CursosEscola;
        this.DiretorEscola = DiretorEscola;
        this.ContactoEscola = ContactosEscola;
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

    // To String
    public String toString(){
        String s;
        s = "Escola: "+NomeEscola+"/ Cód.Escolaº: "+CodEscola+"/ Diretor: "+DiretorEscola+"/ Contactos: "+ContactoEscola+"\n";
        s = s + "CURSOS:\n";
        for(int i=0; i<CursosEscola.size();i++)
            CursosEscola.get(i);
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            EscolaInformatica e = (EscolaInformatica) obj;
            ig = this.NomeEscola.equals(e.NomeEscola) && (this.CodEscola == e.CodEscola) && (this.DiretorEscola.equals(e.DiretorEscola)) && (this.ContactoEscola.equals(e.ContactoEscola)) && (this.CursosEscola.equals(e.CursosEscola));
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
        return copia;
    }

    public static void main(String[] args) {
        // Há espera das outras classes para conseguir elaborar a classe teste do Curso
    } 
}
