package 数据结构;
/*
 * 稀疏数组
 * 将一个11*11的棋盘转化为二维数组
 * 其中第3行4列有白子，第2行3列有黑子，其余位置皆无子
 * 原始数组转稀疏数组
 * 1遍历原始二维数组，得到有效个数
 * 2根据sum就可以创建稀疏数组sparseArr int [sum+1][3]
 * 3将二维数组的有效数据存入稀疏数组中
 * 稀疏数据转原始数组时
 * 1先读取稀疏数组第一行，根据第一行的数据创建原始二维数组，比如 chessArr2 = int [11][11]
 * 2读取稀疏数组后几行的数据，并赋值
 * */
public class sparsearray {
	public static void main(String args[]) {
		//创建一个11*11的棋盘
		//1表示黑子，2表示白子，0表示没有子
		int chessArr1[][] = new int [11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		//其余默认为0
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.print(" " + data);
			}
			System.out.print('\n');
		}
		System.out.print("____________________\n");
		//将二维数组转为稀疏数组
		
		int arraySum = 0,sum = 0 ,ArrRow=0,ArrColumn;
		for(int[] row :chessArr1) {
			ArrRow++;
			for(int data :row) {
				arraySum++;
				if(data!=0)
					sum++;
			}
		}
		ArrColumn = arraySum/ArrRow;//原数组列数
		int[][] chessArr2 = new int[sum+1][3];
		chessArr2[0][0] = ArrRow;
		chessArr2[0][1] = ArrColumn;
		chessArr2[0][2] = sum;
		int a = 1;//计数器
		//将原数组的数据存入稀疏数组中
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
		//遍历稀疏数组
		for(int[] row :chessArr2) {
			for(int data:row)
				System.out.print("\t"+data);
			System.out.print('\n');
		}
		
	}
}
