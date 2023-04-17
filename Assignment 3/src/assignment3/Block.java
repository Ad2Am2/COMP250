package assignment3;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class Block {
 private int xCoord;
 private int yCoord;
 private int size; // height/width of the square
 private int level; // the root (outer most block) is at level 0
 private int maxDepth; 
 private Color color;

 private Block[] children; // {UR, UL, LL, LR}

 public static Random gen = new Random(2);
 
 
 /*
  * These two constructors are here for testing purposes. 
  */
 public Block() {}
 
 public Block(int x, int y, int size, int lvl, int  maxD, Color c, Block[] subBlocks) {
  this.xCoord=x;
  this.yCoord=y;
  this.size=size;
  this.level=lvl;
  this.maxDepth = maxD;
  this.color=c;
  this.children = subBlocks;
 }
 
 

 /*
  * Creates a random block given its level and a max depth. 
  * 
  * xCoord, yCoord, size, and highlighted should not be initialized
  * (i.e. they will all be initialized by default)
  */
 public Block(int lvl, int maxDepth) {

  if (lvl < 0 || maxDepth < 0) throw new IllegalArgumentException("Inputs must be positive integers!");

  if (lvl < maxDepth) {
   double rand = gen.nextDouble();
   if (rand < Math.exp(-0.25*lvl)) {
    this.level = lvl;
    this.maxDepth = maxDepth;
    this.children = new Block[4];
    for (int i = 0; i < 4; i++){
     this.children[i] = new Block(lvl+1, maxDepth);
    }
   } else {
    this.level = lvl;
    this.maxDepth = maxDepth;
    this.color = GameColors.BLOCK_COLORS[gen.nextInt(4)];
    this.children = new Block[0];
   }
  } else if (lvl == maxDepth) {
   this.level = lvl;
   this.maxDepth = maxDepth;
   this.color = GameColors.BLOCK_COLORS[gen.nextInt(4)];
   this.children = new Block[0];
  } else throw new IllegalArgumentException("Level cannot be greater than max depth!");

 }


 /*
  * Updates size and position for the block and all of its sub-blocks, while
  * ensuring consistency between the attributes and the relationship of the 
  * blocks. 
  * 
  *  The size is the height and width of the block. (xCoord, yCoord) are the 
  *  coordinates of the top left corner of the block. 
  */
 public void updateSizeAndPosition (int size, int xCoord, int yCoord) {

  if (size <= 0 || size % Math.pow(2, this.maxDepth - this.level) != 0) throw new IllegalArgumentException("Size is invalid!");

  if (children.length != 0 && children.length != 4) throw new IllegalArgumentException("Children size is invalid!");

  if (children.length == 0){
   this.size = size;
   this.xCoord = xCoord;
   this.yCoord = yCoord;
  } else {
   children[0].updateSizeAndPosition(size/2, xCoord+(size/2), yCoord); // Upper right child
   children[1].updateSizeAndPosition(size/2, xCoord, yCoord); // Upper left child
   children[2].updateSizeAndPosition(size/2, xCoord, yCoord+(size/2)); // Lower left child
   children[3].updateSizeAndPosition(size/2, xCoord+(size/2), yCoord+(size/2)); // Lower right child
   this.size = size;
   this.xCoord = xCoord;
   this.yCoord = yCoord;
  }

 }

 
 /*
  * Returns a List of blocks to be drawn to get a graphical representation of this block.
  * 
  * This includes, for each undivided Block:
  * - one BlockToDraw in the color of the block
  * - another one in the FRAME_COLOR and stroke thickness 3
  * 
  * Note that a stroke thickness equal to 0 indicates that the block should be filled with its color.
  *  
  * The order in which the blocks to draw appear in the list does NOT matter.
  */
 public ArrayList<BlockToDraw> getBlocksToDraw() {

  if (xCoord < 0 || yCoord < 0 || size <= 0) throw new IllegalArgumentException("Invalid input!"); // TODO x and y could be negative??
  if (children.length != 0 && children.length != 4) throw new IllegalArgumentException("Children size is invalid!");

  ArrayList<BlockToDraw> array = new ArrayList<BlockToDraw>();

  if (children.length == 0) {
   if (color == null) throw new IllegalArgumentException("Invalid input!");
   array.add(new BlockToDraw(GameColors.FRAME_COLOR, xCoord, yCoord, size, 3));
   array.add(new BlockToDraw(color, xCoord, yCoord, size, 0));
  } else {
   for (int i = 0; i < children.length; i++) {

    ArrayList<BlockToDraw> child = children[i].getBlocksToDraw();

    for (int j = 0; j < child.size(); j++) {
     array.add(child.get(j));
    }

   }
  }

  return array;

 }



 /*
  * This method is provided and you should NOT modify it. 
  */
 public BlockToDraw getHighlightedFrame() {
  return new BlockToDraw(GameColors.HIGHLIGHT_COLOR, this.xCoord, this.yCoord, this.size, 5);
 }
 
 
 
 /*
  * Return the Block within this Block that includes the given location
  * and is at the given level. If the level specified is lower than 
  * the lowest block at the specified location, then return the block 
  * at the location with the closest level value.
  * 
  * The location is specified by its (x, y) coordinates. The lvl indicates 
  * the level of the desired Block. Note that if a Block includes the location
  * (x, y), and that Block is subdivided, then one of its sub-Blocks will 
  * contain the location (x, y) too. This is why we need lvl to identify 
  * which Block should be returned. 
  * 
  * Input validation: 
  * - this.level <= lvl <= maxDepth (if not throw exception)
  * - if (x,y) is not within this Block, return null.
  */
 public Block getSelectedBlock(int x, int y, int lvl) {

  Block output = null;

  if (lvl > maxDepth || lvl < level || lvl < 0 || !(x>=xCoord && x<=(xCoord+size)) || !(y>=yCoord && y<=(yCoord+size))) throw new IllegalArgumentException("Invalid input!"); // TODO x and y positive only?
  if (children.length != 0 && children.length != 4) throw new IllegalArgumentException("Children size is invalid!");

  if (level+1 <= lvl) {
   if (children.length == 0) {
    return this;
   } else {
    if (x>=xCoord && x<(xCoord+(size/2))) {
     if (y>=yCoord && y<(yCoord+(size/2))) { // Upper left quadrant
      output = children[1].getSelectedBlock(x,y,lvl);
     } else { // Bottom left quadrant
      output = children[2].getSelectedBlock(x,y,lvl);
     }
    } else {
     if (y>=yCoord && y<(yCoord+(size/2))) { // Upper right quadrant
      output = children[0].getSelectedBlock(x,y,lvl);
     } else { // Bottom right quadrant
      output = children[3].getSelectedBlock(x,y,lvl);
     }
    }
   }
  } else return this;
  return output;
 }
 

 /*
  * Swaps the child Blocks of this Block.
  * If input is 1, swap vertically. If 0, swap horizontally. 
  * If this Block has no children, do nothing. The swap 
  * should be propagate, effectively implementing a reflection
  * over the x-axis or over the y-axis.
  * 
  */
 public void reflect(int direction) {

  if (direction != 0 && direction != 1) throw new IllegalArgumentException("Invalid input!");
  if (children.length != 0 && children.length != 4) throw new IllegalArgumentException("Children size is invalid!");

  if (children.length == 0) return;

  Block[] newChildren = new Block[4];

  if (direction == 0) {

   children[0].reflect(direction);
   children[1].reflect(direction);
   children[2].reflect(direction);
   children[3].reflect(direction);

   newChildren[0] = children[3];
   newChildren[1] = children[2];
   newChildren[2] = children[1];
   newChildren[3] = children[0];

   children = newChildren;

  } else if (direction == 1) {
   children[0].reflect(direction);
   children[1].reflect(direction);
   children[2].reflect(direction);
   children[3].reflect(direction);

   newChildren[0] = children[1];
   newChildren[1] = children[0];
   newChildren[2] = children[3];
   newChildren[3] = children[2];

   children = newChildren;
  }
  this.updateSizeAndPosition(size, xCoord, yCoord);
 }
 

 
 /*
  * Rotate this Block and all its descendants. 
  * If the input is 1, rotate clockwise. If 0, rotate 
  * counterclockwise. If this Block has no children, do nothing.
  */
 public void rotate(int direction) {
  if (direction != 0 && direction != 1) throw new IllegalArgumentException("Invalid input!");
  if (children.length != 0 && children.length != 4) throw new IllegalArgumentException("Children size is invalid!");

  if (children.length == 0) return;

  Block[] newChildren = new Block[4];

  if (direction == 0) {

   children[0].rotate(direction);
   children[1].rotate(direction);
   children[2].rotate(direction);
   children[3].rotate(direction);

   newChildren[0] = children[3];
   newChildren[1] = children[0];
   newChildren[2] = children[1];
   newChildren[3] = children[2];

   children = newChildren;

  } else if (direction == 1) {
   children[0].rotate(direction);
   children[1].rotate(direction);
   children[2].rotate(direction);
   children[3].rotate(direction);

   newChildren[0] = children[1];
   newChildren[1] = children[2];
   newChildren[2] = children[3];
   newChildren[3] = children[0];

   children = newChildren;
  }
  this.updateSizeAndPosition(size, xCoord, yCoord);
 }
 


 /*
  * Smash this Block.
  * 
  * If this Block can be smashed,
  * randomly generate four new children Blocks for it.  
  * (If it already had children Blocks, discard them.)
  * Ensure that the invariants of the Blocks remain satisfied.
  * 
  * A Block can be smashed iff it is not the top-level Block 
  * and it is not already at the level of the maximum depth.
  * 
  * Return True if this Block was smashed and False otherwise.
  * 
  */
 public boolean smash() {

  if(!(level < maxDepth) || level <= 0) return false;
  if (children.length != 0 && children.length != 4) throw new IllegalArgumentException("Children size is invalid!");

  children = new Block[4];
  children[0] = new Block(level+1, maxDepth);
  children[1] = new Block(level+1, maxDepth);
  children[2] = new Block(level+1, maxDepth);
  children[3] = new Block(level+1, maxDepth);

  this.updateSizeAndPosition(size, xCoord, yCoord);

  return true;
 }
 
 
 /*
  * Return a two-dimensional array representing this Block as rows and columns of unit cells.
  * 
  * Return and array arr where, arr[i] represents the unit cells in row i, 
  * arr[i][j] is the color of unit cell in row i and column j.
  * 
  * arr[0][0] is the color of the unit cell in the upper left corner of this Block.
  */
 public Color[][] flatten() {

  if (size <= 0 || size % Math.pow(2, this.maxDepth - this.level) != 0) throw new IllegalArgumentException("Size is invalid!");

  if (children.length != 0 && children.length != 4) throw new IllegalArgumentException("Children size is invalid!");

  int unitSize = size/((int) (Math.pow(2,maxDepth - level)));

  Color [][] output = new Color[size/unitSize][size/unitSize ];

  if (level < maxDepth) {
   if (children.length == 0) {
    for (int i = 0; i < output.length; i++){
     for (int j = 0; j < output[i].length; j++){
      output[i][j] = color;
     }
    }
   } else {

    Color[][] upperRight = children[0].flatten();
    for (int i = 0; i < upperRight.length; i++){
     for (int j = 0; j < upperRight[i].length; j++){
      output[i][j+upperRight.length] = upperRight[i][j];
     }
    }

    Color[][] upperLeft = children[1].flatten();
    for (int i = 0; i < upperLeft.length; i++){
     for (int j = 0; j < upperLeft[i].length; j++){
      output[i][j] = upperLeft[i][j];
     }
    }

    Color[][] lowerLeft = children[2].flatten();
    for (int i = 0; i < lowerLeft.length; i++){
     for (int j = 0; j < lowerLeft[i].length; j++){
      output[i+lowerLeft.length][j] = lowerLeft[i][j];
     }
    }

    Color[][] lowerRight = children[3].flatten();
    for (int i = 0; i < lowerRight.length; i++){
     for (int j = 0; j < lowerRight[i].length; j++){
      output[i+lowerRight.length][j+lowerRight.length] = lowerRight[i][j];
     }
    }

   }
  } else {

   if (children.length != 0) throw new IllegalArgumentException("Children go beyond the max depth!");

   output[0][0] = color;

  }

  return output;

 }

 public static void main(String[] args) {
  Block blockDepth2 = new Block(0,2);
  blockDepth2.updateSizeAndPosition(20,0,0);
  blockDepth2.printBlock();
  blockDepth2.printColoredBlock();
 }

 
 
 // These two get methods have been provided. Do NOT modify them. 
 public int getMaxDepth() {
  return this.maxDepth;
 }
 
 public int getLevel() {
  return this.level;
 }


 /*
  * The next 5 methods are needed to get a text representation of a block. 
  * You can use them for debugging. You can modify these methods if you wish.
  */
 public String toString() {
  return String.format("pos=(%d,%d), size=%d, level=%d"
    , this.xCoord, this.yCoord, this.size, this.level);
 }

 public void printBlock() {
  this.printBlockIndented(0);
 }

 private void printBlockIndented(int indentation) {
  String indent = "";
  for (int i=0; i<indentation; i++) {
   indent += "\t";
  }

  if (this.children.length == 0) {
   // it's a leaf. Print the color!
   String colorInfo = GameColors.colorToString(this.color) + ", ";
   System.out.println(indent + colorInfo + this);   
  } else {
   System.out.println(indent + this);
   for (Block b : this.children)
    b.printBlockIndented(indentation + 1);
  }
 }
 
 private static void coloredPrint(String message, Color color) {
  System.out.print(GameColors.colorToANSIColor(color));
  System.out.print(message);
  System.out.print(GameColors.colorToANSIColor(Color.WHITE));
 }

 public void printColoredBlock(){
  Color[][] colorArray = this.flatten();
  for (Color[] colors : colorArray) {
   for (Color value : colors) {
    String colorName = GameColors.colorToString(value).toUpperCase();
    if(colorName.length() == 0){
     colorName = "\u2588";
    }else{
     colorName = colorName.substring(0, 1);
    }
    coloredPrint(colorName, value);
   }
   System.out.println();
  }
 }
 
}
