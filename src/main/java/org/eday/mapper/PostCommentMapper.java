package org.eday.mapper;

import java.util.List;

import org.eday.domain.CommentsVO;

public interface PostCommentMapper {
	public int insertComment(CommentsVO comment);
	public CommentsVO readComment(String comment_id);
	public int updateComment(CommentsVO comment);
	public int deleteComment(CommentsVO comment);
	public List<CommentsVO> readListComment(String post_id);
}
