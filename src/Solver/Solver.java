package Solver;

import Dictionary.Dictionary;
import Solver.WordNode.WordNode;
import Solver.WordNode.WordNodeComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public abstract class Solver {
    Integer node_amount;
    String goal_word;
    String start_word;
    PriorityQueue<WordNode> queue;
    final Map<String,Boolean> visited_node;

    public Solver(String start_word,String goal_word) throws Exception {
        if(start_word.length() != goal_word.length()){
            throw new Exception("Start word length does not match Goal Word length");
        }
        Dictionary dictionary = new Dictionary(goal_word.length());

        visited_node =  dictionary.getWords();
        if(!visited_node.containsKey(start_word.toLowerCase())){
            throw new Exception("Your start word doesn't exist");
        }
        if(!visited_node.containsKey(goal_word.toLowerCase())){
            throw new Exception("Your goal words doesn't exist");
        }

        this.goal_word = goal_word.toLowerCase();
        this.start_word = start_word.toLowerCase();
        this.node_amount = 0;
        queue = new PriorityQueue<>(new WordNodeComparator());
    }

    public Integer getCost(List<String> path) {
        return path.size();
    }

    public abstract Integer getCost(String word);

    public abstract void getAdjacentWords(WordNode current_node);

    public List<String> getNewPath(WordNode current_node) {
        List<String> new_path;
        new_path = new ArrayList<>(current_node.getPaths());
        new_path.add(current_node.getWord());
        return new_path;
    }

    public Integer getNodeAmount() {
        return this.node_amount;
    }

    public WordNode solve() throws Exception {
        WordNode initial_node = new WordNode(this.start_word,0,new ArrayList<>());

        getAdjacentWords(initial_node);
        if(initial_node.getWord().equalsIgnoreCase(goal_word)){
            return initial_node;
        }
        visited_node.put(initial_node.getWord().toLowerCase(),true);
        this.node_amount++;

        while(!queue.isEmpty()){
            this.node_amount++;
            WordNode current_node = queue.remove();
            if(current_node.getWord().equalsIgnoreCase(goal_word)){
                return current_node;
            } else {
                visited_node.put(current_node.getWord().toLowerCase(),true);
                getAdjacentWords(current_node);
            }
        }
        throw new Exception("No solution found");
    }


}
