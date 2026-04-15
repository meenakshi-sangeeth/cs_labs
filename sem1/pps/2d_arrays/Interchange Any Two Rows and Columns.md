### Interchange any two Rows & Columns in the given matrix and display resultant.

```bash
#include <stdio.h>

int main() {
    int n, i, j, r1, r2, c1, c2, temp;
    printf("Enter order of matrix: ");
    scanf("%d", &n);

    int a[n][n];
    printf("Enter matrix elements:\n");
    for(i = 0; i < n; i++)
        for(j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    printf("Enter two rows to interchange (0-based index): ");
    scanf("%d %d", &r1, &r2);
    for(j = 0; j < n; j++) {
        temp = a[r1][j];
        a[r1][j] = a[r2][j];
        a[r2][j] = temp;
    }

    printf("Enter two columns to interchange (0-based index): ");
    scanf("%d %d", &c1, &c2);
    for(i = 0; i < n; i++) {
        temp = a[i][c1];
        a[i][c1] = a[i][c2];
        a[i][c2] = temp;
    }

    printf("Matrix after interchange:\n");
    for(i = 0; i < n; i++) {
        for(j = 0; j < n; j++)
            printf("%d ", a[i][j]);
        printf("\n");
    }

    return 0;
}

```
