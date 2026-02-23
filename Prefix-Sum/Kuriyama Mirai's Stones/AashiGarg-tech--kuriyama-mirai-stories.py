import sys
input = sys.stdin.readline

n = int(input())
v = list(map(int, input().split()))

pref = [0] * (n + 1)
for i in range(n):
    pref[i + 1] = pref[i] + v[i]

u = sorted(v)
pref_s = [0] * (n + 1)
for i in range(n):
    pref_s[i + 1] = pref_s[i] + u[i]

m = int(input())
out = []

for _ in range(m):
    t, l, r = map(int, input().split())
    if t == 1:
        out.append(str(pref[r] - pref[l - 1]))
    else:
        out.append(str(pref_s[r] - pref_s[l - 1]))

print("\n".join(out))