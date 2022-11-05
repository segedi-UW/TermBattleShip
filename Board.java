public class Board {
    public static final int BOARD_SIZE = 10;
    public static final int FLEET_SIZE = 5;

    private static final int MISS = 1;
    private static final int HIT = 2;
    private static final int SUNK = 3;

    private int shipsLeft = FLEET_SIZE;
    private final int[][] foreign = new int[BOARD_SIZE][BOARD_SIZE];

    private final Ship[] ships;

    public Board(Ship[] ships) {
        this.ships = ships;
    }

    public Hit fire(Coordinate coordinate) {
        for (Ship ship : ships) {
            if (ship.isHit(coordinate)) {
                if (ship.hitsLeft() <= 0) {
                    shipsLeft--;
                }
                return ship.hitsLeft() > 0 ? Hit.HIT : Hit.SUNK;
            }
        }
        return Hit.MISS;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" ".repeat(5));
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n")
                .append("-".repeat(3*BOARD_SIZE + 5))
                .append("\n");
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == 0) {
                    sb.append(String.format("%d | ", j));
                }
                switch (foreign[i][j]) {
                    case HIT:
                        sb.append(String.format("%3s", "X"));
                        break;
                    case MISS:
                        sb.append(String.format("%3s", "M"));
                        break;
                    case SUNK:
                        sb.append(String.format("%3s", "S"));
                        break;
                    default:
                        sb.append(String.format("%3s", "-"));
                        break;
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
