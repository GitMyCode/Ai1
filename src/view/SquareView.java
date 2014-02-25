package view;

import javax.swing.*;

/**
 * Created by Martin on 2/25/14.
 */
public class SquareView extends JButton {

    int state =0;
    public SquareView(){
        super();
    }

    public void setState(int state){
        if(this.state!= 0){
            this.state =state;
            switch (state){
                case 1: setText("X");
                    break;
                case 2: setText("0");
                    break;
                case 0: setText("");
            }
        }
    }


}
