package com.study.core.controller;

import com.study.core.entity.Member;
import com.study.core.service.MemberService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity createMember(){
        memberService.addMember();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/members")
    public ResponseEntity getMember(){
        List<Member> t= memberService.findMember();
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }
}
