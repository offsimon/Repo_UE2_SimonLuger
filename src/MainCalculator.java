import java.util.Scanner;

public class MainCalculator {

    static RationalCalculator rationalCalculator = new RationalCalculator
            ((x, y) -> {
                double z = x.getA() * y.getB() + y.getA() * x.getB();
                double n = x.getB() * y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() * y.getB() - y.getA() * x.getB();
                double n = x.getB() * y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() * y.getA();
                double n = x.getB() * y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() * y.getB();
                double n = x.getB() * y.getA();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            });

    static VectorCalculator vectorCalculator = new VectorCalculator
            ((x, y) -> {
                double z = x.getA() + y.getA();
                double n = x.getB() + y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() - y.getA();
                double n = x.getB() - y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() * y.getA();
                double n = x.getB() * y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() / y.getA();
                double n = x.getB() / y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            });

    static ComplexCalculator complexCalculator = new ComplexCalculator
            ((x, y) -> {
                double z = x.getA() + y.getA();
                double n = x.getB() + y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() - y.getA();
                double n = x.getB() - y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() * y.getA();
                double n = x.getB() * y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            }, (x, y) -> {
                double z = x.getA() / y.getA();
                double n = x.getB() / y.getB();
                Number num = new Number();
                num.setA(z);
                num.setB(n);
                return num;
            });


    public static void main(String[] args) {

        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        AbstractCalculator ac = null;
        Number num = null;
        Number x = new Number();
        Number y = new Number();
        int calc;
        int op = 0;
        int xA;
        int xB;
        int yA;
        int yB;

        while (run) {

            menueCalc();
            calc = Integer.parseInt(scanner.nextLine());

            if(calc == 4) {
                run = false;
            }else {
                System.out.print("Enter number x a>");
                xA = Integer.parseInt(scanner.nextLine());
                x.setA(xA);
                System.out.print("Enter number x b>");
                xB = Integer.parseInt(scanner.nextLine());
                x.setB(xB);
                System.out.print("Enter number y a>");
                yA = Integer.parseInt(scanner.nextLine());
                y.setA(yA);
                System.out.print("Enter number y b>");
                yB = Integer.parseInt(scanner.nextLine());
                y.setB(yB);

                op = 0;

                while(op != 1 && op != 2 && op != 3 && op != 4){
                    menueOp();
                    op = Integer.parseInt(scanner.nextLine());
                }

                switch(calc) {
                    case 1:
                        ac = rationalCalculator;
                        break;
                    case 2:
                        ac = vectorCalculator;
                        break;
                    case 3:
                        ac = complexCalculator;
                        break;
                }

                if(run)  {
                    switch(op) {
                        case 1:
                            num = ac.add(x, y);
                            break;
                        case 2:
                            num = ac.subtract(x, y);
                            break;
                        case 3:
                            num = ac.multiply(x, y);
                            break;
                        case 4:
                            num = ac.divide(x, y);
                            break;
                    }

                    solution(num);
                }
            }


        }

    }

    public static void menueCalc() {
        System.out.println("Choose calculator:\n1 - Rational calculator\n2 - Vector calculator\n3 - Complex calculator\n4 - Exit program");
    }

    public static void menueOp() {
        System.out.println("Choose operation:\n1 - add\n2 - subtract\n3 - multiply\n4 - divide\n5 - enter numbers again");
    }

    public static void solution(Number number) {
        System.out.println("----------------\nSolution:\n" + number.toString() + "\n----------------");
    }
}
