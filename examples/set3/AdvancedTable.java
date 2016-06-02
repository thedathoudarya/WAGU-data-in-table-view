/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.set3;

import wagu.Block;
import wagu.Board;
import wagu.Table;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Thedath Oudarya
 */
public class AdvancedTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board board = new Board(175);

        Block sdtBlock = new Block(board, 9, 5,"STUDENT\nDETAILS\nTABLE");
        board.setInitialBlock(sdtBlock.setDataAlign(Block.DATA_CENTER));
        Block nameBlock = new Block(board, 31, 3,"NAME");
        sdtBlock.setRightBlock(nameBlock.setDataAlign(Block.DATA_CENTER));
        Block gradeBlock = new Block(board, 131, 1,"GRADE");
        nameBlock.setRightBlock(gradeBlock.setDataAlign(Block.DATA_CENTER));
        Block studentBlock = new Block(board, 9, 15,"STUDENT");
        sdtBlock.setBelowBlock(studentBlock.setDataAlign(Block.DATA_CENTER));
        Block totalBlock = new Block(board, 41, 1,"TOTAL");
        studentBlock.setBelowBlock(totalBlock.setDataAlign(Block.DATA_CENTER));
        Block avgBlock = new Block(board, 41, 1,"AVERAGE");
        totalBlock.setBelowBlock(avgBlock.setDataAlign(Block.DATA_CENTER));

        List<String> nameTableHeadersList = Arrays.asList("FIRST","LAST");
        List<Integer> nameTableHeadersWidth = Arrays.asList(15, 15);
        List<List<String>> nameTableRowsList = Arrays.asList(
                Arrays.asList("Eddy","Eason"),
                Arrays.asList("Libby","Langstaff"),
                Arrays.asList("Rea","Ramaker"),
                Arrays.asList("Deandre","Doan"),
                Arrays.asList("Alice","Applebaum"),
                Arrays.asList("Alyse","Augustyn"),
                Arrays.asList("Venessa","Vreeland"),
                Arrays.asList("Bernie","Berube")
        );
        Table nameTable = new Table(board, 31, nameTableHeadersList, nameTableRowsList, nameTableHeadersWidth);
        nameTable.setGridMode(Table.GRID_FULL);
        board.appendTableTo(1, Board.APPEND_BELOW, nameTable);

        Block gradeOne = new Block(board, 43, 1,"ONE");
        gradeBlock.setBelowBlock(gradeOne.setDataAlign(Block.DATA_CENTER));
        Block gradeTwo = new Block(board, 43, 1,"TWO");
        gradeOne.setRightBlock(gradeTwo.setDataAlign(Block.DATA_CENTER));
        Block gradeThree = new Block(board, 43, 1,"THREE");
        gradeTwo.setRightBlock(gradeThree.setDataAlign(Block.DATA_CENTER));

        List<String> subjects = Arrays.asList("MATHS","SCIENCE","ENGLISH","TOTAL");
        List<List<String>> figures = Arrays.asList(
                Arrays.asList("68.00","10.00","42.00","120.00"),
                Arrays.asList("31.00","23.00","79.00","133.00"),
                Arrays.asList("12.00","46.00","26.00","84.00"),
                Arrays.asList("81.00","38.00","68.00","187.00"),
                Arrays.asList("20.00","54.00","14.00","88.00"),
                Arrays.asList("49.00","84.00","32.00","165.00"),
                Arrays.asList("70.00","72.00","45.00","187.00"),
                Arrays.asList("19.00","58.00","32.00","109.00"),
                Arrays.asList("350.00","385.00","338.00","1,073.00"),
                Arrays.asList("43.75","48.13","42.25","134.13")
        );
        List<Integer> figuresColWidthsList = Arrays.asList(10, 10, 10, 10);
        Table figuresTable = new Table(board, 43, subjects, figures, figuresColWidthsList);
        figuresTable.setGridMode(Table.GRID_FULL);
        board.appendTableTo(24, Board.APPEND_BELOW, figuresTable);

        figures = Arrays.asList(
                Arrays.asList("49.00","36.00","38.00","123.00"),
                Arrays.asList("6.00","97.00","94.00","197.00"),
                Arrays.asList("75.00","19.00","26.00","120.00"),
                Arrays.asList("62.00","24.00","30.00","116.00"),
                Arrays.asList("17.00","9.00","18.00","44.00"),
                Arrays.asList("73.00","9.00","53.00","135.00"),
                Arrays.asList("84.00","68.00","35.00","187.00"),
                Arrays.asList("41.00","97.00","96.00","234.00"),
                Arrays.asList("407.00","359.00","390.00","1,156.00"),
                Arrays.asList("50.88","44.88","48.75","144.50")
        );
        Table gradeTwoTable = figuresTable.invalidate().setRowsList(figures);
        board.appendTableTo(25, Board.APPEND_BELOW, gradeTwoTable);
        
        figures = Arrays.asList(
                Arrays.asList("31.00","26.00","8.00","65.00"),
                Arrays.asList("38.00","91.00","89.00","218.00"),
                Arrays.asList("39.00","42.00","9.00","90.00"),
                Arrays.asList("94.00","79.00","59.00","232.00"),
                Arrays.asList("35.00","71.00","52.00","158.00"),
                Arrays.asList("65.00","99.00","90.00","254.00"),
                Arrays.asList("23.00","43.00","40.00","106.00"),
                Arrays.asList("84.00","47.00","19.00","150.00"),
                Arrays.asList("409.00","498.00","366.00","1,273.00"),
                Arrays.asList("51.13","62.25","45.75","159.13")
        );
        Table gradeThreeTable = figuresTable.invalidate().setRowsList(figures);
        board.appendTableTo(26, Board.APPEND_BELOW, gradeThreeTable);
        //board.showBlockIndex(true);
        System.out.println(board.invalidate().build().getPreview());

    }

}
