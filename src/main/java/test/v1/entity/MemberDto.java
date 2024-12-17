package test.v1.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDto {
    private Long id;
    private String nickname;

    public static MemberDto of(MemberDocument memberDocument){
        return MemberDto.builder()
                .id(memberDocument.getId())
                .nickname(memberDocument.getNickname())
                .build();
    }
}
