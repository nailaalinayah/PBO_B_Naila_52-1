package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();
    public static void main(String[] args) {
        Admin admin = new Admin("Admin", "052", "Admin052", "Password052");
        Mahasiswa mahasiswa = new Mahasiswa("Naila", "202410370110052");
        userList.add(admin);
        userList.add(mahasiswa);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih login: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Keluar");
        int pilih = -1;
        while (pilih < 1 || pilih > 3) {
            try {
                System.out.print("Masukkan pilihan: ");
                pilih = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka 1/2/3.");
                scanner.nextLine(); // Membersihkan input yang salah
            }
        }


        User user = null;
        if (pilih == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String pass = scanner.nextLine();
            if (admin.login(username, pass)) {
                admin.displayInfo();
                user = admin;
            } else {
                System.out.println("Login gagal! Username atau Password salah.");
            }
        } else if (pilih == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            if (mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo();
                user = mahasiswa;
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Anda telah keluar dari program...");
        }

        // Polimorfisme: Memanggil displayAppMenu() berdasarkan role
        if (user != null) {
            user.displayAppMenu();
        }

        scanner.close();
    }
}