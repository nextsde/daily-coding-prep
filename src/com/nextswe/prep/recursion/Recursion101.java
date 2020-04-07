package com.nextswe.prep.recursion;

import com.nextswe.prep.utils.Utils;

import java.util.Stack;
/*
//based on
Think Like a Programmer
An Introduction to Creative Problem Solving
by V. Anton Spraul
https://nostarch.com/thinklikeaprogrammer
https://nostarch.com/download/samples/TLAP_ch6.pdf
 */
public class Recursion101 {
    int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    //tail recursion
    //in this approach every station will know the total amount
    int signalNextStationForParrotCountingTailRecursion(int[] stations, int index, int total){
        if(index==stations.length){
            return total;
        }
        //process the data
        int myStationParrotCount = stations[index];
        //calculate the running sum to pass with the recursive call
        total = total + myStationParrotCount;
        //after processing the data call recursion
        return signalNextStationForParrotCountingTailRecursion(stations, index+1,total);
    }

    //head recursion
    //in this approach only the first station will know the total amount
    int parrotCountingUsingHeadRecursion(int[] stations, int index){
        if(index==stations.length-1){
            return stations[index];
        }
        //do recursive call first
        int getNextStationTotal = parrotCountingUsingHeadRecursion(stations,index+1);;
        //process the data later
        int currentStationParrotCount = stations[index];
        //return running sum to the calling function
        return currentStationParrotCount + getNextStationTotal;
    }

    //tail recursion example 2
    public int highestRevenueCustomerByTailRecursion(int[] revenues, int customerIndex, int highestRevenueSofar){
        if(customerIndex == revenues.length){
            return highestRevenueSofar;
        }
        //tally the revenue in one customer file
        int currentCustomerRevenue = revenues[customerIndex];
        //compare highest revenue seen so far
        int highestRevenue = Math.max(highestRevenueSofar, currentCustomerRevenue);
        //pass the remaining file to lower subordinate
        //tail recursion since we have processed everything before it and passed the processed data to the next recursive call
        return highestRevenueCustomerByTailRecursion(revenues,customerIndex+1,highestRevenue);
    }

    public int highestRevenueCustomerByHeadRecursion(int[] revenues, int customerIndex){
        if(customerIndex==revenues.length-1){
            return revenues[customerIndex];
        }
        //call next person to give the highest revenue
        int highestRevenue = highestRevenueCustomerByHeadRecursion(revenues,customerIndex+1);
        //process the highest revenue with the current revenue
        int currentRevenue = revenues[customerIndex];
        //return the processed highest revenue to the calling function
        return Math.max(highestRevenue,currentRevenue);
    }

    int iterativeArraySum(int[] integers, int size){
        int sum = 0;
        for(int i=0;i<size;i++){
            sum+=integers[i];
        }
        return sum;
    }

    int arraySumDelete(int[] integers, int size){
        if(size==0) return 0;
        int lastNumber = integers[size-1];
        int allButLastSum = iterativeArraySum(integers,size-1);
        return lastNumber+allButLastSum;
    }

    int arraySumRecursive(int[] integers, int size){
        if(size==0) return 0;
        int lastNumber = integers[size-1];
        int allButLastSum = arraySumRecursive(integers,size-1);
        return lastNumber+allButLastSum;
    }

    //naive programmers recursive solution
    //no difference between iterative and recursive sol
    int arraySumRecursiveExtraParams(int[] integers, int size, int sum, int currentIdex){
        if(currentIdex == size){
            return sum;
        }
        sum+=integers[currentIdex];
        return arraySumRecursiveExtraParams(integers,size,sum, currentIdex+1);
    }

    int zeroCountIterative(int[] numbers, int size){
        int count = 0;
        for(int i=0;i<size;i++){
            if(numbers[i]==0)
                count++;
        }
        return count;
    }

    //mistake programmers make when implementing recursion
    //use of global variable (not good when implementing recursion)
    int count;
    int zeroCountRecursive(int[] numbers, int size){
        if(size==0){return count;}
        if(numbers[size-1]==0)count++;
        return zeroCountRecursive(numbers,size-1);
    }

