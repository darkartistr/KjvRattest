import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class KjvRat implements Cloneable, Comparable<KjvRat>
{
    private int num = 0;
    private int denom = 1;

    public KjvRat() { }

    public KjvRat(int a) {
        num = a;
    }

    public KjvRat(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public KjvRat(KjvRat r) {
        num = r.num;
        denom = r.denom;
    }

    public int getNum() {
        return this.num;
    }

    public int getDenom() {
        return this.denom;
    }

    public void setNum(int a) {
        num = a;
    }

    public void setDenom(int b) throws IOException {
        if (b==0)
            throw new FileMyException("����������� �� ����� ���� ����� ����");
        denom = b;
    }

    public KjvRat plus(KjvRat r2) {
        KjvRat r = new KjvRat(this);
        r.num = r.num*r2.denom+r2.num*r.denom;
        r.denom = r.denom*r2.denom;
        return r;
    }

    public KjvRat plusTo(KjvRat r2) {
        num = num*r2.denom+r2.num*denom;
        denom = denom*r2.denom;
        return new KjvRat(this);
    }

    public KjvRat plus(int r2) {
        return this.plus(new KjvRat(r2));
    }

    public KjvRat minus(KjvRat r2) {
        KjvRat r = new KjvRat(this);
        r.num = r.num*r2.denom-r2.num*r.denom;
        r.denom = r.denom*r2.denom;
        return r;
    }

    public KjvRat minusTo(KjvRat r2) {
        num = num*r2.denom-r2.num*denom;
        denom = denom*r2.denom;
        return new KjvRat(this);
    }

    public KjvRat minus(int r2) {
        return this.minus(new KjvRat(r2));
    }

    public KjvRat multiply(int r2) {
        KjvRat r = new KjvRat(this);
        r.num = r.num*r2;
        return r;
    }

    public KjvRat multiplyTo(KjvRat r2) {
        num *= r2.num;
        denom *= r2.denom;
        return new KjvRat(this);
    }

    public KjvRat multiply(KjvRat r2) {
        KjvRat r = new KjvRat(this);
        r.num *= r2.num;
        r.denom *= r2.denom;
        return r;
    }

    public KjvRat divide(KjvRat r2) {
        KjvRat r = new KjvRat(this);
        r.num *= r2.denom;
        r.denom *= r2.num;
        return r;
    }

    public KjvRat divideTo(KjvRat r2) {
        num *= r2.denom;
        denom *= r2.num;
        return new KjvRat(this);
    }

    public KjvRat divide(int r2) {
        KjvRat r = new KjvRat(this);
        r.denom *= r2;
        return r;
    }

    public void normalize() {
        if (denom < 0) {
            num *= -1;
            denom *= -1;
        }

        int gcd = Gcd_(denom, Math.abs(num));

        num /= gcd;
        denom /= gcd;
    }

    private int Gcd_(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    @Override
    public KjvRat clone() throws RuntimeException {
        KjvRat r = null;
        try {
            r = (KjvRat)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new RuntimeException("gggg");
        }
        return r;
    }

    @Override
    public int compareTo(KjvRat r2) {
        return num * r2.denom - denom * r2.num;
    }

    public boolean isLess(KjvRat r2) {
        return compareTo(r2) < 0;
    }

    public boolean isGreater(KjvRat r2) {
        return compareTo(r2) > 0;
    }

    public boolean isLessEqual(KjvRat r2) {
        return compareTo(r2) <= 0;
    }

    public boolean isGreaterEqual(KjvRat r2) {
        return compareTo(r2) >= 0;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (getClass() != otherObject.getClass())
            return false;

        KjvRat r = (KjvRat) otherObject;

        return num == r.num && denom == r.denom;
    }

    @Override
    public String toString() {
        return Integer.toString(num)+'/'+Integer.toString(denom);
    }
}
class FileMyException extends IOException
{
    public FileMyException() {}

    public FileMyException(String msg) {
        super(msg);
    }
}

