package vehiclerental;

import java.time.LocalTime;
import java.util.Objects;

public class Bike implements Rentable{
    private String ID;
    private LocalTime rentingTime;
    private int fee=15;

    public Bike(String ID) {
        this.ID = ID;
    }
    public int calculateSumPrice(long minutes){
        return (int) (fee*minutes);
    }



    @Override
    public void rent(LocalTime time){
        this.rentingTime=LocalTime.now();
    }

    @Override
    public void closeRent(){
        this.rentingTime=null;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return fee == bike.fee && Objects.equals(ID, bike.ID) && Objects.equals(rentingTime, bike.rentingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, rentingTime, fee);
    }
}
