#include <bits/stdc++.h>
using namespace std;

static const int MAXN = 100005;
long long v[MAXN];
long long pref[MAXN];
long long pref_sorted[MAXN];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        cin >> v[i];
        pref[i] = pref[i - 1] + v[i];
    }

    // Sort directly on a copy
    vector<long long> temp(v + 1, v + n + 1);
    sort(temp.begin(), temp.end());

    for (int i = 1; i <= n; i++) {
        pref_sorted[i] = pref_sorted[i - 1] + temp[i - 1];
    }

    int m;
    cin >> m;

    while (m--) {
        int type, l, r;
        cin >> type >> l >> r;

        if (type == 1)
            cout << pref[r] - pref[l - 1] << '\n';
        else
            cout << pref_sorted[r] - pref_sorted[l - 1] << '\n';
    }

    return 0;
}