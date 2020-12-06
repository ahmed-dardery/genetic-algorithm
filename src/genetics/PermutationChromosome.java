package genetics;

import genetics.crossover.Order1Crossover;
import genetics.mutation.SwapMutation;

import java.util.Collections;

public abstract class PermutationChromosome<C extends Chromosome<Integer, C>> extends Chromosome<Integer, C> {
    public PermutationChromosome(int size) {
        super(size, new Order1Crossover(), new SwapMutation());
        for(int i = 0; i < size; ++i)
            chromosomeData.set(i, i+1);
    }

    @Override
    public void randomize() {
        Collections.shuffle(chromosomeData);
    }
}
