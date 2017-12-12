package util;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Board;

public class BoardDAO implements BoardMapper {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Board b = new Board(1, "���̻�", "5��");
//		int re = dao.insertBoard(b);
//		System.out.println(re);
		
//		Board b = dao.getBoard(1);
//		System.out.println(b);
		
//		List<Board> list = dao.getBoardList();
//		System.out.println(list);
		
//		int s = dao.updateBoard(b);
//		System.out.println(s);
		
//		int gg = dao.deleteBoard(1);
//		System.out.println(gg);
		
		int c = dao.addHits(2);
		System.out.println(c);
		
	}
	
	SqlSessionFactory factory = MyBatisconfig.getSqlSessionFactory();
	@Override
	public int insertBoard(Board b) {
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertBoard(b);
			session.commit();
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Board getBoard(int boardnum) {
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		Board board = null;
		
		try {
			board = mapper.getBoard(boardnum);
			
		} finally {
			session.close();
		}
		
		return board;
	}
	

	@Override
	public List<Board> getBoardList() {
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		List<Board> list = null;
		
		try {
			list = mapper.getBoardList();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return list;
	}

	@Override
	public int updateBoard(Board b) {
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int result = 0;
		
		try {
			result = mapper.updateBoard(b);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return result;
	}

	@Override
	public int deleteBoard(int boardnum) {
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int result = 0;
		
		try {
			result = mapper.deleteBoard(boardnum);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return result;
	}

	@Override
	public int addHits(int boardnum) {
		
		int result = 0;
		try(SqlSession session = factory.openSession()){
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			result = mapper.addHits(boardnum);
			session.commit();
		}
		
		return result;
	}

	@Override
	public List<Board> getBoardListBounds(RowBounds rb) {
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		//rb�� ����Ŭ �⺻ ������Ÿ���̶� xml���� Ÿ�Ը�� �� ���൵ �� 
		List<Board> list = null;
		
		try {
			list = mapper.getBoardListBounds(rb);
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<Board> getBoardList(int cpage) {
		//�������� ������ ���� ����
		int pagecount = 5;
		//������ �������� cpage�� ����ִ�.
		
		//���� ������ �������� 2���
		//������ ���� ��ȣ�� 11 ~ 20�̴�.
		int offset = (cpage-1)*pagecount;
		//0���� �����ϴϱ� ������
		RowBounds rb = new RowBounds(offset, pagecount);
		
		List<Board> boardlist = this.getBoardListBounds(rb);
		System.out.println("������ ������ ����"+boardlist.size());
		
		return boardlist;
	}


	

}
