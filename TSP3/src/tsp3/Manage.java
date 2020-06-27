package tsp3;
import java.util.ArrayList;

public class Manage {

    // Şehirleri tutar.
    private static ArrayList destinationCities = new ArrayList<City>();

    // ArrayList'in içine şehir ekler.
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    // Şehir'i döndürür.
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    // Şehir ArrayListindeki şehir sayısını döndürür.
    public static int numberOfCities(){
        return destinationCities.size();
    }
}