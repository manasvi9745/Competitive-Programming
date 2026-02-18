def longest_festival_streak(arr, k):
    left = 0
    s = 0
    max_len = 0

    for right in range(len(arr)):
        s += arr[right]

        while s > k:
            s -= arr[left]
            left += 1

        max_len = max(max_len, right - left + 1)

    return max_len
