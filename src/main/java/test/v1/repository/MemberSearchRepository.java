package test.v1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.v1.entity.MemberDocument;

import java.util.List;
import java.util.Optional;

/*
    - ElasticSearch를 상속받아 기본적인 CRUD 작업을 할 수 있다.
    - @Query 어노테이션으로 커스텀 쿼리 생성 가능
 */
@Repository
public interface MemberSearchRepository extends ElasticsearchRepository<MemberDocument, Long> {
    // ElasticSearch에서 ID로 데이터 조회
    Optional<MemberDocument> findById(Long id);

    // nickname을 포함하는 데이터 조회 (대소문자 구분 없음)
    List<MemberDocument> findByNicknameContainsIgnoreCase(String nickName);

    // nickname에 와일드카드를 사용한 복잡한 검색 쿼리 예시
    // 원래 의도한 바 : 만약 nickname이 "john"이라면, 이 쿼리는 "john", "johnny", "myjohn" 등과 같은 이름을 검색하게 됩니다.
//    @Query("{\"bool\": { \"must\": [ \n" +
//            "    {\"wildcard\": {\"nickname\": \"*#{#nickname}*\"}}]}}")
//    Page<MemberDocument> findByNicknameContainsIgnoreCase(String nickname, Pageable pageable);



}
