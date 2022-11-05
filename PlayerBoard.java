public class PlayerBoard extends Board {

    public PlayerBoard() {
        super(parseShips());
    }

    private static Ship[] parseShips() {
        final Ship[] ships = new Ship[Board.FLEET_SIZE];
        System.out.println("Welcome to Battleship Admiral! Please enter you ships coordinates.");
        // TODO create aircraft carrier and parse coordinates
        // TODO create battleship and parse coordinates
        // TODO create destroyer and parse coordinates
        // TODO create submarine and parse coordinates
        // TODO create u-boat and parse coordinates
        return ships;
    }

}
