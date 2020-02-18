package guiSystem;

import java.util.Scanner;

public class Knapsack {

	static String remarks = null;

	public static void Knapsack(int custNum[], int weight[], int value[]) {
		int totalweight = 0, totalcost = 0, capacity = 100;
		// SINGLE DIGIT
		for (int i = 0; i < custNum.length; i++) {
			totalweight = weight[i];
			totalcost = value[i];
			if (totalweight <= capacity) {
				remarks = "Accepted";
			} else {
				remarks = "Rejected";
			}
			System.out.println(custNum[i] + "\t" + totalweight + "\t" + totalcost + "\t" + remarks);
		}
		// 2 DIGITS COMBINATION
		for (int i = 1; i < custNum.length; i++) {
			for (int j = i + 1; j < custNum.length + 1; j++) {
				totalweight = weight[i - 1] + weight[j - 1];
				totalcost = value[i - 1] + value[j - 1];
				if (totalweight <= capacity) {
					remarks = "Accepted";
				} else {
					remarks = "Rejected";
				}
				System.out.println(i + "," + j + "\t" + totalweight + "\t" + totalcost + "\t" + remarks);
			}
		}
		// 3 DIGITS COMBINATION
		int num1 = 0, num2 = 1, num3 = 1, num4 = 1;
		for (int i = 0; i < custNum.length * 2; i++) {
			totalweight = weight[num1] + weight[num1 + num2] + weight[num1 + num2 + num3];
			totalcost = value[num1] + value[num1 + num2] + value[num1 + num2 + num3];
			if (totalweight <= capacity) {
				remarks = "Accepted";
			} else {
				remarks = "Rejected";
			}
			System.out.println(custNum[num1] + "," + custNum[num1 + num2] + "," + custNum[num1 + num2 + num3] + "\t"
					+ totalweight + "\t" + totalcost + "\t" + remarks);
			++num3;
			if (num1 + num2 + num3 == 5) {
				num2++;
				num3 = 1;
			}
			if (num1 + num2 == 4) {
				num1++;
				num2 = 1;
			}
		}
		num1 = 0;// REINITIALIZE
		num2 = 1;
		num3 = 1;
		// 4 DIGITS COMBINATION
		for (int i = 0; i < custNum.length; i++) {
			totalweight = weight[num1] + weight[num1 + num2] + weight[num1 + num2 + num3]
					+ weight[num1 + num2 + num3 + num4];
			totalcost = value[num1] + value[num1 + num2] + value[num1 + num2 + num3] + value[num1 + num2 + num3 + num4];
			if (totalweight <= capacity) {
				remarks = "Accepted";
			} else {
				remarks = "Rejected";
			}
			System.out.println(custNum[num1] + "," + custNum[num1 + num2] + "," + custNum[num1 + num2 + num3] + ","
					+ custNum[num1 + num2 + num3 + num4] + "\t" + totalweight + "\t" + totalcost + "\t" + remarks);
			++num4;
			if (num1 + num2 + num3 + num4 == 5) {
				num3++;
				num4 = 1;
			}
			if (num1 + num2 + num3 == 4) {
				num2++;
				num3 = 1;
			}
			if (num1 + num2 == 3) {
				num1++;
				num2 = 1;
			}

		}
		// 5 DIGITS COMBINATION
		for (int i = 0; i < 1; i++) {
			totalweight = weight[i] + weight[i + 1] + weight[i + 2] + weight[i + 3] + weight[i + 4];
			totalcost = value[i] + value[i + 1] + value[i + 2] + value[i + 3] + value[i + 4];
			if (totalweight <= capacity) {
				remarks = "Accepted";
			} else {
				remarks = "Rejected";
			}
			System.out.println(custNum[i] + "," + custNum[i + 1] + "," + custNum[i + 2] + "," + custNum[i + 3] + ","
					+ custNum[i + 4] + "\t" + totalweight + "\t" + totalcost + "\t" + remarks);
		}
	}

	public static void main(String[] args) {

		/*
		 * System.out.print("Enter weight threshold: "); knapsackcapacity =
		 * input.nextInt(); System.out.print("Enter number of objects: "); numObject =
		 * input.nextInt();
		 * 
		 * int weightObject[] = new int[numObject + 1]; int costObject[] = new
		 * int[numObject + 1];
		 * 
		 * System.out.println("Enter variables: "); for (int i = 0; i < numObject; i++)
		 * { customer[i] = input.next(); } for (int i = 0; i < numObject; i++) {
		 * System.out.print("Enter weight of object " + customer[i] + ": ");
		 * weightObject[i] = input.nextInt(); } for (int i = 0; i < numObject; i++) {
		 * System.out.print("Enter cost of object " + customer[i] + ": "); costObject[i]
		 * = input.nextInt(); }
		 * 
		 * possibleCombinations(customer, weightObject, costObject, knapsackcapacity,
		 * numObject); }
		 */
		int[] weight = { 10, 20, 30, 40, 50 };
		int[] value = { 50, 30, 40, 20, 10 };
		int[] custNum = { 1, 2, 3, 4, 5 };
		Knapsack(custNum, weight, value);

	}
}

