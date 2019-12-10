package day3;

public class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance() {
        return Math.abs(x) + Math.abs(y);
    }

    public Point movePoint(int x, int y) {
        int _x = this.x + x;
        int _y = this.y + y;
        return new Point(_x, _y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Boolean equals(Point p) {
        if (this.x == p.getX() && this.y == p.getY()) return Boolean.TRUE;
        return Boolean.FALSE;
    }

}
