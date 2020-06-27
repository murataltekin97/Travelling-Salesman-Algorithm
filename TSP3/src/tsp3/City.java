package tsp3;

public class City {
    int x;
    int y;
    
    // Rasgele bir yer içeren şehir
    public City(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    // X ve Y koordinatlarına göre oluşturulmuş şehir.
    public City(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    
    // Verilen şehir ve sonraki adım arasındaki mesafeyi döndürür.
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    // Şehirlerin hangi adımları izlediğini yazdırır.
    @Override
    public String toString(){
        return getX()+","+getY()+"|"+"\n";
    }
}