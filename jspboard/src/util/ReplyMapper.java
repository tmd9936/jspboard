package util;

import java.util.List;

import vo.Reply;

public interface ReplyMapper {
	//���� �ֱ�
	public int insertReply(Reply reply);
	//���� ����
	public int deleteReply(int replynum);
	//���� ����Ʈ
	public List<Reply> listReply(int boardnum);
}
