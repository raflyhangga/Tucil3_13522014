package Solver;

import Dictionary.Dictionary;
import Solver.WordNode.WordNode;

public class UniformSearch extends Solver {
    /**
     * Constructor
     * */
    public UniformSearch(String start_word,String goal_word) throws Exception {
        super(start_word, goal_word);
    }

    public UniformSearch(String start_word,String goal_word, String filePath) throws Exception {
        super(start_word, goal_word,filePath);
    }
    /**
     * Fungsi untuk mendapatkan biaya untuk suatu simpul
     * */
    public Integer getCost(WordNode otherNode) {
        return otherNode.getTotalCost() + 1;
    }

    public void getAdjacentWords(WordNode current_node){

        for(String word : visited_node.keySet()){
            if(!visited_node.get(word) && (Dictionary.getDistance(current_node.getWord(),word) == 1)){
                WordNode temp_node = new WordNode(word, getCost(current_node), current_node);
                queue.add(temp_node);
            }
        }
    }
}
