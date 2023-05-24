package driver;

import classes.DisjointSets;

public class Main {
    public static void main(String[] args) {
        DisjointSets sets = new DisjointSets(10);
        sets.union(1, 4);
        sets.union(2, 4);
        sets.union(2, 3);
        sets.union(6, 7);
        sets.union(8, 6);

        System.out.println(sets.find(1) == sets.find(3));
        System.out.println(sets.find(7) == sets.find(8));
        System.out.println(sets.find(1) == sets.find(8));

        System.out.println();

        DisjointSets<String> wordsets = new DisjointSets<>(new String[]{
                "gloaming", "drub", "mogul", "pronk", "wordle"
        });
        wordsets.union("gloaming", "drub");
        wordsets.union("drub", "mogul");
        wordsets.union("wordle", "pronk");

        System.out.println(wordsets.find("gloaming") == wordsets.find("drub"));
        System.out.println(wordsets.find("drub") == wordsets.find("wordle"));
    }
}
