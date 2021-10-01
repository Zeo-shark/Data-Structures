/**
 *  author: sourav rakshit
 *  created: 24.09.2020 10:12:14
**/

/* #pragma GCC optimize("O3") */
/* #pragma GCC target ("avx2") */
/* #pragma GCC optimize("unroll-loops") */
/* #pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native") */

#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp> 
#include <ext/pb_ds/tree_policy.hpp> 
#include <ext/rope>

using namespace std;
using namespace __gnu_cxx;

//@pbds
template<typename K, typename V, typename Comp = std::less<K>>
using ordered_map = __gnu_pbds::tree<
    K, V, Comp,
    __gnu_pbds::rb_tree_tag,
    __gnu_pbds::tree_order_statistics_node_update
>;
template <typename K, typename Comp = std::less<K>>
using ordered_set = ordered_map<K, __gnu_pbds::null_type, Comp>;

//@alias
using ll = long long;
using ld = long double;
using pii = pair<int,int>;
using pll = pair<ll,ll>;
using vi = vector<int>;
using vll = vector<ll>;

//@Macros
#define ar array
#define len(x) (int)(x).size()
#define all(x) (x).begin(), (x).end()
#define str(s) to_string(s)

//@Magic Lambdas
namespace std {
template<class Fun> class rec_result{
Fun fun_;
public:
template<class T>
explicit rec_result(T &&fun): fun_(std::forward<T>(fun)) {}
template<class ...Args>
decltype(auto) operator()(Args &&...args) {
return fun_(std::ref(*this), std::forward<Args>(args)...);}};
template<class Fun>decltype(auto) rec(Fun &&fun) {
return rec_result<std::decay_t<Fun>>(std::forward<Fun>(fun));
}} // namespace std

//@Debugger
#ifdef LOCAL
template<typename T> ostream& operator<<(ostream &os, const vector<T> &v)
{ os << '{'; string sep; for (const auto &x : v) os << sep << x, sep = ", "; return os << '}'; }
template<typename T, size_t size> ostream& operator<<(ostream &os, const array<T, size> &arr) 
{ os << '{'; string sep; for (const auto &x : arr) os << sep << x, sep = ", "; return os << '}'; }
template<typename A, typename B> ostream& operator<<(ostream &os, const pair<A, B> &p) 
{ return os << '(' << p.first << "," << p.second << ')'; }

void flush_out() { cerr << endl; }
template<typename H, typename... T> void flush_out(H h, T... t) { cerr << ' ' << h << " | "; flush_out(t...); }
#define log(...) cerr << "[ " << #__VA_ARGS__ << " ] :", flush_out(__VA_ARGS__)
#else
#define log(...) (void)0x30
#endif

//@Utilities
template<typename T> inline void mini(T& a, T b) { a = min(a, b); }
template<typename T> inline void maxi(T& a, T b) { a = max(a, b); }
template<class T>class Random{ static T range(T&a, T&b){ return a+rand()%(b-a+1); }};

//*//---------------------------- Globals --------------------------//*//

const int mod = 1e9 + 7;
const ll INF = 1e18;
const int nax = 2000 * 2007;
const ld PI = 4*atan((ld)1);

//*//---------------------------- Code Begins Here --------------------------//*//

vector<vector<pair<int64_t,int64_t>>> G;
inline void tc() {
    int64_t n, m;
    cin >> n >> m;
    G.resize(n + 1);
    for(int i = 0; i < m; i++) {
        int64_t x, y, w;
        cin >> x >> y >> w;
        G[x].push_back(make_pair(y, w));
    }
    priority_queue<pair<int64_t,int64_t>> q;
    vector<int64_t> dist(n + 1, 4e18);
    vector<bool> visited(n + 1, false);

    q.push({0, 1});
    dist[1] = 0;

    while(!q.empty()) {
        auto node = q.top().second; q.pop();

        if(visited[node]) continue;
        visited[node] = true;

        for(pair<int64_t,int64_t>& x : G[node]) {
            int64_t b = x.first, w = x.second;
            if(dist[node] + w < dist[b]) {
                dist[b] = dist[node] + w;
                q.push(make_pair(-dist[b], b));
            }
        }
    }
    for(int64_t i = 1; i <= n; i++) {
        cout << dist[i] << ' ';
    }
    cout << endl;
}

int32_t main() {
    ios::sync_with_stdio(false);
#ifndef LOCAL
    cin.tie(nullptr);
#endif
    int tt = 1;
    /* cin >> tt; */
    for(int _=tt-1;~_;--_){
        tc();
    }
#ifdef LOCAL
    cerr << "\nTime elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << "s.\n";
#endif
}

/* ============ 😇 NEED HELP? ============ */ 
/* Take a look the the overflows */
/* IndexOutOfBound? Accessing nullptr? */
/* What about some stress testing? */
/* Flood with log or use GDB */
/* ============ NOW SOLVE 👊 ============ */ 

