package ���ݽṹ;
/*
 * ϡ������
 * ��һ��11*11������ת��Ϊ��ά����
 * ���е�3��4���а��ӣ���2��3���к��ӣ�����λ�ý�����
 * ԭʼ����תϡ������
 * 1����ԭʼ��ά���飬�õ���Ч����
 * 2����sum�Ϳ��Դ���ϡ������sparseArr int [sum+1][3]
 * 3����ά�������Ч���ݴ���ϡ��������
 * ϡ������תԭʼ����ʱ
 * 1�ȶ�ȡϡ�������һ�У����ݵ�һ�е����ݴ���ԭʼ��ά���飬���� chessArr2 = int [11][11]
 * 2��ȡϡ��������е����ݣ�����ֵ
 * */
public class sparsearray {
	public static void main(String args[]) {
		//����һ��11*11������
		//1��ʾ���ӣ�2��ʾ���ӣ�0��ʾû����
		int chessArr1[][] = new int [11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		//����Ĭ��Ϊ0
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.print(" " + data);
			}
			System.out.print('\n');
		}
		System.out.print("____________________\n");
		//����ά����תΪϡ������
		
		int arraySum = 0,sum = 0 ,ArrRow=0,ArrColumn;
		for(int[] row :chessArr1) {
			ArrRow++;
			for(int data :row) {
				arraySum++;
				if(data!=0)
					sum++;
			}
		}
		ArrColumn = arraySum/ArrRow;//ԭ��������
		int[][] chessArr2 = new int[sum+1][3];
		chessArr2[0][0] = ArrRow;
		chessArr2[0][1] = ArrColumn;
		chessArr2[0][2] = sum;
		int a = 1;//������
		//��ԭ��������ݴ���ϡ��������
		for(int i = 0 ;i<ArrRow;i++) {
			for(int j = 0;j<ArrColumn;j++) {
				if(chessArr1[i][j]!=0) {
					chessArr2[a][0] = i+1;
					chessArr2[a][1] = j+1;
					chessArr2[a][2] = chessArr1[i][j];
					a++;
				}
			}
		}
		//����ϡ������
		for(int[] row :chessArr2) {
			for(int data:row)
				System.out.print("\t"+data);
			System.out.print('\n');
		}
		
	}
}
