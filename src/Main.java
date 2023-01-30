public class Main {
    public static void main(String[] args) {
        System.out.println("演示一下基本情况和简单使用方法");
        BigNum bn=new BigNum("11110000");
        BigNum bn2=new BigNum(111110000);
        BigNum bn3;
        bn3=bn.add(bn,bn2);
        System.out.println(bn.outBigNum(bn3));
        bn3=bn.sub(bn,bn2);
        System.out.println(bn.outBigNum(bn3));
        bn3=bn.multip(bn,10);
        System.out.println(bn.outBigNum(bn3));
        bn3=bn.division(bn,20);
        System.out.println(bn.outBigNum(bn3));
        bn3=bn.divisionB(bn,bn2);
        System.out.println(bn.outBigNum(bn3));
    }
}