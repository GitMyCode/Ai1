import view.GridView;

import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.util.Scanner;

/**
 * Created by Martin on 2/25/14.
 */
public class TicTacToe {


    public static void  main(String[] args){

        //System.out.println("sa");
        JFrame frame = new JFrame("Tic tac tow");
        Case[] jButtons;

        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Grid grid = new Grid();
        GridView gridV = new GridView();
        grid.addObserver(gridV);

        frame.add(gridV);


        Human p1 = new Human(grid,1);
        Ai p2 = new Ai(grid,2);
        Game game = new Game(grid,gridV,p1,p2);
        gridV.addAction(game);



        frame.setVisible(true);

     /*   Console console = System.console();
        String input  = console.readLine("0 -- le Ai commence\n1 le joueur commence");
        int ordre = Integer.parseInt(input);*/
/*
        Scanner reader = new Scanner(System.in);
        System.out.println("0 -- le Ai commence\\n1 le joueur commence");
        int ordre = reader.nextInt();
*/
        Noeud arbre = new Noeud(1, grid );
       getPos(arbre, grid, 1);
    /*    for(int i =0; i<9 ;i++){
           arbre.fils[i].grid.show();

        }*/
    }

    public static void getPos(Noeud racine, Grid grid, int joueur){
        joueur = joueur==1 ? 2 : 1;
        for(int i =0; i< grid.cases.length ; i++){
            if (grid.cases[i] == 0){
                Grid newGrid = new Grid(grid);
                newGrid.cases[i] = joueur;

                racine.fils[i] = new Noeud(i, newGrid);
                getPos(racine.fils[i], newGrid, joueur);

            }
        }

    }





}
