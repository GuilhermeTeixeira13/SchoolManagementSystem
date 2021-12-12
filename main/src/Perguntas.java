public class Perguntas implements java.io.Serializable {
    private float cotaçao;
    private String pergunta;

    public Perguntas() {
        this.cotaçao = 0;
        this.pergunta = "";
    }

    public Perguntas(float cotaçao, String pergunta) {
        this.cotaçao = cotaçao;
        this.pergunta = pergunta;
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
        s = "Pergunta: " + pergunta + "// Cotação:" + cotaçao;
        return s;
    }

    public boolean equals(Object obj){
        boolean ig=false;
        if(obj != null && this.getClass()==obj.getClass()){
            Perguntas e = (Perguntas) obj;
            ig= (this.cotaçao==e.cotaçao)&&(this.pergunta.equals(e.pergunta));
        }else
            ig=false;
        return ig;
    }

    public Object clone(){
        Perguntas copia=new Perguntas();
        copia.pergunta=this.pergunta;
        copia.cotaçao=this.cotaçao;
        return copia;
    }

    public static void main(String[] args) {
        // Teste
    }
}