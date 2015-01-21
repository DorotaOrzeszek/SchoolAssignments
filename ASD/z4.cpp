#include<cstdio>
#include<set>

using namespace std;

inline int scan_int() {
    register int c = getchar_unlocked();
    int x = 0;
    int neg = 0;
    for( ; ((c<48 || c>57) && c != '-'); c = getchar_unlocked() );
    if( c=='-' ) {
        neg=1;
        c=getchar_unlocked();
    }
    for( ;c>47 && c<58; c = getchar_unlocked() ) {
        x = (x << 1) + (x << 3) + c - 48;
    }
    if ( neg )
        x=-x;
    int o = x;
	return o;
}

int main () {
	// macierz sum generowana w locie z wejscia
	int n = scan_int();
	int k = scan_int();
	long long M[n][n];
	for (int i=0; i<n; i++) {
		for (int j=0; j<n; j++) {
			int temp = scan_int();
			if (i==0 && j==0) {
				M[i][j] = temp;
			} else if (i==0 & j!=0) {
				M[i][j] = M[i][j-1] + temp;
			} else if (i!=0 && j==0) {
				M[i][j] = M[i-1][j] + temp;
			} else { // i != 0 && j != 0
				M[i][j] = M[i][j-1] + M[i-1][j] - M[i-1][j-1] + temp;
			}
		}
	}

	// wspolrzedne podmacierzy
	int mi[k][4];
	for (int i=0; i<k; i++) {
		for (int j=0; j<4; j++) {
			mi[i][j] = scan_int();
		}
	}

	// obliczenie sum podmacierzy
	long long misums[k];
	int p, q, r, s;
	for (int i=0; i<k; i++) {
		long long misum = 0;
		int p = mi[i][0];
		int q = mi[i][1];
		int r = mi[i][2];
		int s = mi[i][3];
		if (p != 0 && q != 0) {
			misum = M[r][s] - M[p-1][s] - M[r][q-1] + M[p-1][q-1];
		} else if (p != 0 && q == 0) {
			misum = M[r][s] - M[p-1][s];
		} else if (p == 0 && q != 0) {
			misum = M[r][s] - M[r][q-1];
		} else { // (p == 0 && q == 0)
			misum = M[r][s];
		}
		misums[i] = misum;
	}

	// liczba klas abstrakcji
	set<long long> myset(misums, misums+k);
	int a = myset.size();

	// liczba klas abstrakcji o maksymalnym rozmiarze
	long long m = 0;
	int c = 0;
	multiset<long long> mymultiset(misums, misums+k);
	for (set<long long>::iterator i = myset.begin();
       i != myset.end(); ++i) {
		long long current = mymultiset.count(*i);
		if (current > m) {
			m = current;
			c = 1;
		} else if (current == m) {
			c++;
		}
	}
	long long maxa = c;

	// średnia wartość sumy elementów podmacierzy należących do zbioru R
	long long mysum = 0;
	for (int i=0; i<k; i++) {
		mysum += misums[i];
	}
	long long avg = mysum / k;

	// wyjscie
	printf("%d %lld %lld", a, maxa, avg);

	return 0;
}
