##  Check whether a given number is perfect or not.  [Hint: Sum of all positive divisors of a given number excluding the given number is 
equal to the number] 

```bash
#include <stdio.h>

int main() {
    int num, sum = 0;
    printf("Enter a number: ");
    scanf("%d", &num);

    for (int i = 1; i <= num / 2; i++) {
        if (num % i == 0) {
            sum += i;
        }
    }

    if (sum == num) {
        printf("%d is a Perfect Number.\n", num);
    } else {
        printf("%d is NOT a Perfect Number.\n", num);
    }
    return 0;
}
```
