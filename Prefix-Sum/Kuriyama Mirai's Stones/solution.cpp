#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<long long> v(n+1), pref(n+1), prefSorted(n+1);

    for (int i = 1; i <= n; i++) {
        cin >> v[i];
        pref[i] = pref[i-1] + v[i];
    }

    vector<long long> u = v;
    sort(u.begin()+1, u.end());

    for (int i = 1; i <= n; i++)
        prefSorted[i] = prefSorted[i-1] + u[i];

    int m;
    cin >> m;

    while (m--) {
        int type, l, r;
        cin >> type >> l >> r;

        if (type == 1)
            cout << pref[r] - pref[l-1] << "\n";
        else
            cout << prefSorted[r] - prefSorted[l-1] << "\n";
    }
}