    //to solve zero count let's use tail recursive technique and BRI
    int zeroCounterDispatcherTail(int[] numbers, int size){
        if(size==0) {
            return 0;
        }
        int count = 0;
        if(numbers[size-1]==0){
            count = count+1;
        }
        //to make it recursive just change this to
//        return count+zeroCountIterative(numbers,size-1);
        //this
        return count+zeroCountIterative(numbers,size-1);
    }

    int zeroCounterDispatcherHead(int[] numbers, int size){
        if(size==0) {
            return 0;
        }
        //to make it recursive just change this to
//        int count = zeroCountIterative(numbers,size-1);
        //this
        int count = zeroCounterDispatcherHead(numbers,size-1);
        if(numbers[size-1]==0){
            count = count+1;
        }
        return count;
    }

    private void printTreeNodes(treeNode treeHead) {
        if(treeHead==null){
            return;
        }
        printTreeNodes(treeHead.left);
        printTreeNodes(treeHead.right);
        Utils.println(treeHead.data);;
    }

    private treeNode insertTreeNodeTail(treeNode currentNode, int i) {
        if(currentNode==null){
            treeNode tmp = new treeNode();
            tmp.data = i;
            return tmp;
        }

        if(i<=currentNode.data) {
            currentNode.left = insertTreeNodeTail(currentNode.left,i);
        }else {
            currentNode.right = insertTreeNodeTail(currentNode.right,i);
        }

        return currentNode;
    }

    private treeNode insertTreeNodeTail2(treeNode currentNode, int i) {
        if(currentNode==null){
            return null;
        }
        if(i<=currentNode.data) {
            currentNode.left = insertTreeNodeTail2(currentNode.left,i);
            if(currentNode.left==null){
                treeNode tmp = new treeNode();
                tmp.data = i;
                currentNode.left = tmp;
            }
        }else {
            currentNode.right = insertTreeNodeTail2(currentNode.right,i);
            if(currentNode.right==null){
                treeNode tmp = new treeNode();
                tmp.data = i;
                currentNode.right = tmp;
            }
        }

        return currentNode;
    }


    private int maxValueFromTree(treeNode treeNode){
        if(treeNode == null) return 0;
        int left = maxValueFromTree(treeNode.left);
        int right = maxValueFromTree(treeNode.right);
        int maxNum = treeNode.data;
        maxNum = Math.max(left,maxNum);
        maxNum = Math.max(right,maxNum);
        return maxNum;
    }

    //to handle negative value in binary tree
    int maxValue(treeNode root) {
        //marged the base case besides recursive call
        int leftMax = root.left!=null?maxValue(root.left):root.data;
        int rightMax = root.right!=null?maxValue(root.right):root.data;
        int maxNum = root.data;
        if (leftMax > maxNum) maxNum = leftMax;
        if (rightMax > maxNum) maxNum = rightMax;
        return maxNum;
    }

    int numLeafNodes(treeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int left = numLeafNodes(root.left);
        int right = numLeafNodes(root.right);
        return left+right;
    }

