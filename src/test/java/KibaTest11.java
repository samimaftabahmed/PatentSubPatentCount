public class KibaTest11 {

    public static void main(String[] args) {

        String sss = "937 937.108";

        String[] split = sss.split(" ");

//        String subPatent = split[1].split(".")[0];
        String[] split2 = split[1].split("\\.");

        for (String  s:split2){
            System.out.println(s);
        }


    }


}
