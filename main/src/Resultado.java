

public class Resultado implements java.io.Serializable {
    // Atributos
    private int idFreq;
    private float cotaçao;

    // Contrutores
    public Resultado() {
        this.idFreq = 0;
        this.cotaçao = 0;
    }

    public Resultado(int idFreq, float cotaçao) {
        this.idFreq = idFreq;
        this.cotaçao = cotaçao;
    }

    // Getters e Setters
    public int getid() {
        return this.idFreq;
    }

    public void setid(int idFreq) {
        this.idFreq = idFreq;
    }

    public float getcotaçao() {
        return this.cotaçao;
    }

    public void setcotaçao(float cotaçao) {
        this.cotaçao = cotaçao;
    }

    public String toString() {
        String s;
        s = "\nID Frequência: " + idFreq + "// Resultado: "+ cotaçao;
        return s;
    }

    // Equals
    public boolean equals(Object obj){
        boolean ig = false;
        if (obj != null && this.getClass() == obj.getClass()) {
            Resultado res1=(Resultado) obj;
            ig=((this.idFreq==res1.idFreq)&&(this.cotaçao==res1.cotaçao));
        }else
            ig=false;
        return ig;
    }

    // Clone
    public Object clone() {
        Resultado copia = new Resultado();
        copia.idFreq = this.idFreq;
        copia.cotaçao = this.cotaçao;
        return copia;
    }

    public static void main(String[] args) {
        // Testes
    }
}
