package com.ruanxinxin.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Zconvert_6 {

    public String convert(String s, int numRows) {

        if (s == null || s.length() <= 1 || numRows <= 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean up = true;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            list.get(row).append(item);
            if (row == 0 || row == numRows - 1) {
                up = !up;
            }
            row += up ? -1 : 1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb.toString());
        }
        return res.toString();
    }

}
