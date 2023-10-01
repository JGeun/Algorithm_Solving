#include<iostream>
 using namespace std;

 int H, M, timer;

 int main() {
     ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

     cin >> H >> M;
     cin >> timer;

     H += timer/60;
     M += timer%60;

     if (M >= 60) {
         M -= 60;
         H += 1;
     }

     if (H >= 24) {
         H -= 24;
     }

     cout << H << " " << M << "\n";
 }
