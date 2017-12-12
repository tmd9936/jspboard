package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Reply;

public class ReplyDAO implements ReplyMapper{
	public static void main(String[] args) {
		ReplyDAO dao = new ReplyDAO();
//		Reply reply = new Reply(50, "id", "¾Æ´Ôss");
//		int r = dao.insertReply(reply);
//		System.out.println(r);
		
//		int r2 = dao.deleteReply(1);
//		System.out.println(r2);
		
		List<Reply> list = dao.listReply(50);
		System.out.println(list);
		
	}
	
	SqlSessionFactory factory = MyBatisconfig.getSqlSessionFactory();
	@Override
	public int insertReply(Reply reply) {
		SqlSession session = factory.openSession();
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertReply(reply);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return result;
	}

	@Override
	public int deleteReply(int replynum) {
		SqlSession session = factory.openSession();
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		int result = 0;
		try {
			result = mapper.deleteReply(replynum);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return result;
	}

	@Override
	public List<Reply> listReply(int boardnum) {
		SqlSession session = factory.openSession();
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		List<Reply> list = null;
		
		try {
			list = mapper.listReply(boardnum);
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		
		return list;
	}

}
