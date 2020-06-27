
package tsp3;


public class CreatePath {
    public static void Create(){
      // Şehirler için rasgele koordinatlar oluşturulmuştur
        int[] dizi1 = {60,180,80,140,20,100,200,140,40,100,180,60,120,180,20,100,200,20,60,160};
        // dizi1'de şehirlerin X koordinatları bulunur.
        int[] dizi2 = {200,200,180,180,160,160,160,140,120,120,100,80,80,60,40,40,40,20,20,20};
        // dizi2'de şehirlerin Y koordinatları bulunur.
        
        for (int i = 0; i < dizi1.length; i++) {
            // dizi1 ve dizi2'deki X ve Y koordinatları kullanılarak şehirler oluşturulur.
            Manage.addCity(new City(dizi1[i],dizi2[i]));
        }
        
      
        
    }
    

    
}
