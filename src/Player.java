/**
 * Created by Martin on 2/25/14.
 */
public abstract class Player {

    Grid grid;

    public Player(Grid grid){
        this.grid = grid;

    }

    public void play(int index){

        checkLose();

    }



    private int checkLose(){
        int index =0;

        for (int i=0; i< 9; i++){
            if(grid.cases[i] == 0){

                checkHorz(i);

            }
        }
        //return index;
        return index;
    }

    private boolean checkHorz(int index){
        boolean ret = false;
        int t = index%3;
        switch (t){
            case 0:
                    ret = (grid.cases[index+1] == 2 && grid.cases[index +2] == 2);
                break;
            case 1: ret = (grid.cases[index+1] == 2 && grid.cases[index +2] == 2);

        }
        return ret;
    }

    public void algo(){


    }



}
