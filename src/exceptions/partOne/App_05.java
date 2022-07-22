package exceptions;

public class App_05 {

//    private static class App01 {
//        // (Compilation error нельзя ставить потомка после предка)
//        public static void main(String[] args) {
//            try {
//            } catch (Exception e) {
//            } catch (RuntimeException e) {
//            }
//        }
//    }

    private static class App02 {
        // (ставить брата помле брата можно)
        public static void main(String[] args) {
            try {
            } catch (Error e) {
            } catch (RuntimeException e) {
            }
        }
    }

    private static class App03 {
        public static void main(String[] args) {
            try {
                throw new Exception();
            } catch (RuntimeException e) {
                System.err.println("catch RuntimeException");
            } catch (Exception e) {
                System.err.println("catch Exception"); // catch
            } catch (Throwable e) {
                System.err.println("catch Throwable");
            }
            System.err.println("next statement");
        }
    }

    private static class App04 {
        public static void main(String[] args) {
            try {
                Throwable t = new Exception(); // сылка типа Throwable указывает
                // на обьект типа Exception
                throw t;
            } catch (RuntimeException e) {
                System.err.println(" catch RuntimeException");
            } catch (Exception e) {
                System.err.println("catch Exception");
            } catch (Throwable e) {
                System.err.println("catch Throwable");
            }
            System.err.println("next statement");
        }
    }
}
