import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNew {


    private static String getContentFrom(String link) throws IOException {
        URL url = new URL(link);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        // xoá các ký tự ngắt dòng (xuống dòng)
        content = content.replaceAll("\\R", "");
        return content;
    }
    public static void main(String[] args) throws IOException {
        String content = getContentFrom("https://dantri.com.vn/the-gioi.htm");
        // Regex
        // tên công thức
        Pattern p1 = Pattern.compile("<a data-utm=(.*?) href=(.*?) title=(.*?)>");
        Matcher m1 = p1.matcher(content);
        while (m1.find()) {
            System.out.println(m1.group(3));
        }
    }
}
