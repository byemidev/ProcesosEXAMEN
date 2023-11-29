#include <stdio.h>
#include <unistd.h>

int main(){
    int diez = 456;
    pid_t pid = fork();

    if (pid  < 0){
        perror("fork");
        return 1;
    }
    else if(pid == 0){
        int menos = diez-32;
        printf("Soy el hijo y la variable ahora vale %d\n", menos);
    }else{
        int mas = diez + 120;
        printf("Soy el padre y la variable ahora vale %d\n", mas);
    }
    return 0;
}