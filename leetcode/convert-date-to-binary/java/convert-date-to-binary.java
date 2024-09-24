class Solution {
    private final String dash = "-";

    public String convertDateToBinary(String date) {
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);

        return strToBinary(year) + dash + strToBinary(month) + dash + strToBinary(day);
    }

    public String strToBinary(String value) {
        return Integer.toBinaryString(Integer.parseInt(value));
    }
}