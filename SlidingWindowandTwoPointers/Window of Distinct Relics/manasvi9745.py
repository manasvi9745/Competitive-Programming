from collections import defaultdict

def longest_subarray_optimal(nums, k):
    n = len(nums)
    freq = defaultdict(int)

    left = 0
    max_length = 0
    distinct_count = 0

    for right in range(n):
        # Add current element
        if freq[nums[right]] == 0:
            distinct_count += 1
        freq[nums[right]] += 1

        # If more than k distinct, shrink window
        while distinct_count > k:
            freq[nums[left]] -= 1
            if freq[nums[left]] == 0:
                distinct_count -= 1
            left += 1

        # Update maximum length
        max_length = max(max_length, right - left + 1)

    return max_length


# Example
nums = [1, 2, 1, 3, 4, 2, 3]
k = 2
print(longest_subarray_optimal(nums, k))  # 3