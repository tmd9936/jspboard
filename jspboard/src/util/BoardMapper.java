package util;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import vo.Board;

public interface BoardMapper {
	//�۾���
	public int insertBoard(Board b);
	//�� �ϳ� �б�
	public Board getBoard(int boardnum);
	//�� ��� ��������
	public List<Board> getBoardList();
	//�� ����
	public int updateBoard(Board b);
	//�� ����
	public int deleteBoard(int boardnum);
	//��ȸ�� ����
	public int addHits(int boardnum);
	//�� ��� �������� rowbound����
	public List<Board> getBoardListBounds(RowBounds rb);
	//�������� �� ��� ��������
	public List<Board> getBoardList(int cpage);
}
