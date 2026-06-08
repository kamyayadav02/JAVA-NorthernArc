package intro;

public class Main2 {
    public static void main(String[] args){
        String data="Hello World";
        String s1= "Sachin";
        String s2="Sourav";
        System.out.println(s1.compareTo(s2));
        System.out.println(data.charAt(0));
        System.out.println(data.length());
        System.out.println(data.charAt(data.length()-1));
        System.out.println(data.substring(0,5));
        System.out.println(data.substring(6));
        System.out.println(data.replace("World","Java"));
        System.out.println(data.trim());
        System.out.println(data.contains("z"));
        System.out.println(data.concat(" Galaxy"));
        System.out.println(data.indexOf("o"));
        System.out.println(data.lastIndexOf("o"));
        // System.out.println(data.split(""));
        System.out.println(data.toLowerCase());
        System.out.println(data.toUpperCase());
        System.out.println(data.startsWith("Hell"));
        System.out.println(data.endsWith("World"));
        System.out.println(s2.compareTo(s1));
        System.out.println(s2.compareToIgnoreCase(s1));
        String s3="Siya";
        String s4="siya";
        System.out.println(s3.equals(s4));
        System.out.println(s3.equalsIgnoreCase(s4));
        System.out.println(s3==s4);


    }
}
