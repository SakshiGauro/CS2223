package com.doubleTrouble;
import java.util.*;

public class DoubleTrouble {

    /**
     * Bonus points
         * Prof. Charles Bouton Harvard developed a complete theory of the game in 1901. The game is said to have originated in China.
     */
    Board board = new Board(3, 7,5);

    Scanner in = new Scanner(System.in);
    int HColor;   //Human Color
    int HNum;  //Human Marker
    int CColor; //Comp Color
    int CNum; //Comp NUm
    String player = "";
    String ans = "";

    public static void main(String[] args) {
        DoubleTrouble dt = new DoubleTrouble();
        System.out.println("Do you want to go first (Y/N)");
        dt.ans = dt.in.nextLine();
        while (!dt.winner()){
            dt.thePrint();
        }
        System.out.println(dt.player + " won!!");
    }

    public boolean valid(int colors, int num){
        return num <= findNumMarker(colors) && num > 0;
    }

    public void thePrint(){
        if (ans.toLowerCase().equals("y")) {
            System.out.println("The Board right now");
            System.out.println("Green-> " + board.getGreen() + " Yellow-> " + board.getYellow() + " Orange-> " + board.getOrange());
            player = "User";
            System.out.println("Enter your move: 1 green, 2 yellow, 3 orange");
            HColor = in.nextInt();
            System.out.println("Enter the number of markers");
            HNum = in.nextInt();
            while (!valid(HColor, HNum) || HColor > 3) {
                System.out.println("Enter your move: 1 green, 2 yellow, 3 orange");
                HColor = in.nextInt();
                System.out.println("Enter the number of markers");
                HNum = in.nextInt();
            }
            setBoard(HColor, findNumMarker(HColor) - HNum);
            if (!winner()) {
                player = "Computer";
                compMove();
                System.out.println("Computer's move...");
                //System.out.println("Green-> " + board.getGreen() + " Yellow-> " + board.getYellow() + " Orange-> " +board.getOrange());
                System.out.println("Computer chose: " + findColorMarker(CColor));
                System.out.println("Computer took out: " + CNum);
            }
        }
        else if(ans.toLowerCase().equals("n")){
            System.out.println("The Board right now");
            System.out.println("Green-> " + board.getGreen() + " Yellow-> " + board.getYellow() + " Orange-> " + board.getOrange());
                player = "Computer";
                compMove();
                System.out.println("Computer's move...");
                System.out.println("Computer chose: " + findColorMarker(CColor));
                System.out.println("Computer took out: " + CNum);
                System.out.println("The Board right now");
                System.out.println("Green-> " + board.getGreen() + " Yellow-> " + board.getYellow() + " Orange-> " + board.getOrange());

            if (!winner()) {
                player = "User";
                System.out.println("Enter your move: 1 green, 2 yellow, 3 orange");
                HColor = in.nextInt();
                System.out.println("Enter the number of markers");
                HNum = in.nextInt();
                while (!valid(HColor, HNum) || HColor > 3) {
                    System.out.println("Enter your move: 1 green, 2 yellow, 3 orange");
                    HColor = in.nextInt();
                    System.out.println("Enter the number of markers");
                    HNum = in.nextInt();
                }
                setBoard(HColor, findNumMarker(HColor) - HNum);
            }
            }
        }

    //setter methods
    public void setBoard(int colorNum, int markerNum){
        if (colorNum == 1)
            board.setGreen(markerNum);
        else if (colorNum == 2)
            board.setYellow(markerNum);
        else
            board.setOrange(markerNum);
    }

    public int findNumMarker(int color){
        if (color == 1){
            return board.getGreen();
        }
        else if(color == 2){
            return board.getYellow();
        }
        else
            return board.getOrange();
    }

    public String findColorMarker(int color){
        if (color == 1){
            return "Green";
        }
        else if(color == 2){
            return "Yellow";
        }
        else
            return "Orange";
    }

    public boolean winner(){
        return board.getGreen() == 0 && board.getOrange() == 0 && board.getYellow() == 0;
    }

    public void compMove(){
        //AI

        if ((findNumMarker(3) - (findNumMarker(1)^findNumMarker(2))) > 0){
            CNum = findNumMarker(3) - (findNumMarker(1)^findNumMarker(2));
            CColor = 3;
        }
        else if((findNumMarker(2) - (findNumMarker(1)^findNumMarker(3))) > 0){
            CNum = findNumMarker(2) - (findNumMarker(1)^findNumMarker(3));
            CColor = 2;
        }
        else if ((findNumMarker(1) - (findNumMarker(2)^findNumMarker(3))) > 0){
            CNum = findNumMarker(1) - (findNumMarker(2)^findNumMarker(3));
            CColor = 1;
        }
        else{
            Random rand = new Random();
            CColor = rand.nextInt(3) + 1;
            CNum = rand.nextInt(findNumMarker(CColor)-1) +1;
        }
        setBoard(CColor,findNumMarker(CColor) - CNum);
    }
}
