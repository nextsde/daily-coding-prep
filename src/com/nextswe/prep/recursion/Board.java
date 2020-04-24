package com.nextswe.prep.recursion;

public class Board {
    private boolean[][] m_board;
    private int rowSize;
    private int colSize;

    public boolean[][] getBoard(){
        return m_board;
    }

    public Board(int size){
        this(size,size);
    }

    public Board(int _rowSize, int _colSize){
        this.rowSize = _rowSize;
        this.colSize = _colSize;
        m_board= new boolean[rowSize][colSize];
    }

    public boolean isSafe(int row, int col){
        //check row (horizontal sweep)
        for(int r=0;r<rowSize;r++){
            if(m_board[r][col]){
                return false;
            }
        }

        //check column (vertical sweep)
        for(int c=0;c<colSize;c++){
            if(m_board[row][c]){
                return false;
            }
        }

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if((i+j == row+col || i-j == row-col) && m_board[i][j]){
                    return false;
                }
            }
        }

//        /* Check upper diagonal on left side */
//        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
//            if (m_board[i][j])
//                return false;
//
//        /* Check lower diagonal on left side */
//        for (int i = row, j = col; j >= 0 && i < rowSize; i++, j--)
//            if (m_board[i][j])
//                return false;

        return true;
    }

    public void place(int row, int col){
        m_board[row][col] = true;
    }

    void remove(int row, int col){
        m_board[row][col] = false;
    }

    public int rowSize() {
        return rowSize;
    }

    public int colSize() {
        return colSize;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(m_board[i][j]){
                    str.append(" Q ");
                }else{
                    str.append(" - ");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }
}
