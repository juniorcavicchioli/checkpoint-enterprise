package br.com.fiap.checkpoint.config;

import br.com.fiap.checkpoint.models.*;
import br.com.fiap.checkpoint.repositories.ArtistRepository;
import br.com.fiap.checkpoint.repositories.CustomerRepository;
import br.com.fiap.checkpoint.repositories.GenreRepository;
import br.com.fiap.checkpoint.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    TrackRepository trackRepository;

    List<TrackArtist> listTrackArtist = new ArrayList<>();
    List<Album> listAlbum = new ArrayList<>();
    List<GenreTrack> listGenreTrack = new ArrayList<>();
    List<Purchase> listPurchase = new ArrayList<>();
    List<AlbumTrack> listAlbumTrack = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        artistRepository.saveAll(List.of(
                new Artist(1L, "Billie Eilish", "Pop", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(2L, "Brothers of Metal", "Metal", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(3L, "Aline Barros", "Gospel", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(4L, "Iron Maiden", "Rock", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(5L, "Beast In Black", "Metal", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(6L, "Henrique e Juliano", "Sertanejo", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(7L, "Ariana Grande", "Pop", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(8L, "Lady Gaga", "Pop", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(9L, "Barões da Pisadinha", "Piseiro", listTrackArtist, listTrackArtist, listAlbum),
                new Artist(10L, "Zé Vaqueiro", "Piseiro", listTrackArtist, listTrackArtist, listAlbum)
        ));

        genreRepository.saveAll(List.of(
                new Genre(1L, "Pop", listGenreTrack),
                new Genre(2L, "Metal", listGenreTrack),
                new Genre(3L, "Gospel", listGenreTrack),
                new Genre(4L, "Rock", listGenreTrack),
                new Genre(5L, "Sertanejo", listGenreTrack),
                new Genre(6L, "Piseiro", listGenreTrack)
        ));

        customerRepository.saveAll(List.of(
                new Customer("exemplo@exemplo.com", "Fulano", "12345678", 15, "Card Information", "IP Address", "Computer", listPurchase),
                new Customer("outroexemplo@exemplo.com", "Ciclano", "87654321", 18, "Card Information", "IP Address", "Cellphone", listPurchase),
                new Customer("maisumexemplo@exemplo.com", "Deltrano", "abcdefgh", 23, "Card Information", "IP Address", "Tablet", listPurchase),
                new Customer("jose@exemplo.com", "José", "12345678", 81, "Card Information", "IP Address", "Computer", listPurchase),
                new Customer("matheus@exemplo.com", "Matheus", "12345678", 20, "Card Information", "IP Address", "Computer", listPurchase),
                new Customer("douglas@exemplo.com", "Douglas", "12345678", 16, "Card Information", "IP Address", "Tablet", listPurchase),
                new Customer("sheila@exemplo.com", "Sheila", "12345678", 45, "Card Information", "IP Address", "Computer", listPurchase)
        ));

        trackRepository.saveAll(List.of(
                new Track(
                        1L, "Deus Nos Amou", Duration.ofMinutes(3).plusSeconds(20),
                        128, 9.99, "Portuguese", "Lucas", "Aline Barros",
                        LocalDate.of(2006, 3, 18), listPurchase, listGenreTrack, listTrackArtist, listAlbumTrack
                ),
                new Track(
                        2L, "Njord", Duration.ofMinutes(3).plusSeconds(59),
                        167, 200, "English", "Lucas", "Brothers Of Metal",
                        LocalDate.of(2019, 10, 18), listPurchase, listGenreTrack, listTrackArtist, listAlbumTrack
                ),
                new Track(
                        3L, "Esquema Preferido", Duration.ofMinutes(3).plusSeconds(20),
                        167, 200, "Portuguese", "Zé", "Zé",
                        LocalDate.of(2019, 10, 18), listPurchase, listGenreTrack, listTrackArtist, listAlbumTrack
                ),
                new Track(
                        4L, "Galinha Pintadinha", Duration.ofMinutes(3).plusSeconds(59),
                        167, 200, "Portuguese", "Galinha", "Brothers Of Metal",
                        LocalDate.of(2019, 10, 18), listPurchase, listGenreTrack, listTrackArtist, listAlbumTrack
                ),
                new Track(
                        5L, "Blind And Frozen", Duration.ofMinutes(5).plusSeconds(16),
                        167, 200, "English", "Lucas", "Brothers Of Metal",
                        LocalDate.of(2017, 3, 11), listPurchase, listGenreTrack, listTrackArtist, listAlbumTrack
                )
        ));
    }
}
