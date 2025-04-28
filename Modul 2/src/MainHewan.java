// kelas Main untuk masuk program
public class MainHewan {
    public static void main(String[] args) {

        // membuat objek hewan1 dengan nama "kucing", jenis "mamalia", dan suara "nyann~~"
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");

        // membuat objek hewan2 dengan nama "anjing", jenis "mamalia", suara "woof-woof!!"
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-woof!!");

        // memamnggil mmetode tampilkanInfo() untuk masing" objek agar informasi ditampilkan
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();

    }
}