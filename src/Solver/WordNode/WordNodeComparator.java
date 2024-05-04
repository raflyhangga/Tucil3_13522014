package Solver.WordNode;

import java.util.Comparator;

public class WordNodeComparator implements Comparator<WordNode>{
    @Override
    public int compare(WordNode x, WordNode y) {
        return Integer.compare(x.totalCost(),y.totalCost());
    }
}
