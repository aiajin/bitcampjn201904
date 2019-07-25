package membermanager.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membermanager.member.dao.MemberDao;
import membermanager.member.model.RequestMemberInfor;

public class MemberRegService implements MemberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		
		String uId = request.getParameter("uId");
		String uPW = request.getParameter("uPW");
		String uName = request.getParameter("uName");
		
		RequestMemberInfor requestMemberInfor = new RequestMemberInfor(uId, uPW, uName, null);
		
		MemberDao dao = MemberDao.getInstance();
		
		Connection conn=null;
		
		int rCnt = 0 ;
		
		try {
			conn = jdbc.ConnectionProvider.getConnection();
			
			rCnt = dao.insertMember(conn, requestMemberInfor.toMemberInfo());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("rCnt", rCnt);
		
		return "/WEB-INF/view/member/memberReg.jsp";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
