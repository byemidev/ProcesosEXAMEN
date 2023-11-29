#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> //para sleep

#define BUFFER_SIZE 1024

int main() {
    FILE *file;
    char buffer[BUFFER_SIZE];

    // Abrir archivo para lectura
    file = fopen("quijote.txt", "r");
    if (file == NULL) {
        perror("Error al abrir el archivo");
        return EXIT_FAILURE;
    }

    // Leer el archivo línea por línea
    while (fgets(buffer, BUFFER_SIZE, file) != NULL) {
        printf("%s", buffer);
        sleep(2);
    }

    // Cerrar el archivo
    if (fclose(file) != 0) {
        perror("Error al cerrar el archivo");
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
