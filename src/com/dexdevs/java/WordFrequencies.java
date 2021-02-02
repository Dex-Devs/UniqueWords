package com.dexdevs.java;

import edu.duke.FileResource;
import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
        
    }
    
    // method to collect unique words
    private void findUnique() {
        myWords.clear(); // clear the arraylist
        
        // read file
        FileResource fr = new FileResource();
        for(String word : fr.words()){
            int index = myWords.indexOf(word.toLowerCase()); // get index of word thats been transformed to lowercase
            if(index == -1) { // word not existing
                myWords.add(word.toLowerCase());
                myFreqs.add(1);
            }else {
                int freqValue = myFreqs.get(index); // get value at index
                myFreqs.set(index, freqValue+1); // increment value to count
            }
        }
    }
    
    // method to locate the index of the word that has the most number of occurence
    private int findIndexOfMax() {
        int maxIndex = 0;
        int freqSize = myFreqs.size(); // avoiding warnings for looping
        for(int i = 0; i < freqSize ; i++) {
            if(myFreqs.get(i) > myFreqs.get(maxIndex)){
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
    
    public void tester(){
        findUnique();
        int uniqueCount = myWords.size();  // avoiding warnings for looping
        System.out.println("Number of unique words: " + uniqueCount);
        
        for(int i = 0 ; i < uniqueCount ; i++) {
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }
        
        int indexOfMax = findIndexOfMax();
        System.out.println("The word that occurs more often and its count is: " + myWords.get(indexOfMax) + " " + myFreqs.get(indexOfMax));
    }
    
    public static void main(String [] args) {
        new WordFrequencies().tester();
    }
}
