package support;

import java.util.ArrayList;
import java.util.Collections;

/** 
 * Modified by Daniel Hsing to suit Chap5_2 problem purposes
 */

public class StatCalc {

    private int count;   // Number of numbers that have been entered.
    private double sum;  // The sum of all the items that have been entered.
    private double squareSum;  // The sum of the squares of all the items.
    private ArrayList<Double> list = new ArrayList<Double>();

    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
    	list.add(num);
        count++;
        sum += num;
        squareSum += num*num;
    }
    
    public double getMax() {
    	Collections.sort(list);
    	return list.get(list.size()-1);
    }
    
    public double getMin() {
    	Collections.sort(list);
    	return list.get(0);
    }
    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        return sum / count;  
    }

    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation() {  
        double mean = getMean();
        return Math.sqrt( squareSum/count - mean*mean );
    }

}  // end class StatCalc