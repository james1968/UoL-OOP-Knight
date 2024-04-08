import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Knight {


    public static int numMoves( int dim, int xstart, int ystart, int xtarget, int ytarget, int[] xrock, int[] yrock ) {
        if  (rock(xstart, ystart, xrock, yrock)) {
            return -1;
        }
        int x = xstart;
        int y = ystart;
        int numberMoves = 2;
        while (true) {
            for (int[] m : moves(x, y, dim, xrock, yrock)) {
                if (finish(m, xtarget, ytarget)) {
                    return numberMoves;
                }
            }
            numberMoves++;
            x = nextMove(moves(x, y, dim, xrock, yrock), xtarget, ytarget)[0];
            System.out.println("x " + x);
            y = nextMove(moves(x, y, dim, xrock, yrock), xtarget, ytarget)[1];
            System.out.println("y " + y);
            if (numberMoves > 19) {
                return -1;
            }
        }
    }

    private static boolean rock(int x, int y, int[] xrock,  int[] yrock) {

        for (int i = 0; i < xrock.length; i++) {
            if (xrock[i] == x && yrock[i] == y) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<int[]> moves(int xstart, int ystart, int dim, int[] xrock, int[] yrock) {
        ArrayList<int[]> move = new ArrayList<>();
            move.add(new int[]{xstart - 2, ystart - 1});
            move.add(new int[]{xstart - 2, ystart + 1});
            move.add(new int[]{xstart - 1, ystart - 2});
            move.add(new int[]{xstart + 1, ystart - 2});
            move.add(new int[]{xstart + 2, ystart - 1});
            move.add(new int[]{xstart + 2, ystart + 1});
            move.add(new int[]{xstart - 1, ystart + 2});
            move.add(new int[]{xstart + 1, ystart + 2});
            ArrayList<int[]> moveNew = new ArrayList<>();
            for (int h = 0; h < move.size(); h++) {
                if ((validSquare(move.get(h)[0], move.get(h)[1], dim))
                        && (!rock(move.get(h)[0], move.get(h)[1], xrock, yrock ))){
                    moveNew.add(move.get(h));
                }
            }
        /*for (int i = 0; i < moveNew.size(); i++) {
            for (int j = 0; j < moveNew.get(0).length; j++) {
                System.out.print(moveNew.get(i)[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("=====");*/
        return moveNew;
    }

    private static boolean validSquare(int x, int y, int dim) {
        return (0 <= x && x < dim) && (0 <= y && y < dim);
    }

    private static int[] nextMove(ArrayList<int[]> moves, int xtarget, int ytarget) {
        double distance = 0;
        ArrayList<Double> distances = new ArrayList<>();
        for (int[] m : moves) {
                distance = Math.sqrt((ytarget - m[1]) * (ytarget - m[1]) + (xtarget - m[0]) * (xtarget - m[0]));
                distances.add(distance);
            }

        Double minMove = Collections.min(distances);
        int indexMove = distances.indexOf(minMove);
        return moves.get(indexMove);
    }

    private static boolean finish(int[] moveNew, int xtarget, int ytarget) {
        for (int i = 0; i < moveNew.length; i++ ) {
            if (moveNew[0] == xtarget && moveNew[1] == ytarget) {
                return true;
            }
        }
        return false;
    }


    public static void main( String[] args )
    {
        int xr[] = { 0, 0, 0, 1, 1, 2, 2, 2, 10 };
        int yr[] = { 0, 1, 2, 0, 2, 0, 1, 2, 10 };
        System.out.println(numMoves(8, 2,3,4,5,xr, yr));

        //int xr1[] = {}, yr1[] = {};
        //System.out.println(numMoves( 3, 0, 0, 2, 2, xr1, yr1 ));
    }

}