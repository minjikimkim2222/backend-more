package test.v1.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "members")
public class MemberDocument {
    @Id
    private Long id; // Elasticsearch에서 해당 필드를 도큐먼트 ID로 인식
    private String nickname;
    private String profileUrl;

    // MYSQL DB에서 가져온 Member 객체를 Elasticsearch를 저장할 수 있도록 변환!
    public static MemberDocument from(Member member){
        return MemberDocument.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .profileUrl(member.getProfilePath())
                .build();
    }
}
