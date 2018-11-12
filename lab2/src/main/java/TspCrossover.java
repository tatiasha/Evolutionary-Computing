
import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TspCrossover extends AbstractCrossover<TspSolution> {
    protected TspCrossover() {
        super(1);
    }

    protected List<TspSolution> mate(TspSolution p1, TspSolution p2, int i, Random random) {

        // your implementation:
        //Order crossover
//        int a = 40;//p1.city.size()/100;
//        int b = 100;//p1.city.size()-p1.city.size()/4;
        int s = p1.city.size();

        int a1 = random.nextInt(s-10);
        int a2 = random.nextInt(s-1);

        while(a2 == a1){
            a2 = random.nextInt(s-1);
        }
        int a = Math.min(a1,a2);
        int b = Math.max(a1, a2);


        TspSolution child1 = new TspSolution();
        TspSolution child2 = new TspSolution();
        ArrayList children = new ArrayList();

        for(int q = 0; q < s; q++){
            child1.city.add(-1);
            child2.city.add(-1);
        }
        for(int q = a; q<=b; q++){
            child1.city.set(q, p1.city.get(q));
            child2.city.set(q, p2.city.get(q));
        }

        int writePos = b+1;
        for (int r = 0; r < s; r++){
            int step = (r + b + 1)%s;
            int t = p2.city.get(step);
            if (!child1.city.contains(t)) {
                child1.city.set(writePos, t);
                writePos = (writePos+1)%s;
            }
        }
        writePos = b+1;
        for (int r = 0; r < s; r++){
            int step = (r + b + 1)%s;
            int t = p1.city.get(step);
            if (!child2.city.contains(t)) {
                child2.city.set(writePos, t);
                writePos = (writePos+1)%s;
            }
        }


        children.add(child1);
        children.add(child2);


        return children;
    }
}
