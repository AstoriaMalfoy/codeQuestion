import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test011(){
        String str1 = "abc";
        String str2 = "a" + "bc";
        String str3 = "a" + new String("bc");
        System.err.println(str1 == str2);
        System.err.println(str1 == str3);

//        List< ? extends Number> foo = new ArrayList<Double>();
//        List< ? extends Integer> foo12 = new ArrayList<Integer>();
//        List< ? super Number> foo1 = new ArrayList<Integer>();
//        List< ? super Integer> foo2 = new ArrayList<Number>();

        int x = 3,y=3;
        switch (x){
            case 3:
                y++;
            case 4:
                y++;
            case 5:
                y++;
            default:
                y++;
        }
    }

    @Test
    public void test03(){
        List<String> list = new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");

            }
        };
        for(int i=0,m=list.size();i<m;i++){
            String str = list.get(i);
            if("a".equals(str)){
                list.remove(i);
            }
        }
        System.out.println(list.size());
    }

    @Test
    public void testQuestion1(){
        int[] arrays = new int[]{0,-5,3,-2,-6,1};
        System.out.println(getResult(arrays,1));
    }
    public int getResult(int[] array,int fix){
        int result = 0;
        for(int i=0;i<array.length;++i){
            array[i] = Math.abs(array[i]-fix);
        }
        for(int i=0;i<4;++i){
            result+=getMinValuePosition(array);
        }
        return result;
    }
    public int getMinValuePosition(int[] array){
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<array.length;++i){
            if(array[i] < minValue){
                minValue = array[i];
                minIndex = i;
            }
        }
        array[minIndex] = Integer.MAX_VALUE;
        return minIndex;
    }

    @Test
    public void testMethod(){
        Map<Integer,String> mas = new HashMap<>();
        mas.put(1,"ast");
        System.out.println(mas.get(1));
        System.out.println(mas.get(2));
    }
    //	this is a git test line
}
