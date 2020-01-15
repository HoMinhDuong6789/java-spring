link: https://fnote.net/notes/87a1ca?fbclid=IwAR1puOwXgZJgbrc3uaGaK6QgRNadlbVCjmHwkhhVs-pJfz69CnyjeIWghnw
pass: http://nhasachtinhoc.blogspot.com

part1: https://mshare.io/file/oXZnoNsK

part2: https://mshare.io/file/lSgW2qF



Erross: https://bugs.eclipse.org/bugs/show_bug.cgi?id=171412
 
mvn clean compile
mvn clean install


Lession 1 Đặc Điểm

	Ioc Containner: dừng để khởi tạo đối tượng từ class, cấu hình, quản lí, và điều phối các đối tượng (bean)
					trong chương trình.
	
	Bean: là các đối tượng được khởi tạo từ class. Tồn tại trong khung làm việc của request, sesion, app context,... có 2 loại hay dùng:
		Singleton: 1 đối tượng duy nhất trong IoC. Mặc định hay dùng
		Prototype: 1 đối tượng mới được tạo khi sử dụng bean, ít dùng
	
	Dependency Injection (DI) gasn bean vào biến khi được sử dụng trong chương trình. Autowire hoặc Inject thông qua
		Constructor: Gán giá trị cho biến thông qua constructor
		Setter: Gán giá trị cho biến thông qua hàm setter
	
	Hỗ trợ nhiều các thư viện: JDBX template, AOP trasaction, Log,...
	
	
Lession 2: Spring Bean 
	
	Bean: là các đối tượng được khởi tạo từ class. Tồn tại trong khung làm việc của request, sesion, app context,... Có các loại:
		Singleton: 1 đối tượng duy nhất trong IoC. Mặc định, 		hay dùng
		Prototype: 1 dối tượng mới được tạo khi sử dụng bean. 		ít dung
		Request: tồn tại trong một HTTP request
		Sesion và Global Sesion: tồn tại trong một HTTP Sesion
	
	Dependency Injection (DI) gán bean vào biến khi được sử dụng trong chương trình. Có hai cách gán bean
		Autowire:		cách hay được sử dụng, và Spring sẽ giúp chúng ta tìm các bean tương ứng với kiểu biến chúng ta sử dụng
			trong chương trình  và gán tự động cho chúng ta
		
		Inject:			cách này chúng ta phải dùng bằng tay, tức là chúng ta phải gán bean bằng tay cho các biến, đối tượng
			của chúng ta thông qua constructor, or access. Các này sử dụng trong cấu hình là chính
		Constructor: gán giá trị cho biến thông qua constructor
		Setter: gán giá trị cho biến thông quan hàm setter
		
	chu kì Bean
		init: gọi khi bắt đàu tạo bean
		Tạo thành công: bean được tạo thành công và quản lý bởi IoC
		Destroy: gọi khi hủy bean
		
	Tạo Bean 
		bản chất là tạo các đới tượng từ class
		XML Config: khỏi tjao thông qua beans namesoace, dùng constructor hoặc thuộc tính với hàm set/get
		Java Config: khởi tạo một dối tượng thông qua từ khóa new và @Bean
		
	Dependency Injection   (gán bean vào biến)
		Dependency Injection (DI) gán bean vào biến khi được sử dụng trong chương trình. Có hai cách	
			Autowire: tự động tìm bwan và gán khi dùng
			Inject thông qua gán bean trực tiếm cho biến
	
	10:10
	
		