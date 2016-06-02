/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples.set1;

import wagu.Block;
import wagu.Board;

/**
 *
 * @author Thedath Oudarya
 */
public class C {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String blockData
                = "I wandered lonely as a cloud\n"
                + "That floats on high o'er vales and hills,\n"
                + "When all at once I saw a crowd,\n"
                + "A host, of golden daffodils;\n"
                + "Beside the lake, beneath the trees,\n"
                + "Fluttering and dancing in the breeze.\n";
        Board board = new Board(75);
        Block block = new Block(board, 50, 12, blockData)
                .setBlockAlign(Block.BLOCK_CENTRE)
                .setDataAlign(Block.DATA_BOTTOM_MIDDLE);
        String preview = board.setInitialBlock(block).build().getPreview();        
        System.out.println(preview);
    }
    
}
