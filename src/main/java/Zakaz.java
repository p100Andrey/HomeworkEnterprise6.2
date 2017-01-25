import java.util.Date;

public class Zakaz {

    int idZakaz;
    int oficiant;
    int stolik;
    Date date;
    boolean zakazOpen = true;

    public Zakaz(int idZakaz, int oficiant, int stolik, Date date) {
        this.idZakaz = idZakaz;
        this.oficiant = oficiant;
        this.stolik = stolik;
        this.date = date;
        addNewZakaz(this);
    }

    public void addNewZakaz(Zakaz zakaz) {

    }

    public void delZakaz(Zakaz zakaz) {
        if (zakazOpen == true) {
            //todo
        } else {
            return;
        }
    }

    public void addBlydoToZakaz(Blydo blydo) {
        if (zakazOpen == true) {
            //todo
        } else {
            return;
        }
    }

    public void delBlydoFromZakaz(Blydo blydo) {
        if (zakazOpen == true) {
            //todo
        } else {
            return;
        }
    }

    public void closeZakaz(Zakaz zakaz) {
        if (zakazOpen == true) {
            //todo
        } else {
            return;
        }
    }

    public void printOpenZakazy (){

    }

    public void printCloseZakazy (){

    }
}
