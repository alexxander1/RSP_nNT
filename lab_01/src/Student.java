import java.util.Date;

public class Student {
    int id;
    String FIO_F;
    String FIO_I;
    String FIO_O;
    Date data;
    String adres;
    String Phone_num;
    String Facultet;
    int Kurs;
    String Gruppa;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String FIO_F, String FIO_I, String FIO_O, Date data, String adres, String phone_num, String facultet, int kurs, String gruppa) {
        this.id = id;
        this.FIO_F = FIO_F;
        this.FIO_I = FIO_I;
        this.FIO_O = FIO_O;
        this.data = data;
        this.adres = adres;
        Phone_num = phone_num;
        Facultet = facultet;
        Kurs = kurs;
        Gruppa = gruppa;
    }

    public String getFIO_F() {
        return FIO_F;
    }

    public void setFIO_F(String FIO_F) {
        this.FIO_F = FIO_F;
    }

    public String getFIO_I() {
        return FIO_I;
    }

    public void setFIO_I(String FIO_I) {
        this.FIO_I = FIO_I;
    }

    public String getFIO_O() {
        return FIO_O;
    }

    public void setFIO_O(String FIO_O) {
        this.FIO_O = FIO_O;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPhone_num() {
        return Phone_num;
    }

    public void setPhone_num(String phone_num) {
        Phone_num = phone_num;
    }

    public String getFacultet() {
        return Facultet;
    }

    public void setFacultet(String facultet) {
        Facultet = facultet;
    }

    public int getKurs() {
        return Kurs;
    }

    public void setKurs(int kurs) {
        Kurs = kurs;
    }

    public String getGruppa() {
        return Gruppa;
    }

    public void setGruppa(String gruppa) {
        Gruppa = gruppa;
    }

    @Override
    public String toString() {
        return "House {" +
                "id= " + id +
                ", FIO_F= " + FIO_F  +
                ", FIO_I= " + FIO_I +
                ", FIO_O= " + FIO_O +
                ", data= " + data.getYear() + "." + data.getMonth() + "." + data.getDay() +
                ", adres= " + adres +
                ", phone_num =" + Phone_num +
                ", Facultet= " + Facultet +
                ", Kurs= " + Kurs +
                ", Gruppa= " + Gruppa +
                '}';
    }

}
