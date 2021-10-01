#include <bits/stdc++.h>
using namespace std;

#define ar array
#define all(x) begin(x), end(x)
#define fast ios::sync_with_stdio(false), cin.tie(nullptr)
#ifdef LOCAL
#define log(x) cerr<<"[ " << #x << " : " << (x) << " ]\n";
#else
#define log(x) 0x30
#endif

using ll = long long;

int32_t main(){
    fast; 
    ll n;
    cin>>n;
    vector<ll> arr(n);
    for(ll& i : arr) cin>>i;
    ll ans = 0;
    for(int i=1; i<n; i++){
        if(arr[i] < arr[i-1]){
            ans+=abs(arr[i-1]-arr[i]);
            arr[i] = arr[i-1];
        }
    }
    cout<<ans<<'\n';
}

