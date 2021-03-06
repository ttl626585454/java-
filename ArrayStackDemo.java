package ���ݽṹ;

public class ArrayStackDemo {
	public static void main(String args) {
		
	}
}


class ArrayStack{
	private int maxsize;//ջ�Ĵ�С
	private int[] stack;//����ģ��ջ
	private int top = -1;//��ʾջ��
	
	public ArrayStack(int maxsize){
		this.maxsize = maxsize;
		stack = new int[this.maxsize];
	}
	public void pop() {
		if(isEmpty()) {
			return;
		}else {
			System.out.println(stack[top]);
			top--;
		}
		
	}
	public void push(int x) {
		if(isFull()) {
			return;
		}else {
			top++;
			stack[top] = x;
		}
	}
	public boolean isFull() {
		if(top>=maxsize-1) {
			return true;
		}
		else
			return false;
	}
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}else {
			return false;
		}
	}
	public void list() {
		for(int i = top;i>=0;i++) {
			System.out.printf(" %d",stack[i]);
		}
	}
	
	
}
