package Solver;

import Dictionary.Dictionary;
import Solver.WordNode.WordNode;
import Solver.WordNode.WordNodeComparator;
import Exception.*;

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

    // Constructor
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

        // Inisialisasi Queue
        queue = new PriorityQueue<>(new WordNodeComparator());
        queue.add(new WordNode(this.start_word,0,new ArrayList<>()));
    }

    public Solver(String start_word,String goal_word,String filePath) throws Exception {
        if(start_word.length() != goal_word.length()){
            throw new Exception("Start word length does not match Goal Word length");
        }
        Dictionary dictionary = new Dictionary(goal_word.length(),filePath);

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

        // Inisialisasi Queue
        queue = new PriorityQueue<>(new WordNodeComparator());
        queue.add(new WordNode(this.start_word,0,new ArrayList<>()));
    }

    /**
     * Method untuk Ekspansi,
     * Ekspansi bersifat asbtrak agar setiap algoritma dapat menyesuaikan
     * */
    public abstract void getAdjacentWords(WordNode current_node);

    /**
     * Fungsi untuk mendapatkan path baru hasil ekspansi suatu simpul
     * */
    public List<String> getNewPath(WordNode current_node) {
        List<String> new_path;
        new_path = new ArrayList<>(current_node.getPaths());
        new_path.add(current_node.getWord());
        return new_path;
    }

    /**
     * Fungsi untuk mengembalikan jumlah simpul yang dikunjungi
     * */
    public Integer getNodeAmount() {
        return this.node_amount;
    }

    /**
     * Fungsi untuk melakukan implementasi algoritma
     * */
    public WordNode solve() throws Exception {
        System.out.println("Solving " + this.goal_word + " from " + this.start_word +"....");
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
        throw new SolutionNotFoundException();
    }
}
