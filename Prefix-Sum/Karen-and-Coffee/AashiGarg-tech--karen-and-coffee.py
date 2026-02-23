import sys
input = sys.stdin.readline

MAXT = 200000

n, k, q = map(int, input().split())

diff = [0] * (MAXT + 2)

for _ in range(n):
    l, r = map(int, input().split())
    diff[l] += 1
    diff[r + 1] -= 1

cover = [0] * (MAXT + 1)
cur = 0
for i in range(1, MAXT + 1):
    cur += diff[i]
    cover[i] = cur

admissible = [0] * (MAXT + 1)
for i in range(1, MAXT + 1):
    if cover[i] >= k:
        admissible[i] = 1

pref = [0] * (MAXT + 1)
for i in range(1, MAXT + 1):
    pref[i] = pref[i - 1] + admissible[i]

out = []
for _ in range(q):
    a, b = map(int, input().split())
    out.append(str(pref[b] - pref[a - 1]))

print("\n".join(out))