package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private final Set<Coordinate> selectedPoints = new HashSet<>();

    //private int bitchtest;

    public void select(Coordinate coordinate) {

        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {

        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {

        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) { // TODO: Implement this
        if (getSelectedPoints().size() < 3) {
            return false;
        }

        Coordinate[] coordArray = new Coordinate[3];

        int i = 0;
        for (Coordinate getCoord : getSelectedPoints()) {
            coordArray[i] = getCoord;
            i++;
        }

        double getX = coordinate.getX();
        double getY = coordinate.getY();

        double AX = coordArray[0].getX();
        double AY = coordArray[0].getY();
        double BX = coordArray[1].getX();
        double BY = coordArray[1].getY();
        double CX = coordArray[2].getX();
        double CY = coordArray[2].getY();

        /*while (bitchtest == 0) {
            System.out.println("Ax: " + Ax);
            System.out.println("Ay: " + Ay);
            System.out.println("Bx: " + Bx);
            System.out.println("By: " + By);
            System.out.println("Cx: " + Cx);
            System.out.println("Cy: " + Cy);
            bitchtest = 1;
        }*/

        //double costim = (BY - AY) / (BX - AX);

        double strana1 = (getX - AX) * (BY - AY) - (getY - AY) * (BX - AX);
        double strana2 = (getX - BX) * (CY - BY) - (getY - BY) * (CX - BX);
        double strana3 = (getX - CX) * (AY - CY) - (getY - CY) * (AX - CX);

        return (strana1 <= 0 && strana2 <= 0 && strana3 <= 0);
    }
}
