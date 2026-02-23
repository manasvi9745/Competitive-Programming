#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        long long n, m, k;
        cin >> n >> m >> k;

        long long lo = 1, hi = m, ans = m;

        while (lo <= hi) {
            long long L = (lo + hi) / 2;

            long long full = m / (L + 1);
            long long rem  = m % (L + 1);

            long long per_row = full * L + min(L, rem);

            if (per_row * n >= k) {
                ans = L;
                hi = L - 1;
            } else {
                lo = L + 1;
            }
        }

        cout << ans << "\n";
    }
}
