## Write a program using `do-while` loop to read the numbers until `-1` is encountered. Also, count the number of prime numbers and composite numbers entered by the user.  Hint: 1 is neither prime nor composite.  

```bash
#include <stdio.h>

int main() {
    int num, primeCount = 0, compositeCount = 0, i, isPrime;

    do {
        printf("Enter a number (-1 to stop): ");
        scanf("%d", &num);

        if (num == -1)
            break;
        if (num == 1 || num == 0)
            continue;

        isPrime = 1;
        i = 2;
        while (i <= num / 2) {
            if (num % i == 0) {
                isPrime = 0;
                break;
            }
            i++;
        }

        if (isPrime)
            primeCount++;
        else
            compositeCount++;

    } while (num != -1);

    printf("Prime numbers count: %d\n", primeCount);
    printf("Composite numbers count: %d\n", compositeCount);

    return 0;
}
```
