package 数据结构;
/*
 * 双向链表
 * 
 * */
public class Two_wayLinkedList {
	public static void main(String args[]) {
		
		
		
	}
}
class DoubleLinkedList{
	//初始化
	private HeroNode2 head = new HeroNode2(0,"","");
	
	//返回头节点
	public HeroNode2 getHead() {
		return head;
	}
	
	//遍历双向链表
	public void list() {
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null)
				break;
			System.out.println(temp);
			temp = temp.next;
		}
	}
	public void add (HeroNode2 heroNode2) {
		HeroNode2 temp = head;
		while(true) {
			if(temp.next==null)
				break;
			temp = temp.next;
		}
		temp.next = heroNode2;
		heroNode2.pre = temp;
	}
	public void delete(int no) {
		if(head.next!=null) {
			HeroNode2 temp = head.next;
			boolean f = false;
			while(temp!=null) {
				if(temp.no==no) {
					f = true;
					break;
				}
				temp = temp.next;
			}
			if(f) {
				temp.pre.next = temp.next;
				//如果是最后一个节点则不需要执行次语句，否则出现空指针异常
				if(temp.next!=null)
					temp.next.pre = temp.pre;
			}else {
				System.out.println("未找到节点");
			}
			
		}else {
			System.out.println("链表为空");
		}	
	}
	
	
	
	
}




class HeroNode2 {
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;
	public HeroNode2 pre;

	// 构造器
	public HeroNode2(int herono, String heroname, String heronickname) {
		this.name = heroname;
		this.no = herono;
		this.nickName = heronickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

}









