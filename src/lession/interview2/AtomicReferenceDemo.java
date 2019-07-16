package lession.interview2;

import lombok.*;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 09:33
 **/
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class User{
    private String userName;
    private int age;
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3=new User("z3",21);
        User li4=new User("li4",25);
        AtomicReference<User> atomicReference=new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());//true	User(userName=li4, age=25)
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());//false	User(userName=li4, age=25)
    }

}
