### Define a structure for a product with members for product ID, name, and price. Write a program to create array of products using pointers, input their details, and display them. (Use the concept of pointers and structures).

```bash
#include <stdio.h>

struct Product {
    int id;
    char name[50];
    float price;
};

int main() {
    int n, i;
    printf("Enter number of products: ");
    scanf("%d", &n);

    struct Product p[n];
    struct Product *ptr = p;

    for (i = 0; i < n; i++) {
        printf("\nEnter details for product %d\n", i + 1);
        printf("Product ID: ");
        scanf("%d", &(ptr + i)->id);
        printf("Product Name: ");
        scanf("%s", (ptr + i)->name);
        printf("Product Price: ");
        scanf("%f", &(ptr + i)->price);
    }

    printf("\nProduct Details:\n");
    for (i = 0; i < n; i++) {
        printf("ID: %d, Name: %s, Price: %.2f\n",
               (ptr + i)->id, (ptr + i)->name, (ptr + i)->price);
    }
    return 0;
}

```
