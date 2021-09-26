package singleton;

/**
 * @author shkstart
 * @create 2021-04-15 11:15
 */
public enum singleTom implements show {

    SINGLE_TOM("AA","BB"){
//        @Override
//        public void son() {
//            System.out.println("这是一个单例");
//        }
    };

     String name1;
     String name2;



    private singleTom(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    @Override
    public void son() {
        System.out.println("这是你爹");
    }

    public static singleTom getSingleTom() {
        return SINGLE_TOM;
    }


}
