## Print all prime numbers in a 1D array

```bash

#include <stdio.h>
#include <math.h>

int isPrime(int num) {
    if (num < 2) return 0;
    for (int i = 2; i <= sqrt(num); i++)
        if (num % i == 0) return 0;
    return 1;
}

int main() {
    int n;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter elements:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Prime numbers: ");
    for (int i = 0; i < n; i++)
        if (isPrime(arr[i]))
            printf("%d ", arr[i]);
    return 0;
}
```
