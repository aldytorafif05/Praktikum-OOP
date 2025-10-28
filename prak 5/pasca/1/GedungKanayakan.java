import java.util.List;

public final class GedungKanayakan implements Asrama {
    List<Mahasiswa> penghuni;
    Integer kapasitas;

    /*
     * TODO: Implementasikan constructor kelas GedungKanayakan
     * penghuni diinisialisasi dengan ArrayList baru
     * kapasitas diinisialisasi sesuai parameter
     */
    public GedungKanayakan(Integer kapasitas) {
        penghuni = new java.util.ArrayList<>();
        this.kapasitas = kapasitas;
    }

    /*
     * TODO: Implementasikan method infoAsrama
     * Tampilkan "Asrama Gedung Kanayakan dengan kapasitas <kapasitas>"
    */
    public void infoAsrama() {
        //TODO: answer here
        System.out.println("Asrama Gedung Kanayakan dengan kapasitas " + kapasitas);
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Asrama Kanayakan hanya untuk mahasiswa domestik WANITA
     *
     * Jika kapasitas asrama penuh, tampilkan "Asrama Gedung Kanayakan sudah penuh"
     * Jika mahasiswa sudah terdaftar di asrama lain (assigned), tampilkan "Mahasiswa sudah terdaftar di asrama lain"
     * Jika mahasiswa asing, tampilkan "Mahasiswa asing tidak boleh mendaftar di asrama ini"
     * Jika mahasiswa domestik PRIA, tampilkan "Asrama Gedung Kanayakan hanya untuk mahasiswa perempuan"
     * Jika mahasiswa domestik WANITA dan asrama belum penuh, tambahkan mhs ke penghuni,
     * tampilkan "Mahasiswa <username> diterima di asrama Gedung Kanayakan"
     * Lalu set asrama mahasiswa ke asrama ini
     */
    public void daftarAsrama(Mahasiswa mhs) {
        // TODO: answer here
        
        if (penghuni.size() >= kapasitas){
            System.out.println("Asrama Gedung Kanayakan sudah penuh");
        }
        else if (mhs.getAsrama() != null){
            System.out.println("Mahasiswa sudah terdaftar di asrama lain");
        }
        else if (mhs instanceof MahasiswaAsing){
            System.out.println("Mahasiswa asing tidak boleh mendaftar di asrama ini");
        }
        else if (mhs instanceof MahasiswaDomestik && ((MahasiswaDomestik) mhs).getGender().equals(Gender.PRIA)){
            System.out.println("Asrama Gedung Kanayakan hanya untuk mahasiswa perempuan");
        }
        else if (mhs instanceof MahasiswaDomestik && penghuni.size() < kapasitas && ((MahasiswaDomestik)mhs).getGender().equals(Gender.WANITA)){
            penghuni.add(mhs);
            System.out.println("Mahasiswa " + mhs.getUsername() + " diterima di asrama Gedung Kanayakan");
            mhs.setAsrama(this);
        }
    }
}
