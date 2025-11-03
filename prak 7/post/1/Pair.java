// TODO:
// Lengkapi parameter generik dari kelas Pair.
// Note: disarankan parameter generik dalam kelas ini tidak perlu menggunakan bounded generic
public final class Pair<T, R> {
    private T first;
    private R second;

    public Pair(T first, R second) {
    // TODO:
    // 1. Simpan parameter first dan second
    this.first = first;
    this.second = second;
    }

    public T getFirst() {
        // TODO:
        // 1. Kembalikan nilai elemen pertama dari pair.
        // ...
        return first;
    }

    public R getSecond() {
        // TODO:
        // 1. Kembalikan nilai elemen kedua dari pair.
        // ...
        return second;
    }
}
