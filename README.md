# Wagu
Wagu helps you to present your data (text) in tables and blocks.
I've add some examples [here](https://github.com/thedathoudarya/wagu/tree/wagu-branch/examples) to show how Wagu makes your life easy on above manner. Following are some of the examples in terminal-outputs with relavent code. I will add more examples eventually, to show you how to handle Wagu in various ways to build your text according to your own desire.
## Example 1 - Terminal Output
```sh
+--------------+--------------+--------------+--------------+-------------+
|NAME          |GENDER        |MARRIED       |           AGE|    SALARY($)|
+--------------+--------------+--------------+--------------+-------------+
|Eddy          |Male          |No            |            23|      1200.27|
|Libby         |Male          |No            |            17|       800.50|
|Rea           |Female        |No            |            30|     10000.00|
|Deandre       |Female        |No            |            19|     18000.50|
|Alice         |Male          |Yes           |            29|       580.40|
|Alyse         |Female        |No            |            26|      7000.89|
|Venessa       |Female        |No            |            22|    100700.50|
+--------------+--------------+--------------+--------------+-------------+
```
And here’s the code to do above all.
## Example 1 - Code
```sh
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
//bookmark 1
Board board = new Board(75);
String tableString = board.setInitialBlock(new Table(board, 75, headersList, rowsList).tableToBlocks()).build().getPreview();
System.out.println(tableString);
```
That's it! List objects holds all your data and the code after bookmark 1, is the part where the terminal output you see is being build.  

