package genetics.crossover;

import genetics.Chromosome;
import javafx.util.Pair;

import java.util.Collections;
import java.util.Random;

public class SubsetCrossover implements ICrossoverStrategy {
    @Override
    public <T, C extends Chromosome<T, C>> Pair<C, C> crossover(Chromosome<T, C> lhs, C rhs) {
        assert(lhs.size == rhs.size);
        int size = lhs.size;
        C child1 = lhs.create(), child2 = rhs.create();
        Collections.copy(child1.chromosomeData, lhs.chromosomeData);
        Collections.copy(child2.chromosomeData, rhs.chromosomeData);

        Random rng = new Random();
        for (int i = 0; i < size; i++) {
            if(rng.nextBoolean()){
                T A = child1.chromosomeData.get(i);
                T B = child2.chromosomeData.get(i);
                child1.chromosomeData.set(i, B);
                child2.chromosomeData.set(i, A);
            }
        }
        return new Pair<>(child1, child2);
    }
}
