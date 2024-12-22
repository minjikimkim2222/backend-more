//package test.elasticsearch.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.stereotype.Service;
//import test.elasticsearch.entity.Member;
//import test.elasticsearch.entity.MemberDocument;
//import test.elasticsearch.entity.MemberDto;
//import test.elasticsearch.repository.MemberSearchRepository;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
////@Service
//@RequiredArgsConstructor
//public class MemberSearchService {
//    private final ElasticsearchOperations elasticsearchOperations;
//    private final MemberSearchRepository memberSearchRepository;
//
//    // MYSQL에서 가져온 Member 객체를, ElasticSearch에 저장
//    public void save(Member member){
//        elasticsearchOperations.save(MemberDocument.from(member));
//    }
//
//    // 여러개의 Member 객체를 ElasticSearch에 저장
//    public void saveAll(List<Member> members){
//        List<MemberDocument> documents = members.stream()
//                .map(MemberDocument::from)
//                .collect(Collectors.toList());
//
//        elasticsearchOperations.save(documents);
//    }
//
//    // 조회
//    public List<MemberDto> searchAddableMembers(String nickname){
//        return memberSearchRepository.findByNicknameContainsIgnoreCase(nickname).stream()
//                .map(MemberDto::of)
//                .collect(Collectors.toList());
//    }
//}
