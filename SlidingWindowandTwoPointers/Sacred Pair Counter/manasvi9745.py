import bisect

def count_pairs_binary_search(a, x):
    n = len(a)
    count = 0

    for i in range(n):
        target = x - a[i]
        j = bisect.bisect_right(a, target) - 1

        if j > i:
            count += (j - i)

    return count