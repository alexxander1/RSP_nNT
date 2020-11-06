public class EliteCar extends car {
    int maxSpeed ;
    int spaciouslesness = 6;
    boolean minibar;

    EliteCar(String name,int speed, int spaciouslesness, int chargeFuel) {
        super(name,speed, spaciouslesness, chargeFuel);
    }

    public void setMaxSpeed(int maxSpeed){
        if (maxSpeed<140){
            this.maxSpeed = maxSpeed;
        }else {this.maxSpeed=140;}


    }

    public void callTaxi(int maxSpeed,int spaciouslesness,boolean minibar){
        if(spaciouslesness <= this.spaciouslesness){
            setMaxSpeed(maxSpeed);
            this.minibar = minibar;
            System.out.println("ваше такси уже в пути");
        }
        else {
            System.out.println("вы не можете заказать такси по причине большого количества людей");
        }
    }

    public void returnTaxi(){
        maxSpeed = 0;
        minibar = false;
    }

}
