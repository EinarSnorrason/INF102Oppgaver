package alg.searching;

/**
 * Created by Einar Snorrason on 04/12/2017.
 */
public class Pos {
    int x;
    int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pos pos = (Pos) o;

        if (x != pos.x) return false;
        return y == pos.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
