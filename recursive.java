package ���ݽṹ;
/*
 * ����ջ�ݹ����Թ�
 * */
public class recursive {
	public static void main (String args[]) {
		//�ȴ���һ����ά����ģ���Թ�
		int[][] map = new int[8][7];
		//ʹ��1��ʾǽ
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
		//�����ͼ
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<7;j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
		//ʹ�õݹ�����߳��Թ�
		setWay(map,1,5);
		
		
		//���С��̽�Ⲣ��ʾ���ĵ�ͼ
		System.out.println("���С��̽�Ⲣ��ʾ���ĵ�ͼ");
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<7;j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
	}
	/*
	 * 
	 * ��->��->��->��
	 * 1��ʾǽ��2��ʾ��ͨ·�����ߣ�3��ʾ�Ѿ��߹�
	 * */
	public static boolean setWay (int[][] map,int i,int j) {
		if(map[6][5]==2) {
			return true;
		}else {
			if(map[i][j]==0) {//û���߹��˵�
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
					//�õ����߲�ͨ������·
					map[i][j] = 3;
					return false;
				}	
			}else if (map[i][j]==1) {//�˵���ǽ
				return false;
			}else if(map[i][j]==21) {//�˵��Ѿ��߹�
				return false;
			}else {
				return false;
			}
				
			
		}
		
	}
}
