def mod_pow(a, n, mod):
    result = 1
    a %= mod

    while n > 0:
        if n % 2 == 1:
            result = (result * a) % mod
        a = (a * a) % mod
        n //= 2

    return result

def super_pow(a, b):
    MOD = 1337
    result = 1

    for digit in b:
        result = mod_pow(result, 10, MOD)
        result = (result * mod_pow(a, digit, MOD)) % MOD

    return result

a = int(input().strip())
b_input = input().strip()
b = list(map(int, b_input[1:-1].split(",")))

print(super_pow(a, b))
