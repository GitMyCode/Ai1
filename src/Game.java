import view.GridView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Martin on 2/25/14.
 */
public class Game implements ActionListener{


    Grid grid;
    GridView gridV;

    public Game(Grid grid, GridView gridV){

        this.grid = grid;
        this.gridV= gridV;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i =0; i<9 ; i++){
            if(gridV.cases[i] == e.getSource()){
                System.out.println(i);
            }
        }
    }

/*

    public void Game(Player p1, Player p2){

        launch

    }*/
}
