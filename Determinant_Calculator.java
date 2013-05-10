import java.util.*;

public class Determinant_Calculator {

  public static void main(String[] args)
	{
		double[][] matrix = entry();
		
		System.out.println((Determinant(matrix)));
	}
	
	public static double[][] entry()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Size:");
		int size = scan.nextInt();
		
		double[][] matrix = new double[size][size];
		for (int i=0;i<size;i++)
		{
			for (int j=0;j<size;j++)
			{
				System.out.println("Please input for row "+i+" and column "+j);
				matrix[i][j]=scan.nextDouble();
			}
		}
		
		return matrix;
	}
	
	public static void display(double matrix[][])
	{
		for (int i=0;i<matrix.length;i++)
		{
			for (int j=0;j<matrix.length;j++)
			{
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static double Determinant(double[][] matrix)
	{
		int count=0;
		double sum=0;
		if (matrix.length>1)
		{
		for (int i=0;i<matrix.length;i++)
		{
			double[] a=new double[(matrix.length-1)*(matrix.length-1)]; // one dimensional array
			double[][] b = new double[matrix.length-1][matrix.length-1]; // two dimensional array
			
			count=0;
			
			for (int j=0;j<matrix.length;j++) // Put the whole thing into a one dimensional array
				{

					for (int k=1;k<matrix.length;k++)
					{
						if (i!=j) // Insert everything into one dimensional array
						{
							a[count]=matrix[j][k];
							count++; 
						}
					}
				}
			
			count=0; // reset counter
			
			for (int j=0;j<matrix.length-1;j++) // insert the one-D array into a 2D array
			{
				for (int k=0;k<matrix.length-1;k++)
				{
					b[j][k]=a[count]; 
					count++;
				}
			}
			sum+=Determinant(b)*matrix[i][0]*Math.pow(-1, i);
		}
		}
		else
			sum=matrix[0][0];
		

		return sum;
	}
}
