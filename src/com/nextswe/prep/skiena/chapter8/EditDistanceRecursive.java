package com.nextswe.prep.skiena.chapter8;

public class EditDistanceRecursive {
    //recursive solution with no dp
    //bad solution
    public int edDistRecursive(char[] a, char[] b,int i, int j){
        if (i == 0) return(j);
        if (j == 0) return(i);
        if(a[i-1]==b[j-1]) {
            return edDistRecursive(a,b,i-1,j-1);
        }
        return 1+Math.min(
                edDistRecursive(a,b,i-1,j-1),
                Math.min(
                        edDistRecursive(a,b,i-1,j),
                        edDistRecursive(a,b,i,j-1)));
    }

    //dp solution edit distance
    class Cell{
        int cost;
        int parent;
    }
    Cell[][] cells;
    public int edDistRecursiveDP(char[] a, char[] b){
        cells = new Cell[a.length+1][b.length+1];
        // Base condition when second string
        // is empty then we remove all characters
        for (int i = 0; i <= a.length; i++) {
            cells[0][i] = new Cell();
            cells[0][i].cost = i;
        }

        // is empty then we remove all characters
        for (int i = 0; i <= b.length; i++) {
            cells[i][0] = new Cell();
            cells[i][0].cost = i;
        }
        return edDistRecursiveDP(a,b,a.length,b.length,cells);
    }
    private int edDistRecursiveDP(char[] a, char[] b,int i, int j, Cell[][] cells){
        if (i == 0) return(j);
        if (j == 0) return(i);
        if(a[i-1]==b[j-1]) {
            //same
            if(cells[i-1][j-1]==null){
                cells[i-1][j-1] = new Cell();
                cells[i-1][j-1].cost = edDistRecursiveDP(a,b,i-1,j-1,cells);
            }
            cells[i-1][j-1].parent = MATCH;
            return cells[i-1][j-1].cost;
        }
        if(cells[i-1][j-1]==null){
            cells[i-1][j-1] = new Cell();
            cells[i-1][j-1].cost = edDistRecursiveDP(a,b,i-1,j-1,cells);
            cells[i-1][j-1].parent = MATCH;
        }
        if(cells[i][j-1]==null){
            cells[i][j-1] = new Cell();
            cells[i][j-1].cost = edDistRecursiveDP(a,b,i,j-1,cells);
            cells[i][j-1].parent = INSERT;
        }
        if(cells[i-1][j]==null){
            cells[i-1][j] = new Cell();
            cells[i-1][j].cost = edDistRecursiveDP(a,b,i-1,j,cells);
            cells[i-1][j].parent = DELETE;
        }
        return 1+Math.min(
                cells[i-1][j-1].cost,
                Math.min(cells[i-1][j].cost,
                        cells[i][j-1].cost));
    }

    public static void main(String[] args){
        EditDistanceRecursive editDistanceRecursive = new EditDistanceRecursive();
        char[] s = "benyamdfqcasdqwe".toCharArray();
        char[] t = "ephremadaqeqasds".toCharArray();
        int distance = editDistanceRecursive.edDistRecursiveDP(s,t);
        for(int i=0;i<s.length;i++){
            for(int j=0;j<t.length;j++){
                if(editDistanceRecursive.cells[i][j]!=null) {
                    System.out.print(" "+editDistanceRecursive.cells[i][j].parent +" ");
                }else{
                    System.out.print(" - ");
                }
            }
            System.out.print("\n");
        }
//        int distance = editDistanceRecursive.edDistRecursive(s,t,s.length,t.length);
//        int distance = editDistanceRecursive.string_compare(s,t,s.length-1,t.length-1);
        System.out.println(distance);
    }

    //geekforgeeks
/*    public int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    public int editDist(char[] str1, char[] str2, int m, int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1[m - 1] == str2[n - 1])
            return editDist(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min(editDist(str1, str2, m, n - 1), // Insert
                editDist(str1, str2, m - 1, n), // Remove
                editDist(str1, str2, m - 1, n - 1) // Replace
        );
    }*/

    static final int MATCH   = 0;       /* enumerated type symbol for match */
    static final int INSERT  = 1;       /* enumerated type symbol for insert */
    static final int DELETE  = 2;       /* enumerated type symbol for delete */

    int string_compare(char[] s, char[] t, int i, int j)
    {
        int k;                  /* counter */
        int[] opt = new int[3];             /* cost of the three options */
        int lowest_cost;        /* lowest cost */

        // base case, if i is 0, then we reached start of s and
        // now it's empty, so there would be j * 1 edit distance between s & t
        // think of it if s is initially empty and t is not, how many
        // edits we need to perform on s to be similar to t? answer is where
        // we are at t right now which is j
        if (i == 0) return(j * indel(' '));
        // same reasoning as above but for s instead of t
        if (j == 0) return(i * indel(' '));

        // calculate opt[match] by checking if s[i] = t[j] which = 0 if true or 1 if not
        // then recursively do the same for s[i-1] & t[j-1]
        opt[MATCH] = string_compare(s,t,i-1,j-1) + match(s[i],t[j]);

        //solution given in the book, does not give correct result
//        opt[MATCH] = string_compare(s,t,i-1,j-1) + match(s[i],t[j]);

        // calculate opt[insert] which is how many chars we need to insert
        // in s to make it looks like t, or look at it from the other way,
        // how many chars we need to delete from t to make it similar to s?
        // since we're deleting from t, we decrease j by 1 and leave i (pointer
        // in s) as is + indel(t[j]) which we deleted (always returns 1)
        opt[INSERT] = string_compare(s,t,i,j-1) + indel(t[j]);
        // same reasoning as before but deleting from s or inserting into t
        opt[DELETE] = string_compare(s,t,i-1,j) + indel(s[i]);

        // these lines are just to pick the min of opt[match], opt[insert], and
        // opt[delete]
        lowest_cost = opt[MATCH];
        for (k=INSERT; k<=DELETE; k++)
            if (opt[k] < lowest_cost) lowest_cost = opt[k];

        return( lowest_cost );
    }

    int match(char c, char d)
    {
        if (c == d) {
            return(0);
        }
        else{
            return(1);
        }
    }

    int indel(char c)
    {
        return(1);
    }
}
