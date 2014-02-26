package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Martin on 2/25/14.
 */
public class GridView extends JPanel implements Observer{

    public SquareView[] cases;


    public GridView(){
        super();
        setLayout(new GridLayout(3,3));
        cases = new SquareView[9];
        for (int i=0; i<9; i++){
            cases[i] = new SquareView();
            add(cases[i]);
        }
    }

    public void addAction(ActionListener game){

        for (int i=0; i<9;i ++){
            cases[i].addActionListener(game);
        }
    }

    private void changeSquare(int index, int player){
        cases[index].setState(player);


    }

    @Override
    public void update(Observable o, Object arg) {
        int[] args = (int[]) arg; // arg[0] = index et arg[1] = state
        cases[args[0]].setState(args[1]);
        System.out.println("ici " +args[1] +"et "+ args[0] );
    }
}
