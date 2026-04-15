### Write a recursive function FIB to generate nth Fibonacci term. Write a main program to print first N Fibonacci terms using function FIB

```bash
#include <stdio.h>

int FIB(int n) {
    if (n == 0)
        return 0;
    else if (n == 1)
        return 1;
    else
        return FIB(n - 1) + FIB(n - 2);
}

int main() {
    int N, i;
    printf("Enter the number of terms: ");
    scanf("%d", &N);
    printf("Fibonacci series: ");
    for (i = 0; i < N; i++) {
        printf("%d ", FIB(i));
    }
    printf("\n");
    return 0;
}
```
