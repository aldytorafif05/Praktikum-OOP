public class Main {
    public static void main(String[] args) {
        System.out.println("=== Market Simulation Start ===");

        // 1. Membuat Market
        Market market = new Market("Toko Sebelah");
        System.out.println("Market '" + market.getName() + "' is open!");
        System.out.println();

        // 2. Menambahkan Keranjang dan Item
        System.out.println("--- Menambahkan keranjang dan item ---");
        
        // Keranjang 1 (akan memiliki ID 1)
        // Item "Apel" (ID 1), "Pisang" (ID 2)
        market.addCartWithItem("Apel", 5000.0); 
        Market.Cart cart1 = market.getCarts().get(0);
        cart1.addItem("Pisang", 3000.0);

        // Keranjang 2 (akan memiliki ID 1 juga, karena bug di constructor Cart)
        // Item "Roti" (ID 3), "Susu" (ID 4)
        market.addCart(); 
        Market.Cart cart2 = market.getCarts().get(1);
        cart2.addItem("Roti", 15000.0);
        cart2.addItem("Susu", 20000.0);

        // Keranjang 3 (akan memiliki ID 1 juga)
        // Item "Mangga" (ID 5)
        market.addCartWithItem("Mangga", 8000.0);
        Market.Cart cart3 = market.getCarts().get(2);

        System.out.println("Market sekarang memiliki " + market.getCarts().size() + " keranjang.");
        System.out.println();

        // 3. Menguji penghapusan item
        System.out.println("--- Menguji penghapusan item ---");
        System.out.println("Menghapus item dengan ID 3 (Roti) dari Keranjang 2...");
        cart2.removeItemById(3); // Menghapus "Roti"
        System.out.println();

        // 4. Menguji penghapusan keranjang
        System.out.println("--- Menguji penghapusan keranjang ---");
        System.out.println("Menghapus Keranjang 3 dari market...");
        market.removeCart(cart3); // Menghapus keranjang yang berisi "Mangga"
        System.out.println("Market sekarang memiliki " + market.getCarts().size() + " keranjang.");
        System.out.println();

        // 5. Menguji checkout
        System.out.println("--- Menguji checkout ---");
        market.checkoutAllCarts();
        System.out.println();

        // 6. Menguji clearCarts
        System.out.println("--- Menguji clear carts ---");
        market.clearCarts();
        System.out.println("Keranjang market dibersihkan. Sisa keranjang: " + market.getCarts().size());
        System.out.println();

        System.out.println("=== Market Simulation End ===");
    }
}