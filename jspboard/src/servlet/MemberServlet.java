package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.print.attribute.PrintRequestAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import util.MemberDAO;
import vo.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String action = req.getParameter("action");
		MemberDAO dao = new MemberDAO();

		if (action == null) {
			resp.sendRedirect("index.jsp");
			return;
		}

		// action으로 분기처리 (로그인폼 가기)
		if (action.equals("login")) {
			resp.sendRedirect("jsp/login.jsp");
		}
		// join폼 가기
		else if (action.equals("join")) {
			resp.sendRedirect("jsp/join.jsp");
		}
		// 회원 가입
		else if (action.equals("joinmember")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String name = req.getParameter("name");
			String ph1 = req.getParameter("ph1");
			String ph2 = req.getParameter("ph2");
			String ph3 = req.getParameter("ph2");
			String address = req.getParameter("address");

			String phone = ph1 + ph2 + ph3;

			System.out.println(id);
			System.out.println(password);
			System.out.println(name);
			System.out.println(phone);
			System.out.println(address);

			Member member = new Member(id, password, name, phone, address);

			int result = dao.joinMember(member);
			System.out.println(result);

			PrintWriter out = resp.getWriter();
			String r = " <html><body><script>" + "alert('회원가입을 축하합니다.');" + "location.href = ('index.jsp');"
					+ "</script></body></html>";
			out.println(r);
		}

		else if (action.equals("memberLogin")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");

			System.out.println(id);
			System.out.println(password);

			Member member = new Member();
			member.setId(id);
			member.setPassword(password);

			Member m = dao.loginMember(member);

			if (m == null) {
				PrintWriter out = resp.getWriter();
				String result = " <html><body><script>" + "alert('id 또는 password가 안 맞습니다. ');"
						+ "location.href = ('jsp/login.jsp');" + "</script></body></html>";
				out.println(result);
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("member", m);
				resp.sendRedirect("index.jsp");
				// 브라우저한테 세션 보내주는 코드
			}

			// req.setAttribute("member", m);
			//
			// RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/board.jsp");
			// dispatcher.forward(req, resp);
		} 
		else if (action.equals("idcheck")) {
			String id = req.getParameter("id");
			
			System.out.println(id);

			Member m = dao.idCheck(id);

			HttpSession session = req.getSession();

			if (m != null) {
				session.setAttribute("message", "중복된 아이디가 있습니다.");
				session.setAttribute("state", "false");
				session.setAttribute("id", id);
			} else {
				session.setAttribute("message", "사용가능한 아이디입니다.");
				session.setAttribute("state", "true");
				session.setAttribute("id", id);
			}
			resp.sendRedirect("jsp/idcheck.jsp");

		}
		else if(action.equals("updateMember")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String name = req.getParameter("name");
			String ph1 = req.getParameter("ph1");
			String ph2 = req.getParameter("ph2");
			String ph3 = req.getParameter("ph3");
			String phone = ph1+ph2+ph3;
			String address = req.getParameter("address");
			
			Member member = new Member(id, password, name, phone, address);
			int result = dao.updateMember(member);
			System.out.println(result);
			
			HttpSession session = req.getSession();
			session.setAttribute("member", member);
			
			resp.sendRedirect("index.jsp");

		}else if(action.equals("removeMember")) {
			HttpSession session = req.getSession();
			session.removeAttribute("member");
			
			resp.sendRedirect("index.jsp");
		}
		
	}

}
