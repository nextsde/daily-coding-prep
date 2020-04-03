package com.nextswe.prep;

import com.nextswe.prep.skiena.chapter5.SKGraph;
import com.nextswe.prep.skiena.chapter5.SKGraphBuilder;

public class Main {
    public static void main(String[] args) {
        SKGraphBuilder skGraphBuilder = new SKGraphBuilder();
//        SKGraph skg = skGraphBuilder.read_graph();
        SKGraph skg = skGraphBuilder.loadGraph("data/graph1.txt");
//        skGraphBuilder.print_graph(skg);
        skGraphBuilder.initialize_search(skg);
//        skGraphBuilder.bfs(skg,1);
//        skGraphBuilder.find_path(1,4);
//        System.out.println("Connected Components: "+skGraphBuilder.connected_components(skg));
        System.out.println("Two Color Bipartite: "+skGraphBuilder.two_color(skg));

//        int A[] = new int[]{10,7,8,9,1,5};
//        BasicSort.qsort(A);
//        SKHeap.heap_sort_by_extract_min(A);
//        Utils.printArray(A);
//        Apr2_P202 p202 = new Apr2_P202();
//        System.out.println(p202.isHappy(1234));
    }
}
