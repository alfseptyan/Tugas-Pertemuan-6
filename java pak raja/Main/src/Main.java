import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Obat> rakObat = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah rak: ");
        int jumlahRak = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < jumlahRak; i++) {
            rakObat.add(null);
        }
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Lihat Obat");
            System.out.println("2. Tambah Obat");
            System.out.println("3. Pindah Obat");
            System.out.println("4. Beli Obat");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
             

            switch (pilihan) {
                case 1:
                    lihatObat();
                    break;
                case 2:
                    tambahObat();
                    break;
                case 3:
                    pindahObat();
                    break;
                case 4:
                    beliObat();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void lihatObat() {
        System.out.println("\nDaftar Obat:");
        for (int i = 0; i < rakObat.size(); i++) {
            if (rakObat.get(i) != null) {
                System.out.println("Rak " + (i + 1) + ": " + rakObat.get(i));
            }
        }
    }

    static void tambahObat() {
        System.out.print("\nMasukkan Index Rak: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index < 0 || index >= rakObat.size()) {
            System.out.println("Indeks rak tidak valid.");
            return;
        }

        System.out.print("Nama Obat: ");
        String nama = scanner.nextLine();

        System.out.print("Stok Obat: ");
        int stok = scanner.nextInt();

        System.out.print("Harga Obat: ");
        double harga = scanner.nextDouble();

        Obat obatBaru = new Obat(nama, stok, harga);

        if (rakObat.get(index) != null && rakObat.get(index).harga >= harga) {
            System.out.println("Harga obat harus lebih tinggi dari obat yang sudah ada di rak.");
        } else {
            rakObat.set(index, obatBaru);
            System.out.println("Obat berhasil ditambahkan.");
        }
    }

    static void pindahObat() {
        System.out.print("\nMasukkan Index Obat yang akan dipindah: ");
        int indexAwal = scanner.nextInt() - 1;
        scanner.nextLine(); 

        System.out.print("Masukkan Index Tujuan Obat: ");
        int indexTujuan = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (indexAwal < 0 || indexAwal >= rakObat.size() || indexTujuan < 0 || indexTujuan >= rakObat.size()) {
            System.out.println("Indeks obat tidak valid.");
            return;
        }

        if (rakObat.get(indexAwal) == null) {
            System.out.println("Tidak ada obat di rak awal.");
            return;
        }

        if (rakObat.get(indexTujuan) != null) {
            System.out.println("Slot tujuan sudah terisi.");
            return;
        }

        Obat obat = rakObat.remove(indexAwal);
        rakObat.add(indexTujuan, obat);
        System.out.println("Obat berhasil dipindahkan.");
    }

    static void beliObat() {
        System.out.print("\nMasukkan Index Obat yang akan dibeli: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index < 0 || index >= rakObat.size()) {
            System.out.println("Indeks obat tidak valid.");
            return;
        }

        Obat obat = rakObat.get(index);
        if (obat == null) {
            System.out.println("Obat tidak tersedia.");
        } else if (obat.stok == 0) {
            System.out.println("Stok obat habis.");
        } else {
            obat.stok--;
            System.out.println("Obat berhasil dibeli.");
        }
    }

    static void exit() {
        int jumlahPembelian = 0;
        double hargaTotal = 0;
        for (Obat obat : rakObat) {
            if (obat != null) {
                jumlahPembelian += obat.stok;
                hargaTotal += obat.harga * obat.stok;
            }
        }
        if (jumlahPembelian > 0) {
            System.out.println("\nJumlah Obat Dibeli: " + jumlahPembelian + " - Harga Total: " + hargaTotal);
        } else {
            System.out.println("\nTetap semangat, mungkin esok akan lebih baik.");
        }
        System.exit(0);
    }
}
