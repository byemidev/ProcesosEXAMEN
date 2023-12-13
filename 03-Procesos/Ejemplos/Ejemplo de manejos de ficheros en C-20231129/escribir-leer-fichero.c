#include <stdio.h>
#include <stdlib.h>


int main() {
    FILE *file;
    char buffer[100];

    // 1. Abrir archivo para escritura
    file = fopen("test.txt", "w");
    if (file == NULL) {
        perror("fopen");
        exit(EXIT_FAILURE);
    }

    // 2. Escribir en el archivo
    fprintf(file, "Hola, Mundo!\n");
    
    // 3. Cerrar el archivo
    fclose(file);

    // 4. Abrir archivo para lectura
    file = fopen("test.txt", "r");
    if (file == NULL) {
        perror("fopen");
        exit(EXIT_FAILURE);
    }

    // 5. Leer del archivo
    if (fgets(buffer, sizeof(buffer), file) != NULL) {
        printf("Contenido del archivo: %s", buffer);
    } else {
        printf("No se pudo leer del archivo\n");
    }
    
    // 6. Cerrar el archivo
    fclose(file);
    return 0;
}
