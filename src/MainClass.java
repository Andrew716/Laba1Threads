import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andrii on 2/24/2015.
 */
public class MainClass {
    public static double sum1 = 0;
    public static double sum2 = 0;
    public static double LEFT_LIMIT = 2;
    public static double RIGHT_LIMIT = 3;
    private static double threadCount =5;
    private static double checkOut;
    public static final double STEP_1 = 0.001;
    public static final double STEP_2 = 0.0001;

    public static double initial(double x){
        double a = Math.pow(Math.pow(x, 2) + 9, 0.5);
        return a + 9/a;
    }

    public static void main(String [] args) throws Exception {
        List<IntegrateThreadClass> threadList = new ArrayList<IntegrateThreadClass>();
        for (int i = 0; i< threadCount; i++){
            threadList.add(new IntegrateThreadClass(LEFT_LIMIT + (RIGHT_LIMIT - LEFT_LIMIT)/threadCount*i,LEFT_LIMIT + (RIGHT_LIMIT -LEFT_LIMIT)/threadCount*(i+1)));
            threadList.get(i).start();
        }
        for (int i = 0; i< threadList.size(); i++){
            threadList.get(i).join();
            sum1 +=threadList.get(i).getLocalSum_1();
            sum2 +=threadList.get(i).getLocalSum_2();
        }
        System.out.println("Results with using threads");
        System.out.println("Result with the step_0.001 =  "+sum1);
        System.out.println("Result with the step_0.0001 =  "+sum2);
        IntegrateThreadClass integrateThrea = new IntegrateThreadClass(2,3);
        double timeWorkWithUsingThreads = (double)System.nanoTime();
        System.out.println("timeWorkWithUsingThreads =  " + timeWorkWithUsingThreads);

        System.out.println();
        System.out.println("Results without using threads");
        NoneThreadIntegrateClass noneThreadIntegrate = new NoneThreadIntegrateClass();
        noneThreadIntegrate.integrateStep_1();
        noneThreadIntegrate.integrateStep_2();
        System.out.println("Result with the step_0.001 =  " + noneThreadIntegrate.getLocalSum_1());
        System.out.println("Result with the step_0.0001 =  " + noneThreadIntegrate.getLocalSum_2());
        double timeWorkWithoutUsingThreads = (double)System.nanoTime();
        System.out.println("timeWorkWithoutUsingThreads =  " + timeWorkWithoutUsingThreads);
        double accelerationFactor = timeWorkWithoutUsingThreads/timeWorkWithUsingThreads;
        System.out.println("Acceleration factor = " + accelerationFactor );
        double efficiencyOfParallelAlgoritm = accelerationFactor/threadCount;
        System.out.println("efficiencyOfParallelAlgoritm =  " + efficiencyOfParallelAlgoritm);

        checkOut = MainClass.initial(RIGHT_LIMIT) - MainClass.initial(LEFT_LIMIT);
        System.out.println("Result of initial =   "+checkOut);
    }
}
