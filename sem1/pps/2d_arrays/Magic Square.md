### Check whether the given matrix is magic square or not

```bash
#include <stdio.h>

int main() {
    int n, i, j, sumDiag1 = 0, sumDiag2 = 0, magic = 1;
    printf("Enter order of square matrix: ");
    scanf("%d", &n);

    int a[n][n];
    printf("Enter matrix elements:\n");
    for(i = 0; i < n; i++)
        for(j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    for(i = 0; i < n; i++)
        sumDiag1 += a[i][i];
    for(i = 0; i < n; i++)
        sumDiag2 += a[i][n-1-i];

    if(sumDiag1 != sumDiag2)
        magic = 0;

    for(i = 0; i < n && magic; i++) {
        int rowSum = 0, colSum = 0;
        for(j = 0; j < n; j++) {
            rowSum += a[i][j];
            colSum += a[j][i];
        }
        if(rowSum != sumDiag1 || colSum != sumDiag1) {
            magic = 0;
            break;
        }
    }

    if(magic)
        printf("Matrix is a Magic Square\n");
    else
        printf("Matrix is Not a Magic Square\n");

    return 0;
}

```
