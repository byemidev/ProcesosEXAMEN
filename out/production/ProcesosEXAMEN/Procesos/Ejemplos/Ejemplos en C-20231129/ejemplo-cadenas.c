#include <stdio.h>

int main() {
    // Definir un array con dos strings.
    char* strings[] = {
        "Hola, mundo!",
        "¡Adiós, mundo!"
    };

    // Usar un bucle para imprimir cada string en el array.
    for(int i = 0; i < 2; i++) {
        printf("%s\n", strings[i]);
    }

    return 0;
}
