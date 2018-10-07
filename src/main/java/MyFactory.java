import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import java.util.Random;
public class MyFactory extends AbstractCandidateFactory<double[]> {

    private int dimension;

    public MyFactory(int dimension) {
        this.dimension = dimension;
    }

    public double[] generateRandomCandidate(Random random) {
        double[] solution = new double[dimension];
        // x from -5.0 to 5.0
        for(int i = 0; i<dimension; i++) {
            //solution[i] = random.nextInt(11) - 5;
            solution[i] = -5 + (5 - (-5)) * random.nextDouble();
        }
        // your implementation:

        return solution;
    }
}
