package ���ݽṹ;
/*
 * ʹ������ģ��ѭ������
 * ��������洢����Ϊmaxsize-1
 * */
public class Queue {
	private int maxSize;//��ʾ������������
	private int front;//ָ�����ͷ
	private int rear ; //ָ�����β
	private int[] arr;
	public Queue(int x) {
		maxSize = x;
		arr = new int [maxSize];
		front = 0;
		rear = 0;
	}
	public boolean isFull() {
		return (rear+1)%maxSize == front;
	}
	public boolean isEmpty() {
		return rear==front;         
	}
	public void addQueue(int n){
		if(isFull()) {
			System.out.println("������");
		}
		else {
			arr[rear]=n;
			rear = (rear+1)%maxSize;
		}
	}
	public int deQueue() {
		if(isEmpty()) {
			throw new RuntimeException("���п�");
		}
		else {
			int j =  arr[front];
			arr[front] = 0;//��Ϊ0����鿴����
			front = (front+1)%maxSize;
			return j;
		}
	}
	public void show() {
		//��������
		if(isEmpty()) {
			System.out.println("���п�");
		}
		else {
			for(int i :arr)
				System.out.print("\t"+i);
		}
	}
	
	
}
