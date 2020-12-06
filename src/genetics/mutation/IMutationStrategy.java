package genetics.mutation;

import genetics.Chromosome;

public interface IMutationStrategy {
    <T, C extends Chromosome<T, C>> void mutate(Chromosome<T,C> chr, int generationIdx);
}
