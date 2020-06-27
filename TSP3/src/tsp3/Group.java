package tsp3;

public class Group {

    // Yol patikasındaki adımları tutar.
    Walk[] tours;


    public Group(int populationSize, boolean initialise) {
        tours = new Walk[populationSize];
        // Grup boyutu genişliğinde bir adım haritası oluşturur.
        if (initialise) {
            for (int i = 0; i < populationSize(); i++) {
                Walk newTour = new Walk();
                newTour.generateIndividual();
                saveTour(i, newTour);
            }
        }
    }
    
    // Turdaki indexleri saklar.
    public void saveTour(int index, Walk tour) {
        tours[index] = tour;
    }
    
    // Adımları içeren bir dizi döndürür
    public Walk getTour(int index) {
        return tours[index];
    }

    // En uygun ve en az maliyetli olan adımları döndürür.
    public Walk getFittest() {
        Walk fittest = tours[0];
        // En uygun adımları bulmak için döngü oluşturur.
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    public int populationSize() {
        return tours.length;
    }
}