import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList children = new ArrayList();
        int point = random.nextInt(p1.length);
        // your implementation:
        double[] a1 = new double[p1.length];
        double[] a2 = new double[p1.length];
        double prob = 0.6;


        for(int q= 0; q<p1.length; q++) {

            //uniform
            double p = random.nextDouble();
            if(p<prob){
                a1[q] = p1[q];
                a2[q] = p2[q];
            }
            else{
                a1[q] = p2[q];
                a2[q] = p1[q];
            }
            //one-point
//            if(q<point){
//                a1[q] = p1[q];
//                a2[q] = p2[q];
//            }
//            else{
//                a1[q] = p2[q];
//                a2[q] = p1[q];
//            }
            //two-point
//            int point2 = random.nextInt(p1.length - point) + 1 + point;
//            if (q < point || q > point2){
//                a1[q] = p1[q];
//                a2[q] = p2[q];
//            }
//            else {
//                a1[q] = p2[q];
//                a2[q] = p1[q];
//            }

        }

        children.add(a1);
        children.add(a2);

        return children;
    }
}
