package edu.curso2.desafioaudio;

import edu.curso2.desafioaudio.modelos.MinhasPreferidas;
import edu.curso2.desafioaudio.modelos.Musica;
import edu.curso2.desafioaudio.modelos.Podcast;

public class Main {

    public static void main(String[] args) {

        Musica minhaMusica = new Musica();
        minhaMusica.setTitulo("Forever");
        minhaMusica.setCantor("Kiss");

        for ( int i = 0; i < 100; i++) {

            minhaMusica.reproduzir();
        }

        for ( int f = 0; f < 50; f++) {

            minhaMusica.curtir();
        }

        Podcast meuPodcast = new Podcast();
        meuPodcast.setTitulo("Café&&Código");
        meuPodcast.setApresentador("Edinho");

        for (int j = 0; j < 5000; j++) {

            meuPodcast.reproduzir();
        }

        for (int k = 0; k < 1000; k++) {

            meuPodcast.curtir();
        }

        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.incluir(minhaMusica);
        preferidas.incluir(meuPodcast);
    }
}
