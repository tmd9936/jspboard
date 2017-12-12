package util;

import java.util.List;

import vo.Reply;

public interface ReplyMapper {
	//리플 넣기
	public int insertReply(Reply reply);
	//리플 삭제
	public int deleteReply(int replynum);
	//리플 리스트
	public List<Reply> listReply(int boardnum);
}
