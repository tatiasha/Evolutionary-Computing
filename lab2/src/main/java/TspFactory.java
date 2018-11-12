
import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import java.util.Collections;
import java.util.Random;

public class TspFactory extends AbstractCandidateFactory<TspSolution> {

    public TspFactory(int N) {
        this.N = N;
    }

    private int N;

    public TspSolution generateRandomCandidate(Random random) {
        TspSolution solution = new TspSolution();
        for(int i = 0; i < this.N; i++)
            solution.city.add(i);
        Collections.shuffle(solution.city);
        return solution;
    }

}

