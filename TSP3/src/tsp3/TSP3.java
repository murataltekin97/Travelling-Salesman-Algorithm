
package tsp3;


public class TSP3 {
    // Programı uygular ve adımları tek tek yazdırır.
    public static void write(){
        Group pop = new Group(50, true);
        System.out.println("Başlangıçtaki Uzaklık: " + pop.getFittest().getDistance());

        // Genetik algoritmayı çalıştırır ve 100 nesil için uygular.
        pop = GeneticAlgorithms.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GeneticAlgorithms.evolvePopulation(pop);
        }

        System.out.println("Problem Çözüldü...");
        System.out.println("Önerilen Uzaklık: " + pop.getFittest().getDistance());
        System.out.println("Çözüm Adımları koordinat olarak belirtilmiştir(|X,Y|):");
       
        System.out.println(pop.getFittest());
        
    }
    


    public static void main(String[] args) {
        CreatePath.Create();
        write();
   

    }
    
}
