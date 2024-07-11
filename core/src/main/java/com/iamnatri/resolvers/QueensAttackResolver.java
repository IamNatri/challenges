package com.iamnatri.resolvers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The QueensAttackResolver class provides a method to calculate the number of squares a queen can attack on a chessboard.
 * ref https://www.youtube.com/watch?v=glnkdCg_kTQ
 *   https://www.hackerrank.com/challenges/queens-attack-2/forum/comments/276582
 * 
 */
public class QueensAttackResolver {
    
    /**
     * Calculates the number of squares a queen can attack on a chessboard.
     *
     * @param n         The size of the chessboard (n x n).
     * @param k         The number of obstacles on the chessboard.
     * @param r_q       The row position of the queen.
     * @param c_q       The column position of the queen 
     * @param obstacles A list of obstacles represented as (row, column) pairs.
     * @return The number of squares the queen can attack.
     */
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles){
        // TODO: Implement the logic to calculate the number of squares the queen can attack
        // var moves = {'n': n-r_q, 's': r_q-1}
        //implementing the sum

        int counter = 0;
        if (k>0)
            counter = getSquaresBlock(n,r_q, c_q, obstacles, k);
            
        int queenMoves = getQueensMoves(n, r_q, c_q);



        
        
        return queenMoves - counter;
    }
    static int getSquaresBlock(int n,int queenY, int queenX, List<List<Integer>> obstacles, int k){
        Set<String> blockSquare = new HashSet<>(); 
        for(int j = 0; j < k; j++){
            List<Integer> block = obstacles.get(j);
            int blockY = block.get(0);
            int blockX =   block.get(1);
            String relPos =  getObstacleRelativeLocation(queenY, queenX, blockY, blockX);
            

            if (relPos == "U"){
                for (int i = blockY; i<=n; i ++ ){
                    blockSquare.add(String.format("%d,%d", blockX, i));
                }
                continue;
            }
            if (relPos =="D"){
                for (int i = 1; i<= blockY; i ++ ){
                    blockSquare.add(String.format("%d,%d", blockX, i));
                }
                continue;
            }
            if (relPos == "L"){
                for (int i = 1; i<=blockX; i++){
                    blockSquare.add(String.format("%d,%d", i, blockY));
                }
                continue;
            }
            if(relPos == "R"){
                for (int i = blockX; i<=n; i ++ ){
                    blockSquare.add(String.format("%d,%d", i, blockY));
                }
                continue;
            }
            if(relPos == "UR"){
                int dif = blockY - queenY;
                int dif2 = blockX - queenX;
                if (dif == dif2){
                    while(queenY+dif <= n && queenX+dif <= n){
                        blockSquare.add(String.format("%d,%d", queenX+dif, queenY+dif));
                        dif++;
                    }
                }
                continue;
            }
            if(relPos == "UL"){
                int dif = blockY - queenY;
                int dif2 = queenX - blockX;
                if (dif == dif2){
                    while (queenY+dif <= n && queenX-dif >= 1){
                        blockSquare.add(String.format("%d,%d", queenX-dif, queenY+dif));
                        dif++;
                    }
                }
                continue;
            }
            if(relPos == "DR"){
                int dif = queenY - blockY;
                int dif2 = blockX - queenX;
                if (dif == dif2){
                    while(queenY-dif >= 1 && queenX+dif <= n){
                        blockSquare.add(String.format("%d,%d", queenX+dif, queenY-dif));
                        dif++;
                    }
                }
                continue;
            }
            if(relPos == "DL"){
                int dif = queenY - blockY;
                int dif2 = queenX - blockX;
                if (dif == dif2){
                    while(queenY-dif >= 1 && queenX-dif >= 1){
                        blockSquare.add(String.format("%d,%d", queenX-dif, queenY-dif));
                        dif++;
                    }
                }
                continue;

            }
        }
        return blockSquare.size();       

    }



    /**
     * ref  https://math.stackexchange.com/questions/3143269/chess-how-to-count-all-legal-moves-on-diagonals-for-a-queen-placed-in-x-y#comment6475333_3143284
     * @param n                 The size of the board (n x n)
     * @param rowQueenPos       y position of the queen       
     * @param columnQueenPos    x position of thw queen 
     * @return int all square count of the queen
     */
    static int getQueensMoves(int n, int rowQueenPos, int columnQueenPos){
        int orthogonal = n*2 - 2;
        //2N−2−|x−y|−|x+y−N−1|.
        int diagonal = 2*n - 2 - Math.abs(columnQueenPos - rowQueenPos) - Math.abs(columnQueenPos + rowQueenPos - n -1);    
        return orthogonal + diagonal;
    }

    /**
     * @param queenY
     * @param queenX
     * @param blockY
     * @param blockX
     * @return the block relative position to the 
     * Queen U for up, D for down, L for left, R for right, UL for upper left, DL for down left etc
     * 
     */
    static String getObstacleRelativeLocation( int queenY, int queenX,int blockY, int blockX){
        /*
         * 
         * Returns 
         * U for up, D for down, L for left, R for right, UL for upper left, DL for down left  
         */

        if (queenX > blockX && queenY > blockY){
            return "DL"; 
        }
        if (queenX < blockX && queenY > blockY){
            return "DR"; 
        }
        if (queenX == blockX && queenY > blockY){
            return "D"; 
        }
        if (queenX > blockX && queenY < blockY){
            return "UL"; 
        }
        if (queenX < blockX && queenY < blockY){
            return "UR"; 
        }
        if (queenX == blockX && queenY < blockY){
            return "U"; 
        }
        if (queenX > blockX && queenY == blockY){
            return "L"; 
        }
        if (queenX < blockX && queenY == blockY){
            return "R"; 
        }

        return null;


    }


}
