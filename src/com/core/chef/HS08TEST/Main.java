/**
 * 
 */
package com.core.chef.HS08TEST;

import java.util.Scanner;

/**
 * @author Thync
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int txn = sc.nextInt();
		double balance =sc.nextDouble();
		if(txn%5!=0 || (double) txn+0.50 > balance){
			System.out.println(convertToDigitsOfPrecision(balance,2));
		} else{
			System.out.println(convertToDigitsOfPrecision(balance - txn - 0.50,2));
		}
			
	}
	
	public static String convertToDigitsOfPrecision(double val, int precisonUpto){
//		int dec = (int) Math.pow(10, precisonUpto);
//		int val_woDec = (int) val;
//		int val_or = (val_woDec)*dec;
//		int val_new = (int) (val*dec);
//		int dec_digits = val_or - val_new;
//		return val_woDec +"."+dec_digits;
		int val_or = (int) val;
		String newVal = String.valueOf(val);
		int d = newVal.indexOf(".");
		String decVal = newVal.substring(d+1);
		if(decVal.length()==precisonUpto)
		{
			return val_or+"."+decVal;
		}else if(decVal.length()>precisonUpto){
			return val_or+"."+decVal.substring(0,precisonUpto);
		}else {
			while(decVal.length()<precisonUpto){
				decVal+="0";
			}
			return val_or+"."+decVal;
		}
	}

}
