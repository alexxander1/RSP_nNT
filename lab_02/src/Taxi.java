import java.util.ArrayList;

public class Taxi {
    private ArrayList<car> taxi = new ArrayList<>();
    public void addCar(car carName){
        taxi.add(carName);
    }

    public void returnInfo(){
        int EliteCar = 0;
        int EconomCar = 0;
        for (car vv:taxi
             ) {
            if(vv instanceof EliteCar){
                EliteCar++;
            }else {
                EconomCar++;
            }
        }
        System.out.print("В нашем такси есть "+EliteCar+" Элитных авто, и "+EconomCar+" автомобилей эконом класса\n");
    }

    public void sortFuel(int lowLitr,int hightLitr){
        for (car a:taxi
             ) {
            if(a.chargeFuel>=lowLitr && a.chargeFuel<=hightLitr){
                System.out.print(a.name+"\n");
            }
        }
    }

    public void sortSpeed(int lowSpeed,int hightSpeed){
        for (car a:taxi
        ) {
            if(a.speed>=lowSpeed && a.speed<=hightSpeed){
                System.out.print(a.name+"\n");
            }
        }
    }

}
