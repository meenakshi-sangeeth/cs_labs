## Generate the multiplication table for ‘n’ numbers up to ‘k’ terms (using nested for loops)

```bash
#include <stdio.h>

int main() {
    int n, k;
    printf("Enter the value of n: ");
    scanf("%d", &n);
    printf("Enter the value of k: ");
    scanf("%d", &k);

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= k; j++) {
            printf("%4d", i * j);
        }
        printf("\n");
    }
    return 0;
}
```
