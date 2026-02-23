import sys
input = sys.stdin.readline

def solve():
    n = int(input())
    v = list(map(int, input().split()))
    
    # Prefix sum for original array
    pref = [0] * (n + 1)
    for i in range(n):
        pref[i + 1] = pref[i] + v[i]
    
    # Sorted array
    u = sorted(v)
    
    # Prefix sum for sorted array
    pref_sorted = [0] * (n + 1)
    for i in range(n):
        pref_sorted[i + 1] = pref_sorted[i] + u[i]
    
    m = int(input())
    
    for _ in range(m):
        t, l, r = map(int, input().split())
        
        if t == 1:
            print(pref[r] - pref[l - 1])
        else:
            print(pref_sorted[r] - pref_sorted[l - 1])


solve()