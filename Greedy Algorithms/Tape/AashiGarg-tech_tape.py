import sys

def solve():
    input = sys.stdin.readline
    n, m, k = map(int, input().split())
    b = list(map(int, input().split()))

    if k >= n:
        print(n)
        return

    total = b[-1] - b[0] + 1

    gaps = []
    for i in range(1, n):
        gaps.append(b[i] - b[i-1] - 1)

    gaps.sort(reverse=True)

    for i in range(k - 1):
        total -= gaps[i]

    print(total)


if __name__ == "__main__":
    solve()