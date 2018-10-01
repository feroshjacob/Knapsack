package edu.kennesaw.aa;

public class ValueAndWeight {
    public int getWeight() {
        return weight;
    }

    public ValueAndWeight(int value,int weight) {
        this.weight = weight;
        this.value = value;
    }

    private int weight;

    public int getValue() {
        return value;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ValueAndWeight){
            ValueAndWeight that = (ValueAndWeight) obj;
           return this.value == that.value && this.weight == that.weight;
        }
        return false;
    }

    private int value;
}
