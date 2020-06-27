package tsp3;
public class GeneticAlgorithms {
    // Genetik algoritma parametreleri

    private static final double DegisimOrani = 0.015;
    private static final int turBoyutu = 5;
    private static final boolean uygunluk = true;

    // Bİr nesil üzerinde uygular
    public static Group evolvePopulation(Group pop) {
        Group newPopulation = new Group(pop.populationSize(), false);

        // En iyi birey tutulur.
        int elitismOffset = 0;
        if (uygunluk) {
            newPopulation.saveTour(0, pop.getFittest());
            elitismOffset = 1;
        }

        // Populasyonu cross-over yapar ve bireyleri değiştirir.
        // Güncel bireylerden yeni bireyler oluşturur.
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            // En iyi aileyi seçer
            Walk parent1 = tournamentSelection(pop);
            Walk parent2 = tournamentSelection(pop);
            // Aileleri cross-over yapar.
            Walk child = crossover(parent1, parent2);
            // Yeni oluşan bireyi poulasyona ekler
            newPopulation.saveTour(i, child);
        }

        // Yeni genetik populasyon oluşturur.
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getTour(i));
        }

        return newPopulation;
    }

    // Güncel aile ve bireyleri düzenler
    public static Walk crossover(Walk parent1, Walk parent2) {
        // Yeni birey için bir tur oluşturur.
        Walk child = new Walk();

        // Parent1'in turu için yeni alt turlar oluşturur.
        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.tourSize(); i++) {
            // Başlangıç pozisyonunun bitiş pozisyonundan az olup olmadığını kontrol eder.
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            } // Başlangıç pozisyonu bitiş pozisyonundan büyükse
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        // Parent2'nin şehir turları arasında gezinir.
        for (int i = 0; i < parent2.tourSize(); i++) {
            // Eğer yeni oluşturulan birey şehirlerin arasında yoksa ekler.
            if (!child.containsCity(parent2.getCity(i))) {              
                for (int ii = 0; ii < child.tourSize(); ii++) {                    
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Değiştirme notasyonlarını kullanarak turları değiştirir.
    private static void mutate(Walk tour) {
        // Tur olacak şehirler arasında döngü oluşurur.
        for(int tourPos1=0; tourPos1 < tour.tourSize(); tourPos1++){
            // Değişim oranını kullanarak turlarda değişiklik yapar.
            if(Math.random() < DegisimOrani){
                // İkinci rasgele turu verir.
                int tourPos2 = (int) (tour.tourSize() * Math.random());

                // Hedefteki şehirleri oluşturur.
                City city1 = tour.getCity(tourPos1);
                City city2 = tour.getCity(tourPos2);

                // İkisini kendi arasında takas eder.
                tour.setCity(tourPos2, city1);
                tour.setCity(tourPos1, city2);
            }
        }
    }

    // Aday turlar arasında seçme yapar.
    private static Walk tournamentSelection(Group pop) {
        // Yeni tur oluşturur.
        Group tournament = new Group(turBoyutu, false);
        // Aday turlar arasından rasgele seçer ve ekler
        
        for (int i = 0; i < turBoyutu; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomId));
        }
        // En uygun turu döndürür.
        Walk fittest = tournament.getFittest();
        return fittest;
    }
}