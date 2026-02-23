MOD = 10**9 + 7

def count_divisors_of_factorial(N):
    is_prime = [True] * (N + 1)
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(N**0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, N + 1, i):
                is_prime[j] = False

    primes = [i for i in range(2, N + 1) if is_prime[i]]

    ans = 1

    for p in primes:
        exp = 0
        power = p
        while power <= N:
            exp += N // power
            power *= p

        ans = ans * (exp + 1) % MOD

    return ans


N = int(input().strip())
print(count_divisors_of_factorial(N))