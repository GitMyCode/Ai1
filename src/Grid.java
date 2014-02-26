import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by Martin on 2/25/14.
 */
public class Grid extends Observable {

    public Integer[] cases;


    public Grid(){

        cases = new Integer[9];
        for (int i=0; i<9; i++){
            cases[i] = 0;
        }
    }
    public Grid(Grid g){
        cases = new Integer[g.cases.length];
        for (int i=0; i<g.cases.length; i++){
            cases[i] = g.cases[i];
        }
    }

    public void setCases(int index,int player){
        cases[index] = player;

        int envoi[] = new int[2];
        envoi[0] = index; envoi[1]= player;
        setChanged();
        notifyObservers( envoi);
    }
    public boolean checkValid(int index){
        return (cases[index] ==0);
    }
    public void show(){
        for (int i =0; i< cases.length; i++){

            System.out.print(cases[i] + " ");
        }
        System.out.println("");
    }

    public static boolean verifierVictoire(Case[] cases) {

        //check ligne

       // if(cases[0].getState() == cases[1].getState() && cases[0].getState() == cases[2].getState() )
/*
               if (cases[0].getState() == cases[1].getState() == cases[2].getState()) {
                 if (cases[0]).getState() return true;
               }
              if (cases[3].getState() == cases[4].getState() == cases[5].getState()) {
                   if (cases[3].getState()) return true;
              }
               if (cases[6].getState() == cases[7].getState() == cases[8].getState()) {
                   if (cases[6].getState()) return true;
               }
               if (cases[0].getState() == cases[3].getState() == cases[6].getState()) {
                   if (cases[0].getState()) return true;
               }
               if (cases[1].getState() == cases[4].getState() == cases[7].getState()) {
                   if (cases[1].getState()) return true;
               }
               if (cases[2].getState() == cases[5].getState() == cases[8].getState()) {
                   if (cases[2].getState()) return true;
               }
               if (cases[0].getState() == cases[4].getState() == cases[8].getState()) {
                   if (cases[0].getState()) return true;
               }
             if (cases[2].getState() == cases[4].getState() == cases[6].getState()) {
                if (cases[2].getState()) return true;
             }*/
            return false;
    }

}
