import org.testng.annotations.Test;

public class StringDemo {

    @Test
    public void demo() {
        String s1 = "America$400";
        String s2 = "alpha+beta+Gama";
        String s3 = "Deeksha";
        System.out.println(s1.indexOf('c'));  // It will give index of c character in the above string
        System.out.println(s1.charAt(8));  // It will give the index value of character $
        System.out.println(s1.substring(0, 11));  // First Index is Inclusive and last index if exclusive
        System.out.println(s1.substring(3));   // It will print everything from 3rd index
        String[] str = s2.split("\\+", 0);
        for (String str1 : str) {
            System.out.println(str1);
        }

        System.out.println(s3 + 10 + 20);


        String new1 = "";
        String[] s4 = s1.split("");
        for (int i = s4.length - 1; i > 0; i--) {
            new1 = new1 + s4[i];
        }
        System.out.println(new1);


    }
}
