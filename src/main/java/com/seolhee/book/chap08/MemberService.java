package com.seolhee.book.chap08;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.seolhee.book.chap03.Member;

/**
 * p.204 [리스트 8.13]를 Main과 Service로 분리한 Service 부분
 * 
 * @author Jacob
 */
public class MemberService {

	Logger logger = LogManager.getLogger();

	MemberDao memberDao = null;

	/**
	 * memberDao setter for injection
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void selectAll() {
		List<Member> members = memberDao.selectAll(0, 100);
		logger.debug(members);
	}

	public void updateMember() {
		Member member = memberDao.selectByEmail("sunha0822@naver.com");
		member.setPassword("b");
		memberDao.update(member);
		logger.debug("Update complete.");
	}

	public void insertMember() {
		Member member = new Member();
		member.setEmail("gs05074@naver.com");
		member.setPassword("027019");
		member.setName("배설희");
		memberDao.insert(member);
		logger.debug("Insert complete.");
	}
}