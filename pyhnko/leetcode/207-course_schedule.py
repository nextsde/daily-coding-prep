class Solution:
    def canFinish(self, N: int, prerequisites: List[List[int]]) -> bool:
        from collections import defaultdict
        
        # create the graph
        graph = defaultdict(list)
        for destiny, source in prerequisites: graph[source].append(destiny)
        
        # topological sort
        degrees =[0]*N
        for next, _ in prerequisites: degrees[next] += 1
        queue = [i for i, n in enumerate(degrees) if n == 0] #FIFO
        
        while queue:
            v = queue.pop(0)
            for u in graph[v]:
                degrees[u] -= 1
                if degrees[u] == 0: queue.append(u)
        
        return not any(degrees)

"""
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> graph[numCourses], degree(numCourses, 0);
        queue<int> q;
        
        for(auto& p: prerequisites){
            graph[p[1]].push_back(p[0]);
            degree[p[0]]++;
        }
        
        for(int i=0; i<numCourses; i++)
            if(degree[i] == 0)
                q.push(i);
        
        while(!q.empty()){
            int v = q.front(); q.pop();
            for(auto& u : graph[v]){
                degree[u]--;
                if (degree[u] == 0)
                    q.push(u);
            }
        }
        
        return !any_of(degree.begin(), degree.end(), [](int n){return n>0;});
        
    }
};
"""

""""
impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        use std::collections::VecDeque;
        
        let mut graph: Vec<Vec<usize>> = vec![vec![]; num_courses as usize];
        let mut degree: Vec<usize> = vec![0; num_courses as usize];
        
        for pre in prerequisites.iter(){
            graph[pre[1] as usize].push(pre[0] as usize);
            degree[pre[0] as usize] += 1;
        }
        let mut q: VecDeque<usize> = VecDeque::new();
        for (i, d) in degree.iter().enumerate(){
            if *d == 0 {
                q.push_back(i as usize);
            }
        }
        
        let mut cnt = 0;
        while let Some(v) = q.pop_front(){
            cnt += 1;
            for u in graph[v].clone(){
                degree[u] -= 1;
                if degree[u] == 0{
                    q.push_back(u);
                }
            }
        }
        
        return cnt == num_courses;
        
        
    }
}
""""