/**
 * GuiFunction 
 * 
 * SelectionSort
 */
public class GuiFunction {

    private String[] namelist = {"homer","ian","reyes"};

    public static int[] selectionSort(final int[] arr) {
        
        for (int i = 0; i < arr.length-1; i++) {
            int  minValuePosition = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[minValuePosition]) {
                    minValuePosition=j;
                }
            }
            final int temp = arr[i];
            arr[i] = arr[minValuePosition];
            arr[minValuePosition] = temp;

            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k]+" ");
                }
            System.out.println();
        }
    return arr;
    }
    public static void SearchName(String name) {
        
        
    }
    public static void main(final String[] args) {
    
        final int[] array = {6,2,1,9,0};
       selectionSort(array);
    }
}