You might found the codes after bookmark 1, bit disturbing. Followng code is much clear and readable but gives the same output. 
```sh
Board board = new Board(75);
Table table = new Table(board, 75, headersList, rowsList);
Block tableBlock = table.tableToBlocks();
board.setInitialBlock(tableBlock);
board.build();
String tableString = board.getPreview();
System.out.println(tableString);
```
You can stick to any code you prefer but, I suggest the first method. When you get along with Wagu, first code might come in handy.
## Example 2 - Terminal Output
```sh
+--------------+--------------+-------------+--------------+--------------+
|     NAME     |    GENDER    |   MARRIED   |      AGE     |   SALARY($)  |
+--------------+--------------+-------------+--------------+--------------+
|     Eddy     |     Male     |      No     |      23      |    1200.27   |
|     Libby    |     Male     |      No     |      17      |    800.50    |
|      Rea     |    Female    |      No     |      30      |   10000.00   |
|    Deandre   |    Female    |      No     |      19      |   18000.50   |
|     Alice    |     Male     |     Yes     |      29      |    580.40    |
|     Alyse    |    Female    |      No     |      26      |    7000.89   |
|    Venessa   |    Female    |      No     |      22      |   100700.50  |
+--------------+--------------+-------------+--------------+--------------+
```
When comparing with the output of example 1, you can see that in example 2, all the text in cells have center-aligned. Following code adde as a modification to the code in example 1 to get the above output.
```sh
List<Integer> colAlignList = Arrays.asList(
    Block.DATA_CENTER, 
    Block.DATA_CENTER, 
    Block.DATA_CENTER, 
    Block.DATA_CENTER, 
    Block.DATA_CENTER);
table.setColAlignsList(colAlignList);
```
## Example 3 - Terminal Output
```sh
+------------------------+-------------+------+-------------+-------------+
|NAME                    |GENDER       |MARRIE|          AGE|    SALARY($)|
+------------------------+-------------+------+-------------+-------------+
|Eddy                    |Male         |No    |           23|      1200.27|
+------------------------+-------------+------+-------------+-------------+
|Libby                   |Male         |No    |           17|       800.50|
+------------------------+-------------+------+-------------+-------------+
|Rea                     |Female       |No    |           30|     10000.00|
+------------------------+-------------+------+-------------+-------------+
|Deandre                 |Female       |No    |           19|     18000.50|
+------------------------+-------------+------+-------------+-------------+
|Alice                   |Male         |Yes   |           29|       580.40|
+------------------------+-------------+------+-------------+-------------+
|Alyse                   |Female       |No    |           26|      7000.89|
+------------------------+-------------+------+-------------+-------------+
|Venessa                 |Female       |No    |           22|    100700.50|
+------------------------+-------------+------+-------------+-------------+
```
Note that when comparing with previous two examples, there are two main changes in this table. First one (and the big) is the full grid and second is the changes in width of columns.
## Example 3 - Code
```sh
List<Integer> colWidthsListEdited = Arrays.asList(24, 13, 6, 13, 13);
table.setGridMode(Table.GRID_FULL).setColWidthsList(colWidthsListEdited);
```
## Example 4 - Terminal Output
```sh
NAME                    GENDER       MARRIE          AGE    SALARY($)      
Alice                   Male         Yes              29       580.40      
Alyse                   Female       No               26      7000.89      
Eddy                    Male         No               23      1200.27      
Rea                     Female       No               30     10000.00      
Deandre                 Female       No               19     18000.50      
Venessa                 Female       No               22    100700.50      
Libby                   Male         No               17       800.50      
Eddy                    Male         No               23      1200.27      
Libby                   Male         No               17       800.50      
Rea                     Female       No               30     10000.00      
Deandre                 Female       No               19     18000.50      
Alice                   Male         Yes              29       580.40      
Alyse                   Female       No               26      7000.89      
Venessa                 Female       No               22    100700.50      
```
## Example 4 - Code
```sh
table.setGridMode(Table.GRID_NON);
```
So, those are some of basic table-views that can be built by Wagu. Next example is a view of an 'invoice' that I created in a project I've been involved. Idea was to print the invoice details in a 3-inch paper, which can print maximum 48 characters horizontally. And here’s how I managed to do that using Wagu.
## Example 5 - Terminal Output
```sh
                                                
           PLATINUM COMPUTERS(PVT) LTD          
     NO 20/B, Main Street, Kandy, Sri Lanka.    
  Land: 812254630 Mob: 712205220 Fax: 812254639 
                                                
                CUSTOMER INVOICE                
                                                
+-----------------------+----------------------+
|INFO                   |CUSTOMER              |
+-----------------------+----------------------+
|DATE: 2015-9-8         |ModernTec Distributors|
|TIME: 10:53:AM         |MOB: +94719530398     |
|BILL NO: 12            |ADDRES: No 25, Main St|
|INVOICE NO: 458-80-108 |reet, Kandy.          |
+-----------------------+----------------------+
|                SELLING DETAILS               |
+-----------------+---------+-----+------------+
|ITEM             | PRICE($)|  QTY|       VALUE|
+-----------------+---------+-----+------------+
|Optical mouse    |   120.00|   20|     2400.00|
|Gaming keyboard  |   550.00|   30|    16500.00|
|320GB SATA HDD   |   220.00|   32|     7040.00|
|500GB SATA HDD   |   274.00|   13|     3562.00|
|1TB SATA HDD     |   437.00|   11|     4807.00|
|RE-DVD ROM       |   144.00|   29|     4176.00|
|DDR3 4GB RAM     |   143.00|   13|     1859.00|
|Blu-ray DVD      |    94.00|   28|     2632.00|
|WR-DVD           |   122.00|   34|     4148.00|
|Adapter          |   543.00|   28|    15204.00|
+-----------------+---------+-----+------------+
|               RETURNING DETAILS              |
+-----------------+---------+-----+------------+
|ITEM             | PRICE($)|  QTY|       VALUE|
+-----------------+---------+-----+------------+
|320GB SATA HDD   |   220.00|    4|      880.00|
|WR-DVD           |   122.00|    7|      854.00|
|1TB SATA HDD     |   437.00|    7|     3059.00|
|RE-DVD ROM       |   144.00|    4|      576.00|
|Gaming keyboard  |   550.00|    6|     3300.00|
|DDR3 4GB RAM     |   143.00|    7|     1001.00|
+-----------------+---------+-----+------------+
                              GROSS   59,928.00 
                       DISCOUNT(5%)    2,996.40 
                             RETURN    9,670.00 
                            PAYABLE   47,261.60 
                               CASH   20,000.00 
                             CHEQUE   15,000.00 
                    CREDIT(BALANCE)   12,261.60 
                                                
                                                
                                                
                                                
                                                
                                                
  ---------------------   --------------------- 
     CASH COLLECTOR         GOODS RECEIVED BY   
                                                
             soulution by clough.com            
```
As you see it is much complex than other examples and couse some additional coding than above examples. Organizing the values in list objects also going to be complex. Threfore, I won't adding the relavent code here, you can find the source code for above view in [here](https://github.com/thedathoudarya/wagu/blob/wagu-branch/examples/set3/Bill.java) in my examples.  
  
