import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    // TODO: Deklarasikan field untuk menyimpan teks pertanyaan
    // TODO: Deklarasikan field untuk daftar Option
    // TODO: Deklarasikan field untuk indeks jawaban yang benar
    private String pertanyaan;
    private List<Option> options;
    private int indeks;

    public Question(String text) {
        // TODO: Inisialisasi teks pertanyaan dan struktur data daftar option
        // TODO: Atur nilai awal indeks jawaban benar (misalnya -1)
        this.pertanyaan = text;
        options = new ArrayList<>();
        indeks = -1;
    }

    public void addOption(String optionText, boolean correct) {
        // TODO: Buat objek Option baru menggunakan inner class
        // TODO: Tambahkan option ke dalam daftar
        // TODO: Jika parameter correct true, perbarui indeks jawaban benar
        Option option = new Option(optionText);
        options.add(option);
        if (correct){
            indeks = options.size() - 1;
        }
    }

    public void display() {
        // TODO: Cetak teks pertanyaan yang diakhiri newline
        // TODO: Iterasi seluruh option dan tampilkan dengan format "nomor.
        // teks<newline>"
        System.out.println(pertanyaan);
        int nomor = 1;
        for (Option o : options){
            System.out.println(nomor + ". " + o.getText());
            nomor++;
        }
    }

    public boolean isCorrect(int selectedOptionNumber) {
        // TODO: Konversi nomor 1-based menjadi indeks 0-based dan bandingkan dengan
        // jawaban benar yang disimpan di dalam kelas
        selectedOptionNumber -= 1;
        if (selectedOptionNumber == indeks){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isValidOption(int selectedOptionNumber) {
        // TODO: Periksa apakah nomor opsi berada dalam rentang indeks daftar option
        return (selectedOptionNumber - 1) < options.size();
    }

    public List<Option> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public class Option {
        // TODO: Deklarasikan field untuk menyimpan teks option
        private String text;

        private Option(String text) {
            // TODO: Simpan teks option pada field yang sesuai
            this.text = text;
        }

        public String getText() {
            // TODO: Mengembalikan teks option
            return this.text;
        }
    }
}
