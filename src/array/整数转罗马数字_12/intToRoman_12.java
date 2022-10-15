package array.整数转罗马数字_12;

public class intToRoman_12 {

    public static void main(String[] args) {
        intToRoman_12 a = new intToRoman_12();
        int num = 1994;
        System.out.println(a.intToRoman(num));
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] replace = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String ret = "";
        for (int i = 0; i <= values.length - 1; i++) {
            while (num >= values[i]) {
                num -= values[i];
                ret += replace[i];
            }
        }
        return ret;
    }
    /*
        public String intToRoman(int num) {
            Map<Integer, String> stringMap = new HashMap<>();
            stringMap.put(1, "I");
            stringMap.put(5, "V");
            stringMap.put(10, "X");
            stringMap.put(40, "XL");
            stringMap.put(50, "L");
            stringMap.put(90, "XC");
            stringMap.put(100, "C");
            stringMap.put(400, "CD");
            stringMap.put(500, "D");
            stringMap.put(1000, "M");

            if(num >=1 && num < 5) {
                return getRomanValueByLessFiveInt(num);
            }

            if(num >= 5 && num < 10) {
                return getRomanValueByFiveInt(num, stringMap);
            }

            if(num >=10 && num <40) {
                return getRomanValueByTenInt(num, stringMap);
            }
            if(num >=40 && num < 50) {
                return getRomanValueByFourTenInt(num, stringMap);
            }

            if(num >=50 && num < 90) {
                return getRomanValueByFiveTeenInt(num, stringMap);
            }

            if(num >=90 && num < 100) {
                return getRomanValueByNineTeenInt(num, stringMap);
            }

            if(num >=100 && num <400) {
                return getRomanValueByHandrandInt(num, stringMap);
            }

            if(num >=100 && num <500) {
                return getRomanValueByHandrandInt(num, stringMap);
            }
            if(num >= 500 && num < 1000) {
                return getRomanValueByFiveHandrandInt(num, stringMap);
            }

            if(num >=1000) {
                return getRomanValueByThrandInt(num, stringMap);
            }
            return "";
        }


        private void getStringByDif(int num, int dif, Map<Integer, String> stringMap, StringBuilder stringBuilder) {
            for(int i = 0; i <= dif - 1; i++) {
                stringBuilder.append(stringMap.get(num));
            }
        }

        private String getRomanValueByLessFiveInt(int num) {
            if(num == 1) {
                return "I";
            }

            if(num == 2) {
                return "II";
            }

            if(num == 3) {
                return "III";
            }

            if(num == 4) {
                return "IV";
            }
            return "";
        }

        private String getRomanValueByFiveInt(int num, Map<Integer, String> stringMap) {
            if(num == 5) {
                return "V";
            }

            if(num == 9) {
                return "IX";
            }
            StringBuilder stringBuilder = new StringBuilder();
            int dif = (int) Math.floor(num/5);
            int remain = num % 5;
            getStringByDif(5, dif, stringMap, stringBuilder);
            if(remain == 0) {
                return stringBuilder.toString();
            }else {
                stringBuilder.append(getRomanValueByLessFiveInt(remain));
            }
            return stringBuilder.toString();
        }

        private String getRomanValueByTenInt(int num, Map<Integer, String> stringMap) {
            if(num == 10) {
                return "X";
            }

            StringBuilder stringBuilder = new StringBuilder();
            int dif = (int) Math.floor(num/10);
            int remain = num % 10;
            getStringByDif(10, dif, stringMap, stringBuilder);
            if(remain == 0) {
                return stringBuilder.toString();
            }else if(remain >=1 && remain <5) {
                stringBuilder.append(getRomanValueByLessFiveInt(remain));
            }else {
                stringBuilder.append(getRomanValueByFiveInt(remain, stringMap));
            }
            return stringBuilder.toString();

        }

        private String getRomanValueByFourTenInt(int num, Map<Integer, String> stringMap) {
            if(num == 40) {
                return "XL";
            }

            StringBuilder stringBuilder = new StringBuilder();
            int dif = (int) Math.floor(num/40);
            int remain = num % 40;
            getStringByDif(40, dif, stringMap, stringBuilder);
            if(remain == 0) {
                return stringBuilder.toString();
            }else if(remain >=1 && remain <5) {
                stringBuilder.append(getRomanValueByLessFiveInt(remain));
            }else {
                stringBuilder.append(getRomanValueByFiveInt(remain, stringMap));
            }
            return stringBuilder.toString();

        }

        private String getRomanValueByFiveTeenInt(int num, Map<Integer, String> stringMap) {
            if(num == 50) {
                return stringMap.get(50);
            }
            StringBuilder stringBuilder = new StringBuilder();
            int dif = (int) Math.floor(num/50);
            int remain = num % 50;
            getStringByDif(50, dif, stringMap, stringBuilder);
            if(remain == 0) {
                return stringBuilder.toString();
            }else if(remain >=1 && remain <5) {
                stringBuilder.append(getRomanValueByLessFiveInt(remain));
            }else if(remain >=5 && remain <10) {
                stringBuilder.append(getRomanValueByFiveInt(remain, stringMap));
            }else if(remain >=10 && remain < 40){
                stringBuilder.append(getRomanValueByTenInt(remain, stringMap));
            }else {
                stringBuilder.append(getRomanValueByFourTenInt(remain, stringMap));
            }
            return stringBuilder.toString();
        }
        private String getRomanValueByNineTeenInt(int num, Map<Integer, String> stringMap) {
            if(num == 90) {
                return "XC";
            }
            StringBuilder stringBuilder = new StringBuilder();
            int dif = (int) Math.floor(num/90);
            int remain = num % 90;
            getStringByDif(90, dif, stringMap, stringBuilder);
            if(remain == 0) {
                return stringBuilder.toString();
            }else if(remain >=1 && remain <5) {
                stringBuilder.append(getRomanValueByLessFiveInt(remain));
            }else {
                stringBuilder.append(getRomanValueByFiveInt(remain, stringMap));
            }
            return stringBuilder.toString();
        }

        private String getRomanValueByHandrandInt(int num, Map<Integer, String> stringMap) {
            if(num == 100) {
                return stringMap.get(100);
            }

            StringBuilder stringBuilder = new StringBuilder();
            int dif = (int) Math.floor(num/100);
            int remain = num % 100;
            getStringByDif(100, dif, stringMap, stringBuilder);
            if(remain == 0) {
                return stringBuilder.toString();
            }else if(remain >=1 && remain <5) {
                stringBuilder.append(getRomanValueByLessFiveInt(remain));
            }else if(remain >=5 && remain <10) {
                stringBuilder.append(getRomanValueByFiveInt(remain, stringMap));
            }else if(remain >=10 && remain <50){
                stringBuilder.append(getRomanValueByTenInt(remain, stringMap));
            }else {
                stringBuilder.append(getRomanValueByFiveTeenInt(remain, stringMap));
            }
            return stringBuilder.toString();
        }

        private String getRomanValueByFiveHandrandInt(int num, Map<Integer, String> stringMap) {
            if(num == 500) {
                return stringMap.get(500);
            }
            if(num == 900) {
                return "CM";
            }

            StringBuilder stringBuilder = new StringBuilder();
            int dif = (int) Math.floor(num/500);
            int remain = num % 500;
            getStringByDif(500, dif, stringMap, stringBuilder);
            if(remain == 0) {
                return stringBuilder.toString();
            }else if(remain >=1 && remain <5) {
                stringBuilder.append(getRomanValueByLessFiveInt(remain));
            }else if(remain >=5 && remain <10) {
                stringBuilder.append(getRomanValueByFiveInt(remain, stringMap));
            }else if(remain >=10 && remain <50){
                stringBuilder.append(getRomanValueByTenInt(remain, stringMap));
            }else if(remain >= 50 && remain < 100){
                stringBuilder.append(getRomanValueByFiveTeenInt(remain, stringMap));
            }else {
                stringBuilder.append(getRomanValueByHandrandInt(remain, stringMap));
            }
            return stringBuilder.toString();
        }

        private String getRomanValueByThrandInt(int num, Map<Integer, String> stringMap) {
            if(num == 1000) {
                return stringMap.get(1000);
            }

            StringBuilder stringBuilder = new StringBuilder();
            int dif = (int) Math.floor(num/1000);
            int remain = num % 1000;
            getStringByDif(1000, dif, stringMap, stringBuilder);
            if(remain == 0) {
                return stringBuilder.toString();
            }else if(remain >=1 && remain <5) {
                stringBuilder.append(getRomanValueByLessFiveInt(remain));
            }else if(remain >=5 && remain <10) {
                stringBuilder.append(getRomanValueByFiveInt(remain, stringMap));
            }else if(remain >=10 && remain <50){
                stringBuilder.append(getRomanValueByTenInt(remain, stringMap));
            }else if(remain >= 50 && remain < 100){
                stringBuilder.append(getRomanValueByFiveTeenInt(remain, stringMap));
            }else if(remain >= 100 && remain <500){
                stringBuilder.append(getRomanValueByHandrandInt(remain, stringMap));
            }else {
                stringBuilder.append(getRomanValueByFiveHandrandInt(remain, stringMap));
            }
            return stringBuilder.toString();
        }


     */


}
