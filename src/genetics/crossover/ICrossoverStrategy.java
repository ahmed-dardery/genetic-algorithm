package genetics.crossover;

import genetics.Chromosome;
import javafx.util.Pair;

public interface ICrossoverStrategy {
    <T, C extends Chromosome<T, C>> Pair<C, C> crossover(final Chromosome<T,C> lhs, final C rhs);
}
