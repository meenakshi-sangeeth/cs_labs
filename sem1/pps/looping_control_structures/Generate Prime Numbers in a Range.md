## Generate prime numbers between 2 given limits

```bash
#include <stdio.h>

int main() {
    int lower, upper, i, j, isPrime;

    printf("Enter lower limit: ");
    scanf("%d", &lower);
    printf("Enter upper limit: ");
    scanf("%d", &upper);

    i = lower;
    if (i < 2) i = 2; // primes start from 2

    printf("Prime numbers between %d and %d are:\n", lower, upper);
    while (i <= upper) {
        isPrime = 1; // assume prime
        j = 2;
        while (j <= i / 2) {
            if (i % j == 0) {
                isPrime = 0;
                break;
            }
            j++;
        }
        if (isPrime)
            printf("%d ", i);
        i++;
    }
    printf("\n");

    return 0;
}

```
