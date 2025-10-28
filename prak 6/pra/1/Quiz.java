import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {
    // TODO: Deklarasikan field untuk menyimpan daftar pertanyaan
    private List<Question> questions;

    public Quiz() {
        // TODO: Inisialisasi daftar pertanyaan
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        // TODO: Tambahkan pertanyaan ke daftar
        questions.add(question);
    }

    public void displayAllQuestions() {
        // TODO: Iterasi setiap pertanyaan dan tampilkan dengan format "Pertanyaan
        // x:<newline>" lalu detailnya dengan memanggil question.display() dan tambahkan
        // juga 1 newline setelah pemanggilan fungsi display
        for (Question q: questions){
            System.out.println("Pertanyaan x:");
            q.display();
            System.out.println();
        }
    }

    public boolean checkAnswer(int questionIndex, int selectedOptionNumber) {
        // TODO: Validasi indeks pertanyaan, jike tidak valid maka keluarkan output:
        // "Question index out of bounds<newline>"
        // kemudian return false
        // TODO: Ambil pertanyaan berdasarkan indeks
        // TODO: Periksa apakah nomor opsi valid, jika tidak valid keluarkan output:
        // "Selected option is not available<newline>"
        // kemudian return false
        // TODO: Kembalikan hasil pemeriksaan jawaban benar
        if (questionIndex > questions.size()){
            System.out.println("Question index out of bounds");
            return false;
        }
        else{
            Question selectedQuestion = questions.get(questionIndex);
            if (!selectedQuestion.isValidOption(selectedOptionNumber)){
                System.out.println("Selected option is not available");
                return false;
            }
            else {
                return selectedQuestion.isCorrect(selectedOptionNumber);
            }
        }
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public int size() {
        // TODO: Mengembalikan jumlah pertanyaan dalam kuis
        return questions.size();
    }
}
