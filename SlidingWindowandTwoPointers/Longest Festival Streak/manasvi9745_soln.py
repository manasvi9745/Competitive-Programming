def longest_streak_optimal(a, k):
    n = len(a)
    left = 0
    current_sum = 0
    max_length = 0

    for right in range(n):
        current_sum += a[right]

        while current_sum > k:
            current_sum -= a[left]
            left += 1

        max_length = max(max_length, right - left + 1)

    return max_length


# Example
a = [2, 1, 3, 2, 1]
k = 7
print(longest_streak_optimal(a, k))  # 3