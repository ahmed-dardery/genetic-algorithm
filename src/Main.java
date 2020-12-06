import genetics.*;
import javafx.util.Pair;

public class Main {
    public static void main(String[] args) {
        MyChromosome temp1 = new MyChromosome(7);
        MyChromosome temp2 = new MyChromosome(7);
        temp1.randomize();
        temp2.randomize();
        System.out.println(temp1.chromosomeData);
        System.out.println(temp2.chromosomeData);
        Pair<MyChromosome, MyChromosome> ret = temp1.crossoverWith(temp2);
        MyChromosome a = ret.getKey();
        MyChromosome b = ret.getValue();
        System.out.println(a.chromosomeData);
        System.out.println(b.chromosomeData);
    }
    static class MyChromosome extends PermutationChromosome<MyChromosome> {
        MyChromosome(int size) {
            super(size);
        }

        @Override
        public MyChromosome create() {
            return new MyChromosome(size);
        }

        @Override
        public double getFitness() {
            double ret = 0;
            for (int i = 0; i < size; i++) {
                ret += this.chromosomeData.get(i) * (i+1);
            }
            return ret;
        }
    }
}
