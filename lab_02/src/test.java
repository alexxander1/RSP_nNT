import java.util.ArrayList;

public class test {

    public static void main(String[] args){
    Taxi firstCompany = new Taxi();
    EliteCar mazda = new EliteCar("jjj",150,2,18);

    firstCompany.addCar(mazda);
    firstCompany.returnInfo();
    firstCompany.sortFuel(12,20);
    firstCompany.sortSpeed(12,200);






    }

    void callTaxi(String type){

    }

}
