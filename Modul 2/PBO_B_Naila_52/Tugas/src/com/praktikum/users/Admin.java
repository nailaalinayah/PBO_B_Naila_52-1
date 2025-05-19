package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

public class Admin extends User implements AdminActions {
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password) {
        super (nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Role: Admin");
        System.out.println("Login berhasil sebagai Admin!");
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali: ");
            System.out.print("Pilih Menu (0-2): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    viewAllReportedItems();
                    break;
                case 2:
                    markItemClaimed();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama Admin...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
    public void viewAllReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else {
            for (Item item : LoginSystem.reportedItems){
                System.out.println("Nama Barang: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("Status: " + item.getStatus());
                System.out.println("================================");
            }
        }
    }
    public void markItemClaimed() {
        Scanner scanner = new Scanner(System.in);
        int indeks = 1;
        boolean foundReported = false;

        for (Item item : LoginSystem.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println(indeks + ". " + item.getItemName() + " - " + item.getStatus());
                indeks++;
                foundReported = true;
            }
        }
        if (!foundReported) {
            System.out.println("Tidak ada barang yang statusnya 'Reported'.");
            return;
        }
        System.out.println("Masukkan no indeks barang yang ingin ditandai.");
        try {
            int itemIndeks = scanner.nextInt() - 1;
            if (itemIndeks >= 0 && itemIndeks < LoginSystem.reportedItems.size()) {
                Item selectedItem = LoginSystem.reportedItems.get(itemIndeks);
                if (selectedItem.getStatus().equals("Reported")) {
                    selectedItem.setStatus("Claimed");
                    System.out.println("Barang " + selectedItem.getItemName() + "telah ditandai sebagai 'Claimed'.");
                } else {
                    System.out.println("Barang ini sudah tidak bisa diklaim.");
                }
            } else {
                System.out.println("Indeks tidak valid.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Terjadi kesalahan ketika input.");
        }
        catch (InputMismatchException e) {
            System.out.println("angka....");
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n--- Menu Kelola Mahasiswa ---");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih aksi (0-2): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    addMahasiswa();
                    break;
                case 2:
                    removeMahasiswa();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama Admin...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    public void addMahasiswa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();

        Mahasiswa newMahasiswa = new Mahasiswa(nama, nim);
        LoginSystem.userList.add(newMahasiswa);
        System.out.println("Mahasiswa " + nama + " berhasil ditambahkan.");
    }

    // Menghapus mahasiswa dari userList berdasarkan NIM
    public void removeMahasiswa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();

        Iterator<User> iterator = LoginSystem.userList.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user instanceof Mahasiswa mahasiswa) {
                if (!mahasiswa.getNim().equals(nim)) {
                    continue;
                }
                iterator.remove();
                found = true;
                System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                break;
            }
        }
        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih aksi (0-2): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Logout berhasil!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
}