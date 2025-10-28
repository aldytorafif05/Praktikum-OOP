public class Route {
    private String startPoint;
    private String destination;
    private int distance; 
    private int averageSpeed;

    public Route(String startPoint, String destination, int distance, int averageSpeed) {
	/**
	 * TODO: Buatlah konstruktor untuk kelas route ini
	 * */
        this.startPoint = startPoint;
        this.destination = destination;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }

    public void showRoute() {
	    /**
	     * TODO: Menampilkan informasi rute dengan format,
	     * 		"{startPoint} >> {destination} ({distance} km)
	     * 		Estimasi waktu tempuh: {time} jam"
	     * 		Waktu tempuh ditulis sampai 1 angka di belakang koma.
	     * */
        System.out.println(startPoint + " >> " + destination + " (" + distance + "km )");
        if (estimateTravelTime() >= 0){
            System.out.printf("Estimasi waktu tempuh: %.1f\n", estimateTravelTime());
        }
        else{
            System.out.println("Estimasi waktu tempu: invalid (averageSpeed <= 0)");
        }
    }

    public double estimateTravelTime() {
	    /**
	     * TODO: Fungsi ini memprediksi berapa lama rute ditempuh dengan 
	     * kecepatan rata rata
	     * */
        if(averageSpeed >0){
            return (double) distance/averageSpeed;
        }
        else {
            return -1;
        }
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }
}
