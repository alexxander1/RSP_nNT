public class EconomCar extends car {
    int maxSpeed;
    int spaciouslesness = 4;

    EconomCar(String name,int speed, int spaciouslesness, int chargeFuel) {
        super(name,speed, spaciouslesness, chargeFuel);
    }


    public void setMaxSpeed(int maxSpeed){
        if (maxSpeed<80){
            this.maxSpeed = maxSpeed;
        }else {this.maxSpeed=80;

        }
    }


    public void callTaxi(int maxSpeed,int spaciouslesness){
        if(spaciouslesness <= this.spaciouslesness){
            setMaxSpeed(maxSpeed);
            System.out.println("ваше такси уже в пути");
        }
        else {
            System.out.println("вы не можете заказать такси по причине большого количества людей");
        }
    }

    public void returnTaxi(){
        maxSpeed = 0;
    }
}
