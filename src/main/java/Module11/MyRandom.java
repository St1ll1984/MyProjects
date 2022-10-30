package Module11;

public class MyRandom {

    private long a, c, m;
    private long seed;

    public MyRandom(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public MyRandom seed(long seed){
        this.seed = seed;
        return this;
    }

    public long next (){
        return (a * seed + c) % m;
    }

}
