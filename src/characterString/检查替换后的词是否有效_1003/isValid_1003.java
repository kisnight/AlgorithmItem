package characterString.检查替换后的词是否有效_1003;

public class isValid_1003 {

    public static void main(String[] args) {
        isValid_1003 a = new isValid_1003();
       String s = "aaababccbcbc";
        System.out.println(a.isValid(s));
    }
/*
    public boolean isValid(String s) {
        if(s.length() < 3) {
            return false;
        }
        char [] ch = s.toCharArray();
        List<Character> tempList = new ArrayList<>();
        List<Character> tempList1 = new ArrayList<>();
        List<Character> tempList2 = new ArrayList<>();
        boolean isStartVerify = false;
        for(int index = 0; index < ch.length; index ++) {
            if(!isStartVerify) {
                //在没有重复值的情况下
                if(!tempList.contains(ch[index])) {

                    if(tempList.size() == 0) {
                        if(ch[index] == 'a') {
                            tempList.add(ch[index]);
                            continue;
                        }else {
                            return false;
                        }
                    }

                    if(tempList.size() == 1) {
                        if(ch[index] == 'b') {
                            tempList.add('b');
                            continue;
                        }else {
                            return false;
                        }
                    }

                    if(tempList.size() == 2) {
                        if(ch[index] == 'c') {
                            tempList.clear();
                        }
                    }

                }else {
                    if(ch[index] == 'a') {
                        tempList1.add(ch[index]);
                        isStartVerify = true;
                    }else {
                        return false;
                    }
                }

            } else {
                //有重复值进入校验阶段
                if(tempList1.size() == 1) {
                    if(ch[index] == 'b') {
                        tempList1.add(ch[index]);
                        continue;
                    }else {
                        return false;
                    }
                }

                if(tempList1.size() == 2) {
                    if(ch[index] == 'c') {
                        tempList1.add(ch[index]);
                        continue;
                    }else {
                        return false;
                    }
                }

                if(tempList1.size() == 3) {
                    if(ch[index] == 'a') {
                        tempList1.clear();
                        tempList1.add('a');
                    }else {
                        if(tempList.size() == 1) {
                            if(tempList2.size() == 0) {
                                if(ch[index] == 'b') {
                                    tempList2.add('b');
                                    continue;
                                }else {
                                    return false;
                                }
                            }

                            if(tempList2.size() == 1) {
                                if(ch[index] == 'c') {
                                    isStartVerify = false;
                                    tempList2.clear();
                                }else {
                                    return false;
                                }
                            }

                        }

                        if(tempList.size() == 2) {
                            if(ch[index] == 'c') {
                                isStartVerify = false;
                                tempList2.clear();
                            }else {
                                return false;
                            }
                        }

                    }
                }

            }//if(contains)

        }//for循环

        if(tempList2.size() == 0) {
            return true;
        }else {
            return false;
        }
    }//函数
*/
    public boolean isValid(String s) {
        while(s.contains("abc")) {
            s = s.replace("abc", "");
        }
        return "".equals(s);
    }
}