I have created a much complex table-view to show you how far Wagu can go in creating tables-views.  
Following image is the excel view of that table.
![Excel table](https://github.com/thedathoudarya/wagu/blob/wagu-branch/adnacedtable.png)
Code for following table view can be found in [here.](https://github.com/thedathoudarya/wagu/blob/wagu-branch/examples/set3/AdvancedTable.java)
## Example 6 - Terminal Output
```sh
+---------+-------------------------------+-----------------------------------------------------------------------------------------------------------------------------------+
|         |                               |                                                               GRADE                                                               |
| STUDENT |              NAME             +-------------------------------------------+-------------------------------------------+-------------------------------------------+
| DETAILS |                               |                    ONE                    |                    TWO                    |                   THREE                   |
|  TABLE  +---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |FIRST          |LAST           |     MATHS|   SCIENCE|   ENGLISH|     TOTAL|     MATHS|   SCIENCE|   ENGLISH|     TOTAL|     MATHS|   SCIENCE|   ENGLISH|     TOTAL|
+---------+---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |Eddy           |Eason          |     68.00|     10.00|     42.00|    120.00|     49.00|     36.00|     38.00|    123.00|     31.00|     26.00|      8.00|     65.00|
|         +---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |Libby          |Langstaff      |     31.00|     23.00|     79.00|    133.00|      6.00|     97.00|     94.00|    197.00|     38.00|     91.00|     89.00|    218.00|
|         +---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |Rea            |Ramaker        |     12.00|     46.00|     26.00|     84.00|     75.00|     19.00|     26.00|    120.00|     39.00|     42.00|      9.00|     90.00|
|         +---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |Deandre        |Doan           |     81.00|     38.00|     68.00|    187.00|     62.00|     24.00|     30.00|    116.00|     94.00|     79.00|     59.00|    232.00|
| STUDENT +---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |Alice          |Applebaum      |     20.00|     54.00|     14.00|     88.00|     17.00|      9.00|     18.00|     44.00|     35.00|     71.00|     52.00|    158.00|
|         +---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |Alyse          |Augustyn       |     49.00|     84.00|     32.00|    165.00|     73.00|      9.00|     53.00|    135.00|     65.00|     99.00|     90.00|    254.00|
|         +---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |Venessa        |Vreeland       |     70.00|     72.00|     45.00|    187.00|     84.00|     68.00|     35.00|    187.00|     23.00|     43.00|     40.00|    106.00|
|         +---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|         |Bernie         |Berube         |     19.00|     58.00|     32.00|    109.00|     41.00|     97.00|     96.00|    234.00|     84.00|     47.00|     19.00|    150.00|
+---------+---------------+---------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|                  TOTAL                  |    350.00|    385.00|    338.00|  1,073.00|    407.00|    359.00|    390.00|  1,156.00|    409.00|    498.00|    366.00|  1,273.00|
+-----------------------------------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
|                 AVERAGE                 |     43.75|     48.13|     42.25|    134.13|     50.88|     44.88|     48.75|    144.50|     51.13|     62.25|     45.75|    159.13|
+-----------------------------------------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+
```
Right now, there are no any doc-comments or developer-comments in source files. But, I'll add them soon, with more examples.  
