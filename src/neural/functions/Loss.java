package neural.functions;

import java.util.ArrayList;

public abstract class Loss {
    /**
     * The simplest loss function out there.
     * Simply calculates the difference between the predicted value and its actual value.
     * @param prediction
     * @param actual
     * @return difference
     */
    public static Double difference         (Double prediction, Double actual) {return (prediction - actual);}

    /**
     * Error is calculated by getting the average of all value's losses.
     * @param prediction
     * @param actual
     * @return mean squared
     */
    public static Double meanSquaredError   (ArrayList<Double> prediction,ArrayList<Double> actual) {
        Double squaredError = 0.0;
        for (int i = 0; i < prediction.size(); i++) {
            squaredError =+ difference(prediction.get(i), actual.get(i));
        }
        return squaredError / actual.size();
    }

    
}
