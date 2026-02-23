import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    q = int(input_data[1])
    
    a = []
    for i in range(2, n + 2):
        a.append(int(input_data[i]))
    
    diff = [0] * (n + 2)
    ptr = n + 2
    for _ in range(q):
        l = int(input_data[ptr])
        r = int(input_data[ptr+1])
        ptr += 2
        diff[l] += 1
        diff[r + 1] -= 1

    cnt = [0] * (n + 1)
    current_freq = 0
    for i in range(1, n + 1):
        current_freq += diff[i]
        cnt[i] = current_freq

    actual_counts = sorted(cnt[1:], reverse=True)
    a.sort(reverse=True)

    max_sum = 0
    for i in range(n):
        max_sum += a[i] * actual_counts[i]
        
    print(max_sum)

if __name__ == "__main__":
    solve()