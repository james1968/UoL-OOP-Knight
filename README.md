1. Move a night on the chessboard
   Exercise: Knight’s tour

Task: Implement a method that for a given a chessboard configuration with one knight, 
calculates if the knight can reach a target position, and if so, the smallest number of
moves needed.
In this exercise, you are asked to write a method that, given a chessboard with one 
knight, rocks on some of the squares, and a target position, indicates whether or not 
the knight can reach the target without landing on any rocks, and if so, the smallest 
number of moves needed by the knight to reach the target.

Challenge
Specifically, implement a method with the following header:
public static int numMoves( int dim, int xstart, int ystart,
int xtarget, int ytarget, int[] xrock, int[] yrock )
Here,
dim is the dimension of the chessboard, and will be between 1 and 20 (inclusive).
The squares of the chessboard are denoted by their positions; each position is a pair 
(x,y) where 0 <= x < dim, and 0 <= y < dim.
The knight’s initial position is (xstart, ystart).
It can be assumed that this pair is a valid position.
The target position is (xtarget, ytarget).
The positions of the rocks are given by the arrays xrock and yrock; these arrays will have the same
length L, and the rock positions are the pairs (xrock[i], yrock[i]) where i varies from 0 to L-1 (inclusive).
It can be assumed that each pair given, in each of the last 3 bullet points, is a valid position.