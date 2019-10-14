/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

        Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

        Any live cell with fewer than two live neighbors dies, as if caused by under-population.
        Any live cell with two or three live neighbors lives on to the next generation.
        Any live cell with more than three live neighbors dies, as if by over-population..
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

        Example:

            Input:
            [
            [0,1,0],
            [0,0,1],
            [1,1,1],
            [0,0,0]
            ]
            Output:
            [
            [0,0,0],
            [1,0,1],
            [0,1,1],
            [0,1,0]
            ]
        Follow up:

        Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
        In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

public class GameOfLife {

    /*
    die -> live  : 10
    die -> die   : 00
    live -> live : 11
    live -> die  : 01
    */


    public void gameOfLife(int[][] board) {

        for(int i = 0; i < board.length; i++){

            for(int j = 0; j < board[i]. length; j++){

                int neighbors = countNeighbors(board, i, j);

                if(board[i][j] == 1){


                    if(neighbors < 2){
                        //die
                        board[i][j] = 0b01;
                    }
                    else if(neighbors == 2 || neighbors == 3){
                        //live
                        board[i][j] = 0b11;
                    }

                    else if(neighbors > 3){
                        //die
                        board[i][j] = 0b01;
                    }


                }else{
                    if(neighbors == 3){
                        board[i][j] = 0b10;

                    }else{
                        board[i][j] = 0b00;
                    }
                }

            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = (board[i][j] >> 1);
            }
        }

    }


    public int countNeighbors(int[][] board, int i, int j){

        int count = 0;
        for(int r = Math.max(i-1, 0) ; r <= Math.min(board.length - 1, i + 1); r++){

            for(int c = Math.max(j-1, 0); c <= Math.min(board[0].length - 1, j + 1); c++){

                if((board[r][c] & 0b01) == 1) {
                    count++;
                }
            }
        }

        if((board[i][j] & 0b01) == 1){
            return count-1;
        }

        return count;
    }


}
