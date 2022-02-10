import java.io.FileNotFoundException;

/**
 * Test file to help test the methods of GridMonitor before using GridMonitorTest
 * 
 * @author Kacey Wheeler
 */

public class Test {
    
    /** @param args not used */
    public static void main(String[] args) throws FileNotFoundException { 
        
        //Test methods for sample.txt
        System.out.println("SAMPLE\n");
        GridMonitor grid = new GridMonitor("sample.txt");
        printGrid(grid.getBaseGrid());
        printGrid(grid.getSurroundingSumGrid());
        printGrid(grid.getSurroundingAvgGrid());
        printGrid(grid.getDeltaGrid());
        printGrid(grid.getDangerGrid());

        //Test methods for oneByOne.txt
        System.out.println("ONEBYONE\n");
        GridMonitor grid2 = new GridMonitor("oneByOne.txt");
        printGrid(grid2.getBaseGrid());
        printGrid(grid2.getSurroundingSumGrid());
        printGrid(grid2.getSurroundingAvgGrid());
        printGrid(grid2.getDeltaGrid());
        printGrid(grid2.getDangerGrid());

        //Test methods for negatives.txt
        System.out.println("NEGATIVES\n");
        GridMonitor grid3 = new GridMonitor("negatives.txt");
        printGrid(grid3.getBaseGrid());
        printGrid(grid3.getSurroundingSumGrid());
        printGrid(grid3.getSurroundingAvgGrid());
        printGrid(grid3.getDeltaGrid());
        printGrid(grid3.getDangerGrid());

        //Test methods for sample4x5.txt
        System.out.println("SAMPLE4X5\n");
        GridMonitor grid4 = new GridMonitor("sample4x5.txt");
        printGrid(grid4.getBaseGrid());
        printGrid(grid4.getSurroundingSumGrid());
        printGrid(grid4.getSurroundingAvgGrid());
        printGrid(grid4.getDeltaGrid());
        printGrid(grid4.getDangerGrid());

        //Test methods for sampleDoubles.txt
        System.out.println("SAMPLEDOUBLES\n");
        GridMonitor grid5 = new GridMonitor("sampleDoubles.txt");
        printGrid(grid5.getBaseGrid());
        printGrid(grid5.getSurroundingSumGrid());
        printGrid(grid5.getSurroundingAvgGrid());
        printGrid(grid5.getDeltaGrid());
        printGrid(grid5.getDangerGrid());

        //Test methods for wideRange.txt
        System.out.println("WIDERANGE\n");
        GridMonitor grid6 = new GridMonitor("wideRange.txt");
        printGrid(grid6.getBaseGrid());
        printGrid(grid6.getSurroundingSumGrid());
        printGrid(grid6.getSurroundingAvgGrid());
        printGrid(grid6.getDeltaGrid());
        printGrid(grid6.getDangerGrid());
    }
    
    /**
     * Returns an array of doubles as a string for
     * output readability and ease of debugging
     * 
     * @param grid array of doubles
     * @return grid as a string 
     */

    public static void printGrid(double[][] grid) {
        for (int r=0; r< grid.length; r++) {
            for (int c=0; c< grid[0].length; c++) {
            	System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Returns an array of booleans as a string for
     * output readability and ease of debugging
     * 
     * @param grid array of booleans
     * @return grid as a string 
     */

    public static void printGrid(boolean[][] grid) {
        for (int r=0; r< grid.length; r++) {
            for (int c=0; c< grid[0].length; c++) {
            	System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
