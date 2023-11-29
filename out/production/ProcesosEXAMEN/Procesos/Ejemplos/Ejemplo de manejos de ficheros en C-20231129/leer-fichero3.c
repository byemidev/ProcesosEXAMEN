#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFFER_SIZE 1024

int main() {
    FILE *file;
    char buffer[BUFFER_SIZE];
    //Creamos un puntero para guardar el string
    char *contenido = NULL;
    size_t contenido_size = 0;

    // Abrir archivo para lectura
    file = fopen("quijote.txt", "r");
    if (file == NULL) {
        perror("Error al abrir el archivo");
        return EXIT_FAILURE;
    }

    // Leer el archivo línea por línea y almacenar en 'contenido'
    while (fgets(buffer, BUFFER_SIZE, file) != NULL) {
        //vemos cuando bits se han guardado en el buffer
        size_t buffer_len = strlen(buffer);
        //Realloc aumenta el tamaño del puntero(string) para que podamos guardar el buffer
        char *nuevo_contenido = realloc(contenido, contenido_size + buffer_len + 1);

        if (nuevo_contenido == NULL) {
            perror("Error al aumentar memoria");
            free(contenido);
            fclose(file);
            return EXIT_FAILURE;
        }

        contenido = nuevo_contenido;
        strcpy(contenido + contenido_size, buffer);
        contenido_size += buffer_len;
    }

    // Cerrar el archivo
    if (fclose(file) != 0) {
        perror("Error al cerrar el archivo");
        free(contenido);
        return EXIT_FAILURE;
    }

    // Imprimir el contenido almacenado
    if (contenido != NULL) {
        printf("Contenido del archivo:\n%s", contenido);
        //Liberamos la memoria
        free(contenido);
    } else {
        printf("El archivo está vacío o ocurrió un error al leerlo.\n");
    }

    return EXIT_SUCCESS;
}
