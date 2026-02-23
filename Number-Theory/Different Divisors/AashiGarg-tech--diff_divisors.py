import sys
import math

def is_prime(x):
    if x < 2:
        return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True

def next_prime(start):
    x = start
    while not is_prime(x):
        x += 1
    return x

t = int(sys.stdin.readline())

for _ in range(t):
    d = int(sys.stdin.readline())

    p = next_prime(1 + d)
    q = next_prime(p + d)

    print(p * q)