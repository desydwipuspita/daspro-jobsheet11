import java.util.Scanner;

public class hitungTotalHarga03Modifikasi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalKeseluruhan = 0;

        System.out.println("========== MENU RESTO KAFE ==========");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuchino - Rp 20,000");
        System.out.println("3. Latte - Rp  22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 10,000");
        System.out.println("======================================");
        System.out.println("Silahkan pilih menu yang anda inginkan");

        while (true) {
 
            System.out.print("\nMasukkan nomor menu yang ingin anda pesan (atau ketik 0 untuk selesai): ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu == 0) {
                break;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();
            System.out.print("Masukkan kode promo (jika ada): ");
            sc.nextLine();
            String kodePromo = sc.nextLine();

            int totalHarga = hitungTotalHarga20(pilihanMenu, banyakItem, kodePromo);
            totalKeseluruhan += totalHarga;

            System.out.println("Total harga untuk pesanan anda: Rp" + totalHarga);
        }

        System.out.println("Total keseluruhan pesanan: Rp" + totalKeseluruhan);
    }

    public static int hitungTotalHarga20(int pilihanMenu, int banyakItem, String kodePromo) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        if (pilihanMenu < 1 || pilihanMenu > hargaItems.length) {
            System.out.println("Pilihan menu tidak valid.");
            return 0;
        }

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            hargaTotal = hargaTotal / 2;
            System.out.println("Anda mendapat diskon 50%.");
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            hargaTotal = (int)(hargaTotal * 0.7);
            System.out.println("Anda mendapat diskon 30%.");
        } else {
            System.out.println("Kode promo invalid. Tidak ada pengurangan total harga.");
        }
        return hargaTotal;
    }
}