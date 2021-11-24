import java.util.ArrayList;

public class ProvasIngresso {
    private ArrayList<String> listaPI;
    
    public ProvasIngresso(){
        listaPI = new ArrayList<String>();
    }

    public ProvasIngresso(String e_ou){
        listaPI = new ArrayList<String>();
    }

    public ArrayList<String> getListaPI(){
        return this.listaPI;
    }

    public void setListaPI(ArrayList<String> listaPI){
        this.listaPI = (ArrayList<String>) listaPI.clone();
    }

    public String toString(){
        String s;
        s = " ";
        for (int i = 0; i < listaPI.size(); i++) {
            if (i != listaPI.size() - 1)
                s = s + listaPI.get(i) + " " + " ";
            else
                s = s + listaPI.get(i) +  "\n";
        }
        return s;
    }

    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            ProvasIngresso pi = (ProvasIngresso) obj;
            ig = this.listaPI.equals(pi.listaPI);
        }
        else{
            ig = false;
        }
        return ig;
    }

    public Object clone(){
        ProvasIngresso copia = new ProvasIngresso();
        copia.listaPI = (ArrayList<String>) this.listaPI.clone();
        return copia;
    }

    public static void main(String[] args) {
        // Variáveis 
        boolean igual = false;

        // Disciplinas

        ArrayList<String> discPI1 = new ArrayList<>();
        ArrayList<String> discPI2 = new ArrayList<>();
        discPI1.add("Matemática");
        discPI1.add("Fisica e Quimica");
        discPI2.add("Economia");
        discPI2.add("Geografia");

        // Criar Provas de Ingresso

        ProvasIngresso pi1 = new ProvasIngresso("e");
        pi1.setListaPI(discPI1);
        // System.out.println(pi1);
        ProvasIngresso pi2= new ProvasIngresso("ou");
        pi2.setListaPI(discPI2);
        // System.out.println(pi2);
        Object pi3 = new ProvasIngresso();


        // Testar métodos
        pi3 = pi2.clone();
        System.out.println(pi3);
        igual = pi3.equals(pi2);
        System.out.println(igual);

        


    }
}
