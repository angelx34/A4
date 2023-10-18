import java.util.Scanner;
import java.io.*;
import java.util.ArrayList ;

public class Maze implements DisplayableMaze {

    MazeContents [][] grid ;
    MazeLocation startPoint ;
    MazeLocation endPoint;
    int height ;
    int width ; // pass all of them , initialize them , in the solve then set it equal to info from 

  // the purpose of the maze class is to construct a maze from the file 
  // read the file 
  // set the attributes of maze according to the stuff in the file 
  // getters for the stuff in the maze 


public Maze (ArrayList<String> fileContents) {
      String[] mazeChoice = {"maze1","maze2"} ;

      height = fileContents.size();
      width = fileContents.get(0).length();
      grid = new MazeContents[this.height][this.width];
      
      for(int i= 0; i< fileContents.size(); i++) {
        String [] fileLine = fileContents.get(i).split("");
        for(int j = 0 ; j< fileLine.length;j++) {
          if (fileLine[j].equals("#")){
            grid[i][j] = MazeContents.WALL;
          }
          else if(fileLine[j].equals(".")) {
            grid[i][j]= MazeContents.OPEN;
          }
          else if(fileLine[j].equals("S")){
            grid[i][j]= MazeContents.OPEN;
            this.startPoint = new MazeLocation(i,j);
          }
          else if(fileLine[j].equals("F")) {
            grid[i][j]= MazeContents.OPEN;
            this.endPoint = new MazeLocation(i,j);
          }
        }
      }
    }
    

    // public Maze() {
    //   String[] mazeChoice = {"maze1","maze2"} ;
    //   Scanner file = null ;
    //   ArrayList<String> fileContents = new ArrayList<String>() ;

    //   try {
    //     file = new Scanner(new File (mazeChoice[0]));
    //   }catch (FileNotFoundException x) {
    //     System.err.println("Cannot Locate file.");
    //     System.exit(-1) ;
    //   }
    //   while (file.hasNextLine()) {
    //     String line = file.nextLine();
    //     fileContents.add(line) ;
    //   }
    //   height = fileContents.size();
    //   width = fileContents.get(0).length();
    //   grid = new MazeContents[this.height][this.width];
      
    //   for(int i= 0; i< fileContents.size(); i++) {
    //     String [] fileLine = fileContents.get(i).split("");
    //     for(int j = 0 ; j< fileLine.length;j++) {
    //       if (fileLine[j].equals("#")){
    //         grid[i][j] = MazeContents.WALL;
    //       }
    //       else if(fileLine[j].equals(".")) {
    //         grid[i][j]= MazeContents.OPEN;
    //       }
    //       else if(fileLine[j].equals("S")){
    //         grid[i][j]= MazeContents.OPEN;
    //         this.startPoint = new MazeLocation(i,j);
    //       }
    //       else if(fileLine[j].equals("F")) {
    //         grid[i][j]= MazeContents.OPEN;
    //         this.endPoint = new MazeLocation(i,j);
    //       }
    //     }
    //   }
    // }
  
    public boolean solve (MazeLocation here ) { 
      try { Thread.sleep(50);	} catch (InterruptedException e) {};
      int row = here.getRow() ;
      int col = here.getCol();
      grid[row][col] = MazeContents.VISITED ;
   
       // MazeContents mazecontents = maze.getContents(here.getRow(), here.getCol());
       // mazecontents = MazeContents.VISITED ; 
   
   // add another if statements to prevent from it getting out of bounds 
   
       if (here.getRow() == endPoint.getRow() && here.getCol() == endPoint.getCol()){
         System.out.println("You Won !");
         //mazecontents
         grid[row][col]= MazeContents.PATH ;
         return true ;
      }
       else {
           if (getContents(here.neighbor(MazeDirection.SOUTH).getRow(), here.neighbor(MazeDirection.SOUTH).getCol()) == MazeContents.OPEN ) {
             System.out.println("SOUTH!");
             Boolean southResult = solve(here.neighbor(MazeDirection.SOUTH));
             if (southResult == true){
               //mazecontents 
               grid[row][col]= MazeContents.PATH ;
               return true ;
             }
             else {
               return solve(here);
             }
           }
   
           else if (getContents(here.neighbor(MazeDirection.EAST).getRow(), here.neighbor(MazeDirection.EAST).getCol()) == MazeContents.OPEN ) {
             System.out.println("EAST!");
             Boolean eastResult = solve(here.neighbor(MazeDirection.EAST));
             if (eastResult == true){
               //mazecontents = MazeContents.PATH ;
               grid[row][col]= MazeContents.PATH ;
               return true ;
             }else {
               return solve(here);
             }
           }
           else if (getContents(here.neighbor(MazeDirection.WEST).getRow(), here.neighbor(MazeDirection.WEST).getCol()) == MazeContents.OPEN ) {
             System.out.println("WEST!");
             Boolean southResult = solve(here.neighbor(MazeDirection.WEST));
             if (southResult == true){
               //mazecontents = MazeContents.PATH ;
               grid[row][col]= MazeContents.PATH ;
               return true ;
             }else {
               return solve(here);
             }
           }
           else if (getContents(here.neighbor(MazeDirection.NORTH).getRow(), here.neighbor(MazeDirection.NORTH).getCol()) == MazeContents.OPEN ) {
             System.out.println("NORTH!");
             Boolean southResult = solve(here.neighbor(MazeDirection.NORTH));
             if (southResult == true){
               //mazecontents = MazeContents.PATH ;
               grid[row][col]= MazeContents.PATH ;
               return true ;
             }
             else {
               return solve(here);
             }
           }
           else{
             System.out.println("DEAD END");
             //mazecontents = MazeContents.DEAD_END ;
             grid[row][col]= MazeContents.DEAD_END ;
             return false;
           }
       }
       
     }
   


    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public MazeContents getContents(int i, int j) {
      if(i > grid.length-1 && i < 0 ){ 
        return MazeContents.WALL;
      }else if(j > grid.length-1 && j < 0 ){ 
        return MazeContents.WALL;
      }
        return grid[i][j];
    }

    @Override
    public MazeLocation getStart() {
        return startPoint;
    }

    @Override
    public MazeLocation getFinish() {
        return endPoint;
    }

    
}
