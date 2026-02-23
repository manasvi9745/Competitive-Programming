def solve():
    t = int(input())
    results = []

    for _ in range(t):
        n, m = map(int, input().split())

        proficient = [0] * (n + 1)

        tasks = list(map(int, input().split()))
        for worker in tasks:
            proficient[worker] += 1

        def can_finish(T):
            extra = 0
            need = 0

            for i in range(1, n + 1):
                c = proficient[i]
                if c <= T:
                    extra += (T - c) // 2
                else:
                    need += c - T

            return extra >= need

        low, high = 1, 2 * m
        ans = high

        while low <= high:
            mid = (low + high) // 2
            if can_finish(mid):
                ans = mid
                high = mid - 1
            else:
                low = mid + 1

        results.append(str(ans))

    print("\n".join(results))


solve()