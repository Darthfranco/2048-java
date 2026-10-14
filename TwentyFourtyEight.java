import java.util.Scanner;
import java.util.Random;

public class TwentyFourtyEight {
    
    static String[][] tileValues = new String[4][4];
    static int colLength = 0;
    static String clear = "\u001B[2J";
    static Scanner input = new Scanner(System.in);
    static String direction;
    static boolean move = false;
    static boolean moved = false;
    static boolean loose = false;
    
    
    public static void main (String[] args){
        clear();
        setTiles();
        board();
        while (true){
        ask();
        clear();
        Direction();
        checkMove();
        board();
        checkLoss();
            if (loose){
                break;
            }
        }
    }

    
    public static void title(){
        System.out.println("Welcome to 2048\nU/D/R/L to move");
    }
    public static void setTiles(){
              for (int row = 0;row < tileValues.length;row++){
       for (int col = 0;col < tileValues[row].length;col++)
           tileValues[row][col] = ("*");
      }
        randomTile();
        randomTile();
    }
    public static void clear(){
     System.out.print(clear);   
    }
    public static void board(){
        title();
        align();
            for (int row = 0;row < tileValues.length;row++){
                if(row != 0){
       System.out.println("");
       System.out.println("");
         }
       for (int col = 0;col < tileValues[row].length;col++){
           System.out.print(tileValues[row][col]);
           if(colLength>2){
           space(colLength +2-tileValues[row][col].length());
           }else{
               space(5-tileValues[row][col].length());
           }
       }
        }
            System.out.println("");
    }
    public static void ask (){
                direction = input.next();
        while (!(direction.equalsIgnoreCase("u") ||
         direction.equalsIgnoreCase("d") ||
         direction.equalsIgnoreCase("l") ||
         direction.equalsIgnoreCase("r"))) {
            clear();
            board();
             direction = input.next();
        }
    }
    public static void randomTile(){
        Random row = new Random();
        Random col = new Random();
        Random four = new Random();
        double num1 = row.nextDouble(4);
            int x =(int) (num1);
       double num2 = col.nextDouble(4);
            int y =(int) (num2);
        while (!tileValues[x][y].equals("*")) {
        x = (int) row.nextDouble(4);
        y = (int) col.nextDouble(4);
            }
        double num3 = four.nextDouble();
        if (num3 <.9)
        tileValues[x][y] = "2";
        else
         tileValues[x][y] = "4";
    }
    public static void twice(int row,int col){
        int number = Integer.parseInt(tileValues[row][col]);
    tileValues[row][col] = String.valueOf(number * 2);
    }
    public static void Direction(){
        if (direction.equals("l")) {
         left();
        }
        else if (direction.equals("u")) {
           up();
        }
        else if (direction.equals("r")) {
            right();
        }
        else if (direction.equals("d")) {
         down();
        }
    }
    public static void checkMove(){
         if (moved==true){
        randomTile();
        move = false;
        moved = false;
        }
    }
    public static void checkLoss(){
        boolean fullBoard = true;
        boolean canMove = false;
        for (int row = 0;row < tileValues.length;row++){
       for (int col = 0;col < tileValues[row].length;col++)
           if(tileValues[row][col].equals("*")){
               fullBoard = false;
      }
        }
            if (fullBoard != false){
                fullBoard = true;
            }
       if(fullBoard){
           //check left
                  for (int row = 0;row < tileValues.length;row++){
       for (int col = 0;col < 3;col++)
           if(!tileValues[row][col].equals("*") && tileValues[row][col].equals(tileValues[row][col+1])){
            canMove = true;
           }
          }

          //check right  
                  for (int row = 0;row < tileValues.length;row++){
       for (int col = 3;col >= 1;col--)
           if(!tileValues[row][col].equals("*") && tileValues[row][col].equals(tileValues[row][col-1])){
               canMove = true;
           }
         }

          //check up
                for (int col = 0; col < tileValues.length; col++){
        for (int row = 0; row < 3; row++)
            if (!tileValues[row][col].equals("*") &&
                tileValues[row][col].equals(tileValues[row+1][col])){
                canMove = true;
            }
                }
            //sckeck down
                   for (int col = 0; col < tileValues.length; col++){
        for (int row = 3; row >= 1; row--)
            if (!tileValues[row][col].equals("*") &&
                tileValues[row][col].equals(tileValues[row-1][col])){
                canMove = true;
            
    }
           }
        if(canMove == false){
            loose = true;
        }   
    }   
           
    }     
    public static void moveLeft(){
       for (int row = 0;row < tileValues.length;row++){
           int opencol = 0;
       for (int col = 0;col < tileValues[row].length;col++)
           if(!tileValues[row][col].equals("*")){
               if (col==opencol){
                   opencol++;
                   }
               else{
                   tileValues[row][opencol] = tileValues[row][col];
                   tileValues[row][col] = ("*");
                   opencol++;
                   move = true;
               }
           }
      }
    }
    public static void combineLeft(){
        for (int row = 0;row < tileValues.length;row++){
           int opencol = 0;
       for (int col = 0;col < 3;col++)
           if(!tileValues[row][col].equals("*") && tileValues[row][col].equals(tileValues[row][col+1])){
               twice (row,col);
               tileValues[row][col+1] = ("*");
    }
  }
    }
    public static void left(){
        moveLeft();
        if (move)
            moved=true;
        combineLeft();
        moveLeft();
    }
    public static void moveRight(){
       for (int row = 0;row < tileValues.length;row++){
           int opencol = 3;
       for (int col = 3;col >= 0;col--)
           if(!tileValues[row][col].equals("*")){
               if (col==opencol){
                   opencol--;
                   }
               else{
                   tileValues[row][opencol] = tileValues[row][col];
                   tileValues[row][col] = ("*");
                   opencol--;
                   move = true;
               }
           }
      }
    }
    public static void combineRight(){
        for (int row = 0;row < tileValues.length;row++){
           int opencol = 3;
       for (int col = 3;col >= 1;col--)
           if(!tileValues[row][col].equals("*") && tileValues[row][col].equals(tileValues[row][col-1])){
               twice (row,col);
               tileValues[row][col-1] = ("*");
    }
  }
    }
    public static void right(){
        moveRight();
        if (move)
            moved=true;
        combineRight();
        moveRight();
    }
    public static void moveUp(){
    for (int col = 0; col < tileValues.length; col++){
        int openrow = 0;
        for (int row = 0; row < tileValues[col].length; row++)
            if (!tileValues[row][col].equals("*")){
                if (row == openrow){
                    openrow++;
                }
                else{
                    tileValues[openrow][col] = tileValues[row][col];
                    tileValues[row][col] = ("*");
                    openrow++;
                    move = true;
                }
            }
    }
}
    public static void combineUp(){
    for (int col = 0; col < tileValues.length; col++){
        int openrow = 0;
        for (int row = 0; row < 3; row++)
            if (!tileValues[row][col].equals("*") &&
                tileValues[row][col].equals(tileValues[row+1][col])){
                twice(row, col);
                tileValues[row+1][col] = ("*");
            }
    }
}
    public static void up(){
    moveUp();
    if (move)
    moved=true;
    combineUp();
    moveUp();
}
    public static void moveDown(){
    for (int col = 0; col < tileValues.length; col++){
        int openrow = 3;
        for (int row = 3; row >= 0; row--)
            if (!tileValues[row][col].equals("*")){
                if (row == openrow){
                    openrow--;
                }
                else{
                    tileValues[openrow][col] = tileValues[row][col];
                    tileValues[row][col] = ("*");
                    openrow--;
                    move = true;
                }
            }
    }
}
    public static void combineDown(){
    for (int col = 0; col < tileValues.length; col++){
        int openrow = 3;
        for (int row = 3; row >= 1; row--)
            if (!tileValues[row][col].equals("*") &&
                tileValues[row][col].equals(tileValues[row-1][col])){
                twice(row, col);
                tileValues[row-1][col] = ("*");
            }
    }
}
    public static void down(){
    moveDown();
    if (move)
    moved=true;
    combineDown();
    moveDown();
}
    public static void space(int spaces){
        for (int x = 0; x < spaces; x++){
            System.out.print(" ");
        }
    }
    public static void align(){
       for (int row = 0;row < tileValues.length;row++){
        for (int col = 0;col < tileValues[row].length;col++){
           if (colLength < tileValues[row][col].length()){
               colLength = tileValues[row][col].length();
           }
       }
      }

    }
}
