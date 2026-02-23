n, x = map(int, input().split())
a = list(map(int, input().split()))

left = 0
right = n - 1
ans = 0

while left < right:
    if a[left] + a[right] <= x:
        ans += right - left
        left += 1
    else:
        right -= 1

print(ans)