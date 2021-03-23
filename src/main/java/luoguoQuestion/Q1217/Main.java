package luoguoQuestion.Q1217;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        ju00(a,b);
        ju01(a,b);
        ju02(a,b);
        ju03(a,b);
        ju04(a,b);
        ju05(a,b);
        ju06(a,b);
        ju07(a,b);
    }

//    0-9区间
    public static void ju00(int sNumber,int bNumber){
        for(int i=0;i<10;++i){
            if(i >= sNumber && i <= bNumber){
                if (isPrime(i)){
                    System.out.println(i);
                }
            }
            if(i>bNumber){
                return;
            }
        }
    }

//    10-99区间
    public static void ju01(int sNumber,int bNumber){
        for(int i=1;i<=9;i+=2){
            int number = 10 * i + i;
            if(number >= sNumber && number <= bNumber){
                if(isPrime(number)){
                    System.out.println(number);
                }
            }
            if(number>bNumber){
                return;
            }
        }
    }
//    100-999区间
    public static void ju02(int sNumber,int bNumber){
        for(int i=1;i<=9;i+=2){
            for(int j=0;j<=9;++j){
                int number = 100 * i + 10 * j + i;
                if(number >= sNumber && number <= bNumber){
                    if(isPrime(number)){
                        System.out.println(number);
                    }
                }
                if(number>bNumber){
                    return;
                }

            }
        }
    }
//    1000-9999区间
    public static void ju03(int sNumber,int bNumber){
        for(int i=1;i<=9;i+=2){
            for(int j=0;i<=9;++j){
                int number = i * 1000 + j * 100 + j * 10 + i;
                if(number >= sNumber && number <= bNumber){
                    if(isPrime(number)){
                        System.out.println(number);
                    }
                }
                if(number>bNumber){
                    return;
                }
            }
        }
    }
//    10000-99999区间
    public static void ju04(int sNumber,int bNumber){
        for(int i=1;i<=9;i+=2){
            for(int j = 0 ; j <= 9 ; ++j){
                for(int k=0;k<=9;++k){
                    int number = i * 10000 + j * 1000 + k * 100 + j * 10 + i;
                    if(number >= sNumber && number <= bNumber){
                        if(isPrime(number)){
                            System.out.println(number);
                        }
                    }
                    if(number>bNumber){
                        return;
                    }
                }
            }
        }
    }
//    100 000-999 999 区间
    public static void ju05(int sNumber,int bNumber){
        for(int i=1;i<=9;i+=2){
            for(int j=0;j<=9;++j){
                for(int k=0;k<=9;++k){
                    int number = i * 100000 + j * 10000 + k * 1000 + k * 100 + j * 10 + i;
                    if(sNumber <= number && number <= bNumber){
                        if(isPrime(number)){
                            System.out.println(number);
                        }
                    }
                    if(number>bNumber){
                        return;
                    }
                }
            }
        }
    }

//    1 000 000 - 9 999 999
    public static void ju06(int sNumber,int bNumber){
        for(int i=1;i<=9;i+=2){
            for(int j=0;j<=9;++j){
                for(int k=0;k<=9;++k){
                    for(int l=0;l<=9;++l){
                        int number = i * 1000000 + j * 100000 + k * 10000 + l * 1000 + k * 100 + j * 10 + i;
                        if(sNumber <= number && number <= bNumber){
                            if(isPrime(number)){
                                System.out.println(number);
                            }
                        }if(number>bNumber){
                            return;
                        }
                    }
                }
            }
        }
    }
//    10 000 000 - 99 999 999
    public static void ju07(int sNumber,int bNumber){
        for(int i=1;i<=9;i+=2){
            for(int j=0;j<=9;++j){
                for(int k=0;k<=9;++k){
                    for(int l=0;l<=9;++l){
                        int number = i * 10000000 + j * 1000000 + k * 100000 + l * 10000 + l * 1000 + k * 100 + j * 10 +i;
                        if(sNumber <= number && number <= bNumber){
                            if(isPrime(number)){
                                System.out.println(number);
                            }
                        }if(number>bNumber){
                            return;
                        }
                    }
                }
            }
        }
    }
//    100 000 000 - 999 999 999
    public  static void  ju08(int sNumber,int bNumber){
        for(int i=1;i<=9;i+=2){
            for(int j=0;j<=9;++j){
                for(int k=0;k<=9;++k){
                    for(int l=0;l<=9;++l){
                        for(int a=0;a<=9;++a){
                            int number = i * 100000000 + j * 10000000 + k*1000000 + l*100000+a*10000+l*1000+k*100+j*10+l;
                            if(sNumber <= number && number <= bNumber){
                                if(isPrime(number)){
                                    System.out.println(number);
                                }
                            }if(number>bNumber){
                                return;
                            }
                        }
                    }
                }
            }
        }
    }


    public static boolean isPrime(int number){
        int n = (int) Math.sqrt(number)+1;
        for(int i=2;i<n;i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
