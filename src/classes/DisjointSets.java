package classes;

import structures.Bijection;

import java.util.Arrays;

public class DisjointSets <T>{
    private Bijection<T, Integer> objectsToIndices = new Bijection<>();
    private int[] sets;
    public DisjointSets(T[] objects){
        sets = new int[objects.length];
        for(int i = 0; i< objects.length; i++){
            objectsToIndices.add(objects[i], i);
        }
        Arrays.fill(sets, -1);
    }
    public DisjointSets(int numElements){
        sets = new int[numElements];
        Arrays.fill(sets, -1);
    }
    public T find(T element){
        int index = objectsToIndices.getValue(element);
        int root = find(index);
        return objectsToIndices.getKey(root);
    }

    public int find(int element){
        if(sets[element] < 0){
            return element;
        }
        return sets[element] = find(sets[element]);
    }
    public boolean union(T first, T second){
        int firstIndex = objectsToIndices.getValue(first);
        int secondIndex = objectsToIndices.getValue(second);
        return union(firstIndex, secondIndex);
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
                sets[firstRoot]--;
            }
            return true;
        }
        return false;
    }
}
