package dat3.cars.service;

import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Member;
import dat3.cars.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class MemberServiceMockWithH2Test {

    public  MemberService memberService;

    public  static MemberRepository memberRepository;

    @BeforeAll
    public static void setupData(@Autowired MemberRepository member_Repository) {
        memberRepository = member_Repository;
        List<Member> members = List.of(
                new Member("m1", "pw", "m1@a.dk", "aa", "aaa", "aaaa", "aaaa", "1234"),
                new Member("m2", "pw", "mm@a.dk", "bb", "bbb", "bbbb", "bbbb", "1234")
        );
        memberRepository.saveAll(members);
    }
    /*
    @Test
    void addMember() {
        Member m = new Member("m3", "pw", "m3@a.dk", "cc", "ccc", "bbbb", "bbbb", "1234");
        MemberRequest request = new MemberRequest(m);
        memberService.addMember(request);
        assertEquals(3,memberRepository.count());
    }
*/

    @Test
    void editMember() {
    }
/*
    @Test
    void getMembers() {
        List<MemberResponse> response = memberService.getMembers();
        assertEquals(2,response.size());
        assertThat(response, containsInAnyOrder(hasProperty("email", is("m1@a.dk")), hasProperty("email", is("mm@a.dk"))));
    }
*/

    /*
    @Test
    void findMemberByUsername() throws Exception {
        MemberResponse response = memberService.findMemberByUsername("m1");
        assertEquals("m1@a.dk",response.getEmail());
    }
*/
    /*
    @Test
    void findMemberByNotExistingUsername() throws Exception {
        ResponseStatusException ex = Assertions.assertThrows(ResponseStatusException.class,()-> memberService.findMemberByUsername("i-dont-exist"));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatus());
    }
*/
    @Test
    void setRankingForUser() {
    }

    @Test
    void deleteByUsername() {
    }
}