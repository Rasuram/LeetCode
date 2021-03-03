package sort;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        String res = "";
        while (n != 0) {
            int rem = n % 26;
            if (rem == 0) {
                rem = 26;
                n -= 1;
            }
            res = (char) (rem + 64) + res;
            n = n / 26;
        }
        return res;

    }


    public static void main(String[] args) {
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        System.out.println(e.convertToTitle(701));

    }
}
