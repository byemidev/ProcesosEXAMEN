#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
//El proceso padre va crear un hijo se va a crear un pipe entre el padre y el hijo (2 puntos.).

//El hijo va a crear otro hijo(hijo2 o nieto como querais), 
//ese hijo va tener una variable que guarde un numero alatorio entre 1 y 20. 
//Debe mostrar ciclo1 me duermo, ciclo 2 me duermo.... cada ciclo se debe dormir un segundo (1punto)

//El hijo debe esperar por su (hijo2 nieto) y cuando acabe mandar 30 mensajes de 
//la forma mensaje-hijo 1, mensaje-hijo 2, mensaje-hijo 3.
//cuando termine de mandar los mensajes debera dormir de forma aleatoria entre 1 y 10 segundos....

//El padre cada mensaje recibido debe mostrar "recibido: mensaje-hijo 1" cada vez que llegue.
//Cuando acabe de esperar por que acabe el hijo y mostrar el "hijo ha finalizado". (2 puntos)

int main(){

int pipe_fd[2]; // pipe_fd[0] lectura , pipe_fd[1] escritura
char buffer[100];
pid_t hijo;

hijo = fork();
switch (hijo)
{
case -1: //no se pudo crear 
perror("error al crear hijo");
exit(EXIT_FAILURE);
    break;
case 0://hijo
    close(pipe_fd[0]); //cerrar lectura
    char message[] = "hola es un pipe";
    write(pipe_fd[1], message, strlen(message) + 1);
    printf("Soy el hijo con pid %d\n", hijo);
    
    for(int i = 0; i <=30; i++){
    printf("mensaje-hijo %d\n", i);
    }
    sleep(rand () % (10-1+1));
        pid_t nieto = fork();
        if(nieto==1){//nieto
            int N = 20;
            int M = 1;
            int numero;
            numero = rand () % (N-M+1) + M;
            printf("numero aleatorio %d", numero);
            for(int i = 0; i < numero; i++){
                printf("Ciclo%d me duermo", i);
                sleep(1000);
            }
        }else if(nieto>0){
        //hijo
        read(pipe_fd[0], buffer, sizeof(buffer));
        wait(NULL);
        printf("mi nieto a terminado");
        }else{//hijo
        perror("error creacion nieto");
        exit(EXIT_FAILURE);
        }
default://padre
close(pipe_fd[1]);//cerrar la escritura
printf("Soy el padre %d\n", getpid());
printf("Mi hijo a termiando");
    break;
}

    return 0;
}