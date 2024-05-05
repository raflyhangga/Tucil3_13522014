package Solver;

import Dictionary.Dictionary;
import Solver.WordNode.WordNode;


public class GreedyBest extends Solver {
    /**
     * Constructor
     * */
    public GreedyBest(String start_word, String end_word) throws Exception {
        super(start_word,end_word);
    }

    public GreedyBest(String start_word, String end_word, String filePath) throws Exception {
        super(start_word,end_word,filePath);
    }

    /**
     * Fungsi untuk mendapatkan biaya untuk suatu simpul
     * */
    public Integer getCost(String word){
        return Dictionary.getDistance(word,this.goal_word);
    }

    public void getAdjacentWords(WordNode current_node){
        for(String word : visited_node.keySet()){
            if(!visited_node.get(word) && (Dictionary.getDistance(current_node.getWord(),word) == 1)){
                WordNode temp_node = new WordNode(word,getCost(word),current_node);
                this.queue.add(temp_node);
            }
        }
    }
}
