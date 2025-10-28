public class Player {
    // TODO: Deklarasikan atribut: username (String), avatar (Avatar), game (Game)
    // TODO: Deklarasikan static int totalPlayer untuk menghitung total player
    // dibuat
    public String username;
    public Avatar avatar;
    public Game game;
    private static int totalPlayer;

    // TODO: Constructor set username dan avatar, dan increment totalPlayer
    public Player(String username, Avatar avatar) {
        // HINT: this.username = username; dst.
        this.username = username;
        this.avatar = avatar;
        totalPlayer++;
    }

    // TODO: Method joinGame: set game ke g kemudian panggil g.joinGame(this)
    public void joinGame(Game g) {
        game = g;
        g.joinGame(this);
    }

    // TODO: Tampilkan profil sesuai format:
    // Username: <username>.
    // Avatar: <namaSkin> (Lv.<level>).
    // Sedang bermain: <namaGame>.
    // ATAU jika belum gabung: Belum bergabung ke game.
    // Diakhiri 1 baris kosong
    public void showProfile() {
        // HINT: Cek game == null
        System.out.println("Username: " + username + ".");
        System.out.println("Avatar: " + avatar.namaSkin + " (Lv." + avatar.level + ")." );
        if (game == null){
            System.out.println("Belum bergabung ke game.");
        }
        else {
            System.out.println("Sedang bermain: " + game.namaGame + ".");
        }
        System.out.println();
    }

    // TODO: Kembalikan totalPlayer
    public static int getTotalPlayer() {
        return totalPlayer; // ganti dengan nilai dari totalPlayer
    }
}