
import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class TspFitnessFunction implements FitnessEvaluator<TspSolution> {

    private int N;
    double[][] matrix_distance;

    public TspFitnessFunction(String problem, int N) {
        this.N = N;
        this.matrix_distance = new double[N+1][N+1];
        TspCities[] all_cities = new TspCities[this.N];
        TspCities solution = new TspCities();
        int counter = -1;
        int step = 0;
        String filepath = "D:\\Studying\\Evolutionary_computing\\Evolutionary-Computing\\lab2\\data\\"+problem;
        try{
            File file=new File(filepath);
            Scanner scanner = new Scanner(file);
            while (step != this.N) {
                int item = scanner.nextInt();
                switch (counter%3){
                    case 0:
                        all_cities[counter/3-1] = solution;
                        solution = new TspCities();
                        solution.city_idx = item;
                        step ++;
                        break;
                    case 1: solution.city_x = item;
                        break;
                    case 2: solution.city_y = item;
                        break;
                    case -1: solution.city_idx = item;
                        counter = 0;
                        break;
                }
                counter++;
            }
            scanner.close();
        }catch (Exception ex) {
            System.out.println("You should write the correct path to problem file");
            System.out.println("You can find example file with 130 cities in ..\\..\\..\\data");
            ex.printStackTrace();
        }
        for(int i = 0; i < this.N; i++)
            for(int j = i; j < this.N; j++){
                int Xx = (all_cities[i].city_x-all_cities[j].city_x)*(all_cities[i].city_x-all_cities[j].city_x);
                int Yy =  (all_cities[i].city_y-all_cities[j].city_y)*(all_cities[i].city_y-all_cities[j].city_y);
                double dst = Math.sqrt(Xx+Yy);
                this.matrix_distance[i][j] = dst;
                this.matrix_distance[j][i] = dst;
            }


    }

    public double getFitness(TspSolution solution, List<? extends TspSolution> list) {
        double ff = 0;
        for(int i = 0; i< solution.city.size()-1; i++){
            int city1 = solution.city.get(i+1);
            int city2 = solution.city.get(i);
            ff += this.matrix_distance[city1][city2];
        }
        ff += this.matrix_distance[solution.city.get(solution.city.size()-1)][solution.city.get(0)];
        return ff;
    }

    public boolean isNatural() {
        return false;
    }
}
