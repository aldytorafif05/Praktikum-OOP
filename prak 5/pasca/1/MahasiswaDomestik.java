public final class MahasiswaDomestik extends Mahasiswa{
    private Gender gender;

    /*
     * TODO: Implementasikan constructor kelas MahasiswaDomestik
     * gender diinisialisasi sesuai parameter, username dan password diinisialisasi dengan null
     * */
    public MahasiswaDomestik(Gender gender){
        // TODO: answer here
        super();
        this.gender = gender;
    }

    /*
     * TODO: Implementasikan method perkenalkan
     * Tampilkan "Halo, saya mahasiswa domestik <gender> dengan username <username>"
     */
    public void perkenalkan(){
        // TODO: answer here
        System.out.println("Halo, saya mahasiswa domestik " + gender + " dengan username " + getUsername());
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Tampilkan "Mahasiswa domestik <gender> dengan username <username> berhasil mendaftar asrama"
     * panggil method daftarAsrama pada objek asrama
     */
    public void daftarAsrama(Asrama asrama) {
        // TODO: answer here
        System.out.println("Mahasiswa domestik " + gender + " dengan username " + getUsername() + " berhasil mendaftar asrama");
        asrama.daftarAsrama(this);
    }

    /*
     * TODO: Implementasikan setter dan getter
     * setGender, getGender
     */

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public Gender getGender(){
        return gender;
    }
}
