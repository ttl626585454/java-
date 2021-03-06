package 数据结构;
/*
 * 使用数组模拟循环队列
 * 数组的最大存储个数为maxsize-1
 * */
public class Queue {
	private int maxSize;//表示数组的最大容量
	private int front;//指向队列头
	private int rear ; //指向队列尾
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
			System.out.println("队列满");
		}
		else {
			arr[rear]=n;
			rear = (rear+1)%maxSize;
		}
	}
	public int deQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空");
		}
		else {
			int j =  arr[front];
			arr[front] = 0;//置为0方便查看队列
			front = (front+1)%maxSize;
			return j;
		}
	}
	public void show() {
		//遍历数组
		if(isEmpty()) {
			System.out.println("队列空");
		}
		else {
			for(int i :arr)
				System.out.print("\t"+i);
		}
	}
	
	
}
