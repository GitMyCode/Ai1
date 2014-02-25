package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Martin on 2/25/14.
 */
public class GridView extends JPanel{

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


}
