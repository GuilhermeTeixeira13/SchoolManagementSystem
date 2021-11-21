import java.util.ArrayList;

public class ProvasIngresso {
    private ArrayList<String> listaPI;
    String e_ou;
    
    public ProvasIngresso(){
        listaPI = new ArrayList<String>();
        e_ou = "";
    }

    public ProvasIngresso(String e_ou){
        this.e_ou = e_ou;
        listaPI = new ArrayList<String>();
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
        s = " ";
        for (int i = 0; i < listaPI.size(); i++) {
            if (i != listaPI.size() - 1)
                s = s + listaPI.get(i) + this.e_ou + " " + e_ou + " ";
            else
                s = s + listaPI.get(i) + this.e_ou + ")\n";
        }
        return s;
    }

    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            ProvasIngresso pi = (ProvasIngresso) obj;
            ig = (this.e_ou.equals(pi.e_ou)) && (this.listaPI.equals(pi.listaPI));
        }
        else{
            ig = false;
        }
        return ig;
    }

    public Object clone(){
        ProvasIngresso copia = new ProvasIngresso();
        copia.e_ou = this.e_ou;
        copia.listaPI = (ArrayList<String>) this.listaPI.clone();
        return copia;
    }

    public static void main(String[] args) {
        // Testes
    }
}
