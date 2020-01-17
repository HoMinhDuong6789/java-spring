link: https://fnote.net/notes/87a1ca?fbclid=IwAR1puOwXgZJgbrc3uaGaK6QgRNadlbVCjmHwkhhVs-pJfz69CnyjeIWghnw
pass: http://nhasachtinhoc.blogspot.com

part1: https://mshare.io/file/oXZnoNsK

part2: https://mshare.io/file/lSgW2qF



Erross: https://bugs.eclipse.org/bugs/show_bug.cgi?id=171412
 
mvn clean compile
mvn clean install


Lession 1 Đặc Điểm

	Ioc Containner: dừng để khởi tạo đối tượng từ class, cấu hình, quản lí, 
	và điều phối các đối tượng (bean) trong chương trình.
	
	Bean: là các đối tượng được khởi tạo từ class. Tồn tại trong khung làm việc của request,
	sesion, app context,... có 2 loại hay dùng:
		Singleton: 1 đối tượng duy nhất trong IoC. Mặc định hay dùng
		Prototype: 1 đối tượng mới được tạo khi sử dụng bean, ít dùng
	
	Dependency Injection (DI) gasn bean vào biến khi được sử dụng trong chương trình.
	Autowire hoặc Inject thông qua
		Constructor: Gán giá trị cho biến thông qua constructor
		Setter: Gán giá trị cho biến thông qua hàm setter
	
	Hỗ trợ nhiều các thư viện: JDBX template, AOP trasaction, Log,...
	
	
Lession 2: Spring Bean 
	
	Bean: là các đối tượng được khởi tạo từ class. Tồn tại trong khung làm việc của request,
	sesion, app context,... Có các loại:
		Singleton: 1 đối tượng duy nhất trong IoC. Mặc định, 		hay dùng
		Prototype: 1 dối tượng mới được tạo khi sử dụng bean. 		ít dung
		Request: tồn tại trong một HTTP request
		Sesion và Global Sesion: tồn tại trong một HTTP Sesion
	
	Dependency Injection (DI) gán bean vào biến khi được sử dụng trong chương trình. 
	Có hai cách gán bean
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
		XML Config: khỏi tjao thông qua beans namesoace, 
			dùng constructor hoặc thuộc tính với hàm set/get
		Java Config: khởi tạo một dối tượng thông qua từ khóa new và @Bean
		
	Dependency Injection   (gán bean vào biến)
		Dependency Injection (DI) gán bean vào biến khi được sử dụng trong chương trình. 
		Có hai cách	
			Autowire: tự động tìm bwan và gán khi dùng
			Inject thông qua gán bean trực tiếm cho biến
				
				XML Config: sử dụng constructor hoặc hàm set
				Java Config: tạo đối tượng dùng constructor/set
					
					<bean id="person" class="com.trungtamjava.model.Person"
						init-method="init" destroy-method="destroy" scope="singleton">
						<property name="name" value="Trung Tam Java"></property>
						<property name="age" value="13"></property>
					</bean>

					<bean id="order" class="com.trungtamjava.model.Order"
						init-method="init" destroy-method="destroy" scope="singleton">
						<property name="person" value="Spring"></property>
					</bean>
				
				@Bean
				public Oeder(){
					return new Order(person);
				}
	
			Autowire: tự động tìm các bean để gán cho biến khi sử dụng thông qua:
				byName: tự động tìm theo tên biến
				byType: tự động tìm theo loại dữ liệu của biến
				constructor: tự động tìm theo đối số constructor
				autodetect: tự động tìm theo constructor và loại biến. 			hay dùng
			
			
			XML Config
				<bean id="order" class="com.trungtamjava.Order" autowire="byName">
					<property name="name" value="Trung Tam Java"></property>
						<property name="age" value="13"></property>
				</bean>
			
			Java Config:
				@Autowired
				@Qualofoer("person") //để Spring biết biến đó là gì
				private Person person;
				
				
				
 		