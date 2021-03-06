package 数据结构;

public class EightQueenProblem {
	//定义一个 max表示有多少个皇后
	int max = 8;
	//定义数组，表示皇后位置】
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
		//依次排放，并判断是否冲突
		for(int i = 0;i<max;i++) {
			array[n] = i;
			if(judge(n)) {
				check(n+1);
			}
		}
	}

	//当我们放置一个皇后时检测是否和已经方式的皇后冲突
	//n表示第n个皇后
	private boolean judge(int n) {
		//i代表皇后
		for(int i = 0;i<n;i++) {
			if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i]))//表示放置的皇后与之前的皇后在同一列
				return false;
		}
		return true;
	}
	
	
	
	//打印解决的方案
	private void print(int[] array) {
		for(int i = 0 ;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	
}
