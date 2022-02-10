import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class that implements GridMonitorInterface. It can read in a two-dimensional array of 
 * doubles (the base grid) from a file and determine locations in the base grid with 
 * dangerous values relative to their surrounding locations. 
 * 
 * 
 * @author Kacey Wheeler
 */

public class GridMonitor implements GridMonitorInterface {
    private int rows;
    private int columns;
    double[][] base;
    
    /**
     * Constructor for GridMonitor
     * 
     * @param filename  the name of the file being opened 
     * @throws FileNotFoundException
     */

    public GridMonitor(String filename) throws FileNotFoundException {
        //Directory must be changed to correct directory of files 
        File myFile = new File("C:\\Users\\cared\\OneDrive\\Desktop\\GridFiles\\" + filename);  
        Scanner myScanner = new Scanner(myFile);
        rows = myScanner.nextInt();
        columns = myScanner.nextInt();
        //Iterate through each double in the file, assigning them to the appropriate location in the array
        base = new double[rows][columns]; 
        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                base[r][c] = myScanner.nextDouble();
            }
        }
    }

     /**
     * Returns a copy of the original base grid.
	 * Overriden from GridMonitorInterface.
     * 
	 * @return base grid copy
	 */

    @Override 
    public double[][] getBaseGrid() {
        double[][] baseCopy = new double[rows][columns];
        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                baseCopy[r][c] = base[r][c];
            }
        }
        return baseCopy;
    }

    /**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is the sum of the 4 surrounding base elements. For elements on a grid border,
	 * the base element's own value is used when looking out of bounds, as if there
	 * is a mirror surrounding the grid. This method is exposed for testing.
     * Overriden from GridMonitorInterface. 
	 * 
	 * @return grid containing the sum of adjacent positions
	 */

    @Override
    public double[][] getSurroundingSumGrid() {
        //Call getBaseGrid method to get the original grid
        double[][] base = this.getBaseGrid();
        double[][] sum = new double[rows][columns];
        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                //Add cell to the left
                if (c!=0) {
                    sum[r][c] += base[r][c-1];
                }
                //Add the cell itself to the sum
                else {
                    sum[r][c] += base[r][c];
                }
                //Add cell below
                if (r!=0) {
                    sum[r][c] += base[r-1][c];
                }
                else {
                    sum[r][c] += base[r][c];
                }
                //Add cell above
                if (r < rows - 1) {
                    sum[r][c] += base[r+1][c];
                }
                else {
                    sum[r][c] += base[r][c]; 
                }
                //Add cell to the right
                if (c < columns - 1) {
                    sum[r][c] += base[r][c+1];
                }
                else {
                    sum[r][c] += base[r][c];
                }
            }
        }
        return sum;
    }

    /**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is the average of the 4 surrounding base elements. This method is exposed for 
	 * testing.
     * Overriden from GridMonitorInterface.
	 * 
	 * @return grid containing the average of adjacent positions
	 */

    @Override
    public double[][] getSurroundingAvgGrid() {
        //Call the getSurroundingSumGrid method to get the summed array
        double[][] sum = this.getSurroundingSumGrid();
        double[][] avg = new double[rows][columns];

        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                avg[r][c] = sum[r][c] / 4;
            }
        }
        
        return avg;
    }

    /**
	 * Returns a grid with the same dimensions as the base grid, but each element 
	 * is the maximum delta from the average. For example, if the surrounding
	 * average at some coordinate is 2.0 and the maximum delta is 50% of the average,
	 * the delta value at the same coordinate in this grid will be 1.0. This method is
	 * exposed for testing.
     * Overriden from GridMonitorInterface.
	 * 
	 * @return grid containing the maximum delta from average of adjacent positions
	 */

    @Override
    public double[][] getDeltaGrid() {
        //Call the getSurroundingAvgGrid to get the averaged array
        double[][] avg = this.getSurroundingAvgGrid();
        double[][] delta = new double[rows][columns];
        
        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                //Get the absolute value in to account for negative values. 
                delta[r][c] = Math.abs(avg[r][c] / 2);
            }
        }

        return delta;
    }
    
    /**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is a boolean value indicating if the cell is at risk. For example, if the cell
	 * at a coordinate is less than the surrounding average minus its maximum delta or
	 * greater than the surrounding average plus its maximum delta, the corresponding
	 * coordinate in this grid will be true. If the base cell value is within the safe
	 * range, however, the corresponding value in this grid will be false.
     * Overriden from GridMonitorInterface.
	 * 
	 * @return grid containing boolean values indicating whether the cell at this
	 * location is in danger of exploding
	 */

    @Override
    public boolean[][] getDangerGrid() {
        double[][] delta = this.getDeltaGrid();
        double[][] average = this.getSurroundingAvgGrid();
        double[][] base = this.getBaseGrid();
        boolean[][] danger = new boolean[rows][columns];
        
        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                //Set the bounds for the cells by adding/subtracting delta value from average value
                double lowerBound = average[r][c] - delta[r][c];
                double upperBound = average[r][c] + delta[r][c];
                //Compare the original value to the lowerBound and upperBound range to see if at risk of exploding
                if (lowerBound < base[r][c] && base[r][c] < upperBound) {
                    danger[r][c] = false;
                }
                else {
                    danger[r][c] = true;
                }
            }
        }
    	return danger;
    }
    /**
     * When printing out an object from this class, returns the base grid 
     * array as a string output with each row on different lines.
     * Overriden from Object class. 
     * 
     * @return base grid as a string output
     */

    @Override
    public String toString() {
        String output = "";
        double[][] base = this.getBaseGrid();
        for (int r=0; r< base.length; r++) {
            for (int c=0; c< base[0].length; c++) {
                output += base[r][c] + " ";
            }
            output += "\n";
        }
        return output;
    }
}
