package org.eday.service;

import org.eday.domain.CommentsVO;

public interface PostCommentService {
	public int writeComment(CommentsVO comment);
	public int modifyComment(CommentsVO comment);
	public CommentsVO getComment(String comment_id);
	public int removeComment(CommentsVO comment);
	
}
