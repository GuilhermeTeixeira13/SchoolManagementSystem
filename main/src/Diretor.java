import java.util.Date;


public class Diretor extends Pessoa{
    //Atributos
    private int anosDeServico ;
    private String formacaoAcademica;

    // Construtores
    public Diretor(){
        super();
        this.anosDeServico = 0;
        this.formacaoAcademica = "";
    }

    public Diretor(String nome, Contactos contactos, String localDeOrigem, String email, Date dataNascimento, int anosDeServico, String formacaoAcademica){
        super(nome, contactos, localDeOrigem, email, dataNascimento);
        this.anosDeServico = anosDeServico;
        this.formacaoAcademica = formacaoAcademica;
    }

    //Getters e Setters
    public void setNome(String nome){
        super.setNome(nome);
    }
    public String getNome(){
        return super.getNome();
    }

    public void setContactos(Contactos contactos){
        super.setContactos(contactos);
    }
    public Contactos getContactos(){
        return super.getContactos();
    }

    public void setLocalDeOrigem(String localDeOrigem){
        super.setLocalDeOrigem(localDeOrigem);;
    }
    public String getLocalDeOrigem(){
        return super.getLocalDeOrigem();
    }

    public void setEmail(String email){
        super.setEmail(email);
    }
    public String getEmail(){
       return super.getEmail();
    }

    public void setDataDeNascimento(Date dataNascimento){
        super.setDataNascimento(dataNascimento);
    }
    public Date getDataDeNascimento(){
       return super.getDataNascimento();
    }

    public void setAnosDeServico(int anosDeServico){
        this.anosDeServico = anosDeServico;
    }
    public int getAnosDeServico(){
       return this.anosDeServico;
    }

    public void setFormacaoAcademica(String formacaoAcademica){
        this.formacaoAcademica = formacaoAcademica;
    }
    public String getFormacaoAcademica(){
       return this.formacaoAcademica;
    }

    // toString
    public String toString(){
        String s;
        s = super.toString();
        s = s + " / Formação Académica: " + this.formacaoAcademica + " / Anos de Serviço: " + this.anosDeServico + "\n";
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if(obj != null && this.getClass() == obj.getClass()){
            Diretor e = (Diretor) obj;
            ig = super.equals(e);
            ig = ig && (this.anosDeServico == e.anosDeServico) && (this.formacaoAcademica == e.formacaoAcademica);
        }
        else
            ig = false;
        return ig;
    }

    // Clone
    public Object clone(){
        Diretor copia = new Diretor();
        copia = (Diretor)super.clone();
        copia.anosDeServico = this.anosDeServico;
        copia.formacaoAcademica = this.formacaoAcademica;
        return copia;
    }

    public static void main(String[] args) {
        
    }
}
