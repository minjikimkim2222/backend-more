package test.v1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.v1.entity.Member;
import test.v1.entity.MemberDto;
import test.v1.service.MemberSearchService;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberSearchController {
    private final MemberSearchService memberSearchService;

    // 특정 Member를 ElasticSearch에 저장
    @PostMapping("/save")
    public ResponseEntity<String> saveMember(@RequestBody Member member){
        memberSearchService.save(member);
        return ResponseEntity.ok("Member saved to Elasticsearch");
    }

    // 여러 Members를 ElasticSearch에 저장
    @PostMapping("/saveAll")
    public ResponseEntity<String> saveAllMembers(@RequestBody List<Member> members){
        memberSearchService.saveAll(members);
        return ResponseEntity.ok("All members saved to ElasticSearch");
    }

    // ElasticSearch에서 nickname 기준으로 Member 조회
    @GetMapping("/search")
    public ResponseEntity<List<MemberDto>> searchMembers(@RequestParam String nickname){
        List<MemberDto> memberDtos = memberSearchService.searchAddableMembers(nickname);
        return ResponseEntity.ok(memberDtos);
    }
}
