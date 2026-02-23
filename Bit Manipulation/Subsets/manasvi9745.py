def subsets_optimal(nums):
    n = len(nums)
    total = 1 << n  # 2^n
    result = []

    for mask in range(total):
        subset = []
        for i in range(n):
            # Check if i-th bit is set
            if mask & (1 << i):
                subset.append(nums[i])
        result.append(subset)

    return result


# Example
print(subsets_optimal([1, 2, 3]))