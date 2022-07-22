package exceptions;

public class App_03 {

    private static class App01 {
        public static void main(String[] args) {
            System.err.println("#1.in");
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println("#1.out"); // вернулись
        } // выходим из текущего фрейма, кончились инструкции

        public static void f() {
            System.err.println(". #2.in");
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(". #2.out"); // вернулись
        } // выходим из текущего фрейма, кончились инструкции

        public static void g() {
            System.err.println(". . #3.in");
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(". . #3.out"); // вернулись
        } // выходим из текущего фрейма, кончились инструкции

        public static void h() {
            System.err.println(". . . #4.in");
            if (true) {
                System.err.println(". . . #4.RETURN");
                return; // выходим из текущего фрейма по 'return'
            }
            System.err.println(". . . #4.out"); // Пропускаем
        }
    }

    private static class App02 {
        // (throw - выходим из Всех фреймов)
        public static void main(String[] args) {
            System.err.println("#1.in");
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println("#1.out"); // ПРОПУСТИЛИ!
        }

        public static void f() {
            System.err.println(". #2.in");
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(". #2.out"); // ПРОПУСТИЛИ!
        }

        public static void g() {
            System.err.println(". . #3.in");
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(". . #3.out"); // ПРОПУСТИЛИ!
        }

        public static void h() {
            System.err.println(". . . #4.in");
            if (true) {
                System.err.println(". . . #4.THROW");
                throw new Error(); // выходим со всей пачки фреймов ('раскрутка стека') по 'throw'
            }
            System.err.println(". . . #4.out"); // ПРОПУСТИЛИ!
        }
    }

    private static class App03 {
        public static void main(String[] args) {
            System.err.println("#1.in");
            try {
                f(); // создаем фрейм, помещаем в стек, передаем в него управление
            } catch (Error e) { // "перехватили" "летящее" исключение
                System.err.println("#1.CATCH"); // и работаем
            }
            System.err.println("#1.out"); // работаем дальше
        }

        public static void f() {
            System.err.println(". #2.in");
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(". #2.out"); // ПРОПУСТИЛИ!
        }

        public static void g() {
            System.err.println(". . #3.in");
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(". . #3.out"); // ПРОПУСТИЛИ!
        }

        public static void h() {
            System.err.println(". . . #4.in");
            if (true) {
                System.err.println(". . . #4.THROW");
                throw new Error(); // выходим со всей пачки фреймов ('раскрутка стека') по 'throw'
            }
            System.err.println(". . . #4.out"); // ПРОПУСТИЛИ!
        }
    }

    private static class App04 {
        public static void main(String[] args) {
            System.err.println("#1.in");
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println("#1.out"); // вернулися и работаем
        }

        public static void f() {
            System.err.println(". #2.in");
            try {
                g(); // создаем фрейм, помещаем в стек, передаем в него управление
            } catch (Error e) { // "перехватили" "летящее" исключение
                System.err.println(". #2.CATCH"); // и работаем
            }
            System.err.println(". #2.out"); // работаем дальше
        }

        public static void g() {
            System.err.println(". . #3.in");
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(". . #3.out"); // ПРОПУСТИЛИ!
        }

        public static void h() {
            System.err.println(". . . #4.in");
            if (true) {
                System.err.println(". . . #4.THROW");
                throw new Error(); // выходим со всей пачки фреймов ('раскрутка стека') по 'throw'
            }
            System.err.println(". . . #4.out"); // ПРОПУСТИЛИ!
        }
    }

    private static class App05 {
        public static void main(String[] args) {
            System.err.println("#1.in");
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println("#1.out"); // вернулись и работаем
        }

        public static void f() {
            System.err.println(". #2.in");
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(". #2.out"); // вернулись и работаем
        }

        public static void g() {
            System.err.println(". . #3.in");
            try {
                h(); // создаем фрейм, помещаем в стек, передаем в него управление
            } catch (Error e) { // "перехватили" "летящее" исключение
                System.err.println(". . #3.CATCH"); // и работаем
            }
            System.err.println(". . #3.out"); // работаем дальше
        }

        public static void h() {
            System.err.println(". . . #4.in");
            if (true) {
                System.err.println(". . . #4.THROW");
                throw new Error(); // выходим со всей пачки фреймов ('раскрутка стека') по 'throw'
            }
            System.err.println(". . . #4.out"); // ПРОПУСТИЛИ!
        }
    }
}
