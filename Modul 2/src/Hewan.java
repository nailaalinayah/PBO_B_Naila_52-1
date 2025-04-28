public class Hewan { // mendefinisi kelas hewan
    //atribut
    String nama; //deklarasi variabel instance 'nama' dengan tipe data string
    String jenis; //deklarasi variabel instance 'jenis' dengan tipe data string
    String suara;  // deklarasi variabel instance 'suara' dengan tipe data string

    public Hewan(String nama, String jenis, String suara) { // konstruktor menginisialisasi objek hewan
        this.nama = nama; // mengisi atribut nama dengan nilai dari  parameter
        this.jenis = jenis; //mengisi atribbut jenis dengan nilai dari parameter
        this.suara = suara; // mengisi atribut suara dengan nilai dari parameter
    }
    // metode menampilkan informasi hewan
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama); // menampilkan nama hewan
        System.out.println("Jenis: " + jenis); // menampilkan jenis  hewan
        System.out.println("Suara: " + suara); // menampilkan suara hewan
        // menambahkan baris kosong untuk tampilan lebbih
        System.out.println();
    }
}

