import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class SolveMaze {
  Maze maze;

 
// the solve method should hold the recursive function 
// needs maze to call the start , endpoint , mazecontents 

  //constructor 
  public SolveMaze (Maze maze) {
    this.maze = maze;
    
    

  }
  
//   public boolean solve (MazeLocation here ) { 

//    int row = here.getRow() ;
//    int col = here.getCol();
//    grid[row][col] = MazeContents.VISITED ;

//     // MazeContents mazecontents = maze.getContents(here.getRow(), here.getCol());
//     // mazecontents = MazeContents.VISITED ; 

// // add another if statements to prevent from it getting out of bounds 

//     if (here.getRow() == maze.getFinish().getRow() && here.getCol() == maze.getFinish().getCol()){
//       System.out.println("You Won !");
//       //mazecontents
//       grid[row][col]= MazeContents.PATH ;
//       return true ;
//    }
//     else {
//         if (maze.getContents(here.neighbor(MazeDirection.SOUTH).getRow(), here.neighbor(MazeDirection.SOUTH).getCol()) == MazeContents.OPEN ) {
//           System.out.println("SOUTH!");
//           Boolean southResult = solve(here.neighbor(MazeDirection.SOUTH));
//           if (southResult == true){
//             //mazecontents 
//             grid[row][col]= MazeContents.PATH ;
//             return true ;
//           }
//           else {
//             return solve(here);
//           }
//         }

//         else if (maze.getContents(here.neighbor(MazeDirection.EAST).getRow(), here.neighbor(MazeDirection.EAST).getCol()) == MazeContents.OPEN ) {
//           System.out.println("EAST!");
//           Boolean southResult = solve(here.neighbor(MazeDirection.EAST));
//           if (southResult == true){
//             //mazecontents = MazeContents.PATH ;
//             grid[row][col]= MazeContents.PATH ;
//             return true ;
//           }else {
//             return solve(here);
//           }
//         }
//         else if (maze.getContents(here.neighbor(MazeDirection.WEST).getRow(), here.neighbor(MazeDirection.WEST).getCol()) == MazeContents.OPEN ) {
//           System.out.println("WEST!");
//           Boolean southResult = solve(here.neighbor(MazeDirection.WEST));
//           if (southResult == true){
//             //mazecontents = MazeContents.PATH ;
//             grid[row][col]= MazeContents.PATH ;
//             return true ;
//           }else {
//             return solve(here);
//           }
//         }
//         else if (maze.getContents(here.neighbor(MazeDirection.NORTH).getRow(), here.neighbor(MazeDirection.NORTH).getCol()) == MazeContents.OPEN ) {
//           System.out.println("NORTH!");
//           Boolean southResult = solve(here.neighbor(MazeDirection.NORTH));
//           if (southResult == true){
//             //mazecontents = MazeContents.PATH ;
//             grid[row][col]= MazeContents.PATH ;
//             return true ;
//           }
//           else {
//             return solve(here);
//           }
//         }
//         else{
//           System.out.println("DEAD END");
//           //mazecontents = MazeContents.DEAD_END ;
          
//           return false;
//         }
//     }
    
//   }


  

 
  public static void main(String[] args) {
    // Maze maze ;
    // if (args.length > 0) {
    //   maze = new Maze(args[0]);
    // } else {
    //   maze = new Maze () ;
    // }
    
    Scanner file = null;
    ArrayList<String> fileContents = new ArrayList<String>() ;

    if (args.length > 0) {
      String filename = args[0];
      try {
        file = new Scanner(new File (filename));
      }catch (FileNotFoundException x) {
        System.err.println("Cannot Locate file.");
        System.exit(-1) ;
      }
    }
    else {
      file = new Scanner(System.in);
    }

    while (file.hasNextLine()) {
        String line = file.nextLine();
        fileContents.add(line) ;
    }
    
    Maze maze = new Maze(fileContents);
    MazeViewer viewer = new MazeViewer(maze);
    SolveMaze solver = new SolveMaze(maze);
    maze.solve(maze.getStart());
    
    
    
  }

























  // public boolean solveMaze (int i, int j, MazeLocation currentLocation) {
  //   if (currentLocation.equals(maze.getFinish())) {
  //     return true ;
  //  }else if(!currentLocation.neighbor(MazeDirection.NORTH).equals(MazeContents.WALL) || !currentLocation.neighbor(MazeDirection.NORTH).equals(MazeContents.VISITED)) {
  //   currentLocation.setRow(i++);
  //   currentLocation.setCol(j);
  
  //   solveMaze(currentLocation.getRow(), currentLocation.getCol(), currentLocation);

  //  }else if (!currentLocation.neighbor(MazeDirection.SOUTH).equals(MazeContents.WALL) || !currentLocation.neighbor(MazeDirection.SOUTH).equals(MazeContents.VISITED)){
  //   currentLocation.setRow(i++);
  //   currentLocation.setCol(j);
    
  //   solveMaze(currentLocation.getRow(), currentLocation.getCol(), currentLocation);

  //  }else if (!currentLocation.neighbor(MazeDirection.EAST).equals(MazeContents.WALL) || !currentLocation.neighbor(MazeDirection.EAST).equals(MazeContents.VISITED)){
  //   currentLocation.setRow(i++);
  //   currentLocation.setCol(j);
  //   solveMaze(currentLocation.getRow(), currentLocation.getCol(), currentLocation);

  //  }else if (!currentLocation.neighbor(MazeDirection.SOUTH).equals(MazeContents.WALL) || !currentLocation.neighbor(MazeDirection.SOUTH).equals(MazeContents.VISITED)){
  //   currentLocation.setRow(i++);
  //   currentLocation.setCol(j);
  //   solveMaze(currentLocation.getRow(), currentLocation.getCol(), currentLocation);
  //  }
  // }

















  //  public boolean isitF (MazeLocation endPoint, MazeLocation currentLocation ){
  //  if (currentLocation.getRow() == endPoint.getRow() && currentLocation.getCol() == endPoint.getCol()) {
      
  //    }
  //     if () {
      

  //    }


  //  }
  }
  