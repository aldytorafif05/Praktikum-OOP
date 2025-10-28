public class Avatar {
    // TODO: Deklarasi atribut: namaSkin (String), level (int)
    public String namaSkin;
    public int level;
    // TODO: Constructor set namaSkin dan level
    public Avatar(String namaSkin, int level) {
        // HINT: this.namaSkin = namaSkin; dst.
        this.namaSkin = namaSkin;
        this.level = level;
    }

    // TODO: Naikkan level (level++) dan cetak:
    // "Skin <namaSkin> naik ke level <level>."
    public void upgradeLevel() {
        // HINT: Urutan: tingkatkan level, lalu cetak
        level++;
        System.out.println("Skin " + namaSkin + " naik ke level " + level + ".");
    }
}