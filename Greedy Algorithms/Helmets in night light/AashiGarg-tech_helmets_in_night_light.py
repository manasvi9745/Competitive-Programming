import sys

def solve():
    input = sys.stdin.read().split()
    if not input:
        return
    
    ptr = 0
    t = int(input[ptr])
    ptr += 1
    
    results = []
    
    for _ in range(t):
        n = int(input[ptr])
        p = int(input[ptr+1])
        ptr += 2
        
        a = list(map(int, input[ptr : ptr + n]))
        ptr += n
        b = list(map(int, input[ptr : ptr + n]))
        ptr += n
        
        # Pair sharing capacity (a) with cost (b)
        # We only care about residents cheaper than Pak Chanek (p)
        residents = []
        for i in range(n):
            if b[i] < p:
                residents.append((b[i], a[i]))
        
        # Sort by cost b[i]
        residents.sort()
        
        # Total residents to notify is n. 
        # Pak Chanek notifies the first person for cost p.
        total_cost = p
        remaining_residents = n - 1
        
        for cost, capacity in residents:
            if remaining_residents <= 0:
                break
            
            # Use this resident to notify as many as possible
            can_notify = min(remaining_residents, capacity)
            total_cost += can_notify * cost
            remaining_residents -= can_notify
            
        # Any remaining residents must be notified by Pak Chanek directly
        if remaining_residents > 0:
            total_cost += remaining_residents * p
            
        results.append(str(total_cost))
        
    sys.stdout.write("\n".join(results) + "\n")

if __name__ == "__main__":
    solve()