package exceptions;

public class App_09 {

    private static class App01 {
        // (неограниченное вложение)
        public static void main(String[] args) {
            try {
                try {
                    try {

                    } catch (Exception e) {
                    } finally {
                    }
                } catch (Exception e) {
                } finally {
                }
            } catch (Exception e) {
            } finally {
            }
        }
    }

    private static class App02 {
        public static void main(String[] args) {
            try {
                try {
                    try {

                    } catch (Exception e) {
                    } finally {
                    }
                } catch (Exception e) {
                } finally {
                }
            } catch (Exception e) {
            } finally {
            }
            try {

            } catch (Exception e) {
            } finally {
            }
        }
    }

    private static class App03 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                try {
                    System.err.print(" 1");
                    // nothing
                    System.err.print(" 2");
                } catch (RuntimeException e) {
                    System.err.print(" 3"); // Не заходим - нет исключения
                } finally {
                    System.err.print(" 4"); // заходим всегда
                }
                System.err.print(" 5");     // заходим - выполнения в норме
            } catch (Exception e) {
                System.err.print(" 6");     // Не заходим - нет исключения
            } finally {
                System.err.print(" 7");     // заходим всегда
            }
            System.err.print(" 8");         // заходим - выполнения в норме
        }
    }

    private static class App04 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                try {
                    System.err.print(" 1");
                    if (true) {throw new RuntimeException();}
                    System.err.print(" 2");
                } catch (RuntimeException e) {
                    System.err.print(" 3"); // Заходим - есть исключения
                } finally {
                    System.err.print(" 4"); // заходим всегда
                }
                System.err.print(" 5");     // заходим - выполнения УЖЕ в норме
            } catch (Exception e) {
                System.err.print(" 6");     // Не заходим - нет исключенияб, УЖУ пкерехвачено
            } finally {
                System.err.print(" 7");     // заходим всегда
            }
            System.err.print(" 8");         // заходим - выполнения в УЖЕ норме
        }
    }

    private static class App05 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                try {
                    System.err.print(" 1");
                    if (true) {throw new Exception();}
                    System.err.print(" 2");
                } catch (RuntimeException e) {
                    System.err.print(" 3"); // Не заходим - есть исключения, но НЕПОДХОДЯЩЕГО ТИПА
                } finally {
                    System.err.print(" 4"); // заходим всегда
                }
                System.err.print(" 5");     // не заходим - выполнения не в норме
            } catch (Exception e) {
                System.err.print(" 6");     // Заходим - есть подходящее исключения
            } finally {
                System.err.print(" 7");     // заходим всегда
            }
            System.err.print(" 8");         // заходим - выполнения в норме
        }
    }

    private static class App06 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                try {
                    System.err.print(" 1");
                    if (true) {throw new Error();}
                    System.err.print(" 2");
                } catch (RuntimeException e) {
                    System.err.print(" 3"); // Не заходим - есть исключения, но НЕПОДХОДЯЩЕГО ТИПА
                } finally {
                    System.err.print(" 4"); // заходим всегда
                }
                System.err.print(" 5");     // не заходим - выполнения не в норме
            } catch (Exception e) {
                System.err.print(" 6");     // Не заходим - есть исключения, но НЕПОДХОДЯЩЕГО ТИПА
            } finally {
                System.err.print(" 7");     // заходим всегда
            }
            System.err.print(" 8");         // не заходим - выполнения не в норме
        }
    }
}
