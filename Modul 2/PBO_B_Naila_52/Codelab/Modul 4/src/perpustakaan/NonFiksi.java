package perpustakaan;

public class NonFiksi extends Buku {
    private final String bidang;
    public NonFiksi(String judul, String penulis, String bidang) {
        super(judul, penulis);
        this.bidang = bidang;
    }

    public void displayInfo() {
        System.out.println("Buku Non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: " + bidang + ")");
    }
}
