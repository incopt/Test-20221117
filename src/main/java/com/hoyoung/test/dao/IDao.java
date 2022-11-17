package com.hoyoung.test.dao;

import java.util.ArrayList;

import com.hoyoung.test.dto.MemberDto;

public interface IDao {
	
	public void memberJoin(String mid,String mpw,String mname, String memail);
	public ArrayList<MemberDto> memberList();//모든 회원 리스트 가져 오기(무조건 모두 가져오기)
	public MemberDto searchIdOk(String mid);//하나를 가져올 목록이름(가져올 것)
	
}
