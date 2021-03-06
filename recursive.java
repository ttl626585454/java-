package 数据结构;
/*
 * 利用栈递归解决迷宫
 * */
public class recursive {
	public static void main (String args[]) {
		//先创建一个二维数组模拟迷宫
		int[][] map = new int[8][7];
		//使用1表示墙
		for(int i =0 ; i<7;i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for(int i = 0;i<8;i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[3][4] = 1;
		map[3][5] = 1;
		//输出地图
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<7;j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
		//使用递归回溯走出迷宫
		setWay(map,1,5);
		
		
		//输出小球探测并表示过的地图
		System.out.println("输出小球探测并表示过的地图");
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<7;j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
	}
	/*
	 * 
	 * 下->右->上->左
	 * 1表示墙，2表示走通路可以走，3表示已经走过
	 * */
	public static boolean setWay (int[][] map,int i,int j) {
		if(map[6][5]==2) {
			return true;
		}else {
			if(map[i][j]==0) {//没有走过此点
				map[i][j] = 2;
				if(setWay(map,i+1,j)) {
					return true;
				}else if(setWay(map,i,j+1)) {
					return true;
				}else if(setWay(map,i-1,j)) {
					return true;
				}else if(setWay(map,i,j-1)) {
					return true;
				}else {
					//该点是走不通的是死路
					map[i][j] = 3;
					return false;
				}	
			}else if (map[i][j]==1) {//此点是墙
				return false;
			}else if(map[i][j]==21) {//此点已经走过
				return false;
			}else {
				return false;
			}
				
			
		}
		
	}
}
