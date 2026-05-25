import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main{
    public static void main(String args[]) throws FileNotFoundException{
        System.out.println("HANGMAN-guess word, 6 turns");

        File f = new File("C:/Users/RD/Documents/hangman/word.txt");
        Scanner reader = new Scanner(f);

        String word = reader.nextLine();

        reader.close();
        
        Scanner sc = new Scanner(System.in);

        String guess;

        int l = word.length();

        for(int i = 1; i <= 6; i++){
            System.out.println("Enter guess below:-");
            guess = sc.nextLine();
            try{
                if(guess.equals(word)){
                    System.out.println("correct, you win");
                    break;
                }else{
                    for(int j = 0; j < l; j++){
                        if(word.charAt(j) == guess.charAt(j)){
                            System.out.print(guess.charAt(j));
                        }else{
                            System.out.print("_");
                        }
                    }
                    System.out.println(" ");
                    System.out.println("wrong, "+(6-i)+" turns left.");
                    if((6-i) == 0){
                        System.out.println("you lose");
                    }
                }
            }catch(StringIndexOutOfBoundsException e){
                System.out.println("invalid length");
                i--;
                
            }
        }
        sc.close();
    }
}