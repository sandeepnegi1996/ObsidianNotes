

 class exceptionPropagation {
    public static void main(String[] args) {
        
        int a=1;
        int b=0;

        try {
            int i=computeDivision(a, b);
        } catch (ArithmeticException e) {
            //TODO: handle exception

            System.out.println(e.getMessage() +"  exception handled in main");
        }
    }

    public static int divideByZero(int a, int b) {
        return a/b;
    }


    public static int computeDivision(int a, int b) {
        int res=0;

        try{
            res=divideByZero(a, b);
        }
        catch( NumberFormatException e) {
            System.out.println("exception catched in compute division");
        }

        return res;
    }


}
