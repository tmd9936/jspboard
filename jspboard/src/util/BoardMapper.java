package util;

import java.util.List;

import vo.Board;

public interface BoardMapper {
	//글쓰기
	public int insertBoard(Board b);
	//글 하나 읽기
	public Board getBoard(int boardnum);
	//글 목록 가져오기
	public List<Board> getBoardList();
	//글 수정
	public int updateBoard(Board b);
	//글 삭제
	public int deleteBoard(int boardnum);
	//조회수 증가
	public int addHits(int boardnum);
}
