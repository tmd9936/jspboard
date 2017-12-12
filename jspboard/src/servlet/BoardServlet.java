package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.BoardDAO;
import vo.Board;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/jsp/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardServlet() {

		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
		System.out.println("doget");

		BoardDAO dao = new BoardDAO();

		String action = req.getParameter("action");

		if (action == null) {
			resp.sendRedirect("../index.jsp");
			return;
		} else if (action.equals("read")) {
			int num = Integer.parseInt(req.getParameter("num"));
			Board b = dao.getBoard(num);
			int hit = dao.addHits(num);

			//System.out.println(hit);
			//System.out.println(b);
			System.out.println("읽기");

			req.setAttribute("board", b);

			RequestDispatcher dispatcher = req.getRequestDispatcher("readBoard.jsp");
			dispatcher.forward(req, resp);
		} else if (action.equals("boardlist")) {
			// 현재 페이지의 글 목록 가져오기
			String page = (String) req.getParameter("page");
			System.out.println("bordlist");
			int cpage = 0;
			if (page == null) {
				// 처음 페이지를 보여준다.
				cpage = 1;
			} else {
				// 입력한 페이지를 보여준다.
				cpage = Integer.parseInt(page);
				System.out.println("페이지보여주기기기기");
			}
			List<Board> boardlist = dao.getBoardList(cpage);
			req.setAttribute("boardlist", boardlist);
			req.setAttribute("cpage", cpage);
			System.out.println("cpage= "+cpage);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("boardList.jsp");
			dispatcher.forward(req, resp);
		}else if(action.equals("boardUpdate")) {
			int num = Integer.parseInt(req.getParameter("num"));
			System.out.println("보내짐");
			System.out.println(num);
			
			Board b = dao.getBoard(num);
			
			req.setAttribute("board", b);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("boardUpdate.jsp");
			dispatcher.forward(req, resp);
			
		}else if(action.equals("delete")) {
			int num = Integer.parseInt(req.getParameter("num"));
			System.out.println("삭제");
			
			int r = dao.deleteBoard(num);
			System.out.println(r);
			
			resp.sendRedirect("board?action=boardlist");
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String action = req.getParameter("action");
		BoardDAO dao = new BoardDAO();

		if (action == null) {
			resp.sendRedirect("../index.jsp");
			return;
		} else if (action.equals("write")) {
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			System.out.println(id);
			System.out.println(title);
			System.out.println(content);

			Board b = new Board(id, title, content);
			int result = dao.insertBoard(b);
			System.out.println(result);

			resp.sendRedirect("board?action=boardlist");
			return;
		}else if(action.equals("update")) {
			//String id = req.getParameter("id");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int boardnum = Integer.parseInt(req.getParameter("boardnum"));
			
			System.out.println("수정중");
			System.out.println(title);
			System.out.println(content);
			System.out.println("보드번호 : "+boardnum);
			
			Board b = new Board(boardnum, title, content);
			int r = dao.updateBoard(b);
			System.out.println(r);
			System.out.println("수정됨");
			
			resp.sendRedirect("board?action=boardlist");
			
//			RequestDispatcher dispatcher = req.getRequestDispatcher("board?action=boardlist");
//			dispatcher.forward(req, resp);
			
		}

		// TODO Auto-generated method stub

	}

}
