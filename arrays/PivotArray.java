import java.util.*;

public class PivotArray  {


static int[][] testArray = new int[4][4];


public void singleRotate( int[][] matrix ) {

    if(matrix == null || matrix.length==0)
            return ;

        int e = matrix.length-1;

        for(int i=0; i <= e; i++){
            for(int j=0; j <= e; j++){
                swap( matrix, i,j,j,e-i);
                //result[j][e-i] = matrix[i][j];
            }
        }
}

public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return new ArrayList<Integer>();

        return spiralOrder(matrix,0,0,matrix.length,matrix[0].length);
}


public ArrayList<Integer> spiralOrder(int [][] matrix, int x, int y, int m, int n){
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(m<=0||n<=0)
            return result;

        //only one element left
        if(m==1&&n==1) {
            result.add(matrix[x][y]);
            return result;
        }

        //top - move right
        for(int i=0;i<n-1;i++){
            result.add(matrix[x][y++]);
        }

        //right - move down
        for(int i=0;i<m-1;i++){
            result.add(matrix[x++][y]);
        }

        //bottom - move left
        if(m>1){
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
        }

        //left - move up
        if(n>1){
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
        }

        if(m==1||n==1)
            result.addAll(spiralOrder(matrix, x, y, 1, 1));
        else
            result.addAll(spiralOrder(matrix, x+1, y+1, m-2, n-2));

        return result;
}

private void swap( int[][] array, int x, int y, int a, int b ) {
  int t = array[x][y];
  array[x][y] = array[a][b];
  array[a][b] = t;
}

public void print( int[][] array ) {
    for (int i = 0; i < array.length; i++ ) {
      for (int j = 0; j < array[i].length; j++ ) {
	System.out.print("["+array[i][j]+"] ");
      }
      System.out.println();
    }
}

public void forwardBackward( int[][] array ) {
    for (int i = array.length-1; i >= 0; i-- ) {
      for (int j = array[i].length - 1; j >=0; j-- ) {
	System.out.print("["+array[i][j]+"] ");
      }
      System.out.println();
    }
}


public static void main(String args[]) {

  testArray[0][0] = 1;
  testArray[1][0] = 2;
  testArray[2][0] = 3;
  testArray[3][0] = 4;

  testArray[0][1] = 5;
  testArray[1][1] = 6;
  testArray[2][1] = 7;
  testArray[3][1] = 8;

  testArray[0][2] = 9;
  testArray[1][2] = 10;
  testArray[2][2] = 11;
  testArray[3][2] = 12;

  testArray[0][3] = 13;
  testArray[1][3] = 14;
  testArray[2][3] = 15;
  testArray[3][3] = 16;

  PivotArray pa = new PivotArray();
  pa.print( testArray );
  //System.out.println("----Single Rotate--------");
  //pa.singleRotate( testArray);
  System.out.println("------ Spiral --------");
  pa.spiralOrder( testArray);
  //pa.print( testArray );

}

}