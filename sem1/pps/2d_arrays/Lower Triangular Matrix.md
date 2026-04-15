### Check whether the given matrix is a Lower triangular matrix or not

```bash
#include <stdio.h>

int main() {
    int n, i, j, flag = 1;
    printf("Enter order of matrix: ");
    scanf("%d", &n);

    int a[n][n];
    printf("Enter matrix elements:\n");
    for(i = 0; i < n; i++)
        for(j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    for(i = 0; i < n; i++)
        for(j = i+1; j < n; j++)
            if(a[i][j] != 0) {
                flag = 0;
                break;
            }

    if(flag)
        printf("Matrix is Lower Triangular\n");
    else
        printf("Matrix is Not Lower Triangular\n");

    return 0;
}

```
