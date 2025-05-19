// kelas main untuk program utama
public class MainRekeningBank {
    public static void main(String[] args) {
        // buat objek rekening1 dengan informasi rekening sendiri
        RekeningBank rekening1 = new RekeningBank("20241037010052", "Naila Al Inayah", 500000);
        // buat objek rekening2 dengan informasi rekenning teman
        RekeningBank rekening2 = new RekeningBank("202410370110003", "Dian Octavian", 1000000);

        rekening1.tampilkanInfo(); // menampilkan informasi rekening1
        rekening2.tampilkanInfo(); // menampilkan informasi rekening2

        rekening1.setorUang(200000); // menyetor uang ke rekening1
        rekening2.setorUang(500000); // menyetor uang ke rekening2

        rekening1.tarikUang(800000); // menarik uang dari rekening 1
        rekening2.tarikUang(300000); // menarik uang dari rekening 2

        // menampilkan informasi
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
