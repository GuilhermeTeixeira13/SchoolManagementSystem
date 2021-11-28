import java.io.Serializable;
import java.util.ArrayList;

public class Contactos implements Serializable{
    // Atributos
    private ArrayList<Telefone> telefones;
    private String e_mail;

    // Construtores
    public Contactos(){
        this.telefones = new ArrayList<Telefone>();
        this.e_mail = "";
    }

    public Contactos(String e_mail){
        this.e_mail = e_mail;
        this.telefones = new ArrayList<Telefone>();
    }

    // Getters e Setters
    public ArrayList<Telefone> getTelefones(){
        return this.telefones;
    }

    public void setTelefone(ArrayList<Telefone> telefones){
        this.telefones = (ArrayList<Telefone>) telefones.clone();
    }

    public String getE_mail(){
        return this.e_mail;
    }

    public void setE_mail(String e_mail){
        this.e_mail = e_mail;
    }

    // To String
    public String toString(){
        String s;
        s = "E_mail: " + e_mail + ", Telefones: " + telefones;
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && obj.getClass() == this.getClass()){
            Contactos e = (Contactos) obj;
            ig = this.e_mail.equals(e.e_mail) && (this.telefones.equals(e.telefones));
        }
        else{
            ig = false;
        }
        return ig;
    }

    // Clone
    public Object clone(){
        Contactos copia = new Contactos();

        copia.e_mail = this.e_mail;
        copia.telefones = (ArrayList<Telefone>) this.telefones.clone();

        return copia;
    }

    public static void main(String[] args) {
        // Testes
    }
}