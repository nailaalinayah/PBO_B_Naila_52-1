//kelas RekeningBank
public class RekeningBank {
    // atribut
    String nomorRekening;
    String namaPemilik;
    double saldo;

    // konstruktor
    public RekeningBank(String noRek, String nama, double saldoAwal){
        nomorRekening = noRek;
        namaPemilik = nama;
        saldo = saldoAwal;
    }
    // method untuk menampilkan informasi rekening
    public void tampilkanInfo(){
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo);
        System.out.println();
    }
    // method untuk setor uang
    public void setorUang(double jumlah) {
        // tambahkan jumlah ke saldo
        saldo += jumlah;
        System.out.print(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
        System.out.println();
    }
    // method untuk tarik uang
    public void tarikUang(double jumlah){
        // mengecek apakah saldo cukup untuk penarikan
        if (jumlah <= saldo) {
            saldo -= jumlah; // kurangi jumlah dari saldo
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) saldo sekarang: Rp" + saldo);
        } else {
            System.out.print( namaPemilik + " menarik Rp" + jumlah + ". (Gagal, saldo tidak mencukupi) saldo saat ini: Rp" + saldo);
        }
        System.out.println();
    }
}
