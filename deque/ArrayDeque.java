package deque;

public class ArrayDeque <T>implements Deque<T>{
    public int size;
    public T[] ad;
    public int nextFirst;
    public int nextLast;
    public ArrayDeque(){
        ad=(T[]) new Object[8];
    }
    public void addFirst(T item){


        ad[nextFirst]=item;
        if(nextFirst==0){
            nextFirst= ad.length-1;
        }
        nextFirst-=1;
        size+=1;
    }
    public void addLast(T item){
        ad[nextLast]=item;
        if(nextLast==ad.length-1){
            nextLast=0;
        }
        nextLast+=1;
        size+=1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){

    }
    public T removeFirst(){
        T p;
        if(nextFirst==ad.length-1){
            p=ad[0];
            ad[0]=null;
        }
        else{
            p=ad[nextFirst+1];
            ad[nextFirst+1]=null;
        }
        nextFirst+=1;
        size-=1;
        return p;
    }
    public T removeLast(){
        T p;
        if(nextLast==0){
            p=ad[ad.length-1];
            ad[ad.length-1]=null;
        }
        else{
            p=ad[nextLast-1];
            ad[nextLast-1]=null;
        }
        nextLast-=1;
        size-=1;
        return p;
    }

    public T get(int index){
        return ad[index];
    }
}
