package perpustakaan;

public interface Peminjaman {
    void kembalikanBuku(String judul);
    void pinjamBuku(String judul);
    void pinjamBuku(String judul, int durasi);
}
