package genetics;

import genetics.crossover.ICrossoverStrategy;
import genetics.mutation.IMutationStrategy;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class Chromosome<T, C extends Chromosome<T, C>> {
    private ICrossoverStrategy crossoverStrategy;
    private IMutationStrategy mutationStrategy;
    public List<T> chromosomeData;
    public int size;
    public Chromosome(int size, ICrossoverStrategy crossoverStrategy, IMutationStrategy mutationStrategy){
        this.crossoverStrategy = crossoverStrategy;
        this.mutationStrategy = mutationStrategy;
        this.size = size;
        chromosomeData = new ArrayList<>(size);
        while(chromosomeData.size() < size) chromosomeData.add(null);

    }
    public void mutate(int generationIdx){
        mutationStrategy.mutate(this, generationIdx);
    }
    public Pair<C, C> crossoverWith(C rhs){
        return crossoverStrategy.crossover(this, rhs);
    }

    public abstract void randomize();
    public abstract double getFitness();


    public abstract C create();
}
