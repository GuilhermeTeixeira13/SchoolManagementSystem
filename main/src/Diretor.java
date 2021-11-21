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

    public Diretor(Pessoa p, int anosDeServico, String formacaoAcademica){
        super(p.getNome(), p.getContactos(), p.getLocalDeOrigem(), p.getEmail(), p.getDataNascimento());
        this.anosDeServico = anosDeServico;
        this.formacaoAcademica = formacaoAcademica;
    }

    public Diretor(Diretor d){
        super(d.getNome(), d.getContactos(), d.getLocalDeOrigem(), d.getEmail(), d.getDataNascimento());
        this.formacaoAcademica = d.formacaoAcademica;
        this.anosDeServico = d.anosDeServico;
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
            ig = ig && (this.anosDeServico == e.anosDeServico) && (this.formacaoAcademica.equals(e.formacaoAcademica));
        }
        else
            ig = false;
        return ig;
    }

    // Clone
    public Object clone(){
        Diretor copia = new Diretor(this);
        return copia;
    }

    public static void main(String[] args) {
        // Testes
    }
}
