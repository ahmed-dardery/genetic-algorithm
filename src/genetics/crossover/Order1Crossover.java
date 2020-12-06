package genetics.crossover;

import genetics.Chromosome;
import javafx.util.Pair;

import java.util.*;

public class Order1Crossover implements ICrossoverStrategy {

    @Override
    public <T, C extends Chromosome<T, C>> Pair<C, C> crossover(final Chromosome<T,C> lhs, final C rhs) {
        assert(lhs.size == rhs.size);
        int size = lhs.size;
        Random rng = new Random();
        int st = rng.nextInt(size), en = rng.nextInt(size);
        if(st > en){
            int tmp = st;
            st = en;
            en = tmp;
        }
        C child1 = lhs.create(), child2 = rhs.create();
        List<T> list1 = child1.chromosomeData, list2 = child2.chromosomeData;
        list1.clear();
        list2.clear();
        Set<T> vis1 = new HashSet<>(), vis2 = new HashSet<>();
        for (int i = st; i <= en; i++) {
            T v1 = lhs.chromosomeData.get(i), v2 = rhs.chromosomeData.get(i);
            vis1.add(v1);
            vis2.add(v2);
            list1.add(v1);
            list2.add(v2);
        }
        for(int i = en+1;list1.size() < size || list2.size() < size ; ++i){
            if(i == size) i = 0;
            T v1 = lhs.chromosomeData.get(i), v2 = rhs.chromosomeData.get(i);
            if(!vis1.contains(v2))
                list1.add(v2);
            if(!vis2.contains(v1))
                list2.add(v1);
        }
        Collections.rotate(list1, st);
        Collections.rotate(list2, st);
        return new Pair<>(child1, child2);
    }
}
