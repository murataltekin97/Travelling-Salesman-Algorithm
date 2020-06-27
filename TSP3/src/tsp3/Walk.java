package tsp3;
import java.util.ArrayList;
import java.util.Collections;

public class Walk{

    // Bütün şehirleri tutan bir arraylist oluşturuldu.
    private ArrayList tour = new ArrayList<City>();
   
    private double fitness = 0;
    private int distance = 0;
    
    // Boş tur için constructor
    public Walk(){
        for (int i = 0; i < Manage.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
    public Walk(ArrayList tour){
        this.tour = tour;
    }

    // Rasgele bireyler oluşturur.
    public void generateIndividual() {
       
        for (int cityIndex = 0; cityIndex < Manage.numberOfCities(); cityIndex++) {
          setCity(cityIndex, Manage.getCity(cityIndex));
        }
        // Turları rasgele yeniden düzenler
        Collections.shuffle(tour);
    }

    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }


    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
   
        fitness = 0;
        distance = 0;
    }
    

    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
  
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
      
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                // Gezmeye başlayacağımız şehir
                City fromCity = getCity(cityIndex);
                // Hedef şehir
                City destinationCity;
                // Gezinin son durağında olup olmadığımızı kontrol eder.
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // İki şehir arasındaki uzaklıkları toplar.
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    // Turdaki şehir sayısını döndürür.
    public int tourSize() {
        return tour.size();
    }
    
    // O şehrin tur içinde olup olmadığını kontrol eder.
    public boolean containsCity(City city){
        return tour.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}