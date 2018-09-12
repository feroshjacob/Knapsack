package edu.kennesaw.aa;

import java.util.ArrayList;
import java.util.List;

public class KnapSack {

    private List<ValueAndWeight> valueAndWeights=null;

    /*
     Complete these methods. You are free to add more variable as required in the class. But keep the method signature as it is.
     */
    private int maxWeight =0;
    public KnapSack(List<ValueAndWeight> valueAndWeights, int maxWeight ) {

        this.valueAndWeights = valueAndWeights;
        this.maxWeight = maxWeight;
    }

    public List<ValueAndWeight> getOptimalItems() {
        return new ArrayList<ValueAndWeight>();
    }

    public Integer getMaximumValue(){
        return 90;
    }

    //Order is (i,w)
    public int[][] getTable() {
        return new int[0][0];
    }
}
