package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Member;

public class MemberDAO implements MemberMapper{
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		Member m = new Member("id", "1", "¹é½ÂÈ¯", "00000000", "11");
		
//		int r = dao.joinMember(m);
//		Member mm = dao.loginMember(m);
//		System.out.println(mm);
//		String s = "2";
//		
//		Member m2 = dao.idCheck("id");
//		System.out.println(m2);
		
		int t = dao.updateMember(m);
		System.out.println(t);
		
		
	}
	
	SqlSessionFactory factory = MyBatisconfig.getSqlSessionFactory();

	@Override
	public int joinMember(Member member) {
		SqlSession session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		int result = 0;
		try {
			result = mapper.joinMember(member);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return result;
	}

	@Override
	public Member loginMember(Member member) {
		SqlSession session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		Member m = null;
		
		try {
			m = mapper.loginMember(member);
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return m;
	}

	@Override
	public int updateMember(Member member) {
		SqlSession session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		int result = 0;
		
		try {
			result = mapper.updateMember(member);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return result;
	}

	@Override
	public Member idCheck(String id) {
		SqlSession session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		Member result = null;
		
		try {
			result = mapper.idCheck(id);
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		return result;
	}
	

}
