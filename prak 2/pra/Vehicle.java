import javax.swing.plaf.synth.SynthUI;

public class Vehicle {
    private String plateNumber;
    private String type;
    private int capacity;   
    private int currentLoad; 
    private Driver driver;
    private Route route;

    public Vehicle(String plateNumber, String type, int capacity, Driver driver, Route route) {
        /**
	 * TODO: Buatlah konstruktor untuk kelas vehicle dengan currentLoad adalah 0
	 * */
        this.plateNumber = plateNumber;
        this.type = type;
        this.capacity = capacity;
        this.driver = driver;
        this.route = route;
        currentLoad = 0;
    }

    public void showInfo() {
	/**
	 * TODO: Tampilkan info dari vehicle
	 * 		"Kendaraan: Avanza (B 1212 FUV)
	 * 		Supir: Lina - Lisensi: ALD1122 - Rating: 3.0
	 * 		Rute: Jakarta >> Tangerang (30 km)
	 * 		Estimasi waktu tempuh: 0.6 jam
	 * 		Penumpang: 0/7"
	 * */
        System.out.println("Kendaraan: " + type + " (" + plateNumber + ")");
        if (driver != null){
            driver.introduce();
        }
        else {
            System.out.println("Supir: -");
        }
        if (route != null){
            System.out.println("Rute: " + route.getStartPoint() + " >> " + route.getDestination() + " (" + route.getDistance() + " km)");
            System.out.println("Estimasi waktu tempuh: " + route.estimateTravelTime());
        }
        else{
            System.out.println("Rute: - ");
        }
        System.out.println("Penumpang: " + currentLoad + "/" + capacity);
    }

    public void changeDriver(Driver newDriver) {
    	/**
	 * TODO: Melakukan perubahan driver di kendaraan
	 * */  
        driver = newDriver;
    }

    public void assignRoute(Route newRoute) {
      	/**
	 * TODO: Menerapkan rute baru pada  kendaraan
	 * */  
        route = newRoute;
    }

    public void boardPassenger(int count) {
      	/**
	 * TODO: Buatlah fungsi yang mesimulasikan penumpang yang naik ke kendaraan, 
	 * 	fungsi ini akan mengubah attribut current load.
	 * 	Pesan gagal "Gagal: kapasitas kendaraan tidak cukup!"
	 * */
        if (count <= 0){return;}
        if ((currentLoad + count) <= capacity){
            currentLoad += count;
        }
        else {
            System.out.println("Gagal: kapasitas kendaraan tidak cukup!");
        }
    }

    public void alightPassenger(int count) {
      	/**
	 * TODO: Buatlah fungsi yang mesimulasikan penumpang yang turun dari kendaraan, 
	 * 	fungsi ini akan mengubah attribut current load.
	 * 	Pesan gagal "Gagal: jumlah penumpang turun melebihi yang ada!"
	 * */  
        if (count <= 0){return;}
        if (count>currentLoad){
            System.out.println("Gagal: jumlah penumpang turun melebihi yang ada!");
        }
        else{
            currentLoad -= count;
        }
    }

    public Driver getDriver(){
	return this.driver;
    }

    public int getCapacity(){
    	return this.capacity;
    }
    public void setDriver(Driver driver){
    	this.driver = driver;
    }
}
