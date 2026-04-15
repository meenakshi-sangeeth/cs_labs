### Compute and display the trace and norm of a given square matrix.  

```bash
#include <stdio.h>
#include <math.h>

int main() {
    int n, i, j;
    double sumSquares = 0;
    printf("Enter order of matrix: ");
    scanf("%d", &n);

    int a[n][n];
    printf("Enter matrix elements:\n");
    for(i = 0; i < n; i++)
        for(j = 0; j < n; j++) {
            scanf("%d", &a[i][j]);
            sumSquares += a[i][j] * a[i][j];
        }

    int trace = 0;
    for(i = 0; i < n; i++)
        trace += a[i][i];

    double norm = sqrt(sumSquares);

    printf("Trace = %d\n", trace);
    printf("Norm = %.2lf\n", norm);

    return 0;
}
```
