//Subclass Pahlawan
class Pahlawan extends KarakterGame {
   //konstruktor yang memanggil superclass
    Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    //Override method serang() untuk serangan Pahlawan
    @Override
    void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        //mengurangi kesehtan target sebanyak 20 poin
        target.setKesehatan(target.getKesehatan() - 20);
        //menampilkan kesehatan terbaru target
        System.out.print(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}
