package org.eday.service;

import org.eday.domain.PostVO;
import org.eday.domain.Post_likeVO;
import org.eday.mapper.PostMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class PostServiceImpl implements PostService {
	
	private PostMapper mapper;

	@Override
	public int insertPost(PostVO post) {
		
		log.info("InsertPost.......!!!" + post);
		
		return mapper.insertPost(post);
	}

	@Override
	public int postLike(Post_likeVO likeVO) {
		log.info("Like Post Service. . . . . ." + likeVO);
		
		// 좋아요 여부 체크
		String checkYN = mapper.selectCheckLikePost(likeVO);
		
		// 좋아요를 눌렀을 때 POSTLIKE 테이블에 값이 있고
		if(checkYN != null){
			if(likeVO.getLike_toggle().equals("y")) {
				log.info("좋아요 취소");
				// 좋아요가 눌려진 상태라면
				likeVO.setLike_toggle("n");
				return mapper.updatePostLike(likeVO);
			} else if(likeVO.getLike_toggle().equals("n")){
				log.info("다시 좋아요");
				// 좋아요가 취소된 상태라면
				likeVO.setLike_toggle("y");
				return mapper.updatePostLike(likeVO);
			}
		}
		log.info("좋아요 눌러");
		// 좋아요를 누른 전적이 없다면 데이터 추가
		return mapper.insertPostLike(likeVO);
	}

}
