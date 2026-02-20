def totalHammingDistance(nums):
    total = 0
    n = len(nums)
    
    # Check all 32 bit positions
    for bit in range(32):
        ones = 0
        
        for num in nums:
            if (num >> bit) & 1:
                ones += 1
        
        zeros = n - ones
        total += ones * zeros
    
    return total


# Example
print(totalHammingDistance([4, 14, 2]))