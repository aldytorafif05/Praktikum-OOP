public final class PairComparator {
    private PairComparator() {
    }

    // TODO:
    // 1. Lengkapi parameter generik method yang merupakan kelas-kelas yang
    // menerapkan interface Comparable
    // 2. Lengkapi parameter generik dari pair yang dibandingkan
    public static <T extends Comparable<T>, R extends Comparable<R>> boolean isGreater(Pair<T, R> p1, Pair<T, R> p2) {
        // TODO:
        // 1. Bandingkan elemen pertama dan kedua antar pair menggunakan compareTo().
        // 2. Kembalikan true hanya jika kedua perbandingan menunjukkan p1 lebih besar dari p2.
        // ...
        return ((p1.getFirst().compareTo(p2.getFirst()) > 0) && (p1.getSecond().compareTo(p2.getSecond()) > 0));
    }
}
