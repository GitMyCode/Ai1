/**
 * Created by MB on 2/25/14.
 */
public class Human extends Player  {

    public Human(Grid grid, int player) {
        super(grid,player);


    }


    public void play(int index){
        grid.setCases(index, this.player);
    }
}
