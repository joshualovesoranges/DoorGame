public class Door {

    //door has either a goat or a car
    private String prize;

    public String getPrize(){
        return prize;
    }

    public void setPrize(String prize){
        this.prize = prize;
    }

    public boolean hasCar(){
        return "car".equals(prize);
    }



}
