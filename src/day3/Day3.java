package day3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {

        List<String> w1 = new ArrayList<>();
        List<String> w2 = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("src/day3/resources/input.txt"));
            if (sc.hasNextLine()) {
                String w = sc.nextLine();
                Collections.addAll(w1, w.split(","));
            }
            if (sc.hasNextLine()) {
                String w = sc.nextLine();
                Collections.addAll(w2, w.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Wire wire1 = new Wire();
        Wire wire2 = new Wire();

        for (String s : w1) {
            wire1.readMove(s);
        }

        for (String s : w2) {
            wire2.readMove(s);
        }

        //FIRST PART
        wire1.intersection(wire2); //THIS IS SUUUPERSLOW
        wire1.getIntersection().remove(0);

        List<Integer> distances = new ArrayList<>();
        for (Point p : wire1.getIntersection()) {
            distances.add(p.distance());
        }
        System.out.printf("Lowest distance to (0,0) is %d from (%d,%d)", Collections.min(distances), wire1.getIntersection().get(distances.indexOf((Collections.min(distances)))).getX(), wire1.getIntersection().get(distances.indexOf((Collections.min(distances)))).getY());


        //SECOND PART
        List<Integer> routes = new ArrayList<>();
        for (Point p : wire1.getIntersection()) {
            routes.add(wire1.stepDistance(p) + wire2.stepDistance(p));
        }
        System.out.printf("\nLowest step distance to (0,0) is %d from (%d,%d)", Collections.min(routes), wire1.getIntersection().get(routes.indexOf((Collections.min(routes)))).getX(), wire1.getIntersection().get(routes.indexOf((Collections.min(routes)))).getY());

    }
}
