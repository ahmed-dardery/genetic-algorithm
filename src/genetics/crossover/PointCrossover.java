package genetics.crossover;

import genetics.Chromosome;
import javafx.util.Pair;

import java.util.Random;

public class PointCrossover implements ICrossoverStrategy {
    @Override
    public <T, C extends Chromosome<T, C>> Pair<C, C> crossover(Chromosome<T, C> lhs, C rhs) {
        assert (lhs.size == rhs.size);
        int size = lhs.size;
        C child1 = lhs.create(), child2 = rhs.create();
        Random rng = new Random();
        int point = rng.nextInt(size);
        for (int i = 0; i <= point; i++) {
            T v1 = lhs.chromosomeData.get(i), v2 = rhs.chromosomeData.get(i);
            child1.chromosomeData.set(i, v1);
            child2.chromosomeData.set(i, v2);
        }
        for (int i = point+1; i < size; i++) {
            T v1 = lhs.chromosomeData.get(i), v2 = rhs.chromosomeData.get(i);
            child2.chromosomeData.set(i, v1);
            child1.chromosomeData.set(i, v2);
        }
        return new Pair<>(child1, child2);
    }
}
