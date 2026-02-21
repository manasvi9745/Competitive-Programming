def count_pairs_two_pointer(arr, x):
    n = len(arr)
    left = 0
    right = n - 1
    count = 0
    
    while left < right:
        if arr[left] + arr[right] <= x:
            # All pairs from left to right-1 are valid
            count += (right - left)
            left += 1
        else:
            right -= 1
            
    return count


# Example
arr = [1, 2, 3, 4, 5]
x = 6
print(count_pairs_two_pointer(arr, x))  # Output: 6