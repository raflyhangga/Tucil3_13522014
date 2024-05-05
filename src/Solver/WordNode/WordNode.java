package Solver.WordNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordNode {
    String word;
    Integer totalCost;
    WordNode previous;

    /**
     * Constructor
     * */
    public WordNode(String word, Integer totalCost, WordNode prev){
        this.word = word;
        this.totalCost = totalCost;
        this.previous = prev;
    }

    public String getWord() {
        return word;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public WordNode getPrevious() {
        return previous;
    }

    /**
     * Fungsi untuk mendapatkan banyak path
     * @return jumlah path
     * */
    public static Integer countPath(WordNode othernode){
        Integer count = 0;
        WordNode current = othernode;
        while(current != null){
            count++;
            current = current.getPrevious();
        }

        return count;
    }

    /**
     * Fungsi untuk mendapatkan alur path
     * @return alur path
     * */
    public static List<String> getPaths(WordNode othernode) {
        ArrayList<String> paths = new ArrayList<>();
        WordNode current = othernode;

        while(current != null){
            paths.add(current.getWord());
            current = current.getPrevious();
        }

        Collections.reverse(paths);
        return paths;
    }
}
