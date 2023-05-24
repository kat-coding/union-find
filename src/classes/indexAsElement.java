package classes;

import java.util.Arrays;

public class indexAsElement {
    private int[] sets;

    public indexAsElement(int numElements){
        if(numElements <= 0){
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        sets = new int[numElements];
        Arrays.fill(sets, -1);
    }
    public int find(int element){
        if(sets[element] < 0){
            return element;
        }
        return sets[element] = find(sets[element]);
    }
    public boolean union(int first, int second){
        int firstRoot = find(first);
        int secondRoot = find(second);

        if(firstRoot != secondRoot){
            if(sets[firstRoot] < sets[secondRoot]){
                sets[secondRoot] = firstRoot;
            }
            else if(sets[secondRoot] < sets[firstRoot]){
                sets[firstRoot] = secondRoot;
            }
            else if(sets[firstRoot] == sets[secondRoot]) {
                sets[secondRoot] = firstRoot;
                //update height of root
                sets[firstRoot]--;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "indexAsElement{" +
                "sets=" + Arrays.toString(sets) +
                '}';
    }
}
