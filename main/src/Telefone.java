public class Telefone {
    // Atributos
    private String nomecontact;
    private long numero;
    private String email;

    // Construtores
    public Telefone(){
        this.nomecontact = "";
        this.numero = 0;
    }

    public Telefone(String nomecontact, long numero, String email){
        this.nomecontact = nomecontact;
        this.numero = numero;
        this.email = email;
    }

    // Getters e Setters
    public String getNomeContact(){
        return nomecontact;
    }

    public void setNomeContact(String nomecontact){
        this.nomecontact = nomecontact;
    }

    public long getNumero(){
        return numero;
    }

    public void setNumero(long numero){
        this.numero = numero;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    // To String
    public String toString(){
        String s = "Nome: " + nomecontact + "\nNúmero: " + numero + "\nEmail: " + email;
        return s;
    }

    // Equals
    public boolean equal(Object obj){
        if(obj != null && this.getClass() == obj.getClass()){
            Telefone tel = (Telefone) obj;
            return (this.numero == tel.numero && this.nomecontact.equals(tel.nomecontact) && (this.email.equals(tel.email)));
        }
        return false;
    }

    // Clone
    public Object clone(){
        Telefone tel = new Telefone();
        tel.numero = this.numero;
        tel.nomecontact= this.nomecontact;
        tel.email = this.email;
        return tel;
    }

    public static void main(String[] args) {
        // Testes
    }
}
