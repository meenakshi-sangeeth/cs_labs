## Delete all the occurrences of the element present in the array which is inputted by the user

```bash
#include <stdio.h>

int main() {
    int n, key, i, j;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter elements:\n");
    for (i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Enter element to delete: ");
    scanf("%d", &key);

    for (i = 0; i < n; i++) {
        if (arr[i] == key) {
            for (j = i; j < n-1; j++)
                arr[j] = arr[j+1];
            n--;
            i--;
        }
    }

    printf("Array after deletion: ");
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
    return 0;
}

```
