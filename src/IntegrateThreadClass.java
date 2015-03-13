/**
 * Created by Andrii on 3/12/2015.
 */
public class IntegrateThreadClass extends Thread {

    private double LEFT_LIMIT;
    private double RIGHT_LIMIT;
    public double localSum_1;
    public double localSum_2;
    public static final double STEP_1 = 0.001;
    public static final double STEP_2 = 0.0001;




    public double function(double x ){

        return Math.pow(x,3)/Math.pow( Math.pow(x,2)+9,3/2);
}

    public static double initial(double x){

        return Math.pow(Math.pow(x,2)+9,1/2)+ 9/Math.pow(Math.pow(x,2)+9,1/2);
    }

    public IntegrateThreadClass(double LEFT_LIMIT, double RIGHT_LIMIT) {
        this.LEFT_LIMIT = LEFT_LIMIT;
        this.RIGHT_LIMIT = RIGHT_LIMIT;
    }


    @Override
    public void run(){


        for (double i = LEFT_LIMIT; i<RIGHT_LIMIT; i+=STEP_1){

            localSum_1 += function(i)*STEP_1;
        }

        for (double i = LEFT_LIMIT; i<RIGHT_LIMIT; i+=STEP_2){

            localSum_2 += function(i)*STEP_2;
        }
    }


}