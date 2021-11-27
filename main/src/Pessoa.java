import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;


public class Pessoa implements Serializable{
    // Atributos
    private String nome;
    private Contactos contactos;
    private String localDeOrigem;
    private LocalDate dataNascimento;

    // Construtores
    public Pessoa(){
        this.nome = "";
        this.contactos = new Contactos();
        this.localDeOrigem = "";
        this.dataNascimento = LocalDate.now();
    }

    public Pessoa(String nome, Contactos contactos, String localDeOrigem, LocalDate dataNascimento){
        this.nome = nome;
        this.contactos = contactos;
        this.localDeOrigem = localDeOrigem;
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

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }

    public String toString(){
        String s;
        s = "\nNome: "+nome+"/ Data de Nascimento: " + this.dataNascimento.toString() + "/ Local De Origem: "+localDeOrigem+" / Contactos: "+contactos;    
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            Pessoa e = (Pessoa) obj;
            ig = (this.nome.equals(e.nome)) && (this.localDeOrigem.equals(e.localDeOrigem)) && (this.contactos.equals(e.contactos)) && (this.dataNascimento.equals(e.dataNascimento));
        }
        else
            ig = false;

        return ig;
    }

    // Clone
    public Object clone(){
        Pessoa copia = new Pessoa();
        copia.nome = this.nome;
        copia.localDeOrigem = this.localDeOrigem;
        copia.contactos = this.contactos;
        copia.dataNascimento = this.dataNascimento;
        return copia;
    }

    public int calculaIdade() {
        LocalDate currentDate = LocalDate.now();
        if ((dataNascimento != null) && (currentDate != null))
            return Period.between(this.dataNascimento, currentDate).getYears();
        else
            return 0;
    }

    public static void main(String[] args) throws Exception{
        Pessoa p1 = new Pessoa();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        System.out.print("Digite uma data no formato 'dd/MM/yyyy' --> ");
        String dateString = Ler.umaString();
        LocalDate data = LocalDate.parse(dateString, formatter);

        p1.setDataNascimento(data);
        System.out.println("Idade: " + p1.calculaIdade());

        System.out.println("Data: " + data.toString());
    }
}