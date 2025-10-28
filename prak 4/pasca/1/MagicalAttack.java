public interface MagicalAttack extends Attack {
    public int getMagicalPower();

    public void setMagicalPower(int power);

    // TODO: Buat default method meditate()
    // Tambahkan 10 ke magicalPower dengan memanggil getMagicalPower() dan setMagicalPower()
    public default void meditate(){
        int power = getMagicalPower() + 10;
        setMagicalPower(power);
    }
    // TODO: Buat default method showMagicalStats()
    // Tampilkan: "Kekuatan Sihir: <magicalPower>"
    public default void showMagicalStats(){
        System.out.println("Kekuatan Sihir: " + getMagicalPower());
    }
}