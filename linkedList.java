package 数据结构;

/**/
public class linkedList {
	public static void main(String args[]) {
		singelList list = new singelList();
		list.nextAdd(new HeroNode(10, "黄安崇", "Jim"));
		list.nextAdd(new HeroNode(7, "章节", "Jack"));
		list.nextAdd(new HeroNode(6, "节", "J"));
		list.reversePrint();
		System.out.print("完毕");
	}

}

//定义链表管理节点
class singelList {
	private HeroNode head = new HeroNode(0, "", "");

	// 当不考虑编号的顺序时找到当前链表最后的节点
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

	// 按照编码顺序添加
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
			System.out.println("链表为空");
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
				System.out.println("对象不存在");
			}
		}
	}

	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false; // 标识是否找到节点
		if (temp != null) {
			while (true) {
				if (temp.next == null) {
					break;
				}
				if (temp.next.no == no) {
					// 找到待删除节点的前一个节点
					temp.next = temp.next.next;
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag) {
				System.out.println("删除成功");
			} else {
				System.out.println("未找到节点");
			}
		} else {
			System.out.println("链表为空");
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
	 * 求链表倒数第index个节点 先取得链表的总长度 后取链表的第 size-index接单
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
	 * 单链表的反转 1.先定义一个反转头节点reverseHead = new HeroNode
	 * 2.从头到尾遍历原来的链表，每遍历一个节点就将其摘下，并放在新链表的尾端 3.原来的链表head.next = reverseHead;
	 */
	public void reverse() {
		if (head.next == null)
			System.out.print("链表为空");
		else {
			HeroNode temp = head.next;
			HeroNode reverseHead = new HeroNode(0, "", "");
			HeroNode next = null; // 指向当前节点的下一个节点
			while (temp != null) {
				next = temp.next;
				temp.next = reverseHead.next;
				reverseHead.next = temp;// 将下个节点指向新链表的前端
				temp = next;// 后移
			}
			head = reverseHead;
			System.out.print("反转成功");
		}
	}

	/*
	 * 逆序打印 利用栈
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

//定义一个对象，每个对象就是一个节点
class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	// 构造器
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
