import static java.lang.Math.pow;

public class BigNum {
    private int head,e;
    public BigNum(String num){
        e=num.length()-4;
        head= Integer.parseInt(num.substring(0, 4));//目前对小于四位数的处理有问题，但是我想你都用的到这个了也不会小于1000叭
    }
    public BigNum(int num){
        this(String.valueOf(num));
    }

    public BigNum(Long num){
        this(String.valueOf(num));
    }

    BigNum sub(BigNum a,BigNum b){
        int ea=a.e,eb=b.e;
        int c = ea - eb;
        if (c>=4);
        else{
            int re= (int) (b.head*pow(0.1,c));
            a.head-=re;
        }
        return a;
    }

    BigNum add(BigNum a,BigNum b){
        int ea=a.e,eb=b.e;
        char flag;
        //int c =(ea>eb)?ea-eb:eb-ea;
        int c=0;
        if(ea>eb) {
            c = ea - eb;
            flag='a';
        }
        else {
            c=eb-ea;
            flag='b';
        }
        if (c>=4){
            if(flag=='a')return a;
            else return b;
        }
        else{
            int re=0;
            if(flag=='a'){
                re= (int) (b.head*pow(0.1,c));
                a.head+=re;
                if(a.head>9999){
                    while(a.head>9999){
                        a.head/=10;
                        a.e+=1;
                    }
                }
                return a;
            }
            else{
                re= (int) (a.head*pow(0.1,c));
                b.head+=re;
                if(b.head>9999){
                    while(b.head>9999){
                        b.head/=10;
                        b.e+=1;
                    }
                }
                return b;
            }
        }
    }
    BigNum multip(BigNum a,int b){
        a.head*=b;  //考虑到精度问题，这里可能有点问题
            while(a.head>9999){
                a.head/=10;
                a.e+=1;
            }
        return a;
    }

    BigNum division(BigNum a,int b){
        a.head/=b;
        while(a.head<1000){
            a.head*=10;
            a.e-=1;
        }
        return a;
    }

    BigNum divisionB(BigNum a,BigNum b){
        a.head/=b.head;
        a.e-=b.e;
        while(a.head<1000){
            a.head*=10;
            a.e-=1;
        }
        return a;
    }
    String outBigNum(BigNum a){
        String zero = "";
        for(int i=0;i<a.e;i++)zero+='0';
        if(a.head==0)return "0";
        return String.valueOf(a.head)+zero;
    }
}
