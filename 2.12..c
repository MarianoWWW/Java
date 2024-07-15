/*
2.12. Una farmacia vende algunos artículos sin descuento y a otros con descuento del 20%. Confeccionar un
programa que recibiendo el precio original y un código que indica si es o no con descuento, informe el
precio final (0 no aplica el descuento y 1 aplica el descuento).
*/

#include <stdio.h>
#include<stdlib.h>

int main()
{
    int COD;
    float PRECIO;
    float TOTAL=0, DESC=0;


    do {
        printf("\n\nIngrese el precio : ");
        scanf ("%f", &PRECIO);
        if (PRECIO<0)
            printf ("\n\nEs chiste? Precio negativo?");
    } while (PRECIO<0);


    do {
        printf ("\nIngrese Codigo  (0 no aplica el descuento y 1 aplica el descuento): ");
        scanf("%d", &COD);
        if (COD < 0 || COD > 1)
            printf ("\n\nCodigo erroneo, intente nuevamente.");
    } while (COD < 0 || COD > 1);
    if (COD==0)
    {
        TOTAL=PRECIO;
    }
    else
    {
        DESC=PRECIO*20/100;
        TOTAL=PRECIO-DESC;
    }
    printf ("\n\nPrecio final $ %8.2f", TOTAL);

    printf("\n\n");
    system ("pause");
    return 0;
}
