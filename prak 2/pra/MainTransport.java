public class MainTransport {
    public static void main(String[] args) {

        // =================================================================
        // BAGIAN 1: INISIALISASI
        // =================================================================
        System.out.println("===== BAGIAN 1: MEMBUAT SISTEM TRANSPORTASI =====");
        TransportSystem system = new TransportSystem("Bandung Transport");
        System.out.println("Sistem Transportasi '" + system.getName() + "' berhasil dibuat.\n");

        System.out.println("--- Menampilkan kendaraan saat masih kosong ---");
        system.showAllVehicles(); // Uji kasus sistem kosong
        System.out.println("\n");


        // =================================================================
        // BAGIAN 2: MEMBUAT DRIVER, RUTE, DAN KENDARAAN
        // =================================================================
        System.out.println("===== BAGIAN 2: MENYIAPKAN DATA =====");
        // Membuat Driver
        Driver driver1 = new Driver("Udin", "123-A");
        Driver driver2 = new Driver("Siti", "456-B");
        Driver driver3 = new Driver("Budi", "789-C");
        System.out.println("3 driver telah dibuat: Udin, Siti, Budi.");

        // Membuat Rute
        // Rute ini akan menghasilkan waktu tempuh desimal yang "jelek" (0.8333...)
        // untuk menguji format printf kita.
        Route routeUdin = new Route("Gedebage", "Sarijadi", 25, 30); 
        Route routeSiti = new Route("Cicaheum", "Ledeng", 20, 40); // Hasilnya 0.5, bagus
        Route routeBudi = new Route("Kopo", "Cibiru", 30, 60); // Hasilnya 0.5, bagus
        System.out.println("3 rute telah dibuat.\n");

        // Membuat Kendaraan
        Vehicle angkot = new Vehicle("D 1111 XX", "Angkot", 12, driver1, routeUdin);
        Vehicle bus = new Vehicle("D 2222 YY", "Bus Kota", 30, driver2, routeSiti);
        Vehicle taksi = new Vehicle("D 3333 ZZ", "Taksi Online", 4, driver3, routeBudi);


        // =================================================================
        // BAGIAN 3: MENGUJI FUNGSI TransportSystem
        // =================================================================
        System.out.println("===== BAGIAN 3: MENAMBAHKAN KENDARAAN KE SISTEM =====");
        System.out.println("--- Menambahkan 1 kendaraan (Angkot) dan menampilkan ---");
        system.addVehicle(angkot);
        system.showAllVehicles(); // Uji kasus 1 kendaraan (tidak boleh ada separator)
        System.out.println("\n");

        System.out.println("--- Menambahkan 2 kendaraan lagi dan menampilkan semua ---");
        system.addVehicle(bus);
        system.addVehicle(taksi);
        system.showAllVehicles(); // Uji kasus >1 kendaraan (HARUS ada separator di antara, TAPI TIDAK di akhir)
        System.out.println("\n");


        // =================================================================
        // BAGIAN 4: MENGUJI LOGIKA KELAS Vehicle DAN Driver
        // =================================================================
        System.out.println("===== BAGIAN 4: MENGUJI LOGIKA PENUMPANG DAN RATING =====");
        
        System.out.println("--- Menguji naik/turun penumpang di taksi (kapasitas 4) ---");
        taksi.boardPassenger(3); // Penumpang sekarang 3/4
        System.out.println("3 penumpang naik taksi.");
        taksi.boardPassenger(2); // Ini akan GAGAL karena melebihi kapasitas
        taksi.alightPassenger(1); // Penumpang sekarang 2/4
        System.out.println("1 penumpang turun dari taksi.");
        taksi.alightPassenger(5); // Ini akan GAGAL karena yg turun > yg ada
        System.out.println("");

        System.out.println("--- Menguji update rating driver Udin ---");
        driver1.updateRating(4.75); // Rating akan diformat jadi 4.8 saat dicetak
        System.out.println("Rating Udin diupdate menjadi 4.75");
        driver1.updateRating(10.0); // Ini akan GAGAL karena rating > 5.0
        System.out.println("\n");


        // =================================================================
        // BAGIAN 5: PENGECEKAN FINAL
        // =================================================================
        System.out.println("===== BAGIAN 5: MENAMPILKAN INFO FINAL SETELAH PERUBAHAN =====");
        system.showAllVehicles();
        System.out.println("\n");
        
        System.out.println("===== BAGIAN 6: MENGUJI FUNGSI PENCARIAN & KAPASITAS =====");
        System.out.println("--- Mencari kendaraan yang disetir oleh 'Siti' ---");
        Vehicle foundVehicle = system.findVehicleByDriver("Siti");
        if (foundVehicle != null) {
            System.out.println("Kendaraan ditemukan! Plat: D 2222 YY");
        } else {
            System.out.println("Kendaraan tidak ditemukan.");
        }

        System.out.println("\n--- Mencari kendaraan yang disetir oleh 'Asep' ---");
        Vehicle notFoundVehicle = system.findVehicleByDriver("Asep");
        if (notFoundVehicle == null) {
            System.out.println("Kendaraan dengan driver 'Asep' tidak ditemukan, sesuai harapan.");
        } else {
            System.out.println("Error: Seharusnya tidak ada kendaraan.");
        }

        System.out.println("\n--- Menghitung total kapasitas penumpang ---");
        // Total harusnya 12 (angkot) + 30 (bus) + 4 (taksi) = 46
        int totalKapasitas = system.totalPassengerCapacity();
        System.out.println("Total kapasitas semua kendaraan: " + totalKapasitas);
    }
}