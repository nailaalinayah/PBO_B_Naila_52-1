 //Subclass Musuh
 class Musuh extends KarakterGame {
    Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    //Override method serang() utuk serangan musuh
     @Override
     void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        //mengurangi kesehatan target sebanyak 15 poin
        target.setKesehatan(target.getKesehatan() - 15);
        //menampilkan kesehtan terbaru target
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
     }
}
