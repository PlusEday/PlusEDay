package org.eday.service;

import java.util.List;

import org.eday.domain.CommentsVO;

public interface PostCommentService {
	public int writeComment(CommentsVO comment);
	public int modifyComment(CommentsVO comment);
	public CommentsVO getComment(String comment_id);
	public int removeComment(CommentsVO comment);
	public List<CommentsVO> getListComment(String post_id);
}
