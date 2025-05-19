public class Mahasiswa {
    private final String nama = "Naila Al Inayah";
    private final String nim = "202410370110052";

    public boolean login(String inputNama, String inputNim) {
        return nama.equals(inputNama) && nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("\nInformasi Mahasiswa:");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}



