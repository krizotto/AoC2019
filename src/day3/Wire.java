package day3;

import java.util.ArrayList;
import java.util.List;

public class Wire {

    List<Point> intersection = new ArrayList<>();
    private List<Point> path = new ArrayList<>();

    Wire() {
        path.add(new Point(0, 0));
    }

    public List<Point> getPath() {
        return this.path;
    }

    public List<Point> getIntersection() {
        return this.intersection;
    }

    public void readMove(String s) {
        char direction = s.charAt(0);
        int count = Integer.parseInt(s.substring(1));

        if (direction == 'R') addRight(count);
        else if (direction == 'L') addLeft(count);
        else if (direction == 'U') addUp(count);
        else if (direction == 'D') addDown(count);
    }

    public void intersection(Wire w) {
        for (Point p : w.getPath()) {
            for (Point thisp : this.getPath()) {
                if (p.equals(thisp)) this.intersection.add(p);
            }
        }
        w.getIntersection().addAll(this.intersection);
    }

    public void printIntersection() {
        System.out.println("Path: ");
        for (Point p : intersection)
            System.out.printf("(%d,%d),", p.getX(), p.getY());
    }

    public int stepDistance(Point p) {
        int i = 0;
        for (Point pt : this.getPath()) {
            if (pt.equals(p)) return (i);
            i++;
        }
        System.out.println("SOMETHING BAD HAPPENED");
        return -1;
    }

    public Point lastPoint() {
        return path.get(path.size() - 1);
    }

    public void addUp(int count) {
        for (int i = 0; i < count; i++) {
            path.add(lastPoint().movePoint(0, 1));
        }
    }

    public void addDown(int count) {
        for (int i = 0; i < count; i++) {
            path.add(lastPoint().movePoint(0, -1));
        }
    }

    public void addLeft(int count) {
        for (int i = 0; i < count; i++) {
            path.add(lastPoint().movePoint(-1, 0));
        }
    }

    public void addRight(int count) {
        for (int i = 0; i < count; i++) {
            path.add(lastPoint().movePoint(1, 0));
        }
    }
}
