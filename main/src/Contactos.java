import java.util.ArrayList;

public class Contactos {
    // Atributos
    private ArrayList<Telefone> telefones;

    // Construtores
    public Contactos(){
        this.telefones = new ArrayList<Telefone>();
        
    }

    // Getters e Setters
    public ArrayList<Telefone> getTelefones(){
        return this.telefones;
    }

    public void setTelefone(ArrayList<Telefone> telefones){
        this.telefones = (ArrayList<Telefone>) telefones.clone();
    }


    // To String
    public String toString(){
        String s;
        s = "Telefones: " + telefones;
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && obj.getClass() == this.getClass()){
            Contactos e = (Contactos) obj;
            ig =  (this.telefones.equals(e.telefones));
        }
        else{
            ig = false;
        }
        return ig;
    }

    // Clone
    public Object clone(){
        Contactos copia = new Contactos();

        copia.telefones = (ArrayList<Telefone>) this.telefones.clone();

        return copia;
    }

    public static void main(String[] args) {
        // Testes
    }
}
