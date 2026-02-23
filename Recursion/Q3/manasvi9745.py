def is_palindrome_optimal(s):
    left = 0
    right = len(s) - 1

    while left < right:
        if s[left] != s[right]:
            return "NO"
        left += 1
        right -= 1

    return "YES"


# Example
print(is_palindrome_optimal("level"))       # YES
print(is_palindrome_optimal("codeforces"))  # NO