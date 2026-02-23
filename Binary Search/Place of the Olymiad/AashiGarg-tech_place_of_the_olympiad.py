def can_place(n, m, k, L):
    # max desks in one row if longest bench ≤ L
    full_blocks = m // (L + 1)
    rem = m % (L + 1)

    per_row = full_blocks * L + min(rem, L)
    return per_row * n >= k


def solve():
    t = int(input())
    for _ in range(t):
        n, m, k = map(int, input().split())

        low, high = 1, m
        ans = m

        while low <= high:
            mid = (low + high) // 2
            if can_place(n, m, k, mid):
                ans = mid
                high = mid - 1
            else:
                low = mid + 1

        print(ans)


solve()