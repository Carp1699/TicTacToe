package org.example;
import java.util.Scanner;


public class Main {
    public static char whoWins(char[][] papoi){
        int count = 0;
        boolean right=false;
        boolean up = false;
        boolean down = false;
        boolean left = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                char current = papoi[i][j];
                //Chcar derecha
                while (true){
                    try{
                        if(current==papoi[i][j+2] && current==papoi[i][j+1])return current;
                        else break;
                    }
                    catch (Exception e){break;}
                }
                //Chcar izquierda
                while (true){
                    try{
                        if(current==papoi[i][j-2] && current==papoi[i][j-1])return current;
                        else break;
                    }
                    catch (Exception e){break;}
                }
                //Chcar up
                while (true){
                    try{
                        if(current==papoi[i-2][j] && current==papoi[i-1][j])return current;
                        else break;
                    }
                    catch (Exception e){break;}
                }
                //Checar down
                while (true){
                    try{
                        if(current==papoi[i+2][j] && current==papoi[i+1][j])return current;
                        else break;
                    }
                    catch (Exception e){break;}
                }
                //Checar diagonal
                while (true){
                    try{
                        ///
                        if(current==papoi[i+1][j-1] && current==papoi[i-1][j+1])return  current;
                        if(current==papoi[i-1][j-1] && current==papoi[i+1][j+1])return  current;

                        else break;
                    }
                    catch (Exception e){break;}
                }
            }
        }
        return'E';
    }
    public static char[][] keep (String s,char[][] ArrayChar2D){
        boolean done = false;
        try{

            int Xs = 0;
            int Os = 0;
            int Spaces =0;
            for (char[] u: ArrayChar2D ) {
                for (char c : u) {
                    if (c == 'X') Xs++;
                    if (c == 'O') Os++;
                    if (c == ' ') Spaces++;
                }
            }
            int x = Integer.parseInt(String.valueOf(s.charAt(0)));
            int y = Integer.parseInt(String.valueOf(s.charAt(2)));
            x-=1;
            y-=1;
            char turno = ' ';
            if(Xs>Os)turno='O';
            else turno='X';
            if (ArrayChar2D[x][y] ==' ') {
                ArrayChar2D[x][y] = turno;
                System.out.println("---------");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (j==0) System.out.print("| ");
                        System.out  .print(ArrayChar2D[i][j]+ " ");
                        if (j==2) System.out.println("|");

                    }
                }
                System.out.println("---------");
            }
            else System.out.println("This cell is occupied! Choose another one!");


        }

        catch (NumberFormatException e){
            System.out.println("You should enter numbers!");
        }
        catch (ArrayIndexOutOfBoundsException e){ System.out.println("Coordinates should be from 1 to 3!");}
        catch (Exception e){
            System.out.println("Write correct coordinates");
        }
        return ArrayChar2D;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        char[][] ArrayChar2D = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j==0) System.out.print("| ");
                System.out  .print(ArrayChar2D[i][j]+ " ");
                if (j==2) System.out.println("|");

            }
        }
        System.out.println("---------");
        while (true)
        {
            int blankSpaces = 0;
            String s=" ";
            s=in.nextLine();
            char winner = whoWins(keep(s,ArrayChar2D));
            for (char[] u: ArrayChar2D ) {
                for (char c : u) {
                    if (c == ' ')blankSpaces++;
                }
            }
            if (winner=='X') {System.out.println("X wins");break;}
            if (winner=='O') {System.out.println("O wins");break;}
            if(blankSpaces==0){System.out.println("Draw");break;}
        }

    }
}