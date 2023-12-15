package meta;
class A {
    private int number1;
    private int number2;

    public A(int num1, int num2) {
        this.number1 = num1;
        this.number2 = num2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }
}

class B {
    private int lastDigitNumber1;
    private int lastDigitNumber2;

    public B(A input) {
        this.lastDigitNumber1 = input.getNumber1() % 10;
        this.lastDigitNumber2 = input.getNumber2() % 10;
    }

    public int getLastDigitNumber1() {
        return lastDigitNumber1;
    }

    public int getLastDigitNumber2() {
        return lastDigitNumber2;
    }
}

class C {
    private int result;

    public C(B input) {
        this.result = input.getLastDigitNumber1() * input.getLastDigitNumber2();
    }

    public int getResult() {
        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        A classA = new A(123, 456);
        B classB = new B(classA);
        C classC = new C(classB);

        System.out.println("Number 1: " + classA.getNumber1());
        System.out.println("Number 2: " + classA.getNumber2());
        System.out.println("Last digit of Number 1: " + classB.getLastDigitNumber1());
        System.out.println("Last digit of Number 2: " + classB.getLastDigitNumber2());
        System.out.println("Result of multiplying the last digits: " + classC.getResult());
    }
}
