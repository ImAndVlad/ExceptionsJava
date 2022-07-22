package exceptions;

public class App_02 {

    private class App1 {
        public double sqr(double arg) { // надо double
            return arg * arg;           // double * double -> double
        }
    }

    private class App2 {
        public double sqr(double arg) { // надо double
            int k = 1;                  // есть int
            return k;                   // можно неявно преобразовать int в double
        }
    }

    private class App3 {
        public double sqr(double arg) { // надо double
            int k = 1;                  // есть int
            return (double) k;          // явное преобразовать int в double
        }
    }

//    private class App4 {
    // (COMPILATION ERROR не пройдет(другой тип))
//        public static double sqr(double arg) {
//            return "hello!";
//        }
//    }

//    private class App5 {
    // (COMPILATION ERROR)
//        public static double sqr(double arg) {
//
//        }
//    }

//    private class App6 {
//        // (COMPILATION ERROR)
//        public static double sqr(double arg) {
//            if (System.currentTimeMillis() % 2 == 0) {
//                return arg * arg; // if (currentTimeMillis() четное число) -> все ОК
//            }
//            // а если нечетноеб что нам возращать?
//        }
//    }

//    private class App7 {
//        // (COMPILATION ERROR)
//        public static void main(String[] args) {
//            double d = sqr(10.0); // d = ?
//            System.out.println(d);
//        }
//        public static double sqr(double arg) {
//            // nothing
//        }
//    }

    private static class App8 {
        public static void main(String[] args) {
            while (true); // нічого не повертаємб "повісили метод"
        }
    }

    private static class App9 {
        public static void main(String[] args) {
            double d = sqr(10.0); // sqr -> навсегда 'повиснет', и
            System.out.println(d); // d -> НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
        }
        public static double sqr(double arg) {
            while (true); // Вот тут на века 'повисли'
        }
    }

    private class App10 {
        public static double sqr(double arg) {
            if (System.currentTimeMillis() % 2 == 0) {
                return arg * arg; // ну ладно, вот твой double
            } else {
                while (true);     // а тут 'виснем' навсегда
            }
        }
    }

    private class App11 {
        // (механизм исключений позволяет НИЧЕГО НЕ ВОЗРАЩАТЬ)
        public static double sqr(double arg) {
            throw new RuntimeException();
        }
    }

    private class App12 {
        // (ТРИ варианта для компилятора)
        public static double sqr(double arg) { // нужно вернуть double
            long time = System.currentTimeMillis();
            if (time % 2 == 0) {
                return arg * arg;             // ок, вот твой double
            } else if (time % 2 == 1) {
                while (true);                 // не, я решил 'повиснуть'
            } else {
                throw new RuntimeException(); // или бросить исключения
            }
        }
    }

    private static class App13 {
        // (Какой double вернет функция, бросающая RuntimeException -> А НИКАКОЙ)
        public static void main(String[] args) {
            // sqr - 'сломаеться' (из него 'вискочит' исключение)
            double d = sqr(10.0); // метод main() прерветься в этой строчке и
                                  // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
            System.out.println(d); // и печатать нам ничего не придеться
        }
        public static double sqr(double arg) {
            throw new RuntimeException(); // 'бросаем' исключение
        }
    }
}
