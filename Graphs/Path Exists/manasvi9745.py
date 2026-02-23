from collections import deque

def validPath(n, edges, source, destination):
    adj = [[] for _ in range(n)]
    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)

    visited = set()
    queue = deque([source])

    while queue:
        node = queue.popleft()
        
        if node == destination:
            return True
        
        if node in visited:
            continue
        
        visited.add(node)

        for nei in adj[node]:
            if nei not in visited:
                queue.append(nei)

    return False
