public class Test {
    
    public static int binarySearch(int nums[],int key){
        int start=0;
        int end=nums.length-1;

        while (start<=end) {
            int mid=(start+end)/2;
            if(nums[mid]==key){
                return mid;
            }
            else if(nums[mid]<key){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
        int key=4;

        System.out.println(binarySearch(nums, key));
            
        
    }
    
}
