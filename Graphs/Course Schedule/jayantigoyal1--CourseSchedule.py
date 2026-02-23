import sys
from collections import deque

def main():
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    numCourses = int(data[index])
    index += 1
    
    m = int(data[index])
    index += 1
    
    adj = [[] for _ in range(numCourses)]
    indegree = [0] * numCourses
    
    for _ in range(m):
        a = int(data[index])
        b = int(data[index + 1])
        index += 2
        
        adj[b].append(a)
        indegree[a] += 1
    
    q = deque()
    
    for i in range(numCourses):
        if indegree[i] == 0:
            q.append(i)
    
    completed = 0
    
    while q:
        course = q.popleft()
        completed += 1
        
        for nxt in adj[course]:
            indegree[nxt] -= 1
            if indegree[nxt] == 0:
                q.append(nxt)
    
    if completed == numCourses:
        print("true")
    else:
        print("false")

if __name__ == "__main__":
    main()
