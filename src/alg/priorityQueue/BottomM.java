package alg.priorityQueue;

import java.util.Random;

/**
 * Class that uses MaxPQ to find lots of numbers
 */
public class BottomM {
    private static Random random = new Random();
    public static void main(String[] args)
    {
        MaxPQ<Double> pq = new MaxPQ<>();
        int M = 1000;
        for (long i=0; true;i++){
            double r = random.nextDouble();
            if (pq.size()<M){
                pq.insert(r);
            }
            else if (pq.max()>r){
                double maxMsmallest=pq.delMax();
                pq.insert(r);
                System.out.println("The max of the lowest "+M+" numbers out of "+i+" random numbers is "+maxMsmallest);
            }
        }
    }
}
