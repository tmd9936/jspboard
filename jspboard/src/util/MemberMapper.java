package util;

import vo.Member;

public interface MemberMapper {
	//회원가입
	public int joinMember(Member member);
	
	//로그인
	public Member loginMember(Member member);
	
	//정보 수정
	public int updateMember(Member member);
	
	//아이디 체크
	public Member idCheck(String id);
}
