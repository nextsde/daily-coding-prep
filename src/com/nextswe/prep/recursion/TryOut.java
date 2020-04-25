package com.nextswe.prep.recursion;

import com.nextswe.prep.utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TryOut {
/*
    private static boolean isPalindrome(String val, int p1, int p2){
        if(p1 > p2){
            return true;
        }else if(val.charAt(p1) == val.charAt(p2)){
            return isPalindrome(val,p1+1,p2-1);
        }else{
            return false;
        }
    }
    public static boolean isPalindrome(String val){
        return isPalindrome(val, 0, val.length()-1);
    }
*/
    public static boolean isPalindrome(String val){
        if(val.length()<=1){
            return true;
        }else{
            char first = val.charAt(0);
            char last = val.charAt(val.length()-1);
            if(first == last){
                return isPalindrome(val.substring(1,val.length()-1));
            }else{
                return false;
            }
        }
    }

    public static void printBinary(int n){
        if(n<=1){
            System.out.print(n);
        }else{
            int lastDigit = n%2;
            int otherInt = n/2;
            printBinary(otherInt);
            System.out.print(lastDigit);
        }
    }

    public static void printBinary(int n, String prefix){
        if(n==0){ //how many choices do i have left
            //when i have nothing left to choose only then n will be zero
            //so instead thinking it as n becoming zero or base case bacoming zero
            //we should think the choices left for us to do
            System.out.println(prefix);
        }else{
            printBinary(n-1,prefix+"0");
            printBinary(n-1,prefix+"1");
        }
    }

    public static void numOfCardsHand(int[] cards, int[] chosen, int n){
        if(n==0){
            System.out.println(Arrays.toString(chosen));
        }else{
            for(int i=0;i<52;i++){
                chosen[n-1] = cards[i];
                numOfCardsHand(cards,chosen,n-1);
            }
        }
    }

    public static void crawl(String filename,String indent){
        System.out.println(indent+""+new File(filename).getName());
        if(!new File(filename).isFile()){
            String[] ff = new File(filename).list();
            for(String f: ff){
                crawl(filename+"/"+f," "+indent);
            }
        }
    }
/*
    private static void permute(char[] arr, int choices){
        if (choices == 0) {
            System.out.println(Arrays.toString(arr));
        }else{
            for(int i=arr.length-choices;i<arr.length;i++){
                char tmp = arr[arr.length-choices];
                arr[arr.length-choices] = arr[i];
                arr[i] = tmp;
                permute(arr,choices-1);
                //in here we need un-choose because we are modifying existing array
                //so we need to un-modify the modification by un-choose
                arr[i] = arr[arr.length-choices];
                arr[arr.length-choices] = tmp;
            }
        }
    }

    public static void permute(String name){
        char[] arr = name.toCharArray();
        permute(arr, arr.length);
    }
*/

    public static void permute(String name,String prefix){
        if(name.length()==0){
            System.out.println(prefix);
        }else{
            for(int i=0;i<name.length();i++){
                char ch = name.charAt(i);
                String rest = name.substring(0,i) + name.substring(i+1);
                permute(rest, prefix+ch);
                //why it does not have any un-choose?
                //because we are creating every-time a new string based on our choice
            }
        }
    }

    public static void diceRolls(int dice, List<Integer> prefix,String indent){
        //if there are choices to make:
        System.out.println(indent+Arrays.toString(prefix.toArray()));
        if(dice==0){
            //base case
            System.out.println(Arrays.toString(prefix.toArray()));
        }else{
            //for each value for my choice:
            for(int i=1;i<=6;i++){
                //-choose
                prefix.add(i);
                //int index = prefix.indexOf(i);
                //-search/explore
                diceRolls(dice-1,prefix,indent+"    ");
                //-un-choose
                //since remove takes index we need to be careful
                //we cannot just use prefix.remove(i);
                prefix.remove(prefix.size()-1);
                //prefix.remove(index);
                //prefix.remove(prefix.indexOf(i));

                //idea here is to remove what we have choosen from the list
                //so prefix.remove(prefix.size()-1); remove the last element from the list
                //since we are doing searching in self similar manner other calls will do their own
                //cleanup/unchoosing which will make sure that when control returns back to us
                //we do our own unchoosing or cleanup
                //or we can just remember the index where we added our item in the list
                //and remove that item from the list
                //both will work
            }
        }
    }

    public static void diceRollsSum(int dice, int desiredSum, List<Integer> prefix){
        if(dice==0){
            //base case
//            if(Utils.arraySum(prefix.toArray())==desiredSum){
//            }
            System.out.println(Arrays.toString(prefix.toArray()));
        }else{
            //for each value for my choice:
            for(int i=1;i<=6;i++){
                //-choose
                prefix.add(i);
                //int index = prefix.indexOf(i);
                //-search/explore
                if((desiredSum-i)>=0){
                    diceRollsSum(dice-1,desiredSum-i,prefix);
                }
                //-un-choose
                //since remove takes index we need to be careful
                //we cannot just use prefix.remove(i);
                prefix.remove(prefix.size()-1);
                //prefix.remove(index);
                //prefix.remove(prefix.indexOf(i));

                //idea here is to remove what we have choosen from the list
                //so prefix.remove(prefix.size()-1); remove the last element from the list
                //since we are doing searching in self similar manner other calls will do their own
                //cleanup/unchoosing which will make sure that when control returns back to us
                //we do our own unchoosing or cleanup
                //or we can just remember the index where we added our item in the list
                //and remove that item from the list
                //both will work
            }
        }
    }

    public static void sublistsHelper(List<String> list, List<String> chosen){
        if(list.size()==0){
            System.out.println(Arrays.toString(chosen.toArray()));
        }else{
            // select an element from the set
            // and we will choose what to do with it.
            String item = list.get(0);
            list.remove(0);
            //choose & explore
            {
                //since we have yes/no choice
                //put that element in our chosen list as : yes
                chosen.add(item);
                //explore
                sublistsHelper(list, chosen);
                //remove from our chosen list as : no
                chosen.remove(chosen.size() - 1);
                //explore
                sublistsHelper(list, chosen);
            }
            //un-choose
            list.add(0,item);
        }
    }

    public static void sublists(List<String> list){
        List<String> chosen = new ArrayList<>();
        sublistsHelper(list,chosen);
    }

    public static void solveHelper(Board board, int col){
        if(col>=board.colSize()){
            System.out.println(board.toString());
        }else{
            for(int row=0;row<board.rowSize();row++){
                if(board.isSafe(row,col)){
                    //choose
                    board.place(row,col);
                    //explore
                    solveHelper(board,col+1);
                    //un-choose
                    board.remove(row,col);
                }
            }
        }
    }

    public static void solveQueens(Board board){
        solveHelper(board, 0);
    }

    public static int euclidGCD(int num1, int num2){
        if(num2==0){
            return num1;
        }else{
            int tmp = num1%num2;
            num1 = num2;
            num2 = tmp;
            return euclidGCD(num1,num2);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(euclidGCD(128,60));
//        Board board = new Board(6,8);
//        solveQueens(board);
//        ArrayList<String> places = new ArrayList<>(Arrays.asList(
//                "Jane", "Bob", "Matt","Sara"
//        ));
//        sublists(places);
//        diceRollsSum(3,7,new ArrayList<Integer>());
//        diceRolls(3,new ArrayList<Integer>(),"");
//        permute("MARTY","");
//        int[] cards = new int[52];
//        for(int i=0;i<52;i++){
//            cards[i] = i+1;
//        }
//        int[] chosen = new int[3];
//        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
//        System.setOut(out);
//        numOfCardsHand(cards,chosen,3);
//        printBinary(3,"");
//        crawl(".","");
//        printBinary(42);
//        System.out.println(isPalindrome("madam"));
//        System.out.println(isPalindrome("racecar"));
//        System.out.println(isPalindrome("step on no pets"));
//        System.out.println(isPalindrome("Java"));
//        System.out.println(isPalindrome("rotator"));
//        System.out.println(isPalindrome("notion"));
//        System.out.println(isPalindrome("Q"));
    }
}
