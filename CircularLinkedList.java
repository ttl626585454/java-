package 数据结构;
/*
 * 单向环形链表
 * 约瑟夫问题
 * 
 * 假设k个人围成一个环，选择一个人从1开始按照唯一的方向报数
 * 数到第m数的人出环进入队列，请问队列顺序是？
 * 
 * 
 * */
public class CircularLinkedList {
	public static void main(String args[]) {
		SingelCircularLinkedList List = new SingelCircularLinkedList();
		List.add(new Boy(1,"Jack"));
		List.add(new Boy(2,"Kack"));
		List.add(new Boy(3,"Lack"));
		List.add(new Boy(4,"Pack"));
		List.cycleDelete(3);
	}
}



class SingelCircularLinkedList {
	private Boy first = null;
	//添加节点
	public void add(Boy boy) {
		if(first==null) {
			first = boy;
			boy.next = first;
		}else {
			Boy temp = first;
			while(true) {
				if(temp.next==first)
					break;
				temp = temp.next;
			}
			temp.next = boy;
			boy.next = first;
		}
	}
	//以一定的数据进行约瑟夫环问题
	public boolean cycleDelete(int m) {
		if (first==null )
			return false;
		else{
			Boy temp = first;
			while(true)
			{
				
				for(int i = 1 ;i<m-1;i++) {
					temp = temp.next ;
				}
				System.out.println(temp.next);  //出环
				temp.next = temp.next.next;
				temp = temp.next;
				if(temp==temp.next) {
					break;
				}
				
			}
			System.out.println(temp); //出环
			first = null;
			return true;
		}
	}   
}


class Boy {
	private String name ;
	private int no;
	public Boy next;
	public Boy(int no ,String name){
		this.name = name;
		this.no = no;
	}
	@Override
	public String toString() {
		return "Boy [no="+ no +"name=" + name + "]";
	}
}