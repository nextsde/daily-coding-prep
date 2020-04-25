package com.nextswe.prep.ds_goodrich.chapter6;

public class CodeFragment {
    /* A generic method for reversing an array. */
    public static <E> void reverse(E[] a){
        Stack<E> buffer = new ArrayStack<>(a.length);
        for(int i=0;i<a.length;i++){
            buffer.push(a[i]);
        }
        for(int i=0;i<a.length;i++){
            a[i] = buffer.pop();
        }
    }

    public static boolean isMatched(String expression){
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new LinkedStack<>();
        for(char c: expression.toCharArray()){
            if(opening.indexOf(c)!=-1){
                buffer.push(c);
            }else if(closing.indexOf(c)!=-1){
                if(buffer.isEmpty()){return false;}
                if(closing.indexOf(c)!=opening.indexOf(buffer.pop())){return false;}
            }
        }
        return buffer.isEmpty();
    }

    public static boolean isHTMLMatched(String html){
        Stack<String> buffer = new LinkedStack<>();
        int j = html.indexOf("<");
        while(j!=-1){
            int k = html.indexOf(">",j+1);
            if(k==-1){return false;}
            String tag = html.substring(j+1,k);// we are droppoing < > from tag
            if(!tag.startsWith("/")){ // if it is not an ending tag put it in the buffer
                buffer.push(tag);
            }else{
                if(buffer.isEmpty()){return false;} //we've found an ending tag but no opening tag exist
                if(!tag.substring(1).equals(buffer.pop())){ return false; } //ending tag matched with opening tag
            }
            j = html.indexOf("<",k+1);
        }
        return buffer.isEmpty();
    }

    public static <E> E Josephus(CircularQueue<E> queue, int k){
        if(queue.isEmpty()){ return null; }
        while(queue.size()>1){
            for(int i=0;i<k-1;i++)
                queue.rotate();
            E e = queue.dequeue();
            System.out.println("    "+e+" is out");
        }
        return queue.dequeue();
    }

    public static <E> CircularQueue<E> buildQueue(E a[]){
        CircularQueue<E> queue = new LinkedCircularQueue<>();
        for(int i=0;i<a.length;i++){
            queue.enqueue(a[i]);
        }
        return queue;
    }



    public static void main(String[] args){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(5);
        System.out.println(deque.toString());
        deque.addFirst(3);
        System.out.println(deque.toString());
        deque.addFirst(7);
        System.out.println(deque.toString());
        System.out.println(deque.first());
        System.out.println(deque.removeLast());
        System.out.println(deque.toString());
//        String[] a1 = {"Alice","Bob","Cindy","Doug","Ed","Fred"};
//        String[] a2 = {"Gene","Hope","Irene","Jack","Kim","Lance"};
//        String[] a3 = {"Mike","Roberto"};
//        System.out.println("First winner is "+Josephus(buildQueue(a1),3));
//        System.out.println("Second winner is "+Josephus(buildQueue(a2),10));
//        System.out.println("Third winner is "+Josephus(buildQueue(a3),7));

//        System.out.println(isMatched("[(5+x)−(y+z)]"));
//        System.out.println(isMatched("({[])}"));
//        String html = "<body>\n" +
//                   "<center>\n" +
//                   "<h1> The Little Boat </h1> </center>\n" +
//                   "<p> The storm tossed the little boat like a cheap sneaker in an old washing machine. The three drunken fishermen were used to such treatment, of course, but not the tree salesman, who even as a stowaway now felt that he\n" +
//                   "had overpaid for the voyage. </p> <ol>\n" +
//                   "<li> Will the salesman die? </li> <li> What color is the boat? </li> <li> And what about Naomi? </li> </ol>\n" +
//                   "</body>\n";
//        System.out.println(isHTMLMatched(html));


//        Integer[] a = {4, 8, 15, 16, 23, 42};
//        String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
//        System.out.println("a = " + Arrays.toString(a));
//        System.out.println("s = " + Arrays.toString(s));
//        System.out.println("Reversing...");
//        reverse(a);
//        reverse(s);
//        System.out.println("a = " + Arrays.toString(a));
//        System.out.println("s = " + Arrays.toString(s));
    }
}
