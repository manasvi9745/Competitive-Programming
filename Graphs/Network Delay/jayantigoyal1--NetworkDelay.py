import sys
import heapq

def main():
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    m = int(data[index])
    index += 1
    
    times = []
    for _ in range(m):
        u = int(data[index])
        v = int(data[index + 1])
        w = int(data[index + 2])
        times.append((u, v, w))
        index += 3
    
    n = int(data[index])
    index += 1
    
    k = int(data[index])
    
    adj = [[] for _ in range(n + 1)]
    for u, v, w in times:
        adj[u].append((v, w))
    
    dist = [float('inf')] * (n + 1)
    dist[k] = 0
    
    pq = [(0, k)]
    
    while pq:
        time, node = heapq.heappop(pq)
        
        if time > dist[node]:
            continue
        
        for neighbor, weight in adj[node]:
            new_time = time + weight
            if new_time < dist[neighbor]:
                dist[neighbor] = new_time
                heapq.heappush(pq, (new_time, neighbor))
    
    max_time = max(dist[1:])
    
    if max_time == float('inf'):
        print(-1)
    else:
        print(max_time)

if __name__ == "__main__":
    main()
