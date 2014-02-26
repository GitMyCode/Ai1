import view.GridView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Martin on 2/25/14.
 */
public class Game implements ActionListener{


    Grid grid;
    GridView gridV;

    Human human;
    Ai ai;

    public Game(Grid grid, GridView gridV,Human p1,Ai p2){

        this.grid = grid;
        this.gridV= gridV;
        human = p1;
        ai = p2;

        human.turn = true;
        ai.turn = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i =0; i<9 ; i++){
            if(gridV.cases[i] == e.getSource()){

                if (grid.checkValid(i)){
                    System.out.println(i);
                   // Player current = getCurrentPlayer();
                    human.play(i);
                    ai.play(i);
                   // switchTrun();
                }
            }
        }
    }


    private Player getCurrentPlayer(){
        return (ai.turn)? ai: human;
    }
    private void switchTrun(){
        ai.turn = !ai.turn;
        human.turn = !human.turn;
    }

/*

    public void Game(Player p1, Player p2){

        launch

    }*/
}
