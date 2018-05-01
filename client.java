import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {
	
	public static void main(String[] args) {
		 
ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
		User user = context.getBean("userProxy",User.class);
		user.showUser("R&D", 3);

	}

}
                                        