package deque;

import edu.princeton.cs.algs4.Interval2D;

import java.util.Iterator;

//需求：add和remove不能使用循环和递归，运行必须在恒等的时间；
//get必须使用迭代
//迭代整个链表需要的时间必须和链表item的数量成正比
public class LinkListDeque<T>implements Deque<T>{
    public IntNode sentinel;
    public static int size;
    public LinkListDeque(T item){
        IntNode sentinel=new IntNode(item);
        size=0;
    }
    public class IntNode{
        public T item;
        public IntNode prev;
        public IntNode next;
        public IntNode(T x){
            this.item=x;
        }
    }

    public void addFirst(T item){
        IntNode add=new IntNode(item);
        sentinel.next.prev=add;
        add.next=sentinel.next;
        sentinel.next=add;
        add.prev=sentinel;
        size+=1;
    }
    public void addLast(T item){
        IntNode add=new IntNode(item);
        add.prev=sentinel.next.next;
        sentinel.next.next=add;
        add.next=sentinel;
        sentinel.prev=add;
        size+=1;
    }
    public boolean isEmpty(){
        if(sentinel.next==sentinel){
            return false;
        }
        return true;
    }
    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode l;
        l=sentinel.next;
        for(int i=0;i<size;i++){
            System.out.print(l.item);
            System.out.print(' ');
        }
        System.out.println();
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        IntNode p=sentinel.next;
        sentinel.next.next.prev=sentinel;
        sentinel.next.next=sentinel.next;
        size-=1;
        return p.item;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        IntNode p=sentinel.prev;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size-=1;
        return p.item;
    }
    public T get(int index){
        if(index>size|isEmpty()){
            return null;
        }
        IntNode p=sentinel.next;
        for(int i=0;i<size;i++){
            if(i==index){
                return p.item;
            }
            p=p.next;
        }
        return null;
    }
    public T getRecursive(int index){
        if(index==0){
            return null;
        }
        return help(index,this.sentinel.next);
    }
    public T help(int index,IntNode p){
        if(index==0){
            return p.item;
        }
        return help(index-1,p.next);
    }

    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null){
            return false;
        }
        if(!(o instanceof Deque)){
            return false;
        }
        Deque<T> o1=(Deque<T>) o;
        for(int i=0;i<size;i++){
            if(!o1.get(i).equals(this.get(i))){
                return false;
            }
        }
        return true;
    }
}
