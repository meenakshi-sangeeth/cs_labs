## Search the position of the number that is entered by the user and delete that particular number from the array and display the resultant array elements. 

```bash
#include <stdio.h>

int main() {
    int n, pos, i;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter elements:\n");
    for (i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Enter position to delete (0-based index): ");
    scanf("%d", &pos);

    if (pos < 0 || pos >= n) {
        printf("Invalid position.\n");
        return 0;
    }

    for (i = pos; i < n-1; i++)
        arr[i] = arr[i+1];
    n--;

    printf("Array after deletion: ");
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
    return 0;
}
```
