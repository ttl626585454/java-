package ���ݽṹ;

/**/
public class linkedList {
	public static void main(String args[]) {
		singelList list = new singelList();
		list.nextAdd(new HeroNode(10, "�ư���", "Jim"));
		list.nextAdd(new HeroNode(7, "�½�", "Jack"));
		list.nextAdd(new HeroNode(6, "��", "J"));
		list.reversePrint();
		System.out.print("���");
	}

}

//�����������ڵ�
class singelList {
	private HeroNode head = new HeroNode(0, "", "");

	// �������Ǳ�ŵ�˳��ʱ�ҵ���ǰ�������Ľڵ�
	public void nextAdd(HeroNode heroNode) {
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	// ���ձ���˳�����
	public void noAdd(HeroNode heroNode) {
		HeroNode temp1 = head;
		while (true) {
			if (temp1.next == null || temp1.next.no > heroNode.no)
				break;
			temp1 = temp1.next;

		}
		if (temp1.next == null) {
			temp1.next = heroNode;
		} else {
			heroNode.next = temp1.next;
			temp1.next = heroNode;
		}

	}

	public void printList() {
		HeroNode temp = head.next;
		while (true) {
			if (temp == null)
				break;
			System.out.println(temp);
			temp = temp.next;
		}
	}

	public void update(HeroNode newHeroNode) {
		if (head.next == null)
			System.out.println("����Ϊ��");
		else {
			boolean flag = false;
			HeroNode temp = head.next;
			while (temp != null) {
				if (temp.no == newHeroNode.no) {
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag) {
				temp.name = newHeroNode.name;
				temp.nickName = newHeroNode.nickName;
			} else {
				System.out.println("���󲻴���");
			}
		}
	}

	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false; // ��ʶ�Ƿ��ҵ��ڵ�
		if (temp != null) {
			while (true) {
				if (temp.next == null) {
					break;
				}
				if (temp.next.no == no) {
					// �ҵ���ɾ���ڵ��ǰһ���ڵ�
					temp.next = temp.next.next;
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("δ�ҵ��ڵ�");
			}
		} else {
			System.out.println("����Ϊ��");
		}
	}

	public int getLength() {
		HeroNode temp = head.next;
		int count = 0;
		while (true) {
			if (temp == null) {
				break;
			}
			temp = temp.next;
			count++;
		}
		return count;
	}

	/*
	 * ����������index���ڵ� ��ȡ��������ܳ��� ��ȡ����ĵ� size-index�ӵ�
	 * 
	 */
	public HeroNode getlast(int index) {
		HeroNode temp = head.next;
		if (index <= 0 || index > getLength())
			return null;
		else {
			for (int i = 1; i <= getLength() - index; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	/*
	 * ������ķ�ת 1.�ȶ���һ����תͷ�ڵ�reverseHead = new HeroNode
	 * 2.��ͷ��β����ԭ��������ÿ����һ���ڵ�ͽ���ժ�£��������������β�� 3.ԭ��������head.next = reverseHead;
	 */
	public void reverse() {
		if (head.next == null)
			System.out.print("����Ϊ��");
		else {
			HeroNode temp = head.next;
			HeroNode reverseHead = new HeroNode(0, "", "");
			HeroNode next = null; // ָ��ǰ�ڵ����һ���ڵ�
			while (temp != null) {
				next = temp.next;
				temp.next = reverseHead.next;
				reverseHead.next = temp;// ���¸��ڵ�ָ���������ǰ��
				temp = next;// ����
			}
			head = reverseHead;
			System.out.print("��ת�ɹ�");
		}
	}

	/*
	 * �����ӡ ����ջ
	 */
	public void reversePrint() {
		singelStack stack = new singelStack();
		HeroNode t = head;
		while (t != null) {
			stack.push(t);
			t = t.next;

		}
		t = head;
		while (t != null) {
			System.out.println(stack.pop());
			t = t.next;
		}

	}

}

class singelStack {
	HeroNode bottom = new HeroNode(0, "", "");

	public void push(HeroNode heroNode) {
		HeroNode temp = bottom;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	public HeroNode pop() {
		HeroNode temp = bottom;
		if (temp.next != null) {
			while (temp.next.next.next != null) {

				temp = temp.next;
			}
			HeroNode h = temp.next;
			temp.next = null;
			return h;
		} else {
			return null;
		}

	}

}

//����һ������ÿ���������һ���ڵ�
class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	// ������
	public HeroNode(int herono, String heroname, String heronickname) {
		this.name = heroname;
		this.no = herono;
		this.nickName = heronickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

}
