package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }


    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int v = intArrayTri.length;
        int b = intArrayTri[0].length;
        int w = intArrayTri[0][0].length;

        int[][] flatArray = new int[b][w];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < w; k++) {
                    flatArray[j][k] += intArrayTri[i][j][k];
                }
            }
        }
        return flatArray;
    }



    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            builder.append(stringFlatMatrixRow(intArrayBi, i));
               if (i < intArrayBi.length - 1){
                   builder.append("\n");
               }
        }
        return builder.toString();
    }


    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <uniArray.length ; i++) {
         builder.append(uniArray[i]);
            if(i < (uniArray.length - 1)){
                builder.append(" ");
            }
        }
        return builder.toString();

    }


    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] array = new int[columns];
        for (int i = 0; i < array.length; i++) {
           array[i] = i + 1;
        }
        return array;
    }


    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] biArray = new int[rows][columns];
        int contador = 1;
        for (int i = 0; i < biArray.length; i++) {
            for (int j = 0; j < biArray[i].length; j++) {
                biArray[i][j] = contador++;
            }
        }
        return biArray;
    }


    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] triArray = new int[depth][rows][columns];
        int contador = 1;
        for (int i = 0; i < triArray.length; i++) {
            for (int j = 0; j < triArray[i].length; j++) {
                for (int k = 0; k < triArray[i][j].length; k++) {
                    triArray[i][j][k] = contador++;
                }
            }
        }
        return triArray;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
