public class Telefone {
    // Atributos
    private String tipo;
    private long numero;

    // Construtores
    public Telefone(){
        this.tipo = "";
        this.numero = 0;
    }

    public Telefone(String tipo, long numero){
        this.tipo = tipo;
        this.numero = numero;
    }

    // Getters e Setters
    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public long getNumero(){
        return numero;
    }

    public void setNumero(long numero){
        this.numero = numero;
    }

    // To String
    public String toString(){
        String s = "Tipo: " + tipo + ", Número: " + numero;
        return s;
    }

    // Equals
    public boolean equal(Object obj){
        if(obj != null && this.getClass() == obj.getClass()){
            Telefone tel = (Telefone) obj;
            return (this.numero == tel.numero && this.tipo.equals(tel.tipo));
        }
        return false;
    }

    // Clone
    public Object clone(){
        Telefone tel = new Telefone();
        tel.numero = this.numero;
        tel.tipo = this.tipo;
        return tel;
    }

    public static void main(String[] args) {
        // Testes
    }
}