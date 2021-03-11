public class MethodTest {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        int number = 765432;
        int[] positionCount = {0,0,0,0,0,0,0,0};
        for(int i=1;i<=number;++i){
            String str = String.valueOf(i);
            if(strContainFlag(str)){
                for(int j=0;j<str.length();++j){
                    if(str.charAt(j)=='2'){
                        positionCount[str.length()-j]++;
                    }
                }
            }
        }
        int result = 0;
        for (int i : positionCount) {
            System.out.print(i + "     ");
            result+=i;
        }
        System.out.println();
        System.out.println(result);
    }

    private static boolean strContainFlag(String str) {
        for(int i=0;i<str.length();++i){
            if(str.charAt(i) == '2'){
                return true;
            }
        }
        return false;
    }
}
