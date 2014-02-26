/**
 * Created by Martin on 2/25/14.
 */
public abstract class Player {

    Grid grid;
    int player;
    boolean turn =false;
    public Player(Grid grid,int player){
        this.grid = grid;
        this.player = player;


    }

    public void play(int index){



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



}
