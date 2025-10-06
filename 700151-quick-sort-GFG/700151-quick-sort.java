class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low<high){
            int pivotIndex=partition(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
            
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot=high;
        int index=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<=arr[pivot]){
                index++;
                int temp=arr[j];
                arr[j]=arr[index];
                arr[index]=temp;
            }
        }
        int t=arr[index+1];
        arr[index+1]=arr[high];
        arr[high]=t;
        return index+1;
    }
    
}