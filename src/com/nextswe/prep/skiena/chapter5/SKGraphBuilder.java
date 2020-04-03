package com.nextswe.prep.skiena.chapter5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SKGraphBuilder {
    private SKGraph initialize_graph(){
        SKGraph skg = new SKGraph(100, false);
        for(int i=1;i<=skg.MAX_VERTEX;i++) skg.degree[i] = 0;
        for(int i=1;i<=skg.MAX_VERTEX;i++) skg.edges[i] = null;

        return skg;
    }

    public SKGraph read_graph(){
        int m; //number of edges
        int x,y; //vertices in edge (x,y)

        SKGraph skg = initialize_graph();

        Scanner in = new Scanner(System.in);
        System.out.println("Number of vertices?");
        skg.nvertices = in.nextInt();
        System.out.println("Number of edges?");
        m = in.nextInt();

        for(int i=1;i<=m;i++){
            System.out.println("edge "+i);
            x = in.nextInt();
            y = in.nextInt();
            insert_edge(skg,x,y,skg.directed);
        }

        return skg;
    }

    //Copied & adjusted according to my need this method from
    //UCSD UCSDGraphs course material from coursera
    //UCSD has a nice course on coursera, do have plans to complete that one later
    /**
     * Loads a graph from a file.  The file is specified with each
     * line representing an edge.  Vertices are numbered from
     * 0..1-numVertices.
     *
     * The first line of the file contains a single int which is the
     * number of vertices in the graph.
     * and the second line number of edges
     * e.g.
     * 4
     * 5
     * 1 2
     * 2 4
     * 4 3
     * 3 1
     * 1 4
     * @param filename The file containing the graph
     */
    public SKGraph loadGraph(String filename)
    {
        BufferedReader reader = null;
        try {
            String nextLine;
            reader = new BufferedReader(new FileReader(filename));
            nextLine = reader.readLine();
            if (nextLine == null) {
                reader.close();
                throw new IOException("Graph file is empty!");
            }

            int m; //number of edges
            int x,y; //vertices in edge (x,y)

            SKGraph skg = initialize_graph();

            skg.nvertices = Integer.parseInt(nextLine);
            nextLine = reader.readLine();
            m = Integer.parseInt(nextLine);

            for(int i=1; (nextLine = reader.readLine()) != null && i<=m;i++){
                String[] verts = nextLine.split(" ");
                x = Integer.parseInt(verts[0]);
                y = Integer.parseInt(verts[1]);
                insert_edge(skg,x,y,skg.directed);
            }
            reader.close();

            return skg;
        } catch (IOException e) {
            System.err.println("Problem loading graph file: " + filename);
            e.printStackTrace();
        }
        return null;
    }

    private void insert_edge(SKGraph skg, int x, int y, boolean directed){
        SKEdgeNode p = new SKEdgeNode(); //temp pointer

        p.weight = 0;
        p.y = y;
        p.next = skg.edges[x];

        skg.edges[x] = p;

        skg.degree[x]++;

        if(!directed){
            insert_edge(skg,y,x,true);
        }else{
            skg.nedges++;
        }
    }

    public void print_graph(SKGraph skg){
        SKEdgeNode p;
        for(int i=1;i<=skg.nvertices;i++){
            System.out.print(i+": ");
            p = skg.edges[i];
            while(p!=null){
                System.out.print(" "+p.y);
                p = p.next;
            }
            System.out.println();
        }
    }
    //bfs
    boolean processed[]; //which vertices have been processed
    boolean discovered[]; //which vertices have been found
    int parent[]; //discovery relation
    int entry_time[];
    int exit_time[];
    boolean finished = false;
    int time_count = 0;
    boolean dfs = false;

    public void initialize_search(SKGraph skg){
        processed = new boolean[skg.MAX_VERTEX];
        discovered = new boolean[skg.MAX_VERTEX];
        parent = new int[skg.MAX_VERTEX];
        entry_time = new int[skg.MAX_VERTEX];
        exit_time = new int[skg.MAX_VERTEX];
        finished = false;
        dfs = false;

        for(int i=1; i<=skg.nvertices; i++){
            discovered[i] = false;
            processed[i] = false;
            parent[i] = -1;
        }
    }

    public void dfs(SKGraph skg, int x){
        SKEdgeNode p;
        int y;
        dfs = true;

        if(finished){
            return;
        }

        discovered[x] = true;
        time_count = time_count+1;
        entry_time[x] = time_count;

        process_vertex_early(x);

        p = skg.edges[x];
        while(p!=null){
            y = p.y;
            if(!discovered[y]){
                parent[y] = x;
                process_edge(x,y);
                dfs(skg,y);
            }else if((!processed[y] && parent[x]!=y) || skg.directed){
                process_edge(x,y);
            }

            if(finished){
                return;
            }
            p=p.next;
        }
        process_vertex_late(x);

        time_count = time_count+1;
        exit_time[x] = time_count;

        processed[x] = true;
    }

    public void bfs(SKGraph skg, int start){
        Queue<Integer> queue = new LinkedList<>(); //to keep track of list of vertices as discover visit them
        int v; //current vertex that we are processing from the queue
        int y; //successor vertex that we get from adjacency list and need to check whether it has been discovered or not
        SKEdgeNode p;

        queue.add(start);
        discovered[start] = true;

        while(!queue.isEmpty()){
            v = queue.remove();
            process_vertex_early(v);
            processed[v] = true;
            p = skg.edges[v];
            while(p!=null){
                y = p.y;
                if(!processed[y]||skg.directed)
                    process_edge(v,y);
                if(!discovered[y]){
                    queue.add(y);
                    discovered[y] = true;
                    parent[y] = v;
                }
                p = p.next;
            }
            process_vertex_late(v);
        }
    }

    public void find_path(int start, int end){
        if((start==end) || end == -1){
            System.out.print("\n"+start);
        }else{
            find_path(start,parent[end]);
            System.out.print(" "+end);
        }
    }

    public int connected_components(SKGraph skg){
        int c = 0; //number of components;
        for(int i=1;i<=skg.nvertices;i++){
            if(!discovered[i]){
                c = c+1;
                bfs(skg,i);
            }
        }
        return c;
    }

    private boolean bipartite = false;
    private int UNCOLORED = 1;
    private int WHITE = 2;
    private int BLACK = 3;
    private int color[];
    private boolean twoColor = false;
    public boolean two_color(SKGraph skg){
        twoColor = true;
        color = new int[skg.MAX_VERTEX];
        for(int i=1;i<=skg.nvertices;i++){
            color[i] = UNCOLORED;
        }
        bipartite = true;

        for(int i=1;i<=skg.nvertices; i++){
            if(!discovered[i]){
                color[i] = WHITE;
                bfs(skg,i);
            }
        }
        return bipartite;
    }



    private void process_vertex_late(int v) {
    }

    private void process_edge(int x, int y) {
        if(dfs){
            if(discovered[y] && (parent[x] != y)){
                System.out.print("Cycle from "+y+" to "+x);
                find_path(y,x);
                finished = true;
            }
        }else{
            if(twoColor){
                if(color[x] == color[y]){
                    bipartite = false;
                    System.out.println("Not bipartite "+x+","+y);
                }
                color[y] = complement(color[x]);
            }
        }
    }

    private int complement(int color){
        if(color == WHITE)return BLACK;
        if(color == BLACK)return WHITE;
        return UNCOLORED;
    }

    private void process_vertex_early(int v) {
    }
}
