package ex02;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentUtils {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StudentUtils demo = new StudentUtils();
		//System.out.println(demo.inputIdStudent());
		System.out.println(demo.inputNameStudent());
	}

	private String inputIdStudent() {
		String id = "";
		String ID_PATTERN = "^[bkit].*[0-9]{3}";
		boolean check = false;
		do {
			System.out.println("Enter your id, example: bkit001");
			id = sc.nextLine();
			System.out.println("the id which you've entered " + id + " " + Pattern.matches(ID_PATTERN, id));
			check = Pattern.matches(ID_PATTERN, id);
		} while (!check);
		return id;
	}

	private String inputNameStudent() {
		
		//sai chưa được 6 ló tự vẫn đúng
		String name = "";
		//Tiếng việt có dấu, it nhất 6 kí tự, không được chứa kí tự số, kí tự đặc biệt.
		String NAME_PATTERN = "^[a-zA-ZàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ].*[^0-9]";
		boolean check = false;
		do {
			System.out.println("What's your name, Your name should be Vietnames at least 6 charaters");
			name = sc.nextLine();
			System.out.println("the name which you've entered " + name + " " + Pattern.matches(NAME_PATTERN, name));
			check = Pattern.matches(NAME_PATTERN, name);
		} while (!check);
		return name;
	}
	
 
}
