import java.util.Date;

public class Pessoa {
    // Atributos
    private String nome;
    private Contactos contactos;
    private String localDeOrigem;
    private String email;
    private Date dataNascimento;

    // Construtores
    public Pessoa(){
        this.nome = "";
        this.contactos = new Contactos();
        this.localDeOrigem = "";
        this.email = "";
        this.dataNascimento = new Date();
    }

    public Pessoa(String nome, Contactos contactos, String localDeOrigem, String email, Date dataNascimento){
        this.nome = nome;
        this.contactos = contactos;
        this.localDeOrigem = localDeOrigem;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setContactos(Contactos contactos){
        this.contactos = contactos;
    }
    public Contactos getContactos(){
        return this.contactos;
    }

    public void setLocalDeOrigem(String localDeOrigem){
        this.localDeOrigem = localDeOrigem;
    }
    public String getLocalDeOrigem(){
        return this.localDeOrigem;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public Date getDataNascimento(){
        return this.dataNascimento;
    }

    public String toString(){
        String s;
        s = "\nNome: "+nome+"/ Data de Nascimento: "+dataNascimento+"/ email: "+email+"/ Local De Origem: "+localDeOrigem+" / Contactos: "+contactos;    
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            Pessoa e = (Pessoa) obj;
            ig = (this.nome.equals(e.nome)) && (this.localDeOrigem.equals(e.localDeOrigem)) && (this.email.equals(e.email)) && (this.contactos.equals(e.contactos)) && (this.dataNascimento.equals(e.dataNascimento));
        }
        else
            ig = false;

        return ig;
    }

    // Clone
    public Object clone(){
        Pessoa copia = new Pessoa();
        copia.nome = this.nome;
        copia.email = this.nome;
        copia.localDeOrigem = this.localDeOrigem;
        copia.contactos = this.contactos;
        copia.dataNascimento = this.dataNascimento;
        return copia;
    }

    public static void Teste(String[] args) {
        //À  espera das outras classes para conseguir elaborar a classe teste do Curso
    }
}