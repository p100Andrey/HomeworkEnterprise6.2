import java.util.Date;

public class PrigotovlenoeBlydo {

    int idGotovoeBlydo;
    int blydo;
    int povar;
    int zakaz;
    Date date;

    public PrigotovlenoeBlydo(int idGotovoeBlydo, int blydo, int povar, int zakaz, Date date) {
        this.idGotovoeBlydo = idGotovoeBlydo;
        this.blydo = blydo;
        this.povar = povar;
        this.zakaz = zakaz;
        this.date = date;
        addPrigotovlenoeBlydo(this);
    }

    public void addPrigotovlenoeBlydo (PrigotovlenoeBlydo prigotovlenoeBlydo){

    }

    public void printPrigotovlenieBlyda (PrigotovlenoeBlydo prigotovlenoeBlydo){

    }
}
