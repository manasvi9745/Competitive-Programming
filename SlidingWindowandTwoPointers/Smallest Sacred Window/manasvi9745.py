n, k = map(int, input().split())
arr = list(map(int, input().split()))

left = 0
s = 0
ans = float('inf')

for right in range(n):
    s += arr[right]

    while s >= k:
        ans = min(ans, right - left + 1)
        s -= arr[left]
        left += 1

print(-1 if ans == float('inf') else ans)
