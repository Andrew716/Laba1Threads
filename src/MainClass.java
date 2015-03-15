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
        System.out.println("Result with the step_0.001 =  "+sum1);
        System.out.println("Result with the step_0.0001 =  "+sum2);
        checkOut = IntegrateThreadClass.initial(RIGHT_LIMIT) - IntegrateThreadClass.initial(LEFT_LIMIT);
        System.out.println("Result of initial =   "+checkOut);
    }
}
