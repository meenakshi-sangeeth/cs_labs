#include <stdio.h>
#include <math.h>

int main() {
    int n;
    double x, term, sum = 0;
    printf("Enter x in degrees: ");
    scanf("%lf", &x);
    printf("Enter number of terms: ");
    scanf("%d", &n);

    x = x * M_PI / 180; // Convert to radians

    for (int i = 0; i < n; i++) {
        term = pow(-1, i) * pow(x, 2*i + 1) / tgamma(2*i + 2); // tgamma(k+1) = k!
        sum += term;
    }

    printf("sin(x) = %lf\n", sum);
    return 0;
}
