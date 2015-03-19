/**
 * Created by Andrii on 3/12/2015.
 */
public class IntegrateThreadClass extends Thread {

    private double LEFT_LIMIT;
    private double RIGHT_LIMIT;
    private double localSum_1;
    private double localSum_2;


    public double function(double x ){

        return Math.pow(x,3)/Math.pow( Math.pow(x,2)+9,3/2);
    }

        public double getLocalSum_2() {
        return localSum_2;
    }

    public double getLocalSum_1() {
        return localSum_1;
    }

    public IntegrateThreadClass(double LEFT_LIMIT, double RIGHT_LIMIT) {
        this.LEFT_LIMIT = LEFT_LIMIT;
        this.RIGHT_LIMIT = RIGHT_LIMIT;
    }

    @Override
    public void run(){
        for (double i = LEFT_LIMIT; i <= RIGHT_LIMIT; i += MainClass.STEP_1){
            localSum_1 += function(i)*MainClass.STEP_1;

        }
        for (double i = LEFT_LIMIT; i <= RIGHT_LIMIT; i += MainClass.STEP_2){
            localSum_2 += function(i)*MainClass.STEP_2;
        }
    }
}
