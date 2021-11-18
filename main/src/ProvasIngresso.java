import java.util.ArrayList;

public class ProvasIngresso {
    private String nomPI;
    private int codProva;
    private ArrayList<String> listaPI;
    String e_ou;
    
    public ProvasIngresso(){
        nomPI = "";
        codProva = 0;
        listaPI = new ArrayList<String>();
        String e_ou;
    }

    public ProvasIngresso(String nomPI, int codProva, String e_ou){
        this.nomPI = nomPI;
        this.codProva = codProva;
        this.e_ou = e_ou;
        listaPI = new ArrayList<String>();
    }

    public String getNomPI(){
        return this.nomPI;
    }

    public void setNomPI(String nomPI){
        this.nomPI	= nomPI;
    }

    public int getCodProva(){
        return this.codProva;
    }

    public void setCodProva(int codProva){
        this.codProva = codProva;
    }

    public ArrayList<String> getListaPI(){
        return this.listaPI;
    }

    public void setListaPI(ArrayList<String> listaPI){
        this.listaPI = (ArrayList<String>) listaPI.clone();

    }

    public String getE_OU(){
        return this.e_ou;
    }

    public void setE_OU(String e_ou){
        this.e_ou = e_ou;
     
    }

    public String toString(){
        String s;
        s = "\nProva de Ingresso: " + nomPI + "/ Cód.Prova: " + codProva;
        s = s + "Lista das Provas de Ingresso: (";
        for (int i = 0; i < listaPI.size(); i++) {
            if (i != listaPI.size() - 1)
                s = s + listaPI.get(i) + this.e_ou + ", " ;
            else
                s = s + listaPI.get(i) + this.e_ou + ")\n";
        }
        return s;
    }

    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            ProvasIngresso pi = (ProvasIngresso) obj;
            ig = this.codProva == pi.codProva && (this.nomPI.equals(pi.nomPI)) && (this.e_ou.equals(pi.e_ou));
            ig = ig && (this.listaPI.equals(pi.listaPI));
        }
        else{
            ig = false;
        }
        return ig;
    }

    public Object clone(){
        ProvasIngresso copia = new ProvasIngresso();
        copia.codProva = this.codProva;
        copia.nomPI = this.nomPI;
        copia.e_ou = this.e_ou;
        copia.listaPI = (ArrayList<String>) this.listaPI.clone();
        return copia;
    }

    public static void main(String[] args) {
        // Há espera das outras classes para conseguir elaborar a classe teste da Disciplina.
    }
}
