import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {
    public List<double[]> apply(List<double[]> population, Random random) {
        int length_one = population.get(0).length;
        double rate = 0.17;
//        double rate2 = 0.1;
        for (int i = 0; i < population.size(); i++) {
            if (random.nextDouble() < rate) {
                //v1
                int idx = random.nextInt(population.get(i).length);
                population.get(i)[idx] += random.nextGaussian() % 5;
//                for (int j = 0; j < population.get(i).length; j++) {
//                    if (random.nextDouble() < rate2) {
//                        population.get(i)[j] += random.nextGaussian();//(random.nextDouble() + random.nextInt()) % 5;
//                    }
//                }

            }
//            //swap - less suitable than inversion
//            double[]copy_current = population.get(i);
//            int n_swap = 1;
//            for (int j = 0; j<n_swap; j++) {
//                int p1 = random.nextInt(population.get(i).length);
//                int p2 = random.nextInt(population.get(i).length);
//                population.get(i)[p1] = population.get(i)[p2];
//                population.get(i)[p2] = copy_current[p1];
//            }
//            //inversion - less suitable than v1
//            int point = random.nextInt(population.get(i).length);
//            int point2 = random.nextInt((population.get(i).length - (point))) + (point);
//            double[] a1 = new double[point2 - point + 1];
//            int step = 0;
//            for (int j = point2; j >= point; j--) {
//                a1[step] = population.get(i)[j];
//                step++;
//            }
//            step = 0;
//            for (int j = point; j < point2; j++) {
//                population.get(i)[j] = a1[step];
//                step++;
//            }
//
//            double prob = 0.2;
//            for (int j = 0; j < population.get(i).length; j++) {
//                double p = random.nextDouble();
//                if (p < prob)
//                    population.get(i)[j] = (population.get(i)[j] + random.nextInt(10) - 5) % population.get(i).length;
//
//            }
        }


        return population;

    }
}
