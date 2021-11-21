public class Perguntas {
    int numpergunta;
    int cotaçao;
    String pergunta;

    public Perguntas() {
        this.numpergunta = 0;
        this.cotaçao = 0;
        this.pergunta = "";
    }

    public Perguntas(int numpergunta, int cotaçao, String pergunta) {
        this.numpergunta = numpergunta;
        this.cotaçao = cotaçao;
        this.pergunta = pergunta;
    }

    public int getnumpergunta() {
        return this.numpergunta;
    }

    public void setnumpergunta() {
        this.numpergunta = numpergunta;
    }

    public int getcotaçao() {
        return this.cotaçao;
    }

    public void setcotaçao() {
        this.cotaçao = cotaçao;
    }

    public String getpergunta() {
        return this.pergunta;
    }

    public void setpergunta() {
        this.pergunta = pergunta;
    }

    public String toString() {
        String s;
        s = "numero da pergunta: " + numpergunta + "pergunta: " + pergunta + "cotação" + cotaçao;
        return s;
    }

public boolean equals(Object obj){
boolean ig=false;
if(obj != null && this.getClass()==obj.getClass()){
    Perguntas perg1=(Perguntas) obj;
    ig= (this.cotaçao==perg1.cotaçao)&&(this.numpergunta==perg1.numpergunta)&&(this.pergunta.equals(perg1.pergunta));
}else{
    ig=false;
}
return ig;

}
public Object clone(){
    Perguntas copia=new Perguntas();
    copia.numpergunta= this.numpergunta;
copia.pergunta=this.pergunta;
copia.cotaçao=this.cotaçao;
return copia;
}
}