public class Obat {
    String nama;
    int stok;
    double harga;

    public Obat(String nama, int stok, double harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String toString() {
        return "Nama: " + nama + ", Stok: " + stok + ", Harga: " + harga;
    }
}
