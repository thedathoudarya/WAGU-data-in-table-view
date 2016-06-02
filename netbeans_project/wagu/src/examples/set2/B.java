/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples.set2;

import wagu.Block;
import wagu.Board;
import wagu.Table;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Thedath Oudarya
 */
public class B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> headersList = Arrays.asList("NAME", "GENDER", "MARRIED", "AGE", "SALARY($)");
        List<List<String>> rowsList = Arrays.asList(
                Arrays.asList("Eddy", "Male", "No", "23", "1200.27"),
                Arrays.asList("Libby", "Male", "No", "17", "800.50"),
                Arrays.asList("Rea", "Female", "No", "30", "10000.00"),
                Arrays.asList("Deandre", "Female", "No", "19", "18000.50"),
                Arrays.asList("Alice", "Male", "Yes", "29", "580.40"),
                Arrays.asList("Alyse", "Female", "No", "26", "7000.89"),
                Arrays.asList("Venessa", "Female", "No", "22", "100700.50")
        );
        
        Board board = new Board(75);
        Table table = new Table(board, 75, headersList, rowsList);
        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        String tableString = board.getPreview();
        System.out.println(tableString);
    }
    
}
