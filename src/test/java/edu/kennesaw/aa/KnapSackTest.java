package edu.kennesaw.aa;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KnapSackTest  {

    /*
     Please don't modify this class. you are free to add more test cases in a different class as needed.
     */

    @Test
    public void testKnapSack(){


        List<ValueAndWeight> valueAndWeights = new ArrayList<ValueAndWeight>();
        valueAndWeights.add(new ValueAndWeight(10,5));
        valueAndWeights.add(new ValueAndWeight(40,4));
        valueAndWeights.add(new ValueAndWeight(30,6));
        valueAndWeights.add(new ValueAndWeight(50,3));

        KnapSack knapSack = new KnapSack(valueAndWeights,10 );

        Assert.assertEquals(knapSack.getMaximumValue().intValue(),90);
        List<ValueAndWeight> solution = knapSack.getOptimalItems();
        Assert.assertTrue(solution.size()==2);
        Assert.assertTrue(solution.contains(new ValueAndWeight(40,4)));
        Assert.assertTrue(solution.contains(new ValueAndWeight(50,3)));

        int[][] table = knapSack.getTable();
        Assert.assertEquals(table[4][10], 90);
        Assert.assertEquals(table[4][3], 50);




    }
}
