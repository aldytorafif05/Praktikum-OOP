import java.util.List;

public class TrainBookingSystem {
    private List<Train> trains;
    private BookingManager bookingManager;

    /*
     * Konstruktor Kelas TrainBookingSystem
     * TODO: Lengkapi state awal dari attribut TrainBookingSystem
     *      - Inisialisasi trains dari parameter konstruktor
     *      - Inisialisasi bookingManager dengan objek BookingManager baru
     */
    public TrainBookingSystem(List<Train> trains) {
        // TODO: lengkapi konstruktor
        this.trains = trains;
        bookingManager = new BookingManager();
    }

    /*
     * Method showTrains
     * TODO:    Method ini berupa prosedur yang akan menampilkan semua kereta yang ada di dalam list trains.
     *          Awali dengan menampilkan header "=== Daftar Kereta Tersedia ==="
     *          - Jika tidak ada kereta, tampilkan pesan "(Tidak ada kereta tersedia)\n"
     *          - Jika trains tidak kosong, print objek train satu per satu dengan format "<index>. <train.toString()>"
     *          - Index dimulai dari 1
     *          - Akhiri dengan baris kosong
     */
    public void showTrains() {
        // TODO: Lengkapi method showTrains
        System.out.println("=== Daftar Kereta Tersedia ===");
        if (trains.size() == 0){
            System.out.println("(Tidak ada kereta tersedia)");
        }
        else {
            int index = 1;
            for (Train t : trains){
                System.out.println(index + ". " + t.toString());
                index++;
            }
            System.out.println("");
        }
    }

    /*
     * Method bookTicket
     * TODO:    Method ini berupa prosedur yang akan melakukan booking tiket 
     *          untuk customerName pada kereta dengan nama trainName.
     *          - Jika kereta dengan nama trainName tidak ditemukan, 
     *              tampilkan pesan "Kereta tidak ditemukan: <trainName>"
     *          - Jika kereta ditemukan tetapi tidak ada kursi tersedia, 
     *              tampilkan pesan "Kursi penuh pada kereta: <trainName>"
     *          - Jika booking berhasil, buat objek Booking baru dengan 
     *              customerName dan objek Train yang bersangkutan.
     *              Tambahkan booking ke dalam BookingManager, kurangi kursi pada kereta, 
     *              dan tampilkan pesan "Booking berhasil: <booking.toString()>"
     */
    public void bookTicket(String customerName, String trainName) {
        // TODO: lengkapi method bookTicket
        boolean found = false;
        for (Train t: trains){
            if (t.getName().equals(trainName)){
                if (!t.hasAvailableSeats()){
                    System.out.println("Kursi penuh pada kereta: " + trainName);
                }
                else {
                    Booking booking = new Booking(customerName, t);
                    BookingManager.Action action = bookingManager.new Action();
                    action.addBooking(booking);
                    t.reduceSeat();
                    System.out.println("Booking berhasil: " + booking.toString());
                }
                found = true;
            }
        }
        if (found == false){
            System.out.println("Kereta tidak ditemukan: " + trainName);
        }
    }

    /*
     * Method cancelBooking
     * TODO: Method ini berupa prosedur yang akan membatalkan booking dengan bookingId tertentu.
     *         Gunakan method cancel dari BookingManager.Action untuk membatalkan booking.
     * 
     */
    public void cancelBooking(String bookingId) {
        // TODO: lengkapi method cancelBooking
        BookingManager.Action action = bookingManager.new Action();
        action.cancel(bookingId);
    }

    /*
     * Method showAllBookings
     * TODO: Method ini berupa prosedur yang akan menampilkan semua booking yang ada di dalam BookingManager.
     *        Gunakan method showAllBookings dari BookingManager untuk menampilkan semua booking.
     */
    public void showAllBookings() {
        // TODO: lengkapi method showAllBookings
        bookingManager.showAllBookings();
    }
}
