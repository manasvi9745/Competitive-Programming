s = input().strip()

moves = 0

for i in range(1, len(s)):
    if s[i] == s[i - 1]:
        moves += 1

if moves % 2 == 1:
    print("Yes")
else:
    print("No")
