package ���ݽṹ;

public class EightQueenProblem {
	//����һ�� max��ʾ�ж��ٸ��ʺ�
	int max = 8;
	//�������飬��ʾ�ʺ�λ�á�
	int[] array = new int[max];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightQueenProblem queen = new EightQueenProblem();
		queen.check(0);
		
	}
	private void check(int n) {
		if(n==max) {
			print(array);
			return;
		}
		//�����ŷţ����ж��Ƿ��ͻ
		for(int i = 0;i<max;i++) {
			array[n] = i;
			if(judge(n)) {
				check(n+1);
			}
		}
	}

	//�����Ƿ���һ���ʺ�ʱ����Ƿ���Ѿ���ʽ�Ļʺ��ͻ
	//n��ʾ��n���ʺ�
	private boolean judge(int n) {
		//i����ʺ�
		for(int i = 0;i<n;i++) {
			if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i]))//��ʾ���õĻʺ���֮ǰ�Ļʺ���ͬһ��
				return false;
		}
		return true;
	}
	
	
	
	//��ӡ����ķ���
	private void print(int[] array) {
		for(int i = 0 ;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	
}
