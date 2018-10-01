package edu.kennesaw.aa;

import java.util.ArrayList;
import java.util.List;

/*
Adapted from https://github.com/mraediaz/Knapsack/blob/master/Knapsack.java
 */
public class KnapSack {

    private List<ValueAndWeight> valueAndWeights;
    private int[][] table;
    private List<ValueAndWeight> selectedOnes;

    /*
     Complete these methods. You are free to add more variable as required in the class. But keep the method signature as it is.
     */
    private int maxWeight =0;
    private int maxValue=0;
    public KnapSack(List<ValueAndWeight> valueAndWeights, int maxWeight ) {

        this.valueAndWeights = valueAndWeights;
        this.maxWeight = maxWeight;
        executeKnapsack();
    }
    public void executeKnapsack() {
        //checking preconditions
        assert (valueAndWeights.size() > 0);
        for(ValueAndWeight v: valueAndWeights){
            assert (v.getValue() >0);
            assert (v.getWeight() >0);
        }


        int  numItems = valueAndWeights.size();
        int capacity = maxWeight;
        table = new int[numItems + 1][capacity + 1];
        boolean[][] knapsack = new boolean[numItems + 1][capacity + 1];

        //Build table k[][] in bottom up manner
        for (int i = 1; i <= numItems; i++) {
            for (int w = 1; w <= capacity; w++) {
                //don't take the item
                int f1 = table[i - 1][w];

                //take it
                int f2 = Integer.MIN_VALUE;
                if (i < numItems && valueAndWeights.get(i).getWeight() <= w) {
                    f2 = valueAndWeights.get(i).getValue() + table[i - 1][w - valueAndWeights.get(i).getWeight()];
                }
                //select the better of two options
                table[i][w] = Math.max(f1, f2);
                knapsack[i][w] = (f2 > f1);

            }
        }


        //determine which items to take
        boolean[] take = new boolean[numItems + 1];
        selectedOnes = new ArrayList<ValueAndWeight>();
        for (int n = numItems, w = maxWeight; n > 0; n--) {
            if (knapsack[n][w]) {
                take[n] = true;
                selectedOnes.add(valueAndWeights.get(n));
                w = w- valueAndWeights.get(n).getWeight();
            } else
                take[n] = false;
        }


        for(ValueAndWeight each:selectedOnes){
            maxValue = maxValue +each.getValue();
        }



    }




    public List<ValueAndWeight> getOptimalItems() {
        return selectedOnes;
    }

    public Integer getMaximumValue(){
        return maxValue;
    }

    //Order is (i,w)
    public int[][] getTable() {
        return table;
    }
}
