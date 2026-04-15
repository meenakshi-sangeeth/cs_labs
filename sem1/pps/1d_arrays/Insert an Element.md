## Insert an element into a 1D array, by getting an element and the position from the user

```bash
#include <stdio.h>

int main() {
    int n, pos, element, i;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n+1];
    printf("Enter elements:\n");
    for (i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Enter position to insert (0-based index): ");
    scanf("%d", &pos);
    printf("Enter element to insert: ");
    scanf("%d", &element);

    if (pos < 0 || pos > n) {
        printf("Invalid position.\n");
        return 0;
    }

    for (i = n; i > pos; i--)
        arr[i] = arr[i-1];
    arr[pos] = element;
    n++;

    printf("Array after insertion: ");
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
    return 0;
}
```
