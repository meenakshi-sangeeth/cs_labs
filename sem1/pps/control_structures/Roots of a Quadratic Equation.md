## Compute all the roots of a quadratic equation using switch case statement

```bash
#include <stdio.h>
#include <math.h>

int main() {
    double a, b, c, discriminant, root1, root2, realPart, imaginaryPart;
    int choice;

    printf("Enter coefficients a, b, and c: ");
    scanf("%lf %lf %lf", &a, &b, &c);

    discriminant = b * b - 4 * a * c;

    if (discriminant > 0)
        choice = 1;  // Real and distinct
    else if (discriminant == 0)
        choice = 2;  // Real and equal
    else
        choice = 3;  // Complex roots

    switch (choice) {
        case 1:
            root1 = (-b + sqrt(discriminant)) / (2 * a);
            root2 = (-b - sqrt(discriminant)) / (2 * a);
            printf("Roots are real and distinct: %.2lf and %.2lf\n", root1, root2);
            break;

        case 2:
            root1 = root2 = -b / (2 * a);
            printf("Roots are real and equal: %.2lf and %.2lf\n", root1, root2);
            break;

        case 3:
            realPart = -b / (2 * a);
            imaginaryPart = sqrt(-discriminant) / (2 * a);
            printf("Roots are complex: %.2lf + %.2lfi and %.2lf - %.2lfi\n",
                   realPart, imaginaryPart, realPart, imaginaryPart);
            break;

        default:
            printf("Invalid case.\n");
    }

    return 0;
}
```
