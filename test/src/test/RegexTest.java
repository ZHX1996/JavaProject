package test;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class RegexTest{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String tel = in.next();
        in.close();
        
        // µç»°ºÅÂë
        Pattern pattern = Pattern.compile("^1([34578])\\\\d{9}$");
        // ÓÊÏä
        //Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        
        Matcher matcher = pattern.matcher(tel);
        System.out.println(matcher.matches());

    }
}
