### Interchange the primary and secondary diagonal elements in the given Matrix

```bash
#include <stdio.h>

int main() {
    int n, i, temp;
    printf("Enter order of matrix: ");
    scanf("%d", &n);

    int a[n][n];
    printf("Enter matrix elements:\n");
    for(i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    for(i = 0; i < n; i++) {
        temp = a[i][i];
        a[i][i] = a[i][n-1-i];
        a[i][n-1-i] = temp;
    }

    printf("Matrix after swapping diagonals:\n");
    for(i = 0; i < n; i++) {
        for(int j = 0; j < n; j++)
            printf("%d ", a[i][j]);
        printf("\n");
    }

    return 0;
}

```
