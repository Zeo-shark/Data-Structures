/**
 *  author: souravrax
 *  created: 26.04.2021 10:09:50
**/
#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;

#define all(x) begin(x), end(x)
#define len(x) int((x).size())
template<typename A, typename B> ostream& operator<<(ostream &os, const pair<A, B> &p) { return os << '(' << p.first << ", " << p.second << ')'; }
template<typename T_container, typename T = typename enable_if<!is_same<T_container, string>::value, typename T_container::value_type>::type> 
ostream& operator<<(ostream &os, const T_container &v) { os << '{'; string sep; for (const T &x : v) os << sep << x, sep = ", "; return os << '}'; }
void dbg_out() { cerr << endl; }
template<typename Head, typename... Tail> void dbg_out(Head H, Tail... T) { cerr << ' ' << H; dbg_out(T...); }
#ifdef LOCAL
#define dbg(...) cerr << "[ " << #__VA_ARGS__ << " ]:", dbg_out(__VA_ARGS__)
#else
#define dbg(...) (void)0x30
#endif
using ll = long long;

int32_t main() {
    ios::sync_with_stdio(false), cin.tie(nullptr);
    int n; cin >> n;
    vector<int> nums(n);
    for (int& i : nums) cin >> i;
    tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> st;
    for (int i = 0; i < n; i++) {
        st.insert(i);
    }
    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        auto idx = *st.find_by_order(x - 1);
        cout << nums[idx] << ' ';
        st.erase(st.find_by_order(x - 1));
    }
}

