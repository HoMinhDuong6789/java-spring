package ex01.functionprogramming;

import javax.print.DocFlavor.INPUT_STREAM;

public class Demo {
	public static void main(String[] args) {
		//System.out.println(process("Hello world"));
		
		//cach 2:
		//in ra chu hoa
		System.out.println(getStr("Hello Loda", new StringProcessor() {
			
			@Override
			public String process(String input) {
				// TODO Auto-generated method stub
				return input.toUpperCase();
			}
		}));
		
		// in ra chu thuong
		System.out.println(getStr("Hello Loda", new StringProcessor() {
			
			@Override
			public String process(String input) {
				// TODO Auto-generated method stub
				return input.toLowerCase();
			}
		}));
		
		/*
		 * day chinh la lap trinh huowng ham, muc dich cua no la chung ta dua hanh vi vao ham. ham hay noi cach khac la dua them cac dona code vao ham nhu mot parameter
		 *LAP TRINH HUONG HAM: la dua hanh vi vao ham
		 *tuy nhien co mot nhoc diem trong khi ap dung cach nay do la viet code rat dai, chi moi viec in ra man hinh cungx mat cua chusng ta 6-7 dong code
		 *
		 *---> Lambda Expressions ra doi
		 *Lamda Expression: la mot cach dinh nghia ngan goi khi omplement mot Functional Interface (Interface cho co mot function)
		 *CAU TRUC cua mot lamda nhu sau:
		 *	parameter -> expression body
		 *
		 *trong do : 
		 *	parameter: la nhung tham so dau vao cua ham (mot hoac nhieu)
		 *	expression body: la phan xu ly parameter, ban can tra ra dugn kieu du lieu da khai bao trong Functional Interface
		 *Neu code cua ban chi can 1 thao tac, thi khong can retrun giong vi du o tren. Com meu code yeu cau xu li, thi dang day du cua no nhuw sau:
		 *parameter -> {
		 *	expression body
		 *	[return] //
		 *}
		 * 
		 */
		
		System.out.println(getStr("Hello LoDA", input->{
			String temp =  input + " Đừng quên like fanpage nhé!!!";
		    return temp.toLowerCase();
		}));
		
		/*
		 * 
		 */
		
	}
	
	
	public static String process(String input) {
		return input.toUpperCase();
	}
	
	/*
	 *Tuy nhien ban thay cach lam nay khog FLEXIBLE, vi cac van chi co the xu li 
	 *cho chu thanh UPPERCASE, muon la gi do khac, nhu toLowerCase chang han, minh se phai viet lai mot function moi
	 *
	 *chung ta se giai quyet cach nau bang Anonymous function (ham anh danh)
	 *
	 */
	
	public static String getStr (String input, StringProcessor processor) {
		return processor.process(input);
	}
	
}

interface StringProcessor{
	public String process(String input);
}
