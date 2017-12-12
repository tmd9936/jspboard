package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.ReplyDAO;
import vo.Reply;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/jsp/reply")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(req,resp);
		String action = req.getParameter("action");
		ReplyDAO dao = new ReplyDAO();
		System.out.println(action);
		
		if(action.equals("delete"))
		{
			int replynum = Integer.parseInt(req.getParameter("replynum"));
			int boardnum = Integer.parseInt(req.getParameter("boardnum"));
			int r = dao.deleteReply(replynum);
			System.out.println("리플삭제");
			System.out.println(replynum);
			System.out.println(boardnum);
			System.out.println(r);
			
			resp.sendRedirect("board?action=read&num="+boardnum);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		ReplyDAO dao = new ReplyDAO();
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		String action = req.getParameter("action");
		
		//System.out.println(action);
		
		if(action.equals("replywrite")) {
			String retext = req.getParameter("retext");
			int boardnum = Integer.parseInt(req.getParameter("boardnum"));
			System.out.println(id);
			
			Reply reply = new Reply(boardnum, id, retext);
			int r = dao.insertReply(reply);
			System.out.println(r);
			
			resp.sendRedirect("board?action=read&num="+boardnum);
		}
		
		
	}

}
