package my.preparations.leetcode;

public class ZigZag {
    public static void main(String[] args) {
        ZigZag z = new ZigZag();
        System.out.println(z.convert("A", 1));
        System.out.println(z.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuffer[] res = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuffer();
        }
        boolean goingDown = false;
        int row = 0;
        for (char ch : s.toCharArray()) {
            res[row].append(String.valueOf(ch));
            if (row == numRows - 1 || row == 0)
                goingDown = !goingDown;
            row += goingDown ? 1 : -1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < res.length; i++)
            sb.append(res[i].toString());

        return sb.toString();
    }
}
