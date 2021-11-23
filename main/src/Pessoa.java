import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.text.SimpleDateFormat;

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
        s = "\nNome: "+nome+"/ Data de Nascimento: "+ dataNascimento.toString().substring(0, 11)+dataNascimento.toString().substring(24, 28) +"/ email: "+email+"/ Local De Origem: "+localDeOrigem+" / Contactos: "+contactos;    
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

    public int calculaIdade() {
        LocalDate LdataNascimento = this.dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        if ((dataNascimento != null) && (currentDate != null)) {
            return Period.between(LdataNascimento, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception{
        Pessoa p1 = new Pessoa();

        // As duas seguintes linhas serão implementadas na main a partir de uma função definida na mesma
        String sDataNascimento = Ler.umaString();
        Date DataNascimento = new SimpleDateFormat("dd/MM/yyy").parse(sDataNascimento);

        p1.setDataNascimento(DataNascimento);
        System.out.println(p1.calculaIdade());
    }
}