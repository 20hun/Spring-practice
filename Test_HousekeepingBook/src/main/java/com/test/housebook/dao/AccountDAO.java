package com.test.housebook.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.housebook.vo.AccountVO;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession session;

	public int accountJoin(AccountVO account) {
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		int cnt = 0;
		
		try {
			cnt = mapper.accountJoin(account);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	public AccountVO accountSelectOne(String acc_id) {
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		AccountVO account = null;
		
		try {
			account = mapper.accountSelectOne(acc_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return account;
	}

}
