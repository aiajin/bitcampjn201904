package member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean(name = "memberDao")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
	@Bean(name = "registService")
	public MemberRegisterService getMemberRegisterService() {
		return new MemberRegisterService();
	}

}
