package com.cov.bloom.mypage.model.service;

import com.cov.bloom.member.model.dao.MemberMapper;
import com.cov.bloom.member.model.dto.LoginMemberDTO;
import com.cov.bloom.member.model.dto.MemberDTO;
import com.cov.bloom.mypage.model.dao.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class MypageService {

    @Autowired
    private final MypageMapper mypageMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public MypageService(MypageMapper mypageMapper){
        this.mypageMapper=mypageMapper;
    }



    public LoginMemberDTO findByUsername(String email){
        LoginMemberDTO login = mypageMapper.findByUsername(email);

        System.out.println("aaa: " + passwordEncoder.encode(login.getPassword()));


        if(!Objects.isNull((login))){
            return login;

        }else{
            return null;
        }
    }



    @Transactional
    public int updateNickname(String memberName, String nickname) {
        int result = mypageMapper.updateNickname(memberName,nickname);

        return result;
    }

    @Transactional
    public int updatePhone(String memberName, String phone) {
        int result = mypageMapper.updatePhone(memberName,phone);
        return result;
    }
}