public class Telefone {
    private String tipo;
    private int numero;

    public Telefone(){
        this.tipo = "";
        this.numero = 0;
    }

    public Telefone(String tipo, int numero){
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public String toString(){
        String s = "Tipo: " + tipo + "\nNúmero: " + numero;
        return s;
    }

    public boolean equal(Object obj){
        if(obj != null && this.getClass() == obj.getClass()){
            Telefone tel = (Telefone) obj;
            return (this.numero == tel.numero && this.tipo.equals(tel.tipo));
        }
        return false;
    }

    public Object clone(){
        Telefone tel = new Telefone();
        tel.numero = this.numero;
        tel.tipo = this.tipo;
        return tel;
    }
}
