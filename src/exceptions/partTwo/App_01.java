package exceptions.partTwo;

import java.io.IOException;

public class App_One {

//    private static class App01 {
//        public static void main(String[] args) {
//            throw new Exception(); // Compilation error
//        }
//    }

//    private static class App02 {
//        public static void main(String[] args) throws IOException {
//            throw new Exception(); // Compilation error
//        }
//    }

    private static class App03 {
        public static void main(String[] args) throws Exception { // предупреждаем о  Exception
            throw new Exception(); // и кидаем Exception
        }
    }

    private static class App04 {
        public static void main(String[] args) throws Throwable { // предупреждаем о Throwable
            throw new Exception(); // а кидаем только Exception
        }
    }

    private static class App05 {
        public static void main(String[] args) throws Exception { // пугаем
            // но ничего не бросаем
        }
    }

//    private static class App06 {
//        public static void main(String[] args) {
//            f(); // Compilation error
//        }
//
//        public static void f() throws Exception {
//        }
//    }

    private static class App06 {
        // пугабт целым Throwable
        public static void main(String[] args) throws Throwable {
            f();
        }
        // хотя мы пугали всего-лишь Exception
        public static void f() throws Exception {
        }
    }


}
