import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.InputMismatchException;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        daftarBarang.add(new Barang("Buku", 50));
        daftarBarang.add(new Barang("Pensil", 10));
        daftarBarang.add(new Barang("Pulpen", 5));

        while (true) {
            System.out.println("\n=== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok");
            System.out.println("4. Keluar");
            System.out.println("Pilih Menu (1-4):");

            int pilihan = 0;
            try {
                pilihan = scanner.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("pilihan tidak valid.");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahBarangBaru(daftarBarang, scanner);
                    break;
                case 2:
                    tampilkanSemuaBarang(daftarBarang);
                    break;
                case 3:
                    kurangiStokBarang(daftarBarang, scanner);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid:)");
            }
        }
    }
    private static void tambahBarangBaru(ArrayList<Barang> daftarBarang, Scanner scanner) {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.next();
        System.out.print("Masukkan stok barang: ");
        int stok = 0;

        try {
            stok = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("input stok harus angka.");
            scanner.nextLine();
            return;
        }

        daftarBarang.add(new Barang(nama, stok));
        System.out.println("Barang berhasil ditambahkan!");
    }
    public static void tampilkanSemuaBarang(ArrayList<Barang> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("tidak ada barang.");
        } else {
            Iterator<Barang> iterator = daftarBarang.iterator();
            while (iterator.hasNext()) {
                Barang barang = iterator.next();
                System.out.println("Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
            }
        }
    }
    public static void kurangiStokBarang(ArrayList<Barang> daftarBarang, Scanner scanner) {
        if (daftarBarang.isEmpty()) {
            System.out.println("kosong.");
            return;
        }

        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println(i + ". " + daftarBarang.get(i).getNama() + " - Stok: " + daftarBarang.get(i).getStok());
        }

        System.out.print("Masukkan nomor indeks barang yang akan dikurangi stoknya: ");
        int indeks = 0;
        try {
            indeks = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println();
            scanner.nextLine();
            return;
        }

        if (indeks < 0 || indeks >= daftarBarang.size()) {
            System.out.println();
            return;
        }

        System.out.print("Masukkan jumlah stok yang akan diambil: ");
        int jumlahDiambil = 0;
        try {
            jumlahDiambil = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println();
            scanner.nextLine();
            return;
        }

        Barang barang = daftarBarang.get(indeks);

        try {
            if (jumlahDiambil > barang.getStok()) {
                throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
            }
            barang.setStok(barang.getStok() - jumlahDiambil);
            System.out.println("Stok " + barang.getNama() + " berhasil dikurangi!");
        } catch (StokTidakCukupException e) {
            System.out.println(e.getMessage());
        }
    }
}

