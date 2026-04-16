#include <stdio.h>
#include <math.h>

int main() {
    int digits, i, num = 0, place;
    printf("Enter number of digits: ");
    scanf("%d", &digits);

    for (i = digits - 1; i >= 0; i--) {
        printf("Enter digit for %d's place: ", (int)pow(10, i));
        scanf("%d", &place);
        num = num * 10 + place;
    }

    printf("The number is: %d\n", num);
    return 0;
}
