//Kelas main untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        //membuat objek dari masing-masing kelas
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone ", 150);
        Musuh viper = new Musuh("Viper ", 200);

        //menampilkan status awal kesehatan pahlawan dan musuh
        System.out.println("Status Awal: ");
        System.out.println(brimstone.getNama() + "memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.print(viper.getNama() + "memiliki kesehatan: " + viper.getKesehatan());
        System.out.println();

        //Simulasi pertarungan
        brimstone.serang(viper);//Brimstone menyerang Viper
        System.out.println();
        viper.serang(brimstone);//viper menyerang Brimstone
    }
}