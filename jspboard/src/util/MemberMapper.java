package util;

import vo.Member;

public interface MemberMapper {
	//ȸ������
	public int joinMember(Member member);
	
	//�α���
	public Member loginMember(Member member);
	
	//���� ����
	public int updateMember(Member member);
	
	//���̵� üũ
	public Member idCheck(String id);
}
