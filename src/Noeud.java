/**
 * Created by Martin on 2/25/14.
 */
public class Noeud {



    Noeud parent;
    Noeud[] fils;
    Grid grid;
    int coupJouer;

    public Noeud(int coupJouer, Grid grid){
        this.grid = grid;
        this.coupJouer = coupJouer;
        fils = new Noeud[10];
    }
}
