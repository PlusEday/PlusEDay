package org.eday.service;

import org.eday.domain.BoardVO;

public interface BoardService {
	public void register(BoardVO board);
	public BoardVO get(Long bno);
}
