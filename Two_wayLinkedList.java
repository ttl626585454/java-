package ���ݽṹ;
/*
 * ˫������
 * 
 * */
public class Two_wayLinkedList {
	public static void main(String args[]) {
		
		
		
	}
}
class DoubleLinkedList{
	//��ʼ��
	private HeroNode2 head = new HeroNode2(0,"","");
	
	//����ͷ�ڵ�
	public HeroNode2 getHead() {
		return head;
	}
	
	//����˫������
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
				//��������һ���ڵ�����Ҫִ�д���䣬������ֿ�ָ���쳣
				if(temp.next!=null)
					temp.next.pre = temp.pre;
			}else {
				System.out.println("δ�ҵ��ڵ�");
			}
			
		}else {
			System.out.println("����Ϊ��");
		}	
	}
	
	
	
	
}




class HeroNode2 {
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;
	public HeroNode2 pre;

	// ������
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









