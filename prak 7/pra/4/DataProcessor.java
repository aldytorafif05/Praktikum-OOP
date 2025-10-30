import java.util.List;

// TODO: Buat generic class DataProcessor<T extends Comparable<T>>
// Pertanyaan: Mengapa kita menggunakan bounded type parameter "T extends Comparable<T>"?
// Hint: Method apa yang diperlukan untuk melakukan sorting atau mencari min/max?
//       Apakah semua tipe data memiliki method tersebut secara default?
//
// Atribut yang diperlukan:
// - String processorName
//
// Method yang diperlukan:
// - Constructor(String processorName): inisialisasi processor
// - findMin(Container<T> container): mencari nilai minimum
//   * Tampilkan: "Mencari nilai minimum di [container.getName()]..."
//   * Return nilai minimum, atau null jika container kosong
//   * Hint: Bagaimana cara membandingkan dua objek untuk menentukan mana yang lebih kecil?
// - findMax(Container<T> container): mencari nilai maximum
//   * Tampilkan: "Mencari nilai maksimum di [container.getName()]..."
//   * Return nilai maximum, atau null jika container kosong
// - sort(Container<T> container): mengurutkan item dalam container (ascending)
//   * Tampilkan: "Mengurutkan data di [container.getName()]..."
//   * Hint: Pikirkan algoritma sorting sederhana yang pernah Anda pelajari.
//   * Method ini memodifikasi container secara langsung
// - getProcessorName(): return nama processor

public class DataProcessor<T extends Comparable<T>> {
    // TODO: Implementasikan class ini
    private String processorName;

    public DataProcessor(String processorName){
        this.processorName = processorName;
    }

    public T findMin(Container<T> container){
        System.out.println("Mencari nilai minimum di " + container.getName() + "...");
        if (container.size() == 0){
            return null;
        }

        T minimum = container.get(0);
        for (T item : container.getItems()){
            if (minimum.compareTo(item) > 0){
                minimum = item;
            }
        }
        return minimum;
    }

    public T findMax(Container<T> container){
        System.out.println("Mencari nilai maksimum di " + container.getName() + "...");
        if (container.size() == 0){
            return null;
        }

        T maximum = container.get(0);
        for(T item: container.getItems()){
            if (maximum.compareTo(item) < 0){
                maximum = item;
            }
        }

        return maximum;
    }

    public void sort(Container<T> container){
        System.out.println("Mengurutkan data di " + container.getName() + "...");
        List<T> sortList = container.getItems();

        for (int i = 0; i < sortList.size() - 1; i++) {
            for (int j = 0; j < sortList.size() - i - 1; j++) {
                if (sortList.get(j).compareTo(sortList.get(j + 1)) > 0) {
                    T temp = sortList.get(j);
                    sortList.set(j, sortList.get(j + 1));
                    sortList.set(j + 1, temp);
                }
            }
        }

    }

    public String getProcessorName(){
        return processorName;
    }
}

