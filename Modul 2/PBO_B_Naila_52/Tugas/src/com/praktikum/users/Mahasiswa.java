package com.praktikum.users;

import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return this.getNama().equals(inputNama) && this.getNim().equals(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil! ");
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Laporan Barang ---");
        System.out.print("Nama Barang: ");
        String ItemName = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String Description = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String Location = scanner.nextLine();
        System.out.println();

        // Membuat objek item baru
        Item item = new Item(ItemName, Description, Location);

        // Menambahkan item ke reportedItems yang static
        LoginSystem.reportedItems.add(item);

        System.out.println("Barang berhasil dilaporkan: " + ItemName + ", Deskripsi: " + Description + ", Lokasi: " + Location);
    }

    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else {
            for (Item item : LoginSystem.reportedItems) {
                if (item.getStatus().equals("Reported")) {
                    System.out.println("Nama Barang: " + item.getItemName());
                    System.out.println("Deskripsi: " + item.getDescription());
                    System.out.println("Lokasi: " + item.getLocation());
                    System.out.println("Status: " + item.getStatus());
                    System.out.println("----------------------------");
                }
            }
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih aksi (0-2): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
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
