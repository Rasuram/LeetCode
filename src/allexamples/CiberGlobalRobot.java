package allexamples;

import java.util.Scanner;

class Robot{
    int currentX;
    int currentY;
    int previousX;
    int previousY;

    Robot(int x, int y){
        this.currentX = x;
        this.currentY = y;
    }

    Robot(){
        this.currentX=0;
        this.currentY=5;
    }

    void moveX(int dx){
        this.previousX = this.currentX;
        this.currentX = this.currentX+dx;
    }

    void  moveY(int dy){
        this.previousY = this.currentY;
        this.currentY=this.currentY+dy;
    }

    void  printCurrentCoordinates(){
        System.out.println(this.currentX+" "+this.currentY);

    }

    void  printLastCoordinates(){
        System.out.println(this.currentX+" "+this.previousY);
    }

    void  printLastMove(){
        Object lastMovex = this.currentX!=this.previousX? "x": this.currentX;
        System.out.println(lastMovex+" "+(this.currentX-this.previousX));
    }

}


/*
 * Create the class allexamples.Robot. Do not use the public access modifier in your class declaration.
 */
public class CiberGlobalRobot {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 4;
        int y = 2;
        int dx = 1;
        int dy = -9;

        Robot firstRobot = new Robot();
        firstRobot.printCurrentCoordinates();

        Robot secondRobot = new Robot(x, y);
        secondRobot.printCurrentCoordinates();

        for (int i = 1; i < 3; i++) {
            secondRobot.moveX(dx);
            secondRobot.printLastMove();
            secondRobot.printCurrentCoordinates();
            secondRobot.moveY(dy);
            secondRobot.printLastCoordinates();

            dx += i * i;
            dy -= i * i;
        }
    }
}
