import sys

data = sys.stdin.read().split()
it = iter(data)

t = int(next(it))
INF = 10**9
out = []

for _ in range(t):
    n = int(next(it))
    k = int(next(it))
    q = int(next(it))

    queries = []
    must_be_ge_k = [False] * n

    for _ in range(q):
        c = int(next(it))
        l = int(next(it)) - 1
        r = int(next(it)) - 1
        queries.append((c, l, r))

        if c == 1:
            for i in range(l, r + 1):
                must_be_ge_k[i] = True

    a = [INF] * n
    fixed = [False] * n

    for c, l, r in queries:
        if c == 1:
            placed = False
            for i in range(l, r + 1):
                if not fixed[i]:
                    a[i] = k
                    fixed[i] = True
                    placed = True
                    break

    for c, l, r in queries:
        if c == 2:
            for i in range(l, r + 1):
                if a[i] == k:
                    a[i] = k + 1
                    fixed[i] = True

            need = 0
            for i in range(l, r + 1):
                if need == k:
                    break
                if not fixed[i] and not must_be_ge_k[i]:
                    a[i] = need
                    fixed[i] = True
                    need += 1

    for i in range(n):
        if not fixed[i]:
            if must_be_ge_k[i]:
                a[i] = k
            else:
                a[i] = k + 1

    out.append(" ".join(map(str, a)))

print("\n".join(out))