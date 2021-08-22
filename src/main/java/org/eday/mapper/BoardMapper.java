package org.eday.mapper;

import org.eday.domain.BoardVO;

public interface BoardMapper {
	public void insert(BoardVO board);
	public BoardVO read(Long bno);
}
