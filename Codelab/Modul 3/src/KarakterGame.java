//Superclass KarakterGame
class KarakterGame {
    //Atribut privat untuk menyimmpan nama dan kesehatan
    private String nama;
    private int kesehatan;

    //konstruktor untuk menginisialisasii nama dan kesehatan
    KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    //Getter untuk mendapatkan nama karakter
    String getNama() {
        return nama;
    }

    //Setter untuk mengubah nilai atribut nama pada objek KarakterGame
    void setNama(String nama) {
        this.nama = nama;
    }

    //Getter untuk mendapatkan kesehatan karakter
    int getKesehatan() {
        return kesehatan;
    }

    //Setter untuk mengubah nilai kesehatan karakter
    void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    //Method serang(), akan di override oleh subclass
    void serang(KarakterGame Target) {
    }
}