package characterString.除自身以外数组的乘积_238;

public class productExceptSelf_238 {

    public static void main(String[] args) {
        int [] arry = {1,2,3,4};
        productExceptSelf_238 a = new productExceptSelf_238();
        System.out.println(a.productExceptSelf(arry));
    }

    public int[] productExceptSelf(int[] nums) {
        int [] retArray = new int[nums.length];
        int allSum = 1;
        int halfIndex = (nums.length - 1) / 2;
        int beginToHalfSum = calcuteSum(0, halfIndex, nums);
        int halfToEndSum = calcuteSum(halfIndex + 1, nums.length -1, nums);

        for(int k = 0; k < nums.length; k++) {
            if(k == 0) {
                int tempAllSum = calcuteSum(1, halfIndex, nums);
                allSum = tempAllSum * halfToEndSum;
            }else if(0 < k && k < halfIndex) {
                int tempAllSum1 = calcuteSum(0, k-1, nums);
                int tempAllSum2 = calcuteSum(k+1, halfIndex, nums);
                allSum = tempAllSum1 * tempAllSum2 * halfToEndSum;
            }else if(k == halfIndex) {
                int tempAllSum = calcuteSum(0, k -1, nums);
                allSum = tempAllSum * halfToEndSum;
            }else if(halfIndex < k && k < nums.length) {
                int tempAllSum1 = calcuteSum(halfIndex + 1, k -1, nums);
                int tempAllSum2 = calcuteSum(k + 1, nums.length -1, nums);
                allSum = tempAllSum1 * tempAllSum2 * beginToHalfSum;
            }else if(k == nums.length -1) {
                int tempAllSum = calcuteSum(halfIndex + 1, nums.length -2, nums);
                allSum = tempAllSum * beginToHalfSum;
            }
            retArray[k] = allSum;
            allSum = 1;
        }

        return retArray;

    }

    private int calcuteSum(int start, int end, int nums[]) {
        int allSum = 1;
        for(int i = start; i <= end; i++) {
            allSum = allSum * nums[i];
        }
        return allSum;
    }
}
