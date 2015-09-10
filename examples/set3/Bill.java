/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.set3;

import java.util.Arrays;
import java.util.List;
import wagu.Block;
import wagu.Board;
import wagu.Table;

/**
 *
 * @author Thedath Oudarya
 */
public class Bill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String company = ""
                + "PLATINUM COMPUTERS(PVT) LTD\n"
                + "NO 20/B, Main Street, Kandy, Sri Lanka.\n"
                + "Land: 812254630 Mob: 712205220 Fax: 812254639\n"
                + " \n"
                + "CUSTOMER INVOICE\n"
                + " \n";
        List<String> t1Headers = Arrays.asList("INFO", "CUSTOMER");
        List<List<String>> t1Rows = Arrays.asList(
                Arrays.asList("DATE: 2015-9-8", "ModernTec Distributors"),
                Arrays.asList("TIME: 10:53:AM", "MOB: +94719530398"),
                Arrays.asList("BILL NO: 12", "ADDRES: No 25, Main Street, Kandy."),
                Arrays.asList("INVOICE NO: 458-80-108", "")
        );
        String t2Desc = "SELLING DETAILS";
        List<String> t2Headers = Arrays.asList("ITEM", "PRICE($)", "QTY", "VALUE");
        List<List<String>> t2Rows = Arrays.asList(
                Arrays.asList("Optical mouse", "120.00", "20", "2400.00"),
                Arrays.asList("Gaming keyboard", "550.00", "30", "16500.00"),
                Arrays.asList("320GB SATA HDD", "220.00", "32", "7040.00"),
                Arrays.asList("500GB SATA HDD", "274.00", "13", "3562.00"),
                Arrays.asList("1TB SATA HDD", "437.00", "11", "4807.00"),
                Arrays.asList("RE-DVD ROM", "144.00", "29", "4176.00"),
                Arrays.asList("DDR3 4GB RAM", "143.00", "13", "1859.00"),
                Arrays.asList("Blu-ray DVD", "94.00", "28", "2632.00"),
                Arrays.asList("WR-DVD", "122.00", "34", "4148.00"),
                Arrays.asList("Adapter", "543.00", "28", "15204.00")
        );
        List<Integer> t2ColWidths = Arrays.asList(17, 9, 5, 12);
        String t3Desc = "RETURNING DETAILS";
        List<String> t3Headers = Arrays.asList("ITEM", "PRICE($)", "QTY", "VALUE");
        List<List<String>> t3Rows = Arrays.asList(
                Arrays.asList("320GB SATA HDD", "220.00", "4", "880.00"),
                Arrays.asList("WR-DVD", "122.00", "7", "854.00"),
                Arrays.asList("1TB SATA HDD", "437.00", "7", "3059.00"),
                Arrays.asList("RE-DVD ROM", "144.00", "4", "576.00"),
                Arrays.asList("Gaming keyboard", "550.00", "6", "3300.00"),
                Arrays.asList("DDR3 4GB RAM", "143.00", "7", "1001.00")
        );
        String summary = ""
                + "GROSS\n"
                + "DISCOUNT(5%)\n"
                + "RETURN\n"
                + "PAYABLE\n"
                + "CASH\n"
                + "CHEQUE\n"
                + "CREDIT(BALANCE)\n";
        String summaryVal = ""
                + "59,928.00\n"
                + "2,996.40\n"
                + "9,670.00\n"
                + "47,261.60\n"
                + "20,000.00\n"
                + "15,000.00\n"
                + "12,261.60\n";
        String sign1 = ""
                + "---------------------\n"
                + "CASH COLLECTOR\n";
        String sign2 = ""
                + "---------------------\n"
                + "GOODS RECEIVED BY\n";
        String advertise = "soulution by clough.com";

        //bookmark
        Board b = new Board(48);
        b.setInitialBlock(new Block(b, 46, 7, company).allowGrid(false).setBlockAlign(Block.BLOCK_CENTRE).setDataAlign(Block.DATA_CENTER));
        b.appendTableTo(0, Board.APPEND_BELOW, new Table(b, 48, t1Headers, t1Rows));
        b.getBlock(3).setBelowBlock(new Block(b, 46, 1, t2Desc).setDataAlign(Block.DATA_CENTER));
        b.appendTableTo(5, Board.APPEND_BELOW, new Table(b, 48, t2Headers, t2Rows, t2ColWidths));
        b.getBlock(10).setBelowBlock(new Block(b, 46, 1, t3Desc).setDataAlign(Block.DATA_CENTER));
        b.appendTableTo(14, Board.APPEND_BELOW, new Table(b, 48, t3Headers, t3Rows, t2ColWidths));
        Block summaryBlock = new Block(b, 35, 9, summary).allowGrid(false).setDataAlign(Block.DATA_MIDDLE_RIGHT);
        b.getBlock(19).setBelowBlock(summaryBlock);
        Block summaryValBlock = new Block(b, 12, 9, summaryVal).allowGrid(false).setDataAlign(Block.DATA_MIDDLE_RIGHT);
        summaryBlock.setRightBlock(summaryValBlock);
        Block sign1Block = new Block(b, 24, 7, sign1).setDataAlign(Block.DATA_BOTTOM_MIDDLE).allowGrid(false);
        summaryBlock.setBelowBlock(sign1Block);
        sign1Block.setRightBlock(new Block(b, 24, 7, sign2).setDataAlign(Block.DATA_BOTTOM_MIDDLE).allowGrid(false));
        sign1Block.setBelowBlock(new Block(b, 48, 3, advertise).setDataAlign(Block.DATA_CENTER).allowGrid(false));
        //b.showBlockIndex(true);
        System.out.println(b.invalidate().build().getPreview());

    }

}
