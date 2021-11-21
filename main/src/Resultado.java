public class Resultado {
    private int id;
    private int cotaçao;

    public Resultado() {
        this.id = 0;
        this.cotaçao = 0;
    }

    public Resultado(int id, int cotaçao) {
        this.id = 0;
        this.cotaçao = 0;
    }

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getcotaçao() {
        return this.cotaçao;
    }

    public void setcotaçao(int cotaçao) {
        this.cotaçao = cotaçao;
    }

    public String toString() {
        String s;
        s = "\nFrequencia ID :" + id + "\nresultado (" + cotaçao + ")";
        return s;
    }

public boolean equals(Object obj){
    boolean ig = false;
    if (obj != null && this.getClass() == obj.getClass()) {
        Resultado res1=(Resultado) obj;
        ig=((this.id==res1.id)&&(this.cotaçao==res1.cotaçao));
    }else{
        ig=false;
    }
    return ig;
}

    public Object clone() {
        Resultado copia = new Resultado();
        copia.id = this.id;
        copia.cotaçao = this.cotaçao;
        return copia;
    }

}
