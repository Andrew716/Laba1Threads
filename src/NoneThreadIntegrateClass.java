/**
 * Created by Andrii on 3/18/2015.
 */
public class NoneThreadIntegrateClass {

    private double localSum_1;
    private double localSum_2;

    public double getLocalSum_1() {
        return localSum_1;
    }

    public double getLocalSum_2() {
        return localSum_2;
    }

    public double function(double x ){
        return Math.pow(x,3)/Math.pow( Math.pow(x,2)+9,3/2);
    }

    public void integrateStep_1(){
        for (double i = MainClass.LEFT_LIMIT; i <= MainClass.RIGHT_LIMIT; i += MainClass.STEP_1){
            localSum_1 += function(i)*MainClass.STEP_1;
        }
    }

    public void integrateStep_2(){
        for (double i = MainClass.LEFT_LIMIT; i <= MainClass.RIGHT_LIMIT; i += MainClass.STEP_2){
            localSum_2 += function(i)*MainClass.STEP_2;
        }
    }
}
