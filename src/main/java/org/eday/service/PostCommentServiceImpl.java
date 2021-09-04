package org.eday.service;

import java.util.List;

import org.eday.domain.CommentsVO;
import org.eday.mapper.PostCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class PostCommentServiceImpl implements PostCommentService {
	
	@Setter(onMethod_ = @Autowired)
	private PostCommentMapper mapper;

	@Override
	public int writeComment(CommentsVO comment) {
		log.info("write comment Service. . . . . .");
		return mapper.insertComment(comment);
	}

	@Override
	public int modifyComment(CommentsVO comment) {
		log.info("modify comment Service. . . . . .");
		return mapper.updateComment(comment);
	}

	@Override
	public CommentsVO getComment(String comment_id) {
		log.info("get comment Service. . . . . .");
		return mapper.readComment(comment_id);
	}

	@Override
	public int removeComment(CommentsVO comment) {
		log.info("remove comment Service. . . . . .");
		return mapper.deleteComment(comment);
	}

	@Override
	public List<CommentsVO> getListComment(String post_id) {
		log.info("get comment list Service. . . . . .");
		return mapper.readListComment(post_id);
	}

}
