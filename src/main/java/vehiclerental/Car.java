package vehiclerental;

import java.time.LocalTime;
import java.util.Objects;

public class Car implements Rentable{
    private String ID;
    private LocalTime rentingTime;
    private int fee=15;

    public Car(String ID, int fee) {
        this.ID = ID;
        this.fee = fee;
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
        Car car = (Car) o;
        return fee == car.fee && Objects.equals(ID, car.ID) && Objects.equals(rentingTime, car.rentingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, rentingTime, fee);
    }
}
