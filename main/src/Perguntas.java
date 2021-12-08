package src;

public class Perguntas implements java.io.Serializable {
    int numpergunta;
    float cotaçao;
    String pergunta;

    public Perguntas() {
        this.numpergunta = 0;
        this.cotaçao = 0;
        this.pergunta = "";
    }

    public Perguntas(int numpergunta, float cotaçao, String pergunta) {
        this.numpergunta = numpergunta;
        this.cotaçao = cotaçao;
        this.pergunta = pergunta;
    }

    public int getnumpergunta() {
        return this.numpergunta;
    }

    public void setnumpergunta(int numpergunta) {
        this.numpergunta = numpergunta;
    }

    public float getcotaçao() {
        return this.cotaçao;
    }

    public void setcotaçao(float cotaçao) {
        this.cotaçao = cotaçao;
    }

    public String getpergunta() {
        return this.pergunta;
    }

    public void setpergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String toString() {
        String s;
        s = "Número da pergunta: " + numpergunta + "// Pergunta: " + pergunta + "// Cotação:" + cotaçao;
        return s;
    }

    public boolean equals(Object obj){
        boolean ig=false;
        if(obj != null && this.getClass()==obj.getClass()){
            Perguntas e = (Perguntas) obj;
            ig= (this.cotaçao==e.cotaçao)&&(this.numpergunta==e.numpergunta)&&(this.pergunta.equals(e.pergunta));
        }else
            ig=false;
        return ig;
    }

    public Object clone(){
        Perguntas copia=new Perguntas();
        copia.numpergunta= this.numpergunta;
        copia.pergunta=this.pergunta;
        copia.cotaçao=this.cotaçao;
        return copia;
    }

    public static void main(String[] args) {
        // Teste
    }
}