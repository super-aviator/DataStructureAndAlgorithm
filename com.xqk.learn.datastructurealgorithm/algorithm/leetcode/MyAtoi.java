package algorithm.leetcode;

class MyAtoi {
    public static int getStatus(char c) {
        if (' ' == c) {
            return 0;
        }
        if ('+' == c || '-' == c) {
            return 1;
        }
        if (c - '0' >= 0 && c - '0' <= 9) {
            return 2;
        }
        return 3;
    }

    public int myAtoi(String s) {
        int sign = 1, curSta = 0;
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int status = getStatus(c);
            if (status < curSta) {
                return sign * (int) result;
            }
            curSta = Math.max(status, curSta);
            if (status == 0) {
                continue;
            }
            if (status == 1) {
                sign = c == '-' ? -1 : 1;
                curSta++;
            } else if (status == 2) {
                result = result * 10 + c - '0';
                //这里可能溢出，溢出就直接返回
                if ((int) result != result) {
                    return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
        }
        return sign * (int) result;
    }
}