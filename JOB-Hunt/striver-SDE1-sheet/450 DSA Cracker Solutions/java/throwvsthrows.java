 class throwvsthrows {


    static void fun() throws IllegalAccessException{
        System.out.println("inside fun");
        throw new IllegalAccessException("from fun");
    }
    public static void main(String[] args) {
        

    }    
}
