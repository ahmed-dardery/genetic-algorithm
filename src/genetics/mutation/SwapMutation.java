package genetics.mutation;

import genetics.Chromosome;

import java.util.Random;

public class SwapMutation implements IMutationStrategy {

    @Override
    public <T, C extends Chromosome<T, C>> void mutate(Chromosome<T,C> chr, int generationIdx) {
        Random rng = new Random();
        int a = rng.nextInt(chr.size);
        int b = rng.nextInt(chr.size);
        T A = chr.chromosomeData.get(a);
        T B = chr.chromosomeData.get(b);
        chr.chromosomeData.set(a, B);
        chr.chromosomeData.set(b, A);
    }
}
