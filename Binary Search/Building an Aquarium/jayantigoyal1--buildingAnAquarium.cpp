#include<bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        long long x;
        cin>>n>>x;
        vector<long long> arr(n);
        long long maxi=0;
        for(int i=0; i<n; i++){
            cin>>arr[i];
            maxi=max(maxi,arr[i]);
        }
        long long low=1, high=maxi+x;
        long long ans=1;
        while(low<=high){
            long long mid=low+(high-low)/2;
            long long water=0;
            for(long long h:arr){
                if(h<mid){
                    water+=(mid-h);
                    if(water>x)break;
                }
            }
            if(water<=x){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        cout<<ans<<endl;
    }
    return 0;
}