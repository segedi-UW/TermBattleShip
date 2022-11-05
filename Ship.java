
public class Ship {
    protected enum Type {
        AIRCRAFT_CARRIER, DESTROYER, BATTLESHIP, SUBMARINE, U_BOAT;
    }
    public final Coordinate start;
    public final Coordinate end;
    public final Type type;
    private final boolean[] hits;
    private int hitsLeft;
    public Ship(Type type, Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
        this.type = type;
        int length = Math.max(Math.abs(start.x - end.x), Math.abs(start.y - end.y));
        hits = new boolean[length];
        hitsLeft = length;
    }

    public int hitsLeft() {
        return hitsLeft;
    }

    // naive, can be improved
    public boolean isHit(Coordinate spot) {
        int dx = start.x - end.x;
        int dy = start.y - end.y;
        int x = start.x;
        int y = start.y;

        for (int i = 0;x != end.x && y != end.y; x += dx, y += dy, i++) {
            if (x == spot.x && y == spot.y) {
                if (!hits[i]) {
                    hits[i] = true;
                    hitsLeft--;
                }
                return true;
            }
        }
        return false;
    }
}
