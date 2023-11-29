#include <stdio.h>
#include <stdlib.h>

int main() {
    // Crear un array de URLs
    char *urls[] = {
            "http://www.google.com",
            "http://www.marca.com",
            "http://www.elpais.com"
    };
    int num_urls = sizeof(urls) / sizeof(char *);

    // Crear una cadena para el comando
    char cmd[512];

    // Ejecuta firefox y chromium con cada URL
    for (int i = 0; i < num_urls; i++) {
        sprintf(cmd, "firefox %s &", urls[i]);
        system(cmd);
        sprintf(cmd, "chromium %s &", urls[i]);
        system(cmd);
    }

    return 0;
}
