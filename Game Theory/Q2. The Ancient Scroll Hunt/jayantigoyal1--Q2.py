n = int(input())
a = list(map(int, input().split()))

left = 0
right = n - 1
indy = 0
lara = 0
flag = True

while left <= right:
    if a[left] > a[right]:
        chosen = a[left]
        left += 1
    else:
        chosen = a[right]
        right -= 1

    if flag:
        indy += chosen
    else:
        lara += chosen

    flag = not flag

print(indy, lara)