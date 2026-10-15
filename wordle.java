import java.util.Scanner;
import java.util.Random;

public class wordle {
    static String[] words = {
    "apple", "beach", "brain", "bread", "brick",
    "brush", "chair", "charm", "chest", "clean",
    "clock", "cloud", "coach", "coast", "crane",
    "cream", "dance", "dream", "drink", "drive",
    "earth", "flame", "floor", "flour", "flute",
    "force", "frame", "fresh", "fruit", "ghost",
    "giant", "glass", "glove", "grace", "grape",
    "grass", "green", "guard", "guide", "happy",
    "heart", "honey", "horse", "hotel", "house",
    "juice", "knife", "laugh", "lemon", "light",
    "lunch", "magic", "mango", "metal", "money",
    "month", "mouse", "mouth", "music", "night",
    "ocean", "olive", "onion", "paint", "panel",
    "paper", "party", "peace", "peach", "pearl",
    "phone", "piano", "pilot", "pizza", "place",
    "plane", "plant", "plate", "point", "pound",
    "power", "queen", "quiet", "radio", "rainy",
    "raise", "river", "robot", "rough", "round",
    "royal", "scale", "scene", "score", "sheep",
    "shelf", "shirt", "shore", "skill", "sleep"
};
    static String word = words[new Random().nextInt(words.length)];
    static String clear = "\u001B[2J";
    static int trys = 0;
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int same = 0;
        System.out.println(clear);
        while (same != 5){
        same = 0;
        System.out.println("Choose a word");
        char [] word0 = word.toCharArray();
        char [] word1 = input.next().toLowerCase().toCharArray();
        boolean[] sameB = new boolean [5];
        boolean[] sameishB = new boolean [5];
            
            
        while (word1.length != 5){
        System.out.println(clear+"Choose a word (MUST BE five letters)");
        word1 = input.next().toLowerCase().toCharArray();   
        }
        System.out.println(clear);
            int letter = 0;
            int letter2 = 0;
            int sameish = 0;
       for (int x = 0; x < word1.length; x++){
       for (int y = 0; y < word0.length; y++){
             if (word1[letter]==word0[letter2]){
                 sameish++;
                 sameishB[letter]=true;
             }
                 letter2++;
           }
           letter++;
           letter2=0;
       }
            letter = 0;
        for (int x = 0; x < word1.length; x++){
            if(word1[letter]==word0[letter]){
                same++;
                sameB[letter]=true;
         }  
            letter++;   
        }
            letter=0;
         sameish-=same;
        String yellow = "\u001B[33m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
         for (int x = 0; x < word1.length; x++){ 
             if (sameB[letter]){
             System.out.print(green+word1[letter]+reset);    
             }else if (sameishB[letter]){
             System.out.print(yellow+word1[letter]+reset);
             }else{
              System.out.print(word1[letter]);   
             }
             
            letter++;   
        }
        System.out.println("\n"+same+"/5 are the same");
        System.out.println(sameish+"/5 are in the wrong spot");
            letter = 0;
            trys++;
            }
        System.out.println("You Win! You took "+trys+" trys");
    }

}