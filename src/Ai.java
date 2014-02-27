import java.util.ArrayList;
import java.util.List;

/**
 * Created by MB on 2/25/14.
 */
public class Ai extends Player {

    int AI = 2;
    public Ai(Grid grid,int player ) {
        super(grid,player);
    }

    @Override
    public void play(int index) {
        super.play(index);
        System.out.println("--------------------------------------------------");

        int[] jouer = minmax(this.grid,4,2, Integer.MIN_VALUE,Integer.MAX_VALUE);
        grid.setCases(jouer[0],player);
    }


    private int switchPlayer(int player){
        return (player == 1)? 2: 1;
    }

    public int[] minmax(Grid grid1, int depth,int player,int alpha,int beta) {//

       /* int score= (evaluer(grid1));
        if(score != 0 || grid1.isFull())
            return new int[] {0,score } ;

        int bestscore =0;
        List<Integer> nextMove = getPossibleMoves(grid1);
        for(int move : nextMove){
            Grid newGrid = new Grid(grid1);
            newGrid.cases[move] = player;
            int temp= minmax(newGrid,2,player)[1];
            bestscore = (bestscore > temp)? bestscore: temp;
        }

        if(player == AI){


        }
*/
        int score= (evaluer(grid1));
        if(score != 0 || grid1.isFull()){
            System.out.print("-------------" +
                    "\n" + score);
            grid1.show();
            return new int[] {0,score } ;
        }


        List<Integer> nextMove = getPossibleMoves(grid1);
        int bestScore;
        int currentScore;
        int bestMove =0;
        /*if(nextMove.isEmpty() || depth == 0){
            bestScore = evaluer(grid1);
            return  new int[] {bestMove,bestScore};
        }*/
           for(int move : nextMove){
                Grid newGrid = new Grid(grid1);
                newGrid.cases[move] = player;
                if(player == 2){
                    currentScore = minmax(newGrid,depth-1,1, alpha,beta)[1];
                    if(currentScore > alpha){
                        alpha = currentScore;
                        bestMove = move;
                        System.out.println("                      AI:"+ move);
                    }
                }else {
                    currentScore = minmax(newGrid,depth-1,2,alpha,beta)[1];
                    if(currentScore < beta){
                        beta = currentScore;
                      //  bestMove = move;
                        System.out.println("                      P:"+ move);
                    }

                }
            // reset la case?
           }


        return new int[] {bestMove, ((player == 2)? alpha: beta)};

    }

    private List<Integer> getPossibleMoves(Grid g){
        List<Integer> ret = new ArrayList<Integer>();
        for(int i =0; i< g.cases.length; i++){
            if(g.cases[i]==0){
                ret.add(i);
            }
        }
        return ret;
    }

    private int evaluer(Grid grid2){
        int score =0;

        score =ligneVal(grid2,0,1,2);
        score = (score==0)? ligneVal(grid2,3,4,5):score;
        score = (score==0)? ligneVal(grid2,6,7,8):score;
        score = (score==0)? ligneVal(grid2,0,3,6):score;
        score = (score==0)? ligneVal(grid2,1,4,7):score;
        score = (score==0)? ligneVal(grid2,2,5,8):score;

        score = (score==0)? ligneVal(grid2,0,4,8):score;
        score = (score==0)? ligneVal(grid2,6,4,2):score;

        return score;
    }

    private int ligneVal(Grid g, int col1,int col2,int col3){
        // Ai  joue les 0
        // 1   joue les X

        int score =0;
        //Premiere Case

        if(g.cases[col1] == AI && g.cases[col2] == AI && g.cases[col3] == AI)
            score = 10;

        if(g.cases[col1] == 1 && g.cases[col2] == 1 && g.cases[col3] == 1)
            score = -10;


        /*if(g.cases[col1] == AI){
            score = 1; // [0][][]
        }else if(g.cases[col1] == 1) {
            score = -1;// [X][][]
        }
        //Deuxieme Case
        if(g.cases[col2] == AI){
             switch (score){
                 case 1: score =10; break; // [0][0][]
                 case -1: score= 0; break; // [X][0][]
                 default: score =1; break; // [] [0][]
             }
        }else if(g.cases[col2] == 1){
            switch (score){
                case  -1: score = -10; break; // [X][X][]
                case  1:  score = 0; break;   // [0][X][]
                default: score = -1; break;   // [ ][X][]
            }
        }
        //Troisieme Case
        if(g.cases[col3] == AI){
            switch (score){
                case   1: score = 10; break;    // [0][][0]  || // [][0][0]
                case  10:
                    score = 1000;
                    System.out.println(col3);
                    break;   // [0][0][0]
                case  -1: score =   0; break;   // [X][][0]  || [][X][0]
                case -10: score = 100 ; break;  // [X][X][0]   // je vien de changer ca
                default: score = 1; break;      // [ ][ ][0]
            }
        }else if(g.cases[col3] == 1) {
            switch (score){
                case   -1:  score = -10; break; // [X][][X]
                case  -10:  score = -100; break; // [X][X][X]
                case    1:  score  = 0 ; break; // [0][][X]
                case   10:  score  = -100 ; break; // [0][0][X]
                default: score = -1; break;
            }
        }*/
        return  score;
    }

}
