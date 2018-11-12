
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TspMutation implements EvolutionaryOperator<TspSolution> {
    public List<TspSolution> apply(List<TspSolution> population, Random random) {
        // your implementation:

        int s = population.get(0).city.size();
        int a1 = random.nextInt(s);
        int a2 = random.nextInt(s);

        while(a2 == a1){
            a2 = random.nextInt(s);
        }
        int a = Math.min(a1,a2);
        int b = Math.max(a1, a2);
        double prob = 0.2;
        double prob2 = 0.07;

        for(int i = 0; i < population.size(); i++){
            TspSolution sol = population.get(i);

            if(random.nextDouble()<prob)
            {
                int t1 = random.nextInt(s);
                int t2 = random.nextInt(s);
                int tm = sol.city.get(t1);

                population.get(i).city.set(t1, sol.city.get(t2));
                population.get(i).city.set(t2, tm);
                continue;
            }

            if(random.nextDouble() < prob2) {

                ArrayList<Integer> tmp = new ArrayList();
                for (int j = a; j <= b; j++)
                    tmp.add(sol.city.get(j));
                Collections.shuffle(tmp);
                Integer step_tmp = 0;
                for (int j = a; j <= b; j++) {
                    Integer q = tmp.get(step_tmp);
                    population.get(i).city.set(j, q);
                    step_tmp++;
                }
            }

        }

        return population;
    }
}
