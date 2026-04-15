## Generate Floyd’s triangle using natural numbers for a given limit N. (using for loops) [Hint: Floyd’s triangle is a right angled-triangle using the natural numbers] 

```bash
#include <stdio.h>

int main() {
    int N, num = 1;
    printf("Enter the number of rows (N): ");
    scanf("%d", &N);

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= i; j++) {
            printf("%d ", num++);
        }
        printf("\n");
    }
    return 0;
}
```
