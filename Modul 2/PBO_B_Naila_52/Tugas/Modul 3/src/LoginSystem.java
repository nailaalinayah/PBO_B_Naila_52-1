import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin Utama", "0052", "admin", "admin052");
        Mahasiswa mahasiswa = new Mahasiswa("Naila", "202410370110052");

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih menu (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                if (admin.login(username, password)) {
                    admin.displayInfo();
                } else {
                    System.out.println("Login Admin gagal. Username atau password salah.");
                }
                break;

            case 2:
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                if (mahasiswa.login(nama, nim)) {
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login Mahasiswa gagal. Nama atau NIM salah.");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
