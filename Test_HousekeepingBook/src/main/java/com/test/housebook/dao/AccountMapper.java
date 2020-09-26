package com.test.housebook.dao;

import com.test.housebook.vo.AccountVO;

public interface AccountMapper {

	public int accountJoin(AccountVO account);

	public AccountVO accountSelectOne(String acc_id);

}
