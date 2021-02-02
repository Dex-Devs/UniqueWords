package org.dexdevs;

import edu.duke.FileResource;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> nameCount;
    
    public CharactersInPlay(){
        characterNames = new ArrayList<>();
        nameCount = new ArrayList<>();
    }
    
    // update 
    private void update(String person) {
        int nameListSize = characterNames.size();
        
        for(int i = 0 ; i < nameListSize ; i++) {
            int index = characterNames.indexOf(person);
            if(index == -1) {
                characterNames.add(person);
                nameCount.add(1);
            }
        }
    }
    
    // read lines with periods
    private void findAllCharacters() {
        characterNames.clear();
        FileResource fr = new FileResource();
        
        for(String line : fr.lines()){
            if(line.contains(".")){
                int periodIndex = line.indexOf(".");
                String extractedText = line.substring(0, periodIndex);
                int index = characterNames.indexOf(extractedText.toUpperCase());
                if(index == -1){
                    characterNames.add(extractedText.toUpperCase());
                    nameCount.add(1);
                }else {
                    int freqValue = nameCount.get(index);
                    nameCount.set(index, freqValue+1);
                }
            }
        }
    }
    
    // filter names -- must have more than 1 counts
    private void characterWithNumParts(int num1, int num2) {
        
        for(int i = 0 ; i < characterNames.size() ; i++) {
            if(nameCount.get(i) >= num1 && nameCount.get(i) <=num2){
                System.out.println(characterNames.get(i) + " " + nameCount.get(i));
            }
        }
    }
    public void tester() {
        findAllCharacters();
        
//        // unfiltered
//        for(int i = 0 ; i < characterNames.size() ; i++) {
//            System.out.println(characterNames.get(i) + " " + nameCount.get(i));
//        }
        
        // filtered
        characterWithNumParts(10, 15);
        
    }
    public static void main(String [] args) {
        new CharactersInPlay().tester();
        
     
        }
}
