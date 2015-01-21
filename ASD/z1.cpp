#include <stdio.h>

int main() {

	int cur = 0;
	int prev = -1;
	int maxlen = 0;
	int uplen = 0;
	int downlen = 0;
	long long maxsum = 0;
	long long upsum = 0;
	long long downsum = 0;

	int temp = 0;
	int c = fgetc_unlocked(stdin); // thread-unsafe but potentially faster...

	while ( c != EOF) {
		if ((c >= '0') && (c <= '9')) {
			temp = 10*temp + c - '0';
		} else if ( c == ' ' ) {
			cur = temp;
			temp = 0;
			if (cur > prev) {
				if (downlen > maxlen) {
					maxlen = downlen;
					maxsum = downsum;
				}
				uplen++; 
				upsum += cur;
				downlen = 1;
				downsum = cur;
			} else if (cur < prev) {
				if (uplen > maxlen) {
					maxlen = uplen;
					maxsum = upsum;
				}
				downlen++;
				downsum += cur;
				uplen = 1;
				upsum = cur;		
			} else {
				downlen++;
				downsum += cur;
				uplen++;
				upsum += cur;
			}
			prev = cur;			
		}
		c = fgetc(stdin);
		
		if (downlen > maxlen) {
			maxlen = downlen;
			maxsum = downsum;
		}
		if (uplen > maxlen) {
			maxlen = uplen;
			maxsum = upsum;
		}
	}
	printf("%d %lld", maxlen, maxsum);
	return 0;
}
