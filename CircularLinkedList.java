package ���ݽṹ;
/*
 * ����������
 * Լɪ������
 * 
 * ����k����Χ��һ������ѡ��һ���˴�1��ʼ����Ψһ�ķ�����
 * ������m�����˳���������У����ʶ���˳���ǣ�
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
	//��ӽڵ�
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
	//��һ�������ݽ���Լɪ������
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
				System.out.println(temp.next);  //����
				temp.next = temp.next.next;
				temp = temp.next;
				if(temp==temp.next) {
					break;
				}
				
			}
			System.out.println(temp); //����
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