import java.util.Scanner;

public class TugasMandiri30 {
    public static void main(String[] args) {
        final int JUMLAH_RESPONDEN = 10;
        final int JUMLAH_PERTANYAAN = 6;

        Scanner sc = new Scanner(System.in);
        int[][] jawaban = new int[JUMLAH_RESPONDEN][JUMLAH_PERTANYAAN];

        for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
            System.out.println("Responden ke-" + (i + 1));
            for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
                int nilai;
                do {
                    System.out.print("Jawaban pertanyaan " + (j + 1) + " (1-5): ");
                    nilai = sc.nextInt();
                    if (nilai < 1 || nilai > 5) {
                        System.out.println("Harus antara 1 sampai 5!");
                    }
                } while (nilai < 1 || nilai > 5);
                jawaban[i][j] = nilai;
            }
        }

        System.out.println("\n=== Rata-rata per responden ===");
        double totalSemua = 0;
        for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
            double totalResponden = 0;
            for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
                totalResponden += jawaban[i][j];
            }
            totalSemua += totalResponden;
            System.out.printf("Responden %d: %.2f\n", i + 1, totalResponden / JUMLAH_PERTANYAAN);
        }

        System.out.println("\n=== Rata-rata per pertanyaan ===");
        for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
            double totalPertanyaan = 0;
            for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
                totalPertanyaan += jawaban[i][j];
            }
            System.out.printf("Pertanyaan %d: %.2f\n", j + 1, totalPertanyaan / JUMLAH_RESPONDEN);
        }

        System.out.println("\n=== Rata-rata keseluruhan ===");
        System.out.printf("%.2f\n", totalSemua / (JUMLAH_RESPONDEN * JUMLAH_PERTANYAAN));
    }
}