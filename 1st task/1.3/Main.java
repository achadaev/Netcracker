public class Main {
    public static void main(String[] args) {
        paintSquare(8);
        System.out.println();
        paintA();
        System.out.println();
        paintB();
        System.out.println();
        paintC();
        System.out.println();
        paintE();
    }

    public static void paintSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void paintA() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j <= i) System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void paintB() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i <= j) System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void paintC() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j >= i) System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void paintE() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 0 || i == 7) || (j == 0 || j == 7))
                    System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
