import sys
from bisect import bisect_left

def solve():
    def input():
        return sys.stdin.readline()

    line = input()
    if not line:
        return
    
    t = int(line.strip())
    
    for _ in range(t):
        line = input().split()
        if not line: break
        n, m, q = map(int, line)

        teachers = sorted(list(map(int, input().split())))

        davids = list(map(int, input().split()))
        
        for david in davids:
            idx = bisect_left(teachers, david)
            
            if idx == 0:
                print(teachers[0] - 1)
            elif idx == m:
                print(n - teachers[-1])
            else:
                t1 = teachers[idx-1]
                t2 = teachers[idx]
                print((t2 - t1) // 2)

if __name__ == "__main__":
    solve()