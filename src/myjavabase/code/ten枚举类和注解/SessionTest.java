package myjavabase.code.ten枚举类和注解;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-21 21:07
 **/
public class SessionTest {
    public static void main(String[] args) {
        Session session=Session.SPRING;
        System.out.println(session);
        session.show();
    }
}

interface MyInterface{
    public void show();
}

enum Session implements MyInterface{
    SPRING("春天","春风又绿江南岸"){
        @Override
        public void show() {
            System.out.println("这是一个春天");
        }
    },
    SUMMER("夏天","映日荷花别样红"){
        @Override
        public void show() {
            System.out.println("这是一个夏天");
        }
    },
    AUTUMN("秋天","秋水共长天一色"){
        @Override
        public void show() {
            System.out.println("这是一个秋天");
        }
    },
    WINTER("冬天","窗含西岭千秋雪"){
        @Override
        public void show() {
            System.out.println("这是一个冬天");
        }
    };
    private final String session;
    private final String description;
    Session(String session, String description) {
        this.session = session;
        this.description = description;
    }
    // //情况一:所有的枚举类都共用相同的接口方法
    // @Override
    // public void show() {
    //     System.out.println("这是一个季节");
    // }
}