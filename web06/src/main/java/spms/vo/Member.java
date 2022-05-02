package spms.vo;

import java.util.Date;

public class Member {
	protected int no;
	protected String name;
	protected String email;
	protected String password;
	protected Date createdDate;
	protected Date modifiedDate;

	// setter 메서드의 리턴값이 void가 아닌 Member인 이유는 셋터 메서드를 연속적으로 호출하기 위함이다.
	// ex) new Member().setNo(1).setName("홍길동").setMail("hong@test.com");
	// new Member()는 인스턴스를 생성하고 나서 그 주소를 리턴한다.
	// 셋터 메서드를 계속 호출해 나가더라도 결국 반환되는 값은 처음 new Member()가 반환한 인스턴스다.	
	
	public int getNo() {
		return no;
	}

	public Member setNo(int no) {
		this.no = no;
		return this;
	}

	public String getName() {
		return name;
	}

	public Member setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Member setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Member setPassword(String password) {
		this.password = password;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Member setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public Member setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}
}
