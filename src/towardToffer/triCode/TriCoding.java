package towardToffer.triCode;

public class TriCoding {
    public static void main(String[] args)
    {
        // 测试用例
        TriCoding t = new TriCoding();
        System.out.println(t.triCoding(123));

    }

    public String triCoding(int num) {
        StringBuilder sb = new StringBuilder();
        String transformString = transform(num, 3);
        sb.append(transformString);
        for(int i = 0; i < sb.length(); i ++) {
            if(sb.charAt(i) == '0') {
                sb.setCharAt(i, '@');
            }

            if(sb.charAt(i) == '1') {
                sb.setCharAt(i, '$');
            }

            if(sb.charAt(i) == '2') {
                sb.setCharAt(i, '&');
            }
        }
        return sb.toString();
    }


    public String transform(int num,int n){
        //参数num为输入的十进制数，参数n为要转换的进制
        int array[]=new int[100];
        int location=0;
        while(num!=0){//当输入的数不为0时循环执行求余和赋值
            int remainder=num%n;
            num = num/n;
            array[location]=remainder;//将结果加入到数组中去
            location++;
        }
        return show(array,location-1);
    }

    private String show(int[] arr,int n){
        StringBuilder sb = new StringBuilder();
        for(int i=n;i>=0;i--){
            if(arr[i]>9){
                sb.append((char)(arr[i]+55));
            } else {
                sb.append(arr[i]+"");
            }
        }
        return sb.toString();
    }

}
