#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    vector<int> a(n);
    for(int i=0; i<n; i++){
        cin>>a[i];
    }
    int left=0, right=n-1;
    int indy=0, lara=0;
    bool flag=true;
    while(left<=right){
        int chosen;
        if(a[left]>a[right]){
            chosen=a[left];
            left++;
        }
        else{
            chosen=a[right];
            right--;
        }
        if(flag) indy+=chosen;
        else lara+=chosen;
        flag = !flag;
    }
    cout<<indy<<" "<<lara<<endl;
    return 0;
}