    int iterativeNumLeafNodes(treeNode root){
        if(root==null){
            return 0;
        }
        int leafCount = 0;
        Stack<treeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            treeNode curr = stack.pop();
            if(curr.left==null && curr.right==null){
                leafCount++;
            }
            else{
                if(curr.left!=null)stack.push(curr.left);
                if(curr.right!=null)stack.push(curr.right);
            }
        }
        return leafCount;
    }

    //head recursion technique
    private int countNegativeFromListNodes(listNode currentNode){
        if(currentNode==null){
            return 0;
        }
        //call recursively to get number of negative numbers from the rest of the list except currentNode
        int count = countNegativeFromListNodes(currentNode.next);
        if(currentNode.data<0){
            count++;
        }
        return count;
    }

    private void printListNodes(listNode head) {
        listNode tmp2 = head;
        while(tmp2!=null){
            Utils.println(tmp2.data);
            tmp2 = tmp2.next;
        }
    }

    private void printListNodesForwardsRecursion(listNode head){
        if(head!=null){
            Utils.println(head.data);
            printListNodesForwardsRecursion(head.next);
        }
    }

    private void printListNodesBackwardsRecursion(listNode head){
        if(head!=null){
            printListNodesBackwardsRecursion(head.next);
            Utils.println(head.data);
        }
    }

    private void displayListForwardsIterative(listNode head){
        for(listNode current = head; current!=null; current=current.next){
            Utils.println(current.data);
        }
    }

    private void displayListBackwardsIterative(listNode head){
        Stack<listNode> stk = new Stack<>();
        for(listNode current = head; current!=null; current=current.next){
            stk.push(current);
        }
        while(!stk.isEmpty()){
            listNode node = stk.pop();
            Utils.println(node.data);
        }
    }

    private listNode insertListNodeTail(listNode head, int i) {
        listNode tmp = new listNode();
        tmp.data = i;
        if(head==null){
            head = tmp;
            return head;
        }
        listNode tmp2 = head;
        while(tmp2.next!=null){
            tmp2 = tmp2.next;
        }
        tmp2.next = tmp;
        return head;
    }

    //6-1
    // Write a function to compute the sum of just the positive numbers in an array of integers.
    // First, solve the problem using iteration.
    // Then, using the technique shown in this chapter, convert your iterative function to a recursive function.
    private int iterativePositiveSum(int[] integers, int size){
        int sum = 0;
        for(int i=0;i<size;i++){
            if(integers[i]>=0){
                sum+=integers[i];
            }
        }
        return sum;
    }

    private int recursivePositiveSumHeadRecursion(int[] integers, int size){
        if(size==0){
            return 0;
        }
        int subSum = recursivePositiveSumHeadRecursion(integers,size-1);
        int runningSum = 0;
        if(integers[size-1]>=0){
            runningSum = subSum + integers[size-1];
        }else{
            runningSum = subSum;
        }
        return runningSum;
    }

    private int recursivePositiveSumTailRecursion(int[] integers, int size){
        if(size==0){
            return 0;
        }
        int runningSum = 0;
        if(integers[size-1]>=0){
            runningSum = integers[size-1];
        }
        return runningSum + recursivePositiveSumTailRecursion(integers,size-1);
    }

    //6-2
    // Consider an array representing a binary string, where every element’s data value is 0 or 1.
    // Write a bool function to determine whether the binary string has odd parity (an odd number of 1 bits).
    // Hint: Remember that the recursive function is going to return true (odd) or false (even), not the count of 1 bits.
    // Solve the problem first using iteration, then recursion.
    private boolean isParityIterative(String boolStr, int size){
        int oneCount = 0;
        for(int i=0;i<size;i++){
            if(boolStr.charAt(i)=='1'){
                oneCount++;
            }
        }
        return oneCount%2==1;
    }

    private boolean isParityIterative(String boolStr){
        return isParityIterative(boolStr,boolStr.length());
    }

    //let's try to do with BRI method
    //first we will create a dispatcher
    private boolean isParityDispatcher(String boolStr, int size){
        if(size==0){
            return false;
        }
        char cc = boolStr.charAt(size-1);
        boolean isPar = isParityIterative(boolStr,size-1);
        return (cc=='1'&&!isPar)||(cc=='0'&&isPar);
    }

    private boolean isParityRecursiveHead(String boolStr, int size){
        if(size==0){
            return false;
        }
        boolean isPar = isParityRecursiveHead(boolStr,size-1);
        char cc = boolStr.charAt(size-1);
        return (cc=='1'&&!isPar)||(cc=='0'&&isPar);
    }

    private boolean isParityRecursiveHead(String boolStr){
        return isParityRecursiveHead(boolStr,boolStr.length());
    }

    private boolean isParityRecursiveTail(String boolStr, int size, boolean tilNow){
        if(size==0){
            return tilNow;
        }
        char cc = boolStr.charAt(size-1);
        return isParityRecursiveTail(boolStr,size-1,(cc=='1'&&!tilNow)||(cc=='0'&&tilNow));
    }

    private boolean isParityRecursiveTail(String boolStr){
        return isParityRecursiveTail(boolStr,boolStr.length(),false);
    }

    // 6-3
    // Write a function that is passed an array of integers and a “target” number and that returns
    // the number of occurrences of the target in the array. Solve the problem first using iteration, then recursion.
    private int numOfOccurenceIterative(int[] integers, int size, int target){
        int count = 0;
        for(int i=0;i<size;i++){
            if(integers[i]==target){
                count++;
            }
        }
        return count;
    }

    private int numOfOccurenceRecursiveHead(int[] integers, int size, int target){
        if(size==0){
            return 0;
        }
        //call recursion for first for head recursion
        int count = numOfOccurenceRecursiveHead(integers, size-1,target);
        //process the data that came from head recursion
        if(integers[size-1]==target){
            count++;
        }
        return count;
    }

    private int numOfOccurenceRecursiveTail(int[] integers, int size, int target, int count){
        if(size==0){
            return count;
        }
        //process the data first
        if(integers[size-1]==target){
            count++;
        }
        //then call recursive for tail recursion
        return numOfOccurenceRecursiveTail(integers, size-1,target,count);
    }

    public static void main(String[] args){
        Recursion101 recursion101 = new Recursion101();
//        Utils.println(recursion101.iterativePositiveSum(new int[]{1,-2,1,2,2},5));
//        Utils.println(recursion101.recursivePositiveSumHeadRecursion(new int[]{1,-2,1,2,2},5));
//        Utils.println(recursion101.recursivePositiveSumTailRecursion(new int[]{1,-2,1,2,2},5));

//        Utils.println(recursion101.isParityRecursiveTail("1111111"));

//        Utils.println(recursion101.numOfOccurenceRecursiveHead(new int[]{1,-2,1,2,2},5,2));
        Utils.println(recursion101.numOfOccurenceRecursiveTail(new int[]{1,-2,1,2,2},5,2,0));

//        Utils.println(recursion101.signalNextStationForParrotCountingTailRecursion(new int[]{7,5,3,10,2},0,0));
//        Utils.println(recursion101.parrotCountingUsingHeadRecursion(new int[]{7,5,3,10,2},0));
//        Utils.println(recursion101.highestRevenueCustomerByHeadRecursion(new int[]{172000,68000,193000,13000,256000,99000},0));
//        Utils.println(recursion101.iterativeArraySum(new int[]{7,5,3,10,2},5));
//        Utils.println(recursion101.zeroCounterDispatcherHead(new int[]{0,1,0,1,0},5));

//        listNode head = null;
//        head = recursion101.insertListNodeTail(head, 11);
//        head = recursion101.insertListNodeTail(head, 12);
//        head = recursion101.insertListNodeTail(head, -21);
//        head = recursion101.insertListNodeTail(head, -2);
//        head = recursion101.insertListNodeTail(head, 34);
//        head = recursion101.insertListNodeTail(head, 2);
//        head = recursion101.insertListNodeTail(head, -9);
//        head = recursion101.insertListNodeTail(head, 19);
//
//        recursion101.printListNodes(head);

//        treeNode treeHead = new treeNode();
//        treeHead.data = 25;
//        treeHead = recursion101.insertTreeNodeTail(treeHead, 11);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, 12);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -21);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -2);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, 34);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, 2);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -9);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, 19);

//        treeHead.data = -25;
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -11);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -12);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -21);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -2);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -34);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -2);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -9);
//        treeHead = recursion101.insertTreeNodeTail(treeHead, -19);

//        recursion101.printTreeNodes(treeHead);
//        Utils.println(recursion101.numLeafNodes(treeHead));
    }
}

//Recursion and Linked Lists
class listNode{
    int data;
    listNode next;
}

//Recursion and Binary Trees
class treeNode{
    int data;
    treeNode left;
    treeNode right;
}
