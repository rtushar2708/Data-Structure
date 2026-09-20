class Solution {
    public boolean lemonadeChange(int[] bills) {
        int doller5 = 0;
        int doller10 = 0;

        for(int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) {
                doller5++;
            }else if(bills[i] == 10) {
                if(doller5 == 0) {
                    return false;
                }
                doller5--;
                doller10++;
            }else {
                if(doller10 > 0 && doller5 > 0) {
                    doller10--;
                    doller5--;
                }else if(doller5 >= 3) {
                    doller5 -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}