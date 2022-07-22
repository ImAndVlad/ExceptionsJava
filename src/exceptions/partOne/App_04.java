package exceptions;

public class App_04 {

    private static class App01 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 1");
            } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
                System.err.print(" 2");
            }
            System.err.println(" 3");
        }
    }

    private static class App02 {
        public static void main(String[] args) {
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    RuntimeException re = (RuntimeException) e;
                    System.err.print("Это RuntimeException на самом деле!!!");
                } else {
                    System.err.print("В каком то смысле не RuntimeException???");
                }
            }
        }
    }

    private static class App03 {
        public static void main(String[] args) throws Exception {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new Exception();
                }
                System.err.print(" 1");
            } catch (RuntimeException e) {
                System.err.print(" 2");
            }
            System.err.print(" 3");
        }
    }

    private static class App04 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new Error();
                }
                System.err.print(" 1");
            } catch (RuntimeException e) {
                System.err.print(" 2");
            }
            System.err.print(" 3");
        }
    }

    private static class App05 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 1");
            } catch (RuntimeException e) {      // перехватили RuntimeException
                System.err.print(" 2");
                if (true) {
                    throw new Error();
                }                               // но бросили Error
            }
            System.err.print(" 3");             // пропускаем - уже летит Error
        }
    }

    private static class App06 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 1");
            } catch (RuntimeException e) {  // перехватили RuntimeException
                System.err.print(" 2");
                if (true) {
                    throw e;
                }                           // и бросили ВТОРОЙ раз ЕГО ЖЕ
            }
            System.err.print(" 3");         // пропускаем - опять летит RuntimeException
        }
    }

    private static class App07 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 1");
            } catch (RuntimeException e) {      // перехватили RuntimeException
                System.err.print(" 2");
                if (true) {
                    throw new Error();
                }  // но бросили новий Error
            } catch (Error e) { // хотя есть catch по Error 'ниже', но ми в него не попадаем
                System.err.print(" 3");
            }
            System.err.println(" 4");
        }
    }

    private static class App08 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 1");
            } catch (RuntimeException e) {      // перехватили RuntimeException
                System.err.print(" 2.1");
                try {
                    System.err.print(" 2.2");
                    if (true) {
                        throw new Error();
                    }                           // бросили новий Error
                    System.err.print(" 2.3");
                } catch (Throwable t) {         // перехватили Error
                    System.err.print(" 2.4");
                }
                System.err.println(" 2.5");
            } catch (Error e) {                 // хотя есть catch по Error 'ниже', но ми в него не попадаем
                System.err.print(" 3");
            }
            System.err.print(" 4");
        }
    }
}
