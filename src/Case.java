import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Martin on 2/25/14.
 */
public class Case  {

    int state =0;
    public Case(){
        super();

    }


    public void changeStage(){
        state++;
        state%=3;

    }

    public int getState(){
        return this.state;
    }
    public void setState(int state){
        this.state = state;
    }



}
