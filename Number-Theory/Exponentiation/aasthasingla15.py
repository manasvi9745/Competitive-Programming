MOD = 10 ** 9 + 7


def mod_pow(a, b):
    # Special case as per problem statement
    if a == 0 and b == 0:
        return 1

    result = 1
    a %= MOD

    while b > 0:
        if b & 1:  # If b is odd
            result = (result * a) % MOD
        a = (a * a) % MOD
        b >>= 1  # Divide b by 2

    return result


# Read number of calculations
n = int(input().strip())

for _ in range(n):
    a, b = map(int, input().split())
    print(mod_pow(a, b))
