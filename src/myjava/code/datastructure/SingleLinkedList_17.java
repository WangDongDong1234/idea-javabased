package myjava.code.datastructure;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-18 17:36
 **/
public class SingleLinkedList_17 {
    public static void main(String[] args) {
           //先创建节点
           HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
           HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
           HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
           HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
           SingleLinkedList_17 singleLinkedList = new SingleLinkedList_17();
           //加入
           singleLinkedList.add(hero1);
           singleLinkedList.add(hero4);
           singleLinkedList.add(hero2);
           singleLinkedList.add(hero3);
           //显示一把
           singleLinkedList.list();
           //测试修改节点的代码
           HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
           singleLinkedList.update(newHeroNode);
           System.out.println("修改后的链表情况~~");
           singleLinkedList.list();
           //删除一个节点
           singleLinkedList.del(1);
           singleLinkedList.del(4);
           System.out.println("删除后的链表情况~~");
           singleLinkedList.list();

    }

    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head=new HeroNode(0,"","");

    //添加结点到单链表
    //思路。当不考虑编号顺序时
    //1.找到当前链表的最后结点
    //2.将最后这个结点的next指向新的结点
    public void add(HeroNode heroNode){
        //因为head结点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp=head;
        //遍历列表，找到最后
        while (true){
            if(temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp=temp.next;
        }
        //当退出while循环时，temp就指向链表的最后
        //将最后这个结点的next指向新结点
        temp.next=heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //（如果由这个排名，则添加失败，
    public void addByOrder(HeroNode heroNode){
        //因为是单链表，因为我们找的temp是位于添加位置结点的前一个结点，否则插入不了
        //因为头结点不能动，因此我们仍然通过一个辅助指针（变量）来找到添加的位置

        HeroNode temp=head;
        //flag 标志添加的编号是否存在，默认是false
        boolean flag=false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if(temp.next.no>heroNode.no){
                //位置找到，就在temp的后面插入，前面的no都小于要插入的no
                break;
            }else if(temp.next.no==heroNode.no){
                //说明希望添加的heroNode的编号已然存在
                //说明编号存在
                flag=true;
                break;
            }
            //后移，遍历当前链表
            temp=temp.next;
        }
        if(flag){
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

   //修改结点的信息，根据no编号来修改，即no编号不能改
   public void update(HeroNode newHeroNode){
        //判断是否为空
       if(head.next==null){
           System.out.println("链表为空");
           return;
       }
       //找到需要修改的结点，根据no编号
       //定义一个辅助变量
       HeroNode temp=head.next;
       //表示是否找到该节点
       boolean flag=false;
       while (true){
           if(temp==null){
               //已经遍历完链表
               break;
           }
           if(temp.no==newHeroNode.no){
               //找到
               flag=true;
               break;
           }
           temp=temp.next;
       }
       //根据flag判断是否找到要修改的节点
       if (flag) {
           temp.name=newHeroNode.name;
           temp.nickname=newHeroNode.nickname;
       }else{
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
       }
   }
   //删除
    //1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们在比较时，是temp.next.no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp=head;
        //标志是否找到带删除节点的
        boolean flag=false;
        while (true){
            //已经到链表的最后
             if(temp.next==null){
                 break;
             }
             if(temp.next.no==no){
                 //找打待删除节点的前一个节点temp
                 flag=true;
                 break;
             }
             //temp后移，遍历
             temp=temp.next;
             if(flag){
                 //找到可以删除
                 temp.next=temp.next.next;
             }else{
                  System.out.printf("要删除的 %d 节点不存在\n", no);
             }
        }
    }

    //显示链表[遍历]
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为是头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp=head.next;
        while(true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp=temp.next;
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}