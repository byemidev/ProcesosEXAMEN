/*
Crea un programa que tenga una variable con un valor de 10.
El proceso hijo debe restar a la variable 5 y mostrarla por pantalla.
El proceso padre debe sumarle 7 y mostrarlo por pantalla.
Entrega el programa.c
*/

#include <stdio.h>
#include <unistd.h>

int main() {
    pid_t pid = fork(); // Crea un nuevo proceso
    int var=10;
    if (pid < 0) { // Error al crear el proceso
        perror("fork");
        return 1;
    } else if (pid == 0) { // Proceso hijo
        printf("Soy el proceso hijo! la variable vale %d\n",(var-5));
    } else { // Proceso padre
        printf("Soy el proceso padre, la variable vale %d\n",(var+7));
    }
    
    return 0;
}