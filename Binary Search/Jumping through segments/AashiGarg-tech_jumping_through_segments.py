import sys
input = sys.stdin.readline

def can_do(segments, k):
    curL = curR = 0

    for l, r in segments:
        curL = max(curL - k, l)
        curR = min(curR + k, r)
        if curL > curR:
            return False

    return True


def solve():
    t = int(input())
    results = []

    for _ in range(t):
        n = int(input())
        segments = [tuple(map(int, input().split())) for _ in range(n)]

        low, high = 0, 10**18
        ans = high

        while low <= high:
            mid = (low + high) // 2
            if can_do(segments, mid):
                ans = mid
                high = mid - 1
            else:
                low = mid + 1

        results.append(str(ans))

    print("\n".join(results))


solve()