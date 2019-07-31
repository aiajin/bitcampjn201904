package member;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForSpring3 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		MemberDao dao = ctx.getBean("memberDao", MemberDao.class);
		
		

	}

}
