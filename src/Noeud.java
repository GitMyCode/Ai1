/**
 * Created by Martin on 2/25/14.
 */
public class Noeud {



    Noeud parent;
    Noeud[] fils;
    Grid grid;
    int coup;

    public Noeud(int coup, Grid grid){
        this.grid = grid;
        this.coup = coup;
        fils = new Noeud[10];

    }
}
