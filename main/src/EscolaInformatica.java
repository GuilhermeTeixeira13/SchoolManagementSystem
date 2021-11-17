import java.util.ArrayList;
import java.util.Date;

public class EscolaInformatica {
    private int CodEscola;
    private ArrayList<Curso> CursosEscola;
    private Diretor Diretor;
    private Contactos Contactos;

    public EscolaInformatica(){
        this.CodEscola = 0;
        this.CursosEscola = new ArrayList<Curso>();
        this.Diretor = new Diretor();
    }
}
