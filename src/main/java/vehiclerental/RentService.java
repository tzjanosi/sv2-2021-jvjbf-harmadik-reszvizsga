package vehiclerental;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RentService {
    Set<User> usersSet=new TreeSet<User>();
    Set<Rentable> vehicleSet=new TreeSet<Rentable>();
    Map<User,Rentable> actualRenting=new TreeMap<User,Rentable>();

    public RentService() {

    }

    public void registerUser(User user){
        if(usersSet.contains(user)){
            throw new UserNameIsAlreadyTakenException("It is already in the list");
        }
        usersSet.add(user)
        ;
    }
    public void addRentable(Rentable rentable){
        vehicleSet.add(rentable);
    }

    public void rent(User user, Rentable rentable, LocalTime time){
        if(user.getBalance()>rentable.calculateSumPrice(180)) {
            actualRenting.put(user, rentable);
            rentable.rent(LocalTime.now());
        }

    }
    public void closeRent(Rentable rentable, int minutes){
        if(!isThisVehicleRented(rentable)){
            throw new IllegalStateException("Not in the List!");
        }
        User user=getUserFromRentable(rentable);
        actualRenting.remove(user);
        user.minusBalance(rentable.calculateSumPrice(getRentingDuration(rentable)));
    }

    public boolean isThisVehicleRented(Rentable rentable){
        return actualRenting.values().contains(rentable);
    }
    public User getUserFromRentable(Rentable rentable) {
        for (Map.Entry<User,Rentable> entry : actualRenting.entrySet()) {
            if (entry.getValue().equals(rentable)) {
                return entry.getKey();
            }
        }
        return null;
    }
    public int getRentingDuration(Rentable rentable){
        return LocalTime.now().getMinute()-rentable.getRentingTime().getMinute();
    }

    public Set<User> getUsers() {
        return usersSet;
    }

    public Set<Rentable> getRentables() {
        return vehicleSet;
    }

    public Map<User, Rentable> getActualRenting() {
        return actualRenting;
    }
}
