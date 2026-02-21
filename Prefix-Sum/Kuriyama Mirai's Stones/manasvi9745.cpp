#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<long long> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    // Prefix sum for original array
    vector<long long> pref(n + 1, 0);
    for (int i = 0; i < n; i++)
        pref[i + 1] = pref[i] + v[i];

    // Sorted array
    vector<long long> sorted_v = v;
    sort(sorted_v.begin(), sorted_v.end());

    // Prefix sum for sorted array
    vector<long long> pref_sorted(n + 1, 0);
    for (int i = 0; i < n; i++)
        pref_sorted[i + 1] = pref_sorted[i] + sorted_v[i];

    int m;
    cin >> m;

    while (m--) {
        int type, l, r;
        cin >> type >> l >> r;

        if (type == 1) {
            cout << pref[r] - pref[l - 1] << "\n";
        } else {
            cout << pref_sorted[r] - pref_sorted[l - 1] << "\n";
        }
    }

    return 0;
}