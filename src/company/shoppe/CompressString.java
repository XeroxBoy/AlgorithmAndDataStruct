package company.shoppe;

public class CompressString {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param param string字符串
     * @return string字符串
     */
    public String compressString(String param) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < param.length()) {
            char oneChar = param.charAt(i);
            int charCount = 1;
            while (i + 1 < param.length() && param.charAt(i + 1) == oneChar) {
                charCount++;
                i++;
            }
            sb.append(oneChar);
            if (charCount > 1) {
                sb.append((char) ('0' + charCount));
            }
            i++;
        }
        return sb.toString();
    }
}
